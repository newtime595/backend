<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>봉사 활동</title>

    <!-- base css 필수 삽입-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/layout.css" />
    <!-- 컨포넌트 css 선택-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/pagination.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/input.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/button.css" /><%-- 
    <link rel="stylesheet" href="${pageContext.request.contextPath}m/asset/css/component/DetailCard.css" /> --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/badge.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/select.css" />

    <!-- css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/volunteer-activity/volunAct-list.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />

  </head>
  <body>
  
  	<jsp:include page="/app/include/header.jsp" />
    <div class="l-main">
      <div class="l-container">
        <div class="p-volunAct-list-main">
			<form method="get" action="${pageContext.request.contextPath}/volunteer-activity/list.va">
			
			  <div class="l-volunAct-list-search-option-group">
			
			    <div class="l-volunAct-list-search-grid">
			
			      <!-- 활동분야 -->
			      <div class="l-volunAct-list-search-item">
			        <label class="c-volunAct-list-search-label">활동분야</label>
			        <select name="actType" class="c-select">
			          <option value="">전체</option>
			          <option value="1" ${search.volunActActType == 1 ? 'selected' : ''}>환경</option>
			          <option value="2" ${search.volunActActType == 2 ? 'selected' : ''}>의료</option>
			          <option value="3" ${search.volunActActType == 3 ? 'selected' : ''}>교육</option>
			          <option value="4" ${search.volunActActType == 4 ? 'selected' : ''}>생활·편의</option>
			          <option value="5" ${search.volunActActType == 5 ? 'selected' : ''}>문화·체육·예술</option>
			          <option value="6" ${search.volunActActType == 6 ? 'selected' : ''}>기타</option>
			        </select>
			      </div>
			
			      <!-- 모집상태 -->
			      <div class="l-volunAct-list-search-item">
			        <label class="c-volunAct-list-search-label">모집상태</label>
			        <select name="recruitStatus" class="c-select">
			          <option value="">전체</option>
			          <option value="1" ${search.recruitStatus == '1' ? 'selected' : ''}>모집중</option>
			          <option value="2" ${search.recruitStatus == '2' ? 'selected' : ''}>모집 예정</option>
			          <option value="3" ${search.recruitStatus == '3' ? 'selected' : ''}>모집 마감</option>
			        </select>
			      </div>
			
			      <!-- 주체 단체 -->
			      <div class="l-volunAct-list-search-item">
			        <label class="c-volunAct-list-search-label">주체 단체</label>
			        <input class="c-input"
			               type="text"
			               name="organization"
			               value="${search.organization}"
			               placeholder="주체 기업명" />
			      </div>
			
			      <!-- 참여 연령 -->
			      <div class="l-volunAct-list-search-item">
			        <label class="c-volunAct-list-search-label">참여 가능 연령</label>
			        <select name="ageGroup" class="c-select">
			          <option value="">전체</option>
			          <option value="1" ${search.volunActAgeGroup == 1 ? 'selected' : ''}>청소년 (14~19)</option>
			          <option value="2" ${search.volunActAgeGroup == 2 ? 'selected' : ''}>청년 (20~30)</option>
			          <option value="3" ${search.volunActAgeGroup == 3 ? 'selected' : ''}>직장인 (30+)</option>
			        </select>
			      </div>
			
			    </div>
			
			    <!-- 키워드 영역 -->
			    <div class="l-volunAct-list-search-keyword">
			
			      <select class="c-select" name="searchType">
			        <option value="title" ${search.searchType == 'title' ? 'selected' : ''}>제목</option>
			        <option value="author" ${search.searchType == 'author' ? 'selected' : ''}>작성자</option>
			      </select>
			
			      <!-- name -->
			      <input class="c-input"
			             type="text"
			             name="keyword"
			             value="${search.keyword}"
			             placeholder="관련 제목 검색" />
			    </div>
			
			    <!-- 버튼 -->
			    <div class="l-volunAct-list-search-submit">
			      <button type="submit" class="c-button c-button--primary c-button--lg">
			        조회
			      </button>
			    </div>
			
			  </div>
			</form>
          <div class="l-volunAct-list-card-list">
            <!-- 봉사목록 카드 리스트 영역 -->
		<ul class="l-volunAct-card-list">
		
		    <c:if test="${empty volunteerList}">
		        <li>등록된 봉사활동이 없습니다.</li>
		    </c:if>
		
		    <c:forEach var="item" items="${volunteerList}">
		        <li class="l-volunAct-card-element">
		
		            <a href="${pageContext.request.contextPath}/volunteer-activity/detail.va?volunActNo=${item.volunActNo}">
		
		                <div class="c-detail-card">
		
		                    <!-- 상단 뱃지 -->
		                    <div class="card-badge">
		
		                        <!-- 모집상태 -->
		                        <span class="badge badge-status">
		                            ${item.recruStatus}
		                        </span>
		
		                        <!-- 활동분야 -->
		                        <span class="badge badge-type">
		                            ${item.volunActActType}
		                        </span>
		
		                        <!-- 연령 -->
		                        <span class="badge badge-age">
		                            ${item.volunActAgeGroup}
		                        </span>
		
		                    </div>
		
		                    <!-- 제목 -->
		                    <div class="card-title">
		                        ${item.volunActTitle}
		                    </div>
		
		                    <!-- 하단 정보 -->
		                    <div class="card-content">
		
		                        <!-- 왼쪽 -->
		                        <div class="card-left">
		                            <div>봉사위치</div>
		                            <div>봉사기간</div>
		                            <div>포인트</div>
		                        </div>
		
		                        <!-- 오른쪽 -->
		                        <div class="card-right">
		                            <div>${item.volunActAddress}</div>
		                            <div>
		                                ${item.volunActProcBegin} ~ ${item.volunActProcEnd}
		                            </div>
		                            <div>${item.volunActPoint}p</div>
		                        </div>
		
		                    </div>
		
		                </div>
		
		            </a>
		
		        </li>
		    </c:forEach>
		
		</ul>
            <!-- 봉사목록 카드 리스트 영역 종료-->
          </div>
          
		<div class="l-volunAct-list-pagination">
		
		    <!-- 이전 -->
		    <c:if test="${page > 1}">
		        <a href="?page=${page-1}
		        &actType=${search.volunActActType}
		        &ageGroup=${search.volunActAgeGroup}
		        &recruitStatus=${search.recruitStatus}
		        &keyword=${search.keyword}
		        &searchType=${search.searchType}
		        &organization=${search.organization}">
		        이전
		        </a>
		    </c:if>
		
		    <!-- 페이지 번호 -->
		    <c:forEach begin="1" end="${totalPage}" var="i">
		        <a href="?page=${i}
		        &actType=${search.volunActActType}
		        &ageGroup=${search.volunActAgeGroup}
		        &recruitStatus=${search.recruitStatus}
		        &keyword=${search.keyword}
		        &searchType=${search.searchType}
		        &organization=${search.organization}">
		            ${i}
		        </a>
		    </c:forEach>
		
		    <!-- 다음 -->
		    <c:if test="${page < totalPage}">
		        <a href="?page=${page+1}
		        &actType=${search.volunActActType}
		        &ageGroup=${search.volunActAgeGroup}
		        &recruitStatus=${search.recruitStatus}
		        &keyword=${search.keyword}
		        &searchType=${search.searchType}
		        &organization=${search.organization}">
		        다음
		        </a>
		    </c:if>
		
		</div>
    <jsp:include page="/app/include/footer.jsp" />
  </body>
</html>
