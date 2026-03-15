const header = document.getElementById("header");
const footer = document.getElementById("footer");

fetch("/Oulim/header-login.html")
  .then((r) => r.text())
  .then((t) => (header.innerHTML = t));

fetch("/Oulim/footer.html")
  .then((r) => r.text())
  .then((t) => (footer.innerHTML = t));
