/*// 신청 버튼 
const volunActApplyBtn = document.querySelector(".l-volunAct-apply .c-button");

// 날짜에 따른 신청 버튼 status 변경
const card = document.querySelector(".c-detail-card");                // 상세카드
const volunteerStatus = document.querySelector("#volunteerStatus");
const volunteerStartDate = new Date(card.dataset.volunteerStartDate);
const volunteerEndDate = new Date(card.dataset.volunteerEndDate);
const today = new Date(); // 현재날짜
const recruitStartDate = new Date(card.dataset.recruitStartDate);
const recruitEndDate = new Date(card.dataset.recruitEndDate);

// 목록으로 돌아가기 버튼
const returnBtn = document.querySelector(".l-return-button .c-button");

today.setHours(0, 0, 0, 0); // 날짜만 비교하기 위해 시간 초기화
recruitStartDate.setHours(0, 0, 0, 0);
recruitEndDate.setHours(0, 0, 0, 0);
volunteerStartDate.setHours(0, 0, 0, 0);
volunteerEndDate.setHours(0, 0, 0, 0);

// TEST데이터
const isLogin = true;
const userType = "USER";
//

// 상태비교 후 변경
if (today < recruitStartDate) {
  volunteerStatus.textContent = "모집예정";
} else if (today >= recruitStartDate && today <= recruitEndDate) {
  volunteerStatus.textContent = "모집중";
} else if (today >= volunteerStartDate && today <= volunteerEndDate) {
  volunteerStatus.textContent = "진행중";
} else if (today > volunteerEndDate) {
  volunteerStatus.textContent = "완료";
}

// 날짜에 따라 버튼 활성화
function updateApplyButton() {
  const now = new Date();
  console.log("실행 중?");
  const isActive = now <= recruitEndDate;

  if (!volunActApplyBtn) return;

  volunActApplyBtn.disabled = !isActive;
  volunActApplyBtn.textContent = isActive ? "신청하기" : "신청 마감";
}

document.addEventListener("DOMContentLoaded", () => {
  updateApplyButton();
});

volunActApplyBtn.addEventListener("click", (e) => {
  console.log("신청버튼 클릭");
  if (!isLogin) {
    alert("로그인이 필요합니다.");

    // TODO : 로그인 페이지로 이동
    return;
  }

  if (userType !== USER_TYPE.USER) {
    alert("기업 회원 및 관리자는 사용할 수 없습니다.");
    return;
  }

  let result = confirm("신청하시겠습니까?");
  if (result === true) {
  } else {
  }
});

returnBtn.addEventListener("click", (e) => {
  console.log("목록으로 돌아가기 버튼 클릭")
  location.href = "/Oulim/front/html/volunteer-activity/volunAct-list.html";
});
*/
//
window.addEventListener("DOMContentLoaded", function () {
    const messageElement = document.getElementById("message");
    if (!messageElement) return;

    const message = messageElement.value;

    if (message === "applySuccess") {
        alert("봉사 신청이 완료되었습니다.");
    } else if (message === "cancelSuccess") {
        alert("봉사 신청이 철회되었습니다.");
    }
});


// 지도
window.addEventListener("DOMContentLoaded", function () {
    const mapContainer = document.getElementById("map");
    const addressElement = document.getElementById("volunteerLocation");

    if (!mapContainer || !addressElement) return;

    const address = addressElement.textContent.trim();

    if (!address) {
        console.error("주소값이 없습니다.");
        return;
    }

    if (typeof kakao === "undefined") {
        console.error("kakao SDK가 로드되지 않았습니다.");
        return;
    }

    kakao.maps.load(function () {
        const map = new kakao.maps.Map(mapContainer, {
            center: new kakao.maps.LatLng(37.5665, 126.9780),
            level: 3
        });

        const geocoder = new kakao.maps.services.Geocoder();

        geocoder.addressSearch(address, function (result, status) {
            if (status === kakao.maps.services.Status.OK) {
                const coords = new kakao.maps.LatLng(result[0].y, result[0].x);

                new kakao.maps.Marker({
                    map: map,
                    position: coords
                });

                map.setCenter(coords);
            } else {
                console.error("주소 검색 실패:", address);
            }
        });
    });
});