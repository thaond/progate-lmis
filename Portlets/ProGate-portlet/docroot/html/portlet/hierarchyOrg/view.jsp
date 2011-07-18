<%@page import="larion.progate.model.Organization"%>
<%@page import="com.larion.progate.common.constants.URLParameter_RS"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/init.jsp" %>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
	Organization org = null;
	if(request.getAttribute(URLParameter_RS.ORGANIZATION) != null){
		org = (Organization) request.getAttribute(URLParameter_RS.ORGANIZATION);
	}
	int maxLevel =  org.getMaxLevel() ; //org.getMaxLevel();
	if(maxLevel > 5){
		maxLevel = 5;
	}
	request.setAttribute("maxLevel", maxLevel);
	
	//System.out.println("maxLevel= " + maxLevel);
	int viewMode = 0;
	if(request.getAttribute(URLParameter_RS.VIEW_MODE) != null){
		viewMode = (Integer) request.getAttribute(URLParameter_RS.VIEW_MODE);
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
</script>
<style type="text/css">
   <%@ include file="/css/style.css" %>
</style>
<c:set var="listOrg" value="<%= listAllChildOrg %>"></c:set>
<c:set var="max_level" value="<%= maxLevel %>" />
<div class="org-profile-layout-column-22">
<div class="org-common-layout">
			<div class="org-common-header">
				<div class="org-td-header">
					
						<span class="org-header-content">Các Cấp Tổ Chức </span>
				
				</div>
			</div>
			<div class="suborg-common-body">
				<div style="padding: 5px;">
					<div class="sub-org-expand" flag="0" id="Content<%=org.getPrimaryKey()%>">
						<div style="float: left;padding-right: 3px;display: block;" id="Image<%=org.getPrimaryKey()%>Sub">
							<img width="14" height="14" src="/ProGate-portlet/images/sub_org/sub.png"/>
						</div>
						<div style="padding-bottom: 3px;">
							<c:set value="<%= org.getName() %>" var="description" />			
								<c:choose>
									<c:when test="${fn:length(description) > 40}">
										<c:set value="${fn:substring(description, 35, 40)}" var="strTemp" />
										<c:set value="${fn:indexOf(strTemp, ' ')}" var="iTemp" />
										<c:set value="${fn:substring(description, 0, 35 + iTemp)}..." var="descTruncate" />
									</c:when>				
									<c:otherwise>
										<c:set value="${description}" var="descTruncate" />
									</c:otherwise>
								</c:choose>	
							<c:out value="${descTruncate}" escapeXml="false"></c:out>
						</div>	
					</div>
				</div>
				<div style="float: left; padding-left: 20px; width: 200px; display: block;" id="ListOrg<%=org.getPrimaryKey()%>"></div>	
					<c:forEach var="ilevel" begin="1" end="${max_level}" step="1">
						<c:set var="pl" value="${(ilevel + 1) * 20}"/>
						<c:forEach var="orgItem" items="${listOrg}">
							<c:if test="${orgItem.level == ilevel}">		
								<div id="SubOrg${orgItem.primaryKey}" class='sub-org-tr' style='display:none;'>
									<div class="sub-org-border">
										<div class='sub-org-expand' flag="0" id='Content${orgItem.primaryKey}'>
											<div style='float: left;padding-right: 3px;display: block;' onclick='collapseDiv(${orgItem.primaryKey});' 
											     id='Image${orgItem.primaryKey}Add'>
											<img width='14' height='14' src='/ProGate-portlet/images/sub_org/add.png'/>
											</div>
											<div style='float: left;padding-right: 3px;display: none;' onclick='collapseDiv(${orgItem.primaryKey});' 
											    id='Image${orgItem.primaryKey}Sub'>
												<img width='14' height='14' src='/ProGate-portlet/images/sub_org/sub.png'/>
											</div>
											<div style='padding-bottom: 3px;'>
													<c:set value="${orgItem.name}" var="name" />			
													<c:choose>
														<c:when test="${fn:length(name) > 35}">
															<c:set value="${fn:substring(name, 20, 35)}" var="temp" />
															<c:set value="${fn:indexOf(temp, ' ')}" var="itemp" />
															<c:set value="${fn:substring(name, 0, 20 + itemp)}..." var="nameTruncate" />
														</c:when>				
														<c:otherwise>
															<c:set value="${name}" var="nameTruncate" />
														</c:otherwise>
													</c:choose>	
													<c:out value="${nameTruncate}" escapeXml="false"></c:out>
											</div>
										</div>
									</div>
									<div style='float: left; padding-left: 20px; width: ${300 - pl}px; display: none;' 
									     id='ListOrg${orgItem.primaryKey}'>							
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
		</div>		

</div>

