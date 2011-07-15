<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="scripts/functions.jsp"%>
<%@ include file="notice.jsp"%>

<!--  <script type="text/javascript" src="ProGate-portlet/js/org-management.js?v1"></script>-->

<form action="" name="frmOrgManagement" method="post">

<div class="innertube">
<table class="tbl-main-user-mnt align-table margin-align" cellspacing="0"
	cellPadding="0" width="100%">
<tbody>
<tr>
	<td class="header-tbl-menu" vAlign="top">
	<table class="tbl-user-mng-menu" cellSpacing="0" cellPadding="0" width="100%">
		<tbody>
		<tr>
			<td class="tbl-top-dot bd-left" width="70%">
			<table width="100%">
				<tbody>
				<tr>
					<td class="title-user-mng"></td>
					<td class="search-user-mng" valign="middle" width="70%" colspan=2>
					<div class="div-align">
						<span class="span-align"><fmt:message key="title.search"/></span>
						<input style="COLOR: #000000; padding: 2px 1px;"
							   id="search_txt" class="txt-search"
							   maxLength="255" type="text"
							   name="<%=Constants.SEARCH %>" />
						<span class="bt-search">&nbsp;</span>
					</div>
					</td>
				</tr>
				</tbody>
			</table>
			</td>
			<td class="tbl-top-dot bd-right" width="30%" colspan="2" align="right">
			<table cellSpacing="0" cellPadding="0" width="252px" class="control_panel">
			<tbody>
			<tr>
				<td>
				<span class="bt-new">
					<portlet:renderURL var="orgNew">
						<portlet:param name='struts_action' value='/organization_management/org_new' />
					</portlet:renderURL>
					<a href="${orgNew }" >
						<fmt:message key="button.new"/>
					</a>
				</span>
				</td>
				<td>
				<span class="bt-delete">
					<a href="javascript:void(0);"><fmt:message key="button.delete"/></a>
				</span>
				</td>
					<td>
					<span class="bt-enable">
						<a href="javascript:void(0);"><fmt:message key="button.enable"/></a>
					</span>
					</td>
					<td>
					<span class="bt-disable p-right">
						<a href="javascript:void(0);"><fmt:message key="button.disable"/></a>
					</span>
				</td>
			</tr>
			</tbody>
			</table>
			</td>
			<!--class="tbl-top-right-corner"   <td class="tbl-top-right"></td>-->
		</tr>
		</tbody>
	</table>
	</td>
</tr>

<tr>
	<td align="left">
	<table class="border-table" cellPadding="0" width="100%">
	<tbody>
		<tr class="tbl-user-mng-content-header">
			<td width="35"><fmt:message key="title.no"/></td>
			<td width="30">
				<input id="parent_ckb" class="input_header" type="checkbox" />
			</td>
			<td width="30" align="center"><fmt:message key="button.edit"/></td>
			<td class="td-color"><fmt:message key="title.organization.name"/></td>
			<td width="73"><fmt:message key="title.user.count"/></td>
			<td width="66"><fmt:message key="title.user.max.no"/></td>
			<td width="81"><fmt:message key="title.organization.subscription.start.date"/></td>
			<td width="92"><fmt:message key="title.organization.subscription.expriration.date"/></td>
			<td width="50"><fmt:message key="title.settings"/></td>
			<td width="60"><fmt:message key="title.organization.status"/></td>
		</tr>
		<c:forEach items="${orgs}" var="org" varStatus="count">
		<c:choose>
		<c:when test="${count.count % 2 != 0}">
		<c:choose>
			<c:when test="${org.orgStatus == true}">
				<tr class="tbl-content-row-0">
			</c:when>
			<c:otherwise>
				<tr class="tbl-content-row-0 disabled">
			</c:otherwise>
		</c:choose>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${org.orgStatus == true}">
					<tr class="tbl-content-row-1">
				</c:when>
				<c:otherwise>
					<tr class="tbl-content-row-1 disabled">
				</c:otherwise>
			</c:choose>			
		</c:otherwise>				
		</c:choose>
				<td class="number-cell"><c:out value="${count.count + ( pageNum - 1 ) * pageSize}"/></td>
				<td class="image-cell"><input type="checkbox" name="<%=Request.CHILD_CKB %>" 
					value='<c:out value="${org.orgId}"/>' >
				</td>
				<td align="center">										
					<portlet:renderURL var="editOrgURL">
					    <portlet:param name="struts_action"  
					                   value="/organization_management/org_management" />
					    <portlet:param name="<%= Constants.CMD %>"
					                   value="<%= Constants.EDIT %>" />
					    <portlet:param name="<%=Request.ORG_ID %>"
					                   value='${org.orgId}' />						    
				  	</portlet:renderURL>
				  	<a href="/tochuc/trangchu?orgId=${org.orgId}&viewMode=1">
				  	<img alt="" src="ProGate-portlet/images/edit_icon.gif" />
				  	</a>				  	
				</td>
				<td><a href="/tochuc/trangchu?orgId=${org.orgId}&viewMode=0"><c:out value="${org.name}"/></a></td>
				<td class="number-cell"><fmt:formatNumber type="number" value="${org.maxUserCount}"/></td>
				<td class="number-cell"><fmt:formatNumber type="number" value="${org.maxUserCount}"/></td>
				<td class="date-cell"><fmt:formatDate pattern="dd/MM/yyyy" value="${org.createdAt}" /></td>
				<td class="date-cell"><fmt:formatDate pattern="dd/MM/yyyy" value="${org.expiredDate}" /></td>
				<td align="center">
					<portlet:renderURL var="settingOrgURL">
					    <portlet:param name="struts_action"  
					                   value="/organization_management/org_edit" />
					    <portlet:param name="<%= Constants.CMD %>"
					                   value="<%= Request.SETTING %>" />
					    <portlet:param name="<%=Request.ORG_ID %>"
					                   value='${org.orgId}' />
				  	</portlet:renderURL>
					<img alt="<fmt:message key="title.organization.setting"/>" 
						src="ProGate-portlet/images/setting.gif" 
						title='<fmt:message key="title.organization.setting"/>'>					
				</td>
				<td class="status-cell">
					<c:choose>
						<c:when test="${org.orgStatus == true}">
							Enabled
						</c:when>
						<c:otherwise>
							Disabled
						</c:otherwise>
					</c:choose> 					
				</td>
			</tr>					
		</c:forEach>												
	</tbody>
	</table>
	</td>
</tr>

<tr>
	<td>
	<table cellSpacing=0 cellPadding=0 width="100%">
	<tbody>
		<tr>
			<td class=td-bottom-left></td>
			<td style="HEIGHT: 20px" width="100%"
				class="tbl-user-mng-paging border_right_bottom_left tbl-bottom-dot"	>			
			<div>
			<div style="DISPLAY: inline">
				[ <c:out value="${from}"/> - <c:out value="${to}" /> of <c:out value="${rowsNum}" /> ] &nbsp;
			</div>
			<div style="DISPLAY: inline" class="pagination">
				<c:choose>
					<c:when test="${pageNum == 1}">
						<span class="disabled_prev_page"><img alt="Prev_button_notclick"
							  src="<%=request.getContextPath() %>/images/prev_button_notclick.gif">
						</span>
					</c:when>
					<c:otherwise>
						<a class="prev_page" href="" >
						<img alt="Prev_button" src="<%=request.getContextPath() %>/images/prev_button.gif"></a>
					</c:otherwise>
				</c:choose>									
				<c:forEach items="${pages}" var="page">
				<c:choose>
					<c:when test="${page == pageNum}">
						<span class="current"><c:out value="${page}"></c:out></span>									
					</c:when>
					<c:otherwise>
						<a href="" class="goToLinkPage">
							<c:out value="${page}"></c:out>
						</a>
					</c:otherwise>
				</c:choose>
				</c:forEach>
				<c:choose>
					<c:when test="${pageNum == pagesNum}">
						<span class="disabled_next_page"><img alt="Next_button_notclick"
							  src="<%=request.getContextPath() %>/images/next_button_notclick.gif">
						</span>
					</c:when>
					<c:otherwise>
						<a class="next_page" href="" >
						<img alt="Next_button" src="<%=request.getContextPath() %>/images/next_button.gif"></a>
					</c:otherwise>
				</c:choose>					
			</div>
			<span style="PADDING-TOP: 5px">&nbsp;
				<input style="WIDTH: 40px; DISPLAY: inline; HEIGHT: 18px; FONT-SIZE: 10px; content: counter();" 
					id="page_number" type="text"
					name="page" onkeypress="return isNumberKey(event)" >&nbsp;
			</span>
			<span style="HEIGHT: 18px; CURSOR: pointer" class="bt-go-pagging">&nbsp;&nbsp;&nbsp;</span>
			</div>						
			</td>
			<td style="BORDER-RIGHT: #578ff7 1px solid"></td>
			<!--class="tbl-bottom-right-corner"-->
		</tr>		
	</tbody>
	</table>
	</td>
</tr>
</tbody>
</table>
</div>
<input type="hidden" name="pagesNum" value="<%=request.getAttribute("pagesNum") %>"/>
<input type="hidden" name="pageNum" value="<%=request.getAttribute("pageNum") %>"/> 
</form>


<FORM NAME="frmMsg">
	<INPUT TYPE="hidden" NAME="MsgTxt" id="MsgTxt" Value="${cobsMsgTxt}">
</FORM>
