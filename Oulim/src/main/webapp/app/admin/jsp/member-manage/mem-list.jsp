<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>mem-list</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />
    <!-- 컨포넌트 css 선택-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/pagination.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/input.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/button.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/list.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/card.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/DetailCard.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/badge.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/app/admin/css/member-manage/mem-list.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/app/admin/css/aside.css" />
</head>

<body>
	<main class="l-main">
	<jsp:include page="/app/admin/jsp/aside.jsp"/>



      <!-- 메인헤더 -->
      <section class="l-content">
        <div class="header">
          <h1>회원조회</h1>
        </div>
        <div id="content-area">
          <select class="search-item">
			<option value="userNo">유저번호</option>
			<option value="userId">아이디</option>
			<option value="userNickname">닉네임</option>
			<option value="userType">회원종류</option>
			<option value="userName">이름</option>
          </select>
          <input type="text" class="c-input" placeholder="검색 조건">
          <button class="c-button c-button--primary c-button--md">조회</button>
        </div>

        <div class="c-list c-list--6col">
          <!-- header -->
	      <form id="content-area" action="${pageContext.request.contextPath}/admin/memlist.adm" method="get">
	        <select class="search-item" name="searchType">
	          <option value="userNo">유저번호</option>
	          <option value="userId">아이디</option>
	          <option value="userNickname">닉네임</option>
	          <option value="userType">회원종류</option>
	          <option value="userName">이름</option>
	        </select>
	        <input type="text" class="c-input" name="keyword" value="${requestScope.keyword}" placeholder="검색 조건" />
	        <button class="c-button c-button--primary c-button--md" type="submit">조회</button>
	      </form>
	      
          <!-- body -->
          <div class="c-list__body">
 			<c:forEach var="member" items="${memberList}">
			    <div class="c-list__row"
			         onclick="location.href='${pageContext.request.contextPath}/admin/memdetail.adm?userNo=${member.userNo}'"
			         style="cursor:pointer;">
			        <span class="c-list__col">${member.userNo}</span>
			        <span class="c-list__col">${member.userId}</span>
			
			        <c:choose>
			            <c:when test="${empty member.userNickname}">
			                <span class="c-list__col">-</span>
			            </c:when>
			            <c:otherwise>
			                <span class="c-list__col">${member.userNickname}</span>
			            </c:otherwise>
			        </c:choose>
			
			        <span class="c-list__col">${member.userTypeText}</span>
			        <span class="c-list__col">${member.userName}</span>
			    </div>
			</c:forEach>
            </div>
          </div>
        </div>
        <div class="page">
          <!-- 페이지네이션  c-pagination-->
          <nav class="c-pagination">
            <a class="c-pagination__link is-disabled">‹‹</a>
            <a class="c-pagination__link is-disabled">‹</a>
            <a class="c-pagination__link is-active">1</a>
            <a class="c-pagination__link">2</a>
            <a class="c-pagination__link">3</a>
            <a class="c-pagination__link">4</a>
            <a class="c-pagination__link">5</a>
            <a class="c-pagination__link">6</a>
            <a class="c-pagination__link">7</a>
            <a class="c-pagination__link">8</a>
            <a class="c-pagination__link">9</a>
            <a class="c-pagination__link">10</a>
            <a class="c-pagination__link">›</a>
            <a class="c-pagination__link">››</a>
          </nav>
        </div>
      </section>

  </main>


</body>

</html>