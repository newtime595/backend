const password = document.getElementById("reset-password");
const passwordCheck = document.getElementById("reset-password-check");

const passwordError = document.getElementById("is-password-error");
const passwordCheckError = document.getElementById("is-password-check-error");

const resetBtn = document.getElementById("is-reset-btn");

function isValidPassword(pw) {
  const regex = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,20}$/;
  return regex.test(pw);
}

resetBtn.addEventListener("click", function (e) {
  let hasError = false;

  passwordError.textContent = "";
  passwordCheckError.textContent = "";

  password.classList.remove("is-error");
  passwordCheck.classList.remove("is-error");

  // 1. 비밀번호 입력 체크
  if (password.value.trim() === "") {
    passwordError.textContent = "비밀번호를 입력해주세요.";
    password.classList.add("is-error");
    if (!hasError) password.focus();
    hasError = true;
  }

  // 2. 정규식 체크
  if (password.value.trim() !== "" && !isValidPassword(password.value)) {
    passwordError.textContent =
      "비밀번호는 8자 이상, 영문/숫자/특수문자를 포함해야 합니다.";
    password.classList.add("is-error");
    if (!hasError) password.focus();
    hasError = true;
  }

  // 3. 확인 입력 체크
  if (passwordCheck.value.trim() === "") {
    passwordCheckError.textContent = "비밀번호 확인을 입력해주세요.";
    passwordCheck.classList.add("is-error");
    if (!hasError) passwordCheck.focus();
    hasError = true;
  }

  // 4. 일치 여부
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