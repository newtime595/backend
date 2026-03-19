const nameInput = document.getElementById("user-name");
const birthInput = document.getElementById("user-birth");
const phoneInput = document.getElementById("user-phone");
const nextBtn = document.getElementById("is-next-btn");
const nameError = document.getElementById("is-user-name-error");
const birthError = document.getElementById("is-user-birth-error");
const emailError = document.getElementById("is-user-email-error");
const phoneError = document.getElementById("is-user-phone-error");

let isEmailChecked = false;
let isEmailAvailable = false;
const companyEmail = document.getElementById("company-email");
const companyEmailCheckBtn = document.getElementById("company-email-check-btn");
const companyEmailAuthCode = document.getElementById("company-email-auth-code");
const companyEmailAuthConfirmBtn = document.getElementById("company-email-auth-confirm-btn");
const companyEmailVerified = document.getElementById("company-email-verified");
const companyEmailError = document.getElementById("is-company-email-error");
const companyEmailAuthError = document.getElementById("is-company-email-auth-error");
const companyNextBtn = document.getElementById("is-company-next-btn");
const companyForm = document.querySelector("form");

let emailTimerInterval;

function startEmailTimer(seconds) {
  clearInterval(emailTimerInterval);

  const timerEl = document.getElementById("company-email-timer");
  let remain = seconds;

  emailTimerInterval = setInterval(() => {
    const min = Math.floor(remain / 60);
    const sec = String(remain % 60).padStart(2, "0");
    timerEl.textContent = min + ":" + sec;

    if (remain <= 0) {
      clearInterval(emailTimerInterval);
      timerEl.textContent = "0:00";
    }

    remain--;
  }, 1000);
}

companyEmailCheckBtn.addEventListener("click", function () {
  const email = companyEmail.value.trim();

  companyEmailError.textContent = "";
  companyEmailAuthError.textContent = "";
  companyEmailVerified.value = "false";

  if (email === "") {
    companyEmailError.textContent = "이메일을 입력해주세요.";
    return;
  }

  fetch(contextPath + "/user/sendEmailAuthCode.usr", {
    method: "POST",
    headers: {
      "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
    },
    body: "userEmail=" + encodeURIComponent(email)
  })
    .then(response => response.text())
    .then(result => {
      if (result === "duplicate") {
        companyEmailError.textContent = "이미 사용중인 이메일입니다.";
      } else if (result === "success") {
        alert("인증번호를 이메일로 발송했습니다.");
        startEmailTimer(180);
      } else {
        companyEmailError.textContent = "인증메일 발송에 실패했습니다.";
      }
    })
    .catch(error => {
      console.error(error);
      companyEmailError.textContent = "요청 처리 중 오류가 발생했습니다.";
    });
});

companyEmailAuthConfirmBtn.addEventListener("click", function () {
  const email = companyEmail.value.trim();
  const authCode = companyEmailAuthCode.value.trim();

  companyEmailAuthError.textContent = "";

  if (authCode === "") {
    companyEmailAuthError.textContent = "인증번호를 입력해주세요.";
    return;
  }

  fetch(contextPath + "/user/verifyEmailAuthCode.usr", {
    method: "POST",
    headers: {
      "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
    },
    body:
      "userEmail=" + encodeURIComponent(email) +
      "&authCode=" + encodeURIComponent(authCode)
  })
    .then(response => response.text())
    .then(result => {
      if (result === "success") {
        alert("이메일 인증이 완료되었습니다.");
        companyEmailVerified.value = "true";
        companyEmailAuthError.textContent = "";
      } else if (result === "expired") {
        companyEmailAuthError.textContent = "인증시간이 만료되었습니다.";
        companyEmailVerified.value = "false";
      } else {
        companyEmailAuthError.textContent = "인증번호가 올바르지 않습니다.";
        companyEmailVerified.value = "false";
      }
    })
    .catch(error => {
      console.error(error);
      companyEmailAuthError.textContent = "요청 처리 중 오류가 발생했습니다.";
      companyEmailVerified.value = "false";
    });
});

companyForm.addEventListener("submit", function (e) {
  if (companyEmailVerified.value !== "true") {
    e.preventDefault();
    companyEmailAuthError.textContent = "이메일 인증을 완료해주세요.";
  }
});



nextBtn.addEventListener("click", function(e) {
	let hasError = false;

	nameError.textContent = "";
	birthError.textContent = "";
	phoneError.textContent = "";

	nameInput.classList.remove("is-error");
	birthInput.classList.remove("is-error");
	phoneInput.classList.remove("is-error");

	if (nameInput.value.trim() === "") {
		nameError.textContent = "이름을 입력해주세요.";
		nameInput.classList.add("is-error");
		if (!hasError) nameInput.focus();
		hasError = true;
	}

	if (birthInput.value.trim() === "") {
		birthError.textContent = "생년월일을 입력해주세요.";
		birthInput.classList.add("is-error");
		if (!hasError) birthInput.focus();
		hasError = true;
	}

	if (phoneInput.value.trim() === "") {
		phoneError.textContent = "휴대전화번호를 입력해주세요.";
		phoneInput.classList.add("is-error");
		if (!hasError) phoneInput.focus();
		hasError = true;
	}

	if (hasError) {
		e.preventDefault();
		alert("입력값을 확인해주세요.");
	}
});