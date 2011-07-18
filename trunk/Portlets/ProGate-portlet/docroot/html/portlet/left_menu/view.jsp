<%@page import="com.larion.progate.leftMenu.constants.LeftMenu_Const"%>
<%@ include file="../common/init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style type="text/css">
.left-menu-child-common a:hover {
	color: #F88017;
}

.left-menu-content:hover {
	color: yellow;
}

</style>

<%
	boolean isAdmin = false;
	int userType = -1; 
	boolean isMyHomePage = false;
	boolean isListOrgPage = false;
	
	if(request.getAttribute(LeftMenu_Const.IS_ADMIN) != null){
		isAdmin = (Boolean)(request.getAttribute(LeftMenu_Const.IS_ADMIN));
	}
	if(request.getAttribute(LeftMenu_Const.USER_TYPE) != null){
		userType = (Integer)(request.getAttribute(LeftMenu_Const.USER_TYPE));
	}
	if(request.getAttribute(LeftMenu_Const.IS_LIST_ORG_PAGE) != null){
		isListOrgPage = (Boolean)(request.getAttribute(LeftMenu_Const.IS_LIST_ORG_PAGE));
	}
	
	String homeUrl= PortalUtil.getPortalURL(request);
	String urlTransaction = ProGateUtil.buildUrl(homeUrl + StringPool.SLASH + LeftMenu_Const.TRANSACTION_MANAGEMENT, 
			new String[] {LeftMenu_Const.USER_TYPE}, new String[] {"0"});
	String urlSupport = ProGateUtil.buildUrl(homeUrl + StringPool.SLASH + LeftMenu_Const.SUPPORT_MANAGEMENT, 
			new String[] {LeftMenu_Const.USER_TYPE}, new String[] {"1"});
	String urlContact = ProGateUtil.buildUrl(homeUrl + StringPool.SLASH + LeftMenu_Const.CONTACT_MANAGEMENT, 
			new String[] {LeftMenu_Const.USER_TYPE}, new String[] {"2"});
	
	String url_TC_Admin = ProGateUtil.buildUrl(homeUrl + StringPool.SLASH + LeftMenu_Const.LIST_ORG_PAGE, 
			new String[] {LeftMenu_Const.USER_TYPE}, new String[] {"0"});
	String url_TC_Member = ProGateUtil.buildUrl(homeUrl + StringPool.SLASH + LeftMenu_Const.LIST_ORG_PAGE, 
			new String[] {LeftMenu_Const.USER_TYPE}, new String[] {"1"});
	String url_TC_Other = ProGateUtil.buildUrl(homeUrl + StringPool.SLASH + LeftMenu_Const.LIST_ORG_PAGE, 
			new String[] {LeftMenu_Const.USER_TYPE}, new String[] {"2"});
	String url_TC_Wait_Admin = ProGateUtil.buildUrl(homeUrl + StringPool.SLASH + LeftMenu_Const.LIST_ORG_PAGE, 
			new String[] {LeftMenu_Const.USER_TYPE}, new String[] {"3"});
	String url_TC_Invite_Join = ProGateUtil.buildUrl(homeUrl + StringPool.SLASH + LeftMenu_Const.LIST_ORG_PAGE, 
			new String[] {LeftMenu_Const.USER_TYPE}, new String[] {"4"});
	
	String url_SP_Buyer = ProGateUtil.buildUrl(homeUrl + StringPool.SLASH + LeftMenu_Const.SP_BUYER, 
			new String[] {LeftMenu_Const.USER_TYPE}, new String[] {"2"});
	String url_SP_Supplier = ProGateUtil.buildUrl(homeUrl + StringPool.SLASH + LeftMenu_Const.SP_SUPPLIER, 
			new String[] {LeftMenu_Const.USER_TYPE}, new String[] {"2"});
	String url_SP_Other = ProGateUtil.buildUrl(homeUrl + StringPool.SLASH + LeftMenu_Const.SP_OTHER, 
			new String[] {LeftMenu_Const.USER_TYPE}, new String[] {"2"});
	
	String urlMailBox = ProGateUtil.buildUrl(homeUrl + StringPool.SLASH + LeftMenu_Const.MAIL_BOX, 
			new String[] {LeftMenu_Const.USER_TYPE}, new String[] {"2"});
	String urlForum = ProGateUtil.buildUrl(homeUrl + StringPool.SLASH + LeftMenu_Const.FORUM, 
			new String[] {LeftMenu_Const.USER_TYPE}, new String[] {"2"});
	
	
	String forcusAdmin = "left-menu-content";
	String forcusMember = "left-menu-content";
	String forcusOther = "left-menu-content";
	String forcusWaitAdmin = "left-menu-content";
	String forcusInviteJoin = "left-menu-content";
	if(isListOrgPage){
		if(userType == 1){
			forcusMember = "left-menu-content-yel";
		}
		else if(userType == 2){
			forcusOther = "left-menu-content-yel";
		}
		else if(userType == 3){
			forcusWaitAdmin = "left-menu-content-yel";
		}
		else if(userType == 4){
			forcusInviteJoin = "left-menu-content-yel";
		}else{
			forcusAdmin = "left-menu-content-yel";
		}
	}
%>
<script type="text/javascript">
	var flag_org = 0;
	var flag_product = 0;
	function showChildOrg(){
		if(flag_org == 0){
			jQuery("#childOrg").css("display","none");
			flag_org = 1;
		}else{
			jQuery("#childOrg").css("display","block");
			flag_org = 0;
		}	
	}
	
	function showChildProduct(){
		if(flag_product == 0){
			jQuery("#childProduct").css("display","none");
			flag_product = 1;
		}else{
			jQuery("#childProduct").css("display","block");
			flag_product = 0;
		}	
	}
	
</script>
<fmt:setBundle basename="mes_key"/>
<div class="pg-left-panel">
<div class="side-bar-org" style="width: 260px;">
	<div class = "left-menu-layout">
		<span class="left-menu-header-content">
			<fmt:message key="leftMenu.header"/>
		</span>
	</div>
	<div class = "left-menu-layout">
		<div class="left-menu-common" style="display: none;">
			<div class="left-menu-img"><a href="#"><img width="21" height="20" src="/ProGate-portlet/images/left_menu/quanlygiaodich.png"></a></div>
			<div class="left-menu-a-layout"><a href="#" style="padding-bottom: 2px;"><span class="left-menu-content"><fmt:message key="leftMenu.transaction" /></span></a></div>
		</div>
		<c:choose>
		<c:when test="${isAdmin}">
			<c:if test="${!isMyHomePage}">
				<c:forEach items="${bean.applications}" var="app">
					<c:if test=""></c:if>
						<div class="left-menu-common">
							<div class="left-menu-img"><a href="${app.friendlyUrl}"><img width="21" height="20" src="${app.imageUrl}"></a></div>
							<div class="left-menu-a-layout"><a href="${app.friendlyUrl}">
								<c:choose>
									<c:when test="${bean.selectedPage == app.friendlyUrl}">
										<span class="left-menu-content-yel">${app.name}</span>
									</c:when>
									<c:otherwise>
										<span class="left-menu-content">${app.name}</span>
									</c:otherwise>
								</c:choose>
							</a></div>
						</div>
				</c:forEach>
			 </c:if>
			<div class="left-menu-common">
				<div class="left-menu-img"><a href="#"><img width="21" height="20" src="/ProGate-portlet/images/left_menu/support.png"></a></div>
				<div class="left-menu-a-layout"><a href="#"><span class="left-menu-content"><fmt:message key="leftMenu.supportMgt"/></span></a></div>
			</div>
			<div class="left-menu-common">
				<div class="left-menu-img"><a href="#"><img width="21" height="18" src="/ProGate-portlet/images/left_menu/contact.png"></a></div>
				<div class="left-menu-a-layout"><a href="#"><span class="left-menu-content"><fmt:message key="leftMenu.contactMgt"/></span></a></div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="left-menu-common">
				<div class="left-menu-img" style="cursor: pointer;"><img width="21" height="20" src="/ProGate-portlet/images/left_menu/quanlytochuc.png" onclick="showChildOrg();"></div>
				<div class="left-menu-a-layout"><span class="left-menu-content" onclick="showChildOrg();"><fmt:message key="leftMenu.organization"/></span></div>
				<div id="childOrg" style="display: block;" class="left-menu-child">
					<div class="left-menu-child-common">
						<a href="<%=url_TC_Admin %>">
						<div class="left-menu-img" style="cursor: pointer;"><img width="16" height="16" src="/ProGate-portlet/images/left_menu/checked.png"></div>
							<span class="<%= forcusAdmin %>"><fmt:message key="leftMenu.admin"/></span>
						</a>
					</div>
					<div class="left-menu-child-common">
						<a href="<%=url_TC_Member %>">
							<div class="left-menu-img" style="cursor: pointer;"><img width="16" height="16" src="/ProGate-portlet/images/left_menu/checked.png"></div>
							<span class="<%= forcusMember %>"><fmt:message key="leftMenu.member"/></span>
						</a>
					</div>
					<div class="left-menu-child-common">
						<a href="<%=url_TC_Wait_Admin %>">
							<div class="left-menu-img" style="cursor: pointer;"><img width="16" height="16" src="/ProGate-portlet/images/left_menu/checked.png"></div>
							<span class="<%= forcusWaitAdmin %>"><fmt:message key="leftMenu.waitAdminAgree"/></span>
						</a>
					</div>
					<div class="left-menu-child-common">
						<a href="<%=url_TC_Invite_Join %>">
							<div class="left-menu-img" style="cursor: pointer;"><img width="16" height="16" src="/ProGate-portlet/images/left_menu/checked.png"></div>
							<span class="<%= forcusInviteJoin %>"><fmt:message key="leftMenu.inviteJoin"/></span>
						</a>
					</div>
					<div class="left-menu-child-common">
						<a href="<%=url_TC_Other %>">
							<div class="left-menu-img" style="cursor: pointer;"><img width="16" height="16" src="/ProGate-portlet/images/left_menu/checked.png"></div>
							<span class="<%= forcusOther %>"><fmt:message key="leftMenu.other"/></span>
						</a>
					</div>
				</div>
			</div>
			<div class="left-menu-common" style="display: none;">
				<div class="left-menu-img" style="cursor: pointer;"><img width="21" height="20" src="/ProGate-portlet/images/left_menu/sanpham-dichvu.png" onclick="showChildProduct();"></div>
				<div class="left-menu-a-layout"><span class="left-menu-content" onclick="showChildProduct();"><fmt:message key="leftMenu.product"/></span></div>
				<div id="childProduct" style="display: block;" class="left-menu-child">
					<div class="left-menu-child-common">
						<a href="#">
							<div class="left-menu-img" style="cursor: pointer;"><img width="16" height="16" src="/ProGate-portlet/images/left_menu/checked.png"></div>
							<span class="left-menu-content"><fmt:message key="leftMenu.buyer"/></span>
						</a>
					</div>
					<div class="left-menu-child-common">
						<a href="#">
							<div class="left-menu-img" style="cursor: pointer;"><img width="16" height="16" src="/ProGate-portlet/images/left_menu/checked.png"></div>
							<span class="left-menu-content"><fmt:message key="leftMenu.supplier"/></span>
						</a>
					</div>
					<div class="left-menu-child-common">
						<a href="#">
							<div class="left-menu-img" style="cursor: pointer;"><img width="16" height="16" src="/ProGate-portlet/images/left_menu/checked.png"></div>
							<span class="left-menu-content"><fmt:message key="leftMenu.otherProduct"/></span>
						</a>
					</div>
				</div>
			</div>
			<div class="left-menu-common" style="display: none;">
				<div class="left-menu-img"><a href="#"><img width="21" height="20" src="/ProGate-portlet/images/left_menu/inbox.png"></a></div>
				<div class="left-menu-a-layout"><a href="#"><span class="left-menu-content"><fmt:message key="leftMenu.mailBox"/></span></a></div>
			</div>
			<div class="left-menu-common" style="display: none;">
				<div class="left-menu-img"><a href="#"><img width="21" height="20" src="/ProGate-portlet/images/left_menu/baiviettrendiendan.png"></a></div>
				<div class="left-menu-a-layout"><a href="#"><span class="left-menu-content"><fmt:message key="leftMenu.entryForum"/></span></a></div>
			</div>
		</c:otherwise>
		</c:choose>
	</div>
</div>

</div>