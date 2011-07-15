<%@ include file="../../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">	

	function submit() {
		
		var orgName = '${bean.org.name}';
		
		var roleName = '${bean.oldRole}';
		
		var applyRoleName = jQuery.trim(jQuery('input[name="applyUserRole"]:checked').next().text());
		
		var str = '<fmt:message key="warning.user.decentralize.success"><fmt:param value="'
			+ roleName
			+ '"/>
			+ '<fmt:param value="'
			+ applyRoleName
			+ '"/>
			+ '<fmt:param value="'
			+ orgName
			+ '"/>
			+ '</fmt:message>';
		
		jQuery("#successMsg").val(str);
		
		var url = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="action" value="decentralizeUserInOrg" />
					    <portlet:param name="<%=Request.USER_ID %>" value='${bean.user.userid}'/>
					    <portlet:param name="<%=Request.SELECTED_ORG_ID %>" value="${bean.orgId}" />
						<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.SAVE %>"/>
					</portlet:renderURL>';
					
		document.frmUser.action = url;
		document.frmUser.submit();
	}
	
	function validate_and_submit() {
		
		var orgName = '${bean.org.name}';
		
		var roleName = '${bean.oldRole}';
		
		var applyRoleName = jQuery.trim(jQuery('input[name="applyUserRole"]:checked').next().text());
		
		if (applyRoleName == 'Manager' || roleName == 'Manager') {
			checkingValidDecentralize();
		} else {
			var str = '<fmt:message key="warning.user.decentralize.confirm"><fmt:param value="'
				+ roleName
				+ '"/>
				+ '<fmt:param value="'
				+ applyRoleName
				+ '"/>
				+ '<fmt:param value="'
				+ orgName
				+ '"/>
				+ '</fmt:message>';
			
			var answer = confirm(str);
			
			if (answer) {
				submit();
			}
		}		
	}
	
	function checkingValidDecentralize() {
		
		var userId = '${bean.user.userid}';
		var orgId = '${bean.orgId}';
		
		jQuery.ajax({
			type: "POST",
			data:"userId="+userId+"&orgId="+orgId+"&role=manager",
			url:"/ProGate-portlet/servlet/CheckingValidDecentralizeServlet",
			success: function(data){
				var str = '';
				
				var userName = '${bean.user.screenname}'; 
				
				data = jQuery.trim(data);
				
				if (data == 'action.delete.role.manager.of.user') {
					
					str = '<fmt:message key="warning.user.action.delete.role.manager.of.user">
						+ '<fmt:param value="'
						+ userName
						+ '"/>
						+ '<fmt:param value="'
						+ userName
						+ '"/>
						+ '</fmt:message>';
					
					alert(str);
				} else {
					str = '<fmt:message key="warning.user.action.decentralize.role.to.another.user">
						+ '<fmt:param value="'
						+ data
						+ '"/>
						+ '<fmt:param value="'
						+ data
						+ '"/>
						+ '<fmt:param value="'
						+ userName
						+ '"/>
						+ '<fmt:param value="'
						+ data
						+ '"/>
						+ '</fmt:message>';
						
					var answer = confirm(str);
					
					if (answer) {
						submit();
					}
				}
			}
		});
	}
	
	jQuery(function() {
		/*  Load warning message when form on load */
		var smgStatusVal = jQuery("#msgStatus").val();
		if ( smgStatusVal != 0) {
			if ( smgStatusVal == 1 ) {				
				jQuery("#tnt-global-message").addClass("tnt-global-success-message");
				jQuery("#tnt-global-message").removeClass("tnt-global-error-message");
				jQuery("#tnt-global-message span").text(jQuery("#successMsg").val());				
			} else {
				jQuery("#tnt-global-message").removeClass("tnt-global-success-message");
				jQuery("#tnt-global-message").addClass("tnt-global-error-message");
				jQuery("#tnt-global-message span").text(jQuery("#failMsg").val());
			}
		}
	});
</script>

<form action="" name="frmUser" method="post">

<div class="tnt-user-management">
	<div>
		<div class="tnt-row tnt-border-bottom">
			<div class="tnt-row-left">
				<div class="tnt-title">
					<label><fmt:message key="title.user.decentralization"/></label>
				</div>
			</div>
		</div>
		
		<div class="tnt-row" id="tnt-global-message">
			<span>
			
			</span>
		</div>
				
		<div class="tnt-row">
			<div class="tnt-row">
				<fieldset style="height: 50px;">
				<legend><fmt:message key="title.user.account.information"/></legend>
				<label><fmt:message key="title.user.login.name"/>:</label>
				<label><c:out value="${bean.user.screenname}"></c:out></label>
				<br/>
				<label><fmt:message key="title.user.full.name"/>:</label>
				<label><c:out value="${bean.user.firstname} ${bean.user.lastname}"/></label>
				</fieldset>
			</div>
			
			<div class="tnt-row">
				<fieldset>
				<legend><fmt:message key="title.user.decentralize"/></legend>
				<c:forEach items="${bean.roles}" var="role">
					<c:choose>
						<c:when test="${role.roleId == 5 && bean.participant.roleId == 9}">
							<input type="radio" name="<%=Request.APPLY_USER_ROLE %>" 
									value="${role.roleId}" checked="checked"/>
						</c:when>
						
						<c:otherwise>
							<c:choose>								
								<c:when test="${role.roleId == bean.participant.roleId}">
									<input type="radio" name="<%=Request.APPLY_USER_ROLE %>" 
											value="${role.roleId}" checked="checked"/>
								</c:when>
								
								<c:otherwise>
									<input type="radio" name="<%=Request.APPLY_USER_ROLE %>" 
											value="${role.roleId}"/>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
													
					<label class="roleName"><c:out value="${role.name}"/></label>
				</c:forEach>
				</fieldset>
			</div>
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-center">
				<span>
				<input type="button" class="bt-form" onclick="validate_and_submit()"
						value='<fmt:message key="button.save" />'/>
				</span>
				
				<span>
				<portlet:renderURL var="returnURL">
				    <portlet:param name="action"
				                   value="commonController" />
				    <portlet:param name="<%=Request.ROOT_ORG_ID %>"
				                   value="${bean.rootOrgId}" />
				    <portlet:param name="<%=Request.SELECTED_ORG_ID %>"
				                   value="${bean.orgId}" />
				    <portlet:param name="<%=Request.TAB %>"
				                   value="<%=Request.MEMBER_TAB %>" />
			  	</portlet:renderURL>
				<input type="button" class="bt-form"
						onclick="window.location = '<c:out value='${returnURL}'/>'"
						value='<fmt:message key="button.cancel" />'/>
				</span>
			</div>
		</div>
	</div>	
</div>

<input type="hidden" name="<%=Request.ROOT_ORG_ID %>" value="${bean.rootOrgId}">
<input type="hidden" name="<%=Request.SUCCESS_MESSAGE %>" value="${bean.successMsg}" id="successMsg">
<input type="hidden" name="<%=Request.FAIL_MESSAGE %>" value="${bean.failMsg}" id="failMsg">
</form>

<form name="frmMsg">
	<input type="hidden" name="<%=Request.MESSAGE_STATUS %>" id="msgStatus" value="${bean.msgStatus}">
</form>