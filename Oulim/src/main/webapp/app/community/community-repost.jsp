<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>봉사 후기 수정</title>

  <!-- base css 필수 삽입-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/layout.css">

  <!-- 컨포넌트 css 선택-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/pagination.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/input.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/button.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/list.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/card.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/DetailCard.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/badge.css" />

  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />
  <!-- css 연결 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/community/community-repost.css">
  <script defer src="${pageContext.request.contextPath}/asset/js/pages/main/include.js"></script>

</head>
<!-- js 연결 -->
<script defer src="${pageContext.request.contextPath}/asset/js/pages/community/community-repost.js"></script>

<body>
  <!-- Header 자동 삽입 -->
  	<jsp:include page="/app/include/header.jsp" />

    <main class="l-main">
      <!-- 팀원들 작성 영역 이 안에서 작업하기!!퍼블 작업진행 -->
      <div class="l-container">
        <div class="p-community-repost">
          <div class="c-community-repost-page-title">
            <h2>봉사 후기 수정</h2>
          </div>

          <form action="">
            <div class="l-community-repost-top">
              <div class="c-delete-post-btn">
                <button class="c-warning-delete-button">삭제</button>
              </div>
            </div>
            <div class="l-community-repost-main">
              <div class="c-community-repost-title">
                <label for=""><b>제목</b></label>
                <!-- 컴포넌트 c-input 사용 -->
                <input class="c-input" type="text" name="" id="" placeholder="후기 제목 입력" />
              </div>

              <div class="l-community-repost-detail">
                <label><b>상세 내용 작성</b>
              </div>
              <textarea class="c-textarea" placeholder="후기를 작성해주세요"></textarea>
            </div>

            <div class="l-community-repost-img-attach">
              <!-- TODO : 이미지 추가 관련 처리하기 -->
              <div class="c-community-repost-img-attatch-label">
                <label>이미지 등록</label>
              </div>
              <div class="c-community-repost-img-row">
                <input type="text" class="c-community-repost-file-name" value="대표이미지.jpg" readonly>
                <label for="imageInput" class="c-file-btn">파일 추가</label>
                <input type="file" id="imageInput" accept="image/*">
              </div>
            </div>
            <div class="l-community-repost-btn-group">
              <!-- 공용 컴포넌트 투버튼 c-button-group  -->
              <div class="c-button-group">
                <div>
                  <button type="submit" id="repost-button" class="c-button c-button--primary c-button--md">수정</button>
                </div>
                <div>
                  <button type="button" id="cancel-button" class="c-button c-button--secondary c-button--md">취소</button>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>

    </main>

    <!-- Footer 자동 삽입 -->
  <jsp:include page="/app/include/footer.jsp" />
</body>

</html>