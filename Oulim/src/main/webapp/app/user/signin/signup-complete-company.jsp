<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>기업 가입 완료</title>

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
	href="${pageContext.request.contextPath}/asset/css/pages/user/signin/signup-complete-company.css" />
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
			<form action="${pageContext.request.contextPath}/">
				<div class="p-signup-complete-company">
					<div class="l-signup-complete-company-layout">
						<div>
							<img src="${pageContext.request.contextPath}/asset/image/join/wait_check.png" alt="확인이미지" />
						</div>
						<div class="l-signup-complete-company-title">
							<div>
								<h2>회원가입 신청이 완료 되었습니다.</h2>
							</div>
							<div>
								<h5>회원 가입 승인 완료시 로그인 가능합니다.</h5>
								<h5>메인버튼 선택 시 메인 화면으로 이동합니다.</h5>
							</div>
						</div>
					</div>
				</div>
				
				<div class="c-signup-complete-company">
					<button class="c-button c-button--primary c-button--md"
					onclick="/">
						다음</button>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="/app/include/footer.jsp" />
</body>

</html>
