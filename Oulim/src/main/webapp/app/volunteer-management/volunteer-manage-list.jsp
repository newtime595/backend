<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>volunteer-manage-list</title>

<!-- base css 필수 삽입-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/typography.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/layout.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/volunteer-manage/volunteer-manage-list.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />
<!-- 컨포넌트 css 선택-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/pagination.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/button.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/list.css" />

<script defer src="${pageContext.request.contextPath}/asset/js/pages/main/include.js"></script>
<script defer
	src="${pageContext.request.contextPath}/asset/js/pages/volunteer-manage/volunteer-manage-register.js"></script>
<script
	src="${pageContext.request.contextPath}/asset/js/pages/volunteer-manage/volunteer-manage-list.js"
	defer></script>
</head>

<body>
	<jsp:include page="/app/include/header.jsp" />

	<main class="l-main">
		<section class="p-volunteer-manage-list">
			<div class="l-container">
				<div class="p-volunteer-manage-list_header">
					<h1 class="p-volunteer-manage-list_title">봉사관리</h1>
					<a
						href="/Oulim/front/html/volunteer-management/volunteer-manage-register.html">
						<button class="c-button c-button--primary c-button--md">봉사
							등록</button>
					</a>
				</div>
				<div class="p-volunteer-manage-list_content">
					<div class="c-list c-list--3col">
						<!-- header -->
						<div class="c-list__header">
							<span class="c-list__col">제목</span> <span class="c-list__col">기간</span>
							<span class="c-list__col">상태</span>
						</div>
						<!-- body -->
						<div class="c-list__body" id="volunteerListBody"></div>
					</div>
				</div>

				<!-- 페이지네이션  c-pagination-->
				<nav class="c-pagination"></nav>
			</div>
		</section>
	</main>

<jsp:include page="/app/include/footer.jsp" />
</body>

</html>