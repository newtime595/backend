document.addEventListener("DOMContentLoaded", () => {

  const checkBtn = document.querySelector(".side-button");

  if (!checkBtn) return;

  checkBtn.addEventListener("click", () => {

    const userNo = document.querySelector("input[name='userNo']").value;
    const nickname = document.querySelector("input[name='userNickname']").value;

    if (!nickname || nickname.trim() === "") {
      alert("닉네임을 입력하세요");
      return;
    }

    fetch(`${contextPath}/admin/checkNickname.adm?userNo=${userNo}&userNickname=${encodeURIComponent(nickname)}`)
      .then(res => res.text())
      .then(result => {

        if (result === "empty") {
          alert("닉네임을 입력하세요");
        } else if (result === "same") {
          alert("기존 닉네임과 동일합니다");
        } else if (result === "duplicated") {
          alert("이미 사용중인 닉네임입니다");
        } else if (result === "available") {
          alert("사용 가능한 닉네임입니다");
        }

      })
      .catch(err => {
        console.error(err);
        alert("오류 발생");
      });

  });

});