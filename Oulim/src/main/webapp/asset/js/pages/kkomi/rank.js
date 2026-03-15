/**
 * rank.js
 * 랭킹 데이터 정렬 및 동적 렌더링
 */

// 1. 랭킹 테스트 데이터
const rankData = [
    { name: "이달의 봉사왕은 바로나야", score: 48034, level: 9 },
    { name: "이달의 봉야", score: 46210, level: 8 },
    { name: "나눔의 기쁨", score: 45500, level: 9 },
    { name: "봉사러버", score: 45230, level: 7 },
    { name: "좋은사람", score: 44100, level: 6 },
    { name: "따뜻한손", score: 42000, level: 5 },
    { name: "봉사왕후보", score: 39990, level: 4 },
    { name: "마음천사", score: 37210, level: 5 },
    { name: "행복나눔", score: 35020, level: 3 },
    { name: "따뜻한세상", score: 33000, level: 2 }
];

document.addEventListener('DOMContentLoaded', () => {
    // 점수 높은 순으로 정렬
    const sortedData = [...rankData].sort((a, b) => b.score - a.score);
    
    renderTop3(sortedData.slice(0, 3));
    renderRankList(sortedData.slice(3, 10));
    
    // 내 랭킹 강조 효과 (테스트용)
    highlightMyRank("좋은사람");
});

/**
 * 상단 TOP 3 렌더링 (2등 - 1등 - 3등 순서로 배치)
 */
function renderTop3(top3) {
    const top3Container = document.querySelector('.p-rank__top3');
    if (!top3Container) return;

    // 시각적 밸런스를 위해 [2등, 1등, 3등] 순서로 배열 재배치
    const displayOrder = [top3[1], top3[0], top3[2]];
    const medals = ["🥈", "🥇", "🥉"];
    const rankClasses = ["second", "first", "third"];

    top3Container.innerHTML = displayOrder.map((user, index) => {
        // 실제 등수 계산 (index 0은 2등, index 1은 1등, index 2는 3등)
        const actualRank = index === 0 ? 2 : (index === 1 ? 1 : 3);
        
        return `
            <div class="c-rank-card c-rank-card--${rankClasses[index]}">
                <div class="c-rank-card__rank">${medals[actualRank-1]}</div>
                <img src="/Oulim/asset/image/character/komi-lv${user.level}.svg" class="c-rank-card__img" alt="캐릭터">
                <div class="c-rank-card-user">
                    <span class="c-rank-card-user__name">${user.name}</span>
                    <span class="c-rank-card-user__score">${user.score.toLocaleString()}p</span>
                </div>
            </div>
        `;
    }).join('');
}

/**
 * 4위~10위 리스트 렌더링
 */
function renderRankList(others) {
    const listContainer = document.querySelector('.c-rank-list');
    if (!listContainer) return;

    listContainer.innerHTML = others.map((user, index) => `
        <li class="c-rank-item" data-name="${user.name}">
            <span class="c-rank-item__rank">${index + 4}</span>
            <span class="c-rank-item__name">${user.name}</span>
            <span class="c-rank-item__score">${user.score.toLocaleString()}p</span>
        </li>
    `).join('');
}

/**
 * 현재 로그인한 사용자의 순위를 강조하는 함수
 */
function highlightMyRank(userName) {
    const items = document.querySelectorAll('.c-rank-item');
    items.forEach(item => {
        if (item.dataset.name === userName) {
            item.style.backgroundColor = 'var(--color-primary-light, #f0f9eb)';
            item.style.borderLeft = '4px solid var(--color-primary, #76b13a)';
            item.innerHTML += `<span class="c-badge" style="margin-left:auto">나</span>`;
        }
    });
}