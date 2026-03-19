package com.oulim.app.kkomi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oulim.app.config.MyBatisConfig;
import com.oulim.app.kkomi.dto.KkomiDTO;
import com.oulim.app.kkomi.dto.KkomiJoinDTO;
import com.oulim.app.kkomi.dto.RankingDTO;
import com.oulim.app.kkomi.dto.RankingJoinDTO;

public class KkomiDAO {
	SqlSession sqlSession;
	
	public KkomiDAO(boolean isAuto) {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(isAuto);
	}
	
	public KkomiJoinDTO getKkomiInfo(int userNo) {
		System.out.println("꼬미 정보 조회 - getKkomiInfo");		
		return sqlSession.selectOne("kkomi.selectKkomiJoin",userNo);
	}
	
	public boolean upsertKkomi(KkomiDTO kkomi) {
		System.out.println("꼬미 도력 쌓기 수행 - upsertKkomi");
		int result = sqlSession.update("kkomi.upsertKkomi",kkomi);
		return result < 1 ? false : true;
	}
	
	public List<RankingJoinDTO> getRankingInfo(int userNo) {
		System.out.println("랭킹 상위권 및 내 랭킹 조회 - getRankingInfo");
		return sqlSession.selectList("kkomi.selectTopRanking", userNo);
	}
	
	public boolean upsertRanking(RankingDTO ranking) {
		System.out.println("랭킹 갱신 - upsertRanking");
		int result = sqlSession.update("kkomi.upsertRanking", ranking);
		return result < 1 ? false : true;
	}
}
