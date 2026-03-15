const generalBtn = document.querySelector(".is-general");
const businessBtn = document.querySelector(".is-business");

const generalTerms = document.getElementById("is-general-terms");
const businessTerms = document.getElementById("is-business-terms");

generalBtn.addEventListener("click", function () {
  generalTerms.style.display = "block";
  businessTerms.style.display = "none";
  resetCheck();
});

businessBtn.addEventListener("click", function () {
  generalTerms.style.display = "none";
  businessTerms.style.display = "block";
  resetCheck();
  
});

function resetCheck() {
  checks.forEach(check => check.checked = false);
  checksG.forEach(check => check.checked = false);
  allCheck.checked = false;
  allCheckG.checked = false;
}

const allCheck = document.getElementById("is-all-check");
const checks = document.querySelectorAll(".is-agree-check");
const nextBtn = document.getElementById("is-next-btn");

allCheck.addEventListener("change", function () {
  checks.forEach(function (check) {
    check.checked = allCheck.checked;
  });
});

checks.forEach(function (check) {
  check.addEventListener("change", function () {
    const isAllChecked = [...checks].every(function (item) {
      return item.checked;
    });

    allCheck.checked = isAllChecked;
  });
});

nextBtn.addEventListener("click", function (e) {
  const isAllChecked = [...checks].every(function (item) {
    return item.checked;
  });

  if (!isAllChecked) {
    e.preventDefault();
    alert("약관에 모두 동의해주세요.");
  }
});

// 기업
const allCheckG = document.getElementById("is-all-check-general");
const checksG = document.querySelectorAll(".is-agree-check-general");
const nextBtnG = document.getElementById("is-next-btn-general");

allCheckG.addEventListener("change", function () {
  checksG.forEach(function (check) {
    check.checked = allCheckG.checked;
  });
});

checksG.forEach(function (check) {
  check.addEventListener("change", function () {
    const isAllChecked = [...checksG].every(function (item) {
      return item.checked;
    });

    allCheckG.checked = isAllChecked;
  });
});

nextBtnG.addEventListener("click", function (e) {
  const isAllChecked = [...checksG].every(function (item) {
    return item.checked;
  });

  if (!isAllChecked) {
    e.preventDefault();
    alert("약관에 모두 동의해주세요.");
  }
});