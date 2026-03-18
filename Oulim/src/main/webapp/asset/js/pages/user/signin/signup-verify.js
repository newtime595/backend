const nameInput = document.getElementById("user-name");
const birthInput = document.getElementById("user-birth");
const emailInput = document.getElementById("user-email");
const phoneInput = document.getElementById("user-phone");

const nextBtn = document.getElementById("is-next-btn");
const emailCheckBtn = document.getElementById("email-check-btn");

const nameError = document.getElementById("is-user-name-error");
const birthError = document.getElementById("is-user-birth-error");
const emailError = document.getElementById("is-user-email-error");
const phoneError = document.getElementById("is-user-phone-error");

let isEmailChecked = false;
let isEmailAvailable = false;

emailInput.addEventListener("input", () => {
	isEmailChecked = false;
	isEmailAvailable = false;

	emailError.textContent = "";
	emailInput.classList.remove("is-error");
	emailError.classList.remove("is-success-text");
	emailError.classList.add("is-error-text");
});

emailCheckBtn.addEventListener("click", () => {
	const value = emailInput.value.trim();

	if (value === "") {
		emailError.textContent = "이메일을 입력해주세요.";
		emailInput.classList.add("is-error");
		emailInput.focus();

		isEmailChecked = false;
		isEmailAvailable = false;
		return;
	}

	fetch(`${contextPath}/user/checkOk.usr?type=email&value=${encodeURIComponent(value)}`)
		.then(res => res.text())
		.then(result => {
			console.log("이메일 응답 원본:", result);
			result = result.trim();
			console.log("이메일 응답 trim:", result);
			result = result.trim();

			if (result === "duplicated") {
				emailError.textContent = "이미 사용 중인 이메일입니다.";
				emailInput.classList.add("is-error");
				emailError.classList.remove("is-success-text");
				emailError.classList.add("is-error-text");

				isEmailChecked = true;
				isEmailAvailable = false;
			} else if (result === "available") {
				emailError.textContent = "사용 가능한 이메일입니다.";
				emailInput.classList.remove("is-error");
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

nextBtn.addEventListener("click", function(e) {
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
		if (!hasError) nameInput.focus();
		hasError = true;
	}

	if (birthInput.value.trim() === "") {
		birthError.textContent = "생년월일을 입력해주세요.";
		birthInput.classList.add("is-error");
		if (!hasError) birthInput.focus();
		hasError = true;
	}

	if (emailInput.value.trim() === "") {
		emailError.textContent = "이메일을 입력해주세요.";
		emailInput.classList.add("is-error");
		if (!hasError) emailInput.focus();
		hasError = true;
	} else if (!isEmailChecked) {
		emailError.textContent = "이메일 중복확인을 해주세요.";
		emailInput.classList.add("is-error");
		if (!hasError) emailInput.focus();
		hasError = true;
	} else if (!isEmailAvailable) {
		emailError.textContent = "이미 사용 중인 이메일입니다.";
		emailInput.classList.add("is-error");
		if (!hasError) emailInput.focus();
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