const userName = document.getElementById("find-id-user-name");
const birth = document.getElementById("find-id-user-birth");
const email = document.getElementById("find-id-user-email");
const verify = document.getElementById("find-id-verify");

const userNameError = document.getElementById("is-find-id-user-name-error");
const birthError = document.getElementById("is-find-id-user-birth-error");
const emailError = document.getElementById("is-find-id-user-email-error");

const errorMessage = document.getElementById("find-id-error-message");
const findBtn = document.getElementById("is-id-find-btn");
const emailBtn = document.getElementById("find-id-email-btn");
const verifyBtn = document.getElementById("find-id-verify-btn");
const timerDisplay = document.getElementById("find-id-timer");
let timerInterval = null;
let remainingTime = 180;

function startTimer() {
  clearInterval(timerInterval); 

  remainingTime = 180; 
  updateTimer();

  timerInterval = setInterval(function () {
    remainingTime--;

    updateTimer();

    if (remainingTime <= 0) {
      clearInterval(timerInterval);
      alert("인증시간이 만료되었습니다.");
    }
  }, 1000);
}

function updateTimer() {
  const min = Math.floor(remainingTime / 60);
  const sec = remainingTime % 60;

  timerDisplay.textContent =
    min + ":" + String(sec).padStart(2, "0");
}

function getValue(element) {
  return element ? element.value.trim() : "";
}

function isValidEmail(emailValue) {
  const emailRegex = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
  return emailRegex.test(emailValue);
}

if (errorMessage && errorMessage.value.trim() !== "") {
  alert(errorMessage.value);
}

/* 이메일 인증번호 전송 */
if (emailBtn) {
  emailBtn.addEventListener("click", function () {
    const userEmail = getValue(email);

    emailError.textContent = "";
    email.classList.remove("is-error");

    if (userEmail === "") {
      emailError.textContent = "이메일을 입력해주세요.";
      email.classList.add("is-error");
      email.focus();
      alert("이메일을 입력해주세요.");
      return;
    }

    if (!isValidEmail(userEmail)) {
      emailError.textContent = "올바른 이메일 형식을 입력해주세요.";
      email.classList.add("is-error");
      email.focus();
      alert("올바른 이메일 형식을 입력해주세요.");
      return;
    }
	
	console.log("emailBtn:", emailBtn);
	console.log("verifyBtn:", verifyBtn);
	console.log("contextPath:", contextPath);
	
	
	fetch(contextPath + "/user/sendFindEmailAuthCode.usr", {
	  method: "POST",
	  headers: {
	    "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
	  },
	  body: "userEmail=" + encodeURIComponent(userEmail)
	})
	  .then(response => {
	    console.log("status:", response.status);
	    console.log("url:", response.url);
	    return response.text();
	  })
	  .then(result => {
	    result = result.trim();

	    if (result === "success") {
	      alert("인증번호를 이메일로 발송했습니다.");
		  startTimer();
	    } else if (result === "empty") {
	      alert("이메일을 입력해주세요.");
	    } else if (result === "fail") {
	      alert("메일 발송에 실패했습니다.");
	    } else if (result === "duplicate") {
	      alert("이미 가입된 이메일입니다.");
	    } else {
	      alert("인증메일 발송에 실패했습니다.");
	    }
	  })
	  .catch(error => {
	    console.error("메일 발송 오류:", error);
	    alert("요청 처리 중 오류가 발생했습니다.");
	  });
  });
}

/* 인증확인 버튼 */
let isEmailVerified = false;

if (verifyBtn) {
  verifyBtn.addEventListener("click", function () {
    const userEmail = getValue(email);
    const verifyCode = getValue(verify);

    if (userEmail === "") {
      alert("이메일을 입력해주세요.");
      email.focus();
      return;
    }

    if (!isValidEmail(userEmail)) {
      alert("올바른 이메일 형식을 입력해주세요.");
      email.focus();
      return;
    }

    if (verifyCode === "") {
      alert("인증번호를 입력해주세요.");
      verify.focus();
      return;
    }

    fetch(contextPath + "/user/verifyEmailAuthCode.usr", {
      method: "POST",
      headers: {
        "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
      },
      body:
        "userEmail=" + encodeURIComponent(userEmail) +
        "&authCode=" + encodeURIComponent(verifyCode)
    })
      .then(response => response.text())
      .then(result => {
        result = result.trim();
        console.log("인증확인 응답:", result);

        if (result === "success") {
          isEmailVerified = true;
          alert("인증되었습니다.");
          clearInterval(timerInterval);
        } else if (result === "expired") {
          isEmailVerified = false;
          alert("인증시간이 만료되었습니다. 다시 인증번호를 받아주세요.");
        } else {
          isEmailVerified = false;
          alert("인증번호가 올바르지 않습니다.");
        }
      })
      .catch(error => {
        console.error("인증확인 오류:", error);
        alert("인증 처리 중 오류가 발생했습니다.");
      });
  });
}

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
  } else if (!isValidEmail(email.value.trim())) {
    emailError.textContent = "올바른 이메일 형식을 입력해주세요.";
    email.classList.add("is-error");
    if (!hasError) email.focus();
    hasError = true;
  }

  if (!isEmailVerified) {
    e.preventDefault();
    alert("이메일 인증을 완료해주세요.");
    return;
  }

  if (hasError) {
    e.preventDefault();
    alert("입력값을 확인해주세요.");
  }
});