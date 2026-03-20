// 작성 버튼
const commentPostBtn = document.querySelector(".c-comment-post-btn .c-button--primary");

const recommendBtn = document.querySelector("#recommendBtn");

// 목록으로 돌아가기 버튼
const returnBtn = document.querySelector(".l-return-button .c-button");

const USER_TYPE = {
	ADMIN: 0,
	USER: 1,
	COMPANY: 2
};
document.addEventListener("DOMContentLoaded", ()=>{
	commentPostBtn.addEventListener("click", async (e) => {
		const commentText = document.querySelector("#commentContent").value;
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

		if (commentText.trim() === "") {
			alert("댓글 내용을 입력해주세요.");
			return;
		}
		
		try{
			const res = await fetch(`${contextPath}/community/commentPost.commu`,{
				method : "POST",
				headers : {
					 "X-Requested-With": "fetch" ,
				 	"Content-type" : "application/x-www-form-urlencoded" },
					body : `postNo=${postNo}&content=${encodeURIComponent(commentText)}`
			});		
			
			const data = await res.json();
			if(!data.success){
				alert("댓글 작성이 실패했습니다.");		
				return;			
			}
		}catch(err){
			console.error("댓글 작성 실패");
			alert("댓글 작성을 실패했습니다");
		}
		location.reload();
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

	document.addEventListener("click", async(e) =>{
//		const pageLink = e.target.closest("#commentPagination a[data-page]");
		const pageLink = e.target.closest("#commentPagination a");
		console.log(pageLink);
		if(!pageLink) return;
		
		e.preventDefault();
				
		const page = Number(pageLink.dataset.page);
		console.log(page);
		await loadComments(page);
	});
	
})


async function loadComments(page){
	try{
		const res = await fetch(`${contextPath}/community/comment.commu?postNo=${postNo}&page=${page}`,{
			headers: {
			  "X-Requested-With": "fetch"
			}
		});
		
		const data = await res.json();
		renderComments(data.commentList);
		renderCommentPagination(data.page, data.startPage, data.endPage, data.prev, data.next);
	}catch(err){
		console.error("댓글 페이지 조회 실패", err);
	}
}

function renderComments(commentList) {
  const commentWrap = document.querySelector("#commentList");
  const paginationWrap = document.querySelector("#commentPagination");

  if (!commentList || commentList.length === 0) {
    commentWrap.innerHTML = "";
	
	//pagination 숨김
	  paginationWrap.style.display = "none";
	  return;
  }
  console.log(commentList.length);
  
  paginationWrap.style.display = "flex";

  commentWrap.innerHTML = commentList.map(comment => `
    <div class="comment-item">
      <div class="comment-author">${comment.userNickname}</div>
      <div class="comment-content">${comment.commentContent}</div>
      <div class="comment-date">${comment.postDate}</div>
    </div>
  `).join("");
}

function renderCommentPagination(page, startPage, endPage, prev, next) {
  const pagingWrap = document.querySelector("#commentPagination");
  let html = "";

  if (startPage === 1 && endPage === 1) {
    pagingWrap.style.display = "none";
    return;
  }

  if (prev) {
    html += `<a href="#" class="c-pagination__link" data-page="${startPage - 1}">&lt;</a>`;
  } else {
    html += `<a href="#" class="c-pagination__link is-disabled" onclick="return false;">&lt;</a>`;
  }

  for (let i = startPage; i <= endPage; i++) {
    html += `
      <a href="#"
         class="c-pagination__link ${i === page ? "is-active" : ""}"
         data-page="${i}">
         ${i}
      </a>
    `;
  }

  if (next) {
    html += `<a href="#" class="c-pagination__link" data-page="${endPage + 1}">&gt;</a>`;
  } else {
    html += `<a href="#" class="c-pagination__link is-disabled" onclick="return false;">&gt;</a>`;
  }

  pagingWrap.innerHTML = html;
}