// 카드 클릭 시 상세페이지 이동
document.addEventListener("DOMContentLoaded", () => {

    const cards = document.querySelectorAll(".card");

    cards.forEach(card => {
        card.addEventListener("click", () => {
            const id = card.dataset.id;

            if (!id) return;

            // 상세 페이지 이동
            window.location.href = `/volunteer-activity/detail.va?volunActNo=${id}`;
        });
    });

});