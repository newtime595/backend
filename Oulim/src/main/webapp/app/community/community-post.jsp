<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!doctype html>
<html lang="ko">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>봉사 후기 등록</title>

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

  <!-- css 연결 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/community/community-post.css">
  <script defer src="${pageContext.request.contextPath}/asset/js/pages/community/community-post.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />
  
  <script>
   	const contextPath = "${pageContext.request.contextPath}";
  </script>
</head>

<body>
  <!-- Header 자동 삽입 -->
  	<jsp:include page="/app/include/header.jsp" />

  
    <main class="l-main">
      <!-- 팀원들 작성 영역 이 안에서 작업하기!!퍼블 작업진행 -->
      <div class="l-container">
        <div class="p-community-post">
          <div class="c-community-post-page-title">
            <h2>봉사 후기 등록</h2>
          </div>
          <form id="write-form" action="${pageContext.request.contextPath}/community/postOK.commu"
           method="post" enctype="multipart/form-data">
            <div class="l-community-post-main">
              <div class="c-community-post-title">
                <label for="title"><b>제목</b></label>
                <!-- 컴포넌트 c-input 사용 -->
                <input class="c-input" type="text" name="postTitle" id="title" placeholder="후기 제목 입력" required />
              </div>

              <div class="l-community-post-detail">
                <label for="content"><b>상세 내용 작성</b>
              </div>
              <textarea class="c-textarea" id="content" name="postContent" placeholder="후기를 작성해주세요" required></textarea>
            </div>

            <div class="l-community-post-img-attach">
              <!-- TODO : 이미지 추가 관련 처리하기 -->
              <div class="c-community-post-img-attatch-label">
                <label>이미지 등록</label>
              </div>
              <div class="c-community-post-img-row">
                <input type="text" class="c-community-post-file-name" value="대표이미지.jpg" readonly>
                <label for="file" class="c-file-btn">파일 추가</label>
                <style>#file{display:none !important}</style>
                <input type="file" id="file" name="postImage" accept="image/*">
              </div>
            </div>
            
            <div class="c-community-post-preview">
    			<ul class="file-list">
    				
    			</ul>
  			</div>
            
            <div class="l-community-post-btn-group">            
              <!-- 공용 컴포넌트 투버튼 c-button-group  -->
              <div class="c-button-group">
                <div>
                  <button type="submit" id="post-button" class="c-button c-button--primary c-button--md">등록</button>
                </div>
                <div>
                  <button type="button" id="cancel-button" class="c-button c-button--secondary c-button--md">취소</button>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
      <!-- TODO : css 로 스타일 적용, repost는 똑같이 처리하기 -->
    </main>

    <!-- Footer 자동 삽입 -->
  <jsp:include page="/app/include/footer.jsp" />
</body>

</html>