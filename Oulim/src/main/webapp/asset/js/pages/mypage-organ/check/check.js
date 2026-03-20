const accept = document.getElementById("accept");
const cancel = document.getElementById("cancel");

const password = document.getElementsByName("password")[0];


accept.addEventListener('click', () => {

    if (password.value.trim() === "") {
        alert("비밀번호를 입력해주세요.");
    } else if (password.value.trim() === "1234") { // 비밀번호는 임의로 넣은 값, 나중에 DB에서 가져올 것
        alert("로그인 성공");
    };

    

});

cancel.addEventListener("click", () => {
    // location("../");
    alert("취소");
});

const pwBtn = document.getElementById("c-password-btn-toggle");
const pwToggleIcon = document.getElementById("c-password-toggle-img");

pwBtn.addEventListener("click", () => {
  if (password.type === "password") {
    password.type = "text";
    pwToggleIcon.src = "/Oulim/asset/image/user/password-on.png";
  } else {
    password.type = "password";
    pwToggleIcon.src = "/Oulim/asset/image/user/password-off.png";
  }
});

// 1. 입력 값이 없이 확인 버튼 클릭 시, alert > 입력해주세요.

// 2. 취소 버튼 누르면 history(-1);

// 3. 확인 버튼 클릭 > 비밀번호 불일치 시, 비밀번호가 일치하지 않습니다
// 비밀번호 검증 로직 필요? ex) 정규식



