document.addEventListener('DOMContentLoaded', () => {
    // 1. 데이터
    const vList = [
        { title: "환경 미화 봉사", loc: "도봉구", p: "2,000" },
        { title: "도시락 배달", loc: "노원구", p: "1,500" },
        { title: "유기견 보호", loc: "남양주", p: "3,000" },
        { title: "학습 도우미", loc: "성북구", p: "2,500" },
        { title: "연탄 나눔", loc: "강북구", p: "2,000" }
    ];

    const rList = [
        { title: "벽화 봉사 후기", author: "철수", img: "https://picsum.photos/400/250?1" },
        { title: "보호소 일기", author: "영희", img: "https://picsum.photos/400/250?2" },
        { title: "따뜻한 도시락", author: "민수", img: "https://picsum.photos/400/250?3" }
    ];

    // 2. 렌더링 (슬라이더 & 후기)
    const track = document.querySelector('.js-volunteer-slider');
    const rGrid = document.querySelector('.js-review-container');

    if(track) {
        track.innerHTML = vList.map(v => `
            <div class="c-volunteer-card">
                <span class="c-volunteer-card__recruitment">모집중</span>
                <h3 style="margin:10px 0; height:44px;">${v.title}</h3>
                <p> ${v.loc}</p>
                <div style="margin-top:15px; border-top:1px dashed #eee; padding-top:10px; display:flex; justify-content:space-between;">
                    <small>성장 도력</small><strong>${v.p} P</strong>
                </div>
            </div>
        `).join('');
    }

    if(rGrid) {
        rGrid.innerHTML = rList.map(r => `
            <div class="c-review-card">
                <div class="review-img"><img src="${r.img}"></div>
                <div class="review-content">
                    <h4>${r.title}</h4>
                    <p style="color:#76b13a; margin-top:10px;">${r.author}</p>
                </div>
            </div>
        `).join('');
    }

    // 3. 슬라이더 로직
    const prev = document.getElementById('prevBtn');
    const next = document.getElementById('nextBtn');
    let idx = 0;
    const cardW = 310 + 20; // 너비 + gap

    const move = () => {
        track.style.transform = `translateX(-${idx * cardW}px)`;
        prev.disabled = (idx === 0);
        next.disabled = (idx >= vList.length - 3);
    };

    next.addEventListener('click', () => { idx++; move(); });
    prev.addEventListener('click', () => { idx--; move(); });
    move();
});