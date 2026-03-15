const volunteerData = [
  { id: 1, title: "제설 봉사", startDate: "26.02.03", endDate: "26.02.05", status: "모집중" },
  { id: 2, title: "환경 정화", startDate: "26.02.04", endDate: "26.02.04", status: "모집중" },
  { id: 3, title: "급식 봉사", startDate: "26.02.05", endDate: "26.02.06", status: "완료" },
  { id: 4, title: "도시락 배달", startDate: "26.02.06", endDate: "26.02.08", status: "모집중" },
  { id: 5, title: "플로깅", startDate: "26.02.07", endDate: "26.02.07", status: "완료" },
  { id: 6, title: "연탄 나르기", startDate: "26.02.08", endDate: "26.02.09", status: "모집중" },
  { id: 7, title: "아동 학습 보조", startDate: "26.02.09", endDate: "26.02.11", status: "모집중" },
  { id: 8, title: "노인 돌봄", startDate: "26.02.10", endDate: "26.02.10", status: "완료" },
  { id: 9, title: "공원 청소", startDate: "26.02.11", endDate: "26.02.12", status: "모집중" },
  { id: 10, title: "행사 지원", startDate: "26.02.12", endDate: "26.02.13", status: "모집중" },
  { id: 11, title: "유기견 보호소", startDate: "26.02.13", endDate: "26.02.14", status: "모집중" },
  { id: 12, title: "유기견 보호소", startDate: "26.02.13", endDate: "26.02.15", status: "모집중" }
];

const listBody = document.querySelector("#volunteerListBody");
const pagination = document.querySelector(".c-pagination");


const perPage = 10; // 한 페이지 리스트 개수
const pageGroup = 10; // 페이지 버튼 개수
const totalPages = Math.ceil(volunteerData.length / perPage);    // 전체 페이지 계싼
let currentPage = 1;

// 페이지의 데이터 표시 함수
function showPage(page) {
  currentPage = page;

  const start = (page - 1) * perPage;
  const end = start + perPage;
  const pageData = volunteerData.slice(start, end);

  listBody.innerHTML = "";
  
  pageData.forEach(item => {
    const row = document.createElement("div");
    row.className = "c-list__row";

    row.innerHTML = `
      <span class="c-list__col">${item.title}</span>
      <span class="c-list__col">${item.startDate} ~ ${item.endDate}</span>
      <span class="c-list__col">${item.status}</span>
    `;

    row.addEventListener("click", () => {
      location.href = `/Oulim/front/html/volunteer-management/volunteer-manage-detail.html?id=${item.id}`;
    });

    listBody.appendChild(row);
  });

  renderPagination();
}

// 페이지 버튼 생성 함수
function renderPagination() {
  pagination.innerHTML = "";

  const groupStart = Math.floor((currentPage - 1) / pageGroup) * pageGroup + 1;
  const groupEnd = Math.min(groupStart + pageGroup - 1, totalPages);

  // 이전 페이지 그룹 버튼 생성
  if (groupStart > 1) {
    const prev = document.createElement("a");
    prev.className = "c-pagination__link";
    prev.textContent = "‹";
    prev.onclick = () => showPage(groupStart - 1);
    pagination.appendChild(prev);
  }

  // 페이지 번호 버튼 생성
  for (let i = groupStart; i <= groupEnd; i++) {
    const btn = document.createElement("a");
    btn.className = "c-pagination__link";
    if (i === currentPage) btn.classList.add("is-active");

    btn.textContent = i;
    btn.onclick = () => showPage(i);

    pagination.appendChild(btn);
  }

  // 다음 페이지 그룹 버튼 생성
  if (groupEnd < totalPages) {
    const next = document.createElement("a");
    next.className = "c-pagination__link";
    next.textContent = "›";
    next.onclick = () => showPage(groupEnd + 1);
    pagination.appendChild(next);
  }
}

// 첫 페이지네이션 초기 실행
showPage(1);