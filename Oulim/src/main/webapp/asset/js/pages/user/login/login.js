const form = document.getElementById("loginForm");
const idInput = document.getElementById("userID");
const pwInput = document.getElementById("userPw");

const idError = document.getElementById("userIDError");
const pwError = document.getElementById("userPwError");

form.addEventListener("submit", function (e) {
  let hasError = false;

  idError.textContent = "";
  pwError.textContent = "";

  idInput.classList.remove("is-error");
  pwInput.classList.remove("is-error");

  if (idInput.value.trim() === "") {
    idError.textContent = "아이디를 입력해주세요.";
    idInput.classList.add("is-error");

    if (!hasError) {
      idInput.focus();
    }
    hasError = true;
  }

  if (pwInput.value.trim() === "") {
    pwError.textContent = "비밀번호를 입력해주세요.";
    pwInput.classList.add("is-error");

    if (!hasError) {
      pwInput.focus();
    }
    hasError = true;
  }

  if (hasError) {
    e.preventDefault();
    alert("입력값을 확인해주세요.");
  }
});

// 토글
const userPw = document.getElementById("userPw");
const pwBtn = document.getElementById("c-password-btn-toggle");
const pwToggleIcon = document.getElementById("c-password-toggle-img");

pwBtn.addEventListener("click", () => {
  if (userPw.type === "password") {
    userPw.type = "text";
    pwToggleIcon.src = "/Oulim/asset/image/user/password-on.png";
  } else {
    userPw.type = "password";
    pwToggleIcon.src = "/Oulim/asset/image/user/password-off.png";
  }
});