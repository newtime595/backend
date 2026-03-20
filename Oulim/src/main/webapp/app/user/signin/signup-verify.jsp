<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>회원가입 본인인증</title>

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
	href="${pageContext.request.contextPath}/asset/css/pages/user/signin/signup-verify.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />
<script defer
	src="${pageContext.request.contextPath}/asset/js/pages/user/signin/signup-verify.js"></script>
<script>
	const contextPath = "${pageContext.request.contextPath}";
</script>
</head>

<body>
	<jsp:include page="/app/include/header.jsp" />
	<div class="l-main">
		<div class="l-container">
			<div class="p-signup-verify-main">
				<form
					action="${pageContext.request.contextPath}/user/normalJoinFirstOk.usr"
					method="post">
					<input type="hidden" id="company-email-verified" name="emailVerified" value="false" />
					<div class="l-signup-verify-layout">
						<div>
							<h2>회원가입</h2>
						</div>

						<div class="c-signup-verify-text">
							<h4>가입자의 본인확인을 진행합니다</h4>
							<br />
							<h6>인증된 기본정보로 가입을 진행합니다</h6>
						</div>

						<div class="c-signup-verify-input">
							<h6>이름</h6>
							<input type="text" name="userName" id="user-name" class="c-input"
								placeholder="이름을 입력해주세요" />
							<p id="is-user-name-error" class="is-error-text"></p>
						</div>
						<div class="c-signup-verify-input">
							<h6>생년월일</h6>
							<input type="date" name="userBirth" id="user-birth"
								class="c-input" placeholder="생년월일을 입력해주세요" />
							<p id="is-user-birth-error" class="is-error-text"></p>
						</div>

						<div class="c-signup-verify-input">
							<h6>이메일</h6>
							<div class="l-signup-info-input-layout">
								<div class="c-signup-verify-input">
									<input type="text" name="userEmail" id="company-email"
										class="c-input" placeholder="이메일을 입력해주세요" />
									<p id="is-company-email-error" class="is-error-text"></p>
								</div>
								<div class="c-signup-btn">
									<button type="button"
										class="c-button c-button--secondary c-button--md"
										id="company-email-check-btn">인증발송</button>
								</div>
							</div>
						</div>
						<div class="c-signup-verify-input-number">
							<h6>이메일 인증번호</h6>
							<div class="l-signup-verify-number-layout">
								<div>
									<input type="text" name="emailAuthCode"
										id="company-email-auth-code" class="c-input"
										placeholder="인증번호입력" />
									<div class="c-signup-verify-numbertime"
										id="company-email-timer">3:00</div>
								</div>
								<div class="c-signup-btn">
									<button class="c-button c-button--secondary c-button--md"
										type="button" id="company-email-auth-confirm-btn">인증확인</button>
								</div>
							</div>
							<p id="is-company-email-auth-error" class="is-error-text"></p>
						</div>

						<div class="c-signup-verify-input">
							<h6>휴대전화</h6>
							<div class="l-signup-verify-layout-btn">
								<input type="text" name="userPhoneNum" id="user-phone"
									class="c-input" placeholder="휴대전화번호 입력" />
								<div class="c-signup-btn">
									<button class="c-button c-button--secondary c-button--md"
										type="button">인증 보내기</button>
								</div>
							</div>
							<p id="is-user-phone-error" class="is-error-text"></p>
						</div>

						<div class="c-signup-verify-input-number">
							<h6>인증번호</h6>
							<div class="l-signup-verify-number-layout">
								<div>
									<input type="text" name="" id="" class="c-input"
										placeholder="인증번호입력" />
									<div class="c-signup-verify-numbertime">3:00</div>
								</div>
								<div class="c-signup-btn">
									<button class="c-button c-button--secondary c-button--md"
										type="button">인증확인</button>
								</div>
							</div>
						</div>
						<div class="c-signup-verify-nextbtn">
							<button class="c-button c-button--primary c-button--md"
								id="is-next-btn" type="submit">다 음</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="/app/include/footer.jsp" />
</body>
</html>
