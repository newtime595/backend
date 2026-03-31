document.addEventListener("DOMContentLoaded", () => {

  // 포인트 클릭
  const pointNum = document.querySelector(".point-count");

  if (pointNum) {
    pointNum.addEventListener("click", function () {
      const userNo = document.querySelector("input[name='userNo']").value;
      location.href = contextPath + "/admin/memdetail.adm?userNo=" + userNo;
    });
  }

  // 닉네임 중복확인
  const checkBtn = document.querySelector("#checkNicknameBtn");

  if (!checkBtn) {
    return;
  }

  checkBtn.addEventListener("click", () => {
    const userNo = document.querySelector("input[name='userNo']").value;
    const nickname = document.querySelector("input[name='newNickname']").value.trim();

    console.log("입력한 새 닉네임:", nickname);

    if (!nickname) {
      alert("닉네임을 입력하세요");
      return;
    }

    fetch(`${contextPath}/admin/checkNickname.adm?userNo=${userNo}&userNickname=${encodeURIComponent(nickname)}`)
      .then(res => res.text())
      .then(result => {
        result = result.trim();
        console.log("응답:", result);

        if (result === "empty") {
          alert("닉네임을 입력하세요");
        } else if (result === "same") {
          alert("현재 닉네임과 동일합니다");
        } else if (result === "duplicated") {
          alert("이미 사용 중인 닉네임입니다");
        } else if (result === "available") {
          alert("사용 가능한 닉네임입니다");
        } else {
          alert("알 수 없는 응답: " + result);
        }
      })
      .catch(err => {
        console.error(err);
        alert("오류 발생");
      });
  });

});