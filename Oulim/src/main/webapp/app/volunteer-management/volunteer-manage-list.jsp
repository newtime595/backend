<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!doctype html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>volunteer-manage-list</title>

<!-- base css 필수 삽입-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/typography.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/layout.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/volunteer-manage/volunteer-manage-list.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />
<!-- 컨포넌트 css 선택-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/pagination.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/button.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/list.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/input.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/badge.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/select.css" />


<script defer src="${pageContext.request.contextPath}/asset/js/pages/main/include.js"></script>
<script
	src="${pageContext.request.contextPath}/asset/js/pages/volunteer-manage/volunteer-manage-list.js"
	defer></script>
</head>

<body>
	<jsp:include page="/app/include/header.jsp" />

	<main class="l-main">
		<section class="p-volunteer-manage-list">
			<div class="l-container">
				<div class="p-volunteer-manage-list_header">
					<h1 class="p-volunteer-manage-list_title">봉사관리</h1>
					</div>
						<!-- 봉사활동 조회 옵션 선택 그룹 -->
				          <form action="${pageContext.request.contextPath}/volunteer-manage/list.vm" method="get">
							<div class="l-volunAct-list-search-option-group">
								<div class="l-volunAct-list-search-grid">
									<div class="l-volunAct-list-search-item">
										<label class="c-volunAct-list-search-label">활동분야</label>
										<select class="c-select" name="actType">
											<option value="">모두</option>
											<option value="1" ${actType == '1' ? 'selected' : ''}>환경</option>
											<option value="2" ${actType == '2' ? 'selected' : ''}>의료</option>
											<option value="3" ${actType == '3' ? 'selected' : ''}>교육</option>
											<option value="4" ${actType == '4' ? 'selected' : ''}>생활·편의</option>
											<option value="5" ${actType == '5' ? 'selected' : ''}>문화·체육·예술</option>
											<option value="6" ${actType == '6' ? 'selected' : ''}>기타</option>
										</select>
									</div>
						
									<div class="l-volunAct-list-search-item">
										<label class="c-volunAct-list-search-label">모집상태</label>
										<select class="c-select" name="recruitStatus">
											<option value="">선택</option>
											<option value="recruit" <c:if test="${recruitStatus == 'recruit'}">selected</c:if>>모집중</option>
											<option value="before-recruit" <c:if test="${recruitStatus == 'before-recruit'}">selected</c:if>>모집 예정</option>
											<option value="recruit-end" <c:if test="${recruitStatus == 'recruit-end'}">selected</c:if>>모집 마감</option>
										</select>
									</div>
								</div>
						
								<div class="l-volunAct-list-search-keyword">
								<label class="c-volunAct-list-search-label">제 목</label>
									<input class="c-input" type="text" name="keyword" value="${keyword}" placeholder="관련 제목 검색" />
								</div>
						
								<div class="l-volunAct-list-search-submit">
									<button type="submit" class="c-button c-button--primary c-button--lg">
										조회
									</button>
								</div>
							</div>
						</form>
					<div class="p-volunteer-manage-list_header">
						<button class="c-button c-button--primary c-button--md" type="button"
						onclick="location.href='${pageContext.request.contextPath}/volunteer-manage/register.vm'">봉사
							등록</button>
					</div>
				<div class="p-volunteer-manage-list_content">
					<div class="c-list c-list--4col">
						<!-- header -->
						<div class="c-list__header">
							<span class="c-list__col">제목</span> <span class="c-list__col">기간</span> <span class="c-list__col">활동 분야</span>
							<span class="c-list__col">상태</span> 
						</div>
						<!-- body -->
						<div class="c-list__body" id="volunteerListBody">
							<c:choose>
								<c:when test="${not empty volunteerList}">
									<c:forEach var="volunteer" items="${volunteerList}">
										<div class="c-list__row">
											<span class="c-list__col">
												<a href="${pageContext.request.contextPath}/volunteer-manage/detail.vm?volunActNo=${volunteer.volunActNo}">
													${volunteer.volunActTitle}
												</a>
											</span>																		
											<span class="c-list__col">
												${volunteer.volunActRecruBegin} ~ ${volunteer.volunActRecruEnd}
											</span>
											<span class="c-list__col">
											    <c:choose>
											        <c:when test="${volunteer.volunActActType == 1}">환경</c:when>
											        <c:when test="${volunteer.volunActActType == 2}">의료</c:when>
											        <c:when test="${volunteer.volunActActType == 3}">교육</c:when>
											        <c:when test="${volunteer.volunActActType == 4}">생활 편의</c:when>
											        <c:when test="${volunteer.volunActActType == 5}">문화체육예술</c:when>
											        <c:when test="${volunteer.volunActActType == 6}">기타</c:when>
											        <c:otherwise>-</c:otherwise>
											    </c:choose>
											</span>
											<span class="c-list__col">${volunteer.recruStatus}</span>
										</div>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<div class="c-list__row">
										<span class="c-list__col">조회된 봉사활동이 없습니다.</span>
										<span class="c-list__col"></span>
										<span class="c-list__col"></span>
									</div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>

				<!-- 페이지네이션  c-pagination-->
				<nav class="c-pagination">
					<c:if test="${lastPage > 1}">
						<c:if test="${page > 1}">
							<a class="c-pagination__link"
							   href="${pageContext.request.contextPath}/volunteer-manage/list.vm?page=${page - 1}&actType=${actType}&recruitStatus=${recruitStatus}&keyword=${keyword}">
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
									   href="${pageContext.request.contextPath}/volunteer-manage/list.vm?page=${i}&actType=${actType}&recruitStatus=${recruitStatus}&keyword=${keyword}">
										${i}
									</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
				
						<c:if test="${page < lastPage}">
							<a class="c-pagination__link"
							   href="${pageContext.request.contextPath}/volunteer-manage/list.vm?page=${page + 1}&actType=${actType}&recruitStatus=${recruitStatus}&keyword=${keyword}">
								›
							</a>
						</c:if>
					</c:if>
				</nav>
			</div>
		</section>
	</main>

<jsp:include page="/app/include/footer.jsp" />
</body>

</html>