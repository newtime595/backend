<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>profile-edit</title>

<!-- base css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />

<!-- component css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/input.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/button.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/mypage-organ/profile/profile-edit.css">
<script>
	const contextPath = "${pageContext.request.contextPath}";
</script>
<script defer
	src="${pageContext.request.contextPath}/asset/js/pages/mypage-organ/profile/profile-edit.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />
</head>

<body>

	<jsp:include page="/app/include/header.jsp" />

	<main class="l-main">

		<div class="main-container">

			<!-- aside -->
			<div class="main-aside">
				<aside>
					<div class="main-aside-list">

						<h2>마이페이지</h2>

						<ul class="list1">
							<a href="${pageContext.request.contextPath}/mypage/organEdit.mp">
								<li>내 정보 보기</li>
							</a>
						</ul>
						<ul class="list5">
							<a href="${pageContext.request.contextPath}/mypage/quit.mp">
								<li>회원 탈퇴</li>
							</a>
						</ul>
					</div>
				</aside>
			</div>

			<!-- content -->
			<div class="main-2">

				<div class="main-text-box">
					<h1>나의 기업 정보</h1>
				</div>
				<div class="main-pw">

					<div class="i-nickname">
						<h5>기관명</h5>
						<div class="pw-text">
							<input id="organname" type="text" class="c-input"
								name="organName" value="${mypageInfo.organName}" readonly>
						</div>
					</div>

					<label class="c-form-field__label">
						<h5>사업자 등록 번호</h5>
					</label>
					<div class="pw-text">
						<input id="organcertnum" type="text" class="c-input"
							name="organCertNum" value="${mypageInfo.organCertNum}" readonly>
					</div>
					<form id="emailUpdateForm"
						action="${pageContext.request.contextPath}/mypage/updateEmail.mp"
						method="post">
						<div class="i-email">

							<h5>이메일</h5>
							<div class="pw-text">
								<input id="email" type="text" class="c-input" name="userEmail"
									placeholder="이메일을 입력해주세요." value="${mypageInfo.userEmail}">
								<button id="emailBtn" type="button"
									class="c-button c-button--primary c-button--md">인증발송</button>
							</div>
						</div>

						<h5>인증번호</h5>
						<div class="pw-text">
							<input id="verify" type="text" class="c-input" name="verify"
								placeholder="이메일 인증번호 입력">
								<div class="c-id-find-numbertime" id="find-id-timer">3:00</div>
							<button type="submit" id="emailVerifyBtn"
								class="c-button c-button--primary c-button--md">인증확인</button>
						</div>
					</form>

					<form
						action="${pageContext.request.contextPath}/mypage/updatePw.mp"
						method="post">
						<h5>비밀번호 수정</h5>
						<div class="pw-text">

							<input type="password" class="c-input" name="new-pw"
								placeholder="새 비밀번호 입력">
							<button type="button" id="c-password-btn-toggle">
								<img src="${pageContext.request.contextPath}/asset/image/user/password-off.png" alt="eye"
									id="c-password-toggle-img" />
							</button>
						</div>

						<h5>비밀번호 재확인</h5>
						<div class="pw-text">
							<input type="password" class="c-input" name="new-pw-check"
								placeholder="비밀번호 확인">
							<button type="button" id="c-password-btn-toggle-2">
								<img src="${pageContext.request.contextPath}/asset/image/user/password-off.png" alt="eye"
									id="c-password-toggle-2-img" />
							</button>
							<button type="submit" id="pwVerifyBtn"
								class="c-button c-button--primary c-button--md">수정</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</main>

	<jsp:include page="/app/include/footer.jsp" />

</body>

</html>

