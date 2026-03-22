/*
const postDetail = document.querySelectorAll(".clicktitle");

postDetail.forEach((btn) => {
    btn.addEventListener("click", function(){
    location.href = "${pageContext.request.contextPath}/app/admin/jsp/community-manage/post-detail.jsp";
});
});*/

const postDetail = document.querySelectorAll(".clicktitle");

postDetail.forEach((btn) => {
    btn.addEventListener("click", function () {
        location.href = this.dataset.href;
    });
});