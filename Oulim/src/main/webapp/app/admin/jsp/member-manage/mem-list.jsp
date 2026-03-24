<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>mem-list</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />
<!-- 컨포넌트 css 선택-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/pagination.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/input.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/button.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/list.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/card.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/DetailCard.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/badge.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app/admin/css/member-manage/mem-list.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app/admin/css/aside.css" />
    <script>
    	const contextPath = "${pageContext.request.contextPath}";
    </script>
	<script defer src="${pageContext.request.contextPath}/app/admin/js/member-manage/mem-list.js"></script>

</head>

<body>
	<main class="l-main">
		<jsp:include page="/app/admin/jsp/aside.jsp" />

		<!-- 메인헤더 -->
		<section class="l-content">
			<div class="header">
				<h1>회원조회</h1>
			</div>
			<div class="c-list c-list--6col">
				<!-- header -->
				<form id="content-area"
					action="${pageContext.request.contextPath}/admin/memList.adm"
					method="get">
					<select class="search-item" name="searchType">
						<option value="userNo">유저번호</option>
						<option value="userId">아이디</option>
						<option value="userNickname">닉네임</option>
						<option value="userType">회원종류</option>
						<option value="userName">이름</option>
					</select> <input type="text" class="c-input" name="keyword"
						value="${requestScope.keyword}" placeholder="검색 조건" />
					<button class="c-button c-button--primary c-button--md"
						type="submit">조회</button>
				</form>


			       <div class="c-list c-list--6col">
			          <!-- header -->
			          <div class="c-list__header">
			            <span class="c-list__col">유저번호</span>
			            <span class="c-list__col">아이디</span>
			            <span class="c-list__col">닉네임</span>
			            <span class="c-list__col">회원종류</span>
			            <span class="c-list__col">이름</span>
			       </div>
				<!-- body -->
				
				<div class="c-list__body">
					<c:forEach var="member" items="${memberList}">
						<div class="c-list__row"
						     data-href="${pageContext.request.contextPath}/admin/memDetail.adm?userNo=${member.userNo}">
							<span class="c-list__col">${member.userNo}</span> <span
								class="c-list__col">${member.userId}</span>

							<c:choose>
								<c:when test="${empty member.userNickname}">
									<span class="c-list__col">-</span>
								</c:when>
								<c:otherwise>
									<span class="c-list__col">${member.userNickname}</span>
								</c:otherwise>
							</c:choose>

							<span class="c-list__col">${member.userTypeText}</span> <span
								class="c-list__col">${member.userName}</span>
						</div>
					</c:forEach>
				</div>
			</div>

			<div class="page">
				<!-- 페이지네이션  c-pagination-->
				<nav class="c-pagination">
				  <c:if test="${prev}">
				    <a class="c-pagination__link"
				       href="${pageContext.request.contextPath}/admin/memList.adm?page=${startPage - 1}${queryString}">‹</a>
				  </c:if>
				
				  <c:if test="${not prev}">
				    <a class="c-pagination__link is-disabled">‹</a>
				  </c:if>
				
				  <c:forEach var="i" begin="${startPage}" end="${endPage}">
				    <a class="c-pagination__link ${i == page ? 'is-active' : ''}"
				       href="${pageContext.request.contextPath}/admin/memList.adm?page=${i}${queryString}">
				       ${i}
				    </a>
				  </c:forEach>
				
				  <c:if test="${next}">
				    <a class="c-pagination__link"
				       href="${pageContext.request.contextPath}/admin/memList.adm?page=${endPage + 1}${queryString}">›</a>
				  </c:if>
				
				  <c:if test="${not next}">
				    <a class="c-pagination__link is-disabled">›</a>
				  </c:if>
				</nav>
			</div>
		</section>

	</main>


</body>

</html>