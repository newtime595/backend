<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>봉사 활동 상세</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/core/layout.css" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/button.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/list.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/component/badge.css" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/volunteer-activity/volunAct-detail.css">

<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />

<script defer src="${pageContext.request.contextPath}/asset/js/pages/volunteer-activity/volunAct-detail.js"></script>
<script src="https://dapi.kakao.com/v2/maps/sdk.js?appkey=d090ba1051e43d12c75b06b4254865bf&autoload=false&libraries=services"></script>
</head>

<body>

<jsp:include page="/app/include/header.jsp" />
<input type="hidden" id="message" value="${param.message}">
<div class="l-container">

    <div class="back-area">
        <button type="button" class="edit-btn c-button c-button--primary c-button--md" onclick="location.href='${pageContext.request.contextPath}/volunteer-activity/list.va'">봉사활동목록</button>
    </div>

    <div class="status-area">
        <span class="c-badge c-badge--primary" id="volunteerStatus">
						${volunActivity.recruStatus}
		</span>
			<span class="c-badge c-badge--orange" id="volunteerTarget">
				<c:choose>
					<c:when test="${volunActivity.volunActAgeGroup == 0}">전체</c:when>
					<c:when test="${volunActivity.volunActAgeGroup == 1}">청소년</c:when>
					<c:when test="${volunActivity.volunActAgeGroup == 2}">청년</c:when>
					<c:when test="${volunActivity.volunActAgeGroup == 3}">직장인</c:when>
					<c:otherwise>${volunActivity.volunActAgeGroup}</c:otherwise>
				</c:choose>
			</span>
  	</div>
    <h1 class="title">${volunActivity.volunActTitle}</h1>
    <div class="detail-wrapper">
        <div class="detail-left">
            <ul class="info-list">

                <li>
                    <span>봉사기간</span>
                    <p>${volunActivity.volunActProcBegin} ~ ${volunActivity.volunActProcEnd}</p>
                </li>

                <li>
                    <span>모집기간</span>
                    <p>${volunActivity.volunActRecruBegin} ~ ${volunActivity.volunActRecruEnd}</p>
                </li>

                <li>
                    <span>봉사시간</span>
                    <p>${volunActivity.volunActBeginTime}:00 ~ ${volunActivity.volunActEndTime}:00</p>
                </li>

                <li>
                    <span>모집인원</span>
                    <p>${volunActivity.volunActRecruMaxCount}명</p>
                </li>

                <li>
                    <span>포인트</span>
                    <p class="point">${volunActivity.volunActPoint}P</p>
                </li>

                <li>
                    <span>봉사자 연령</span>
                    <p>
                       <c:choose>
						    <c:when test="${volunActivity.volunActAgeGroup eq 0}">전체</c:when>
						    <c:when test="${volunActivity.volunActAgeGroup eq 1}">청소년</c:when>
						    <c:when test="${volunActivity.volunActAgeGroup eq 2}">청년</c:when>
						    <c:when test="${volunActivity.volunActAgeGroup eq 3}">직장인</c:when>
						    <c:otherwise></c:otherwise>
						</c:choose>
                    </p>
                </li>

                <li>
                    <span>주최기관</span>
                    <p>
                        ${volunActivity.orgName}
                    </p>
                </li>

                <li>
                    <span>활동분야</span>
                    <p><c:choose>
						    <c:when test="${volunActivity.volunActActType eq 1}">환경</c:when>
						    <c:when test="${volunActivity.volunActActType eq 2}">의료</c:when>
						    <c:when test="${volunActivity.volunActActType eq 3}">교육</c:when>
						    <c:when test="${volunActivity.volunActActType eq 4}">생활·편의</c:when>
						    <c:when test="${volunActivity.volunActActType eq 5}">문화·체육·예술</c:when>
						    <c:when test="${volunActivity.volunActActType eq 6}">기타</c:when>
						</c:choose></p>
                </li>

            </ul>
        </div>

        <div class="detail-right">
		    <p class="location">
		        <strong>봉사장소</strong>
		        <span id="volunteerLocation">
		            ${volunActivity.volunActAddress} ${volunActivity.volunActAddressDetail}
		        </span>
		    </p>
		
		    <div id="map" class="map-box"></div>
		</div>

    </div>

    <div class="content-section">
        <h3>상세내용</h3>
        <div class="content-box">
            ${volunActivity.volunActDetail}
        </div>
    </div>

    <div class="btn-group">
	    <c:choose>
	        <c:when test="${isApplied}">
	            <form action="${pageContext.request.contextPath}/volunteer-activity/apply.va" method="post">
	                <input type="hidden" name="volunActNo" value="${volunActivity.volunActNo}">
	                <button type="submit" class="c-button c-button--primary c-button--lg" disabled>신청완료</button>
	            </form>
	
	            <form action="${pageContext.request.contextPath}/volunteer-activity/cancel.va" method="post">
	                <input type="hidden" name="volunActNo" value="${volunActivity.volunActNo}">
	                <button type="submit" class="c-button c-button--primary c-button--lg">철회</button>
	            </form>
	        </c:when>
	        
            <c:when test="${userType == 2}">
                <form action="${pageContext.request.contextPath}/volunteer-activity/apply.va" method="post">
                    <input type="hidden" name="volunActNo" value="${volunActivity.volunActNo}">
                    <button type="submit" class="c-button c-button--primary c-button--lg" disabled>신청</button>
                </form>

                <form action="${pageContext.request.contextPath}/volunteer-activity/cancel.va" method="post">
                    <input type="hidden" name="volunActNo" value="${volunActivity.volunActNo}">
                    <button type="submit" class="c-button c-button--primary c-button--lg" disabled>철회</button>
                </form>
            </c:when>
            
	        <c:otherwise>
	            <form action="${pageContext.request.contextPath}/volunteer-activity/apply.va" method="post">
	                <input type="hidden" name="volunActNo" value="${volunActivity.volunActNo}">
	                <button type="submit" class="c-button c-button--primary c-button--lg">신청</button>
	            </form>
	
	            <form action="${pageContext.request.contextPath}/volunteer-activity/cancel.va" method="post">
	                <input type="hidden" name="volunActNo" value="${volunActivity.volunActNo}">
	                <button type="submit" class="c-button c-button--primary c-button--lg" disabled>철회</button>
	            </form>
	        </c:otherwise>
	    </c:choose>
	</div>

</div>

<jsp:include page="/app/include/footer.jsp" />

</body>
</html>