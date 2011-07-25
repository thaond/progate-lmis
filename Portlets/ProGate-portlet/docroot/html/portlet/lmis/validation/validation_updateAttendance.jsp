<%@ include file="../../lmis/grid/grid.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<script type="text/javascript">
function isEmpty(text){
	text = jQuery.trim(text);
	return (text=="" || text==null);
}
function isValidation(){
	var hourBegin = jQuery("#hourBegin").val();
	var minBegin = jQuery("#minBegin").val();
	var hourEnd = jQuery("#hourEnd").val();
	var minEnd = jQuery("#minEnd").val();
	var valid=true;
	if(isEmpty(hourBegin) || isEmpty(minBegin)){
		jQuery("#errorTime").removeClass('requiredFieldMessage');
		jQuery("#errorTime").text('');
		jQuery("#errorTimeBegin").removeClass('hiddenMessage');
		jQuery("#errorTimeBegin").addClass('requiredFieldMessage');
		jQuery("#errorTimeBegin").html('Bạn chưa nhập giờ bắt đầu');
		valid=false;
	}else{
		jQuery("#errorTimeBegin").removeClass('requiredFieldMessage');
		jQuery("#errorTimeBegin").text('');
		if(hourBegin > 24 || minBegin > 59 ){
			jQuery("#errorTime").removeClass('hiddenMessage');
			jQuery("#errorTime").addClass('requiredFieldMessage');
			jQuery("#errorTime").html('Bạn nhập giờ chưa chính xác');
			valid=false
		}else{
			jQuery("#errorTime").removeClass('requiredFieldMessage');
			jQuery("#errorTime").text('');
		}
	}
	if(!isEmpty(hourEnd) && !isEmpty(minEnd)){
		if(hourEnd > 24 || minEnd > 59 ){
			jQuery("#errorTime").removeClass('hiddenMessage');
			jQuery("#errorTime").addClass('requiredFieldMessage');
			jQuery("#errorTime").html('Bạn nhập giờ chưa chính xác');
			valid=false
		}else{
			jQuery("#errorTime").removeClass('requiredFieldMessage');
			jQuery("#errorTime").text('');
		}
	}
	return valid;
}
</script>