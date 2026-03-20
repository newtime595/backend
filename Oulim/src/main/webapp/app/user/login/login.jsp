<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>login</title>

<!-- base css 필수 삽입-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />
<!-- 컨포넌트 css 선택-->
<!-- <link rel="stylesheet" href="/Oulim/asset/css/component/pagination.css" /> -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/input.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/button.css" />
<!-- <link rel="stylesheet" href="/Oulim/asset/css/component/list.css" /> -->
<!-- <link rel="stylesheet" href="/Oulim/asset/css/component/card.css" /> -->
<!-- <link rel="stylesheet" href="/Oulim/asset/css/component/DetailCard.css" /> -->
<!-- <link rel="stylesheet" href="/Oulim/asset/css/component/badge.css" /> -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/layout.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/user/login/login.css" />
<script defer src="${pageContext.request.contextPath}/asset/js/pages/user/login/login.js"></script>
<script>
	const contextPath = "${pageContext.request.contextPath}";
</script>
</head>

<body>
	<jsp:include page="/app/include/header.jsp" />
	<div class="l-main">
		<div class="l-container">
			<form action="${pageContext.request.contextPath}/user/loginOk.usr" method="post" id="loginForm">
			<input type="hidden" id="loginStatus" value="${param.login}">
				<div class="p-login">
					<div class="l-login-layout">
						<div>
							<h2>로그인</h2>
						</div>
						<div>
							<h5>아이디와 비밀번호를 작성해 주세요.</h5>
							<div class="l-login-input-layout">
								<div>
									<h6 class="text-sm">아이디</h6>
								</div>
								<div>
									<input type="text" name="userId" id="userId" class="c-input" 
									placeholder="아이디 입력해주세요" />
								</div>
								<p class="is-error-message" id="userIDError"></p>
							</div>
							<div class="l-login-input-layout">
								<div>
									<h6 class="text-sm">비밀번호</h6>
								</div>
								<div class="l-toggle-layout">
									<input type="password" name="userPw" id="userPw" class="c-input" placeholder="비밀번호 입력해주세요" />
									<button type="button" id="c-password-btn-toggle">
										<img src="${pageContext.request.contextPath}/asset/image/user/password-off.png" alt="eye"
											id="c-password-toggle-img" />
									</button>
								</div>
								<p class="is-error-message" id="userPwError"></p>
							</div>
							<div class="l-login-signup-layout">
								<div>
									<a href="${pageContext.request.contextPath}/app/user/signin/signup-terms.jsp">회원가입</a>
								</div>
								<div>
									<a href="${pageContext.request.contextPath}/app/user/find-idpassword/id-find.jsp">아이디
										찾기</a>
								</div>
								<div>
									<a
										href="${pageContext.request.contextPath}/app/user/find-idpassword/password-find.jsp">비밀번호
										찾기</a>
								</div>
							</div>
						</div>
						<button type="submit"
							class="c-button c-button--primary c-button--md">
							로그인</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="/app/include/footer.jsp" />
</body>
</html>
