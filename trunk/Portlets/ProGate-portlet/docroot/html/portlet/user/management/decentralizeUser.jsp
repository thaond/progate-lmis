<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">
	function submit(url) {
		if (jQuery(".txt-search").val() == '<fmt:message key="title.keyword"/>') {
			jQuery(".txt-search").val('');
		}
		
		if (url == '' || url == null) {
			url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
			   			<portlet:param name="action" value="decentralizeUser" />
					    <portlet:param name="<%=Request.USER_ID %>" value="${bean.userId}"/>
					    <portlet:param name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL %>"
					    			   value="${bean.returnToFullPageURL}"/>					    
				   </portlet:renderURL>';
		}
		
		document.frmUser.action = url;
		document.frmUser.submit();
	}
	
	function pagingSubmit(url) {
		submit(url);
	}
	
	function validate_and_submit() {
		if(jQuery("input[name='orgId']:checked").length == 0) {
			alert('<fmt:message key="warning.user.in.organization.none.choose"/>');
		} else {			
			var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
				   			<portlet:param name="action" value="decentralizeUser" />
						    <portlet:param name="<%=Request.USER_ID %>" value="${bean.userId}"/>
						    <portlet:param name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL %>"
						    			   value="${bean.returnToFullPageURL}"/>
		    			    <portlet:param name="<%=Constants.CMD %>"
			    			   			   value="<%=Constants.UPDATE %>"/>
					  </portlet:renderURL>';
			
			var orgName = jQuery.trim(jQuery("input[name='orgId']:checked").parent().parent().find(".orgName").html());
			jQuery('input[name="orgName"]').val(orgName);
			
			var roleName = jQuery.trim(jQuery("input[name='orgId']:checked").parent().parent().find(".roleName").html());
			jQuery('input[name="roleName"]').val(roleName);
			
			var applyRoleName = jQuery.trim(jQuery('select[name="applyUserRole"] option:selected').html());
			jQuery('input[name="applyRoleName"]').val(applyRoleName);
			
			jQuery("input[name='orgId']:checked").parent().parent().find(".oldRoleId").attr("name", 
					"<%=Request.USER_ROLE_ID%>");
						
			if (applyRoleName == 'Owner' || roleName == 'Owner') {
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
					submit(url);
				}
			}
		}
	}
	
	function checkingValidDecentralize() {
		
		var userId = '${bean.userId}';
		var orgId = jQuery.trim(jQuery("input[name='orgId']:checked").val());
		
		jQuery.ajax({
			type: "POST",
			data:"userId="+userId+"&orgId="+orgId+"&role=owner",
			url:"/ProGate-portlet/servlet/CheckingValidDecentralizeServlet",
			success: function(data){
				var str = '';
				
				var userName = '${bean.user.screenname}';
				
				data = jQuery.trim(data);
				
				if (data == 'action.delete.role.owner.of.user') {
					
					str = '<fmt:message key="warning.user.action.delete.role.owner.of.user">'
						+ '<fmt:param value="'
						+ userName
						+ '"/>'
						+ '<fmt:param value="'
						+ userName
						+ '"/>'
						+ '</fmt:message>';
					
					alert(str);
				} else {
					str = '<fmt:message key="warning.user.action.decentralize.role.owner.to.another.user">'
						+ '<fmt:param value="'
						+ data
						+ '"/>'
						+ '<fmt:param value="'
						+ data
						+ '"/>'
						+ '<fmt:param value="'
						+ userName
						+ '"/>'
						+ '<fmt:param value="'
						+ data
						+ '"/>'
						+ '</fmt:message>';
						
					var answer = confirm(str);
					
					if (answer) {
						var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
							   			<portlet:param name="action" value="decentralizeUser" />
									    <portlet:param name="<%=Request.USER_ID %>" value="${bean.userId}"/>
									    <portlet:param name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL %>"
									    			   value="${bean.returnToFullPageURL}"/>
					    			    <portlet:param name="<%=Constants.CMD %>"
						    			   			   value="<%=Constants.UPDATE %>"/>
								  </portlet:renderURL>';
						
						submit(url);
					}
				}
			}
		});
	}
	
	function search() {
		submit();
	}
	
	jQuery(function() {
		
		/*  Load warning message when form on load */
		if ( document.frmMsg.MsgTxt.value != '') {
			if ( document.frmMsg.MsgTxt.value == 'warning.user.decentralize.success' ) {
				
				jQuery("#tnt-global-message").addClass("tnt-global-success-message");
				jQuery("#tnt-global-message").removeClass("tnt-global-error-message");
				
				var str = '<fmt:message key="warning.user.decentralize.success">
							<fmt:param value="${bean.roleName}"/>
							<fmt:param value="${bean.applyRoleName}"/>
							<fmt:param value="${bean.orgName}"/>
						  </fmt:message>';
				
				jQuery("#tnt-global-message span").text(str);
			} 
		}
		
		jQuery("input[name='btApplyFilter']").click(function(){
			submit();
		});
		
		/* Handle search */
		jQuery(".txt-search").focus();
		
		jQuery(".txt-search").focus(function(){
			if (jQuery(this).val() == '<fmt:message key="title.keyword"/>') {
				jQuery(this).val('');
			}
		});
		
		jQuery(".txt-search").blur(function(){
			if (jQuery(this).val() == '') {
				jQuery(this).val('<fmt:message key="title.keyword"/>');	
			}
		});
		
		jQuery(".txt-search").bind('keydown', function(e){
	        if (e.which == 13) {	        	
	        	search();
	        }
	    });
	});
</script>

<form action="" name="frmUser" method="post">

<div class="pg-right-panel">
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
			<div class="tnt-row-left">
				<fieldset style="width: 330px; height: 73px;">
				<legend><fmt:message key="title.user.account.information"/></legend>
				<label><fmt:message key="title.user.login.name"/>:</label>
				<label><c:out value="${bean.user.screenname}"></c:out></label>
				<br/>
				<label><fmt:message key="title.user.full.name"/>:</label>
				<label>${bean.user.firstname} ${bean.user.lastname}</label>
				</fieldset>
			</div>
			
			<div class="tnt-row-right">
				<fieldset>
				<legend><fmt:message key="title.filter"/></legend>
				<label><fmt:message key="title.user.role"/></label>
				<select name="<%=Request.FILTER_USER_ROLE %>" style="width: 230px;">
					<c:choose>
						<c:when test="${bean.filterRole == 0}">
							<option value="0" selected="selected">
								<fmt:message key="title.all"/>
							</option>
						</c:when>
						
						<c:otherwise>
							<option value="0">
								<fmt:message key="title.all"/>
							</option>
						</c:otherwise>
					</c:choose>
					
					<c:forEach items="${bean.roles}" var="role">
						<c:choose>
							<c:when test="${role.roleId == bean.filterRole}">
								<option value="${role.roleId}" selected="selected">
									<c:out value="${role.name}"/>
								</option>
							</c:when>
							
							<c:otherwise>
								<option value="${role.roleId}">
									<c:out value="${role.name}"/>
								</option>
							</c:otherwise>
						</c:choose>						
					</c:forEach>
				</select>
				</fieldset>
				<br/>
				<div>
					<input class="txt-search"
						   maxLength="100" type="text" 
						   value="${bean.searchPhrase}"
						   name="<%=Constants.SEARCH %>" />
					
					<input type="button" name="btApplyFilter" 
						value='<fmt:message key="title.view"/>'>
				</div>
			</div>
		</div>
		
		<div class="tnt-row">
			<div>
			<table class="tnt-table">
			<tbody>
				<tr class="tnt-table-header">
					<td width="40"><fmt:message key="title.no"/></td>
					<td width="40"></td>
					<td width="400"><fmt:message key="title.organization.name"/></td>
					<td width="100"><fmt:message key="title.user.role"/></td>					
				</tr>
				<c:choose>
					<c:when test="${bean.countDetailInformationUser == 0}">
					<tr>
					<td colspan="4" class="tnt-warning-message">
					<fmt:message key="warning.user.none.organization.join"/>					
					</td>							
					</tr>
					</c:when>
					
					<c:otherwise>
					<c:forEach items="${bean.users}" var="user" varStatus="count">				
						<c:choose>
							<c:when test="${count.count % 2 != 0}">
								<tr class="tnt-table-row-0">
							</c:when>
							
							<c:otherwise>
								<tr class="tnt-table-row-1">
							</c:otherwise>
						</c:choose>
							<td class="tnt-number-cell">
							<c:out value="${count.count + ( bean.paginationUser.currentPage - 1 ) * bean.paginationUser.pageSize}"/>
							</td>
							
							<td class="tnt-number-cell">
								<input type="radio" name="<%=Request.ORG_ID %>"
										value='${user.orgId}' >
							</td>
							
							<td class="tnt-text-cell">
								<label class="orgName">
									<c:out value="${user.orgName}"/>
								</label>
							</td>
							
							<td class="tnt-text-cell">
								<input type="hidden" value="${user.roleId}" class="oldRoleId">
								<label class="roleName">
									<c:out value="${user.rolename}"/>
								</label>
							</td>
						</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
			</table>
			</div>
			
			<c:if test="${bean.countDetailInformationUser > 0}">
				<div class="tnt-row">
					<c:set value="${bean.paginationUser}" var="paging"></c:set>
					<%@ include file="../../common/pagination.jsp" %>
				</div>
			</c:if>
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-left">
				<label><fmt:message key="title.user.role"/></label>
				<select name="<%=Request.APPLY_USER_ROLE %>">
					<c:forEach items="${bean.roles}" var="role">
						<option value="${role.roleId}">
							<c:out value="${role.name}"/>
						</option>
					</c:forEach>
				</select>
			</div>
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-center">
				<c:if test="${bean.countDetailInformationUser > 0}">
				<span>
				<input type="button" class="bt-form" onclick="validate_and_submit()"
						value='<fmt:message key="button.save" />'/>
				</span>
				</c:if>
				
				<span>
				<input type="button" class="bt-form"
						onclick="window.location = '<c:out value='${bean.returnToFullPageURL}'/>'"
						value='<fmt:message key="button.cancel" />'/>
				</span>
			</div>
		</div>
	</div>	
</div>

<input type="hidden" name="roleName"/>
<input type="hidden" name="applyRoleName"/>
<input type="hidden" name="orgName"/>

</form>

<form name="frmMsg">
	<input type="hidden" name="<%=Request.MESSAGE_TXT %>" id="MsgTxt" value="${bean.MsgTxt}">
</form>
