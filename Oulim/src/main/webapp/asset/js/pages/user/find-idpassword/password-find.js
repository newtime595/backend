const userId = document.getElementById("find-user-id");
const userName = document.getElementById("find-user-name");
const birth = document.getElementById("find-user-birth");
const email = document.getElementById("find-user-email");

const userIdError = document.getElementById("is-find-user-id-error");
const userNameError = document.getElementById("is-find-user-name-error");
const birthError = document.getElementById("is-find-user-birth-error");
const emailError = document.getElementById("is-find-user-email-error");

const findBtn = document.getElementById("is-password-find-btn");

findBtn.addEventListener("click", function (e) {
  let hasError = false;

  userIdError.textContent = "";
  userNameError.textContent = "";
  birthError.textContent = "";
  emailError.textContent = "";


  userId.classList.remove("is-error");
  userName.classList.remove("is-error");
  birth.classList.remove("is-error");
  email.classList.remove("is-error");

  if (userId.value.trim() === "") {
    userIdError.textContent = "아이디를 입력해주세요.";
    userId.classList.add("is-error");
    if (!hasError) userId.focus();
    hasError = true;
  }

  if (userName.value.trim() === "") {
    userNameError.textContent = "이름을 입력해주세요.";
    userName.classList.add("is-error");
    if (!hasError) userName.focus();
    hasError = true;
  }

  if (birth.value.trim() === "") {
    birthError.textContent = "생년월일을 입력해주세요.";
    birth.classList.add("is-error");
    if (!hasError) birth.focus();
    hasError = true;
  }

  if (email.value.trim() === "") {
    emailError.textContent = "이메일을 입력해주세요.";
    email.classList.add("is-error");
    if (!hasError) email.focus();
    hasError = true;
  }

  if (hasError) {
    e.preventDefault();
    alert("입력값을 확인해주세요.");
  }
});