<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>기업 가입 완료</title>

    <!-- base css 필수 삽입-->
    <link rel="stylesheet" href="/Oulim/asset/css/core/reset.css" />
    <link rel="stylesheet" href="/Oulim/asset/css/core/variable.css" />
    <link rel="stylesheet" href="/Oulim/asset/css/core/Typography.css" />
    <!-- 컨포넌트 css 선택-->
    <link rel="stylesheet" href="/Oulim/asset/css/component/input.css" />
    <link rel="stylesheet" href="/Oulim/asset/css/component/button.css" />
    <link
      rel="stylesheet"
      href="/Oulim/asset/css/pages/user/signin/signup-complete-company.css"
    />

    <link
      rel="stylesheet"
      href="/Oulim/asset/css/pages/user/signin/signup-complete.css"
    />
    <script defer src="/Oulim/asset/js/pages/main/include.js"></script>
  </head>

  <body>
    <div id="header"></div>
    <div class="l-main">
      <div class="l-container">
        <form action="/Oulim/front/html/user/login/login.html">
          <div class="p-signup-complete-company">
            <div class="l-signup-complete-company-layout">
              <div><img src="" alt="확인이미지" /></div>
              <div class="l-signup-complete-company-title">
                <div><h3>회원가입이 완료 되었습니다.</h3></div>
                <div><h6>확인버튼 선택 시 메인 화면으로 이동합니다.</h6></div>
              </div>
            </div>
          </div>
          <div class="l-siginup-complete-company-textarea-layout">
            <div class="c-siginup-complete-company-text-left">
              <div><p>기관명</p></div>
              <div><p>이름</p></div>
              <div><p>생년월일</p></div>
              <div><p>아이디</p></div>
              <div><p>이메일</p></div>
            </div>
            <div class="c-siginup-complete-company-text-right">
              <div><p>대한적십시자</p></div>
              <div><p>홍김마리아</p></div>
              <div><p>977973</p></div>
              <div><p>gtwk1234</p></div>
              <div><p>kdtkdt12@naver.com</p></div>
            </div>
          </div>
          <div class="c-signup-complete-company">
            <button class="c-button c-button--primary c-button--md">
              다음
            </button>
          </div>
        </form>
      </div>
    </div>
    <div id="footer"></div>
  </body>
</html>
