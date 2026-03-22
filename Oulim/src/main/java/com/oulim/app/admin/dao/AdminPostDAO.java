package com.oulim.app.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.oulim.app.community.dto.CommunityPostDTO;
import com.oulim.app.community.dto.CommunityPostJoinDTO;
import com.oulim.app.config.MyBatisConfig;

public class AdminPostDAO {
	public SqlSession sqlSession;
	
	public AdminPostDAO(){
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
		
	}
	// 게시글 목록 조회
	public List<CommunityPostJoinDTO> selectList(Map<String, Object> pageMap) {
		System.out.println("게시물 목록 조회 - selectList 메소드 실행");
		List<CommunityPostJoinDTO> list = sqlSession.selectList("community.selectPostAll", pageMap);
		return list;
}

	// 게시글 수정 메소드
	public void repostPost(CommunityPostDTO communityPostDTO) {
		System.out.println("게시글 작성 - repostPost 메소드 실행");
		sqlSession.update("community.updatePost", communityPostDTO);
		System.out.println("게시글 작성 성공");
	}
	
	// 게시글 삭제 메소드
	public void deleteCommunityPost(int postNo) {
		System.out.println("게시글 삭제 - deleteCommunityPost 메소드 실행");
		sqlSession.delete("community.delete", postNo);
		System.out.println("게시글 삭제 성공");
	}
	
	
	// 게시글 상세 조회
	public CommunityPostJoinDTO selectPost(int postNo) {
		System.out.println("게시글 상세 조회 - selectPostDetail");
		return sqlSession.selectOne("adminPost.selectPost", postNo);
	}


}