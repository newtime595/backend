<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>봉사 후기</title>

    <!-- base css 필수 삽입-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/layout.css" />
    <!-- 컨포넌트 css 선택-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/pagination.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/input.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/button.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/list.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/card.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/DetailCard.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/badge.css" />
    <!-- css 연결 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/community/community-detail.css"
    />
    <script defer src="${pageContext.request.contextPath}/asset/js/pages/community/community-detail.js">
    </script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css"/>
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />
  	<script>
    	const contextPath = "${pageContext.request.contextPath}";
    	const postNo = "${post.postNo}";
    	const userNo = "${post.userNo}";
    	const isLogin = ${not empty sessionScope.userNo ? 'true' : 'false'};
    	const loginUserNo = ${sessionScope.userNo != null ? sessionScope.userNo : -1};
    	const userType = ${sessionScope.userType != null ? sessionScope.userType : -1};
    	const userNickname = "${sessionScope.userNickname != null ? sessionScope.userNickname : ''}";
    </script>
  </head>
  <body>
    <!-- Header 자동 삽입 -->
  	<jsp:include page="/app/include/header.jsp" />

    <main class="l-main">
      <div class="l-container">
        <!-- 팀원들 작성 영역 이 안에서 작업하기!!퍼블 작업진행 -->
        <div class="p-community-detail">
          <div class=""><b>${post.postTitle}</b></div>
          <div class="l-community-detail-author-group">
            작성자 | <span id="author">${post.userNickname}</span> 작성일 |
            <span id="date">${post.postDate}</span> 조회수 | <span id="view">${post.postViewCount }</span>
          </div>
        </div>
        <div class="l-community-detail-main">
          <div>
            <h4>상세내용</h4>
          </div>
          <!-- 추후 이미지를 출력할 div -->
          <div class="l-community-detail-image">
           <c:forEach var="img" items="${post.images}">
           <div	class="mainImage">
    		<img src="${pageContext.request.contextPath}/upload/${img.postImgSystemName}" alt="">
    		</div>
  			</c:forEach>
          </div>
          <!-- 전달 받은 데이터를 표시할 div -->
          <div class="l-community-detail-main-content">${post.postContent }</div>
        </div>

        <div class="l-community-comment">
          <div class="l-community-comment-recommend-btn-group">
            	<div class="c-comment-title"><b>댓글</b></div>
            	<div class="l-recommend-btn-group">
            	  <button id="recommendBtn" class="c-button c-button--primary c-button--sm">추천</button>
             	 <div class="c-recommend">추천수 | ${post.likeCount}</div>
            	</div>
            </div>
          
          <c:if test="${not empty commentList}">
	          <c:forEach var="comment" items="${commentList}">
       			<div class="commentList">
		    	      <div class="comment-item">
		    	        <div id="comment-author">${comment.userNickname}</div>
		    	        <div class="comment-content">${comment.commentContent}</div>
		    	        <div class="comment-date">${comment.postDate}</div>    	        
			          </div>
			      </div>
	          </c:forEach>
          </c:if>
          <div class="l-community-comment-writebox">
             <textarea              
	              class="c-comment-textarea"
	              id="commentContent"
    	          placeholder="댓글 입력"
        	    ></textarea>
            <div class="c-comment-post-btn">
            	<button id="commentPostBtn" class="c-button c-button--primary c-button--lg">댓글 작성</button>
           	 </div>
          </div>
          
          <div
            class="l-community-list-pagination"
            style="width: 900px; margin: 50px"
          >
          <c:if test="${not empty commentList}">
            <nav class="c-pagination" id="commentPagination">
              <c:choose>
              	<c:when test="${prev}">
              		<a href="#" 
              		class="c-pagination__link">&lt;</a>
              	</c:when>
              	<c:otherwise>
              		<a href="#" 
              		class="c-pagination__link is-disabled" onclick="return false;">&lt;</a>
              	</c:otherwise>
              </c:choose>
              <c:set var="realStartPage" value="${startPage < 1 ? 1 : startPage }"/>
              <c:forEach var="i" begin="${realStartPage}" end="${endPage}">
    			<c:choose>          
    				<c:when test="${!(i == page)}">
	              		<a href="#"
	              			 class="c-pagination__link">
	               			<c:out value="${i}"/>
	               		</a>
	               	</c:when>
	               	<c:otherwise>
	               		<a href="#" class="c-pagination__link is-active">
	               			<c:out value="${i}"/>
	               		</a>
	               	</c:otherwise>
	            </c:choose>	            
              </c:forEach>
              <c:choose>
              	<c:when test="${next}">
              		<a href="#"
              	 	class="c-pagination__link">&gt;</a>
              	</c:when>
              	<c:otherwise>
              		<a href="#"
              	 	class="c-pagination__link is-disabled" onclick="return false;">&gt;</a>
              	</c:otherwise>
              </c:choose>
            </nav>
            </c:if>
            </div>
        </div>
        
        <div class="l-return-button">
          <button class="c-button c-button--primary c-button--lg">목록으로 돌아가기</button>
        </div>
      </div>
    </main>

    <!-- Footer 자동 삽입 -->
  <jsp:include page="/app/include/footer.jsp" />
  </body>
</html>
