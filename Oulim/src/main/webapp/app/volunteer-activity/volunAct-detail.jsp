<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>봉사 활동 상세</title>

<!-- base css -->
<link rel="stylesheet" href="${path}/asset/css/core/reset.css" />
<link rel="stylesheet" href="${path}/asset/css/core/variable.css" />
<link rel="stylesheet" href="${path}/asset/css/core/Typography.css" />
<link rel="stylesheet" href="${path}/asset/css/core/layout.css" />

<!-- component -->
<link rel="stylesheet" href="${path}/asset/css/component/button.css" />
<link rel="stylesheet" href="${path}/asset/css/component/list.css" />
<link rel="stylesheet" href="${path}/asset/css/component/badge.css" />

<!-- page css -->
<link rel="stylesheet" href="${path}/asset/css/pages/volunteer-activity/volunAct-detail.css">

<!-- header / footer -->
<link rel="stylesheet" href="${path}/asset/css/pages/main/header-login.css" />
<link rel="stylesheet" href="${path}/asset/css/pages/main/footer.css" />

<!-- js -->
<script defer src="${path}/asset/js/pages/volunteer-activity/volunAct-detail.js"></script>

</head>

<body>

<jsp:include page="/app/include/header.jsp" />

<div class="l-container">

    <!-- 뒤로가기 -->
    <div class="back-area">
        <button class="c-button c-button--primary" onclick="history.back()">뒤로</button>
    </div>

    <!-- 상태 -->
    <div class="status-area">
        <span class="c-badge 
            ${post.status eq 'recruiting' ? 'c-badge--active' : 'c-badge--disabled'}">
            ${post.statusText}
        </span>
    </div>

    <!-- 제목 -->
    <h1 class="title">${post.title}</h1>

    <!-- 메인 카드 -->
    <div class="detail-wrapper">

        <!-- 좌측 정보 -->
        <div class="detail-left">
            <ul class="info-list">

                <li>
                    <span>봉사기간</span>
                    <p>${post.startDate} ~ ${post.endDate}</p>
                </li>

                <li>
                    <span>모집기간</span>
                    <p>${post.recruitStartDate} ~ ${post.recruitEndDate}</p>
                </li>

                <li>
                    <span>봉사시간</span>
                    <p>${post.volunteerTime}</p>
                </li>

                <li>
                    <span>모집인원</span>
                    <p>
                        <strong class="point">${post.currentCount}명</strong>
                        / ${post.maxCount}명
                    </p>
                </li>

                <li>
                    <span>포인트</span>
                    <p class="point">${post.points}P</p>
                </li>

                <li>
                    <span>대상연령</span>
                    <p class="point">${post.targetAge}</p>
                </li>

            </ul>
        </div>

        <!-- 우측 지도 -->
        <div class="detail-right">
            <p class="location"><strong>봉사장소</strong> ${post.location}</p>

            <div id="map" class="map-box">
                지도 영역
            </div>
        </div>

    </div>

    <!-- 상세 내용 -->
    <div class="content-section">
        <h3>상세내용</h3>
        <div class="content-box">
            ${post.content}
        </div>
    </div>

    <!-- 버튼 -->
    <div class="btn-group">

        <form action="${path}/apply.do" method="post">
            <input type="hidden" name="id" value="${post.id}">
            <button class="btn-apply">신청</button>
        </form>

        <form action="${path}/cancel.do" method="post">
            <input type="hidden" name="id" value="${post.id}">
            <button class="btn-cancel">철회</button>
        </form>

    </div>

</div>

<jsp:include page="/app/include/footer.jsp" />

</body>
</html>