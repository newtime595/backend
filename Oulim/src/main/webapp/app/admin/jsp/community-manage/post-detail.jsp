<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <p>봉사활동 후기제목</p>
            <div class="c-list__actions">
              <button class="c-button c-button--primary c-button--sm">
                수정
              </button>
              <button class="c-button c-button--secondary c-button--sm">
                삭제
              </button>
            </div>
          </div>
          <div id="post-comment">
            <p>작성일 : 0000-00-00</p>
            <p>작성자 :</p>
          </div>
          <div id="post-count">
            <p>조회수 : 1</p>
            <p>추천수 : 1</p>
          </div>
          <div id="happy-count">
            <button class="recommend-btn c-button c-button--primary c-button--md">
              추천
            </button>
          </div>
          <!-- 게시글 내용 -->
          <div class="post-text">
            <div class="photobox">
              <img src="" width="200px" height="200px" />
            </div>
            <p>
              게시글 내용이 들어가는 영역입니다. 봉사활동 후기나 설명 등이
              표시됩니다. 여러 줄의 텍스트가 들어갈 수 있도록 구성되어
              있습니다.
            </p>
          </div>

          <!-- 댓글 영역 -->
          <div class="comment-area">
            <h3 class="comment-title">댓글</h3>

            <!-- 댓글 목록 -->
            <div class="comment-list">
              <div class="comment">
                <p class="comment-user">작성자1</p>
                <p class="comment-text">좋은 활동이네요!</p>
              </div>

              <div class="comment">
                <p class="comment-user">작성자2</p>
                <p class="comment-text">저도 참여하고 싶습니다.</p>
              </div>

              <div class="comment">
                <p class="comment-user">작성자3</p>
                <p class="comment-text">수고하셨습니다.</p>
              </div>
            </div>
          </div>
        </div>
    </div>
    </section>
  </main>

</body>

</html>