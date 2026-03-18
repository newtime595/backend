package com.oulim.app.user.dao;

import org.apache.ibatis.session.SqlSession;

import com.oulim.app.config.MyBatisConfig;
import com.oulim.app.user.dto.UserDTO;


public class UserDAO {
    SqlSession sqlSession;

    public UserDAO() {
        sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }
    
    public void normaljoin(UserDTO userDTO) {
    	sqlSession.insert("user.normaljoin", userDTO);
    }
    
    public UserDTO login(UserDTO userDTO) {
    	return sqlSession.selectOne("user.login", userDTO);
    }
    
    public String findId(UserDTO userDTO) {
        return sqlSession.selectOne("user.findId", userDTO);
    }
    
    public UserDTO findPw(UserDTO userDTO) {
    	return sqlSession.selectOne("user.findPw", userDTO);
    }
    
    public void updatePw(UserDTO userDTO) {
    	sqlSession.update("user.updatePw", userDTO);
    }
}