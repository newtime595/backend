<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>coming-volunteer</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />

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
	href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/mypage/volunteer-history/coming-volunteer.css" />

</head>

<body>
	<jsp:include page="/app/include/header.jsp" />

	<main class="l-main">

		<div class="main-container">

			<!-- aside -->
			<div class="main-aside">
				<aside>
					<div class="main-aside-list">

						<h2>마이페이지</h2>

						<ul class="list1">
							<li>나의 정보</li>
							<br>
							<a href="${pageContext.request.contextPath}/mypage/checkOk.mp">
								<li>- 내 정보 보기</li>
							</a>
							<br>
							<a href="${pageContext.request.contextPath}/mypage/userEdit.mp">
								<li>- 내 정보 수정</li>
							</a>
							<br>
						</ul>

						<ul class="list2">
							<li>봉사조회</li>
							<br>
							<a
								href="${pageContext.request.contextPath}/mypage/comingVolun.mp">
								<li>- 예정된 봉사 이력 조회</li>
							</a>
							<br>
							<a
								href="${pageContext.request.contextPath}/mypage/finishVolun.mp">
								<li>- 완료된 봉사 이력 조회</li>
							</a>

						</ul>

						<ul class="list3">
							<a href="${pageContext.request.contextPath}/mypage/point.mp">
								<li>포인트 조회</li>
							</a>
						</ul>

						<ul class="list4">
							<a href="${pageContext.request.contextPath}/mypage/myPost.mp">
								<li>작성글 조회</li>
							</a>
						</ul>

						<ul class="list5">
							<a href="${pageContext.request.contextPath}/mypage/quit.mp">
								<li>회원 탈퇴</li>
							</a>
						</ul>

					</div>
				</aside>
			</div>


			<!-- content -->
			<div class="main-2">

				<div class="main-section1">
					<h1>예정된 봉사 이력 조회</h1>
				</div>


				<div class="main-section3">
					<a
						href="${pageContext.request.contextPath}/front/html/volunteer-activity/volunAct-detail.html">

						<div class="c-card">

							<div class="c-card__header">
								<span class="c-badge c-badge--primary">모집중</span>
							</div>

							<h3 class="c-card__title">주민과 함께하는 제설작업 봉사 모집</h3>


							<div class="c-card__footer">
								<span>2026.02.03 ~ 2026.02.06</span>
							</div>

						</div>
					</a>


				</div>

				<div class="main-section3">
					<c:if test="${empty comingVol}">
						<li>등록된 봉사활동이 없습니다.</li>
					</c:if>

					<c:forEach var="item" items="${comingVol}">
						<a
							href="${pageContext.request.contextPath}/volunteer-activity/detail.va/volunAct-detail.va?volunActNo=${item.volunActNo}">
							<div class="c-card">
								<div class="c-card__header">
									<span class="c-badge c-badge--primary">모집중</span>
								</div>
								<h3 class="c-card__title">${item.volunActTitle}</h3>
								<div class="c-card__footer">
									<span>${item.comVolunActProcBegin} ~
										${item.comVolunActProcEnd}</span>
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
				<div>
					<nav class="c-pagination">
						<c:if test="${page > 1}">
							<a class="c-pagination__link" href="?page=${page-1}">‹</a>
						</c:if>
						<c:forEach var="i" begin="1" end="${lastPage}">
							<a class="c-pagination__link ${i==page?'is-active':''}"
								href="?page=${i}">${i}</a>
						</c:forEach>
						<c:if test="${page < lastPage}">
							<a class="c-pagination__link" href="?page=${page+1}">›</a>
						</c:if>
					</nav>

				</div>
	</main>

	<jsp:include page="/app/include/footer.jsp" />

</body>

</html>