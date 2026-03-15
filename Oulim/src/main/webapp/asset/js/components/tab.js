document.addEventListener("DOMContentLoaded", () => {

const tabs = document.querySelectorAll(".c-tab__item")

const panels = document.querySelectorAll(".c-tab-panel")

tabs.forEach(tab => {

tab.addEventListener("click", () => {

const target = tab.dataset.tab

tabs.forEach(t => t.classList.remove("is-active"))
panels.forEach(p => p.classList.remove("is-active"))

tab.classList.add("is-active")

document
.querySelector(`[data-panel="${target}"]`)
.classList.add("is-active")

})

})

})