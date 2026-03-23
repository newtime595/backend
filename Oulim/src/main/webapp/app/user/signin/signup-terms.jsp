<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>회원가입 약관</title>

<!-- base css 필수 삽입-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/reset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/variable.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/Typography.css" />
<!-- 컨포넌트 css 선택-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/input.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/button.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/core/layout.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/component/checkbox.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/user/signin/signup-terms.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/header-login.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/asset/css/pages/main/footer.css" />
<script defer
	src="${pageContext.request.contextPath}/asset/js/pages/user/signin/signup-terms.js"></script>
</head>

<body>
	<jsp:include page="/app/include/header.jsp" />
	<div class="l-main">
		<div class="l-container">
			<div class="p-signup">
				<form id="signup-terms-form"
					action="${pageContext.request.contextPath}/app/user/signin/signup-verify.jsp"
					method="get" data-context-path="${pageContext.request.contextPath}">
					<input type="hidden" name="userType" id="user-type" value="1" />
					<div class="l-signup-main">
						<div>
							<h2>회원가입</h2>
						</div>
						<div class="l-signup-choice">
							<div class="is-general">
								<img
									src="${pageContext.request.contextPath}/asset/image/join/normal.png"
									alt="일반" />
								<div>
									<h6>일반</h6>
								</div>
							</div>
							<div class="is-business">
								<img
									src="${pageContext.request.contextPath}/asset/image/join/organ.png"
									alt="기업" />
								<div>
									<h6>기업</h6>
								</div>
							</div>
						</div>
						<div id="is-general-terms">
							<!-- 여기가 일반 -->
							<div class="l-signup-toplayout">
								<label class="c-checkbox"> <input type="checkbox"
									id="is-all-check" /> <span class="c-checkbox__box"></span>
									<h5>전체 이용약관 동의</h5>
								</label>
							</div>
							<div class="l-signup-toplayout">
								<label class="c-checkbox"> <input type="checkbox"
									class="is-agree-check" /> <span class="c-checkbox__box"></span>
									<h5>서비스 이용약관 동의(필수)</h5>
								</label>
							</div>
							<div class="c-signup-textarea"><p><strong>제1조 (목적)</strong></p>
<p>본 약관은 어울림(이하 "회사")이 제공하는 자원봉사 및 커뮤니티 서비스(이하 "서비스")의 이용과 관련하여 회사와 회원 간의 권리, 의무 및 책임사항을 규정함을 목적으로 합니다.</p>

<p><strong>제2조 (용어의 정의)</strong></p>
<p>1. "회원"이란 본 약관에 동의하고 회사가 제공하는 서비스를 이용하는 개인을 의미합니다.</p>
<p>2. "서비스"란 봉사활동 조회, 신청, 참여 기록 관리, 커뮤니티 기능 등 회사가 제공하는 모든 기능을 의미합니다.</p>
<p>3. "아이디(ID)"란 회원 식별과 서비스 이용을 위하여 회원이 설정한 문자 또는 숫자의 조합을 의미합니다.</p>
<p>4. "비밀번호"란 회원 계정 보호를 위하여 회원이 설정한 문자, 숫자, 특수문자의 조합을 의미합니다.</p>

<p><strong>제3조 (약관의 효력 및 변경)</strong></p>
<p>1. 본 약관은 회원가입 화면 또는 서비스 내에 게시함으로써 효력이 발생합니다.</p>
<p>2. 회사는 관련 법령을 위반하지 않는 범위에서 본 약관을 변경할 수 있으며, 변경된 약관은 적용일자 및 변경 사유와 함께 사전에 공지합니다.</p>
<p>3. 회원이 변경된 약관 시행일 이후에도 서비스를 계속 이용하는 경우, 변경된 약관에 동의한 것으로 봅니다.</p>

<p><strong>제4조 (서비스의 제공)</strong></p>
<p>회사는 회원에게 다음과 같은 서비스를 제공합니다.</p>
<p>1. 봉사활동 정보 조회 및 검색 기능</p>
<p>2. 봉사활동 신청 및 참여 기능</p>
<p>3. 회원 정보 관리 기능</p>
<p>4. 기타 회사가 정하는 부가 서비스</p>

<p><strong>제5조 (회원가입 및 계정관리)</strong></p>
<p>1. 회원은 가입 시 정확하고 최신의 정보를 입력해야 하며, 허위 정보를 기재해서는 안 됩니다.</p>
<p>2. 회원은 자신의 아이디와 비밀번호를 직접 관리할 책임이 있으며, 이를 제3자에게 양도하거나 대여할 수 없습니다.</p>
<p>3. 회원은 계정 도용 또는 보안상 문제가 발생한 경우 즉시 회사에 알려야 합니다.</p>

<p><strong>제6조 (회원의 의무)</strong></p>
<p>회원은 다음 각 호의 행위를 하여서는 안 됩니다.</p>
<p>1. 타인의 정보 도용 또는 허위 정보 입력 행위</p>
<p>2. 서비스 운영을 방해하거나 시스템에 비정상적으로 접근하는 행위</p>
<p>3. 타인의 권리 또는 명예를 침해하는 행위</p>
<p>4. 법령 및 공서양속에 반하는 행위</p>

<p><strong>제7조 (서비스 이용 제한)</strong></p>
<p>회사는 회원이 본 약관을 위반하거나 서비스의 정상적인 운영을 방해하는 경우 사전 통지 후 서비스 이용을 제한할 수 있습니다. 다만 긴급한 경우에는 사후 통지할 수 있습니다.</p>

<p><strong>제8조 (면책)</strong></p>
<p>회사는 천재지변, 시스템 장애, 통신망 문제 등 불가항력적인 사유로 인하여 서비스를 제공할 수 없는 경우 책임을 지지 않습니다.</p>
<p>회사는 회원의 귀책사유로 인하여 발생한 손해에 대하여 책임을 지지 않습니다.</p></div>
							<div class="l-signup-toplayout">
								<label class="c-checkbox"> <input type="checkbox"
									class="is-agree-check" /> <span class="c-checkbox__box"></span>
									<h5>개인정보 수집 및 이용 동의(필수)</h5>
								</label>
							</div>
							<div class="c-signup-textarea"><p><strong>1. 수집하는 개인정보 항목</strong></p>
<p>어울림은 회원가입 및 서비스 제공을 위하여 다음과 같은 개인정보를 수집합니다.</p>
<p>- 필수항목: 이름, 생년월일, 이메일, 아이디, 비밀번호</p>

<p><strong>2. 개인정보 수집 및 이용 목적</strong></p>
<p>회사는 수집한 개인정보를 다음의 목적을 위해 이용합니다.</p>
<p>1. 회원 식별 및 본인 확인</p>
<p>2. 회원가입 의사 확인 및 계정 관리</p>
<p>3. 서비스 제공 및 운영</p>
<p>4. 부정 이용 방지 및 보안 관리</p>
<p>5. 문의사항 처리 및 공지사항 전달</p>

<p><strong>3. 개인정보의 보유 및 이용 기간</strong></p>
<p>수집된 개인정보는 회원 탈퇴 시까지 보유 및 이용합니다.</p>
<p>다만, 관계 법령에 따라 일정 기간 보관이 필요한 경우 해당 법령에서 정한 기간 동안 보관될 수 있습니다.</p>

<p><strong>4. 동의 거부 권리 및 불이익</strong></p>
<p>회원은 개인정보 수집 및 이용에 대한 동의를 거부할 권리가 있습니다.</p>
<p>다만, 필수항목에 대한 동의를 거부할 경우 회원가입 및 서비스 이용이 제한될 수 있습니다.</p>

<p><strong>5. 개인정보 보호를 위한 조치</strong></p>
<p>회사는 회원의 개인정보를 안전하게 보호하기 위하여 관련 법령에 따른 기술적, 관리적 보호조치를 시행합니다.</p></div>
							<div class="l-signup-toplayout">
								<label class="c-checkbox"> <input type="checkbox"
									class="is-agree-check" /> <span class="c-checkbox__box"></span>
									<h5>이용약관 동의(필수)</h5>
								</label>
							</div>
							<div class="c-signup-textarea"><p><strong>1. 수집 및 이용 목적</strong></p>
<p>어울림은 회원에게 이벤트, 공지사항, 신규 서비스, 업데이트 소식 등 다양한 정보를 제공하기 위해 마케팅 정보를 발송할 수 있습니다.</p>

<p><strong>2. 수신 항목</strong></p>
<p>- 이메일을 통한 이벤트 및 서비스 안내</p>

<p><strong>3. 동의 여부</strong></p>
<p>회원은 마케팅 정보 수신에 동의하지 않아도 기본적인 서비스 이용이 가능합니다.</p>

<p><strong>4. 동의 철회</strong></p>
<p>회원은 언제든지 마케팅 정보 수신 동의를 철회할 수 있으며, 철회 이후에는 관련 안내가 발송되지 않습니다.</p></div>
							<div type="submit" class="c-signup-btn">
								<button class="c-button c-button--primary c-button--md"
									id="is-next-btn">다음</button>
							</div>
						</div>
						<div id="is-business-terms">
							<!-- 여기가 기업 -->
							<div class="l-signup-toplayout">
								<label class="c-checkbox"> <input type="checkbox"
									id="is-all-check-general" /> <span class="c-checkbox__box"></span>
									<h5>전체 이용약관 동의</h5>
								</label>
							</div>
							<div class="l-signup-toplayout">
								<label class="c-checkbox"> <input type="checkbox"
									class="is-agree-check-general" /> <span
									class="c-checkbox__box"></span>
									<h5>서비스 이용약관 동의(필수)</h5>
								</label>
							</div>
							<div class="c-signup-textarea"><p><strong>제1조 (목적)</strong></p>
<p>본 약관은 어울림(이하 "회사")이 제공하는 기관 회원 서비스를 이용함에 있어 회사와 기관 회원 간의 권리, 의무 및 책임사항을 규정함을 목적으로 합니다.</p>

<p><strong>제2조 (정의)</strong></p>
<p>1. "기관 회원"이란 회사의 승인을 받아 서비스에 가입한 기업, 기관 또는 단체를 의미합니다.</p>
<p>2. "서비스"란 봉사활동 등록, 관리, 참여자 모집, 기관 정보 관리 등 회사가 기관 회원에게 제공하는 기능을 의미합니다.</p>

<p><strong>제3조 (서비스 제공)</strong></p>
<p>회사는 기관 회원에게 다음과 같은 서비스를 제공합니다.</p>
<p>1. 봉사활동 등록 및 수정 기능</p>
<p>2. 모집 인원 및 활동 정보 관리 기능</p>
<p>3. 기관 정보 관리 기능</p>
<p>4. 기타 회사가 정하는 기관 전용 부가 기능</p>

<p><strong>제4조 (기관 회원의 의무)</strong></p>
<p>기관 회원은 정확한 기관 정보 및 담당자 정보를 제공하여야 하며, 허위 또는 부정확한 정보를 기재해서는 안 됩니다.</p>
<p>기관 회원은 등록하는 봉사활동 정보의 내용, 일정, 장소, 모집 내용 등에 대해 책임을 집니다.</p>
<p>기관 회원은 이용자에게 피해를 주거나 서비스의 신뢰를 훼손하는 행위를 하여서는 안 됩니다.</p>

<p><strong>제5조 (서비스 이용 제한)</strong></p>
<p>회사는 기관 회원이 본 약관을 위반하거나 허위 정보를 등록한 경우, 기관 회원 자격을 제한하거나 서비스 이용을 중단시킬 수 있습니다.</p>

<p><strong>제6조 (책임의 제한)</strong></p>
<p>회사는 기관 회원이 등록한 정보의 정확성, 적법성, 신뢰성에 대해 보증하지 않으며, 기관 회원의 귀책사유로 발생한 분쟁에 대해서는 책임을 지지 않습니다.</p></div>
							<div class="l-signup-toplayout">
								<label class="c-checkbox"> <input type="checkbox"
									class="is-agree-check-general" /> <span
									class="c-checkbox__box"></span>
									<h5>개인정보 수집 및 이용 동의(필수)</h5>
								</label>
							</div>
							<div class="c-signup-textarea"><p><strong>1. 수집하는 개인정보 항목</strong></p>
<p>어울림은 기관 회원 가입 및 서비스 제공을 위하여 다음과 같은 개인정보를 수집합니다.</p>
<p>- 필수항목: 담당자 이름, 생년월일, 이메일, 아이디, 비밀번호, 기관명, 기관 인증번호</p>

<p><strong>2. 개인정보 수집 및 이용 목적</strong></p>
<p>회사는 수집한 개인정보를 다음의 목적으로 이용합니다.</p>
<p>1. 기관 회원 식별 및 담당자 본인 확인</p>
<p>2. 기관 회원 가입 및 승인 처리</p>
<p>3. 봉사활동 등록, 운영 및 관리</p>
<p>4. 문의사항 처리 및 공지 전달</p>
<p>5. 서비스 부정 이용 방지 및 보안 관리</p>

<p><strong>3. 개인정보의 보유 및 이용 기간</strong></p>
<p>수집된 개인정보는 회원 탈퇴 시까지 보유 및 이용합니다.</p>
<p>다만 관계 법령에 따라 보관 의무가 있는 경우 해당 기간 동안 보관할 수 있습니다.</p>

<p><strong>4. 동의 거부 권리 및 불이익</strong></p>
<p>기관 회원은 개인정보 수집 및 이용에 대한 동의를 거부할 권리가 있습니다.</p>
<p>다만, 필수정보 제공에 동의하지 않을 경우 기관 회원 가입 및 서비스 이용이 제한될 수 있습니다.</p>

<p><strong>5. 보호조치</strong></p>
<p>회사는 개인정보 보호 관련 법령에 따라 개인정보를 안전하게 관리하며, 유출 및 훼손 방지를 위해 필요한 조치를 시행합니다.</p></div>
							<div class="l-signup-toplayout">
								<label class="c-checkbox"> <input type="checkbox"
									class="is-agree-check-general" /> <span
									class="c-checkbox__box"></span>
									<h5>이용약관 동의 (필수)</h5>
								</label>
							</div>
							<div class="c-signup-textarea"><p><strong>1. 수집 항목</strong></p>
<p>어울림은 기관 회원 확인을 위하여 기관명, 기관 인증번호 및 제출된 증빙서류(PDF 파일 등)를 수집할 수 있습니다.</p>

<p><strong>2. 수집 및 이용 목적</strong></p>
<p>수집된 정보와 서류는 다음의 목적을 위해 이용됩니다.</p>
<p>1. 기관의 실체 및 자격 확인</p>
<p>2. 기관 회원 승인 절차 진행</p>
<p>3. 허위 가입 및 부정 이용 방지</p>

<p><strong>3. 보유 및 이용 기간</strong></p>
<p>제출된 증빙서류는 기관 인증 및 검토 절차를 위해 필요한 기간 동안 보관되며, 목적 달성 후 관련 법령에 따라 안전하게 파기됩니다.</p>

<p><strong>4. 제출 자료의 정확성</strong></p>
<p>기관 회원은 제출하는 모든 정보와 서류가 진실하고 정확함을 보장하여야 합니다.</p>
<p>허위 자료 제출이 확인될 경우 가입이 거절되거나 서비스 이용이 제한될 수 있습니다.</p>

<p><strong>5. 유의사항</strong></p>
<p>증빙서류는 기관 회원 승인 및 관리 목적 외 다른 용도로 사용되지 않으며, 회사는 이를 안전하게 보호하기 위하여 합리적인 관리조치를 시행합니다.</p></div>
							<div class="c-signup-btn">
								<button type="submit"
									class="c-button c-button--primary c-button--md"
									id="is-next-btn-general">다음</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<jsp:include page="/app/include/footer.jsp" />
</body>
</html>
