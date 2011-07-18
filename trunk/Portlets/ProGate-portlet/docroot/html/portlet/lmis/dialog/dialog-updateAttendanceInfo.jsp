<%@ include file="../../lmis/init-tvna.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../lmis/validation/validation_updateAttendance.jsp" %>
<script type="text/javascript">
	function dateFormat(text){
		var datePart = text.match(/\d+/g);
		var year = datePart[0];
	    var month = datePart[1];
	    var day = datePart[2];
	    return day + '/' + month + '/' + year;
	}
	jQuery(function(){
		jQuery("#editAttendance :input").keydown(function(e) {
	    	// Allow only backspace and delete
	    	if ( e.keyCode == 46 || e.keyCode == 8 ) {
	    		// let it happen, don't do anything
	    	}
	    	else {
	    		// Ensure that it is a number and stop the keypress
	    		if (e.keyCode < 48 || e.keyCode > 57 ) {
	    			e.preventDefault();
	    		}
	    	}
		});
		jQuery(".edit").click(function(e){
			e.preventDefault();
			var id = e.currentTarget.parentNode.getElementsByTagName("input")[1].value;
			var staffCode = jQuery(this).parent().parent().find("td:eq(1)").text();
			var url='<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
							<portlet:param name="action" value="managerAttendanceInfo"/>
							<portlet:param name="<%=Request.SELECTED_ID%>" value="id_changetime"/>
							<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
							<portlet:param name="<%=Request.TAB_ACT%>" value="<%=Request.TAB_MANAGER%>"/>
							<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.EDIT%>"/>
					</portlet:renderURL>';
			jQuery.ajax({
				type:'GET',
				url:url,
				data:{
					"selectedId":id,
					"staffCode":staffCode,
				},
				success: function(xml){
					var staffCode = jQuery(xml).find('staffCode').text();
					jQuery('#editAttendance #staffCode').val(staffCode);
					var name = jQuery(xml).find('fullName:first').text();
					jQuery('#editAttendance #name').val(name);
					var hourBegin = jQuery(xml).find('hourBegin').text();
					jQuery('#editAttendance #hourBegin').val(hourBegin);
					var minBegin = jQuery(xml).find('minBegin').text();
					jQuery('#editAttendance #minBegin').val(minBegin);
					var hourEnd = jQuery(xml).find('hourEnd').text();
					jQuery('#editAttendance #hourEnd').val(hourEnd);
					var minEnd = jQuery(xml).find('minEnd').text();
					jQuery('#editAttendance #minEnd').val(minEnd);
					var userId = jQuery(xml).find('userId').text();
					jQuery('#editAttendance #userId').val(userId);
					var _dateAtt = jQuery(xml).find('dateAtt').text();
					var dateAtt = dateFormat(_dateAtt);
					jQuery('#editAttendance #dateAtt').val(dateAtt);
					
					jQuery("#editAttendance").css("display", "block");
			    	jQuery("#editAttendance").dialog("open");
				},
				error: function(){
					alert("co loi khi dung ajax");
				}
			});
			
		});
		
		
		var save = function(e){
		if(isValidation()){
			var hourBegin = jQuery("#hourBegin").val();
			var minBegin = jQuery("#minBegin").val();
			var hourEnd = jQuery("#hourEnd").val();
			var minEnd = jQuery("#minEnd").val();
			var userId = jQuery("#userId").val();
			var dateAtt = jQuery("#dateAtt").val();
			var url = '<portlet:renderURL>
								<portlet:param name="action" value="managerAttendanceInfo" />
								<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
								<portlet:param name="<%=Request.TAB_ACTION %>" value="<%=Request.TAB_MANAGER %>" />			
								<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.SAVE%>" />
						</portlet:renderURL>';
			
			jQuery.ajax({
				type:'POST',
				url:url,
				data:{
					"hourBegin":hourBegin,
					"minBegin":minBegin,
					"hourEnd":hourEnd,
					"minEnd":minEnd,
					"userId":userId,
					"dateAtt":dateAtt				
				},
				success: function(e){
					jQuery("#editAttendance").dialog("close");
					var href = '<portlet:renderURL>
									<portlet:param name="action" value="managerAttendanceInfo" />
									<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
									<portlet:param name="<%=Request.TAB_ACTION %>" value="<%=Request.TAB_MANAGER %>" />			
									<portlet:param name="<%=Constants.CMD%>" value="<%=Request.SAVE_SUCCESS%>" />
							</portlet:renderURL>';
					submit(href);
				},
			});
		}else{
			e.preventDefault();
		}
		}
		
		var close = function() {
			jQuery("#editAttendance").dialog("close");
	  	}	
		var dialogOpts = {
		    	title:'<fmt:message key="lmis.attendanceInfo.updateHeader"/>',
		    	autoOpen: false,
			    modal: true,
			    overlay:{
			    	background:'#000000',
		    		opacity:'0.7'
			    },
			    buttons: {
			    	'<fmt:message key="button.save" />':save,
			    	'<fmt:message key="button.cancel" />': close
			    },
			    resizable: false,
			    width: 400,
			    height: 320
		    };
		jQuery("#editAttendance").dialog(dialogOpts);
		
	});
	
</script>
<div id="editAttendance">
<form action="" method="post" name="frmEditAttendance">
	<div style="padding-top:10px;padding-left:20px"><fmt:message key="lmis.common.requiredField"/></div>
	<div>
		<table style="margin-top:10px;margin-left:40px;">
		<tr>
			<td><div ><label><fmt:message key="lmis.config.code.staffID"/></label></div></td>
			<td><div ><input id="staffCode" type="text" class="styleInput15" disabled="disabled" /></div></td>
		</tr>
		<tr>
			<td><div ><label><fmt:message key="lmis.common.fullname"/></label></div></td>
			<td><div ><input id="name" type="text" class="styleInput15" disabled="disabled"/></div></td>
		</tr>
		<tr>
			<td><div ><label><fmt:message key="lmis.attendanceInfo.hourBegin"/></label></div></td>
			<td>
			<div>
				<span><input id="hourBegin" name="hourBegin" maxlength="2" type="text" style="margin-left:20px;width: 5em;height:1.5em;"/></span>
				<span><label>:</label></span>
				<span><input id="minBegin" name="minBegin" maxlength="2" type="text" style="width: 5em;height:1.5em;"/></span>				
			</div>			
			<div style="margin-top:-22px;margin-bottom:-10px;padding-left:20px" ><label id="errorTimeBegin" class="hiddenMessage" ></label></div>
			</td>
		</tr>
		<tr>
			<td><div ><label><fmt:message key="lmis.attandanceInfo.hourEnd"/></label></div></td>
			<td>
			<div >
				<span><input id="hourEnd" type="text" maxlength="2" style="margin-left:20px;width: 5em;height:1.5em;"/></span>
				<span><label>:</label></span>
				<span><input id="minEnd" type="text" maxlength="2" style="width: 5em;height:1.5em;"/></span>
				
			</div>
			</td>
		</tr>
		</table>
		<input type="hidden" id="userId">
		<input type="hidden" id="dateAtt" name="dateAtt">
	</div>
	</form>
	<div class="ui-widget-overlay"></div>
</div>




