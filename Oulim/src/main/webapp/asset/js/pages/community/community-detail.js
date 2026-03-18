// 작성 버튼
const commentPostBtn = document.querySelector(".c-comment-post-btn .c-button--primary");

const commentText = document.querySelector(".c-comment-textarea");
const recommendBtn = document.querySelector("#recommendBtn");

// 목록으로 돌아가기 버튼
const returnBtn = document.querySelector(".l-return-button .c-button");

const USER_TYPE = {
	ADMIN: 0,
	USER: 1,
	COMPANY: 2
};

commentPostBtn.addEventListener("click", (e) => {
	console.log("댓글 작성 버튼 클릭");
	if (!isLogin) {
		alert("로그인이 필요합니다.")

		location.href = `${contextPath}/user/login.usr`
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

recommendBtn.addEventListener("click", async (e) => {
	console.log("추천 버튼 클릭");
	if (!isLogin) {
		alert("로그인이 필요합니다.")
		location.href = `${contextPath}/user/login.usr`
		return;
	}

	if (userType !== USER_TYPE.USER) {
		alert("기업 회원 및 관리자는 사용할 수 없습니다.");
		return;
	}

	let result = confirm("추천하시겠습니까?");
	if (result) {
		try {
			const res = await fetch(`${contextPath}/community/like.commu?postNo=${encodeURIComponent(postNo)}&userNo=${encodeURIComponent(loginUserNo)}`, {
				method: "POST",
				headers: { "X-Requested-With": "fetch" },
			});
			if (!res.ok) {
				throw new Error("추천 요청 실패")
			}
			
			const data = await res.json();
			if(data.success){
				console.log("추천 성공")
			}else{
				alert("추천할 수 없었습니다.");
			}		
		} catch (err) {
			console.error("게시글 추천 실패 : ", err);
			alert("게시글 추천에 실패했습니다");
		}
		location.reload();
	}
});

returnBtn.addEventListener("click", (e) => {
	console.log("목록으로 돌아가기 버튼 클릭")
	location.href = `${contextPath}/community/list.commu`;;
});

