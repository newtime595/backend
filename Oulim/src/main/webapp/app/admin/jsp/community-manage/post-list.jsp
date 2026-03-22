<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!doctype html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>post-list</title>

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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/app/admin/css/community-manage/post-list.css" />
  <script defer src="${pageContext.request.contextPath}/app/admin/js/community-manage/post-list.js"></script>
</head>

<body>


  <main class="l-main">
      <!-- 사이드바 -->
    <aside>
      <!-- 관리자 영역 -->
      <div class="adminnow">
        <img src="" width="40" height="40" />
		<form action ="${pageContext.request.contextPath}/admin/logout.adm" >
        <button class="c-button c-button--primary c-button--md">
          로그아웃
        </button>
        </form>
      </div>

      <!-- 사이드바 메뉴 -->
      <nav class="sidebar-menu">
        <ul>
          <li class="menu-item">
            <a href="${pageContext.request.contextPath}/admin/dashboard.adm">통계</a>
          </li>

          <!-- 회원관리 -->
          <li class="menu-item dropdown">
            <a href="#" class="menu-title"> 회원관리 </a>

            <ul class="submenu">
              <li><a href="${pageContext.request.contextPath}/admin/companycertification.adm">기업회원</a></li>
              <li><a href="${pageContext.request.contextPath}/admin/memlist.adm">회원조회</a></li>
            </ul>
          </li>

          <!-- 봉사활동관리 -->
          <li class="menu-item dropdown">
            <a href="${pageContext.request.contextPath}/admin/volunlist.adm" class="menu-title"> 봉사활동관리 </a>
          </li>

          <!-- 게시판관리 -->
          <li class="menu-item dropdown">
            <a href="${pageContext.request.contextPath}/admin/postlist.adm" class="menu-title"> 게시판관리 </a>
          </li>
        </ul>
      </nav>
    </aside>


      <section class="l-content">
        <!-- 메인 위에 헤더 -->
        <div class="header">
          <h1>게시글 관리</h1>
        </div>
      <form id="content-area" action="${pageContext.request.contextPath}/admin/postlist.adm" method="get">
        <select class="search-item" name="searchType">
          <option value="writer" ${searchType == 'writer' ? 'selected' : ''}>닉네임</option>
          <option value="title" ${searchType == 'title' ? 'selected' : ''}>게시글 제목</option>
        </select>
        <input type="text" class="c-input" name="keyword" value="${keyword}" placeholder="검색 조건">
        <button class="c-button c-button--primary c-button--md" type="submit">조회</button>
      </form>

        <div class="c-list c-list--8col">
          <!-- header -->
          <div class="c-list__header">
         <label class="c-checkbox"><input type="checkbox" id="checkAll" />
         <span class="c-checkbox__box"></span></label>
          <span class="c-list__col">게시글 번호</span>
          <span class="c-list__col">닉네임</span>
          <span class="c-list__col">게시글 제목</span>
          <span class="c-list__col">작성일</span>
          <span class="c-list__col">추천수</span>
          <span class="c-list__col">조회수</span>
          <span class="c-list__col">관리</span>
          </div>
          <!-- body -->
          <div class="c-list__body">
          <c:if test="${empty postList}">
            <div class="c-list__row empty-row">
              <span class="c-list__col">-</span><span class="c-list__col">-</span><span class="c-list__col">게시글이 없습니다.</span><span class="c-list__col">-</span><span class="c-list__col">-</span><span class="c-list__col">-</span><span class="c-list__col">-</span><span class="c-list__col">-</span>
            </div>
          </c:if>
	          <c:forEach var="post" items="${postList}">
	            <div class="c-list__row">
	              <label class="c-checkbox"><input type="checkbox" class="row-check" /><span class="c-checkbox__box"></span></label>
	              <span class="c-list__col clicktitle" data-href="${pageContext.request.contextPath}/admin/postdetail.adm?postNo=${post.postNo}">${post.postNo}</span>
	              <span class="c-list__col clicktitle" data-href="${pageContext.request.contextPath}/admin/postdetail.adm?postNo=${post.postNo}">${post.userNickname}</span>
	              <span class="c-list__col clicktitle" data-href="${pageContext.request.contextPath}/admin/postdetail.adm?postNo=${post.postNo}">${post.postTitle}</span>
	              <span class="c-list__col clicktitle" data-href="${pageContext.request.contextPath}/admin/postdetail.adm?postNo=${post.postNo}">${post.postDate}</span>
	              <span class="c-list__col">${post.likeCount}</span>
	              <span class="c-list__col">${post.postViewCount}</span>
	              <div class="c-list__actions">
	                <form action="${pageContext.request.contextPath}/admin/postdeleteok.adm" method="post" onsubmit="return confirm('게시글을 삭제하시겠습니까?');">
	                  <input type="hidden" name="postNo" value="${post.postNo}" />
	                  <button class="c-button c-button--primary c-button--md" type="submit">삭제</button>
	                </form>
	              </div>
	            </div>
	          </c:forEach>
            </div>
          </div>

        <div class="page">
          <!-- 페이지네이션  c-pagination-->
        <nav class="c-pagination">
          <c:if test="${prev}"><a class="c-pagination__link" href="${pageContext.request.contextPath}/admin/postlist.adm?page=${startPage - 1}${queryString}">‹</a></c:if>
          <c:if test="${not prev}"><a class="c-pagination__link is-disabled">‹</a></c:if>
          <c:forEach var="i" begin="${startPage}" end="${endPage}">
            <a class="c-pagination__link ${i == page ? 'is-active' : ''}" href="${pageContext.request.contextPath}/admin/postlist.adm?page=${i}${queryString}">${i}</a>
          </c:forEach>
          <c:if test="${next}"><a class="c-pagination__link" href="${pageContext.request.contextPath}/admin/postlist.adm?page=${endPage + 1}${queryString}">›</a></c:if>
          <c:if test="${not next}"><a class="c-pagination__link is-disabled">›</a></c:if>
        </nav>
        </div>
      </section>

  </main>


</body>

</html>