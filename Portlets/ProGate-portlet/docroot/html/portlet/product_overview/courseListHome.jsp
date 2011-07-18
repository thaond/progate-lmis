<%@ include file="../common/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<style type="text/css">
   <%@ include file="/css/course_view/course.css" %>
</style>

<script type="text/javascript" src="/ProGate-portlet/js/util.js"></script>
<script type="text/javascript" src="/ProGate-portlet/js/scaleImg.js"></script>

<script type="text/javascript">
	function viewProduct(url) {
		window.location = url;
	}
	
</script>

<fmt:setLocale value="vi_VN" scope="session"/>
<c:set value="<%= PortalUtil.getPortalURL(request) %>" var="homeUrl" />
<c:set value="<%= URLParameter_RS.PRODUCT_ID %>" var="productId" />
<div class="courseView-layout">
	<div class="courseView-header">
		<div class="courseView-header-title">			
			<c:set value="${homeUrl}/${bean.friendlyUrl}" var="redirectUrl" />
			<a href="${redirectUrl}" class="courseView-header-content">
				<c:choose>
					<c:when test="${bean.displayStyle == bean.examHomeView}">
						<fmt:message key="title.exam" />
					</c:when>				
					<c:otherwise>
						<fmt:message key="title.course" />
					</c:otherwise>
				</c:choose>
			</a>
		</div>
	</div>
	<div class="courseView-body">
		<div class="courseView-content">
			<c:forEach items="${bean.productList}" var="product" >				
				<c:set value="${homeUrl}/${bean.friendlyUrl}?${productId}=${product.journalArticleId}" var="detailUrl" />
				<c:choose>
					<c:when test="${product.currencyCode == 'VND'}">
						<c:set value="0" var="maxFraction" />
					</c:when>
					<c:otherwise>
						<c:set value="2" var="maxFraction" />
					</c:otherwise>
				</c:choose>
				<div class="courseView-row-hover">
					<div class="courseView-row">
						<div class="courseView-row-image">
							<div style="float:left; padding: 2px; width: 70px; height: 60px; border: thin ridge rgb(224, 237, 244)">
								<a href="${detailUrl}">
									<c:choose>								
										<c:when test="${product.smallImageUrl == null || product.smallImageUrl == ''}">									
											<img class="courseImage" src='<%=request.getContextPath()%>/images/new-manage-org/small_noImage.gif' alt=""/>
																		
										</c:when>
										<c:otherwise>
											<img class="courseImage" src='<c:out value="${product.smallImageUrl}"></c:out>' onLoad='scaleImg(this, 70, 60)' alt="" style="display: none;"/>											
										</c:otherwise>
									</c:choose>						
								</a>
							</div>
						</div>
						<div class="courseView-row-text">	   
							<a class="courseView-row-link" href="${detailUrl}">
								<c:out value="${product.title}"></c:out>
							</a>
							<br />
							<span>
								<c:choose>
									<c:when test="${fn:length(product.description) > 105}">
										<c:set value="${fn:substring(product.description, 90, 105)}" var="strTemp" />
										<c:set value="${fn:indexOf(strTemp, ' ')}" var="iTemp" />
										<c:out value="${fn:substring(product.description, 0, 90 + iTemp)}..." escapeXml="false"></c:out>
									</c:when>				
									<c:otherwise>
										<c:out value="${product.description}" escapeXml="false"></c:out>
									</c:otherwise>
								</c:choose>
							</span>	    
						</div>
						<div class="courseView-row-center">
							<span>
								<fmt:message key="title.course.price" />
							</span>
							<span style="font-weight: bold;">
								<fmt:formatNumber value="${product.price - product.price * product.discount / 100}" 
								maxFractionDigits="${maxFraction}" minFractionDigits="${maxFraction}"/>
							</span>
							<span>
								<c:out value="${product.currencyCode}"></c:out>
							</span>
						</div>	  
						<div style="clear: both;"></div>
					</div>
				</div>
				<div class="courseView-row-line"></div>
			</c:forEach>
		</div>
	</div>
</div>

