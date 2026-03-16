<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>check</title>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/typography.css" />

  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/input.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/button.css" />

  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/mypage/check/check.css">
  
	<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />

  <script defer src="${pageContext.request.contextPath}/asset/js/pages/mypage/check/check.js"></script>
</head>

<body>
	<jsp:include page="/app/include/header.jsp" />

  <main class="l-main">

    <div class="l-mypage">

      <div class="l-mypage--aside">
        <aside>
          <div class="p-mypage-check--menu">
            <ul>
              <!-- check에서 메뉴 눌렀을때 사용자를 어디로 보내야 하는가? -->
              <h2>마이페이지</h2>

              <div class="p-mypage-check--menu-group">
                <li>나의 정보</li>
                <br />
                <a href="${pageContext.request.contextPath}/front/html/mypage/check/check.html"><li>- 내 정보 보기</li></a>
                <br />
                <a href="${pageContext.request.contextPath}/front/html/mypage/check/check.html"><li>- 내 정보 수정</li></a>
              </div>

              <div class="p-mypage-check--menu-group">
                <li>봉사조회</li>
                <br />
                <a href="${pageContext.request.contextPath}/front/html/mypage/check/check.html"><li>- 예정된 봉사 이력 조회</li></a>
                <br />
                <a href="${pageContext.request.contextPath}/front/html/mypage/check/check.html"><li>- 완료된 봉사 이력 조회</li></a>
              </div>

              <div class="p-mypage-check--menu-group">
                <li>포인트 조회</li>
              </div>

              <div class="p-mypage-check--menu-group">
                <li>작성글 조회</li>
              </div>

              <div class="p-mypage-check--menu-group">
                <li>회원 탈퇴</li>
              </div>

            </ul>
          </div>
        </aside>
      </div>

      <div class="l-mypage--content">

        <div class="p-mypage-check--header">

          <div class="p-mypage-check--title">
            <h1>마이페이지</h1>
          </div>

          <div class="p-mypage-check--desc">
            <h5>마이페이지는 비밀번호 확인 후 이용가능합니다</h5>
          </div>

        </div>

        <form>

          <div class="p-mypage-check--form">

            <div class="p-mypage-check--label">
              <h5>비밀번호</h5>
            </div>

            <div class="p-mypage-check--input">
              <input type="password" class="c-input" name="password" placeholder="비밀번호 입력" />
             <button type="button" id="c-password-btn-toggle"><img src="${pageContext.request.contextPath}/asset/image/user/password-off.png" alt="eye" id="c-password-toggle-img" /></button>
            </div>

          </div>

          <div class="c-button-group">
            <button id="accept" class="c-button c-button--primary c-button--md" style="width:120px">
              확인
            </button>

            <button id="cancel" class="c-button c-button--secondary c-button--md" style="width:120px">
              취소
            </button>
          </div>

        </form>

      </div>

    </div>

  </main>

<jsp:include page="/app/include/footer.jsp" />

</body>

</html>