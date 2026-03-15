const volunteerStartDate = document.querySelector("#volunteerStartDate");   // 봉사시작
const volunteerEndDate = document.querySelector("#volunteerEndDate");       // 봉사종료
const recruitStartDate = document.querySelector("#recruitStartDate");       // 모집시작
const recruitEndDate = document.querySelector("#recruitEndDate");           // 모집종료
const volunteerStartTime = document.querySelector("#volunteerStartTime");   // 봉사시작시간
const volunteerEndTime = document.querySelector("#volunteerEndTime");       // 봉사종료시간
const volunteerTarget = document.querySelector("#volunteerTarget");         // 봉사대상
const volunteerLocation = document.querySelector("#volunteerLocation");     // 봉사장소
const volunteerPoint = document.querySelector("#volunteerPoint");           // 획득포인트
const volunteerTitle = document.querySelector("#volunteerTitle");           // 봉사제목
const volunteerAge = document.querySelector("#volunteerAge");               // 연령대 선택
const volunteerCapacity = document.querySelector("#volunteerCapacity");     // 일자당 모집인원 선택
const volunteerCategory = document.querySelector("#volunteerCategory");     // 활동분야
const volunteerDetail = document.querySelector("#volunteerDetail");         // 봉사상세내용
const registerButton = document.querySelector("#registerButton");           // 작성버튼
const cancelButton = document.querySelector("#cancelButton");               // 취소버튼

const requiredFields = [
    volunteerStartDate,
    volunteerEndDate,
    volunteerStartTime,
    volunteerEndTime,
    recruitStartDate,
    recruitEndDate,
    volunteerAge,
    volunteerCapacity,
    volunteerCategory,
    volunteerTarget,
    volunteerLocation,
    volunteerPoint,
    volunteerTitle,
    volunteerDetail
];

// 필수값 검사
function isEmpty(field) {
    return !field.value || !field.value.trim();
}

// 날짜 범위 검사 함수
function validateDateRange(startInput, endInput) {
    const startValue = startInput.value;
    const endValue = endInput.value;

    if (!startValue || !endValue) {
        return true;
    }
    return startValue <= endValue;
}

// 시간 범위 검사 함수
function validateTimeRange(startInput, endInput) {
    const startValue = startInput.value;
    const endValue = endInput.value;

    if (!startValue || !endValue) {
        return true;
    }

    return startValue <= endValue;
}

// 오류 추가 함수
function showError(input){
    input.classList.add("is-error");
}

// 오류 삭제 함수
function clearError(input){
    input.classList.remove("is-error");
}

// 전체 오류 제거
function clearAllErrors() {
    requiredFields.forEach(field => {
        if (field) clearError(field);
    });
}

// 포인트 입력칸 숫자만 입력 가능
// 포인트 상한정해야함
volunteerPoint.addEventListener("input", (e) => {
  e.target.value = e.target.value.replace(/[^0-9]/g, "");
});

// 입력하면 바로 오류 제거
requiredFields.forEach(field => {
    field.addEventListener("input", () => {
        clearError(field);
    });

    field.addEventListener("change", () => {
        clearError(field);
    });
});

registerButton.addEventListener("click", (e) => {
    e.preventDefault();

    let isValid = true;
    let firstErrorField = null;

    clearAllErrors();

    // 필수값 검사
    requiredFields.forEach(field => {
        if (isEmpty(field)) {
            showError(field);
            if (!firstErrorField) {
                firstErrorField = field;
            }
            isValid = false;
        }
    });

    // 시간 검사
    if (!validateTimeRange(volunteerStartTime, volunteerEndTime)) {
        showError(volunteerStartTime);
        showError(volunteerEndTime);
        alert("봉사 시간을 다시 설정해주세요.");

        if (!firstErrorField) {
            firstErrorField = volunteerStartTime;
        }
        isValid = false;
    }

    // 날짜 검사 시작일 > 종료일
    if (!validateDateRange(volunteerStartDate, volunteerEndDate)) {
        showError(volunteerStartDate);
        showError(volunteerEndDate);
        alert("기간을 다시 설정해주세요.");
        if (!firstErrorField) {
            firstErrorField = volunteerStartDate;
        }
        isValid = false;
    }

    // 날짜 검사 모집 시작일 > 모집 종료일
    if (!validateDateRange(recruitStartDate, recruitEndDate)) {
        showError(recruitStartDate);
        showError(recruitEndDate);
        alert("기간을 다시 설정해주세요.");
        if (!firstErrorField) {
            firstErrorField = recruitStartDate;
        }
        isValid = false;
    }

    // 날짜 검사 모집 종료일 > 봉사 시작일
    if (recruitEndDate.value &&
        volunteerStartDate.value &&
        recruitEndDate.value > volunteerStartDate.value) {
        showError(recruitStartDate);
        showError(recruitEndDate);
        showError(volunteerStartDate);
        alert("기간을 다시 설정해주세요.");

        if (!firstErrorField) {
            firstErrorField = recruitEndDate;
        }
        isValid = false;
    }

    if (!isValid) {
        firstErrorField.focus();
        return;
    }

    alert("봉사 등록이 완료되었습니다.");
    location.href = "/Oulim/front/html/volunteer-management/volunteer-manage-list.html";
});

// 취소버튼 클릭시
cancelButton.addEventListener("click", () => {
  if (confirm("작성 중인 내용이 사라집니다. 취소하시겠습니까?")) {
    location.href = "/Oulim/front/html/volunteer-management/volunteer-manage-list.html";
  }
});
