<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<div id="loading" class="cds-loading">
		<img src="/ProGate-portlet/images/cds/ajax-loader.gif"/>
</div>
<script>
	<%@ include file="/js/cds/validate.js" %>
</script>
<%-- <c:choose>
<c:when test="${bean.isBOD == true}">
	<script>
		jQuery("#loading").show();
		location.href='${bean.linkToApprovalScreen}';
	</script>
</c:when>
<c:otherwise> --%>
<div class="cds-container">
	<div class="left padding-top padding-bottom" style="font-size: 1.1em; color: #E46C0A">
		<img class="absmiddle" src="/ProGate-portlet/images/cds/evaluate.png"
			width="40px" height="40px" />
		<strong>Đánh Giá CDS</strong>
	</div>
	<div class="clear"></div>
		<c:choose>
		<c:when test="${bean.hasPermission == false}">
				<div class="border-radius" style="min-height: 485px; margin-bottom: 20px;">
					<div class="cds-notification">Rất tiếc! Bạn không có quyền truy cập vào liên kết này.<br/>
						Vui lòng nhấp <a href="#">vào đây</a> để trở lại trang chủ.
					</div>
				</div>	
		</c:when>
		<c:otherwise>
			<jsp:include page="/html/portlet/cds/evaluation/evaluationTabs.jsp"></jsp:include>
		
			<c:choose>
					<c:when test="${bean.activedTab == bean.TAB_EVALUATION_1}">
						<jsp:include page="/html/portlet/cds/evaluation/currentResult.jsp"></jsp:include>
					</c:when>
		
					<c:when test="${bean.activedTab == bean.TAB_EVALUATION_2}">
						<jsp:include page="/html/portlet/cds/evaluation/prepare.jsp"></jsp:include>
					</c:when>
					
					<c:when test="${bean.activedTab == bean.TAB_EVALUATION_3}">
						<jsp:include page="/html/portlet/cds/evaluation/evaluateSlot.jsp"></jsp:include>
					</c:when>
			</c:choose>
		</c:otherwise>
		</c:choose>
</div>
<%-- </c:otherwise>
</c:choose> --%>
