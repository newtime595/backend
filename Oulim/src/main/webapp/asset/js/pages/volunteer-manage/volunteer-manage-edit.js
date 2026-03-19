const form = document.querySelector("form");

const volunActProcBegin = document.querySelector("#volunActProcBegin");       // 봉사 시작일
const volunActProcEnd = document.querySelector("#volunActProcEnd");           // 봉사 종료일
const volunActRecruBegin = document.querySelector("#volunActRecruBegin");     // 모집 시작일
const volunActRecruEnd = document.querySelector("#volunActRecruEnd");         // 모집 종료일

const volunActBeginTime = document.querySelector("#volunActBeginTime");       // 봉사 시작 시간
const volunActEndTime = document.querySelector("#volunActEndTime");           // 봉사 종료 시간

const volunActAgeGroup = document.querySelector("#volunActAgeGroup");         // 연령대
const volunActRecruMaxCount = document.querySelector("#volunActRecruMaxCount"); // 모집 인원
const volunActActType = document.querySelector("#volunActActType");           // 활동 분야

const volunActAddress = document.querySelector("#volunActAddress");           // 봉사 장소
const volunActPoint = document.querySelector("#volunActPoint");               // 포인트
const volunActTitle = document.querySelector("#volunActTitle");               // 제목
const volunActDetail = document.querySelector("#volunActDetail");             // 내용

const cancelButton = document.querySelector("#cancelButton");

function isEmpty(element) {
	return !element.value || !element.value.trim();
}

function parseDate(value) {
	return new Date(value + "T00:00:00");
}

function diffDays(startDate, endDate) {
	const diff = endDate.getTime() - startDate.getTime();
	return Math.floor(diff / (1000 * 60 * 60 * 24));
}

function isNumber(value) {
	return /^[0-9]+$/.test(value);
}

function isValidHour(value) {
	return /^(0|[1-9]|1[0-9]|2[0-3])$/.test(value);
}

form.addEventListener("submit", function (e) {

	// 1. 필수값 검사
	if (isEmpty(volunActProcBegin)) {
		alert("봉사 시작일을 선택해주세요.");
		volunActProcBegin.focus();
		e.preventDefault();
		return;
	}

	if (isEmpty(volunActProcEnd)) {
		alert("봉사 종료일을 선택해주세요.");
		volunActProcEnd.focus();
		e.preventDefault();
		return;
	}

	if (isEmpty(volunActRecruBegin)) {
		alert("모집 시작일을 선택해주세요.");
		volunActRecruBegin.focus();
		e.preventDefault();
		return;
	}

	if (isEmpty(volunActRecruEnd)) {
		alert("모집 종료일을 선택해주세요.");
		volunActRecruEnd.focus();
		e.preventDefault();
		return;
	}

	if (isEmpty(volunActBeginTime)) {
		alert("봉사 시작 시간을 입력해주세요.");
		volunActBeginTime.focus();
		e.preventDefault();
		return;
	}

	if (isEmpty(volunActEndTime)) {
		alert("봉사 종료 시간을 입력해주세요.");
		volunActEndTime.focus();
		e.preventDefault();
		return;
	}

	if (volunActAgeGroup.value === "") {
		alert("봉사자 연령을 선택해주세요.");
		volunActAgeGroup.focus();
		e.preventDefault();
		return;
	}

	if (volunActRecruMaxCount.value === "") {
		alert("일자당 모집 인원을 선택해주세요.");
		volunActRecruMaxCount.focus();
		e.preventDefault();
		return;
	}

	if (volunActActType.value === "") {
		alert("활동분야를 선택해주세요.");
		volunActActType.focus();
		e.preventDefault();
		return;
	}

	if (isEmpty(volunActAddress)) {
		alert("봉사 장소를 입력해주세요.");
		volunActAddress.focus();
		e.preventDefault();
		return;
	}

	if (isEmpty(volunActPoint)) {
		alert("포인트를 입력해주세요.");
		volunActPoint.focus();
		e.preventDefault();
		return;
	}

	if (isEmpty(volunActTitle)) {
		alert("봉사 제목을 입력해주세요.");
		volunActTitle.focus();
		e.preventDefault();
		return;
	}

	if (isEmpty(volunActDetail)) {
		alert("봉사 상세 내용을 입력해주세요.");
		volunActDetail.focus();
		e.preventDefault();
		return;
	}

	// 2. 포인트 숫자만
	if (!isNumber(volunActPoint.value.trim())) {
		alert("포인트는 숫자만 입력 가능합니다.");
		volunActPoint.focus();
		e.preventDefault();
		return;
	}

	// 3. 시간 형식 검사 (0~23)
	if (!isValidHour(volunActBeginTime.value.trim())) {
		alert("봉사 시작 시간은 0~23 사이 숫자로 입력해주세요.");
		volunActBeginTime.focus();
		e.preventDefault();
		return;
	}

	if (!isValidHour(volunActEndTime.value.trim())) {
		alert("봉사 종료 시간은 0~23 사이 숫자로 입력해주세요.");
		volunActEndTime.focus();
		e.preventDefault();
		return;
	}

	const beginTime = Number(volunActBeginTime.value.trim());
	const endTime = Number(volunActEndTime.value.trim());

	// 4. 봉사시간 시작 > 종료 불가
	if (beginTime > endTime) {
		alert("봉사 시작 시간은 종료 시간보다 클 수 없습니다.");
		volunActBeginTime.focus();
		e.preventDefault();
		return;
	}

	if (beginTime === endTime) {
		alert("봉사 시작 시간과 종료 시간은 같을 수 없습니다.");
		volunActBeginTime.focus();
		e.preventDefault();
		return;
	}

	const procBegin = parseDate(volunActProcBegin.value);
	const procEnd = parseDate(volunActProcEnd.value);
	const recruBegin = parseDate(volunActRecruBegin.value);
	const recruEnd = parseDate(volunActRecruEnd.value);

	// 5. 각 기간 시작일 > 종료일 불가
	if (procBegin > procEnd) {
		alert("봉사 시작일은 종료일보다 늦을 수 없습니다.");
		volunActProcBegin.focus();
		e.preventDefault();
		return;
	}

	if (recruBegin > recruEnd) {
		alert("모집 시작일은 종료일보다 늦을 수 없습니다.");
		volunActRecruBegin.focus();
		e.preventDefault();
		return;
	}

	// 6. 모집 기간 최대 30일
	if (diffDays(recruBegin, recruEnd) > 30) {
		alert("모집 기간은 시작일로부터 최대 30일까지 가능합니다.");
		volunActRecruEnd.focus();
		e.preventDefault();
		return;
	}

	// 7. 봉사 기간 최대 7일
	if (diffDays(procBegin, procEnd) > 7) {
		alert("봉사 기간은 시작일로부터 최대 7일까지 가능합니다.");
		volunActProcEnd.focus();
		e.preventDefault();
		return;
	}

	// 8. 모집 기간 안에 봉사 기간 포함 불가
	// 모집 종료일 이후에 봉사 시작해야 함
	if (procBegin <= recruEnd) {
		alert("모집 기간과 봉사 기간은 겹칠 수 없습니다. 봉사 기간은 모집 종료 후로 설정해주세요.");
		volunActProcBegin.focus();
		e.preventDefault();
		return;
	}

	// 9. 일자당 모집 인원 최대 30명
	if (Number(volunActRecruMaxCount.value) > 30) {
		alert("일자당 모집 인원은 최대 30명까지 가능합니다.");
		volunActRecruMaxCount.focus();
		e.preventDefault();
		return;
	}
});

// 취소 버튼
cancelButton.addEventListener("click", function () {
	history.back();
});