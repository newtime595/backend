// 글 작성 본문
const postContent = document.querySelector(".c-textarea");
// 등록 버튼
const postBtn = document.querySelector(
	".l-community-post-btn-group .c-button-group #post-button",
);
const fileNameInput = document.querySelector(".c-community-post-file-name");
// 파일 요소
const fileInput = document.getElementById('file');
const fileList = document.querySelector('.file-list');
const writeForm = document.getElementById('write-form');
const cntElement = document.querySelector('.cnt');

// 글 제목
const title = document.querySelector(".c-community-post-title .c-input");

// 취소 버튼
const cancelBtn = document.querySelector(
	".l-community-post-btn-group .c-button-group #cancel-button",
)

const isLogin = true;
const userType = "USER";
const USER_TYPE = {
	ADMIN: "ADMIN",
	USER: "USER",
	COMPANY: "COMPANY",
};

postContent.addEventListener("input", () => {
	clearError(postContent);
});

postContent.addEventListener("change", () => {
	clearError(postContent);
});

postBtn.addEventListener("click", (e) => {
	// 임시 처리 파트
	console.log("등록 버튼 클릭");
	if (!isLogin) {
		alert("로그인이 필요합니다.");
		e.preventDefault();

		// TODO : 로그인 페이지로 이동
		window.location.href = `${contextPath}/user/login.usr`
		return;
	}

	if (userType !== USER_TYPE.USER) {
		e.preventDefault();
		alert("기업 회원 및 관리자는 사용할 수 없습니다.");
		return;
	}

	if (title.value.trim() === "") {
		e.preventDefault();
		alert("제목을 입력하세요.");
		// showError(title);
		return;
	}

	if (postContent.value.trim() === "") {
		e.preventDefault();
		alert("작성 내용이 없습니다.");
		// showError(postContent);
		return;
	}
});

cancelBtn.addEventListener("click", (e) => {
	console.log("취소 버튼 클릭");
	window.location.href = `${contextPath}/community/list.commu`;
});

// 오류 추가 함수
function showError(input) {
	input.classList.add("c-form-field.is-error");
}

// 오류 삭제 함수
function clearError(input) {
	input.classList.remove("c-form-field.is-error");
}

// 전체 오류 제거
function clearAllErrors() {
	requiredFields.forEach(field => {
		if (field) clearError(field);
	});
}

fileInput.addEventListener('change', (event) => {
	const files = event.target.files;

	console.log("파일등록");
	// 기존 미리보기 초기화
	fileList.innerHTML = '';

	if (files.length > 1) {
		const dataTransfer = new DataTransfer();
		fileInput.files = dataTransfer.files;
		alert("파일은 최대 1개만 첨부 가능합니다.");
		cntElement.textContent = 0;
		return;
	}

	// 선택 파일들 순회하며 미리보기
	for (let i = 0; i < files.length; i++) {
		const file = files[i];
		fileNameInput.value=file.name;
		const src = URL.createObjectURL(file);
		const listItem = document.createElement('li');
		listItem.innerHTML =
			`<div class="show-img-box">
			<img src="${src}" alt="${file.name}">
			</div>
		<div class="btn-box">
		    <button type='c-button' class='img-cancel-btn' data-name='${file.name}'>삭제</button>
		</div>
		`;
		fileList.appendChild(listItem);
	}

	cntElement.textContent = files.length;

	// 새로 생성된 삭제 버튼에 클릭 이벤트 리스너 추가
	const cancelButtons = document.querySelectorAll('.img-cancel-btn');
	cancelButtons.forEach(button => {
		button.addEventListener('click', (e) => {
			const fileName = e.target.dataset.name;
			const currentFiles = fileInput.files;
			const dataTransfer = new DataTransfer();

			// 삭제할 파일을 제외하고 새로운 FileList 생성
			for (let i = 0; i < currentFiles.length; i++) {
				if (currentFiles[i].name !== fileName) {
					dataTransfer.items.add(currentFiles[i]);
				}
			}

			// 파일 입력(input)의 files 속성을 업데이트
			fileInput.files = dataTransfer.files;
			fileNameInput.value="";
			// DOM에서 미리보기 요소 제거
			e.target.closest('li').remove();

			// 파일 개수 업데이트
			cntElement.textContent = fileInput.files.length;
		});
	});
});
