<%@ include file="../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<style type="text/css">
.ui-tabs {
	border-bottom: 1px solid #30A1BE;
	margin: 0px;
	padding: 0px;
}

.ui-tabs li.current:hover, .ui-tabs li.current a:hover {
	color: #000000;
}

.ui-tabs li.current a,.ui-tabs li.current span {
	color: #000000;
	font-weight: normal;
	border-color: #30A1BE #30A1BE -moz-use-text-color;
}

.ui-tabs li a,.tabs li span {
	background: url("/ProGate-Theme-theme/images/ui/ui-bg_glass_85_dfeffc_1x400.png") repeat-x scroll 50% 50% #DFEFFC;
	color: #000000;
	border-color: #30A1BE #30A1BE -moz-use-text-color;
	border-right: none;
}

.ui-tabs li a:hover {
	text-decoration: none;
}

.ui-tabs li a:hover,.ui-tabs li span:hover {
	background: url("/ProGate-Theme-theme/images/ui/ui-bg_glass_75_d0e5f5_1x400.png") repeat-x scroll 50% 50% #D0E5F5;
	color: #9EBAC8;
}

#myTabs {
	width: 100%;
}

#featured { /*padding-right:250px;*/
	position: relative;
	padding: 5px;
	background: #fff;
	/*border:5px solid #ccc;*/
	border-bottom: 0 none;
	background: #fff;
}

#featured ul.ui-tabs-nav {
	background: url("/ProGate-Theme-theme/images/ui/ui-bg_glass_85_dfeffc_1x400.png") repeat-x scroll 50% 50% #DFEFFC;
    border: 1px solid #30A1BE;
    height: 20px;
    list-style: none outside none;
    margin: 0;
    padding: 0;
    position: absolute;
    top: 253px;
    width: 298px;
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
	width: 298px;
	height: 248px;
	background: #30A1BE;
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
	/*width: 308px;*/
	border: 1px solid #30A1BE;
	border-top: 0 none;
}

#featured .ui-tabs-panel .info {
	position: absolute;
	top: 180px;
	left: 0;
	height: 70px;
	width: 300px;
	background: url('images/transparent-bg.png');
}

#featured .info h2 {
	font-size: 18px;
	font-family: Georgia, serif;
	color: #fff;
	padding: 5px;
	margin: 0;
	overflow: hidden;
}

#featured .info p {
	margin: 0 5px;
	font-family: Verdana;
	font-size: 11px;
	line-height: 15px;
	color: #f0f0f0;
}

#featured .info a {
	text-decoration: none;
	color: #fff;
}

#featured .info a:hover {
	text-decoration: underline;
}

#featured div.ui-tabs-panel img {
	height: 170px;
	padding: 5px;
	width: 290px;
}
</style>

<script type="text/javascript">
	jQuery(document).ready(function() {

		jQuery("#myTabs").tabs();
		
		jQuery("#featured").tabs({fx:{opacity: "toggle"}}).tabs("rotate", 10000, true);		
		/*
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
<div class="tnt-slide-show-product">

<ul id="myTabs">
<li><a href="#0"><fmt:message key="title.product" /></a></li>
<li><a href="#1"><fmt:message key="title.service" /></a></li>
</ul>

<c:if test="${bean.isOrgAdmin == true }">
<div style="float: right; margin-top: -25px;">
	<span>
		<c:choose>
		<c:when test="${bean.slideShowCount > 0 }">
			<portlet:renderURL windowState="<%=WindowState.MAXIMIZED.toString() %>" var="updateSlideShowProductURL">
			    <portlet:param name="action" value="updateSlideShowProduct" />
			    <portlet:param name="<%=URLParameter_RS.ORG_ID %>" value="${bean.orgId}"/>
			    <portlet:param name="<%=URLParameter_RS.VIEW_MODE %>" value="${bean.viewMode}"/>
			</portlet:renderURL>
			
			<a href="${updateSlideShowProductURL}" class="tnt-link">
			<fmt:message key="button.update" />
			</a>
		</c:when>
		<c:otherwise>
			<portlet:renderURL windowState="<%=WindowState.MAXIMIZED.toString() %>" var="addSlideShowProductURL">
			    <portlet:param name="action" value="addSlideShowProduct" />	   
			    <portlet:param name="<%=URLParameter_RS.ORG_ID %>" value="${bean.orgId}"/>
			    <portlet:param name="<%=URLParameter_RS.VIEW_MODE %>" value="${bean.viewMode}"/>
			</portlet:renderURL>
			
			<a href="${addSlideShowProductURL}" class="tnt-link">
			+ <fmt:message key="button.add" />
			</a>
		</c:otherwise>
		</c:choose>
	</span>
</div>
</c:if>

<div id="0">
<c:choose>
	<c:when test="${bean.slideShowCount > 0 }">
		<div id="featured">
		    <ul class="ui-tabs-nav">
		    	 <c:forEach items="${bean.slideShowList}" var="slideShow" varStatus="count">
		        <li class="ui-tabs-nav-item " id="nav-fragment-${count.count }">
		        	<a href="#fragment-${count.count }"><c:out value="${count.count}"></c:out></a>
		        </li>
		        <!-- <li class="ui-tabs-nav-item" id="nav-fragment-2"><a href="#fragment-2">2</a></li>
		        <li class="ui-tabs-nav-item" id="nav-fragment-3"><a href="#fragment-3">3</a></li>
		        <li class="ui-tabs-nav-item" id="nav-fragment-4"><a href="#fragment-4">4</a></li> -->
		        </c:forEach>
		    </ul>
		    <c:forEach items="${bean.slideShowList}" var="slideShow" varStatus="count">
		    <div id="fragment-${count.count}" class="ui-tabs-panel" style="">
		        <img src="<c:out value="${slideShow.imageUrl}"></c:out>" alt="" />
		        
		        <div class="info">
			        <h2>
			        <a href="<%=PortalUtil.getPortalURL(request) %>/${bean.productDetailPageUrl}?
								<%=URLParameter_RS.ORG_ID %>=${bean.orgId}&
								<%=URLParameter_RS.VIEW_MODE %>=${bean.viewMode}&
								<%=URLParameter_RS.PRODUCT_ID %>=${slideShow.productId}">
								<c:out value="${slideShow.title}"></c:out>
					</a>
			        </h2>
			        <p></p>  
		        </div>
		    </div>
		    </c:forEach>
		</div>
	</c:when>
	
	<c:otherwise>
	<div style="font-style: italic; text-align: justify;">
	<fmt:message key="warning.slideshow.product.add" />
	</div>	
	</c:otherwise>
</c:choose>

</div>

<div id="1"></div>

</div>
</div>
</c:otherwise>
</c:choose>




