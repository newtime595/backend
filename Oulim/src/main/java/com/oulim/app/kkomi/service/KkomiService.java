package com.oulim.app.kkomi.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.oulim.app.common.util.DefineType;
import com.oulim.app.config.MyBatisConfig;
import com.oulim.app.kkomi.dao.KkomiDAO;
import com.oulim.app.kkomi.dto.KkomiDTO;
import com.oulim.app.kkomi.dto.RankingDTO;
import com.oulim.app.user.dao.UserDAO;
import com.oulim.app.user.dto.CurrencyDTO;
import com.oulim.app.user.dto.LogPointDTO;

public class KkomiService {

	// 레벨별 경험치를 저장할 맵
	private Map<Integer,Integer> kkomiLevExpMap = new HashMap<>();
	final int EXP_BASE = 2000;
	final int KKOMI_ID = 1; // 꼬미 ID설정
	final int MINIMAL_USE_POINT = 100;
	public KkomiService() {
		// 1 ~ 9까지 경험치 설정
		// 요구 경험치 변동은 각 레벨 단계당 
		for(int i = 1 ; i < 10; i++) {
			kkomiLevExpMap.put(i, (i - 1) * (int)Math.pow(2, (i - 1))*EXP_BASE);
		}
	}
	
	/**
	 * 꼬미 도력쌓기 메소드
	 * @param userNo
	 * @return 결과 메세지
	 */
	public int kkomiExpUp(int userNo) {
		// 트랜잭션 처리를 위한 SQL Session 선언
		SqlSession sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(false);
		
		KkomiDAO kkomiDAO = new KkomiDAO(sqlSession);
		UserDAO userDAO = new UserDAO(sqlSession);
		// 자신의 랭킹 정보 조회
		RankingDTO rankDTO = kkomiDAO.getMyRanking(userNo);
		// 자신의 꼬미 상태 조회
		KkomiDTO kkomiDTO = kkomiDAO.getOnlyKkomi(userNo);

		// 포인트 보유량을 가져오기 위한 Map과 DTO
		Map<String,Integer> pointMap = new HashMap<String,Integer>();
		pointMap.put("userNo", userNo);
		pointMap.put("currencyId", DefineType.POINT_ID);
		// 자신의 포인트(currencyId=1) 현황 조회
		CurrencyDTO pointDTO = userDAO.getSomeCurrencyInfo(pointMap);
		
		LogPointDTO logPointDTO = new LogPointDTO();
		
		// 포인트를 보유하지 않았거나, 최소 사용량도 만족하지 못할 경우, 포인트가 부족합니다 출력
		if(pointDTO == null || pointDTO.getTotalAmount() < MINIMAL_USE_POINT) {
			sqlSession.close();
			return DefineType.LACK_OF_CURRENCY;
		}
		
		// 기존 꼬미 데이터가 없다면 생성한다.
		if(kkomiDTO == null) {
			kkomiDTO = new KkomiDTO();
			kkomiDTO.setKkomiLev(1);
			kkomiDTO.setKkomiExp(0);
		}
		
		// 랭킹 데이터가 없었다면 생성한다.
		if(rankDTO == null) {
			rankDTO = new RankingDTO();
			rankDTO.setRankPoint(0);
			rankDTO.setUserNo(userNo);
		}
				
		// 현재 보유 포인트에서 100단위로 포인트를 사용할 경우 남을 양을 계산한다.
		int remainPoint = pointDTO.getTotalAmount() % MINIMAL_USE_POINT;
		// 사용할 포인트 양을 계산한다.
		int usePoint = pointDTO.getTotalAmount() - remainPoint;
		// 사용한 포인트는 1 : 1 로 경험치에 반영된다. (추후 비율 수정 가능)
		int getExp = usePoint;
		// 획득한 포인트는 랭킹 점수가 된다.
		int getRankPoint = getExp;
		// 랭크포인트 누적
		int rankPoint = rankDTO.getRankPoint() + getRankPoint;
		int calculatedExp = kkomiDTO.getKkomiExp() + getExp;
		// Insert Transaction
		try {
			// 경험치 변화량을 통해 최종 레벨을 계산한다.
			kkomiDTO.setUserNo(userNo);
			kkomiDTO.setKkomiNo(DefineType.KKOMI_ID);
			kkomiDTO.setKkomiExp(calculatedExp);
			kkomiDTO.setKkomiLev(calcLvToExp(calculatedExp));
			
			System.out.println(kkomiDTO.toString());
			if(!kkomiDAO.upsertKkomi(kkomiDTO)) {
				throw new RuntimeException("꼬미 정보 갱신 실패");
			}
			
			rankDTO.setRankPoint(rankPoint);
			System.out.println(rankDTO.toString());
			if(!kkomiDAO.upsertRanking(rankDTO)) {
				throw new RuntimeException("랭킹 갱신 실패");
			}
			
			pointDTO.setUserNo(userNo);
			pointDTO.setCurrencyID(DefineType.POINT_ID);
			pointDTO.setTotalAmount(remainPoint);
			System.out.println(pointDTO.toString());
			if(!userDAO.upsertCurrency(pointDTO))
			{
				throw new Exception("포인트 갱신 실패");
			}
			
			logPointDTO.setCurrencyId(DefineType.POINT_ID);
			logPointDTO.setChangeAmount(usePoint * (-1));
			logPointDTO.setLogReason("꼬미 도력쌓기");
			logPointDTO.setUserNo(userNo);
			
			System.out.println(logPointDTO.toString());
			userDAO.insertPointLog(logPointDTO);
			
			sqlSession.commit();
		}catch(Exception ex) {
			sqlSession.rollback();
			System.out.println(ex.getMessage());
			return DefineType.DB_PROBLEM;
		}
		finally {
			sqlSession.close();
		}
		
		return DefineType.SUCCESS;
	}
	
	public int getToRequireExpByLv(int lv) {
		return kkomiLevExpMap.entrySet().stream().filter(e -> e.getKey() != null && e.getKey() <= lv)
				.mapToInt(e -> e.getValue() == null ? 0 : e.getValue()).sum();
	}
	
	public int calcLvToExp(int exp) {
		int sum =0;
		int level = 1;
		for(int i = 2 ; i < kkomiLevExpMap.size() + 1; i++) {
			Integer needExp = kkomiLevExpMap.get(i);
			if(needExp == null)
				continue;
			
			if(exp >= sum + needExp) {
				sum += needExp;
				level = i;				
			}else {
				break;
			}
		}
		
		return level;
	}
}
