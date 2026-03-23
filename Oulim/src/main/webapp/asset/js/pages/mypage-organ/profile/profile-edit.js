const emailForm = document.getElementById("emailUpdateForm");
const emailInput = document.getElementById("email");
const verifyInput = document.getElementById("verify");
const emailBtn = document.getElementById("emailBtn");

const pwForm = document.querySelector('form[action$="/mypage/updatePw.mp"]');
const newPasswordInput = document.getElementsByName("new-pw")[0];
const newPasswordCheckInput = document.getElementsByName("new-pw-check")[0];

const pwBtn = document.getElementById("c-password-btn-toggle");
const pwBtn2 = document.getElementById("c-password-btn-toggle-2");
const pwToggleIcon = document.getElementById("c-password-toggle-img");
const pwToggleIcon2 = document.getElementById("c-password-toggle-2-img");
const statusPw = document.getElementById("updatePwStatus");
const statusEmail = document.getElementById("updateEmailStatus");

if (statusPw && statusPw.value) {
  const status = statusPw.value;

  if (status === "success") {
    alert("비밀번호가 수정되었습니다.");
  } else if (status === "empty") {
    alert("새 비밀번호를 입력해주세요.");
  } else if (status === "mismatch") {
    alert("비밀번호가 일치하지 않습니다.");
  }

  history.replaceState(null, null, location.pathname);
}

if (statusEmail && statusEmail.value) {
  const emailStatus = statusEmail.value;

  if (emailStatus === "success") {
    alert("이메일이 수정되었습니다.");
  } else if (emailStatus === "empty") {
    alert("새 이메일을 입력해주세요.");
  } else if (emailStatus === "invalid") {
    alert("올바른 이메일 형식을 입력해주세요.");
  } else if (emailStatus === "verify-empty") {
    alert("인증번호를 입력해주세요.");
  } else if (emailStatus === "verify-fail") {
    alert("인증번호가 올바르지 않습니다.");
  }

  history.replaceState(null, null, location.pathname);
}

function getValue(element) {
  return element ? element.value.trim() : "";
}

function isValidEmail(email) {
  const emailRegex = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;
  return emailRegex.test(email);
}

function isValidPassword(password) {
  const passwordRegex =
    /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*()_\-+=\[\]{};:'",.<>/?\\|`~]).{8,20}$/;
  return passwordRegex.test(password);
}


if (emailBtn) {
  emailBtn.addEventListener("click", function () {
    const userEmail = getValue(emailInput);

    if (userEmail === "") {
      alert("이메일을 입력해주세요.");
      emailInput.focus();
      return;
    }

    if (!isValidEmail(userEmail)) {
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
      body: "userEmail=" + encodeURIComponent(userEmail)
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
      .catch(error => {
        console.error("메일 발송 오류:", error);
        alert("요청 처리 중 오류가 발생했습니다.");
      });
  });
}


if (emailForm) {
  emailForm.addEventListener("submit", function (e) {
    const userEmail = getValue(emailInput);
    const verifyCode = getValue(verifyInput);

    if (userEmail === "") {
      e.preventDefault();
      alert("이메일을 입력해주세요.");
      emailInput.focus();
      return;
    }

    if (!isValidEmail(userEmail)) {
      e.preventDefault();
      alert("올바른 이메일 형식을 입력해주세요.");
      emailInput.focus();
      return;
    }

    if (verifyCode === "") {
      e.preventDefault();
      alert("인증번호를 입력해주세요.");
      verifyInput.focus();
      return;
    }
  });
}

if (pwBtn && newPasswordInput && pwToggleIcon) {
  pwBtn.addEventListener("click", function () {
    if (newPasswordInput.type === "password") {
      newPasswordInput.type = "text";
      pwToggleIcon.src = contextPath + "/asset/image/user/password-on.png";
    } else {
      newPasswordInput.type = "password";
      pwToggleIcon.src = contextPath + "/asset/image/user/password-off.png";
    }
  });
}

if (pwBtn2 && newPasswordCheckInput && pwToggleIcon2) {
  pwBtn2.addEventListener("click", function () {
    if (newPasswordCheckInput.type === "password") {
      newPasswordCheckInput.type = "text";
      pwToggleIcon2.src = contextPath + "/asset/image/user/password-on.png";
    } else {
      newPasswordCheckInput.type = "password";
      pwToggleIcon2.src = contextPath + "/asset/image/user/password-off.png";
    }
  });
}

if (pwForm) {
  pwForm.addEventListener("submit", function (e) {
    const newPw = getValue(newPasswordInput);
    const newPwCheck = getValue(newPasswordCheckInput);

    if (newPw === "" && newPwCheck === "") {
      e.preventDefault();
      alert("새 비밀번호를 입력해주세요.");
      newPasswordInput.focus();
      return;
    }

    if (newPw === "") {
      e.preventDefault();
      alert("새 비밀번호를 입력해주세요.");
      newPasswordInput.focus();
      return;
    }

    if (newPwCheck === "") {
      e.preventDefault();
      alert("비밀번호 확인을 입력해주세요.");
      newPasswordCheckInput.focus();
      return;
    }

    if (!isValidPassword(newPw)) {
      e.preventDefault();
      alert("비밀번호는 8~20자이며 영문, 숫자, 특수문자를 모두 포함해야 합니다.");
      newPasswordInput.focus();
      return;
    }

    if (newPw !== newPwCheck) {
      e.preventDefault();
      alert("비밀번호가 일치하지 않습니다.");
      newPasswordCheckInput.focus();
      return;
    }
  });
}