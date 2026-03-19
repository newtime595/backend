package com.oulim.app.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oulim.app.config.MyBatisConfig;
import com.oulim.app.user.dto.CurrencyDTO;
import com.oulim.app.user.dto.OrganDTO;
import com.oulim.app.user.dto.UserDTO;


public class UserDAO {
    SqlSession sqlSession;

    public UserDAO() {
        sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }
    
    public int checkId(String userId) {
    	return sqlSession.selectOne("user.chkUserId", userId);
    }
    
    public int checkEmail(String userEmail) {
    	return sqlSession.selectOne("user.chkUserEmail", userEmail);
    }
    
    public int checkNickname(String userNickname) {
    	return sqlSession.selectOne("user.chkUserId", userNickname);
    }
    
    public int checkPhoneNum(String userPhoneNum) {
    	return sqlSession.selectOne("user.chkUserPhoneNum", userPhoneNum);
    }
    
    public void normaljoin(UserDTO userDTO) {
    	sqlSession.insert("user.normaljoin", userDTO);
    }
    
    public OrganDTO selectOrganByCertNum(String organCertNum) {
        return sqlSession.selectOne("user.selectOrganByCertNum", organCertNum);
    }

    public void organjoin(UserDTO userDTO) {
    	sqlSession.insert("user.organjoin", userDTO);
    }
    
    public void insertorgan(OrganDTO organDTO) {
    	sqlSession.insert("user.insertorgan", organDTO);
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
    
    // 재화 처리 관련
    public List<CurrencyDTO> getUserCurrencyInfo(int userNo){
    	System.out.println("유저 재화 정보 가져오기");
    	return sqlSession.selectList("user.getCurrency", userNo);
    }
    
    public boolean upsertCurrency(CurrencyDTO currencyDTO) {
    	System.out.println("유저 재화 상태 변경");
    	int result = sqlSession.update("user.upsertCurrency", currencyDTO);
    	return result < 1 ? false : true;
    }
    
}