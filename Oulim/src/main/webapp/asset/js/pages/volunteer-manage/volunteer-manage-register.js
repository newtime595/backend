const form = document.querySelector("#registerForm");

const volunActRecruBegin = document.querySelector("#volunActRecruBegin");
const volunActRecruEnd = document.querySelector("#volunActRecruEnd");
const volunActProcBegin = document.querySelector("#volunActProcBegin");
const volunActProcEnd = document.querySelector("#volunActProcEnd");
const volunActBeginTime = document.querySelector("#volunActBeginTime");
const volunActEndTime = document.querySelector("#volunActEndTime");
const volunActAgeGroup = document.querySelector("#volunActAgeGroup");
const volunActActType = document.querySelector("#volunActActType");
const volunActAddress = document.querySelector("#volunActAddress");
const volunActPoint = document.querySelector("#volunActPoint");
const volunActTitle = document.querySelector("#volunActTitle");
const volunActDetail = document.querySelector("#volunActDetail");
const registerButton = document.querySelector("#registerButton");

function isEmpty(field) {
	return !field.value || !field.value.trim();
}

function parseDate(value) {
	return new Date(value + "T00:00:00");
}

function diffDays(start, end) {
	const ms = end.getTime() - start.getTime();
	return Math.floor(ms / (1000 * 60 * 60 * 24));
}

// 숫자만 입력
[volunActPoint, volunActBeginTime, volunActEndTime].forEach((input) => {
	input.addEventListener("input", (e) => {
		e.target.value = e.target.value.replace(/[^0-9]/g, "");
	});
});

registerButton.addEventListener("click", (e) => {
	e.preventDefault();

	if (isEmpty(volunActRecruBegin)) {
		alert("모집 시작일을 입력해주세요.");
		volunActRecruBegin.focus();
		return;
	}

	if (isEmpty(volunActRecruEnd)) {
		alert("모집 종료일을 입력해주세요.");
		volunActRecruEnd.focus();
		return;
	}

	if (isEmpty(volunActProcBegin)) {
		alert("봉사 시작일을 입력해주세요.");
		volunActProcBegin.focus();
		return;
	}

	if (isEmpty(volunActProcEnd)) {
		alert("봉사 종료일을 입력해주세요.");
		volunActProcEnd.focus();
		return;
	}

	if (isEmpty(volunActBeginTime)) {
		alert("봉사 시작 시간을 입력해주세요.");
		volunActBeginTime.focus();
		return;
	}

	if (isEmpty(volunActEndTime)) {
		alert("봉사 종료 시간을 입력해주세요.");
		volunActEndTime.focus();
		return;
	}

	if (isEmpty(volunActAgeGroup)) {
		alert("봉사자 연령을 선택해주세요.");
		volunActAgeGroup.focus();
		return;
	}

	if (isEmpty(volunActActType)) {
		alert("활동분야를 선택해주세요.");
		volunActActType.focus();
		return;
	}

	if (isEmpty(volunActAddress)) {
		alert("봉사 장소를 입력해주세요.");
		volunActAddress.focus();
		return;
	}

	if (isEmpty(volunActPoint)) {
		alert("포인트를 입력해주세요.");
		volunActPoint.focus();
		return;
	}

	if (isEmpty(volunActTitle)) {
		alert("봉사 제목을 입력해주세요.");
		volunActTitle.focus();
		return;
	}

	if (isEmpty(volunActDetail)) {
		alert("봉사 상세 내용을 입력해주세요.");
		volunActDetail.focus();
		return;
	}

	const recruBeginDate = parseDate(volunActRecruBegin.value);
	const recruEndDate = parseDate(volunActRecruEnd.value);
	const procBeginDate = parseDate(volunActProcBegin.value);
	const procEndDate = parseDate(volunActProcEnd.value);

	if (recruBeginDate > recruEndDate) {
		alert("모집기간을 다시 설정해주세요.");
		volunActRecruBegin.focus();
		return;
	}

	if (procBeginDate > procEndDate) {
		alert("봉사기간을 다시 설정해주세요.");
		volunActProcBegin.focus();
		return;
	}

	if (diffDays(recruBeginDate, recruEndDate) > 30) {
		alert("모집 기간은 시작일로부터 최대 30일까지 가능합니다.");
		volunActRecruBegin.focus();
		return;
	}

	if (diffDays(procBeginDate, procEndDate) > 7) {
		alert("봉사 기간은 시작일로부터 최대 7일까지 가능합니다.");
		volunActProcBegin.focus();
		return;
	}

	if (recruEndDate >= procBeginDate) {
		alert("모집 기간에 봉사기간이 포함될 수 없습니다.");
		volunActRecruEnd.focus();
		return;
	}

	if (Number(volunActBeginTime.value) >= Number(volunActEndTime.value)) {
		alert("봉사 시간을 다시 설정해주세요.");
		volunActBeginTime.focus();
		return;
	}

	if (Number(volunActPoint.value) <= 0) {
		alert("포인트를 입력해주세요.");
		volunActPoint.focus();
		return;
	}

	form.submit();
});