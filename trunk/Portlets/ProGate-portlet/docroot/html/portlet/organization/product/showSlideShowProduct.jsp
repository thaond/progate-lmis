<%@ include file="../../common/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="larion.progate.model.ProGateJournalArticle"%>
<%@ page
	import="larion.progate.service.ProGateJournalArticleLocalServiceUtil"%>
<%@ page
	import="larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.LinkedList"%>

<style type="text/css">
.ui-tabs { /*border-bottom: 1px solid #30A1BE;*/
	margin: 0px;
	padding: 0px;
}

.ui-tabs li.current:hover,.ui-tabs li.current a:hover {
	color: #000000;
}

.ui-tabs li.current a,.ui-tabs li.current span {
	color: #000000;
	font-weight: normal;
	border-color: #30A1BE #30A1BE -moz-use-text-color;
}

.ui-tabs li a,.tabs li span {
	background:
		url("/ProGate-Theme-theme/images/ui/ui-bg_glass_85_dfeffc_1x400.png")
		repeat-x scroll 50% 50% #DFEFFC;
	color: #000000;
	border-color: #30A1BE #30A1BE -moz-use-text-color;
	border-right: none;
}

.ui-tabs li a:hover {
	text-decoration: none;
}

.ui-tabs li a:hover,.ui-tabs li span:hover {
	background:
		url("/ProGate-Theme-theme/images/ui/ui-bg_glass_75_d0e5f5_1x400.png")
		repeat-x scroll 50% 50% #D0E5F5;
	color: #9EBAC8;
}

#myTabs {
	width: 100%;
}

.slideShowHeader {
	width: 312px;
	-moz-border-radius: 5px 5px 0 0;
	background-color: #30A1BE;
	height: 30px;
}

.slideShowHeader .slideShowTitle {
	color: white;
	font-size: 14px;
	font-weight: bold;
	padding: 7px;
	width: 300px;
}

#featured { /*position: relative;
	border:5px solid #ccc;
	border-bottom: 0 none;*/
	background: #ffffff;
}

#featured ul.ui-tabs-nav {
	background:
		url("/ProGate-Theme-theme/images/ui/ui-bg_glass_85_dfeffc_1x400.png")
		repeat-x scroll 50% 50% #DFEFFC;
	height: 20px;
	list-style: none outside none;
	margin: 0;
	padding: 0;
}

#featured ul.ui-tabs-nav li {
	padding: 3px 0 1px 13px;
}

#featured ul.ui-tabs-nav li span {
	font-size: 11px;
	font-family: Verdana;
	line-height: 18px;
}

#featured .ui-tabs-panel {
	height: 210px;
	/*background: #30A1BE;*/
	position: relative;
	overflow: hidden;
}

#featured .ui-tabs-hide {
	display: none;
}

#featured li.ui-tabs-nav-item a {
	background: none repeat scroll 0 0 #D0E5F5;
	color: #333333;
	display: block;
	outline: medium none;
	padding: 0 5px;
	text-decoration: none;
	border-right: 0 none;
}

#featured li.ui-tabs-nav-item a:hover {
	background: #f2f2f2;
}

#featured li.ui-tabs-selected {
	background: url('images/selected-item.gif') top left no-repeat;
}

#featured ul.ui-tabs-nav li.ui-tabs-selected a {
	background: #ccc;
}

#featured ul.ui-tabs-nav li img {
	float: left;
	margin: 2px 5px;
	background: #fff;
	padding: 2px;
	border: 1px solid #eee;
}

.ui-tabs-panel {
	height: 280px;
}

#featured .ui-tabs-panel .info {
	position: absolute;
	top: 175px;
	left: 0;
	height: 70px;
	width: 312px;
}

#featured .info h2 {
	font-size: 18px;
	padding: 5px;
	margin: 0;
	overflow: hidden;
}

#featured .info p {
	margin: 0 5px;
	font-size: 11px;
	line-height: 15px;
	color: #f0f0f0;
}

#featured .info a {
	text-decoration: none;
	color: #000000;
}

#featured .info a:hover {
	text-decoration: underline;
}

#featured div.ui-tabs-panel img {
	height: 170px;
	padding: 5px;
	width: 302px;
}
	
.slideShow-content-link  {
	text-decoration: none;	
	color: white;
	margin-left :175px;
	font-size: 13px;
	font: 13px Arial,Helvetica,Verdana,sans-serif;
}

</style>

<script type="text/javascript">
	jQuery(document).ready(function() {

		jQuery("#featured").tabs({
			fx : {
				opacity : "toggle"
			}
		}).tabs("rotate", 10000, true);

		/*jQuery("#myTabs").tabs();
		
		jQuery("#featured").hover(  
		    function() {  
		    	jQuery("#featured").tabs("rotate",0,true);  
		    },  
		    function() {  
		    	jQuery("#featured").tabs("rotate",10000,true);  
		    }  
		);  
		 */
	});
</script>
<c:choose>
	<c:when test="${bean.slideShowCount == 0 && bean.viewMode == 0}">
	</c:when>
	<c:otherwise>
		<div class="org-profile-layout-column-211">
			<div class="tnt-slide-show-product" style="height: 260px; border-width: medium 1px 1px;border-left:1px solid #30A1BE;
			     border-right:1px solid #30A1BE;border-bottom:1px solid #30A1BE;-moz-border-radius: 0pt 0pt 5px 5px;">
                <div class="slideShowHeader">
					<div class="slideShowTitle">
						<span><fmt:message key="title.product" /> </span>
						<c:if test="${isOrgAdmin}">
						<c:choose>
						<c:when test="${bean.viewMode == 1 && bean.slideShowCount == 0 }">
						   <portlet:renderURL windowState="<%=WindowState.MAXIMIZED.toString() %>"
							     var="addSlideShowProductURL">
							<portlet:param name="action"
						         value="handleSlideShowProduct" />
							<portlet:param name="<%=URLParameter_RS.ORG_ID %>"
								 value="${bean.orgId}" />
							<portlet:param name="<%=URLParameter_RS.VIEW_MODE %>"
								 value="${bean.viewMode}" />
							<portlet:param name="<%=Constants.CMD%>"
								 value="<%=Constants.ADD%>" />
							<portlet:param name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL %>"
								 value='<%=PortalUtil.getCurrentURL(renderRequest) %>' />
							</portlet:renderURL>
						    <a class="slideShow-content-link"  href="${addSlideShowProductURL}">
						    <fmt:message key="add" /></a>
				       </c:when>
				       </c:choose>
				     </c:if>
				</div>
				</div>
				<div>
				<div id="0">
					<div id="featured" style="padding: 10px;" ">
						<c:choose>
							<c:when test="${bean.slideShowCount > 0 }">
								<c:forEach items="${bean.slideShowList}" var="slideShow"
									varStatus="count">
									<div id="fragment-${count.count}" class="ui-tabs-panel" style="text-align: justify; color: rgb(166, 166, 166);">                                   
									<img alt="" onLoad='scaleImg(this, 250, 150)' src='<c:out value="${slideShow.imageUrl}"></c:out>' >										
										<div class="info">
											<h2>
												<a href="${bean.productDetailLink}${slideShow.productId}">
													<c:out value="${slideShow.title}"></c:out> </a>
											</h2>
										</div>
									</div>
								</c:forEach>
								
								<c:if test="${bean.isOrgAdmin}">
									<div style="float: right; padding: 3px 5px 3px 3px;">
										<span> <c:choose>
												<c:when test="${bean.slideShowCount > 0 }">
													<portlet:renderURL
														windowState="<%=WindowState.MAXIMIZED.toString() %>"
														var="updateSlideShowProductURL">
														<portlet:param name="action"
															value="handleSlideShowProduct" />
														<portlet:param name="<%=URLParameter_RS.ORG_ID %>"
															value="${bean.orgId}" />
														<portlet:param name="<%=URLParameter_RS.VIEW_MODE %>"
															value="${bean.viewMode}" />
														<portlet:param name="<%=Constants.CMD%>"
															value="<%=Constants.UPDATE%>" />
														<portlet:param
															name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL %>"
															value='<%=PortalUtil.getCurrentURL(renderRequest) %>' />
													</portlet:renderURL>

													<a href="${updateSlideShowProductURL}" class="tnt-link">
														<fmt:message key="button.update" /> </a>
												</c:when>

												<c:otherwise>
													<portlet:renderURL
														windowState="<%=WindowState.MAXIMIZED.toString() %>"
														var="addSlideShowProductURL">
														<portlet:param name="action"
															value="handleSlideShowProduct" />
														<portlet:param name="<%=URLParameter_RS.ORG_ID %>"
															value="${bean.orgId}" />
														<portlet:param name="<%=URLParameter_RS.VIEW_MODE %>"
															value="${bean.viewMode}" />
														<portlet:param name="<%=Constants.CMD%>"
															value="<%=Constants.ADD%>" />
														<portlet:param
															name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL %>"
															value='<%=PortalUtil.getCurrentURL(renderRequest) %>' />
													</portlet:renderURL>

													<a href="${addSlideShowProductURL}" class="tnt-link"> +
														<fmt:message key="button.add" /> </a>
												</c:otherwise>
											</c:choose> </span>
									</div>
								</c:if>
								<ul class="ui-tabs-nav">
									<c:forEach items="${bean.slideShowList}" var="slideShow"
										varStatus="count">
										<li class="ui-tabs-nav-item "
											id="nav-fragment-${count.count }"><a
											href="#fragment-${count.count }"><c:out
													value="${count.count}"></c:out> </a>
										</li>								
									</c:forEach>
								</ul>
							</c:when>
							<c:otherwise>
								<div class="ui-tabs-panel"
									style="text-align: justify; color: rgb(166, 166, 166);">
									<fmt:message key="warning.slideshow.product.add" />
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
            </div>
			</div>
		</div>
	</c:otherwise>
</c:choose>




