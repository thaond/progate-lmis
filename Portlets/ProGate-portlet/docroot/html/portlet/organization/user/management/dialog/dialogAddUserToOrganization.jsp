<%@ include file="../../../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">
	jQuery(function(){
		var save = function() {
			if(jQuery(".addedId:checked").length == 0) {
				alert('<fmt:message key="warning.user.in.organization.none.choose"/>');
			} else {
				var url = '<portlet:actionURL>
							    <portlet:param name="action" value="commonController" />
							    <portlet:param name="<%=Request.ROOT_ORG_ID %>"
			                   		   value="${bean.rootOrgId}" />
							    <portlet:param name="<%=Request.SELECTED_ORG_ID %>"
							                   value="${bean.selectedOrgId}" />
							    <portlet:param name="<%=Request.TAB %>"
					                   		   value="${bean.tab}" />
								<portlet:param name="<%=Request.ADDED_ORG_ID %>" value="addedOrgIdVal" />
								<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>"/>
							</portlet:actionURL>';
				
				var addedId = jQuery(".addedId:checked").val();
				url = url.replace("addedOrgIdVal", addedId);
				
				var orgName = jQuery.trim(jQuery(".addedId:checked").parent().parent().find(".orgName").html());
				jQuery('input[name="orgName"]').val(orgName);
				
				var str = '<fmt:message key="warning.user.add.to.organization.confirm"><fmt:param value="'
							+ orgName
							+ '"/>
							+ '</fmt:message>';
				
				var answer = confirm(str);
				
				if (answer) {
					str = '<fmt:message key="warning.user.add.to.organization.success"><fmt:param value="'
						+ orgName
						+ '"/>
						+ '</fmt:message>';
					
					jQuery("#successMsg").val(str);
					
					submit(url);
				}			
			}
	  	}
		
		var close = function() {
			jQuery("#dialogAddUserToOrganization").dialog("close");
	  	}
		
		var dialogOpts = {
	    	title:'<fmt:message key="title.user.add.to.organization" />',
	    	autoOpen: false,
		    modal: false,
		    buttons: {		        
		    	'<fmt:message key="button.save" />': save, 
		    	'<fmt:message key="button.cancel" />': close
		    },
		    resizable: false,
		    width: 500,
		    height: 400
	    };
	    
	    jQuery("#dialogAddUserToOrganization").dialog(dialogOpts);
	    
	    jQuery(".tnt-bt-add").click(function(){
	    	if(jQuery("input[name='userId']:checked").length == 0) {
				alert('<fmt:message key="warning.user.none.choose"/>');
			} else {
				jQuery("#dialogAddUserToOrganization").css("display", "block");
		    	jQuery("#dialogAddUserToOrganization").dialog("open");
			}
	    });
		// End show create objective set dialog
	});
</script>

<div id="dialogAddUserToOrganization">
	<div style="width: 488px;">
	<table class="tnt-table">
	<tbody style="display: block;
		    height: 320px;
		    overflow: auto;">
		<tr class="tnt-table-header">
			<td width="40"><fmt:message key="title.no"/></td>
			<td width="40"></td>
			<td width="400"><fmt:message key="title.organization.name"/></td>
		</tr>
		<c:forEach items="${bean.subOrgList}" var="subOrg" varStatus="count">
		<c:if test="${count.count != 1}">
		<c:choose>
			<c:when test="${count.count % 2 != 0}">
				<tr class="tnt-table-row-0">
			</c:when>
			
			<c:otherwise>
				<tr class="tnt-table-row-1">
			</c:otherwise>
		</c:choose>
			<td class="tnt-number-cell">
			<c:out value="${count.count - 1}"/>
			</td>
			
			<td class="tnt-number-cell">
				<input type="radio" name="<%=Request.ADDED_ORG_ID %>"
						value='<c:out value="${subOrg.orgId}"/>'
						class="addedId">
			</td>
			
			<td class="tnt-text-cell">
				<label class="orgName">
					<c:out value="${subOrg.orgName}"/>
				</label>
			</td>
		</tr>
		</c:if>
		</c:forEach>
	</tbody>
	</table>
	</div>
</div>