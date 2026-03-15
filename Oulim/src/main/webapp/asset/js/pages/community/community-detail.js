// 작성 버튼
const commentPostBtn = document.querySelector(".c-comment-post-btn .c-button--primary");

const commentText = document.querySelector(".c-comment-textarea");
const recommendBtn = document.querySelector(".c-comment-post-btn .c-button--primary");

// 목록으로 돌아가기 버튼
const returnBtn = document.querySelector(".l-return-button .c-button");

const isLogin = true;
const userType = "USER";


const USER_TYPE = {
    ADMIN: "ADMIN",
    USER: "USER",
    COMPANY: "COMPANY"
};

commentPostBtn.addEventListener("click", (e) => {
    console.log("댓글 작성 버튼 클릭");
    if (!isLogin) {
        alert("로그인이 필요합니다.")

        // TODO : 로그인 페이지로 이동
        return;
    }

    if (userType !== USER_TYPE.USER) {
        alert("기업 회원 및 관리자는 사용할 수 없습니다.");
        return;
    }

    if (commentText.value.trim() === "") {
        alert("댓글 내용을 입력해주세요.");
        return;
    }
});

recommendBtn.addEventListener("click", (e) => {
    console.log("추천 버튼 클릭");
    if (!isLogin) {
        alert("로그인이 필요합니다.")

        // TODO : 로그인 페이지로 이동
        return;
    }

    if (userType !== USER_TYPE.USER) {
        alert("기업 회원 및 관리자는 사용할 수 없습니다.");
        return;
    }

    // TODO DB 비교 필요
});

returnBtn.addEventListener("click", (e) => {
  console.log("목록으로 돌아가기 버튼 클릭")
  location.href = "/Oulim/front/html/community/community-list.html";
});