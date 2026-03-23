<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>기업 회원가입 본인인증</title>

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
	href="${pageContext.request.contextPath}/asset/css/pages/user/signin/signup-verify-company.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />
<script defer
	src="${pageContext.request.contextPath}/asset/js/pages/user/signin/signup-verify-company.js"></script>
<script>
	const contextPath = "${pageContext.request.contextPath}";
</script>
</head>

<body>
	<jsp:include page="/app/include/header.jsp" />
	<div class="l-main">
		<div class="l-container">
			<div class="p-signup-verify-company-main">
				<form
					action="${pageContext.request.contextPath}/user/organJoinFirstOk.usr"
					method="post" enctype="multipart/form-data">
					<input type="hidden" name="emailVerified"
						id="company-email-verified" value="false" />
					<div class="l-signup-verify-company-layout">
						<div>
							<h2>회원가입</h2>
						</div>

						<div class="c-signup-verify-company-text">
							<h4>가입자의 본인확인을 진행합니다</h4>
							<br />
							<h6>인증된 기본정보로 가입을 진행합니다</h6>
						</div>

						<div class="c-signup-verify-company-input">
							<h6>기관명</h6>
							<input type="text" name="organName" id="company-name"
								class="c-input" placeholder="소속회사" maxlength="50" />
							<p id="is-company-name-error" class="is-error-text"></p>
						</div>
						<div class="c-signup-verify-company-input">
							<h6>이름</h6>
							<input type="text" name="userName" id="company-user-name"
								class="c-input" placeholder="이름 입력해주세요" maxlength="50" />
							<p id="is-company-user-name-error" class="is-error-text"></p>
						</div>
						<div class="c-signup-verify-company-input">
							<h6>생년월일</h6>
							<input type="date" name="userBirth" id="company-birth"
								class="c-input" placeholder="생년월일을 입력해주세요" maxlength="8"/>
							<p id="is-company-birth-error" class="is-error-text"></p>
						</div>
						<div class="c-signup-verify-company-input">
							<h6>사업자 등록번호</h6>
							<input type="text" name="organCertNum" id="company-cert-num"
								class="c-input" placeholder="사업자 등록 번호( - 제외)를 입력해주세요" maxlength="20" />
							<p id="is-company-user-name-error" class="is-error-text"></p>
						</div>

						<div class="c-signup-verify-company-input">
							<h6>이메일</h6>
							<div class="l-signup-info-company-input-layout">
								<div class="c-signup-verify-company-input">
									<input type="text" name="userEmail" id="company-email"
										class="c-input" placeholder="이메일을 입력해주세요" maxlength="50"/>
									<p id="is-company-email-error" class="is-error-text"></p>
								</div>
								<div class="c-signup-company-btn">
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
										placeholder="인증번호입력" maxlength="6" />
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
						<div class="c-signup-verify-company-input-file">
							<h6>파일 첨부 (재직증명서 사본과 사업자등록증 사본을 하나의 pdf로 올려주세요)</h6>
							<div>
								<input type="text" id="company-file-name-1"
									class="c-siginup-verify-company-filename"
									placeholder="재직증명서 사업자등록증 합본" readonly /> <input type="file"
									name="certFile" id="company-file-1"
									class="c-siginup-verify-company-file" />
								<div class="c-signup-company-btn">
									<button class="c-button c-button--secondary c-button--md"
										type="button" id="company-file-btn-1">첨부파일</button>
								</div>
							</div>
						</div>
						<div class="c-signup-verify-company-nextbtn">
							<button type="submit"
								class="c-button c-button--primary c-button--md"
								id="is-company-next-btn">다 음</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="/app/include/footer.jsp" />
</body>
</html>
