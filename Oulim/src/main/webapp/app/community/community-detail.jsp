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
    <script defer src="${pageContext.request.contextPath}/asset/js/pages/main/include.js"></script>
    <script defer src="${pageContext.request.contextPath}/asset/js/pages/community/community-detail.js">
    </script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css"/>
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />
  </head>
  <body>
    <!-- Header 자동 삽입 -->
  	<jsp:include page="/app/include/header.jsp" />

    <main class="l-main">
      <div class="l-container">
        <!-- 팀원들 작성 영역 이 안에서 작업하기!!퍼블 작업진행 -->
        <div class="p-community-detail">
          <div class=""><b>제목</b></div>
          <div class="l-community-detail-author-group">
            작성자 | <span id="author">작성자</span> 작성일 |
            <span id="date">작설일</span> 추천수 |
            <span id="like">추천수</span> 조회수 | <span id="view">조회수</span>
          </div>
        </div>
        <div class="l-community-detail-main">
          <div>
            <h4>상세내용</h4>
          </div>
          <!-- 추후 이미지를 출력할 div -->
          <div class="l-community-detail-image"></div>
          <!-- 전달 받은 데이터를 표시할 div -->
          <div class="l-community-detail-main-content">내용출력</div>
        </div>

        <div class="l-community-comment">
          <div class="l-community-comment-recommend-btn-group">
            <div class="c-comment-title"><b>댓글</b></div>
            <div class="l-recommend-btn-group">
              <button class="c-button c-button--primary c-button--sm">추천</button>
              <div class="c-recommend">추천수 | 40000</div>
            </div>
          </div>
          <div class="comment-item">
            작성자<span id="comment-author"></span><br />
            <div class="comment-content">댓글내용</div>
          </div>
          <div class="l-community-comment-writebox">
            <textarea
              class="c-comment-textarea"
              placeholder="댓글 입력"
            ></textarea>
            <div class="c-comment-post-btn">
              <button class="c-button c-button--primary c-button--lg">댓글 작성</button>
            </div>
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
