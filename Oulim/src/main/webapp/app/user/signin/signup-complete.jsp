<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>가입 완료</title>

<!-- base css 필수 삽입-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />
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
	href="${pageContext.request.contextPath}/asset/css/pages/user/signin/signup-complete.css" />
</head>

<body>
	<jsp:include page="/app/include/header.jsp" />
	<div class="l-main">
		<div class="l-container">
			<form action="${pageContext.request.contextPath}/user/login.usr">
				<div class="p-signup-complete">
					<div class="l-signup-complete-layout">
						<div class="l-signup-complete-img">
							<img src="${pageContext.request.contextPath}/asset/image/join/complete_check.png" alt="확인이미지" />
						</div>
						<div class="l-signup-complete-title">
							<div>
								<h3>회원가입이 완료 되었습니다.</h3>
							</div>
							<div>
								<h6>로그인 버튼 선택시 로그인 화면으로 이동합니다.</h6>
							</div>
						</div>
					</div>
				</div>
				
				<div class="c-signup-complete">
					<button type="submit" class="c-button c-button--primary c-button--md">
						로그인</button>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="/app/include/footer.jsp" />
</body>
</html>
