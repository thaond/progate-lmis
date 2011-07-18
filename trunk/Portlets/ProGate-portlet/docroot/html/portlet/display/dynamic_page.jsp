<%@ include file="../common/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<% 

String name = ProGateUtil.getConfigValue(renderRequest, ConfigParams_RS.NAME);
name = "Test";
String image = ProGateUtil.getConfigValue(renderRequest, 
					ConfigParams_RS.IMAGE, "/ProGate-portlet/images/organization_management.png"); 

image = "/ProGate-portlet/images/organization_management.png";

String dynamicMenuURL =	ProGateUtil.buildUrl(
								ProGateUtil.getConfigValue(renderRequest, ConfigParams_RS.REDIRECT_URL),
								null, null );

%>

<style type="text/css">
.left-panel {
	float: left;
}

.left-panel .nav-menu {
	padding: 5px;
	height: 490px;
	padding: 45px 0 100px 45px;
	width: 255px;
	background-color: #30A1BE;
	-moz-border-radius: 5px 5px 5px 5px;
}

.right-panel ul {
	list-style: none;
}

.right-panel .cell {
	padding: 45px 0 0 45px;
	width: 160px;
	text-align: center;
}

.right-panel .cell a {
	text-decoration: none;
}

.right-panel .cell img {
	width: 160px;
	height: 120px;
}
</style>

<portlet:renderURL windowState="<%=WindowState.MAXIMIZED.toString() %>" var="addProductURL">
				    <portlet:param name="action" value="addProduct" />				    
				</portlet:renderURL>

<div class="right-panel">
	<c:forEach begin="1" end="3">
	<c:forEach begin="1" end="3" varStatus="count">
		<ul>
			<li>
			<div class="cell">
			<div class="name"><a href="<%=dynamicMenuURL %>"> <img
				alt="<%=name %>" src="<%=image %>" title="<%=name %>" /> </a></div>

			<div style="padding-top: 7px;"><a href="${addProductURL}">
			<font color="blue"><%=name %></font> </a></div>
			</div>
			</li>
		</ul>
	</c:forEach>
	</c:forEach>
</div>



