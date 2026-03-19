<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!doctype html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>volunteer-manage-register</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/layout.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/volunteer-manage/volunteer-manage-register.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/input.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/button.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/card.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/select.css" />
<script defer src="${pageContext.request.contextPath}/asset/js/pages/main/include.js"></script>
<script defer src="${pageContext.request.contextPath}/asset/js/pages/volunteer-manage/volunteer-manage-register.js"></script>
</head>

<body>
<jsp:include page="/app/include/header.jsp" />

<main class="l-main">
	<div class="l-container">
		<form id="registerForm" action="${pageContext.request.contextPath}/volunteer-manage/registerOk.vm" method="post">
			
			<%-- <input type="hidden" name="volunActOrganNo" value="${sessionScope.organNo}"> --%>
			<input type="hidden" name="volunActOrganNo" value="1">

			<div class="p-volunteer-manage-register_header">
				<h1 class="p-volunteer-manage-register_title">봉사등록</h1>
			</div>

			<c:if test="${not empty errorMessage}">
				<script>
					alert("${errorMessage}");
				</script>
			</c:if>

			<div class="l-volunteer-manage-register_form">
				<div class="l-volunteer-manage-register_form-grid">
				
					<div class="l-volunteer-manage-register_form-item">
						<label class="l-volunteer-manage-register_form-label">모집기간</label>
						<div class="l-volunteer-manage-register_form-field l-volunteer-manage-register_form-field--period">
							<input type="date" class="c-input" id="volunActRecruBegin" name="volunActRecruBegin"
								value="${volunteer.volunActRecruBegin}" />
							<span class="l-volunteer-manage-register_form-tilde">~</span>
							<input type="date" class="c-input" id="volunActRecruEnd" name="volunActRecruEnd"
								value="${volunteer.volunActRecruEnd}" />
						</div>
					</div>
					
					<div class="l-volunteer-manage-register_form-item">
						<label class="l-volunteer-manage-register_form-label">봉사기간</label>
						<div class="l-volunteer-manage-register_form-field l-volunteer-manage-register_form-field--period">
							<input type="date" class="c-input" id="volunActProcBegin" name="volunActProcBegin"
								value="${volunteer.volunActProcBegin}" />
							<span class="l-volunteer-manage-register_form-tilde">~</span>
							<input type="date" class="c-input" id="volunActProcEnd" name="volunActProcEnd"
								value="${volunteer.volunActProcEnd}" />
						</div>
					</div>

					<div class="l-volunteer-manage-register_form-item">
						<label class="l-volunteer-manage-register_form-label">봉사시간</label>
						<div class="l-volunteer-manage-register_form-field l-volunteer-manage-register_form-field--period">
							<input type="text" id="volunActBeginTime" name="volunActBeginTime" class="c-input" placeholder="10"
								value="${volunteer.volunActBeginTime}">
							<span class="l-volunteer-manage-register_form-tilde">~</span>
							<input type="text" id="volunActEndTime" name="volunActEndTime" class="c-input" placeholder="18"
								value="${volunteer.volunActEndTime}">
						</div>
					</div>

					
					<div class="l-volunteer-manage-register_form-item">
						<label class="l-volunteer-manage-register_form-label">봉사자연령</label>
						<div class="l-volunteer-manage-register_form-field">
							<select id="volunActAgeGroup" name="volunActAgeGroup" class="c-select">
								<option value="0" <c:if test="${volunteer.volunActAgeGroup == 0}">selected</c:if>>전체</option>
								<option value="1" <c:if test="${volunteer.volunActAgeGroup == 1}">selected</c:if>>청소년 (14~19세)</option>
								<option value="2" <c:if test="${volunteer.volunActAgeGroup == 2}">selected</c:if>>청년 (20~29세)</option>
								<option value="3" <c:if test="${volunteer.volunActAgeGroup == 3}">selected</c:if>>직장인 (30세 이상)</option>
							</select>
						</div>
					</div>

					<div class="l-volunteer-manage-register_form-item">
						<label class="l-volunteer-manage-register_form-label">일자당 모집 인원</label>
						<div class="l-volunteer-manage-register_form-field">
							<select id="volunActRecruMaxCount" name="volunActRecruMaxCount" class="c-select">
								<option value="30" <c:if test="${volunteer.volunActRecruMaxCount == 30}">selected</c:if>>30명</option>
								<option value="25" <c:if test="${volunteer.volunActRecruMaxCount == 25}">selected</c:if>>25명</option>
								<option value="20" <c:if test="${volunteer.volunActRecruMaxCount == 20}">selected</c:if>>20명</option>
								<option value="15" <c:if test="${volunteer.volunActRecruMaxCount == 15}">selected</c:if>>15명</option>
								<option value="10" <c:if test="${volunteer.volunActRecruMaxCount == 10}">selected</c:if>>10명</option>
								<option value="5" <c:if test="${volunteer.volunActRecruMaxCount == 5}">selected</c:if>>5명 내외</option>
							</select>
						</div>
					</div>

					<div class="l-volunteer-manage-register_form-item">
						<label class="l-volunteer-manage-register_form-label">활동분야</label>
						<div class="l-volunteer-manage-register_form-field">
							<select id="volunActActType" name="volunActActType" class="c-select">
								<option value="">선택</option>
								<option value="1" <c:if test="${volunteer.volunActActType == 1}">selected</c:if>>환경</option>
								<option value="2" <c:if test="${volunteer.volunActActType == 2}">selected</c:if>>의료</option>
								<option value="3" <c:if test="${volunteer.volunActActType == 3}">selected</c:if>>교육</option>
								<option value="4" <c:if test="${volunteer.volunActActType == 4}">selected</c:if>>생활 편의</option>
								<option value="5" <c:if test="${volunteer.volunActActType == 5}">selected</c:if>>문화·체육·예술</option>
								<option value="6" <c:if test="${volunteer.volunActActType == 6}">selected</c:if>>기타</option>
							</select>
						</div>
					</div>

					<div class="l-volunteer-manage-register_form-item">
						<label class="l-volunteer-manage-register_form-label">모집기관</label>
						<div class="l-volunteer-manage-register_form-field">
							<input type="text" id="organizationName" class="c-input"
								placeholder="등록된 기관명 노출 예정" readonly />
						</div>
					</div>

					<div class="l-volunteer-manage-register_form-item">
						<label class="l-volunteer-manage-register_form-label">봉사장소</label>
						<div class="l-volunteer-manage-register_form-field">
							<input type="text" id="volunActAddress" name="volunActAddress" class="c-input"
								placeholder="장소를 입력해주세요." value="${volunteer.volunActAddress}" />
						</div>
					</div>

					<div class="l-volunteer-manage-register_form-item">
						<label class="l-volunteer-manage-register_form-label">포인트</label>
						<div class="l-volunteer-manage-register_form-field">
							<input type="text" id="volunActPoint" name="volunActPoint" class="c-input"
								placeholder="숫자만 입력 가능합니다." value="${volunteer.volunActPoint}" />
						</div>
					</div>
				</div>
			</div>

			<div class="l-volunteer-manage-register_form">
				<div class="l-volunteer-manage-register_form-item">
					<label class="l-volunteer-manage-register_form-label">봉사 제목</label>
					<div class="l-volunteer-manage-register_form-field">
						<input type="text" id="volunActTitle" name="volunActTitle" class="c-input"
							placeholder="제목을 입력해주세요." value="${volunteer.volunActTitle}" />
					</div>
				</div>
			</div>

			<div class="l-volunteer-manage-register_detail">
				<label class="l-volunteer-manage-register_detail-label">봉사 상세 내용</label>
				<textarea id="volunActDetail" name="volunActDetail" class="c-input" placeholder="내용을 입력해주세요.">${volunteer.volunActDetail}</textarea>
			</div>

			<div class="c-button--volunteer-manage-register">
				<button type="submit" id="registerButton" class="c-button c-button--primary c-button--md">
					등록
				</button>
				<button type="button" id="cancelButton" class="c-button c-button--secondary c-button--md"
					onclick="location.href='${pageContext.request.contextPath}/volunteer-manage/list.vm'">
					취소
				</button>
			</div>
		</form>
	</div>
</main>

<jsp:include page="/app/include/footer.jsp" />
</body>
</html>