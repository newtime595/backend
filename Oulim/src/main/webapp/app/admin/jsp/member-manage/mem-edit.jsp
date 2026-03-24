<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>회원 수정</title>
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
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/app/admin/css/member-manage/mem-edit.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/app/admin/css/aside.css" />
     <script>
    	const contextPath = "${pageContext.request.contextPath}";
    </script>
	<script defer src="${pageContext.request.contextPath}/app/admin/js/member-manage/mem-edit.js"></script>
  </head>

  <body>

    <main class="l-main">
      <!-- 사이드바 -->
		<jsp:include page="/app/admin/jsp/aside.jsp" />

      <!-- 메인 헤더 -->
      <section class="l-content">
        <div class="header">
          <h1>회원수정</h1>
        </div>
        	<input type="hidden" name="userNo" value="${member.userNo}" />
			<c:if test="${not empty member}">
			  <form id="content-area" action="${pageContext.request.contextPath}/admin/memUpdateOk.adm" method="post">
			    <input type="hidden" name="userNo" value="${member.userNo}" />
			
			    <div>
			      <label>아이디</label>
			      <input class="c-input" type="text" value="${member.userId}" readonly />
			    </div>
			
			    <div id="userNickname">
			      <div>
			        <label>닉네임</label>
			        <input class="c-input" type="text" name="userNickname"
			               value="${empty member.userNickname ? '' : member.userNickname}" />
			      </div>
			      <button class="c-button c-button--secondary c-button--md side-button" type="button">중복확인</button>
			    </div>
			
			    <div>
			      <label>주소</label>
			      <input class="c-input" type="text" name="userAddress"
			             value="${empty member.userAddress ? '' : member.userAddress}" />
			    </div>
			
			    <div>
			      <label>상세주소</label>
			      <input class="c-input" type="text" name="userAddressDetail"
			             value="${empty member.userAddressDetail ? '' : member.userAddressDetail}" />
			    </div>
			
			    <div id="myPoint">
			      <div>
			        <label>보유포인트</label>
			        <input class="c-input" type="text"
			               value="${member.totalAmount}P" readonly />
			      </div>
			      <div>
			        <label>포인트수정</label>
			        <input class="c-input" type="number" name="pointAmount" value="0" />
			      </div>
			    </div>
			
			    <div style="display:flex; gap:12px; margin-top:16px;">
			      <button class="c-button c-button--primary c-button--md" type="submit">저장</button>
			      <a class="c-button c-button--secondary c-button--md"
			         href="${pageContext.request.contextPath}/admin/memDetail.adm?userNo=${member.userNo}">
			        취소
			      </a>
			    </div>
			  </form>
			
			  <hr style="margin:30px 0;">
			
			  <h2>포인트 사용내역</h2>
			
			  <div class="c-list c-list--4col">
			    <div class="c-list__header">
			      <span class="c-list__col">번호</span>
			      <span class="c-list__col">내용</span>
			      <span class="c-list__col">포인트</span>
			      <span class="c-list__col">날짜</span>
			    </div>
			
			    <div class="c-list__body">
			      <c:if test="${empty pointList}">
			        <div class="c-list__row">
			          <span class="c-list__col">-</span>
			          <span class="c-list__col">내역 없음</span>
			          <span class="c-list__col">-</span>
			          <span class="c-list__col">-</span>
			        </div>
			      </c:if>
			
			      <c:forEach var="point" items="${pointList}">
			        <div class="c-list__row">
			          <span class="c-list__col">${point.logNo}</span>
			          <span class="c-list__col">${point.logReason}</span>
			          <span class="c-list__col">${point.changeAmount}</span>
			          <span class="c-list__col">${point.logDate}</span>
			        </div>
			      </c:forEach>
			    </div>
			  </div>
			</c:if>
      </section>
    </main>

  </body>
</html>
