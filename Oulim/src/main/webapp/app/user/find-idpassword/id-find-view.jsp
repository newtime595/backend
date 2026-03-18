<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>id 현황</title>

    <!-- base css 필수 삽입-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />
    <!-- 컨포넌트 css 선택-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/input.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/button.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/layout.css" />

    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/asset/css/pages/user/find-idpassword/id-find-view.css"
    />
   <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
   <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />
  </head>
	
  <body>
    <jsp:include page="/app/include/header.jsp" />
    <div class="l-main">
      <div class="l-container">
        <div class="p-id-find-view">
          <form action="${pageContext.request.contextPath}/user/passwordFind.usr" method="get">
            <div class="l-id-find-view-layout">
              <div>
                <h2>아이디 현황</h2>
              </div>

              <div class="c-id-find-view-text">
                <h4>가입자의 아이디</h4>
              </div>

              <div class="l-id-find-view-info-layout">
                <div>
                  <div><p>아이디</p></div>
                </div>

                <div>
                  <div><p>${userId}</p></div>
                </div>
              </div>

              <div class="c-id-find-view-nextbtn">
                <button type="button" class="c-button c-button--primary c-button--md"
                onclick="location.href='${pageContext.request.contextPath}/user/pwFind.usr'">
                  비밀번호 찾기
                </button>
                <button type="button" class="c-button c-button--secondary c-button--md"
      			onclick="location.href='${pageContext.request.contextPath}/user/login.usr'">
                  로그인 페이지 이동하기
                </button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
    <jsp:include page="/app/include/footer.jsp" />
  </body>
</html>
