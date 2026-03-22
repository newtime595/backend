<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>id 찾기</title>

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
	href="${pageContext.request.contextPath}/asset/css/pages/user/find-idpassword/id-find.css" />
<script defer
	src="${pageContext.request.contextPath}/asset/js/pages/user/find-idpassword/id-find.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />
<script>
  const contextPath = "${pageContext.request.contextPath}";
</script>
</head>

<body>
	<jsp:include page="/app/include/header.jsp" />
	<div class="l-main">
		<div class="l-container">
			<div class="p-id-find">
				<form action="${pageContext.request.contextPath}/user/idFindOk.usr" method="post">
					<input type="hidden" id="find-id-error-message" value="${error}">
					<div class="l-id-find-layout">
						<div>
							<h2>아이디 찾기</h2>
						</div>

						<div class="c-id-find-text">
							<h4>가입자의 본인확인을 진행합니다.</h4>
						</div>

						<div class="c-id-find-input">
							<h6>이름</h6>
							<input type="text" name="userName" id="find-id-user-name" class="c-input"
								placeholder="이름 입력해주세요" />
							<p id="is-find-id-user-name-error" class="is-error-text"></p>
						</div>
						<div class="c-id-find-input">
							<h6>생년월일</h6>
							<input type="date" name="userBirth" id="find-id-user-birth"
								class="c-input" placeholder="생년월일 입력해주세요" />
							<p id="is-find-id-user-birth-error" class="is-error-text"></p>
						</div>
						<div class="c-id-find-input">
							<h6>이메일</h6>
							<input type="text" name="userEmail" id="find-id-user-email"
								class="c-input" placeholder="이메일 입력해주세요" />
								<button type="button" id="find-id-email-btn" name="find-id-email-btn" class="c-button c-button--secondary c-button--md">
										인증전송</button>
							<p id="is-find-id-user-email-error" class="is-error-text"></p>
						</div>
						<div class="c-id-find-input-number">
							<h6>인증번호</h6>
							<div class="l-id-find-number-layout">
								<div>
									<input type="text" name="verify" id="find-id-verify" class="c-input"
										placeholder="인증번호입력" />
									<div class="c-id-find-numbertime" id="find-id-timer">3:00</div>
								</div>
								<div class="">
									<button type="button" id="find-id-verify-btn" class="c-button c-button--secondary c-button--md">
										인증확인</button>
								</div>
							</div>
						</div>
						<div class="c-id-find-nextbtn">
							<button type="submit" id="is-id-find-btn"
								class="c-button c-button--primary c-button--md">
								아이디 찾기</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="/app/include/footer.jsp" />
</body>
</html>
