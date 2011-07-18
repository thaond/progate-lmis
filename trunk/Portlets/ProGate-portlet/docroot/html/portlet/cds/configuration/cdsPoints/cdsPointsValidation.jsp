<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
 
function isEmpty(text){
	text = jQuery.trim(text);
	return (text == "" || text == null);
}

function isValidation() {
	var valid=true;
	
	var name1 = jQuery("#addEditCdsPointsForm #name1").val();
	var name2 = jQuery("#addEditCdsPointsForm #name2").val();
	var name3 = jQuery("#addEditCdsPointsForm #name3").val();
	var name4 = jQuery("#addEditCdsPointsForm #name4").val();
	var name5 = jQuery("#addEditCdsPointsForm #name5").val();
	
	if( name1=="Điểm" || name2=="Điểm" || name3=="Điểm" || name4=="Điểm" || name5=="Điểm") {
		jQuery("#errorName").html('<fmt:message key="warning.cp.name.empty" />');
		valid = false;
	}else {
		jQuery("#errorName").html('');
	}
	
	var value1 = jQuery("#addEditCdsPointsForm #value1").val();
	var value2 = jQuery("#addEditCdsPointsForm #value2").val();
	var value3 = jQuery("#addEditCdsPointsForm #value3").val();
	var value4 = jQuery("#addEditCdsPointsForm #value4").val();
	var value5 = jQuery("#addEditCdsPointsForm #value5").val();
	
	if( value1=="Trọng số" || value2=="Trọng số" || value3=="Trọng số" || value4=="Trọng số" || value5=="Trọng số") {
		jQuery("#errorValue").html('<fmt:message key="warning.cp.value.empty" />');
		valid = false;
	}else {
		jQuery("#errorValue").html('');
	}
	
	var des1 = jQuery("#addEditCdsPointsForm #des1").val();
	var des2 = jQuery("#addEditCdsPointsForm #des2").val();
	var des3 = jQuery("#addEditCdsPointsForm #des3").val();
	var des4 = jQuery("#addEditCdsPointsForm #des4").val();
	var des5 = jQuery("#addEditCdsPointsForm #des5").val();
	
	if( des1=="Mô tả" || des2=="Mô tả" || des3=="Mô tả" || des4=="Mô tả" || des5=="Mô tả") {
		jQuery("#errorDes").html('<fmt:message key="warning.cp.des.empty" />');
		valid = false;
	}else {
		jQuery("#errorDes").html('');
	}
	
	return valid;
}
</script>