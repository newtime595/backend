package com.oulim.app.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oulim.app.config.MyBatisConfig;
import com.oulim.app.volunteer.dto.VolunActivityDTO;

public class AdmVolMangDAO {
	
	private SqlSession sqlSession;
	
	public AdmVolMangDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	// 조회목록
	public List<VolunActivityDTO> selectAdminVolunList(VolunActivityDTO dto){
		System.out.println(sqlSession.getConfiguration().getMappedStatementNames());
		return sqlSession.selectList("AdmVolMan.selectAdminVolunList", dto);
		
	}
	//페이징 카운팅
	public int selectAdminVolunCount(VolunActivityDTO  dto) {
		return sqlSession.selectOne("AdmVolMan.selectAdminVolunCount", dto);
		
	}
	
	 
	
	
	

}
