const companyName = document.getElementById("company-name");
const userName = document.getElementById("company-user-name");
const birth = document.getElementById("company-birth");
const email = document.getElementById("company-email");

const companyNameError = document.getElementById("is-company-name-error");
const userNameError = document.getElementById("is-company-user-name-error");
const birthError = document.getElementById("is-company-birth-error");
const emailError = document.getElementById("is-company-email-error");

const nextBtn = document.getElementById("is-company-next-btn");
const emailCheckBtn = document.getElementById("company-email-check-btn");

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
const form = document.querySelector("form");

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

email.addEventListener("input", () => {
  isEmailChecked = false;
  isEmailAvailable = false;

  emailError.textContent = "";
  email.classList.remove("is-error");
  emailError.classList.remove("is-success-text");
  emailError.classList.add("is-error-text");
});

emailCheckBtn.addEventListener("click", () => {
  const value = email.value.trim();

  if (value === "") {
    emailError.textContent = "이메일을 입력해주세요.";
    email.classList.add("is-error");
    emailError.classList.remove("is-success-text");
    emailError.classList.add("is-error-text");
    email.focus();

    isEmailChecked = false;
    isEmailAvailable = false;
    return;
  }

  fetch(`${contextPath}/user/checkOk.usr?type=email&value=${encodeURIComponent(value)}`)
    .then(res => res.text())
    .then(result => {
      result = result.trim();

      if (result === "duplicated") {
        emailError.textContent = "이미 사용 중인 이메일입니다.";
        email.classList.add("is-error");
        emailError.classList.remove("is-success-text");
        emailError.classList.add("is-error-text");

        isEmailChecked = true;
        isEmailAvailable = false;
      } else if (result === "available") {
        emailError.textContent = "사용 가능한 이메일입니다.";
        email.classList.remove("is-error");
        emailError.classList.remove("is-error-text");
        emailError.classList.add("is-success-text");

        isEmailChecked = true;
        isEmailAvailable = true;
      } else {
        emailError.textContent = "중복확인 중 오류가 발생했습니다.";
        emailError.classList.remove("is-success-text");
        emailError.classList.add("is-error-text");

        isEmailChecked = false;
        isEmailAvailable = false;
      }
    })
    .catch(() => {
      emailError.textContent = "서버 요청 중 오류가 발생했습니다.";
      emailError.classList.remove("is-success-text");
      emailError.classList.add("is-error-text");

      isEmailChecked = false;
      isEmailAvailable = false;
    });
});

companyForm.addEventListener("submit", function (e) {
  let hasError = false;

  companyNameError.textContent = "";
  userNameError.textContent = "";
  birthError.textContent = "";
  emailError.textContent = "";
  companyEmailAuthError.textContent = "";

  companyName.classList.remove("is-error");
  userName.classList.remove("is-error");
  birth.classList.remove("is-error");
  email.classList.remove("is-error");

  if (companyName.value.trim() === "") {
    companyNameError.textContent = "기관명을 입력해주세요.";
    companyName.classList.add("is-error");
    if (!hasError) companyName.focus();
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
  } else if (!isEmailChecked) {
    emailError.textContent = "이메일 중복확인을 해주세요.";
    email.classList.add("is-error");
    if (!hasError) email.focus();
    hasError = true;
  } else if (!isEmailAvailable) {
    emailError.textContent = "이미 사용 중인 이메일입니다.";
    email.classList.add("is-error");
    if (!hasError) email.focus();
    hasError = true;
  }

  if (companyEmailVerified.value !== "true") {
    companyEmailAuthError.textContent = "이메일 인증을 완료해주세요.";
    if (!hasError) companyEmailAuthCode.focus();
    hasError = true;
  }

  const fileInput = document.getElementById("company-file-1");
  const file = fileInput.files[0];

  if (!file) {
    alert("파일을 첨부해주세요.");
    hasError = true;
  } else if (file.type !== "application/pdf") {
    alert("PDF 파일만 업로드 가능합니다.");
    hasError = true;
  }

  if (hasError) {
    e.preventDefault();
  }
});

// 첨부파일 작업
const fileBtn1 = document.getElementById("company-file-btn-1");
const fileInput1 = document.getElementById("company-file-1");
const fileName1 = document.getElementById("company-file-name-1");

fileBtn1.addEventListener("click", function () {
  fileInput1.click();
});

fileInput1.addEventListener("change", function () {
  if (fileInput1.files.length > 0) {
    fileName1.value = fileInput1.files[0].name;
  }
});

form.addEventListener("submit", function (e) {
  const fileInput = document.getElementById("company-file-1");
  const file = fileInput.files[0];
 
  if (!file) {
    alert("파일을 첨부해주세요.");
    e.preventDefault();
    return;
  }

  if (file.type !== "application/pdf") {
    alert("PDF 파일만 업로드 가능합니다.");
    e.preventDefault();
    return;
  }
});

