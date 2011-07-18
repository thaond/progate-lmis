<%@ include file="../../lmis/grid/grid.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<script type="text/javascript">
	function isValidation(){
		//get value
		var currentTime = new Date();
		var datepicker = jQuery("#dateAttendance").val();
		var attachFile = jQuery("#attachFile").val();
		var valid=true;

		if(isEmpty(attachFile)){
			jQuery("#chooseFile").remove();
			jQuery("#errorFileEmpty").removeClass('hiddenMessage');
			jQuery("#errorFileEmpty").addClass('requiredFieldMessage');
			jQuery("#errorFileEmpty").html('<fmt:message key="warning.up.file.empty" />');
			valid=false;
		}else if(isNotFileCSV(attachFile)){
			jQuery("#chooseFile").remove();
			jQuery("#errorFileEmpty").removeClass('hiddenMessage');
			jQuery("#errorFileEmpty").addClass('requiredFieldMessage');
			jQuery("#errorFileEmpty").html('<fmt:message key="warning.up.file.csv" />');
			valid = false;
		}else{
			jQuery("#errorFileEmpty").removeClass('requiredFieldMessage');
			jQuery("#errorFileEmpty").text('');
		}	
		return valid;
	}

	function isEmpty(text){
		text = jQuery.trim(text);
		return (text=="" || text==null);
	}
	function isNotFileCSV(file){
		var fileType = file.split('.');
		return (fileType[1] != "csv");
	}
</script>