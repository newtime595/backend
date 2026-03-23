const toggleBtn = document.getElementById("c-password-btn-toggle");
const pwEye = document.getElementById("c-password-toggle-img");
const loginForm = document.querySelector("form");
const adminId = document.getElementById("adminId");
const adminPw = document.getElementById("adminPw");
const errorBox = document.getElementById("is-user-login-error");

toggleBtn.addEventListener("click", function () {
  if (adminPw.type === "password") {
    adminPw.type = "text";
    pwEye.src = "/Oulim/asset/image/user/password-on.png";
  } else {
    adminPw.type = "password";
    pwEye.src = "/Oulim/asset/image/user/password-off.png";
  }
});

loginForm.addEventListener("submit", function (e) {
  let message = "";

  if (adminId.value.trim() === "") {
    message = "아이디를 입력하세요";
  } else if (adminPw.value.trim() === "") {
    message = "비밀번호를 입력하세요";
  }

  if (message !== "") {
    e.preventDefault();
    errorBox.textContent = message;
    errorBox.style.display = "block";
    return;
  }

  errorBox.style.display = "none";
});

adminId.addEventListener("input", function () {
  errorBox.style.display = "none";
});

adminPw.addEventListener("input", function () {
  errorBox.style.display = "none";
});