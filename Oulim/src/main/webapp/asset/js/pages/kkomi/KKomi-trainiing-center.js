document.addEventListener("DOMContentLoaded", () => {

  const mockData = {
    level: 4,
    rank: 7000,
    absorbPoint: 5000,
    remainPoint: 500,
    progress: 60
  }

  const character = document.querySelector("#komiCharacter")
  const levelBadge = document.querySelector(".js-level")
  const progressBar = document.querySelector(".js-progress")

  const rankEls = document.querySelectorAll(".js-rank")
  const absorb = document.querySelector(".js-absorb")
  const remain = document.querySelector(".js-remain")

  if(character){
    character.src = `/Oulim/asset/image/character/komi-lv${mockData.level}.svg`
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

  const feedBtn = document.querySelector(".js-feed")
  const missionBtn = document.querySelector(".js-mission")
  const storageBtn = document.querySelector(".js-storage")

  feedBtn?.addEventListener("click", () => {
    alert("도력을 흡수합니다!")
  })

  missionBtn?.addEventListener("click", () => {
    location.href="/mission"
  })

  storageBtn?.addEventListener("click", () => {
    location.href="/storage"
  })

})