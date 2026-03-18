package com.oulim.app.volunteer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oulim.app.config.MyBatisConfig;
import com.oulim.app.volunteer.dto.PointJoinDTO;
import com.oulim.app.volunteer.dto.VolunActivityDTO;
import com.oulim.app.volunteer.dto.VolunApplyDTO;

public class VolunteerMangementDAO {

	public SqlSession sqlSession;

	public VolunteerMangementDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// 봉사활동 조회
	public List<VolunActivityDTO> selectVolManageList(VolunActivityDTO volunActivityDTO) {
		return sqlSession.selectList("VolunteerManagement.volManageSelect", volunActivityDTO);
	}

	// 봉사활동 등록
	public void volActivityInsert(VolunActivityDTO volunActivityDTO) {
		sqlSession.insert("VolunteerManagement.volActivityInsert", volunActivityDTO);
	}

	// 봉사활동 상세조회
	public VolunActivityDTO selectVolManageDetail(int volunActNo) {
		return sqlSession.selectOne("VolunteerManagement.volManageDetail", volunActNo);
	}

	// 봉사 지원자 조회
	public List<VolunApplyDTO> applyVolSelect(int volunActNo) {
		return sqlSession.selectList("VolunteerManagement.applyVolSelect", volunActNo);
	}

	// 봉사 활동 수정 페이지 조회
	public VolunActivityDTO selectVolManageUpdate(int volunActNo) {
		return sqlSession.selectOne("VolunteerManagement.volManageDetail", volunActNo);
	}

	// 봉사활동 수정
	public void volManageUpdate(VolunActivityDTO volunActivityDTO) {
		sqlSession.update("VolunteerManagement.volManageUpdate", volunActivityDTO);
	}
	
	// 봉사활동 삭제
	public void volManageDelete(int volunActNo) {
		sqlSession.delete("VolunteerManagement.volManageDelete", volunActNo);
	}
	
	// 포인트 지급
	public void updateCurrency(PointJoinDTO pointjoinDTO ) {
		sqlSession.update("VolunteerManagement.updateCurrency", pointjoinDTO);
	}

}
