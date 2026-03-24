package com.oulim.app.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oulim.app.admin.dto.AdminPointDTO;
import com.oulim.app.config.MyBatisConfig;

public class AdminPointDAO {
	
    private SqlSession sqlSession;

    public AdminPointDAO() {
        sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }

    public AdminPointDTO selectPointInfo(int userNo) {
        return sqlSession.selectOne("adminPoint.selectPointInfo", userNo);
    }

    public List<AdminPointDTO> selectPointLogList(int userNo) {
        return sqlSession.selectList("adminPoint.selectPointLogList", userNo);
    }

    public void plusPoint(AdminPointDTO dto) {
        sqlSession.update("adminPoint.plusPoint", dto);
    }

    public void minusPoint(AdminPointDTO dto) {
        sqlSession.update("adminPoint.minusPoint", dto);
    }

    public void insertPointLog(AdminPointDTO dto) {
        sqlSession.insert("adminPoint.insertPointLog", dto);
    }
}
