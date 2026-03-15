const isLogin = true;
const userType = "USER";
const USER_TYPE = {
    ADMIN: "ADMIN",
    USER: "USER",
    COMPANY: "COMPANY"
};
// 글 제목
const title = document.querySelector(".c-community-repost-title .c-input");

// 글 작성 본문
const postContent = document.querySelector(".c-textarea");

// 수정버튼
const repostRepostBtn = document.querySelector("#repost-button");
const cancelBtn = document.querySelector("#cancel-button");

repostRepostBtn.addEventListener("click",(e) => {
    console.log("등록 버튼 클릭");
    // 임시로 submit 막기
    e.preventDefault();
    if (!isLogin) {
        alert("로그인이 필요합니다.")

        // TODO : 로그인 페이지로 이동
        return;
    }

    if (userType !== USER_TYPE.USER) {
        alert("기업 회원 및 관리자는 사용할 수 없습니다.");
        return;
    }

    if(title.value.trim() === ""){
        alert("제목을 입력해주세요.")
        return;
    }

    if(postContent.value.trim() === ""){
        alert("작성 내용이 없습니다.");
        return;
    }

    if(imageInput.length > 1){
        alert("이미지 첨부는 하나만 가능합니다.");
        return;
    }

    const result = confirm("수정하시겠습니까?");
    if(result)
    {
        alert("수정되었습니다.");
        location.href="/Oulim/front/html/mypage/community-history/myposts.html";
    }
});

cancelBtn.addEventListener("click", (e) =>{
    location.href="/Oulim/front/html/mypage/community-history/myposts.html";
});