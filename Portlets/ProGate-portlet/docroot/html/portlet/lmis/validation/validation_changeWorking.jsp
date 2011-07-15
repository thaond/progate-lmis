<%@ include file="../../lmis/grid/grid.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<script type="text/javascript">
function dateFormat(text){
    var datePart = text.match(/\d+/g);
    var day = datePart[0];
    var month = datePart[1];
    var year = datePart[2];
    return month + '/' + day + '/' + year;

}

function isEmpty(text){
	text = jQuery.trim(text);
	return (text=="" || text==null);

}

function isDateGreater(greater,lesser){
	var greaterDate = new Date(dateFormat(greater));
	var lesserDate = new Date(dateFormat(lesser));
	return (greaterDate > lesserDate);
}

function isValidation(){
	//get value
	var datepickerBegin = jQuery(".contentDetail #datepickerBegin").val();
	var datepickerEnd = jQuery(".contentDetail #datepickerEnd").val();
	var monHour = jQuery("#daily #monHour").val();
	var monMin = jQuery("#daily #monMin").val();
	var tueHour = jQuery("#daily #tueHour").val();
	var tueMin = jQuery("#daily #tueMin").val();
	var wedHour = jQuery("#daily #wedHour").val();
	var wedMin = jQuery("#daily #wedMin").val();
	var thuHour = jQuery("#daily #thuHour").val();
	var thuMin = jQuery("#daily #thuMin").val();
	var friHour = jQuery("#daily #friHour").val();
	var friMin = jQuery("#daily #friMin").val();
	var satHour = jQuery("#daily #satHour").val();
	var satMin = jQuery("#daily #satMin").val();
	var reason = jQuery("#writerDetail #reason").val();

	//default valid
	var valid=true;

	//valid reason
	if (isEmpty(reason)){
		jQuery("#errorReason").removeClass('hiddenMessage');
		jQuery("#errorReason").addClass('requiredFieldMessage');
		valid=false;
	}else{
		jQuery("#errorReason").removeClass('requiredFieldMessage');
		jQuery("#errorReason").text('');
	}

	//valid date begin
	if(isEmpty(datepickerBegin)){
		jQuery("#errorDate").removeClass('hiddenMessage');
		jQuery("#errorDate").addClass('requiredFieldMessage');
		jQuery("#errorDate").html('<fmt:message key="warning.tc.date.empty" />');
		valid=false;
	}else {
		jQuery("#errorDate").removeClass('requiredFieldMessage');
		jQuery("#errorDate").text('');
	}

	//valid date end
	if(isEmpty(datepickerEnd)){
		jQuery("#errorDate").removeClass('hiddenMessage');
		jQuery("#errorDate").addClass('requiredFieldMessage');
		jQuery("#errorDate").html('<fmt:message key="warning.tc.date.empty" />');
		valid=false;
	}else {
		//date begin > date end ?
		if(!isEmpty(datepickerBegin) && isDateGreater(datepickerBegin,datepickerEnd)){
			jQuery("#errorDate").removeClass('hiddenMessage');
			jQuery("#errorDate").addClass('requiredFieldMessage');
			jQuery("#errorDate").html('<fmt:message key="warning.tc.date.greater" />');
			valid=false;
		}else if(!isEmpty(datepickerBegin) && !isDateGreater(datepickerBegin,datepickerEnd)) {
			jQuery("#errorDate").removeClass('requiredFieldMessage');
			jQuery("#errorDate").text('');
		}
	}

	//valid time daily
	if(isEmpty(monHour) || isEmpty(monMin)|| isEmpty(tueHour) || isEmpty(tueMin)
			|| isEmpty(wedHour) || isEmpty(wedMin) || isEmpty(thuHour) || isEmpty(thuMin)
			|| isEmpty(friHour) || isEmpty(friMin) || isEmpty(satHour) || isEmpty(satMin)){
		jQuery("#errorDaily").removeClass('hiddenMessage');
		jQuery("#errorDaily").addClass('requiredFieldMessage');
		jQuery("#errorDaily").html('<fmt:message key="warning.tc.hour.daily" />');
		return false;
	}else{
		jQuery("#errorDaily").removeClass('requiredFieldMessage');
		jQuery("#errorDaily").text('');
	}


	return valid;
}
</script>