<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>point-history</title>

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
	href="${pageContext.request.contextPath}/asset/css/pages/mypage/point-history/point-history.css">


<script defer
	src="${pageContext.request.contextPath}/asset/js/pages/mypage/point-history/point-history.js"></script>

</head>

<body>
	<jsp:include page="/app/include/header.jsp" />

	<main class="l-main">

		<div class="l-mypage">

			<div class="l-mypage--aside">

				<aside>

					<div class="p-point-history--menu">

						<ul>

							<h2>마이페이지</h2>

							<div class="p-point-history--menu-group">
								<li>나의 정보</li> <br> <a
									href="${pageContext.request.contextPath}/mypage/checkOk.mp">
									<li>- 내 정보 보기</li>
								</a> <br> <a
									href="${pageContext.request.contextPath}/mypage/userEdit.mp">
									<li>- 내 정보 수정</li>
								</a>
							</div>

							<div class="p-point-history--menu-group">
								<li>봉사조회</li> <br> <a
									href="${pageContext.request.contextPath}/mypage/comingVolun.mp">
									<li>- 예정된 봉사 이력 조회</li>
								</a> <br> <a
									href="${pageContext.request.contextPath}/mypage/finishVolun.mp">
									<li>- 완료된 봉사 이력 조회</li>
								</a>
							</div>

							<div class="p-point-history--menu-group">
								<a href="${pageContext.request.contextPath}/mypage/point.mp"><li>포인트
										조회</li></a>
							</div>

							<div class="p-point-history--menu-group">
								<a href="${pageContext.request.contextPath}/mypage/myPost.mp">
									<li>작성글 조회</li>
								</a>
							</div>

							<div class="p-point-history--menu-group">
								<a href="${pageContext.request.contextPath}/mypage/quit.mp">
									<li>회원 탈퇴</li>
								</a>
							</div>

						</ul>

					</div>

				</aside>

			</div>

			<div class="l-mypage--content">

				<div class="p-point-history--header">
					<h1>포인트 조회</h1>
				</div>

				<div class="p-point-history--body">


					<div class="p-point-history--nav">
						<nav>
							<a href="?plusPage=1&minusPage=1&tab=plus" id="plus"
								class="${activeTab eq 'plus' ? 'active' : ''}">적립 포인트</a> <a
								href="?plusPage=1&minusPage=1&tab=minus" id="minus"
								class="${activeTab eq 'minus' ? 'active' : ''}">사용 포인트</a>
						</nav>
						<hr>
					</div>

					<div id="a" class="p-point-history--earn-list"
						style="${activeTab eq 'plus' ? 'display:block;' : 'display:none;'}">
						<ul>
							<c:forEach var="p" items="${plusPoint}">
								<li>
									<div>
										<h5>${p.logReason}</h5>
										<h5>${p.logDate}</h5>
									</div>
									<div>${p.changeAmount}p</div>
								</li>
							</c:forEach>
						</ul>
					</div>

					<div id="b" class="p-point-history--use-list"
						style="${activeTab eq 'minus' ? 'display:block;' : 'display:none;'}">
						<ul>
							<c:forEach var="m" items="${minusPoint}">
								<li>
									<div>
										<h5>${m.logReason}</h5>
										<h5>${m.logDate}</h5>
									</div>
									<div>${m.changeAmount}p</div>
								</li>
							</c:forEach>
						</ul>
					</div>

<div class="p-point-history--pagination">

    <c:choose>

        <c:when test="${activeTab eq 'plus'}">
            <c:if test="${plusLastPage > 1}">
                <nav class="c-pagination">

                    <c:if test="${plusPage > 1}">
                        <a class="c-pagination__link"
                           href="?plusPage=${plusPage-1}&minusPage=${minusPage}&tab=plus">‹</a>
                    </c:if>

                    <c:forEach var="i" begin="1" end="${plusLastPage}">
                        <a class="c-pagination__link ${i eq plusPage?'is-active':''}"
                           href="?plusPage=${i}&minusPage=${minusPage}&tab=plus">${i}</a>
                    </c:forEach>

                    <c:if test="${plusPage < plusLastPage}">
                        <a class="c-pagination__link"
                           href="?plusPage=${plusPage+1}&minusPage=${minusPage}&tab=plus">›</a>
                    </c:if>

                </nav>
            </c:if>
        </c:when>

        <c:when test="${activeTab eq 'minus'}">
            <c:if test="${minusLastPage > 1}">
                <nav class="c-pagination">

                    <c:if test="${minusPage > 1}">
                        <a class="c-pagination__link"
                           href="?plusPage=${plusPage}&minusPage=${minusPage-1}&tab=minus">‹</a>
                    </c:if>

                    <c:forEach var="i" begin="1" end="${minusLastPage}">
                        <a class="c-pagination__link ${i eq minusPage ? 'is-active' : ''}"
                           href="?plusPage=${plusPage}&minusPage=${i}&tab=minus">${i}</a>
                    </c:forEach>

                    <c:if test="${minusPage < minusLastPage}">
                        <a class="c-pagination__link"
                           href="?plusPage=${plusPage}&minusPage=${minusPage+1}&tab=minus">›</a>
                    </c:if>

                </nav>
            </c:if>
        </c:when>

    </c:choose>

</div>
</div>
				

			</div>

		</div>

	</main>


	<jsp:include page="/app/include/footer.jsp" />

</body>

</html>