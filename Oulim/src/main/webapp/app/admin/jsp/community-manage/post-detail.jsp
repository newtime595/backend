<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!doctype html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>post-detail</title>

    <!-- base css 필수 삽입-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />
    <!-- 컨포넌트 css 선택-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/pagination.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/input.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/button.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/list.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/card.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/DetailCard.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/badge.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/app/admin/css/community-manage/post-detail.css" />
  <script defer src="${pageContext.request.contextPath}/app/admin/js/community-manage/post-detail.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/app/admin/css/aside.css" />
</head>

<body>

	<main class="l-main">
	<jsp:include page="/app/admin/jsp/aside.jsp"/>


    <!-- 메인 컨텐츠 -->

      <section class="l-content">
        <!-- 메인위에 헤더 -->
        <div class="header">
          <h1>게시글 상세</h1>
        </div>
			<div id="content-area">
			  <div class="post-name">
			    <p>${post.postTitle}</p>
			    <div class="c-list__actions">
			      <button class="c-button c-button--primary c-button--sm">수정</button>
			      <button class="c-button c-button--secondary c-button--sm">삭제</button>
			    </div>
			  </div>
			
			  <div id="post-comment">
			    <p>작성일 : ${post.postDate}</p>
			    <p>작성자 : ${post.userNickname}</p>
			  </div>
			
			  <div id="post-count">
			    <p>조회수 : ${post.postViewCount}</p>
			    <p>추천수 : ${post.likeCount}</p>
			  </div>
			
			  <div class="post-text">
			    <div class="photobox">
			     <c:forEach var="img" items="${post.images}">
          			 <div	class="mainImage">
			        <img src="${pageContext.request.contextPath}/upload/${img.postImgSystemName}" width="200" height="200" />
			      </div>
			     </c:forEach>
			    </div>
			    <p>${post.postContent}</p>
			  </div>
			
			  <div class="comment-area">
			    <h3 class="comment-title">댓글</h3>
			    <div class="comment-list">
			      <c:if test="${empty commentList}">
			        <div class="comment">
			          <p class="comment-text">댓글이 없습니다.</p>
			        </div>
			      </c:if>
			
			      <c:forEach var="comment" items="${commentList}">
			        <div class="comment">
			          <p class="comment-user">${comment.userNickname}</p>
			          <p class="comment-text">${comment.commentContent}</p>
			        </div>
			      </c:forEach>
			    </div>
			  </div>
			</div>
     </section>
  </main>

</body>

</html>