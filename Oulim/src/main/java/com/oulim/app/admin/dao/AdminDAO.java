package com.oulim.app.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oulim.app.admin.dto.AdminDTO;
import com.oulim.app.admin.dto.AdminStatisticDTO;
import com.oulim.app.config.MyBatisConfig;
import com.oulim.app.user.dto.UserDTO; 


public class AdminDAO {
    SqlSession sqlSession;
    
    public AdminDAO() {
        sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }
    
    //mybatis가 맵퍼로 보냄
    public int login(AdminDTO adminDTO) {
    	System.out.println("AdminDAO의 로그인 메소드 호출");
        Integer adminNo = sqlSession.selectOne("admin.login", adminDTO);

        if (adminNo == null) {
            return 0; // 로그인 실패
        }

        return adminNo; // 로그인 성공
    }

    
    public AdminStatisticDTO getStatistic() {
    	System.out.println("통계 조회 - getStatistic");
    	return sqlSession.selectOne("admin.selectStatistic");
    }
    
    public List<UserDTO> getUnApprovedOrganUser(){
    	System.out.println("미승인 기업회원 리스트 조회 - getUnApprovedOrganUser");
    	return sqlSession.selectList("admin.getRequireApproveMember");
    }
}