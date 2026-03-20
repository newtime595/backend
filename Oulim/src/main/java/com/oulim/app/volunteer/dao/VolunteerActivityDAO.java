package com.oulim.app.volunteer.dao;

import java.util.List;

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
        return sqlSession.selectOne("volunAct.selectVolunteerCount", dto);
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
    
}