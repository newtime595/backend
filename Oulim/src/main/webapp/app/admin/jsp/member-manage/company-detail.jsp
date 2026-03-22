<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- 페이지 제목 -->
<title>기업회원 승인요청 상세</title>

<!-- 공통 reset / 변수 / 타이포 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/layout.css" />

<!-- 공통 컴포넌트 css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/pagination.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/input.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/button.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/list.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/card.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/DetailCard.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/badge.css" />

<!-- 기업회원 상세 전용 css -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app/admin/css/member-manage/company-detail.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/app/admin/css/aside.css" />
</head>

<body>
	<main class="l-main">
		<jsp:include page="/app/admin/jsp/aside.jsp" />
		<div class="l-container">
			<!-- 우측 메인 컨텐츠 시작 -->
			<section class="l-content">
				<!-- 상단 페이지 제목 영역 -->
				<div class="header">
					<h1>기업회원 승인요청 상세</h1>
				</div>
				<!-- 상세 본문 전체 감싸는 영역 -->
				<div class="detail-wrap">
					<!-- 안내 문구 -->
					<p class="detail-guide">*회원의 정보를 확인하고 기업회원 가입 승인 / 반려 처리해 주세요.
					</p>
					<div class="detail-form">

						<!-- 기관명 -->
						<div class="detail-item">
							<label class="detail-label">기관명</label>
							<div class="detail-value">${userDetail.organName}</div>
						</div>

						<!-- 이름 -->
						<div class="detail-item">
							<label class="detail-label">이름</label>
							<div class="detail-value">
								${userDetail.userName}
								<!-- 나중에: ${companyDetail.userName} -->
							</div>
						</div>

						<!-- 생년월일 -->
						<div class="detail-item">
							<label class="detail-label">생년월일</label>
							<div class="detail-value">${userDetail.userBirth}</div>
						</div>

						<!-- 사업자 등록번호 -->
						<div class="detail-item">
							<label class="detail-label">사업자 등록번호</label>
							<div class="detail-value">${userDetail.organCertNum}</div>
						</div>

						<!-- 이메일 주소 -->
						<div class="detail-item">
							<label class="detail-label">이메일 주소</label>
							<div class="detail-value">
								${userDetail.userEmail}
								<!-- 나중에: ${companyDetail.userEmail} -->
							</div>
						</div>

						<!-- 재직증명서 파일 -->
						<div class="detail-item">
							<label class="detail-label">재직증명서 사본</label>

							<!-- 파일명 + 다운로드 버튼 한 줄 배치 -->
							<div class="file-row">
								<div class="detail-value file-name">${userDetail.organFileOriginalName}</div>

								<!-- 파일 다운로드 버튼 -->
								<a href="${pageContext.request.contextPath}/admin/viewCert.adm?userNo=${userDetail.userNo}"
									class="c-button c-button--secondary c-button--md file-button">
									파일 확인하기</a>
							</div>
						</div>
					</div>


					<!-- 나중에 form submit JS 연결 가능 -->

					<div class="detail-button-wrap">
					<form action="${pageContext.request.contextPath}/admin/compCertOk.adm" method="post">
					<input type="hidden" name="userNo" value="${userDetail.userNo}">
					<input type="hidden" name="organNo" value="${userDetail.organNo}">
					<input type="hidden" name="isApprove" value="true">
						<button type="submit"
							class="c-button c-button--primary c-button--lg">승인</button>
					</form>
					<form action="${pageContext.request.contextPath}/admin/compCertOk.adm" method="post">
					<input type="hidden" name="userNo" value="${userDetail.userNo}">
					<input type="hidden" name="isApprove" value="false">
						<button type="submit"
							class="c-button c-button--secondary c-button--lg">반려</button>
					</form>
					</div>
				</div>
			</section>

		</div>
	</main>
</body>
</html>