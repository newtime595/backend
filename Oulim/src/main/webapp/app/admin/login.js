const pwInput = document.getElementById("userPw");
// const pwToggle = document.querySelector(".pw-toggle");
const pwEye = document.getElementById("c-password-toggle-img");
// const pwEye = document.querySelector("c-password-toggle-img");

const loginForm = document.querySelector("form");
const userName = document.getElementById("userName");
const userPw = document.getElementById("userPw");

const errorBox = document.getElementById("is-user-login-error");
const errorText = errorBox.querySelector("span");


// const loginButton = document.getElementsByClassName(".c-button");

// 비밀번호 입력 확인 온 오프
pwEye.addEventListener("click", function(){

  if (userPw.type === "password") {
    userPw.type = "text";
    pwEye.src = "/Oulim/asset/image/user/password-on.png";
  } else {
    userPw.type = "password";
    pwEye.src = "/Oulim/asset/image/user/password-off.png";
  }
});


// 로그인 정보 채우지 않을시 경고 메세지

loginForm.addEventListener("submit", function(e){

  let message = "";
  if (userName.value.trim() === "") {
    message = "아이디를 입력하세요"

  } else if (userPw.value.trim() === "") {
    message = "비밀번호를 입력하세요"

  }

  if (message !== "") {
    e.preventDefault();
    errorText.textContent = message;
    errorBox.style.display = "block";
    errorText.style.color = "red";

  }
});

// 입력시 경고 메세지 사라짐
userName.addEventListener("input", function(){

  errorBox.style.display = "none";
});



// loginButton.addEventListener("click", function(){

//   location.href="/Oulim/admin/html/dashboard/dashboard.html";
// });