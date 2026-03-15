const nameInput = document.getElementById("user-name");
const birthInput = document.getElementById("user-birth");
const emailInput = document.getElementById("user-email");
const phoneInput = document.getElementById("user-phone");

const nextBtn = document.getElementById("is-next-btn");

const nameError = document.getElementById("is-user-name-error");
const birthError = document.getElementById("is-user-birth-error");
const emailError = document.getElementById("is-user-email-error");
const phoneError = document.getElementById("is-user-phone-error");

nextBtn.addEventListener("click", function (e) {
  let hasError = false;

  nameError.textContent = "";
  birthError.textContent = "";
  emailError.textContent = "";
  phoneError.textContent = "";

  nameInput.classList.remove("is-error");
  birthInput.classList.remove("is-error");
  emailInput.classList.remove("is-error");
  phoneInput.classList.remove("is-error");

  if (nameInput.value.trim() === "") {
    nameError.textContent = "이름을 입력해주세요.";
    nameInput.classList.add("is-error");
    if (!hasError) {
      nameInput.focus();
    }
    hasError = true;
  }

  if (birthInput.value.trim() === "") {
    birthError.textContent = "생년월일을 입력해주세요.";
    birthInput.classList.add("is-error");
    if (!hasError) {
      birthInput.focus();
    }
    hasError = true;
  }

  if (emailInput.value.trim() === "") {
    emailError.textContent = "이메일을 입력해주세요.";
    emailInput.classList.add("is-error");
    if (!hasError) {
      emailInput.focus();
    }
    hasError = true;
  }

  if (phoneInput.value.trim() === "") {
    phoneError.textContent = "휴대전화번호를 입력해주세요.";
    phoneInput.classList.add("is-error");
    if (!hasError) {
      phoneInput.focus();
    }
    hasError = true;
  }

  if (hasError) {
    e.preventDefault();
    alert("입력값을 확인해주세요.");
  }
});