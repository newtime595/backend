<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>profile-edit</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/layout.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/input.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/button.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/mypage/profile/profile-edit.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />
<script>
	const contextPath = "${pageContext.request.contextPath}";
</script>
<script defer
	src="${pageContext.request.contextPath}/asset/js/pages/mypage/profile/profile-edit.js"></script>
</head>

<body>
	<jsp:include page="/app/include/header.jsp" />

	<main class="l-containe">
		<div class="main-container">
			<div class="main-aside">
				<aside>
					<div class="main-aside-list">

						<h2>마이페이지</h2>

						<ul class="list1">
							<li>나의 정보</li>
							<br>
							<a href="${pageContext.request.contextPath}/mypage/profile.mp">
								<li>- 내 정보 보기</li>
							</a>
							<br>
							<a href="${pageContext.request.contextPath}/mypage/userEdit.mp">
								<li>- 내 정보 수정</li>
							</a>
							<br>
						</ul>

						<ul class="list2">
							<li>봉사조회</li>
							<br>
							<a
								href="${pageContext.request.contextPath}/mypage/comingVolun.mp">
								<li>- 예정된 봉사 이력 조회</li>
							</a>
							<br>
							<a
								href="${pageContext.request.contextPath}/mypage/finishVolun.mp">
								<li>- 완료된 봉사 이력 조회</li>
							</a>

						</ul>

						<ul class="list3">
							<a href="${pageContext.request.contextPath}/mypage/point.mp">
								<li>포인트 조회</li>
							</a>
						</ul>

						<ul class="list4">
							<a href="${pageContext.request.contextPath}/mypage/myPost.mp">
								<li>작성글 조회</li>
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

			<div class="main-2">
				<div class="main-text-box">
					<h1>나의 정보 수정</h1>
				</div>

				<form
					action="${pageContext.request.contextPath}/mypage/userEditOk.mp"
					method="post" id="editForm">
					<div class="main-pw">

						<div class="c-form-field">
							<label class="c-form-field__label" for="nickname">닉네임</label>
							<div class="pw-text">
								<input type="text" class="c-input" id="userNickname"
									name="userNickname" value="${userNickname}"
									placeholder="닉네임 입력">
								<button type="button"
									class="c-button c-button--primary c-button--lg"
									id="checkNickname">중복확인</button>
							</div>
							<p class="c-form-field__error" id="nicknameError"
								style="display: none;"></p>
						</div>

						<div class="c-form-field">
							<label class="c-form-field__label" for="email">이메일</label>
							<div class="pw-text">
								<input id="userEmail" type="text" class="c-input"
									name="userEmail" value="${userEmail}" placeholder="이메일 입력">
								<button type="button"
									class="c-button c-button--primary c-button--lg" id="checkEmail">인증전송</button>
							</div>
							<p class="c-form-field__error" id="emailError"
								style="display: none;"></p>
						</div>

						<div class="c-form-field">
							<label class="c-form-field__label" for="verify">인증번호</label>
							<div class="pw-text">
								<input id="authCode" type="text" class="c-input" name="authCode"
									placeholder="이메일 인증번호 입력">
									<div class="c-id-find-numbertime" id="find-id-timer">3:00</div>
								<button type="button"
									class="c-button c-button--primary c-button--lg"
									id="checkVerify">인증확인</button>
							</div>
							<p class="c-form-field__error" id="verifyError"
								style="display: none;"></p>
						</div>

						<div class="c-form-field">
							<label class="c-form-field__label">비밀번호 수정</label>
							<div class="pw-text is-password">
								<input type="password" class="c-input" id="newPassword"
									name="newPassword" placeholder="새 비밀번호 입력">
								<button type="button" class="c-password-toggle-btn"
									onclick="togglePassword('newPassword', 'toggleImg1')">
									<img
										src="${pageContext.request.contextPath}/asset/image/user/password-off.png"
										alt="eye" id="toggleImg1" />
								</button>
							</div>
							<p class="c-form-field__error" id="pwError"
								style="display: none;"></p>
						</div>

						<div class="c-form-field">
							<label class="c-form-field__label">비밀번호 재확인</label>
							<div class="pw-text is-password">
								<input type="password" class="c-input" id="confirmPassword"
									name="confirmPassword" placeholder="비밀번호 확인">
								<button type="button" class="c-password-toggle-btn"
									onclick="togglePassword('confirmPassword', 'toggleImg2')">
									<img
										src="${pageContext.request.contextPath}/asset/image/user/password-off.png"
										alt="eye" id="toggleImg2" />
								</button>
							</div>
							<p class="c-form-field__error" id="confirmPwError"
								style="display: none;"></p>
						</div>

						<div class="c-button-group">
							<button type="submit" id="accept"
								class="c-button c-button--primary c-button--md">수정</button>
							<button type="button" id="cancel"
								class="c-button c-button--secondary c-button--md"
								onclick="history.back();">취소</button>
						</div>
				</form>
			</div>
		</div>
	</main>
	<jsp:include page="/app/include/footer.jsp" />
</body>
<script>
  const errorMsg = "${sessionScope.editError}";
  if (errorMsg && errorMsg !== "null" && errorMsg !== "") {
    alert(errorMsg);
  }
</script>
<%
  session.removeAttribute("editError");
%>
</html>