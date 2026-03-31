package com.oulim.app.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import com.oulim.app.config.MyBatisConfig;
import com.oulim.app.user.dto.CurrencyDTO;
import com.oulim.app.user.dto.LogPointDTO;
import com.oulim.app.user.dto.OrganDTO;
import com.oulim.app.user.dto.UserDTO;


public class UserDAO {
    SqlSession sqlSession;

    public UserDAO() {
        sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }
    
    public UserDAO(SqlSession session) {
    	sqlSession = session;
    }
    
    public int checkId(String userId) {
    	return sqlSession.selectOne("user.chkUserId", userId);
    }
    
    public int checkEmail(String userEmail) {
    	return sqlSession.selectOne("user.chkUserEmail", userEmail);
    }
    
    public int checkNickname(String userNickname) {
    	return sqlSession.selectOne("user.chkUserNickname", userNickname);
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
    
    public CurrencyDTO getSomeCurrencyInfo(Map<String, Integer> map) {
    	System.out.println("특정한 재화 하나의 보유 정보 가져오기");
    	return sqlSession.selectOne("user.getCurrencyOne", map);
    }
    
    public boolean upsertCurrency(CurrencyDTO currencyDTO) {
    	System.out.println("유저 재화 상태 변경");
    	int result = sqlSession.update("user.upsertCurrency", currencyDTO);
    	return result < 1 ? false : true;
    }
    
    // 유저 수 조회
    public int getTotalUser(int userType) {
    	return sqlSession.selectOne("user.getUserCount", userType);
    }
    
    // 포인트 로그 삽입
    public boolean insertPointLog(LogPointDTO logPointDTO) {
    	System.out.println("포인트 이력 삽입");
    	int result = sqlSession.insert("user.pointLogInsert", logPointDTO);
    	return result < 1 ? false : true;
    }
}