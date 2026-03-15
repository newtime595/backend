// 글 작성 본문
const postContent = document.querySelector(".c-textarea");
// 등록 버튼
const postBtn = document.querySelector(
  ".l-community-post-btn-group .c-button-group #post-button",
);

// 글 제목
const title = document.querySelector(".c-community-post-title .c-input");

// 취소 버튼
const cancelBtn = document.querySelector(
  ".l-community-post-btn-group .c-button-group #cancel-button",
);
// 이미지 첨부 input
const imageInput = document.querySelector("#imageInput");

const isLogin = true;
const userType = "USER";
const USER_TYPE = {
  ADMIN: "ADMIN",
  USER: "USER",
  COMPANY: "COMPANY",
};

postContent.addEventListener("input", () =>{
     clearError(field);
});

postContent.addEventListener("change", () => {
    clearError(field);
});

postBtn.addEventListener("click", (e) => {
  // 임시 처리 파트
  e.preventDefault();
  console.log("등록 버튼 클릭");
  if (!isLogin) {
    alert("로그인이 필요합니다.");

    // TODO : 로그인 페이지로 이동
    return;
  }

  if (userType !== USER_TYPE.USER) {
    alert("기업 회원 및 관리자는 사용할 수 없습니다.");
    return;
  }

  if (title.value.trim() === "") {
    alert("제목을 입력하세요.");
    // showError(title);
    return;
  }

  if (postContent.value.trim() === "") {
    alert("작성 내용이 없습니다.");
    // showError(postContent);
    return;
  }

  // servlet 부착 전이기에 목록으로 돌아가는 상태로 설정
  location.href = "/Oulim/front/html/community/community-list.html";
});

cancelBtn.addEventListener("click", (e) => {
  console.log("취소 버튼 클릭");
  location.href = "/Oulim/front/html/community/community-list.html";
});

// 오류 추가 함수
function showError(input){
    input.classList.add("c-form-field.is-error");
}

// 오류 삭제 함수
function clearError(input){
    input.classList.remove("c-form-field.is-error");
}

// 전체 오류 제거
function clearAllErrors() {
    requiredFields.forEach(field => {
        if (field) clearError(field);
    });
}
