<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>		
<!doctype html>
<html lang="ko">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>volunteer-manage-edit</title>

    <!-- base css 필수 삽입-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/typography.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/layout.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/volunteer-manage/volunteer-manage-edit.css" />
    <link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />

    <!-- 컨포넌트 css 선택-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/input.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/button.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/card.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/select.css" />

    <script defer src="${pageContext.request.contextPath}/asset/js/pages/main/include.js"></script>
    <script defer src="${pageContext.request.contextPath}/asset/js/pages/volunteer-manage/volunteer-manage-edit.js"></script>
</head>

<body>
	<jsp:include page="/app/include/header.jsp" />

	<main class="l-main">
		<div class="l-container">
			<form action="${pageContext.request.contextPath}/volunteer-manage/updateOk.vm" method="post">
				
				<input type="hidden" name="volunActNo" value="${volunActivity.volunActNo}" />
				<input type="hidden" name="volunActOrganNo" value="${volunActivity.volunActOrganNo}" />

				<div class="p-volunteer-manage-edit_header">
					<h1 class="p-volunteer-manage-edit_title">봉사수정</h1>
				</div>
			
				<div class="l-volunteer-manage-edit_form">
					<div class="l-volunteer-manage-edit_form-grid">

						<div class="l-volunteer-manage-edit_form-item">
							<label class="l-volunteer-manage-edit_form-label">봉사기간</label>
							<div class="l-volunteer-manage-edit_form-field l-volunteer-manage-edit_form-field--period">
								<input type="date" class="c-input" id="volunActProcBegin" name="volunActProcBegin"
									value="${volunActivity.volunActProcBegin}" />
								<span class="l-volunteer-manage-edit_form-tilde">~</span>
								<input type="date" class="c-input" id="volunActProcEnd" name="volunActProcEnd"
									value="${volunActivity.volunActProcEnd}" />
							</div>
						</div>

						<div class="l-volunteer-manage-edit_form-item">
							<label class="l-volunteer-manage-edit_form-label">봉사시간</label>
							<div class="l-volunteer-manage-edit_form-field l-volunteer-manage-edit_form-field--period">
								<input type="text" id="volunActBeginTime" name="volunActBeginTime" class="c-input"
									value="${volunActivity.volunActBeginTime}" placeholder="10">
								<span class="l-volunteer-manage-edit_form-tilde">~</span>
								<input type="text" id="volunActEndTime" name="volunActEndTime" class="c-input"
									value="${volunActivity.volunActEndTime}" placeholder="18">
							</div>
						</div>

						<div class="l-volunteer-manage-edit_form-item">
							<label class="l-volunteer-manage-edit_form-label">모집기간</label>
							<div class="l-volunteer-manage-edit_form-field l-volunteer-manage-edit_form-field--period">
								<input type="date" class="c-input" id="volunActRecruBegin" name="volunActRecruBegin"
									value="${volunActivity.volunActRecruBegin}" />
								<span class="l-volunteer-manage-edit_form-tilde">~</span>
								<input type="date" class="c-input" id="volunActRecruEnd" name="volunActRecruEnd"
									value="${volunActivity.volunActRecruEnd}" />
							</div>
						</div>

						<div class="l-volunteer-manage-edit_form-item">
							<label class="l-volunteer-manage-edit_form-label">봉사자연령</label>
							<div class="l-volunteer-manage-edit_form-field">
								<select id="volunActAgeGroup" name="volunActAgeGroup" class="c-select">
									<option value="0" <c:if test="${volunActivity.volunActAgeGroup == 0}">selected</c:if>>전체</option>
									<option value="1" <c:if test="${volunActivity.volunActAgeGroup == 1}">selected</c:if>>청소년</option>
									<option value="2" <c:if test="${volunActivity.volunActAgeGroup == 2}">selected</c:if>>청년</option>
									<option value="3" <c:if test="${volunActivity.volunActAgeGroup == 3}">selected</c:if>>직장인</option>
								</select>
							</div>
						</div>

						<div class="l-volunteer-manage-edit_form-item">
							<label class="l-volunteer-manage-edit_form-label">일자당 모집 인원</label>
							<div class="l-volunteer-manage-edit_form-field">
								<select id="volunActRecruMaxCount" name="volunActRecruMaxCount" class="c-select">
									<option value="30" <c:if test="${volunActivity.volunActRecruMaxCount == 30}">selected</c:if>>30명</option>
									<option value="25" <c:if test="${volunActivity.volunActRecruMaxCount == 25}">selected</c:if>>25명</option>
									<option value="20" <c:if test="${volunActivity.volunActRecruMaxCount == 20}">selected</c:if>>20명</option>
									<option value="15" <c:if test="${volunActivity.volunActRecruMaxCount == 15}">selected</c:if>>15명</option>
									<option value="10" <c:if test="${volunActivity.volunActRecruMaxCount == 10}">selected</c:if>>10명</option>
									<option value="5" <c:if test="${volunActivity.volunActRecruMaxCount == 5}">selected</c:if>>5명 내외</option>
								</select>
							</div>
						</div>

						<div class="l-volunteer-manage-edit_form-item">
							<label class="l-volunteer-manage-edit_form-label">활동분야</label>
							<div class="l-volunteer-manage-edit_form-field">
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

						<div class="l-volunteer-manage-edit_form-item">
							<label class="l-volunteer-manage-edit_form-label">모집기관</label>
							<div class="l-volunteer-manage-edit_form-field">
								<input type="text" id="OrganizationName" name="OrganizationName" class="c-input"
									value="${volunActivity.volunActNo}" placeholder="등록된 기관명 노출 예정" readonly />
							</div>
						</div>

						<div class="l-volunteer-manage-edit_form-item">
							<label class="l-volunteer-manage-edit_form-label">봉사장소</label>
							<div class="l-volunteer-manage-edit_form-field">
								<input type="text" id="volunActAddress" name="volunActAddress" class="c-input"
									value="${volunActivity.volunActAddress}" placeholder="장소를 입력해주세요." />
							</div>
						</div>

						<div class="l-volunteer-manage-edit_form-item">
							<label class="l-volunteer-manage-edit_form-label">상세주소</label>
							<div class="l-volunteer-manage-edit_form-field">
								<input type="text" id="volunActAddressDetail" name="volunActAddressDetail" class="c-input"
									value="${volunActivity.volunActAddressDetail}" placeholder="상세주소를 입력해주세요." />
							</div>
						</div>

						<div class="l-volunteer-manage-edit_form-item">
							<label class="l-volunteer-manage-edit_form-label">우편번호</label>
							<div class="l-volunteer-manage-edit_form-field">
								<input type="text" id="volunActPostnum" name="volunActPostnum" class="c-input"
									value="${volunActivity.volunActPostnum}" placeholder="우편번호를 입력해주세요." />
							</div>
						</div>

						<div class="l-volunteer-manage-edit_form-item">
							<label class="l-volunteer-manage-edit_form-label">포인트</label>
							<div class="l-volunteer-manage-edit_form-field">
								<input type="text" id="volunActPoint" name="volunActPoint" class="c-input"
									value="${volunActivity.volunActPoint}" placeholder="숫자만 입력 가능합니다." />
							</div>
						</div>
					</div>
				</div>

				<div class="l-volunteer-manage-edit_form">
					<div class="l-volunteer-manage-edit_form-item">
						<label class="l-volunteer-manage-edit_form-label">봉사 제목</label>
						<div class="l-volunteer-manage-edit_form-field">
							<input type="text" id="volunActTitle" name="volunActTitle" class="c-input"
								value="${volunActivity.volunActTitle}" placeholder="제목을 입력해주세요." />
						</div>
					</div>
				</div>

				<div class="l-volunteer-manage-edit_detail">
					<label class="l-volunteer-manage-edit_detail-label">봉사 상세 내용</label>
					<textarea id="volunActDetail" name="volunActDetail" class="c-input"
						placeholder="내용을 입력해주세요.">${volunActivity.volunActDetail}</textarea>
				</div>

				<div class="c-button--volunteer-manage-edit">
					<button type="submit" id="editButton" class="c-button c-button--primary c-button--md">
						수정
					</button>
					<button type="button" id="cancelButton" class="c-button c-button--secondary c-button--md">
					    취소
					</button>
				</div>
			</form>
		</div>
	</main>

	<jsp:include page="/app/include/footer.jsp" />
</body>

</html>