package com.oulim.app.volunteer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.oulim.app.config.MyBatisConfig;
import com.oulim.app.volunteer.dto.VolunActivityDTO;
import com.oulim.app.volunteer.dto.VolunApplyDTO;

public class VolunteerActivityDAO {

    private SqlSession sqlSession;

    public VolunteerActivityDAO() {
        this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }

    public List<VolunActivityDTO> selectVolActList(VolunActivityDTO dto) {
        return sqlSession.selectList("volunAct.selectVolunteerList", dto);
    }
    
    public int selectCount(VolunActivityDTO dto) {
        return sqlSession.selectOne("volunAct.selectCount", dto);
    }
    
    //상세 페이지 정보
    public VolunActivityDTO selectDetail(int volunActNo) {
		return sqlSession.selectOne("volunAct.selectVolunDetail", volunActNo);
	}
    
    // 신청
    public void applyVolunteer(VolunApplyDTO dto) {
        sqlSession.insert("volunAct.applyVolunteer", dto);
    }

    // 철회
    public void cancelVolunteer(VolunApplyDTO dto) {
        sqlSession.update("volunAct.cancelVolunteer", dto);
    }
    
    // 메인화면 조회용 봉사활동 리스트 조회
    public List<VolunActivityDTO> selectMainVolActList(){
    	return sqlSession.selectList("volunAct.selectVolunMain");
    }
    
    // 봉사 신청  여부 
    public int selectApplyCount(Map<String, Object> map) {
		return sqlSession.selectOne("volunAct.selectApplyCount",map );
	}
    
}