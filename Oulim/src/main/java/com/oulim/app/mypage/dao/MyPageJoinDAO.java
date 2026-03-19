package com.oulim.app.mypage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oulim.app.config.MyBatisConfig;
import com.oulim.app.mypage.dto.MyPageJoinDTO;

public class MyPageJoinDAO {
	
	public SqlSession sqlSession;

	public MyPageJoinDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	1. 마이페이지 진입
	
	public boolean enterMyPage(int userNo) {
		return (Integer)(sqlSession.selectOne("mypage.enterMyPage", userNo)) == 1;
	}
	
	
//	2. 내 정보 보기
	
	public MyPageJoinDTO userAllinfo(int userNo) {
		return sqlSession.selectOne("mypage.userAllInfo", userNo);
	}

	public MyPageJoinDTO organAdditionalinfo(int organNo) {
		return sqlSession.selectOne("mypage.organAdditionalInfo", organNo);
	}
	
	
	public MyPageJoinDTO summaryInfo(int userNo) {
		return sqlSession.selectOne("mypage.userSummaryInfo", userNo);
	}

//	2-1. 완료봉사, 예정봉사, 포인트 획득 간소화한 정보 조회
	
	public List<MyPageJoinDTO> miniPoint(int userNo) {
		return sqlSession.selectList("mypage.miniPoint", userNo);
	}

	public MyPageJoinDTO miniComVol(int userNo) {
		return sqlSession.selectOne("mypage.miniComVol", userNo);
	}

	public MyPageJoinDTO miniFinVol(int userNo) {
		return sqlSession.selectOne("mypage.miniFinVol", userNo);
	}
	
	
//	3. 내 정보 수정(일반, 기업)

	public void userEdit(MyPageJoinDTO myPageDTO) {
		sqlSession.update("mypage.userEdit", myPageDTO);
	}
	
	public void organEdit(MyPageJoinDTO myPageDTO) {
		sqlSession.update("mypage.organUserEdit", myPageDTO);
	}
	
	public void organAdditionalEdit(int organNo) {
		sqlSession.update("mypage.organUserEdit2", organNo);
	}
	
	
//	4. 예정된 봉사 목록 조회
	
	public List<MyPageJoinDTO> comingVolun(int userNo) {
		return sqlSession.selectList("mypage.comingVol", userNo);
	}
	
//	5. 완료된 봉사 목록 조회
	
	public List<MyPageJoinDTO> finishVolun(int userNo) {
		return sqlSession.selectList("mypage.finishVol", userNo);
	}
	
//	6. 적립된 포인트 내역 조회
	public List<MyPageJoinDTO> plusPoint(int userNo) {
		return sqlSession.selectList("mypage.plusPoint", userNo);
	}
	
	
//	7. 사용한 포인트 내역 조회

	public List<MyPageJoinDTO> minusPoint(int userNo) {
		return sqlSession.selectList("mypage.minusPoint", userNo);
	}
	
	
//	6. 작성 글 조회
	
	public List<MyPageJoinDTO> viewMyPost(int userNo) {
		return sqlSession.selectList("mypage.mypost", userNo);
		
	}
	
//	7. 회원탈퇴
	
	public void quit(int userNo) {
		sqlSession.update("mypage.quit", userNo);
	}
	
	
	
	
	
	
	
	
}
