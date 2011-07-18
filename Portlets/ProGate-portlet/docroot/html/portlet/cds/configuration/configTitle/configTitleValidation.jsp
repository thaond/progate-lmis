<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	<%@ include file="/js/cds/validate.js" %>
</script>
<script type="text/javascript">
function isDuplicateName(id, newName, methodName) {
	var href='<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
		<portlet:param name="action" value="configTitle" />
		<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
	</portlet:actionURL>';
	var existedName;
	jQuery.ajax({
		type: 'POST',
		url: href,
		//synchronous requests
		async:false, 
		data: {
			"handle":"checkDuplicateName",
			"titleId":id,
			"newName": newName,
			"methodName": methodName,
		},
		success: function(data) {
			//alert("server said: "+ data);
			existedName = data;
		},
		error: function(data) {
			alert("Co loi xay ra khi dung ajax");
			return -1;
		}
	});
	//alert("return " + existedName);
	return existedName;
}
function isValidation(id) {
	var fullName = jQuery("#fullName").val();
	var shortName = jQuery("#shortName").val();
	var order = jQuery("#order").val();
	
	var valid = true;
	
	if( isEmpty(fullName) ) {
		jQuery("#errorFullName").addClass('requiredFieldMessage');
		jQuery("#errorFullName").html('<fmt:message key="warning.title.fullName.empty" />');
		valid = false;
	}else {
		//alert(isDuplicateName(id, fullName, "getName"));
		if (isDuplicateName(id, fullName, "getName") == "true") {
			valid = false;
			jQuery("#errorFullName").addClass('requiredFieldMessage');
			jQuery("#errorFullName").html('<fmt:message key="warning.title.fullName.existed" />');
			 
		} else {
			jQuery("#errorFullName").removeClass('requiredFieldMessage');
			jQuery("#errorFullName").html('<fmt:message key="information.title.name" />');
		}
	}
	
	if( isEmpty(shortName) ) {
		jQuery("#errorShortName").addClass('requiredFieldMessage');
		jQuery("#errorShortName").html('<fmt:message key="warning.title.abbreviation.empty" />');
		valid = false;
	}else {
		//alert(isDuplicateName(id, fullName, "getAbbreviation"));
		if (isDuplicateName(id, shortName, "getAbbreviation") == "true") {
			valid = false;
			jQuery("#errorShortName").addClass('requiredFieldMessage');
			jQuery("#errorShortName").html('<fmt:message key="warning.title.abbreviation.existed" />');
			 
		} else {
			jQuery("#errorShortName").html('<fmt:message key="information.title.abbreviation" />');
			jQuery("#errorShortName").removeClass('requiredFieldMessage');
		}
	}
	
	if( isEmpty(order) ) {
		jQuery("#errorOrder").addClass('requiredFieldMessage');
		jQuery("#errorOrder").html('<fmt:message key="warning.title.order.empty" />');
		valid = false;
	}else {
		jQuery("#errorOrder").removeClass('requiredFieldMessage');
		jQuery("#errorOrder").html('<fmt:message key="information.title.order" />');
	}
	
	jQuery('select[@name=points]').each(function(index){
		if(jQuery(this).val() == "select") {
			jQuery("#errorCompetencyLevels").addClass('requiredFieldMessage');
			jQuery("#errorCompetencyLevels").html('<fmt:message key="warning.title.competencyLevels.empty" />');
			valid = false;
			return false;
		}else {
			jQuery("#errorCompetencyLevels").removeClass('requiredFieldMessage');
			jQuery("#errorCompetencyLevels").text("");
		}
	});
	
	return valid;
}
</script>