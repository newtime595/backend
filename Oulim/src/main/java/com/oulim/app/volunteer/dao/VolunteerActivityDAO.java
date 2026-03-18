package com.oulim.app.volunteer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.oulim.app.volunteer.dto.VolunActivityDTO;

public class VolunteerActivityDAO {

    private SqlSession sqlSession;

    public VolunteerActivityDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public VolunteerActivityDAO() {
		// TODO Auto-generated constructor stub
	}
    
//    전체 목록 조회
	public List<VolunActivityDTO> selectVolunteerList(Map<String, Object> param){

        return sqlSession.selectList("VolunteerMapper.selectVolunteerList");

    }

}