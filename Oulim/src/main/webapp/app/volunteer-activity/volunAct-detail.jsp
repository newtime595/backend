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

<link rel="stylesheet" href="/Oulim/asset/css/core/reset.css" />
<link rel="stylesheet" href="/Oulim/asset/css/core/variable.css" />
<link rel="stylesheet" href="/Oulim/asset/css/core/Typography.css" />
<link rel="stylesheet" href="/Oulim/asset/css/core/layout.css" />

<link rel="stylesheet" href="/Oulim/asset/css/component/input.css" />
<link rel="stylesheet" href="/Oulim/asset/css/component/button.css" />
<link rel="stylesheet" href="/Oulim/asset/css/component/badge.css" />

<link rel="stylesheet" href="/Oulim/asset/css/pages/volunteer-activity/volunAct-detail.css" />
</head>

<body>

<div class="l-container">
    <div class="u-margin-bottom-md">
        <button type="button" class="c-button c-button--primary"
                onclick="history.back();">뒤로</button>
    </div>

    <article class="volunteer-detail">

        <!-- 모집 상태 -->
        <div class="u-margin-bottom-sm">
            <span class="c-badge 
                ${post.recruStatus == '모집중' ? 'c-badge--active' : 'c-badge--disabled'}">
                ${post.recruStatus}
            </span>
        </div>

        <!-- 제목 -->
        <h1 class="t-title-lg u-margin-bottom-xl">
            ${post.volunActTitle}
        </h1>

        <div class="c-detail-card">

            <div class="c-detail-card__info">
                <ul class="c-list">

                    <!-- 봉사기간 -->
                    <li class="c-list__item">
                        <span class="c-list__label">봉사기간</span>
                        <span class="c-list__value">
                            ${post.volunActProcBegin} ~ ${post.volunActProcEnd}
                        </span>
                    </li>

                    <!-- 모집기간 -->
                    <li class="c-list__item">
                        <span class="c-list__label">모집기간</span>
                        <span class="c-list__value">
                            ${post.volunActRecruBegin} ~ ${post.volunActRecruEnd}
                        </span>
                    </li>

                    <!-- 봉사시간 -->
                    <li class="c-list__item">
                        <span class="c-list__label">봉사시간</span>
                        <span class="c-list__value">
                            ${post.volunActBeginTime} ~ ${post.volunActEndTime}
                        </span>
                    </li>

                    <!-- 모집인원 -->
                    <li class="c-list__item">
                        <span class="c-list__label">모집인원</span>
                        <span class="c-list__value">
                            <!-- currentCount 없음 → 일단 max만 표시 -->
                            ${post.volunActRecruMaxCount}명
                        </span>
                    </li>

                    <!-- 포인트 -->
                    <li class="c-list__item">
                        <span class="c-list__label">포인트</span>
                        <span class="c-list__value u-color-point u-weight-bold">
                            ${post.volunActPoint}P
                        </span>
                    </li>

                    <!-- 대상연령 -->
                    <li class="c-list__item">
                        <span class="c-list__label">대상연령</span>
                        <span class="c-list__value u-color-point">
                            ${post.volunActAgeGroup}
                        </span>
                    </li>

                </ul>
            </div>

            <!-- 주소 -->
            <div class="c-detail-card__map">
                <p class="u-margin-bottom-xs">
                    <strong>봉사장소</strong>
                    ${post.volunActAddress} ${post.volunActAddressDetail}
                </p>
                <div id="map" class="c-map-placeholder">지도 영역</div>
            </div>

        </div>

        <!-- 상세내용 -->
        <section class="u-margin-top-xxl">
            <h3 class="t-title-md u-text-center u-margin-bottom-lg">상세내용</h3>
            <div class="c-content-box">
                ${post.volunActDetail}
            </div>
        </section>

        <!-- 버튼 -->
        <div class="c-button-group u-margin-top-xl">
            <form action="apply.do" method="post" class="u-flex-1">
                <input type="hidden" name="id" value="${post.volunActNo}">
                <button type="submit"
                        class="c-button c-button--submit u-width-full">신청</button>
            </form>

            <form action="cancel.do" method="post" class="u-flex-1">
                <input type="hidden" name="id" value="${post.volunActNo}">
                <button type="submit"
                        class="c-button c-button--outline u-width-full">철회</button>
            </form>
        </div>

    </article>
</div>

</body>
</html>