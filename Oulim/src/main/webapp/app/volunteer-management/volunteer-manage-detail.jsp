<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>		
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>volunteer-manage-detail</title>

<!-- base css 필수 삽입-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/layout.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/volunteer-manage/volunteer-manage-detail.css">
<!-- 컨포넌트 css 선택-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/pagination.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/button.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/list.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/card.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/DetailCard.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/badge.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />
<script src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=d090ba1051e43d12c75b06b4254865bf&autoload=false&libraries=services"></script>
<script defer src="${pageContext.request.contextPath}/asset/js/pages/volunteer-manage/volunteer-manage-detail.js"></script>
</head>

<body>
	<jsp:include page="/app/include/header.jsp" />
	<input type="hidden" name="volunActNo" value="${volunDetail.volunActNo}"> 
	<input type="hidden" name="volunActAgeGroup" value="${volunDetail.volunActAgeGroup}"> 
	<main class="l-main">
		<div class="l-container">
			<div class="p-volunteer-manage-detail_header">
				<h1 class="p-volunteer-manage-detail_title">봉사 상세</h1>
				<div class="c-button-add">
            		<button type="button" id="attendanceToggleBtn" class="edit-btn c-button c-button--primary c-button--md">
						출석 처리
					</button>
          		</div>
				<div class="c-button-group">
					<button class="edit-btn c-button c-button--primary c-button--md" type="button"
					onclick="location.href='${pageContext.request.contextPath}/volunteer-manage/update.vm?volunActNo=${volunDetail.volunActNo}'"
					>수정</button>
					<form action="${pageContext.request.contextPath}/volunteer-manage/delete.vm" method="post">
						<input type="hidden" name="volunActNo" value="${volunDetail.volunActNo}">
						<button type="submit" class="delete-btn c-button c-button--secondary c-button--md"
							onclick="return confirm('정말 삭제하시겠습니까?')">
							삭제
						</button>
					</form>
				</div>
			</div>
			<div class="c-detail-card" id="volunteerDetailCard">
				<div class="c-detail-card__header">
					<span class="c-badge c-badge--primary" id="volunteerStatus">
						${volunDetail.recruStatus}
					</span>
					<span class="c-badge c-badge--orange" id="volunteerTarget">
						<c:choose>
							<c:when test="${volunDetail.volunActAgeGroup == 0}">전체</c:when>
							<c:when test="${volunDetail.volunActAgeGroup == 1}">청소년</c:when>
							<c:when test="${volunDetail.volunActAgeGroup == 2}">청년</c:when>
							<c:when test="${volunDetail.volunActAgeGroup == 3}">직장인</c:when>
							<c:otherwise>${volunDetail.volunActAgeGroup}</c:otherwise>
						</c:choose>
					</span>
				</div>

				<h2 class="c-detail-card__title" id="volunteerTitle">
					${volunDetail.volunActTitle}
				</h2>

				<div class="c-detail-card__info">
					<div class="c-detail-card__row">
						<span class="c-detail-card__label">봉사장소</span>
						<span class="c-detail-card__value" id="volunteerLocation">
							${volunDetail.volunActAddress}
						</span>
					</div>
					<div class="c-detail-card__row">
						<span class="c-detail-card__label">봉사기간</span>
						<span class="c-detail-card__value" id="volunteerPeriod">
							${volunDetail.volunActProcBegin} ~ ${volunDetail.volunActProcEnd}
						</span>
					</div>
					<div class="c-detail-card__row">
						<span class="c-detail-card__label">모집기간</span>
						<span class="c-detail-card__value" id="recruitPeriod">
							${volunDetail.volunActRecruBegin} ~ ${volunDetail.volunActRecruEnd}
						</span>
					</div>
					<div class="c-detail-card__row">
						<span class="c-detail-card__label">봉사시간</span>
						<span class="c-detail-card__value" id="volunteerTime">
							${volunDetail.volunActEndTime - volunDetail.volunActBeginTime}시간
						</span>
					</div>
					<div class="c-detail-card__row">
						<span class="c-detail-card__label">날짜별 모집현황</span>
						<div class="c-detail-card__value">
							<c:choose>
								<c:when test="${not empty applyCountList}">
									<c:forEach var="count" items="${applyCountList}">
										<div>
											${count.volunActApplyDate} : ${count.currentCount} / ${volunDetail.volunActRecruMaxCount}명
										</div>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<div>아직 신청자가 없습니다.</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="c-detail-card__row">
						<span class="c-detail-card__label">포인트</span>
						<span class="c-detail-card__value" id="volunteerPoint">
							${volunDetail.volunActPoint}p
						</span>
					</div>
					<div class="c-detail-card__row">
						<span class="c-detail-card__label">봉사자연령</span>
						<span class="c-detail-card__value" id="volunteerAge">
							<c:choose>
								<c:when test="${volunDetail.volunActAgeGroup == 0}">전체</c:when>
								<c:when test="${volunDetail.volunActAgeGroup == 1}">청소년</c:when>
								<c:when test="${volunDetail.volunActAgeGroup == 2}">청년</c:when>
								<c:when test="${volunDetail.volunActAgeGroup == 3}">직장인</c:when>
								<c:otherwise>${volunDetail.volunActAgeGroup}</c:otherwise>
							</c:choose>
						</span>
					</div>
				</div>
			</div>
			<div id="detailSection">
			<!-- 글내용 영역 추가 -->
			<div class="c-detail-card">
				<div class="c-detail-card__info">
					<div class="c-detail-card__row">
						<span class="c-detail-card__label">추가내용 작성</span>
					</div>
					<div class="c-detail-card__row">
						<div class="volunActDetailPlus">
							${volunDetail.volunActDetail}
						</div>
					</div>
				</div>
			</div>
			<!--지도  -->
				<div class="c-detail-card">
					<div class="c-detail-card__info">
						<div class="c-detail-card__row">
							<div id="map"></div>
						</div>
					</div>
				</div>
			</div>
			<!-- 봉사자 리스트 출력  -->
		<div id="attendanceSection" style="display: none;">
		<form action="${pageContext.request.contextPath}/volunteer-manage/attendance.vm" method="post">
			<input type="hidden" name="volunActNo" value="${volunDetail.volunActNo}">
			<input type="hidden" name="changeAmount" value="${volunDetail.volunActPoint}">
			<input type="hidden" name="page" value="${page}">
			<input type="hidden" name="view" value="${empty param.view ? 'detail' : param.view}">
	
		<div class="c-list c-list--5col">
			<div class="c-list__header">
				<span class="c-list__col"><input type="checkbox" id="checkAllAttendance">　전체 선택</span>
				<span class="c-list__col">봉사자</span>
				<span class="c-list__col">나이</span>
				<span class="c-list__col">봉사날짜</span>
				<span class="c-list__col">상태</span>
			</div>
		
			<div class="c-list__body" id="participantListBody">
				<c:choose>
					<c:when test="${not empty applyList}">
						<c:forEach var="apply" items="${applyList}">
							<div class="c-list__row">
								<span class="c-list__col">
									<input type="checkbox" name="attendanceUser"
										value="${apply.userNo}"
										data-user-no="${apply.userNo}"
										data-volun-act-no="${apply.volunActNo}"
										data-attendance-status="${apply.volunActAttendance}">
								</span>
								<span class="c-list__col">${apply.userName}</span>
								<span class="c-list__col">${apply.userAge}</span>
								<span class="c-list__col">${apply.volunActApplyDate}</span>
								<span class="c-list__col
									<c:if test='${apply.volunActAttendance == 1}'> attendance-text attendance-text--present</c:if>
									<c:if test='${apply.volunActAttendance == 2}'> attendance-text attendance-text--absent</c:if>
									<c:if test='${apply.volunActAttendance != 1 && apply.volunActAttendance != 2}'> attendance-text attendance-text--pending</c:if>
								">
									<c:choose>
										<c:when test="${apply.volunActAttendance == 1}">출석</c:when>
										<c:when test="${apply.volunActAttendance == 2}">결석</c:when>
										<c:otherwise>미처리</c:otherwise>
									</c:choose>
								</span>
							</div>
						</c:forEach>
					</c:when>
		
					<c:otherwise>
						<div class="c-list__row">
							<span class="c-list__col">-</span>
							<span class="c-list__col">지원자가 없습니다.</span>
							<span class="c-list__col">-</span>
							<span class="c-list__col">-</span>
							<span class="c-list__col">-</span>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
					<div class="b-btn-layout attendance-submit-area">
						<button type="submit"
							id="attendBtn"
							name="attendanceStatus"
							value="1"
							class="c-button c-button--primary c-button--md attendance-submit-area__button ${!canAttendance ? 'is-disabled' : ''}"
							${!canAttendance ? 'disabled="disabled"' : ''}>
							출석
						</button>
					
						<button type="submit"
							id="absentBtn"
							name="attendanceStatus"
							value="2"
							class="c-button c-button--secondary c-button--md attendance-submit-area__button ${!canAttendance ? 'is-disabled' : ''}"
							${!canAttendance ? 'disabled="disabled"' : ''}>
							결석
						</button>
					</div>
					
					<c:if test="${!canAttendance}">
						<p class="attendance-submit-area__message">
							출석 · 결석 처리는 봉사 종료일 1일 이후부터 가능합니다.
						</p>
					</c:if>
			</form>
			
			<!-- 페이지네이션 -->
			<nav class="c-pagination" id="attendancePagination">
				<c:if test="${lastPage > 1}">
					<c:if test="${page > 1}">
						<a class="c-pagination__link"
						   href="${pageContext.request.contextPath}/volunteer-manage/detail.vm?volunActNo=${volunDetail.volunActNo}&page=${page - 1}&view=${empty param.view ? 'detail' : param.view}">
							‹
						</a>
					</c:if>
			
					<c:forEach var="i" begin="1" end="${lastPage}">
						<c:choose>
							<c:when test="${i == page}">
								<a class="c-pagination__link is-active">${i}</a>
							</c:when>
							<c:otherwise>
								<a class="c-pagination__link"
								   href="${pageContext.request.contextPath}/volunteer-manage/detail.vm?volunActNo=${volunDetail.volunActNo}&page=${i}&view=${empty param.view ? 'detail' : param.view}">
									${i}
								</a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
			
					<c:if test="${page < lastPage}">
						<a class="c-pagination__link"
						   href="${pageContext.request.contextPath}/volunteer-manage/detail.vm?volunActNo=${volunDetail.volunActNo}&page=${page + 1}&view=${empty param.view ? 'detail' : param.view}">
							›
						</a>
					</c:if>
				</c:if>
			</nav>
			</div>

			<div class="c-button--volunteer-manage-detail">
					<button class="c-button c-button--primary c-button--md"
					onclick="location.href='${pageContext.request.contextPath}/volunteer-manage/list.vm'">
						봉사 리스트로 돌아가기</button>
			</div>
		</div>
	</main>

<jsp:include page="/app/include/footer.jsp" />
</body>

</html>