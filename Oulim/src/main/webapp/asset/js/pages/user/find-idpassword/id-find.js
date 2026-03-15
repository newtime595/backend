const userName = document.getElementById("find-id-user-name");
const birth = document.getElementById("find-id-user-birth");
const email = document.getElementById("find-id-user-email");

const userNameError = document.getElementById("is-find-id-user-name-error");
const birthError = document.getElementById("is-find-id-user-birth-error");
const emailError = document.getElementById("is-find-id-user-email-error");

const findBtn = document.getElementById("is-id-find-btn");

findBtn.addEventListener("click", function (e) {
  let hasError = false;

  userNameError.textContent = "";
  birthError.textContent = "";
  emailError.textContent = "";

  userName.classList.remove("is-error");
  birth.classList.remove("is-error");
  email.classList.remove("is-error");

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
