<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>company-certification</title>

    <!-- base css 필수 삽입-->
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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/app/admin/css/member-manage/company-certification.css" />
  <script defer src="${pageContext.request.contextPath}/app/admin/js/member-manage/company-certification.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/app/admin/css/aside.css" />
</head>

<body>
	<main class="l-main">
	<jsp:include page="/app/admin/jsp/aside.jsp"/>


    <!-- 메인 -->
    <section class="l-content">
        <!-- 메인헤더 -->
        <div class="header">
          <h1>기업회원관리</h1>
        </div>
        <div id="content-area">
          <p id="company-count">총 처리 필요 회원 수 : ${totalCount}</p>
        </div>

        <div class="c-list c-list--6col">
          <!-- header -->
          <div class="c-list__header">
            <span class="c-list__col">유저번호</span>
            <span class="c-list__col">회사명</span>
            <span class="c-list__col">아이디</span>
            <span class="c-list__col">회원명</span>
            <span class="c-list__col">회사코드</span>
            <span class="c-list__col"></span>
          </div>
          <!-- body -->
          <div class="c-list__body">
          <c:if test="${not empty requireMemberList}">          
          	<c:forEach var="certMember" items="${requireMemberList}">
            <div class="c-list__row">
              <span class="c-list__col company-detail"> ${certMember.userNo} </span>
              <span class="c-list__col company-detail"> ${certMember.organName} </span>
              <span class="c-list__col company-detail"> ${certMember.userId } </span>
              <span class="c-list__col company-detail"> ${certMember.userName}</span>
              <span class="c-list__col company-detail"> ${certMember.organNo}</span>
              <button class="c-button c-button--primary c-button--sm"
               onclick="location.href = '${pageContext.request.contextPath}/admin/companydetail.adm?userNo=${certMember.userNo}'">상세보기</button>
            </div>
            </c:forEach>
            </c:if>            
          </div>
        </div>
		<div class="l-community-list-pagination">
          <c:if test="${not empty requireMemberList}">
          
            <!-- 페이지네이션  c-pagination-->
            <nav class="c-pagination">
              <c:choose>
              	<c:when test="${prev}">
              		<a href="${pageContext.request.contextPath}/admin/companycertification.adm?page=${startPage-1}" 
              		class="c-pagination__link">&lt;</a>
              	</c:when>
              	<c:otherwise>
              		<a href="${pageContext.request.contextPath}/admin/companycertification.adm?page=${startPage-1}" 
              		class="c-pagination__link is-disabled" onclick="return false;">&lt;</a>
              	</c:otherwise>
              </c:choose>
              <c:set var="realStartPage" value="${startPage < 1 ? 1 : startPage }"/>
              <c:forEach var="i" begin="${realStartPage}" end="${endPage}">
    			<c:choose>          
    				<c:when test="${!(i == page)}">
	              		<a href="${pageContext.request.contextPath}/admin/companycertification.adm?page=${i}"
	              			 class="c-pagination__link">
	               			<c:out value="${i}"/>
	               		</a>
	               	</c:when>
	               	<c:otherwise>
	               		<a href="#" class="c-pagination__link is-active">
	               			<c:out value="${i}"/>
	               		</a>
	               	</c:otherwise>
	            </c:choose>	            
              </c:forEach>
              <c:choose>
              	<c:when test="${next}">
              		<a href="${pageContext.request.contextPath}/admin/companycertification.adm?page=${endPage + 1}"
              	 	class="c-pagination__link">&gt;</a>
              	</c:when>
              	<c:otherwise>
              		<a href="${pageContext.request.contextPath}/admin/companycertification.adm?page=${endPage + 1}"
              	 	class="c-pagination__link is-disabled" onclick="return false;">&gt;</a>
              	</c:otherwise>
              </c:choose>
            </nav>
            </c:if>
          </div>
      </section>
  </main>

</body>

</html>