<%@page import="larion.progate.model.Organization"%>
<%@page import="com.larion.progate.common.constants.URLParameter_RS"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/init.jsp" %>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%
	//Build URL
	String homeUrl= PortalUtil.getPortalURL(request);
	String pageSubOrg = "/taotochuc";
	String addOrgUrl = homeUrl + pageSubOrg + StringPool.QUESTION + "cmd=add" + StringPool.AMPERSAND + URLParameter_RS.ORG_PARENT_ID + StringPool.EQUAL;
	String editOrgUrl = homeUrl + pageSubOrg + StringPool.QUESTION + "cmd=edit" + StringPool.AMPERSAND + URLParameter_RS.ORG_ID + StringPool.EQUAL;
	//String detailSubOrgUrl = homeUrl + "/tochuc/to-chuc-con" + StringPool.QUESTION + URLParameter_RS.VIEW_MODE + StringPool.EQUAL + "0" + StringPool.AMPERSAND + URLParameter_RS.ORG_ID + StringPool.EQUAL;
	String subOrgUrl =  PortalUtil.getCurrentURL(request);
	
	
	List<Organization> listAllChildOrg = null;
	if(request.getAttribute(URLParameter_RS.LIST_ALL_CHILD_ORG) != null){
		listAllChildOrg = (List<Organization>) request.getAttribute(URLParameter_RS.LIST_ALL_CHILD_ORG);
	}
	//System.out.println("listAllChildOrgs= " + listAllChildOrg.size());
	Organization org = null;
	if(request.getAttribute(URLParameter_RS.ORGANIZATION) != null){
		org = (Organization) request.getAttribute(URLParameter_RS.ORGANIZATION);
	}
	int maxLevel =  org.getMaxLevel() ; //org.getMaxLevel();
	request.setAttribute("maxLevel", maxLevel);
	
	//System.out.println("maxLevel= " + maxLevel);
	int viewMode = 0;
	if(request.getAttribute(URLParameter_RS.VIEW_MODE) != null){
		viewMode = (Integer) request.getAttribute(URLParameter_RS.VIEW_MODE);
	}
	boolean isAdmin = false;
	if(request.getAttribute("isAdmin") != null){
		isAdmin = (Boolean) request.getAttribute("isAdmin");
	}
	
%>
<script type="text/javascript">

	function collapseDiv(orgId){
		var imageIdAdd = '#Image' + orgId + 'Add';
		var imageIdSub = '#Image' + orgId + 'Sub';
		var listOrgId = '#ListOrg' + orgId;
		var imageId = '#Content' + orgId;
		var isflag = jQuery(imageId).attr('flag');
		
		if(isflag == 0){
			jQuery(imageIdSub).css("display","block");
			jQuery(imageIdAdd).css("display","none");
			jQuery(listOrgId).css("display","block");
			jQuery(imageId).attr('flag','1');
		}else{
			jQuery(imageIdSub).css("display","none");
			jQuery(imageIdAdd).css("display","block");
			jQuery(listOrgId).css("display","none");
			jQuery(imageId).attr('flag','0');
		}
	}
	
	function deleteOrg(orgId) {		
		if (confirm('Bạn có chắc muốn xóa tổ chức này không ?')) {
			var portletActionURL = '<portlet:actionURL>
						               <portlet:param name="action" value="deleteSubOrg"/>
						              </portlet:actionURL>';
			document.deleteOrg.<%=URLParameter_RS.ORG_ID%>.value = orgId;
			document.deleteOrg.action = portletActionURL;
		    document.deleteOrg.submit();
		}		
	}
	
</script>
<style type="text/css">
   <%@ include file="/css/sub_org/style.css" %>
</style>
<c:set var="view_Mode" value="<%= viewMode %>" />
<c:set var="max_level" value="<%= maxLevel %>" />
<c:set var="listOrg" value="<%= listAllChildOrg %>" />
<c:set var="addOrgPrefix" value="<%= addOrgUrl %>" />
<c:set var="editOrgPrefix" value="<%= editOrgUrl %>" />
<c:set var="isAdminRole" value="<%= isAdmin %>" />
<c:set var="addOrgSuffix" value="<%= StringPool.AMPERSAND + URLParameter_RS.ORG_ROOT_ID + StringPool.EQUAL + org.getPrimaryKey() + StringPool.AMPERSAND + URLParameter_RS.VIEW_MODE + StringPool.EQUAL + viewMode %>"/>
<c:set var="editOrgSuffix" value="<%= StringPool.AMPERSAND + URLParameter_RS.ORG_ROOT_ID + StringPool.EQUAL + org.getPrimaryKey() + StringPool.AMPERSAND + URLParameter_RS.VIEW_MODE + StringPool.EQUAL + viewMode %>"/>
<div class="sub-org-body">
		<div class="sub-org-expand" flag="0" id="Content<%=org.getPrimaryKey()%>">
			<div onclick="collapseDiv(<%=org.getPrimaryKey()%>);" style="float: left;padding-right: 3px;padding-bottom:5px;;display: none;" 
			     id="Image<%=org.getPrimaryKey()%>Add">
				<img width="14" height="14" src="/ProGate-portlet/images/sub_org/add.png"/>
			</div>
			<div onclick="collapseDiv(<%=org.getPrimaryKey()%>);" style="float: left;padding-right: 3px;padding-bottom:5px;display: block;" 
			     id="Image<%=org.getPrimaryKey()%>Sub">
				<img width="14" height="14" src="/ProGate-portlet/images/sub_org/sub.png"/>
			</div>
			<div style="padding-bottom: 3px;">
				<%= org.getName() %>
			</div>			
		</div>
		<%if(isAdmin && (viewMode == 1)){ %>
			<div class="sub-org-action">
				<a href="<%= addOrgUrl + org.getPrimaryKey() + StringPool.AMPERSAND + URLParameter_RS.ORG_ROOT_ID + StringPool.EQUAL + org.getPrimaryKey() + StringPool.AMPERSAND + URLParameter_RS.VIEW_MODE + StringPool.EQUAL + viewMode %>" style="float: right;">
					<img width="18" height="18" src="/ProGate-portlet/images/sub_org/plus.png"/>
				</a>
			</div>
		<%} %>

	<div style="float: left; padding-left: 20px; width: 610px; display: block;" id="ListOrg<%=org.getPrimaryKey()%>">
	</div>	
			
	<c:forEach var="ilevel" begin="1" end="${max_level}" step="1">
		<c:set var="pl" value="${(ilevel + 1) * 20}"/>
		<c:forEach var="orgItem" items="${listOrg}">
			<c:if test="${orgItem.level == ilevel}">		
				<div id="SubOrg${orgItem.primaryKey}" class='sub-org-tr' style='display:none;'>
					<div class="sub-org-border">
						<div class='sub-org-expand' flag="0" id='Content${orgItem.primaryKey}'>
							<div style='float: left;padding-right: 3px;padding-bottom:5px;display: block;' onclick='collapseDiv(${orgItem.primaryKey});' id='Image${orgItem.primaryKey}Add'>
								<img width='14' height='14' src='/ProGate-portlet/images/sub_org/add.png'/>
							</div>
							<div style='float: left;padding-right: 3px;padding-bottom:5px; display: none;' onclick='collapseDiv(${orgItem.primaryKey});' id='Image${orgItem.primaryKey}Sub'>
								<img width='14' height='14' src='/ProGate-portlet/images/sub_org/sub.png'/>
							</div>
							<div style='padding-bottom: 3px;'>
									${orgItem.name}
							</div>
						</div>
						<c:if test="${isAdminRole && (view_Mode == 1)}">	
							<div class='sub-org-action'>
								<a href='javascript:deleteOrg(${orgItem.primaryKey});' style='float: right;'>
									<img width='18' height='18' src='/ProGate-portlet/images/sub_org/delete.png'/>
								</a>
								<a href='${editOrgPrefix}${orgItem.primaryKey}${editOrgSuffix}' style='float: right;padding-right: 10px;'>
									<img width='18' height='18' src='/ProGate-portlet/images/sub_org/edit.png'/>
								</a>
								<a href='${addOrgPrefix}${orgItem.primaryKey}${addOrgSuffix}' style='float: right;padding-right: 10px;'>
									<img width='18' height='18' src='/ProGate-portlet/images/sub_org/plus.png'/>
								</a>
							</div>
						</c:if>
					</div>
					<div style='float: left; padding-left: 20px; width: ${630 - pl}px; display: none;' id='ListOrg${orgItem.primaryKey}'>							
					</div>
				</div>
				<script>
				  	jQuery(document).ready(function () {
				  		jQuery("#ListOrg${orgItem.orgParent}").append(jQuery("#SubOrg${orgItem.primaryKey}").html());
					});
			  	</script>						
			</c:if>
		</c:forEach>
	</c:forEach>	
</div>




<form action="" method="post" name="deleteOrg">
	<input type="hidden" name="<%= URLParameter_RS.ORG_ID %>" value="">
	<input type="hidden" name="<%= URLParameter_RS.ORG_ROOT_ID %>" value="<%=org.getPrimaryKey()%>">
	<input type="hidden" name="<%= URLParameter_RS.VIEW_MODE %>" value="<%=viewMode%>">
</form>


<form action="" method="post" name="showChildOrg">
	<input type="hidden" name="<%= URLParameter_RS.ORG_ID %>" value="">
</form>

