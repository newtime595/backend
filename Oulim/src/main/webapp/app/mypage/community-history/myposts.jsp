<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>myposts</title>

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
	href="${pageContext.request.contextPath}/asset/css/pages/mypage/community-history/myposts.css">

</head>

<body>

	<jsp:include page="/app/include/header.jsp" />

	<main class="l-main">

		<div class="l-mypage">

			<div class="l-mypage--aside">

				<aside>

					<div class="p-mypage-posts--menu">

						<ul>

							<h2>마이페이지</h2>

							<div class="p-mypage-posts--menu-group">
								<li>나의 정보</li> <br> <a
									href="${pageContext.request.contextPath}/mypage/checkOk.mp"><li>-
										내 정보 보기</li></a> <br> <a
									href="${pageContext.request.contextPath}/mypage/userEdit.mp"><li>-
										내 정보 수정</li></a>
							</div>

							<div class="p-mypage-posts--menu-group">
								<li>봉사조회</li> <br> <a
									href="${pageContext.request.contextPath}/mypage/comingVolun.mp"><li>-
										예정된 봉사 이력 조회</li></a> <br> <a
									href="${pageContext.request.contextPath}/mypage/finishVolun.mp"><li>-
										완료된 봉사 이력 조회</li></a>
							</div>

							<div class="p-mypage-posts--menu-group">
								<a href="${pageContext.request.contextPath}/mypage/point.mp"><li>포인트
										조회</li></a>
							</div>

							<div class="p-mypage-posts--menu-group">
								<a href="${pageContext.request.contextPath}/mypage/myPost.mp"><li>작성글
										조회</li></a>
							</div>

							<div class="p-mypage-posts--menu-group">
								<a href="${pageContext.request.contextPath}/mypage/quit.mp"><li>회원
										탈퇴</li></a>
							</div>

						</ul>

					</div>

				</aside>

			</div>

			<div class="l-mypage--content">

				<div class="p-mypage-posts--header">
					<h1>나의 작성글</h1>
				</div>

				<div class="p-mypage-posts--body">

					<div class="c-list c-list--4col">

						<div class="c-list__header">
							<span class="c-list__col">제목</span> <span class="c-list__col">작성일</span>
							<span class="c-list__col">추천수</span> <span class="c-list__col">-</span>
						</div>

						<div class="c-list__body">

							<c:choose>
								<c:when test="${empty mypost}">
									<div class="c-list__row">
										<span class="c-list__col">작성한 글이 없습니다.</span>
									</div>
								</c:when>

								<c:otherwise>
									<c:forEach var="post" items="${mypost}">
										<div class="c-list__row">

											<span class="c-list__col"> ${post.postTitle} </span> <span
												class="c-list__col"> ${post.postDate} </span> <span
												class="c-list__col"> ${post.postLikeNo == null ? 0 : post.postLikeNo}
											</span>

											<div class="c-list__actions">
												<a
													href="${pageContext.request.contextPath}/community/repost.commu?postNo=${post.postNo}">
													<button class="c-button c-button--primary c-button--sm">
														수정</button>
												</a>
											</div>

										</div>
									</c:forEach>
								</c:otherwise>
							</c:choose>

						</div>

					</div>

					<c:if test="${showPagination}">
						<div class="p-mypage-posts--pagination">
							<nav class="c-pagination">

								<!-- 이전 페이지 방향키 -->
								<c:if test="${hasPrevPage}">
									<a class="c-pagination__link"
										href="${pageContext.request.contextPath}/mypage/myPost.mp?page=${page - 1}">‹</a>
								</c:if>

								<!-- 이전 블록 -->
								<c:if test="${prev}">
									<a class="c-pagination__link"
										href="${pageContext.request.contextPath}/mypage/myPost.mp?page=${startPage - 1}">«</a>
								</c:if>

								<!-- 페이지 번호 -->
								<c:forEach var="i" begin="${startPage}" end="${endPage}">
									<a class="c-pagination__link ${i == page ? 'is-active' : ''}"
										href="${pageContext.request.contextPath}/mypage/myPost.mp?page=${i}">${i}</a>
								</c:forEach>

								<!-- 다음 블록 -->
								<c:if test="${next}">
									<a class="c-pagination__link"
										href="${pageContext.request.contextPath}/mypage/myPost.mp?page=${endPage + 1}">»</a>
								</c:if>

								<!-- 다음 페이지 방향키 -->
								<c:if test="${hasNextPage}">
									<a class="c-pagination__link"
										href="${pageContext.request.contextPath}/mypage/myPost.mp?page=${page + 1}">›</a>
								</c:if>

							</nav>
						</div>
					</c:if>

				</div>

			</div>

		</div>

	</main>


	<jsp:include page="/app/include/footer.jsp" />
</body>

</html>