document.addEventListener("DOMContentLoaded", () => {

  const modal = document.querySelector("#modalExample")

  const openBtn = document.querySelector(".js-modal-open")

  const closeBtns = document.querySelectorAll(".js-modal-close")


  /* 모달 열기 */

  openBtn.addEventListener("click", () => {

    modal.classList.add("is-open")

  })


  /* 모달 닫기 */

  closeBtns.forEach(btn => {

    btn.addEventListener("click", () => {

      modal.classList.remove("is-open")

    })

  })


  /* 배경 클릭 시 닫기 */

  modal.addEventListener("click", (e) => {

    if(e.target === modal){

      modal.classList.remove("is-open")

    }

  })

})