package com.oulim.app.community.dao;

import java.util.List;
import java.util.Map;

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
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
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
	public void updateViewCount(int postNo) {
		System.out.println("조회수 업데이트 실행 : " + postNo);
		int result = sqlSession.update("community.updateReadCount", postNo);
		System.out.println("조회수 업데이트 결과 : " + result);
	}

	// 게시글 작성 메소드
	public int insertCommunityPost(CommunityPostDTO communityPostDTO) {
		System.out.println("게시글 작성 - insertCommunityPost 메소드 실행");
		int result = sqlSession.insert("community.postInsert", communityPostDTO);
		System.out.println("쿼리 수행 결과 : " + result);
		int postNo = communityPostDTO.getPostNo();		
		System.out.println("게시글 작성 성공 PostNo : " + postNo);
		return postNo;
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

	// 게시글 추천 확인
	public boolean checkPostLike(PostLikeDTO postLikeDTO) {
		System.out.println("게시글 추천 확인 - checkPostLike 메소드 실행");
		int result = sqlSession.selectOne("community.isRecomended", postLikeDTO);
		if(result > 0 ) {
			return false;
		}
		return true;		
	}
	
	// 게시글 추천
	public void doPostLike(PostLikeDTO postLikeDTO) {
		System.out.println("게시글 추천 - doPostLike 메소드 실행");
		sqlSession.insert("community.postLike", postLikeDTO);
		System.out.println("게시글 추천 성공");
	}

	// 게시글 목록 조회
	public List<CommunityPostJoinDTO> selectList(Map<String, Object> pageMap) {
		System.out.println("게시물 목록 조회 - selectList 메소드 실행");
		List<CommunityPostJoinDTO> list = sqlSession.selectList("community.selectPostAll", pageMap);
		return list;
	}

	// 게시글 상세 조회
	public CommunityPostJoinDTO selectPostDetail(int postNo) {
		System.out.println("게시글 상세 조회 - selectPostDetail");
		return sqlSession.selectOne("community.selectPost", postNo);
	}

	// 댓글 조회
	public List<CommunityCommentDTO> selectCommentList(Map<String, Integer> pageMap) {
		System.out.println("댓글 목록 조회 - selectCommentList 메소드 실행 ");
		List<CommunityCommentDTO> list = sqlSession.selectList("community.selectPostComment", pageMap);
		return list;
	}

	// 댓글 작성
	public void insertPostComment(CommunityCommentDTO communityCommentDTO) {
		System.out.println("댓글 작성 - insertPostComment 메소드 실행");
		sqlSession.insert("community.commentInsert", communityCommentDTO);
		System.out.println("댓글 작성 성공");
	}
}
