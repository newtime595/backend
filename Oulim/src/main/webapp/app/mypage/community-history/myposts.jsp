<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>myposts</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/typography.css" />

    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/pagination.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/input.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/button.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/list.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/card.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/DetailCard.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/badge.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/mypage/community-history/myposts.css">

</head>

<body>

<jsp:include page="/app/include/header.jsp" />

    <main class="l-main">

        <div class="l-mypage">

            <div class="l-mypage--aside">

                <aside>

                    <div class="p-mypage-posts--menu">

                        <ul>

                            <h2>마이페이지</h2>

                            <div class="p-mypage-posts--menu-group">
                                <li>나의 정보</li>
                                <br>
                                <a href="${pageContext.request.contextPath}/front/html/mypage/profile/profile.html"><li>- 내 정보 보기</li></a>
                                <br>
                                <a href="${pageContext.request.contextPath}/front/html/mypage/profile/profile-edit.html"><li>- 내 정보 수정</li></a>
                            </div>

                            <div class="p-mypage-posts--menu-group">
                                <li>봉사조회</li>
                                <br>
                                <a href="${pageContext.request.contextPath}/front/html/mypage/volunteer-history/coming-volunteer.html"><li>- 예정된 봉사 이력 조회</li></a>
                                <br>
                                <a href="${pageContext.request.contextPath}/front/html/mypage/volunteer-history/finish-volunteer.html"><li>- 완료된 봉사 이력 조회</li></a>
                            </div>

                            <div class="p-mypage-posts--menu-group">
                                <a href="${pageContext.request.contextPath}/front/html/mypage/point-history/point-history.html"><li>포인트 조회</li></a>
                            </div>

                            <div class="p-mypage-posts--menu-group">
                                <a href="${pageContext.request.contextPath}/front/html/mypage/community-history/myposts.html"><li>작성글 조회</li></a>
                            </div>

                            <div class="p-mypage-posts--menu-group">
                                <a href="${pageContext.request.contextPath}/front/html/mypage/quit/quit.html"><li>회원 탈퇴</li></a>
                            </div>

                        </ul>

                    </div>

                </aside>

            </div>

            <div class="l-mypage--content">

                <div class="p-mypage-posts--header">
                    <h1>나의 작성글</h1>
                </div>

                <div class="p-mypage-posts--body">

                    <div class="c-list c-list--4col">

                        <div class="c-list__header">
                            <span class="c-list__col">제목</span>
                            <span class="c-list__col">작성일</span>
                            <span class="c-list__col">추천수</span>
                            <span class="c-list__col">-</span>
                        </div>

                        <div class="c-list__body">

                            <div class="c-list__row">

                                <span class="c-list__col">
                                    2025/2026년 주민과 함께하는 제설작업 자원 봉사자 모집(창4동)
                                </span>

                                <span class="c-list__col">
                                    26.02.03
                                </span>

                                <span class="c-list__col">
                                    1234개
                                </span>

                                <div class="c-list__actions">

                                    <a href="${pageContext.request.contextPath}/front/html/community/community-repost.html"><button class="c-button c-button--primary c-button--sm">
                                        수정
                                    </button></a>

                                </div>

                            </div>

                        </div>

                    </div>

                    <div class="p-mypage-posts--pagination">

                        <nav class="c-pagination">

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

                        </nav>

                    </div>

                </div>

            </div>

        </div>

    </main>


<jsp:include page="/app/include/footer.jsp" />
</body>

</html>