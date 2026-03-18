<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>어울림터 봉사 후기</title>

    <!-- base css 필수 삽입-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/layout.css" />

    <!-- 컨포넌트 css 선택-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/pagination.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/input.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/button.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/list.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/card.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/DetailCard.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/badge.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/select.css" />
  <link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
  <link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />
    <!-- css 연결 -->
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/asset/css/pages/community/community-list.css"
    />
    <script defer src="${pageContext.request.contextPath}/asset/js/pages/main/include.js"></script>
    <script defer src="${pageContext.request.contextPath}/asset/js/pages/community/community-list.js"></script>
    <script>
    	const contextPath = "${pageContext.request.contextPath}";
    </script>
  </head>
  
  <body>
    <!-- Header 자동 삽입 -->
  	<jsp:include page="/app/include/header.jsp" />

    <main class="l-main">
      <!-- 팀원들 작성 영역 이 안에서 작업하기!!퍼블 작업진행 -->
      <div class="l-container">
        <div class="p-community-list-main">
          <div class="c-community-list-title">
            <h2>어울림터 봉사 후기</h2>
          </div>
          <div class="l-community-list-search-group">
            <div class="c-community-post-btn">
              <button class="c-button c-button--primary c-button--lg">
                글쓰기
              </button>
            </div>
            <div class="l-community-search-box">
              <!-- <select class="c-community-search" name="search-type" id=""> -->
              <div class="c-select-size-controler">
                <select class="c-select" name="search-type" id="searchType">
                  <option value="title">제목</option>
                  <option value="writer">작성자</option>
                </select>
              </div>

              <input
                class="c-input"
                type="text"
                name="keyword"
                placeholder="검색어 입력"
                id="keyword"
              />

              <div class="c-community-list-search-btn-container">
                <button id="searchBtn" class="c-button c-button--primary">검색</button>
              </div>
            </div>
          </div>
          <!-- 공통 컴포넌트 c-list-list--5col 사용 -->
          <div class="c-list c-list--5col">
            <!-- header -->
            <div class="c-list__header">
              <span class="c-list__col">제목</span>
              <span class="c-list__col">번호</span>
              <span class="c-list__col">닉네임</span>
              <span class="c-list__col">작성일</span>
              <span class="c-list__col">추천수</span>
            </div>
            <!-- body -->
            <div class="c-list__body">
            	<c:choose>
            		<c:when test="${not empty postList}">
            			<c:forEach var="post" items="${postList}">
							<a href="${pageContext.request.contextPath}/community/detail.commu?postNo=${post.postNo}">
									<div class="c-list__row">
											<span class="c-list__col"> <c:out
													value="${post.getPostTitle()}" />
											</span> <span class="c-list__col"> <c:out
													value="${post.getPostNo()}" />
											</span> <span class="c-list__col"> <c:out
													value="${post.getUserNickname()}" />
											</span> <span class="c-list__col"> <c:out
													value="${post.getPostDate()}" />
											</span> <span class="c-list__col"> <c:out
													value="${post.getLikeCount() }" />
											</span>
										</div>
							</a>
						</c:forEach>
            		</c:when>
            		<c:otherwise>
            			<div>
            				<div colspan="5" align="center">등록된 게시물이 없습니다.</div>
            			</div>
            		</c:otherwise>
            	</c:choose>            
            </div>
          </div>
          <!-- 페이지네이션 -->
          <!-- 공통 컴포넌트  c-pagination 사용-->
          <div
            class="l-community-list-pagination"
            style="width: 900px; margin: 50px"
          >
            <!-- 페이지네이션  c-pagination-->
            <nav class="c-pagination">
              <c:choose>
              	<c:when test="${prev}">
              		<a href="${pageContext.request.contextPath}/community/list.commu?page=${startPage-1}" 
              		class="c-pagination__link">&lt;</a>
              	</c:when>
              	<c:otherwise>
              		<a href="${pageContext.request.contextPath}/community/list.commu?page=${startPage-1}" 
              		class="c-pagination__link is-disabled" onclick="return false;">&lt;</a>
              	</c:otherwise>
              </c:choose>
              <c:set var="realStartPage" value="${startPage < 1 ? 1 : startPage }"/>
              <c:forEach var="i" begin="${realStartPage}" end="${endPage}">
    			<c:choose>          
    				<c:when test="${!(i == page)}">
	              		<a href="${pageContext.request.contextPath}/community/list.commu?page=${i}&searchType=${searchType}&keyword=${keyword}"
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
              		<a href="${pageContext.request.contextPath}/community/list.commu?page=${endPage + 1}"
              	 	class="c-pagination__link">&gt;</a>
              	</c:when>
              	<c:otherwise>
              		<a href="${pageContext.request.contextPath}/community/list.commu?page=${endPage + 1}"
              	 	class="c-pagination__link is-disabled" onclick="return false;">&gt;</a>
              	</c:otherwise>
              </c:choose>
            </nav>
          </div>
          
        </div>
      </div>
    </main>

    <!-- Footer 자동 삽입 -->
  <jsp:include page="/app/include/footer.jsp" />
  </body>
</html>
