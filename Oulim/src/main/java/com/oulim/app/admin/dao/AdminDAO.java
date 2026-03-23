package com.oulim.app.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.oulim.app.admin.dto.AdminCompanyCertificationDTO;
import com.oulim.app.admin.dto.AdminDTO;
import com.oulim.app.admin.dto.AdminStatisticDTO;
import com.oulim.app.config.MyBatisConfig;
import com.oulim.app.user.dto.UserDTO;
import com.oulim.app.volunteer.dto.VolunActivityDTO; 


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
    	return sqlSession.selectList("admin.getUnApprovedMember");
    }
    
    public List<AdminCompanyCertificationDTO> getRequireApprovedOrganUser(Map<String, Integer> map){
    	System.out.println("미승인 기업회원 리스트 조회 - getUnApprovedOrganUser");
    	return sqlSession.selectList("admin.getRequireApproveMember", map);
    }
    
    public int getCountUnApprovedOrganUser() {
    	System.out.println("승인이 필요한 총 기업회원 수 조회 - getCountUnApprovedOrganUser");
    	return sqlSession.selectOne("admin.getTotalRequireMember");
    }
    
    public AdminCompanyCertificationDTO getCertUserDetail(int userNo) {
    	System.out.println("승인 처리 회원 상세 정보 - getCertUserDetail");
    	return sqlSession.selectOne("admin.getOrganUserCertDetail", userNo);
    }
    
    public boolean approveOrganUser(Map<String,Integer> dataMap) {
    	int result = sqlSession.update("admin.updateUserCert", dataMap);
    	return result > 0 ? true : false;
    }
    
    public boolean deleteOrganUser(int userNo) {
    	int result = sqlSession.delete("admin.rejectCertification", userNo);
    	return result > 0 ? true : false;
    }
    
    public List<VolunActivityDTO> getUncompleteVolunActList(){
    	return sqlSession.selectList("admin.uncompleteVolunList");
    }
    
    public UserDTO findOrganUserList(int organNo){
    	List<UserDTO> userList = sqlSession.selectList("admin.findOrganUser", organNo);
    	return userList.get(0);
    }
}