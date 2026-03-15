// 봉사후기 카드
const communityPost = document.querySelectorAll(".c-list__body a");
// 글쓰기 버튼
const postBtn = document.querySelector(".c-community-post-btn .c-button");

const isLogin = true;
const userType = "USER";


const USER_TYPE = {
    ADMIN : "ADMIN",
    USER : "USER",
    COMPANY : "COMPANY"
};

communityPost.forEach((post) => {
    post.addEventListener("click", (e) =>{
        console.log("게시글 클릭");
    });
});

postBtn.addEventListener("click", (e) =>{

        console.log("글쓰기 버튼 클릭")
        if(!isLogin){
            alert("로그인이 필요합니다.")

            // TODO : 로그인 페이지로 이동
            return;
        }
        
        if(userType !== USER_TYPE.USER ){
            alert("기업 회원 및 관리자는 사용할 수 없습니다.");
            return;
        }

        location.href="/Oulim/front/html/community/community-post.html";
});