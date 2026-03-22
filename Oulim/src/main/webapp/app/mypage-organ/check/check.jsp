<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>check</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/typography.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/input.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/button.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/mypage-organ/check/check.css" />

<script defer
	src="${pageContext.request.contextPath}/asset/js/pages/main/include.js"></script>
<script defer
	src="${pageContext.request.contextPath}/asset/js/pages/mypage-organ/check/check.js"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />
</head>

<body>

	<jsp:include page="/app/include/header.jsp" />

	<main class="l-main">
		<div class="l-mypage">

			<div class="l-mypage--aside">
				<aside>
					<div class="p-mypage-check--menu">
						<ul>
							<li><h2>마이페이지</h2></li>

							<li class="p-mypage-check--menu-group">
								<a href="${pageContext.request.contextPath}/mypage/organcheck.mp">내 정보 보기</a>
							</li>

							<li class="p-mypage-check--menu-group">
								<a href="${pageContext.request.contextPath}/mypage/organcheck.mp">회원 탈퇴</a>
							</li>
						</ul>
					</div>
				</aside>
			</div>

			<div class="l-mypage--content">
				<div class="p-mypage-check--header">
					<div class="p-mypage-check--title">
						<h1>마이페이지</h1>
					</div>

					<div class="p-mypage-check--desc">
						<h5>마이페이지는 비밀번호 확인 후 이용가능합니다</h5>
					</div>
				</div>

				<form action="${pageContext.request.contextPath}/mypage/organcheckOk.mp" method="post">
					<div class="p-mypage-check--form">

						<div class="p-mypage-check--label">
							<h5>비밀번호</h5>
						</div>

						<div class="p-mypage-check--input">
							<input type="password" id="password" class="c-input" name="userPw"
								placeholder="비밀번호 입력" />
								<img src="${pageContext.request.contextPath}/asset/image/user/password-off.png"
									alt="eye" id="c-password-toggle-img" />
							<button type="button" id="c-password-btn-toggle">			
							</button>
						</div>

					</div>

					<div class="c-button-group">
						<button type="submit" id="accept"
							class="c-button c-button--primary c-button--md"
							style="width: 120px">확인</button>

						<button type="button" id="cancel"
							class="c-button c-button--secondary c-button--md"
							style="width: 120px">취소</button>
					</div>
				</form>
			</div>

		</div>
	</main>

	<jsp:include page="/app/include/footer.jsp" />

</body>
</html>