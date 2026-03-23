const form = document.getElementById("editForm");

const nicknameInput = document.getElementById("userNickname");
const emailInput = document.getElementById("userEmail");
const verifyInput = document.getElementById("authCode");
const newPasswordInput = document.getElementById("newPassword");
const confirmPasswordInput = document.getElementById("confirmPassword");

const checkNicknameBtn = document.getElementById("checkNickname");
const checkEmailBtn = document.getElementById("checkEmail");
const checkVerifyBtn = document.getElementById("checkVerify");

const nicknameError = document.getElementById("nicknameError");
const emailError = document.getElementById("emailError");
const verifyError = document.getElementById("verifyError");
const pwError = document.getElementById("pwError");
const confirmPwError = document.getElementById("confirmPwError");
const timerElement = document.getElementById("find-id-timer");

let timer;   
let time = 180;

function startTimer() {
  clearInterval(timer); 
  time = 180;

  timer = setInterval(() => {
    const minutes = Math.floor(time / 60);
    const seconds = time % 60;

    timerElement.textContent =
      minutes + ":" + (seconds < 10 ? "0" + seconds : seconds);

    time--;

    if (time < 0) {
      clearInterval(timer);
      timerElement.textContent = "00:00";
      alert("인증 시간이 만료되었습니다.");
    }
  }, 1000);
}

function isValidEmail(email) {
  const emailRegex = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
  return emailRegex.test(email);
}

function isValidPassword(password) {
  const passwordRegex =
    /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*()_\-+=\[{\]};:'",<.>/?\\|`~]).{8,}$/;
  return passwordRegex.test(password);
}

// 비밀번호 보기/숨기기 함수
function togglePassword(inputId, imgId) {
  const input = document.getElementById(inputId);
  const img = document.getElementById(imgId);

  if (!input || !img) return;

  if (input.type === "password") {
    input.type = "text";
    img.src = contextPath + "/asset/image/user/password-off.png";
  } else {
    input.type = "password";
    img.src = contextPath + "/asset/image/user/password-on.png";
  }
}

window.togglePassword = togglePassword;

// 닉네임 중복확인 예시
if (checkNicknameBtn) {
  checkNicknameBtn.addEventListener("click", function () {
    const nickname = nicknameInput.value.trim();

    if (nickname === "") {
      alert("닉네임을 입력해주세요.");
      nicknameInput.focus();
      return;
    }

    fetch(`${contextPath}/user/checkOk.usr?type=nickname&value=${encodeURIComponent(nickname)}`)
      .then(response => response.text())
      .then(result => {
        result = result.trim();

        if (result === "available") {
          alert("사용 가능한 닉네임입니다.");
        } else if (result === "duplicated") {
          alert("이미 사용 중인 닉네임입니다.");
          nicknameInput.focus();
        } else {
          alert("중복확인 중 오류가 발생했습니다.");
        }
      })
      .catch(error => {
        console.error("닉네임 중복확인 오류:", error);
        alert("서버 요청 중 오류가 발생했습니다.");
      });
  });
}

// 이메일 인증전송 예시
if (checkEmailBtn) {
  checkEmailBtn.addEventListener("click", function () {
    const email = emailInput.value.trim();

    if (email === "") {
      alert("이메일을 입력해주세요.");
      emailInput.focus();
      return;
    }

    if (!isValidEmail(email)) {
      alert("올바른 이메일 형식을 입력해주세요.");
      emailInput.focus();
      return;
    }

    console.log("요청 주소:", contextPath + "/mypage/sendUpdateEmail.mp");

    fetch(contextPath + "/mypage/sendUpdateEmail.mp", {
      method: "POST",
      headers: {
        "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
      },
      body: "userEmail=" + encodeURIComponent(email)
    })
      .then(response => {
        console.log("response status:", response.status);
        return response.text();
      })
      .then(result => {
        console.log("result:", result);
        result = result.trim();

        if (result === "success") {
          alert("인증번호를 이메일로 발송했습니다.");
		  startTimer();
        } else if (result === "duplicate") {
          alert("이미 사용 중인 이메일입니다.");
        } else if (result === "empty") {
          alert("이메일을 입력해주세요.");
        } else if (result === "fail") {
          alert("메일 발송에 실패했습니다.");
        } else {
          alert("인증메일 발송에 실패했습니다.");
        }
      })
  });
}

// 인증번호 확인 예시
if (checkVerifyBtn) {
  checkVerifyBtn.addEventListener("click", function () {
    const email = emailInput.value.trim();
    const authCode = verifyInput.value.trim();

    if (email === "") {
      alert("이메일을 입력해주세요.");
      emailInput.focus();
      return;
    }

    if (authCode === "") {
      alert("인증번호를 입력해주세요.");
      verifyInput.focus();
      return;
    }

	fetch(contextPath + "/mypage/verifyEmail.mp", {
	  method: "POST",
	  headers: {
	    "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
	  },
	  body: "userEmail=" + encodeURIComponent(email) + "&authCode=" + encodeURIComponent(authCode)
	})
	  .then(response => {
	    console.log("status:", response.status);
	    return response.text();
	  })
	  .then(result => {
	    console.log("서버 응답값:", result);
	    result = result.trim();

		if (result === "success") {
		  alert("이메일 인증이 완료되었습니다.");
		  clearInterval(timer);
		} else if (result === "emptyEmail") {
		  alert("이메일을 입력해주세요.");
		} else if (result === "emptyCode") {
		  alert("인증번호를 입력해주세요.");
		} else if (result === "expired") {
		  alert("인증번호가 만료되었거나 다시 인증이 필요합니다.");
		} else if (result === "differentEmail") {
		  alert("인증 요청한 이메일과 현재 입력한 이메일이 다릅니다.");
		} else if (result === "mismatch" || result === "fail") {
		  alert("인증번호가 일치하지 않습니다.");
		} else if (result === "loginRequired") {
		  alert("로그인이 필요합니다.");
		} else {
		  alert("알 수 없는 응답: " + result);
		}
	  })
	  .catch(error => {
	    console.error(error);
	    alert("요청 처리 중 오류가 발생했습니다.");
	  });
  });
}

function showError(element, message) {
  if (!element) return;
  element.textContent = message;
  element.style.display = "block";
}

function hideError(element) {
  if (!element) return;
  element.textContent = "";
  element.style.display = "none";
}

newPasswordInput.addEventListener("input", function () {
  const pw = newPasswordInput.value.trim();

  if (pw === "") {
    hideError(pwError);
    return;
  }

  if (!isValidPassword(pw)) {
    showError(pwError, "비밀번호는 영문, 숫자, 특수문자를 포함한 8자 이상이어야 합니다.");
    return;
  }

  hideError(pwError);
});

confirmPasswordInput.addEventListener("input", function () {
  const pw = newPasswordInput.value.trim();
  const confirmPw = confirmPasswordInput.value.trim();

  if (confirmPw === "") {
    hideError(confirmPwError);
    return;
  }

  if (pw !== confirmPw) {
    showError(confirmPwError, "비밀번호가 일치하지 않습니다.");
    return;
  }

  hideError(confirmPwError);
});

// 최종 제출 검사
if (form) {
  form.addEventListener("submit", function (e) {
    const nickname = nicknameInput.value.trim();
    const email = emailInput.value.trim();
    const newPassword = newPasswordInput.value.trim();
    const confirmPassword = confirmPasswordInput.value.trim();

    if (nickname === "") {
      alert("닉네임을 입력해주세요.");
      nicknameInput.focus();
      e.preventDefault();
      return;
    }

    if (email === "") {
      alert("이메일을 입력해주세요.");
      emailInput.focus();
      e.preventDefault();
      return;
    }

    if (!isValidEmail(email)) {
      alert("올바른 이메일 형식을 입력해주세요.");
      emailInput.focus();
      e.preventDefault();
      return;
    }

    if (newPassword !== "" || confirmPassword !== "") {
      if (!isValidPassword(newPassword)) {
        alert("비밀번호는 영문, 숫자, 특수문자를 포함한 8자 이상이어야 합니다.");
        newPasswordInput.focus();
        e.preventDefault();
        return;
      }

      if (confirmPassword === "") {
        alert("비밀번호 확인을 입력해주세요.");
        confirmPasswordInput.focus();
        e.preventDefault();
        return;
      }

      if (newPassword !== confirmPassword) {
        alert("비밀번호가 일치하지 않습니다.");
        confirmPasswordInput.focus();
        e.preventDefault();
        return;
      }
    }
  });
}