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

nextBtn.addEventListener("click", function (e) {
  let hasError = false;

  companyNameError.textContent = "";
  userNameError.textContent = "";
  birthError.textContent = "";
  emailError.textContent = "";

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

  if (hasError) {
    e.preventDefault();
    alert("입력값을 확인해주세요.");
  }
});

// 첨부파일 작업
const fileBtn1 = document.getElementById("company-file-btn-1");
const fileInput1 = document.getElementById("company-file-1");
const fileName1 = document.getElementById("company-file-name-1");

const fileBtn2 = document.getElementById("company-file-btn-2");
const fileInput2 = document.getElementById("company-file-2");
const fileName2 = document.getElementById("company-file-name-2");

fileBtn1.addEventListener("click", function () {
  fileInput1.click();
});

fileInput1.addEventListener("change", function () {
  if (fileInput1.files.length > 0) {
    fileName1.value = fileInput1.files[0].name;
  }
});

fileBtn2.addEventListener("click", function () {
  fileInput2.click();
});

fileInput2.addEventListener("change", function () {
  if (fileInput2.files.length > 0) {
    fileName2.value = fileInput2.files[0].name;
  }
});