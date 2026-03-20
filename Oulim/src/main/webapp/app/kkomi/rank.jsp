<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>rank</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/layout.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/badge.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/button.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/kkomi/rank.css">
  <link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
  <link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />
  <script defer src="${pageContext.request.contextPath}/asset/js/pages/kkomi/rank.js"></script>
  <script>
	const contextPath = "${pageContext.request.contextPath}";
	const rankData = [
		<c:forEach var="rank" items="${rankingList}" varStatus="status">
		{
			userNo : ${rank.userNo},
			name : "${rank.userNickname}",
			score: ${rank.rankPoint},
			level : ${rank.kkomiLev},
			ranking : ${rank.ranking}
		}<c:if test="${!status.last}">,</c:if>
		</c:forEach>
	];
	const loginUserNo = ${sessionScope.userNo};
  </script>

</head>

<body>
  <jsp:include page="/app/include/header.jsp" />
  <main class="l-main">
    <div class="l-container">
      <section class="p-rank">
        <h2 class="p-rank__title">도력 랭킹</h2>
        <jsp:useBean id="now" class="java.util.Date" />
		<h4><fmt:formatDate value="${now}" pattern="yyyy년 MM월"/></h4>
        <p class="p-rank__desc">가장 많은 선행을 베푼 수행자들을 확인해보세요!</p>

        <div class="p-rank__top3 js-rank-top3">
          <div class="loading-spinner">랭킹을 불러오는 중...</div>
        </div>

        <ul class="c-rank-list js-rank-list">
        </ul>
        
        <div class="p-rank__my">
        </div>
        
        <button class="c-button c-button--secondary c-button--md" onclick="location.href=${pageContext.request.contextPath}/kkomi/info.kko">
          수련소로 돌아가기
        </button>
      </section>
    </div>
  </main>
  <jsp:include page="/app/include/footer.jsp" />
</body>


</html>