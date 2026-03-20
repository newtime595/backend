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
	href="${pageContext.request.contextPath}/asset/css/core/typography.css" />

<!-- component css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/input.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/button.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/mypage-organ/profile/profile-edit.css">

<script defer
	src="${pageContext.request.contextPath}/asset/js/pages/main/include.js"></script>

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
							<br>
							<a href="${pageContext.request.contextPath}/mypage-organ/check.mp">
								<li>내 정보 보기</li>
							</a>
						</ul>
						<ul class="list5">
							<a href="${pageContext.request.contextPath}/mypage/check.mp">
								<li>회원 탈퇴</li>
							</a>
						</ul>
					</div>
				</aside>
			</div>

			<!-- content -->
			<div class="main-2">

				<div class="main-text-box">
					<h1>기업 정보 수정</h1>
				</div>
				<form action="${pageContext.request.contextPath}/mypage/organEditOk.mp" method="post">
					<div class="main-pw">

						<div class="i-nickname">

							<h5>기관명</h5>
							<div class="pw-text">
								<input id="organname" type="text" class="c-input"
									name="organname" placeholder="기관명">
								<!-- <button type="button" class="c-button c-button--primary c-button--md">중복확인</button> -->
							</div>
						</div>

						<p>
						<div class="c-form-field is-error">

							<label class="c-form-field__label">
								<h5>닉네임</h5>
							</label>
							<div class="pw-text">
								<input type="text" class="c-input" placeholder="닉네임">
								<!-- <button type="button" class="c-button c-button--primary c-button--md">중복확인</button> -->
							</div>
							<span class="c-form-field__error"> 존재하는 닉네임입니다. </span>

						</div>
						</p>

						<div class="i-email">

							<h5>이메일</h5>
							<div class="pw-text">
								<input id="email" type="text" class="c-input" name="email"
									placeholder="이메일">
								<button id="emailBtn" type="button"
									class="c-button c-button--primary c-button--md">중복확인</button>
							</div>
						</div>

						<p>
						<div class="c-form-field is-error">

							<label class="c-form-field__label">
								<h5>이메일</h5>
							</label>
							<div class="pw-text">
								<input type="text" class="c-input" placeholder="이메일">
								<button id="emailBtn2" type="button"
									class="c-button c-button--primary c-button--md">중복확인</button>
							</div>
							<span class="c-form-field__error"> 존재하는 이메일입니다. </span>

						</div>
						</p>

						<h5>인증번호</h5>
						<div class="pw-text">
							<input id="verify" type="text" class="c-input" name="verify"
								placeholder="이메일 인증번호 입력">
							<button id="verifyBtn"
								class="c-button c-button--primary c-button--md">인증확인</button>
						</div>

						<p>
						<div class="c-form-field is-error">

							<label class="c-form-field__label">
								<h5>인증번호</h5>
							</label>
							<div class="pw-text">
								<input type="email" class="c-input" placeholder="이메일 인증번호 입력">
								<button type="button"
									class="c-button c-button--primary c-button--md">인증확인</button>
							</div>
							<span class="c-form-field__error"> 인증번호가 일치하지 않습니다. </span>

						</div>
						</p>

						<h5>비밀번호 수정</h5>
						<div class="pw-text">

							<input type="password" class="c-input" name="new-password"
								placeholder="새 비밀번호 입력">
							<button type="button" id="c-password-btn-toggle">
								<img src="/Oulim/asset/image/user/password-off.png" alt="eye"
									id="c-password-toggle-img" />
							</button>
						</div>

						<h5>비밀번호 재확인</h5>
						<div class="pw-text">
							<input type="password" class="c-input" name="new-password-check"
								placeholder="비밀번호 확인">
							<button type="button" id="c-password-btn-toggle-2">
								<img src="/Oulim/asset/image/user/password-off.png" alt="eye"
									id="c-password-toggle-2-img" />
							</button>
						</div>

						<h5>주소</h5>
						<div class="pw-text">
							<input type="text" class="c-input" name="address"
								placeholder="주소 추가하기">
							<button id="addrBtn"
								class="c-button c-button--primary c-button--md">주소검색</button>
						</div>

					</div>

					<div class="c-button-group">
						<button id="accept"
							class="c-button c-button--primary c-button--md">수정</button>
						<button id="cancel"
							class="c-button c-button--secondary c-button--md">취소</button>
					</div>

				</form>

			</div>

		</div>

	</main>

	<jsp:include page="/app/include/footer.jsp" />

</body>

</html>
>
