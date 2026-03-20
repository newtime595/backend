<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<div class="p-header-page">
		<div class="l-header-layout">
			<c:choose>
				<c:when test="${empty sessionScope.userNo}">
					<div class="l-header-right">
						<a href="/"><img src="${pageContext.request.contextPath}/asset/image/logo/logo.png" alt="logo" class="logoimgs" /></a>
						<div>
							<a href="${pageContext.request.contextPath}/volunteer-activity/list.va">봉사활동</a>
						</div>
						<div>
							<a href="${pageContext.request.contextPath}/community/list.commu">어울림터</a>
						</div>
					</div>
					<div class="l-header-left">
						<div >
							<a class="c-button c-button--secondary c-button--md" href="${pageContext.request.contextPath}/user/login.usr">로그인/회원가입</a>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="l-header-right">
						<a href="/"><img src="${pageContext.request.contextPath}/asset/image/logo/logo.png" alt="logo" class="logoimgs" /></a>
						<div>
							<a href="${pageContext.request.contextPath}/volunteer-activity/list.va">봉사활동</a>
						</div>
						<div>
							<a href="${pageContext.request.contextPath}/community/list.commu">어울림터</a>
						</div>
						
						<c:if test="${sessionScope.userType== 1}">
							<div>
								<a href="${pageContext.request.contextPath}/kkomi/info.kko">꼬미수련소</a>
							</div>
						</c:if>

						<c:if test="${sessionScope.userType== 2}">
							<div>
								<a href="${pageContext.request.contextPath}/volunteer-manage/list.vm">봉사관리</a>
							</div>
						</c:if>
						
					</div>
					<div class="l-header-left">
						<div>
							<h4>${sessionScope.userType == 1 ? sessionScope.userNickname : sessionScope.organName} 님</h4>
						</div>
						<div>
						<a class="c-button c-button--secondary c-button--md" href="${pageContext.request.contextPath}/mypage/check.mp">마이페이지</a>
						</div>
						<div>
						<a class="c-button c-button--secondary c-button--md" href="${pageContext.request.contextPath}/user/logout.usr">로그아웃</a>
						</div>
						
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</header>

