<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>profile</title>

<!-- base css 필수 삽입-->
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
	href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/mypage/profile/profile.css" />

</head>

<body>
	<jsp:include page="/app/include/header.jsp" />

	<main class="l-main">
		<div class="main-container">
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
							<a
								href="${pageContext.request.contextPath}/mypage/userEdit.mp">
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

			<div class="main-2">
				<div class="main-section1">
					<img
						src="${pageContext.request.contextPath}/asset/image/character/komi-lv9.svg"
						alt="펫사진" />
					<div class="sec1-text">
						<h1>${sessionScope.userNickname}</h1>
						<br>
						<h5>총 봉사 횟수 : ${volunActNo}회</h5>
						<h5>총 봉사 시간 : ${totalVolunTime}시간</h5>
						<h5>랭킹 포인트 : ${rankPoint}p</h5>
						<h5>현재 포인트 : ${totalAmount}p</h5>
					</div>
				</div>

				<div class="main-section2">
					<a
						href="${pageContext.request.contextPath}/mypage/comingVolun.mp">
						<div class="c-card">
							<h5>나의 예정된 봉사</h5>
							<hr />
							<br>
							<div class="c-card__header">
								<span class="c-badge c-badge--primary">모집중</span>
							</div>
							<h3 class="c-card__title">${comVolunActTitle}</h3>
							<div class="c-card__footer">
								<span>${comVolunActProcBegin} ~ ${comVolunActProcEnd}</span>
							</div>
						</div>
					</a> <a
						href="${pageContext.request.contextPath}/mypage/finishVolun.mp">
						<div class="c-card">
							<h5>나의 완료된 봉사</h5>
							<hr />
							<br>
							<div class="c-card__header">
								<span class="c-badge c-badge--primary">완료</span>
							</div>
							<h3 class="c-card__title">${finVolunActTitle}</h3>
							<div class="c-card__footer">
								<span>${finVolunActProcBegin} ~ ${finVolunActProcEnd}</span>
							</div>
						</div>
					</a>
				</div>



						<a href="${pageContext.request.contextPath}/mypage/point.mp">
				<div class="c-card">
					<h5>나의포인트</h5>
					<hr />
					<br>
					<div class="main-section3">
							<c:choose>

								<c:when test="${not empty miniPoint}">

									<c:forEach var="miniPoint" items="${miniPoint}" begin="0" end="3" step="1">
										<h3 class="c-card__title">${miniPoint.logReason}</h3>
										<p class="c-card__desc">+${miniPoint.changeAmount}</p>
										<div class="c-card__footer">
											<span>${miniPoint.logDate}</span>
										</div>
										<br>
									</c:forEach>

								</c:when>

							</c:choose>
					</div>
				</div>
					</a>


			</div>
		</div>
	</main>

	<jsp:include page="/app/include/footer.jsp" />
</body>

</html>