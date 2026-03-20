const accept = document.getElementById("accept");
const cancel = document.getElementById("cancel");


const password = document.getElementsByName("password")[0];


accept.addEventListener('click', () => {

    const chk = document.getElementById("chk-box-label").checked;

    if (password.value.trim() === "") {
        alert("비밀번호를 입력해주세요.");

    } else if (password.value.trim() === "1234") { // 비밀번호는 임의로 넣은 값, 나중에 DB에서 가져올 것
        
        if (chk === false) {
            alert("약관에 동의해주세요.");
        } else if (chk === true) {
            alert("탈퇴 성공");
        }

    };

    // 약관에 동의하지 않고 탈퇴 클릭 시, 얼럿 출력

});

cancel.addEventListener("click", () => {
    // location("../");
    alert("취소");
});




