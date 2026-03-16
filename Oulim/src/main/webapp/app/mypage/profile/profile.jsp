<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>profile</title>

  <!-- base css 필수 삽입-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/typography.css" />

  <!-- 컨포넌트 css 선택-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/pagination.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/input.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/button.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/list.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/card.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/DetailCard.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/badge.css" />
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />


  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/mypage/profile/profile.css" />

</head>

<body>
<jsp:include page="/app/include/header.jsp" />

  <main class="l-main">
    <div class="main-container">
      <div class="main-aside">
        <aside>
          <div class="main-aside-list">

            <h2>마이페이지</h2>

            <ul class="list1">
              <li>나의 정보</li>
              <br>
              <a href="${pageContext.request.contextPath}/front/html/mypage/profile/profile.html">
                <li>- 내 정보 보기</li>
              </a>
              <br>
              <a href="${pageContext.request.contextPath}/front/html/mypage/profile/profile-edit.html">
                <li>- 내 정보 수정</li>
              </a>
              <br>
            </ul>

            <ul class="list2">
              <li>봉사조회</li>
              <br>
              <a href="${pageContext.request.contextPath}/front/html/mypage/volunteer-history/coming-volunteer.html">
                <li>- 예정된 봉사 이력 조회</li>
              </a>
              <br>
              <a href="${pageContext.request.contextPath}/front/html/mypage/volunteer-history/finish-volunteer.html">
                <li>- 완료된 봉사 이력 조회</li>
              </a>

            </ul>

            <ul class="list3">
              <a href="${pageContext.request.contextPath}/front/html/mypage/point-history/point-history.html">
                <li>포인트 조회</li>
              </a>
            </ul>

            <ul class="list4">
              <a href="${pageContext.request.contextPath}/front/html/mypage/community-history/myposts.html">
                <li>작성글 조회</li>
              </a>
            </ul>

            <ul class="list5">
              <a href="${pageContext.request.contextPath}/front/html/mypage/quit/quit.html">
                <li>회원 탈퇴</li>
              </a>
            </ul>

          </div>
        </aside>
      </div>

      <div class="main-2">
        <div class="main-section1">
          <img src="${pageContext.request.contextPath}/asset/image/character/komi-lv9.svg" alt="펫사진" />
          <div class="sec1-text">
            <h1>zl존봉사12</h1>
            <br>
            <h5>총 봉사 횟수 : 145회</h5>
            <h5>총 봉사 시간 : 1456시간</h5>
            <h5>랭킹 포인트 : 44,100p</h5>
            <h5>현재 포인트 : 50p</h5>
          </div>
        </div>

        <div class="main-section2">
          <a href="${pageContext.request.contextPath}/front/html/volunteer-activity/volunAct-detail.html">
          <div class="c-card">
            <h5>나의 예정된 봉사</h5>
            <hr />
            <br>
            <div class="c-card__header">
              <span class="c-badge c-badge--primary">모집중</span>
            </div>
            <h3 class="c-card__title">주민과 함께하는 제설작업 봉사 모집</h3>
            <p class="c-card__desc">
              지역 주민들과 함께하는 봉사 활동입니다.
            </p>
            <div class="c-card__footer">
              <span>2026.02.03 ~ 2026.02.06</span>
            </div>
          </div>
          </a>

          <a href="${pageContext.request.contextPath}/front/html/volunteer-activity/volunAct-detail.html">
          <div class="c-card">
            <h5>나의 완료된 봉사</h5>
            <hr />
            <br>
            <div class="c-card__header">
              <span class="c-badge c-badge--primary">완료</span>
            </div>
            <h3 class="c-card__title">주민과 함께하는 제설작업 봉사 모집</h3>
            <p class="c-card__desc">
              지역 주민들과 함께하는 봉사 활동입니다.
            </p>
            <div class="c-card__footer">
              <span>2026.02.03 ~ 2026.02.06</span>
            </div>
          </div>
          </a>
        </div>

        <div class="main-section3">
          <a href="${pageContext.request.contextPath}/front/html/mypage/point-history/point-history.html">
          <div class="c-card">
            <h5>나의포인트</h5>
            <hr />
            <br>
            <div class="c-card__header">
              <span class="c-badge c-badge--primary">완료</span>
            </div>
            <h3 class="c-card__title">주민과 함께하는 제설작업 봉사 모집</h3>
            <p class="c-card__desc">
              봉사를 마치고 150p를 획득했어요!
            </p>
            <div class="c-card__footer">
              <span>2026-01-04</span>
            </div>
            <br>
            <div class="c-card__header">
              <span class="c-badge c-badge--primary">완료</span>
            </div>
            <h3 class="c-card__title">주민과 함께하는 제설작업 봉사 모집</h3>
            <p class="c-card__desc">
              봉사를 마치고 200p를 획득했어요!
            </p>
            <div class="c-card__footer">
              <span>2026-01-04</span>
            </div>
            <br>

            <div class="c-card__header">
              <span class="c-badge c-badge--primary">완료</span>
            </div>
            <h3 class="c-card__title">주민과 함께하는 제설작업 봉사 모집</h3>
            <p class="c-card__desc">
              봉사를 마치고 50p를 획득했어요!
            </p>
            <div class="c-card__footer">
              <span>2026-01-04</span>
            </div>
            <br>
            <div class="c-card__header">
              <span class="c-badge c-badge--primary">완료</span>
            </div>
            <h3 class="c-card__title">주민과 함께하는 제설작업 봉사 모집</h3>
            <p class="c-card__desc">
              봉사를 마치고 100p를 획득했어요!
            </p>
            <div class="c-card__footer">
              <span>2026-01-04</span>
            </div>

          </div>
          </a>
        </div>


      </div>
    </div>
  </main>

<jsp:include page="/app/include/footer.jsp" />
</body>

</html>