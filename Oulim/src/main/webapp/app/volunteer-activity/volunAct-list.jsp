<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>봉사 활동</title>

    <!-- base css 필수 삽입-->
    <link rel="stylesheet" href="/Oulim/asset/css/core/reset.css" />
    <link rel="stylesheet" href="/Oulim/asset/css/core/variable.css" />
    <link rel="stylesheet" href="/Oulim/asset/css/core/Typography.css" />
    <link rel="stylesheet" href="/Oulim/asset/css/core/layout.css" />
    <!-- 컨포넌트 css 선택-->
    <link rel="stylesheet" href="/Oulim/asset/css/component/pagination.css" />
    <link rel="stylesheet" href="/Oulim/asset/css/component/input.css" />
    <link rel="stylesheet" href="/Oulim/asset/css/component/button.css" />
    <link rel="stylesheet" href="/Oulim/asset/css/component/list.css" />
    <link rel="stylesheet" href="/Oulim/asset/css/component/card.css" />
    <link rel="stylesheet" href="/Oulim/asset/css/component/DetailCard.css" />
    <link rel="stylesheet" href="/Oulim/asset/css/component/badge.css" />
    <link rel="stylesheet" href="/Oulim/asset/css/component/select.css" />

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
          <div class="l-volunAct-title">
            <h2>봉사 활동</h2>
          </div>
          <!-- 봉사활동 조회 옵션 선택 그룹 -->
          <div class="l-volunAct-list-search-option-group">
            <div class="l-volunAct-list-search-grid">
              <div class="l-volunAct-list-search-item">
                <label class="c-volunAct-list-search-label">활동분야</label>
				<select name="actType" class="c-select">
				    <option value="">전체</option>
				    <option value="1">환경</option>
				    <option value="2">의료</option>
				    <option value="3">교육</option>
				    <option value="4">생활·편의</option>
				    <option value="5">문화·체육·예술</option>
				    <option value="6">기타</option>
				</select>
              </div>

              <div class="l-volunAct-list-search-item">
                <label class="c-volunAct-list-search-label" name="recruitStatus">모집상태</label>
				<select name="recruitStatus" class="c-select">
				    <option value="">선택</option>
				    <option value="1">모집중</option>
				    <option value="2">모집 예정</option>
				    <option value="3">모집 마감</option>
				</select>
              </div>

              <div class="l-volunAct-list-search-item">
                <label class="c-volunAct-list-search-label">주체 단체</label>
                <input class="c-input" type="text" placeholder="주체 기업명" />
              </div>

              <div class="l-volunAct-list-search-item">
                <label class="c-volunAct-list-search-label">
                  참여 가능 연령
                </label>
				<select name="ageGroup" class="c-select">
				    <option value="">전체</option>
				    <option value="1">청소년 (14~19)</option>
				    <option value="2">청년 (20~30)</option>
				    <option value="3">직장인 (30+)</option>
				</select>
              </div>
            </div>

            <div class="l-volunAct-list-search-keyword">
              <select class="c-select" name="searchType">
                <option value="title">제목</option>
                <option value="author">작성자</option>
              </select>

              <input class="c-input" type="text" placeholder="관련 제목 검색" />
            </div>

            <div class="l-volunAct-list-search-submit">
              <button class="c-button c-button--primary c-button--lg">
                조회
              </button>
            </div>
          </div>
          <div class="l-volunAct-list-card-listA">
            <!-- 봉사목록 카드 리스트 영역 -->
			<ul class="l-volunAct-card-list">
			
			    <!-- 데이터 없을 때 -->
			    <c:if test="${empty volunteerList}">
			        <li>등록된 봉사활동이 없습니다.</li>
			    </c:if>
			
			    <!-- 데이터 있을 때 -->
			    <c:forEach var="item" items="${volunteerList}">
			        <li class="l-volunAct-card-element">
			            <div class="c-detail-card">
			                <a href="${pageContext.request.contextPath}/volunteer-activity/detail.va?volunActNo=${item.volunActNo}">
			                    <div class="card">
			                        <div class="title">${item.volunActTitle}</div>
			                        <div class="status">${item.recruStatus}</div>
			                        <div class="info"> ${item.volunActAddress}</div>
			                        <div class="info"> ${item.volunActPoint} point</div>
			                    </div>
			                </a>
			            </div>
			        </li>
			    </c:forEach>
			</ul>
            <!-- 봉사목록 카드 리스트 영역 종료-->
          </div>

          <div
            class="l-volunAct-list-pagination"
            style="width: 900px; margin: 50px"
          >
            <!-- 페이지네이션  c-pagination-->
            <nav class="c-pagination">
              <a class="c-pagination__link is-disabled">‹</a>
              <a class="c-pagination__link is-active">1</a>
              <a class="c-pagination__link">2</a>
              <a class="c-pagination__link">3</a>
              <a class="c-pagination__link">›</a>
            </nav>
          </div>
        </div>
      </div>
    </div>
    <jsp:include page="/app/include/footer.jsp" />
  </body>
</html>
