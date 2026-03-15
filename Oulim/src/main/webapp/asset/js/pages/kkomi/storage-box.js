/**
 * storage-box.js
 * 보관함 아이템 관리 및 사용 로직
 */

// 1. 보관함 테스트 데이터
const storageData = [
    {
        id: 1,
        name: '영롱한 구슬',
        desc: '여우의 도력을 일시적으로 2배 높여주는 신비한 구슬입니다.',
        expire: 7,
        type: 'bead'
    },
    {
        id: 2,
        name: '천년초',
        desc: '여우의 털색을 은빛으로 변경할 수 있는 희귀한 약초입니다.',
        expire: 30,
        type: 'herb'
    },
    {
        id: 3,
        name: '여우령 부적',
        desc: '다음 봉사 활동 시 획득하는 도력을 500만큼 즉시 추가합니다.',
        expire: 3,
        type: 'talisman'
    }
];

// 2. 아이템 타입별 SVG 소스 관리
const itemIcons = {
    bead: `<svg width="40" height="40" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
            <circle cx="12" cy="12" r="9" fill="#E3F2FD" stroke="#2196F3" stroke-width="1.5"/>
            <circle cx="9" cy="10" r="1.5" fill="#2196F3"/>
          </svg>`,
    herb: `<svg width="40" height="40" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M12 22C12 22 12 18 12 15M12 15C12 11 14 7 19 5C17 10 13 12 12 15ZM12 15C12 11 10 7 5 5C7 10 11 12 12 15Z" stroke="#4CAF50" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"/>
          </svg>`,
    talisman: `<svg width="40" height="40" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <rect x="5" y="3" width="14" height="18" rx="2" stroke="#F44336" stroke-width="1.5"/>
                <path d="M9 7L15 17M15 7L9 17" stroke="#F44336" stroke-width="1.5"/>
              </svg>`
};

document.addEventListener('DOMContentLoaded', () => {
    renderStorage();

    // 이벤트 위임: 사용하기 버튼 클릭
    document.querySelector('.storage-list').addEventListener('click', (e) => {
        if (e.target.classList.contains('js-use-btn')) {
            const itemCard = e.target.closest('.storage-item');
            const itemId = itemCard.dataset.id;
            const itemName = itemCard.querySelector('.item-name').innerText;

            useItem(itemId, itemName, itemCard);
        }
    });
});

/**
 * 보관함 리스트 렌더링
 */
function renderStorage() {
    const listContainer = document.querySelector('.storage-list');
    
    if (storageData.length === 0) {
        listContainer.innerHTML = `<div class="empty-state" style="text-align:center; padding:50px; color:#888;">보관함이 비어 있습니다.</div>`;
        return;
    }

    listContainer.innerHTML = storageData.map(item => `
        <div class="storage-item" data-id="${item.id}">
            <div class="storage-item__img">
                ${itemIcons[item.type] || itemIcons.bead}
            </div>
            <div class="storage-item__info">
                <h3 class="item-name">${item.name}</h3>
                <p class="item-desc">${item.desc}</p>
            </div>
            <div class="storage-item__status">
                <span class="expire-date">남은 유효 기간 : ${item.expire}일</span>
                <button class="c-button c-button--primary c-button--md js-use-btn">사용하기</button>
            </div>
        </div>
    `).join('');
}

/**
 * 아이템 사용 처리
 */
function useItem(id, name, element) {
    if (confirm(`'${name}'을(를) 지금 사용하시겠습니까?`)) {
        // 1. 애니메이션 효과 (선택)
        element.style.transition = 'all 0.5s ease';
        element.style.opacity = '0';
        element.style.transform = 'translateX(20px)';

        // 2. 실제 데이터 삭제 (테스트용)
        setTimeout(() => {
            const index = storageData.findIndex(item => item.id == id);
            if (index > -1) storageData.splice(index, 1);
            
            element.remove();
            alert(`'${name}' 아이템이 사용되었습니다! 효과가 수련소에 반영됩니다.`);
            
            // 만약 다 썼다면 비어있음 표시
            if (storageData.length === 0) renderStorage();
        }, 500);
    }
}