const password = document.getElementById("reset-password");
const passwordCheck = document.getElementById("reset-password-check");

const resetBtn = document.getElementById("is-reset-btn");

resetBtn.addEventListener("click", function (e) {
  let hasError = false;

  passwordError.textContent = "";
  passwordCheckError.textContent = "";

  password.classList.remove("is-error");
  passwordCheck.classList.remove("is-error");

  if (password.value.trim() === "") {
    passwordError.textContent = "비밀번호를 입력해주세요.";
    password.classList.add("is-error");
    if (!hasError) password.focus();
    hasError = true;
  }

  if (passwordCheck.value.trim() === "") {
    passwordCheckError.textContent = "비밀번호 확인을 입력해주세요.";
    passwordCheck.classList.add("is-error");
    if (!hasError) passwordCheck.focus();
    hasError = true;
  }

  if (
    password.value.trim() !== "" &&
    passwordCheck.value.trim() !== "" &&
    password.value !== passwordCheck.value
  ) {
    passwordCheckError.textContent = "비밀번호가 일치하지 않습니다.";
    passwordCheck.classList.add("is-error");
    if (!hasError) passwordCheck.focus();
    hasError = true;
  }
  
  if (hasError) {
    e.preventDefault();
    alert("입력값을 확인해주세요.");
  }
});


// 토글
const userPw = document.getElementById("reset-password");
const pwBtn = document.getElementById("c-password-btn-toggle");
const pwToggleIcon = document.getElementById("c-password-toggle-img");

pwBtn.addEventListener("click", () => {
  if (userPw.type === "password") {
    userPw.type = "text";
    pwToggleIcon.src = contextPath + "/asset/image/user/password-off.png";
  } else {
    userPw.type = "password";
    pwToggleIcon.src = contextPath + "/asset/image/user/password-on.png";
  }
});

// 토글2
const userPw2 = document.getElementById("reset-password-check");
const pwBtn2 = document.getElementById("c-password-btn-toggle-2");
const pwToggleIcon2 = document.getElementById("c-password-toggle-img-2");

pwBtn2.addEventListener("click", () => {
  if (userPw2.type === "password") {
    userPw2.type = "text";
    pwToggleIcon2.src = contextPath + "/asset/image/user/password-off.png";
  } else {
    userPw2.type = "password";
    pwToggleIcon2.src = contextPath + "/asset/image/user/password-on.png";
  }
});