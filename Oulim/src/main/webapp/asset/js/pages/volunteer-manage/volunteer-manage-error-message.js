document.addEventListener("DOMContentLoaded", () => {
	const message = document.body.dataset.message;

	if (!message) return;

	if (message === "insertSuccess") {
		alert("봉사활동이 등록되었습니다.");
		window.location.href="/volunteer-manage/list.vm";
	} else if (message === "insertFail") {
		alert("봉사활동 등록에 실패했습니다.");
		window.location.href="/volunteer-manage/list.vm";
	} else if (message === "updateSuccess") {
		alert("봉사활동이 수정되었습니다.");
		const volunActNo = document.getElementById("volunActNo").value;
		window.location.href = `/volunteer-manage/detail.vm?volunActNo=${volunActNo}`;
	} else if (message === "updateFail") {
		alert("봉사활동 수정에 실패했습니다.");
		const volunActNo = document.getElementById("volunActNo").value;
		window.location.href = `/volunteer-manage/detail.vm?volunActNo=${volunActNo}`;
	}
	else if (message === "deleteSuccess") {
		alert("봉사활동 삭제에 성공했습니다.");
		window.location.href="/volunteer-manage/list.vm";
	}
	else if (message === "deleteFail") {
		alert("봉사활동 삭제에 실패했습니다.");
		window.location.href="/volunteer-manage/list.vm";
	}

});