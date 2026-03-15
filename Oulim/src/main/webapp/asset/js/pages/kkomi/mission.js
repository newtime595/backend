/**
 * mission.js
 * 테스트 데이터를 활용한 미션 목록 렌더링 및 인터랙션 로직
 */

// 1. 테스트 데이터 (실제 프로젝트에서는 DB에서 불러온 JSON 형태가 됩니다)
const missionData = [
    { id: 1, type: 'normal', title: '초보 수행자의 첫걸음', desc: '봉사 활동 1회 완료하기', current: 0, total: 1, reward: 500, isDone: false },
    { id: 2, type: 'normal', title: '마을의 수호신', desc: '환경 정화 봉사 3회 참여', current: 3, total: 3, reward: 1200, isDone: false },
    { id: 3, type: 'special', title: '연말연시 나눔', desc: '연탄 나르기 봉사 1회', current: 0, total: 1, reward: 2000, isDone: false }
];

document.addEventListener('DOMContentLoaded', () => {
    // 초기 렌더링 (전체/일반 탭 시작)
    renderMissions('normal');

    // 탭 클릭 이벤트 (데이터 필터링)
    document.querySelectorAll('.c-tab__item').forEach(tab => {
        tab.addEventListener('click', (e) => {
            const type = e.target.dataset.tab;
            renderMissions(type);
        });
    });

    // 보상받기 버튼 이벤트 위임 (동적 생성된 버튼 대응)
    document.querySelector('.c-tab-content').addEventListener('click', (e) => {
        if (e.target.classList.contains('js-reward-btn')) {
            handleReward(e.target);
        }
    });
});

/**
 * 데이터 기반 카드 생성 함수
 */
function renderMissions(type) {
    const listContainer = document.querySelector('.mission-list');
    const filteredData = missionData.filter(item => item.type === type);

    if (filteredData.length === 0) {
        listContainer.innerHTML = `<div class="empty-state">준비된 미션이 없습니다.</div>`;
        return;
    }

    listContainer.innerHTML = filteredData.map(item => {
        const percent = (item.current / item.total) * 100;
        const isComplete = item.current >= item.total;
        
        return `
            <div class="mission-card ${isComplete ? 'is-complete' : ''}">
                <div class="mission-card__info">
                    <h3 class="mission-card__title">${item.title}</h3>
                    <p class="mission-card__text">${item.desc}</p>
                    <div class="mission-card__progress-container">
                        <div class="mission-card__progress-bar" style="width: ${isComplete ? 100 : percent}%;"></div>
                        <span class="mission-card__progress-text">진행도 ${item.current} / ${item.total}</span>
                    </div>
                </div>
                <div class="mission-card__reward">
                    <span class="reward-label">보상</span>
                    <span class="reward-value">${item.reward} DP</span>
                    <button class="c-button c-button--primary c-button--md js-reward-btn" 
                            ${!isComplete ? 'disabled' : ''}>
                        보상받기
                    </button>
                </div>
            </div>
        `;
    }).join('');

    // 렌더링 후 애니메이션 적용
    initProgressAnimations();
}

/**
 * 보상받기 클릭 로직
 */
function handleReward(btn) {
    const card = btn.closest('.mission-card');
    const title = card.querySelector('.mission-card__title').innerText;
    
    if(confirm(`[${title}] 미션 보상을 받으시겠습니까?`)) {
        btn.disabled = true;
        btn.innerText = '수령 완료';
        card.classList.add('is-complete'); // 완료 스타일 처리
        alert('보상이 지급되었습니다!');
    }
}

/**
 * 진행바 애니메이션
 */
function initProgressAnimations() {
    setTimeout(() => {
        document.querySelectorAll('.mission-card__progress-bar').forEach(bar => {
            bar.style.transition = 'width 1s ease-in-out';
        });
    }, 100);
}