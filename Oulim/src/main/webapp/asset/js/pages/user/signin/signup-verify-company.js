const companyName = document.getElementById("company-name");
const userName = document.getElementById("company-user-name");
const birth = document.getElementById("company-birth");
const email = document.getElementById("company-email");

const companyNameError = document.getElementById("is-company-name-error");
const userNameError = document.getElementById("is-company-user-name-error");
const birthError = document.getElementById("is-company-birth-error");
const emailError = document.getElementById("is-company-email-error");

const nextBtn = document.getElementById("is-company-next-btn");

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
