document.addEventListener("DOMContentLoaded", () => {
  const volunteerDetailData = [
    {
      id: 1,
      title: "제설 봉사",
      target: "독거노인",
      location: "서울특별시 도봉구",
      recruitStartDate: "2026-01-03",
      recruitEndDate: "2026-03-01",
      volunteerStartDate: "2026-06-03",
      volunteerEndDate: "2026-07-06",
      time: "4시간",
      capacity: "30명",
      point: "2000p",
      age: "직장인(30~)",
      participants: [
        { id: 1, name: "홍길동", age: "32세", date: "2026-09-03", status: "출석" },
        { id: 2, name: "김철수", age: "28세", date: "2026-08-03", status: "결석" },
        { id: 3, name: "이영희", age: "35세", date: "2026-02-04", status: "출석" },
        { id: 4, name: "김철수", age: "28세", date: "2026-02-03", status: "결석" },
        { id: 5, name: "김철수", age: "28세", date: "2026-02-03", status: "결석" },
        { id: 6, name: "김철수", age: "28세", date: "2026-02-03", status: "결석" },
        { id: 7, name: "김철수", age: "28세", date: "2026-02-03", status: "결석" },
        { id: 8, name: "김철수", age: "28세", date: "2026-02-03", status: "결석" },
        { id: 9, name: "김철수", age: "28세", date: "2026-02-03", status: "결석" },
        { id: 10, name: "김철수", age: "28세", date: "2026-02-03", status: "결석" }, 
      ]
    },
    {
      id: 2,
      title: "환경 정화",
      target: "지역주민",
      location: "서울특별시 노원구",
      recruitStartDate: "2026-02-01",
      recruitEndDate: "2026-02-10",
      volunteerStartDate: "2026-02-12",
      volunteerEndDate: "2026-02-13",
      time: "3시간",
      capacity: "20명",
      point: "1500p",
      age: "청년(20~29세)",
      participants: [
        { id: 1, name: "홍길동", age: "32세", date: "2026-09-03", status: "출석" },
        { id: 2, name: "김철수", age: "28세", date: "2026-02-03", status: "결석" },
        { id: 3, name: "이영희", age: "35세", date: "2026-02-04", status: "출석" }
      ]
    },
    { id:3}
  ];

  const volunteerStatus = document.querySelector("#volunteerStatus");
  const deleteBtns = document.querySelectorAll(".delete-btn");
  const editBtns = document.querySelectorAll(".edit-btn");

  const params = new URLSearchParams(location.search);
  const volunteerId = Number(params.get("id"));

  const volunteer = volunteerDetailData.find(item => item.id === volunteerId);

  if (!volunteer) {
    alert("존재하지 않는 봉사입니다.");
    location.href = "/Oulim/front/html/volunteer-management/volunteer-manage-list.html";
    return;
  }

  document.querySelector("#volunteerTitle").textContent = volunteer.title;
  document.querySelector("#volunteerTarget").textContent = volunteer.target;
  document.querySelector("#volunteerLocation").textContent = volunteer.location;
  document.querySelector("#volunteerPeriod").textContent =
    `${formatDate(volunteer.volunteerStartDate)} ~ ${formatDate(volunteer.volunteerEndDate)}`;
  document.querySelector("#recruitPeriod").textContent =
    `${formatDate(volunteer.recruitStartDate)} ~ ${formatDate(volunteer.recruitEndDate)}`;
  document.querySelector("#volunteerTime").textContent = volunteer.time;
  document.querySelector("#volunteerCapacity").textContent = volunteer.capacity;
  document.querySelector("#volunteerPoint").textContent = volunteer.point;
  document.querySelector("#volunteerAge").textContent = volunteer.age;

  volunteerStatus.textContent = getVolunteerStatus(volunteer);
  renderParticipantList(volunteer.participants);
  bindParticipantButtons();

  deleteBtns.forEach(btn => {
    btn.addEventListener("click", () => {
      alert("삭제되었습니다.");
    });
  });

  editBtns.forEach(btn => {
    btn.addEventListener("click", () => {
      location.href = "/Oulim/front/html/volunteer-management/volunteer-manage-edit.html";
    });
  });
});


function formatDate(dateString) {
  const date = new Date(dateString);
  const yy = String(date.getFullYear()).slice(2);
  const mm = String(date.getMonth() + 1).padStart(2, "0");
  const dd = String(date.getDate()).padStart(2, "0");
  return `${yy}.${mm}.${dd}`;
}

function getVolunteerStatus(volunteer) {
  const today = new Date();
  today.setHours(0, 0, 0, 0);

  const recruitStartDate = new Date(volunteer.recruitStartDate);
  const recruitEndDate = new Date(volunteer.recruitEndDate);
  const volunteerStartDate = new Date(volunteer.volunteerStartDate);
  const volunteerEndDate = new Date(volunteer.volunteerEndDate);

  recruitStartDate.setHours(0, 0, 0, 0);
  recruitEndDate.setHours(0, 0, 0, 0);
  volunteerStartDate.setHours(0, 0, 0, 0);
  volunteerEndDate.setHours(0, 0, 0, 0);

  if (today < recruitStartDate) {
    return "모집예정";
  }
  if (today >= recruitStartDate && today <= recruitEndDate) {
    return "모집중";
  }
  if (today > recruitEndDate && today < volunteerStartDate) {
    return "진행예정";
  }
  if (today >= volunteerStartDate && today <= volunteerEndDate) {
    return "진행중";
  }
  return "완료";
}

function renderParticipantList(participants) {
  const listBody = document.querySelector("#participantListBody");
  listBody.innerHTML = "";

  if (!participants || participants.length === 0) {
    listBody.innerHTML = `
      <div class="c-list__row">
        <span class="c-list__col">참여자가 없습니다.</span>
        <span class="c-list__col"></span>
        <span class="c-list__col"></span>
        <span class="c-list__col"></span>
        <span class="c-list__col"></span>
        <span class="c-list__col"></span>
      </div>
    `;
    return;
  }

  participants.forEach((participant) => {
    const row = document.createElement("div");
    row.className = "c-list__row";
    row.dataset.date = participant.date;
    row.dataset.participantId = participant.id;

    row.innerHTML = `
      <div class="c-button--volunteer-manage-detail_btn">
        <button class="recommend-btn c-button c-button--primary c-button--md">추천</button>
      </div>
      <span class="c-list__col">${participant.name}</span>
      <span class="c-list__col">${participant.age}</span>
      <span class="c-list__col">${formatDate(participant.date)}</span>
      <span class="c-list__col">${participant.status}</span>
      <div class="c-list__actions">
        <div class="c-button--volunteer-manage-register">
          <button class="attendance-btn c-button c-button--primary c-button--md">출석</button>
          <button class="absent-btn c-button c-button--secondary c-button--md">결석</button>
        </div>
      </div>
    `;

    listBody.appendChild(row);
  });
}

function bindParticipantButtons() {
  const rows = document.querySelectorAll("#participantListBody .c-list__row");
  const recommendBtns = document.querySelectorAll("#participantListBody .recommend-btn");
  const attendanceBtns = document.querySelectorAll("#participantListBody .attendance-btn");
  const absentBtns = document.querySelectorAll("#participantListBody .absent-btn");

  const today = new Date();
  today.setHours(0, 0, 0, 0);

  rows.forEach((row) => {
    const volunteerDate = row.dataset.date;
    if (!volunteerDate) return;

    const targetDate = new Date(volunteerDate);
    targetDate.setHours(0, 0, 0, 0);

    const recommendBtn = row.querySelector(".recommend-btn");
    const attendanceBtn = row.querySelector(".attendance-btn");
    const absentBtn = row.querySelector(".absent-btn");

    const isActive = today >= targetDate;

    if (recommendBtn) recommendBtn.disabled = !isActive;
    if (attendanceBtn) attendanceBtn.disabled = !isActive;
    if (absentBtn) absentBtn.disabled = !isActive;
  });

  recommendBtns.forEach((btn) => {
    btn.addEventListener("click", (e) => {
      e.stopPropagation();
      if (btn.disabled) return;
      alert("추천이 완료되었습니다.");
    });
  });

  attendanceBtns.forEach((btn) => {
    btn.addEventListener("click", (e) => {
      e.stopPropagation();
      if (btn.disabled) return;
      alert("출석 처리되었습니다.");
    });
  });

  absentBtns.forEach((btn) => {
    btn.addEventListener("click", (e) => {
      e.stopPropagation();
      if (btn.disabled) return;
      alert("결석 처리되었습니다.");
    });
  });
}