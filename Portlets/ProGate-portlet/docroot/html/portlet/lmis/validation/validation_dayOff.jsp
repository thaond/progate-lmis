<%@ include file="../../lmis/grid/grid.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<script type="text/javascript">
function isEmpty(text){
	text = jQuery.trim(text);
	return (text=="" || text==null);

}

function dateFormat(text){
    var datePart = text.match(/\d+/g);
    var day = datePart[0];
    var month = datePart[1];
    var year = datePart[2];
    return month + '/' + day + '/' + year;
}

function isDateGreater(greater,lesser){
	var greaterDate = new Date(dateFormat(greater));
	var lesserDate = new Date(dateFormat(lesser));
	return (greaterDate > lesserDate);
}
function isDateLesser(lesser,greater){
	var greaterDate = new Date(dateFormat(greater));
	var lesserDate = new Date(dateFormat(lesser));
	return (lesser < greater);
}


function isValidation(){
	//get value
	var dayOffBegin = jQuery("#dayOffBegin").val();
	var dayOffEnd = jQuery("#dayOffEnd").val();
	var reason = jQuery("#reason").val();
	var sessionBegin = jQuery("input[name='dayOffBeginRadio']:checked").val();
	var sessionEnd = jQuery("input[name='dayOffEndRadio']:checked").val();
		
	var valid= true;
	
	//valid reason
	if(isEmpty(reason)){
		jQuery("#errorReason").removeClass('hiddenMessage');
		jQuery("#errorReason").addClass('requiredFieldMessage');
		jQuery("#errorReason").html('<fmt:message key="warning.tc.reason.empty"/>');
		valid = false;
	}else{
		jQuery("#errorReason").removeClass('requiredFieldMessage');
		jQuery("#errorReason").text('');
	}
	
	//valid date begin
	 if(isEmpty(dayOffBegin)){
		jQuery("#errorDate").removeClass('hiddenMessage');
		jQuery("#errorDate").addClass('requiredFieldMessage');
		jQuery("#errorDate").html('<fmt:message key="warning.up.file.csv" />');
		valid=false;
	}else {
		jQuery("#errorDate").removeClass('requiredFieldMessage');
		jQuery("#errorDate").text('');
	}
	
	//valid date end
	if(isEmpty(dayOffEnd)){
		jQuery("#errorDate").removeClass('hiddenMessage');
		jQuery("#errorDate").addClass('requiredFieldMessage');
		jQuery("#errorDate").html('<fmt:message key="warning.tc.date.empty" />');
		valid=false;
	}else{
		if(!isEmpty(dayOffBegin) && isDateGreater(dayOffBegin,dayOffEnd)){
			jQuery("#errorDate").removeClass('hiddenMessage');
			jQuery("#errorDate").addClass('requiredFieldMessage');
			jQuery("#errorDate").html('<fmt:message key="warning.tc.date.greater" />');
			valid=false;
		}else if(!isEmpty(dayOffBegin) && !isDateGreater(dayOffBegin,dayOffEnd) && !isDateLesser(dayOffBegin,dayOffEnd)){
			if(sessionBegin != sessionEnd){
				jQuery("#errorDate").removeClass('hiddenMessage');
				jQuery("#errorDate").addClass('requiredFieldMessage');
				jQuery("#errorDate").html('Trang thai nghi khong giong nhau');
				valid= false;
			}else{
				jQuery("#errorDate").removeClass('requiredFieldMessage');
				jQuery("#errorDate").text('');
			}
		}else if(!isEmpty(dayOffBegin) && !isDateGreater(dayOffBegin,dayOffEnd) && isDateLesser(dayOffBegin,dayOffEnd)){
			jQuery("#errorDate").removeClass('requiredFieldMessage');
			jQuery("#errorDate").text('');
		}
	} 
	
	return valid;
}
</script>