<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>point-history</title>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />

  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/pagination.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/input.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/button.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/list.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/card.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/DetailCard.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/badge.css" />
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />

  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/mypage/point-history/point-history.css">


  <script defer src="${pageContext.request.contextPath}/asset/js/pages/mypage/point-history/point-history.js"></script>

</head>

<body>
<jsp:include page="/app/include/header.jsp" />

  <main class="l-main">

    <div class="l-mypage">

      <div class="l-mypage--aside">

        <aside>

          <div class="p-point-history--menu">

            <ul>

              <h2>마이페이지</h2>

              <div class="p-point-history--menu-group">
                <li>나의 정보</li>
                <br>
                <a href="${pageContext.request.contextPath}/mypage/checkOk.mp">
                  <li>- 내 정보 보기</li>
                </a>
                <br>
                <a href="${pageContext.request.contextPath}/mypage/userEdit.mp">
                  <li>- 내 정보 수정</li>
                </a>
              </div>

              <div class="p-point-history--menu-group">
                <li>봉사조회</li>
                <br>
                <a href="${pageContext.request.contextPath}/mypage/comingVolun.mp">
                  <li>- 예정된 봉사 이력 조회</li>
                </a>
                <br>
                <a href="${pageContext.request.contextPath}/mypage/finishVolun.mp">
                  <li>- 완료된 봉사 이력 조회</li>
                </a>
              </div>

              <div class="p-point-history--menu-group">
                <a href="${pageContext.request.contextPath}/mypage/point.mp"><li>포인트 조회</li></a>
              </div>

              <div class="p-point-history--menu-group">
                <a href="${pageContext.request.contextPath}/mypage/myPost.mp">
                  <li>작성글 조회</li>
                </a>
              </div>

              <div class="p-point-history--menu-group">
                <a href="${pageContext.request.contextPath}/mypage/quit.mp">
                  <li>회원 탈퇴</li>
                </a>
              </div>

            </ul>

          </div>

        </aside>

      </div>

      <div class="l-mypage--content">

        <div class="p-point-history--header">
          <h1>포인트 조회</h1>
        </div>

        <div class="p-point-history--body">

          <div class="p-point-history--nav">

            <nav>

              <div id="plus">적립 포인트</div>
              <div id="minus">사용 포인트</div>

            </nav>

            <hr>

          </div>

          <div id="a" class="p-point-history--earn-list">

            <ul>

              <li>

                <div>

                  <h5>포인트 적립</h5>
                  <h5>2026-01-04</h5>

                </div>

                <div>20p</div>

              </li>

              <li>

                <div>

                  <h5>포인트 적립</h5>
                  <h5>2026-01-04</h5>

                </div>

                <div>300p</div>

              </li>

              <li>

                <div>

                  <h5>포인트 적립</h5>
                  <h5>2026-01-04</h5>

                </div>

                <div>300p</div>

              </li>

              <li>

                <div>

                  <h5>포인트 적립</h5>
                  <h5>2026-01-04</h5>

                </div>

                <div>300p</div>

              </li>

            </ul>

          </div>

          <div id="b" class="p-point-history--use-list">

            <ul>

              <li>

                <div>

                  <h5>먹이주기</h5>
                  <h5>2026-01-04</h5>

                </div>

                <div>-20p</div>

              </li>

              <li>

                <div>

                  <h5>먹이주기</h5>
                  <h5>2026-01-04</h5>

                </div>

                <div>-300p</div>

              </li>

              <li>

                <div>

                  <h5>먹이주기</h5>
                  <h5>2026-01-04</h5>

                </div>

                <div>-300p</div>

              </li>

              <li>

                <div>

                  <h5>먹이주기</h5>
                  <h5>2026-01-04</h5>

                </div>

                <div>-300p</div>

              </li>

            </ul>

          </div>

          <div class="p-point-history--pagination">

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