package com.oulim.app.admin.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.oulim.app.admin.dto.AdminMemDetailDTO;
import com.oulim.app.admin.dto.AdminMemListDTO;
import com.oulim.app.config.MyBatisConfig;
import com.oulim.app.user.dto.LogPointDTO;


public class AdminMemDAO {
	
	public SqlSession sqlSession;
	
	
//    public AdminMemDAO() {
//    	sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
//    } 
//        //관리자 멤버 선택리스트
//    public List<AdminMemListDTO> selectList(AdminMemListDTO adminMemListDTO) {
//    	System.out.println("");
//        return sqlSession.selectList("adminMem.selectList", adminMemListDTO);
//    }
//    	//관리자 회원 카운트
//    public int selectCount(AdminMemListDTO adminMemListDTO) {
//        return sqlSession.selectOne("adminMem.selectCount", adminMemListDTO);
//    }
//    	//관리자 멤서 상세
//    public AdminMemDetailDTO selectDetail(int userNo) {
//        return sqlSession.selectOne("adminMem.selectDetail", userNo);
//    }
    public AdminMemDAO() {
        sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }

    public List<AdminMemListDTO> selectList(AdminMemListDTO adminMemListDTO) {
        return sqlSession.selectList("adminMem.selectList", adminMemListDTO);
    }

    public int selectCount(AdminMemListDTO adminMemListDTO) {
        return sqlSession.selectOne("adminMem.selectCount", adminMemListDTO);
    }

    public AdminMemDetailDTO selectDetail(int userNo) {
        return sqlSession.selectOne("adminMem.selectDetail", userNo);
    }

    public List<LogPointDTO> selectPointList(int userNo) {
        return sqlSession.selectList("adminMem.selectPointList", userNo);
    }
    // 멤버 업데이트
    public void update(AdminMemDetailDTO member) {
        sqlSession.update("adminMem.update", member);
    }
    // 멤버 삭제
    public void delete(int userNo) {
        sqlSession.update("adminMem.delete", userNo);
    }
    
    public void updateMember(AdminMemDetailDTO member) {
        sqlSession.update("adminMem.updateMember", member);
    }
    
    // 현재 닉네임 조회
    public String selectNicknameByUserNo(int userNo) {
        return sqlSession.selectOne("adminMem.selectNicknameByUserNo", userNo);
    }

    // 수정용 닉네임 중복 검사
    public int checkNicknameForUpdate(int userNo, String userNickname) {
        Map<String, Object> map = new HashMap<>();
        map.put("userNo", userNo);
        map.put("userNickname", userNickname);
        return sqlSession.selectOne("adminMem.checkNicknameForUpdate", map);
    }

    // 닉네임 업데이트
    public void updateNickname(int userNo, String userNickname) {
        Map<String, Object> map = new HashMap<>();
        map.put("userNo", userNo);
        map.put("userNickname", userNickname);
        sqlSession.update("adminMem.updateNickname", map);
    }
    
    public AdminMemListDTO selectMember(int userNo) {
        return sqlSession.selectOne("adminMem.selectMember", userNo);
    }
    
}
