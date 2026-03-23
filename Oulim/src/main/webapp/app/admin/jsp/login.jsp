<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>로그인</title>
    <!-- base css -->
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/asset/css/core/reset.css"
    />
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/asset/css/core/variable.css"
    />
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/asset/css/core/Typography.css"
    />
    <!-- component css -->
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/asset/css/component/input.css"
    />
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/asset/css/component/button.css"
    />
    <!-- page css -->
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/app/admin/css/login.css"
    />
    <script
      defer
      src="${pageContext.request.contextPath}/app/admin/js/login.js"
    ></script>
  </head>
  <body>
    <main class="l-main">
      <div class="l-login-layout">
        <h1>
          어울림에<br />
          오신것을 환영합니다.
        </h1>
        <!-- 로그인 폼 -->
        <form action="${pageContext.request.contextPath}/admin/loginOk.adm" method="POST">
          <!-- 아이디 -->
          <div class="l-login-input-layout">
            <label for="adminId">아이디</label>
            <input
              id="adminId"
              class="c-input"
              name="adminId"
              placeholder="사번 또는 이메일을 입력하세요"
            />
          </div>
          <!-- 비밀번호 -->
          <div class="l-login-input-layout">
            <label for="adminPw">비밀번호</label>
            <div class="pw-box-layout">
              <input
                id="adminPw"
                type="password"
                class="c-input"
                name="adminPw"
                placeholder="비밀번호를 입력하세요"
              />
              <button type="button" id="c-password-btn-toggle">
                <img
                  src="${pageContext.request.contextPath}/asset/image/user/password-off.png"
                  alt="eye"
                  id="c-password-toggle-img"
                />
              </button>
            </div>
          </div>
			<div id="is-user-login-error" class="login-error"
			     style="${not empty loginError ? 'display:block;' : 'display:none;'}">
			  <span id="error-text">${loginError}</span>
			</div>
          <!-- 로그인 버튼 -->
          <button class="c-button c-button--primary c-button--md" type="submit">
            로그인
          </button>
        </form>
        <div class="login-help">
          로그인 관련 문의는 admin@leadpop.co.kr로 연락해 주세요.
        </div>
      </div>
    </main>
  </body>
</html>
