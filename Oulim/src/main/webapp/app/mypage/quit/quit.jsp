<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>quit</title>

  <!-- base css -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />

  <!-- component css -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/input.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/button.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/checkbox.css">

  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/mypage/quit/quit.css" />
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />

  <script defer src="${pageContext.request.contextPath}/asset/js/pages/mypage/quit/quit.js"></script>
</head>

<body>
<jsp:include page="/app/include/header.jsp" />
  <main class="l-main">

    <div class="main-container">

      <!-- aside -->
      <div class="main-aside">
        <aside>
          <div class="main-aside-list">

            <h2>마이페이지</h2>

            <ul class="list1">
              <li>나의 정보</li>
              <br>
              <a href="${pageContext.request.contextPath}/mypage/checkOk.mp">
                <li>- 내 정보 보기</li>
              </a>
              <br>
              <a href="${pageContext.request.contextPath}/mypage/userEdit.mp">
                <li>- 내 정보 수정</li>
              </a>
              <br>
            </ul>

            <ul class="list2">
              <li>봉사조회</li>
              <br>
              <a href="${pageContext.request.contextPath}/mypage/comingVolun.mp">
                <li>- 예정된 봉사 이력 조회</li>
              </a>
              <br>
              <a href="${pageContext.request.contextPath}/mypage/finishVolun.mp">
                <li>- 완료된 봉사 이력 조회</li>
              </a>

            </ul>

            <ul class="list3">
              <a href="${pageContext.request.contextPath}/mypage/point.mp">
                <li>포인트 조회</li>
              </a>
            </ul>

            <ul class="list4">
              <a href="${pageContext.request.contextPath}/mypage/myPost.mp">
                <li>작성글 조회</li>
              </a>
            </ul>

            <ul class="list5">
              <a href="${pageContext.request.contextPath}/mypage/quit.mp">
                <li>회원 탈퇴</li>
              </a>
            </ul>

          </div>
        </aside>
      </div>


      <!-- content -->
      <div class="main-2">

        <div class="main-text-box">
          <div class="m2-text-box-1">
            <h1>회원 탈퇴</h1>
          </div>
        </div>


        <!-- 탈퇴 약관 -->
        <div class="term">
          <fieldset>
            Lorem ipsum dolor sit amet consectetur adipisicing elit.
            Qui magnam fugit consectetur vitae nemo accusamus ullam
            beatae in molestias, ipsam expedita, obcaecati, cupiditate
            fugiat atque adipisci eaque eius.
            Lorem ipsum dolor sit amet consectetur adipisicing elit.
            Qui magnam fugit consectetur vitae nemo accusamus ullam
            beatae in molestias, ipsam expedita, obcaecati, cupiditate
            fugiat atque adipisci eaque eius.
            Lorem ipsum dolor sit amet consectetur adipisicing elit.
            Qui magnam fugit consectetur vitae nemo accusamus ullam
            beatae in molestias, ipsam expedita, obcaecati, cupiditate
            fugiat atque adipisci eaque eius.
            Lorem ipsum dolor sit amet consectetur adipisicing elit.
            Qui magnam fugit consectetur vitae nemo accusamus ullam
            beatae in molestias, ipsam expedita, obcaecati, cupiditate
            fugiat atque adipisci eaque eius.
            Lorem ipsum dolor sit amet consectetur adipisicing elit.
            Qui magnam fugit consectetur vitae nemo accusamus ullams
            beatae in molestias, ipsam expedita, obcaecati, cupiditate
            fugiat atque adipisci eaque eius.
          </fieldset>
        </div>


        <!-- 체크 -->
        <div class="chk-box">
          <label class="c-checkbox">
            <input type="checkbox">
            <span class="c-checkbox__box"></span>
            <span>
              <h5>탈퇴 약관을 읽고 이해하였으며, 이에 동의합니다.</h5>
            </span>
          </label>
        </div>



        <!-- 비밀번호 -->
        <form action="${pageContext.request.contextPath}/mypage/quitOk.mp" method="post">

          <div class="main-pw">

            <h5>비밀번호 입력</h5>

            <div class="pw-input">
              <input type="password" class="c-input" name="userPw" placeholder="비밀번호 입력" />
            </div>

          </div>


          <div class="c-button-group">
            <button id="accept" class="c-button c-button--primary c-button--md">
              탈퇴
            </button>

            <button id="cancel" class="c-button c-button--secondary c-button--md">
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