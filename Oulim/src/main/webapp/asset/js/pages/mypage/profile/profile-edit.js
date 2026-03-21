// 1. 닉네임 중복확인
// 2. 이메일 중복확인
// 3. 인증 완료 > 필드 에러 출력 
// 4. 비밀번호 조건 검사 > 일정 자리수 이상, 정규식 검사
// 5. 주소검색 > api 사용
// 6. 저장 > 수정이 완료되었습니다
// 수정된 값이 없으면 그냥 현재 상태 유지

// const nickname = document.getElementsByName("nickname")[0];
const nickname = document.getElementById("nickname");
const nicknameContainer = document.getElementsByClassName("i-nickname")[0];
const email = document.getElementById("email");
const emailContainer = document.getElementsByClassName("i-email")[0];
const verify = document.getElementById("verify");
const newPassword = document.getElementsByName("new-password")[0];
const passwordChk = document.getElementsByName("new-password-check")[0];


const exist1 = document.getElementsByClassName("c-button c-button--primary c-button--md")[0];
const exist2 = document.getElementsByClassName("c-button c-button--primary c-button--md")[2];
const verifyBtn = document.getElementsByClassName("c-button c-button--primary c-button--md")[4];

const nicknameError = document.getElementsByClassName("c-form-field is-error")[0];
const emailError = document.getElementsByClassName("c-form-field is-error")[1];
const verifyError = document.getElementsByClassName("c-form-field is-error")[2];

const accept = document.getElementById("accept");
const cancel = document.getElementById("cancel");


exist1.addEventListener("click", () => { // 닉네임 검사


   if (nickname.value.trim() === "") {
      alert("비었음");
   } else if (nickname.value.trim() === "wnstmd") {

      nicknameContainer.style.display = "none";
      nicknameError.style.display = "block";
   };

});

exist2.addEventListener("click", () => { // 이메일 검사

   if (email.value.trim() === "") {
      alert("비었음");
   } else if (email.value.trim() === "wnstmd@naver.com") {
      emailContainer.style.display = "none";
      emailError.style.display = "block";
   };

});

verifyBtn.addEventListener("click", () => { // 인증번호 검사

   if (verify.value.trim() === "") {
      alert("인증번호가 발송되었습니다.");
   } else if (verify.value.trim() === "1234") {
      alert("인증성공");
   };
});



accept.addEventListener("click", () => {

   alert("수정 완료");



});

cancel.addEventListener("click", () => {
   // location("../");
   alert("취소");
});

const pwBtn = document.getElementById("c-password-btn-toggle");
const pwBtn2 = document.getElementById("c-password-btn-toggle-2")
const pwToggleIcon = document.getElementById("c-password-toggle-img");
const pwToggleIcon2 = document.getElementById("c-password-toggle-2-img");

pwBtn.addEventListener("click", (e) => {
   e.preventDefault();
   if (newPassword.type === "password") {
      newPassword.type = "text";
      pwToggleIcon.src = contextPath + "/asset/image/user/password-on.png";
   } else {
      newPassword.type = "password";
      pwToggleIcon.src = contextPath + "/asset/image/user/password-off.png";
   }
});

pwBtn2.addEventListener("click", (e) => {
   e.preventDefault();
   if (passwordChk.type === "password") {
      passwordChk.type = "text";
      pwToggleIcon2.src = contextPath + "/asset/image/user/password-on.png";
   } else {
      passwordChk.type = "password";
      pwToggleIcon2.src = contextPath + "/asset/image/user/password-off.png";
   }
});