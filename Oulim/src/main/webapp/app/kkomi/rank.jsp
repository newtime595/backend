<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>rank</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/typography.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/layout.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/badge.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/kkomi/rank.css">
  <link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
  <link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />
  <script defer src="${pageContext.request.contextPath}/asset/js/pages/kkomi/rank.js"></script>
  

</head>

<body>
  <jsp:include page="/app/include/header.jsp" />
  <main class="l-main">
    <div class="l-container">
      <section class="p-rank">
        <h2 class="p-rank__title">도력 랭킹</h2>
        <p class="p-rank__desc">가장 많은 선행을 베푼 수행자들을 확인해보세요!</p>

        <div class="p-rank__top3 js-rank-top3">
          <div class="loading-spinner">랭킹을 불러오는 중...</div>
        </div>

        <ul class="c-rank-list js-rank-list">
        </ul>
        <button class="c-button c-button--secondary c-button--md" onclick="location.href='Kkomi-training-center.html'">
          수련소로 돌아가기
        </button>
      </section>
    </div>
  </main>
  <jsp:include page="/app/include/footer.jsp" />
</body>


</html>