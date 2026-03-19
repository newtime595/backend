document.addEventListener("DOMContentLoaded", function () {
	const attendanceToggleBtn = document.getElementById("attendanceToggleBtn");
	const detailSection = document.getElementById("detailSection");
	const attendanceSection = document.getElementById("attendanceSection");

	if (!attendanceToggleBtn || !detailSection || !attendanceSection) return;

	attendanceToggleBtn.addEventListener("click", function () {
		const isDetailVisible = detailSection.style.display !== "none";

		if (isDetailVisible) {
			detailSection.style.display = "none";
			attendanceSection.style.display = "block";
			attendanceToggleBtn.textContent = "상세 보기";
		} else {
			detailSection.style.display = "block";
			attendanceSection.style.display = "none";
			attendanceToggleBtn.textContent = "출석 처리";
		}
	});
});