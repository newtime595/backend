<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>기업 회원가입 추가정보</title>

    <!-- base css 필수 삽입-->
    <link rel="stylesheet" href="/Oulim/asset/css/core/reset.css" />
    <link rel="stylesheet" href="/Oulim/asset/css/core/variable.css" />
    <link rel="stylesheet" href="/Oulim/asset/css/core/Typography.css" />
    <!-- 컨포넌트 css 선택-->
    <link rel="stylesheet" href="/Oulim/asset/css/component/input.css" />
    <link rel="stylesheet" href="/Oulim/asset/css/component/button.css" />
    <link rel="stylesheet" href="/Oulim/asset/css/core/layout.css" />

    <link
      rel="stylesheet"
      href="/Oulim/asset/css/pages/user/signin/signup-info-company.css"
    />
    <script defer src="/Oulim/asset/js/pages/main/include.js"></script>
    <script
      defer
      src="/Oulim/asset/js/pages/user/signin/signup-info-company.js"
    ></script>
  </head>

  <body>
    <div id="header"></div>
    <div class="l-main">
      <div class="l-container">
        <form action="/Oulim/front/html/user/signin/signup-complete-company.html">
          <div class="p-signup-info-company">
            <div class="l-signup-info-company-layout">
              <div>
                <h2>회원가입</h2>
              </div>
              <div class="c-signup-info-company-text">
                <h4>가입하실 아이디와 비밀번호를 작성해 주세요.</h4>
              </div>
              <div>
                <h6>아이디</h6>
                <div class="l-signup-info-company-input-layout">
                  <div>
                    <input
                      type="text"
                      name=""
                      id="company-user-id"
                      class="c-input"
                      placeholder="아이디 입력"
                    />
                    <p id="is-company-user-id-error" class="is-error-text"></p>
                  </div>
                  <div class="c-signup-company-btn">
                    <button
                      type="button"
                      class="c-button c-button--secondary c-button--md"
                    >
                      중복확인
                    </button>
                  </div>
                </div>
              </div>
              <div class="c-signup-info-company-input-number">
                <h6>비밀번호</h6>
                <div class="l-toggle-layout">
                <input
                  type="password"
                  name=""
                  id="company-user-password"
                  class="c-input"
                />
                <button type="button" id="c-password-btn-toggle"><img src="/Oulim/asset/image/user/password-off.png" alt="eye" id="c-password-toggle-img" /></button>
                </div>
                <p
                  id="is-company-user-password-error"
                  class="is-error-text"
                ></p>
              </div>
              <div class="c-signup-info-company-input-number">
                <h6>비밀번호확인</h6>
                <div class="l-toggle-layout-2">
                <input
                  type="password"
                  name=""
                  id="company-user-password-check"
                  class="c-input"
                />
                <button type="button" id="c-password-btn-toggle-2"><img src="/Oulim/asset/image/user/password-off.png" alt="eye" id="c-password-toggle-img-2" /></button>
                </div>
                <p
                  id="is-company-user-password-check-error"
                  class="is-error-text"
                ></p>
              </div>
              <div class="c-signup-info-company-nextbtn">
                <button
                  
                  class="c-button c-button--primary c-button--md"
                  id="is-company-signup-btn"
                >
                  회원가입
                </button>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
    <div id="footer"></div>
  </body>
</html>
