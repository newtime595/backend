<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>비밀번호 찾기</title>

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
      href="/Oulim/asset/css/pages/user/find-idpassword/password-find.css"
    />
    <script defer src="/Oulim/asset/js/pages/main/include.js"></script>
    <script
      defer
      src="/Oulim/asset/js/pages/user/find-idpassword/password-find.js"
    ></script>
  </head>

  <body>
    <div id="header"></div>
    <div class="l-main">
      <div class="l-container">
        <div class="p-password-find">
          <form action="/Oulim/front/html/user/find-idpassword/password-reset.html">
            <div class="l-password-find-layout">
              <div>
                <h2>비밀번호찾기</h2>
              </div>

              <div class="c-password-find-text">
                <h4>가입자의 본인확인을 진행합니다.</h4>
              </div>

              <div class="c-password-find-input">
                <h6>아이디</h6>
                <input
                  type="text"
                  name=""
                  id="find-user-id"
                  class="c-input"
                  placeholder="아이디 입력해주세요"
                />
                <p id="is-find-user-id-error" class="is-error-text"></p>
              </div>
              <div class="c-password-find-input">
                <h6>이름</h6>
                <input
                  type="text"
                  name=""
                  id="find-user-name"
                  class="c-input"
                  placeholder="이름 입력해주세요"
                />
                <p id="is-find-user-name-error" class="is-error-text"></p>
              </div>
              <div class="c-password-find-input">
                <h6>생년월일</h6>
                <input
                  type="text"
                  name=""
                  id="find-user-birth"
                  class="c-input"
                  placeholder="생년월일 입력해주세요"
                />
                <p id="is-find-user-birth-error" class="is-error-text"></p>
              </div>
              <div class="c-password-find-input">
                <h6>이메일</h6>
                <input
                  type="text"
                  name=""
                  id="find-user-email"
                  class="c-input"
                  placeholder="이메일 입력해주세요"
                />
                <p id="is-find-user-email-error" class="is-error-text"></p>
              </div>
              <div class="c-password-find-input-number">
                <h6>인증번호</h6>
                <div class="l-password-find-number-layout">
                  <div>
                    <input
                      type="text"
                      name=""
                      id=""
                      class="c-input"
                      placeholder="인증번호입력"
                    />
                    <div class="c-password-find-numbertime">3:00</div>
                  </div>
                  <div class="">
                    <button class="c-button c-button--secondary c-button--md">
                      인증확인
                    </button>
                  </div>
                </div>
              </div>
              <div class="c-password-find-nextbtn">
                <button
                  class="c-button c-button--primary c-button--md"
                  id="is-password-find-btn"
                >
                  비밀번호 찾기
                </button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
    <div id="footer"></div>
  </body>
</html>
