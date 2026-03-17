package com.oulim.app.community.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.oulim.app.community.dto.CommunityCommentDTO;
import com.oulim.app.community.dto.CommunityPostDTO;
import com.oulim.app.community.dto.CommunityPostJoinDTO;
import com.oulim.app.community.dto.PostLikeDTO;

import com.oulim.app.config.MyBatisConfig;

public class CommunityDAO {
	public SqlSession sqlSession;
	
	public CommunityDAO() {
		// 이미지 테이블 삽입 등의 이유로 transaction 활용
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(false);
	}
	
	// 게시글 총 갯수 반환 메소드
	public int getPostTotal() {
		System.out.println("게시글 총 개수 조회 - getPostTotal 메소드 실행");
		return sqlSession.selectOne("community.getTotalPost");
	}
	
	// 댓글 총 갯수 반환 메소드
	public int getTotalComment(int postNo) {
		System.out.println("특정 게시글의 총 댓글 수 조회 - getCommentTotal 메소드 실행 : " + postNo);
		return sqlSession.selectOne("community.getTotalComment", postNo);
	}
	
	// 조회수 증가 메소드
	public boolean updateViewCount(int postNo) {
		try {
			System.out.println("조회수 업데이트 실행 : " + postNo);
			int result = sqlSession.update("community.updateReadCount", postNo);
			sqlSession.commit();
			System.out.println("조회수 업데이트 결과 : " + result);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("조회수 업데이트 실패 ");
			e.printStackTrace();
			sqlSession.rollback();
			return false;
		}
	}
	
	// 게시글 작성 메소드
	public int insertCommunityPost(CommunityPostDTO communityPostDTO, boolean isNoFile) {
		try {
			System.out.println("게시글 작성 - insertCommunityPost 메소드 실행");
			int postNo = sqlSession.insert("community.postInsert", communityPostDTO);
			if(isNoFile) {
				sqlSession.commit();
			}
			System.out.println("게시글 작성 성공");
			return postNo;
		} catch (Exception e) {
			System.out.println("게시글 작성 성공 - insertCommunityPost 메소드 실행");
			e.printStackTrace();
			sqlSession.rollback();
		}
		return 0;
	}
	
	// 게시글 수정 메소드
	public boolean repostPost(CommunityPostDTO communityPostDTO) {
		try {
			System.out.println("게시글 작성 - repostPost 메소드 실행");
			sqlSession.update("community.updatePost", communityPostDTO);
			sqlSession.commit();
			System.out.println("게시글 작성 성공");
			return true;
		} catch (Exception e) {
			System.out.println("게시글 작성 실패 - repostPost 메소드 실행");
			e.printStackTrace();
			sqlSession.rollback();
			return false;
		}
	}
	
	// 게시글 삭제 메소드
	public boolean deleteCommunityPost(int postNo) {
		try {
			System.out.println("게시글 삭제 - deleteCommunityPost 메소드 실행");
			sqlSession.delete("community.delete", postNo);
			sqlSession.commit();
			System.out.println("게시글 삭제 성공");
			return true;
		} catch (Exception e) {
			System.out.println("게시글 삭제 실패 - deleteCommunityPost 메소드 실행");
			sqlSession.rollback();
			return false;
		}		
	}
	
	// 게시글 추천
	public boolean doPostLike(PostLikeDTO postLikeDTO) {
		try {
			System.out.println("게시글 추천 - doPostLike 메소드 실행");
			sqlSession.insert("community.postLike", postLikeDTO);
			System.out.println("게시글 추천 성공");
			return true;
		} catch (Exception e) {
			System.out.println("게시글 추천 실패 - doPostLike 메소드 실행");
			e.printStackTrace();
			sqlSession.rollback();
			return false;
		}
	}
	
	// 게시글 목록 조회
	public List<CommunityPostJoinDTO> selectList(HashMap<String, Integer> pageMap){
		System.out.println("게시물 목록 조회 - selectList 메소드 실행");
		List<CommunityPostJoinDTO> list =  sqlSession.selectList("community.selectPostAll", pageMap);
		return list;
	}
	// 게시글 상세 조회
	public CommunityPostJoinDTO selectPostDetail(int postNo) {
		System.out.println("게시글 상세 조회 - selectPostDetail");
		return sqlSession.selectOne("community.selectPost", postNo);
	}
	// 댓글 조회
	public List<CommunityCommentDTO> selectCommentList(HashMap<String, Integer> pageMap) {
		System.out.println("댓글 목록 조회 - selectCommentList 메소드 실행 ");
		List<CommunityCommentDTO> list = sqlSession.selectList("community.selectPostComment", pageMap);
		return list;
	}
	
	// 댓글 작성
	public boolean insertPostComment(CommunityCommentDTO communityCommentDTO) {
		try {
			System.out.println("게시글 추천 - doPostLike 메소드 실행");
			sqlSession.insert("community.commentInsert", communityCommentDTO);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sqlSession.rollback();
			return false;
		}
	}
}
