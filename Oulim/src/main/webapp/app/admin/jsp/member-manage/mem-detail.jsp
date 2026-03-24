<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!doctype html>
<html lang="ko">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />

  <!-- 페이지 제목 -->
  <title>회원 정보 상세</title>

  <!-- 공통 reset / 변수 / 타이포 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/layout.css" />

  <!-- 공통 컴포넌트 css -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/pagination.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/input.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/button.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/list.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/card.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/DetailCard.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/badge.css" />

  <!-- 회원 상세 전용 css -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/app/admin/css/member-manage/mem-detail.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/app/admin/css/aside.css" />
	<script>
		const contextPath = "${pageContext.request.contextPath}";
	</script>
	<script defer src="${pageContext.request.contextPath}/app/admin/js/member-manage/mem-detail.js"></script>
</head>

<body>
  <main class="l-main">
	<jsp:include page="/app/admin/jsp/aside.jsp"/>
  <div class="l-container">
    <!-- 우측 메인 컨텐츠 시작 -->

    <section class="l-content">

      <!-- 페이지 제목 -->
      <div class="header">
        <h1>회원 정보 상세</h1>
      </div>

      <!-- 상세 전체 박스 -->
      <div class="detail-wrap">

   
        <p class="detail-guide">
          *회원정보수정은 꼭 회원의 요청에 의해서만 진행하세요. 관리자의 임의 수정은 지양해 주세요.<br />
          비밀번호는 고객이 직접 재설정하도록 안내만 주세요.
        </p>

        <!-- 회원번호 + 상세 폼 묶음 -->
        <div class="detail-body">

          <!-- 우측 상세 입력/표시 영역 -->
<!--            <form class="detail-form"> -->

            <!-- 이름 -->
  			<c:if test="${not empty member}">
            <form class="detail-form" action="${pageContext.request.contextPath}/admin/memEdit.adm" method="get">
              <input type="hidden" name="userNo" value="${member.userNo}" />

              <div class="detail-item">
                <label class="detail-label" for="userName">이름</label>
                <input
                  id="userName"
                  type="text"
                  class="c-input detail-input"
                  name="userName"
                  value="${member.userName}"
                  placeholder="이름"
                  readonly
                />
              </div>

            <!-- 아이디 -->
              <div class="detail-item">
                <label class="detail-label" for="userNickname">닉네임</label>
                <div class="inline-row">
                  <input
                    id="userNickname"
                    type="text"
                    class="c-input detail-input flex-input"
                    name="userNickname"
                    value="${empty member.userNickname ? '' : member.userNickname}"
                    placeholder="닉네임"
                    readonly
                  />
                </div>
              
            </div>

            <!-- 닉네임 -->
            <div class="detail-item">
              <label class="detail-label" for="userNickname">닉네임 수정</label>

              <!-- 입력창 + 버튼 한 줄 -->
              <div class="inline-row">
                <input
                  id="userNickname"
                  type="text"
                  class="c-input detail-input flex-input"
                  name="newNickname"
                  placeholder="새로운 닉네임"
                />
                

                <button type="button" class="c-button c-button--primary c-button--md side-button">
                  중복확인
                </button>
              </div>

              
              <div class="detail-help">
                *회원 닉네임은 초기화만 가능합니다. 재설정은 회원이 직접 설정하게 하세요.<br />
                *user001 ~ user999까지 임의로 작성해서 중복확인 진행해 주세요.
              </div>
            </div>

            <!-- 주소 -->
            <div class="detail-item">
              <label class="detail-label" for="userAddress">주소</label>

                <div class="inline-row">
                  <input
                    id="userAddress"
                    type="text"
                    class="c-input detail-input flex-input"
                    name="userAddress"
                    value="${empty member.userAddress ? '' : member.userAddress}"
                    placeholder="주소입력"
                    readonly
                  />
                

                <button type="button" class="c-button c-button--primary c-button--md side-button icon-button">
                  돋보기
                </button>
              </div>
            </div>

            <!-- 보유포인트 -->
            <div class="detail-item">
              <div class="inline-row">
                <label class="detail-label" for="totalPoint">보유포인트</label>
                <div class="inline-row">
                  <input
                    id="totalPoint"
                    type="text"
                    class="c-input detail-input point-input"
                    name="totalPoint"
                    value="${member.totalAmount}P"
                    placeholder="포인트"
                    readonly
                  />

				<a href="${pageContext.request.contextPath}/admin/memEdit.adm?userNo=${member.userNo}"
				   class="c-button c-button--primary c-button--md point-button">
				    포인트상세내역 보기
				</a>
              </div>
             </div>
            </div>

            <!-- 하단 버튼 -->
              <div class="button-group">
                <button type="submit" class="c-button c-button--primary c-button--md action-button">
                  수정
                </button>

                <a href="${pageContext.request.contextPath}/admin/memDeleteOk.adm?userNo=${member.userNo}"
                   class="c-button c-button--secondary c-button--md action-button">
                  탈퇴
                </a>
              </div>
            </form>
          </c:if>

          <c:if test="${empty member}">
            <p>회원 정보를 불러올 수 없습니다.</p>
          </c:if>
        </div>
      </div>
    </section>

	</div>
  </main>
</body>
</html>