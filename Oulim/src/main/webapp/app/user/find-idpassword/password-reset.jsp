<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>비밀번호 재설정</title>

<!-- base css 필수 삽입-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/layout.css" />
<!-- 컨포넌트 css 선택-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/input.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/button.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/layout.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/user/find-idpassword/password-reset.css" />
<script defer
	src="${pageContext.request.contextPath}/asset/js/pages/user/find-idpassword/password-reset.js"></script>
<script>
	const contextPath = "${pageContext.request.contextPath}";
</script>
</head>

<body>
	<jsp:include page="/app/include/header.jsp" />
	<div class="l-main">
		<div class="l-container">
			<div class="p-password-reset">
				<form action="${pageContext.request.contextPath}/user/pwChangeOk.usr" method="post">
					<div class="l-password-reset-layout">
						<div>
							<h2>비밀번호 재설정</h2>
						</div>

						<div class="c-password-reset-text">
							<h4>비밀번호를 재설정 해주세요.</h4>
						</div>

						<div class="c-password-reset-input">
							<h6>비밀번호</h6>
							<div class="l-toggle-layout">
								<input type="password" name="userPw" id="reset-password"
									class="c-input" />
								<button type="button" id="c-password-btn-toggle">
									<img
										src="${pageContext.request.contextPath}/asset/image/user/password-off.png"
										alt="eye" id="c-password-toggle-img" />
								</button>
							</div>
							<p id="is-reset-password-error" class="is-error-text"></p>
						</div>
						<div class="c-password-reset-input">
							<h6>비밀번호확인</h6>
							<div class="l-toggle-layout-2">
								<input type="password" name="userPwCheck" id="reset-password-check"
									class="c-input" />
								<button type="button" id="c-password-btn-toggle-2">
									<img
										src="${pageContext.request.contextPath}/asset/image/user/password-off.png"
										alt="eye" id="c-password-toggle-img-2" />
								</button>
							</div>
							<p id="is-reset-password-check-error" class="is-error-text"></p>
						</div>

						<div class="c-password-reset-nextbtn">
							<button id="is-reset-btn"
								class="c-button c-button--primary c-button--md">비밀번호 변경</button>
							<button type="button"
								class="c-button c-button--secondary c-button--md"
								onclick="location.href='${pageContext.request.contextPath}/user/login.usr'">
								취소</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="/app/include/footer.jsp" />
</body>
</html>
