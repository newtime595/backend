document.querySelectorAll(".c-list__row").forEach(row => {
  row.addEventListener("click", function () {
    location.href = this.dataset.href;
  });
});