package com.oulim.app.volunteer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oulim.app.config.MyBatisConfig;
import com.oulim.app.volunteer.dto.VolunActivityDTO;

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
}