document.addEventListener("DOMContentLoaded", () => {

	const USER_TYPE = {
		ADMIN: 0,
		USER: 1,
		COMPANY: 2
	};
  const mockData = {
    level: kkomiLev,
    rank: ranking,
    absorbPoint: currExp,
    remainPoint: point,
    progress: (currExp === 0 || needExp === 0) ? 0 : (currExp / needExp * 100)
  }

  const character = document.querySelector("#komiCharacter")
  const levelBadge = document.querySelector(".js-level")
  const progressBar = document.querySelector(".js-progress")

  const rankEls = document.querySelectorAll(".js-rank")
  const absorb = document.querySelector(".js-absorb")
  const remain = document.querySelector(".js-remain")

  if(character){
    character.src = `${contextPath}/asset/image/character/komi-lv${mockData.level}.svg`
  }

  if(levelBadge){
    levelBadge.textContent = `Lv.${mockData.level}`
  }

  if(progressBar){
    progressBar.style.width = `${mockData.progress}%`
  }

  rankEls.forEach(el=>{
    el.textContent = mockData.rank
  })

  if(absorb){
    absorb.textContent = mockData.absorbPoint
  }

  if(remain){
    remain.textContent = mockData.remainPoint
  }

  const feedBtn = document.querySelector("#feedBtn");
  const missionBtn = document.querySelector(".js-mission");
  const storageBtn = document.querySelector(".js-storage");
  const rankingBtn = document.getElementById("rankingBtn");
  
  rankingBtn.addEventListener("click" ,() => {
	location.href =`${contextPath}/kkomi/ranking.kko`;
  });

  feedBtn?.addEventListener("click", async () => {    
		if (!isLogin) {
			alert("로그인이 필요합니다.")

			location.href = `${contextPath}/user/login.usr`
			return;
		}

		if (userType !== USER_TYPE.USER) {
			alert("기업 회원 및 관리자는 사용할 수 없습니다.");
			return;
		}
		
		if(mockData.remainPoint < 100){
			alert("최소 사용 가능 포인트를 보유하고 있지 않습니다(최소 100)");
			return;
		}
		
		try{
			const res = await fetch(`${contextPath}/kkomi/feed.kko`,{
				method : "POST",
				headers : { "X-Requested-With": "fetch" }
			});
			const data = await res.json();
			if(data.result === 100){
				alert(data.data);
				location.reload();				
			}else{
				alert(data.data);				
			}
		}catch(err){
			alert("오류가 발생했습니다.");
		}
  })

  missionBtn?.addEventListener("click", () => {
    location.href=`${contextPath}/kkomi/mission.kko`
  })

  storageBtn?.addEventListener("click", () => {
    location.href=`${contextPath}/app/kkomi/storage-box.jsp`
  })

})