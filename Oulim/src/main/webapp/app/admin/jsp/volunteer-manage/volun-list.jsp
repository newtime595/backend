<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>volun-list</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />
    <!-- 컨포넌트 css 선택-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/pagination.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/input.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/button.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/select.css" />
  
  <link rel="stylesheet" href="${pageContext.request.contextPath}/app/admin/css/volunteer-manage/volun-list.css" />
  <script src="${pageContext.request.contextPath}/app/admin/js/volunteer-manage/volun-list.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/app/admin/css/aside.css" />
</head>

<body>
	<main class="l-main">
	<jsp:include page="/app/admin/jsp/aside.jsp"/>
	
	  <section class="l-content">
	    <div class="header">
	      <h2>봉사 활동 관리</h2>
	    </div>
	
		<div class="search-section">
		  <form action="/admin/volunlist.adm"  method="get" class="search-form" onsubmit="return validateSearchForm()">
		    <div class="search-container">
		      
		      <div class="search-row">
		        <div class="search-group">
		          <label class="search-label">진행상태</label>
					<select name="recruitStatus"class = "c-select">
					  <option value="all" ${empty param.recruitStatus or param.recruitStatus == 'all' ? 'selected' : ''}>
					  	전체
					  </option>
					  <option value="before" ${param.recruitStatus == 'before' ? 'selected' : ''}>
					  	모집예정
					  </option>
					  <option value="recruiting" ${param.recruitStatus == 'recruiting' ? 'selected' : ''}>
					  	모집중
					  </option>
					  <option value="closedRecruit" ${param.recruitStatus == 'closedRecruit' ? 'selected' : ''}>
					  	모집마감
					  </option>
					  <option value="ongoing" ${param.recruitStatus == 'ongoing' ? 'selected' : ''}>
					  	진행중
					  </option>
					  <option value="done" ${param.recruitStatus == 'done' ? 'selected' : ''}>
					 	 종료
					  </option>
					</select>
		        </div>
		
		        <div class="search-group">
		          <label class="search-label">봉사기간</label>
		          <div class="search-date-range">
				    <input 
				      type="date"
				      id="startDate"
				      name="volunActProcBegin"
				      value="${param.volunActProcBegin}"
				      class="c-input"
				      min="1900-01-01"
				      max="2199-12-31">
				
				    <span class="search-separator">~</span>
				
				    <input 
				      type="date"
				      id="endDate"
				      name="volunActProcEnd"
				      value="${param.volunActProcEnd}"
				      class="c-input"
				      min="1900-01-01"
				      max="2199-12-31">
		          </div>
		        </div>
		      </div>
		
		      <div class="search-row">
		        <div class="search-group search-group--full">
		          <label class="search-label">검색어</label>
		          <div class="search-input-wrapper">
			          <select class="c-select" name="searchType">
						<option value="no" ${param.searchType == 'no' ? 'selected' : ''}>
						  봉사번호
						</option>
						<option value="title" ${param.searchType == 'title' ? 'selected' : ''}>
						  봉사제목
						</option>
						<option value="org" ${param.searchType == 'org' ? 'selected' : ''}>
						  단체명
						</option>
				       </select>
				       <input class="c-input" type="text" name="keyword" value="${keyword}" placeholder="검색어 입력" />		          
		          </div>
		        </div>
		      </div>
		
		      <div class="search-actions">
		        <button type="submit" class="c-button c-button--primary c-button--md">조회</button>
			      <a href="/admin/volunlist.adm" class="c-button c-button--Tertiary c-button--md">
			        초기화
			      </a>
		      </div>
		
		    </div>
		  </form>
		</div>
		
		<div class="c-list-container">
		  <div class="c-list">
		  
		    <!-- 헤더 -->
		    <div class="c-list__header">
		      <div class="c-list__col">봉사번호</div>
		      <div class="c-list__col">봉사명</div>
		      <div class="c-list__col">단체명</div>
		      <div class="c-list__col">시작일</div>
		      <div class="c-list__col">종료일</div>
		      <div class="c-list__col">진행상태</div>
		    </div>
		
		    <!-- 바디 -->
		    <div class="c-list__body">
		      <c:choose>
		        <c:when test="${not empty volunList}">
			      <c:forEach var="v" items="${volunList}">
			      <a>
			        <div class="c-list__row">
						<div class="c-list__col">${v.volunActNo}</div>
						<div class="c-list__col">${v.volunActTitle}</div>
						<div class="c-list__col">${v.orgName}</div>
						<div class="c-list__col">${v.volunActProcBegin}</div>
						<div class="c-list__col">${v.volunActProcEnd}</div>
						<div class="c-list__col">${v.recruStatus}</div>
			        </div>
			      </a>
			      </c:forEach>
		        </c:when>
		        <c:otherwise>
		          <div class="c-list__row">
		            <div class="c-list__col" style="width:100%; text-align:center;">
		              데이터가 없습니다.
		            </div>
		          </div>
		        </c:otherwise>
		      </c:choose>
		    </div>
		  </div>
		</div>
	
	    <div class="pagination-area">
	       </div>
	  </section>
	</main>
</body>

</html>