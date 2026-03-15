
const earn = document.getElementById("a");
const use = document.getElementById("b");

const plus = document.getElementById("plus");
const minus = document.getElementById("minus");


plus.addEventListener("click", () => {
    earn.style.display = "block";
    use.style.display = "none";
});


minus.addEventListener("click", () => {
    earn.style.display = "none";
    use.style.display = "block";
});







