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
  
  <link rel="stylesheet" href="${pageContext.request.contextPath}/app/admin/css/volunteer-manage/volun-list.css" />
  <script defer src="${pageContext.request.contextPath}/app/admin/js/volunteer-manage/volun-list.js"></script>
</head>

<body>
	<main class="l-main">
	  <aside class="l-sidebar">
	    <div class="adminnow">
	      <div class="admin-profile">
	        <div class="profile-circle"></div>
	      </div>
	      <button class="c-button c-button--logout">로그아웃</button>
	    </div>
	
	   <nav class="sidebar-menu">
	      <ul>
	        <li class="menu-item"><a href="#">통계</a></li>
	        <li class="menu-item"><a href="#">회원관리</a></li>
	        <li class="menu-item active"><a href="#">봉사 활동 관리</a></li>
	        <li class="menu-item"><a href="#">게시판관리</a></li>
	      </ul>
	    </nav>
	  </aside>
	
	  <section class="l-content">
	    <div class="header">
	      <h1>봉사 활동 관리</h1>
	    </div>
	
	    <div class="search-section">
	      <div class="search-container">
	        <select class="c-select">
	          <option>봉사번호</option>
	          <option>아이디</option>
	          <option>단체명</option>
	          <option>시작일</option>
	          <option>종료일</option>
	          <option>지급포인트</option>
	          <option>진행상태</option>
	        </select>
	        <input type="text" class="c-input" placeholder="검색 조건">
	        <button class="c-button c-button--search">조회</button>
	      </div>
	    </div>
		
		<div class="c-list-container">
		  <div class="c-list">
		  
		    <!-- 헤더 -->
		    <div class="c-list__header">
		      <div class="c-list__col">봉사번호</div>
		      <div class="c-list__col">단체명</div>
		      <div class="c-list__col">시작일</div>
		      <div class="c-list__col">종료일</div>
		      <div class="c-list__col">지급 포인트</div>
		      <div class="c-list__col">진행상태</div>
		    </div>
		
		    <!-- 바디 -->
		    <div class="c-list__body">
		      <c:choose>
		        <c:when test="${not empty volunList}">
			      <c:forEach var="v" items="${volunList}">
			        <div class="c-list__row">
						<div class="c-list__col">${v.volunActNo}</div>
						<div class="c-list__col">${v.orgName}</div>
						<div class="c-list__col">${v.volunActProcBegin}</div>
						<div class="c-list__col">${v.volunActProcEnd}</div>
						<div class="c-list__col">${v.volunActPoint}</div>
						<div class="c-list__col">${v.recruStatus}</div>
			        </div>
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