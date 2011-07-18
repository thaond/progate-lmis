<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	<%@ include file="/js/cds/validate.js" %>
</script>
<script type="text/javascript">

function isValidation(id) {
	//get string values
	var nameEP = jQuery("#addEditEvaluationPeriodsForm #nameEP").val();
	var fromDate = jQuery("#addEditEvaluationPeriodsForm #fromDate").val();
	var toDate = jQuery("#addEditEvaluationPeriodsForm #toDate").val();
	var startDate = jQuery("#addEditEvaluationPeriodsForm #startDate").val();
	var endDate = jQuery("#addEditEvaluationPeriodsForm #endDate").val();
	var href='<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
		<portlet:param name="action" value="evaluationPeriods" />
		<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
	</portlet:actionURL>';
	//set default validation is false
	var valid = true;
	var pre;
	var next;
	
	//valid name
	if( isEmpty(nameEP) ) {
		jQuery("#errorName").addClass('requiredFieldMessage');
		jQuery("#errorName").html('<fmt:message key="warning.ep.name.empty" />');
		valid = false;
	}else {
		jQuery("#errorName").removeClass('requiredFieldMessage');
		jQuery("#errorName").html('<fmt:message key="information.ep.name" />');
	}
	//valid from date
	if( isEmpty(fromDate)) {
		jQuery("#errorFromDate").html('<fmt:message key="warning.ep.fromDate.empty" />');
		valid = false;
	} else {
		if(${bean.listSize} > 0) {
			//valid adding 
			if(id =="-1") {
				var maxToDate = "${bean.maxToDate}";
				if( isDateGreater(maxToDate, fromDate) ) {
					jQuery("#errorFromDate").html('Ngày bắt đầu đợt CDS phải lớn hơn ngày kết thúc <strong>' + maxToDate + '</strong> của đợt CDS trước');
					valid = false;
				} else {
					jQuery("#errorFromDate").text('');
				}
			} else { //valid editing 
				// check: from date > to date of previous period, < from date of next period
				jQuery.ajax({
					type:'GET',
					//synchronous requests
					async:false,
					url: href,
					data: {
						"handle":"checkDateInRange",
						"id":id,
					},
					success: function(xml){
						//alert("Data:" + xml);
						pre = jQuery(xml).find('pre:first').text();
						//alert(pre);
						next = jQuery(xml).find('next:first').text();
						//alert(next);
						if(pre == "null") {
							if(isDateGreater(fromDate, next)) {
								jQuery("#errorFromDate").html('Ngày bắt đầu đợt CDS phải nhỏ hơn ngày bắt đầu <strong>' + next + '</strong> của đợt CDS sau');
								valid = false;
							}
						} else if (next == "null") {
							if(isDateGreater(pre, fromDate)) {
								jQuery("#errorFromDate").html('Ngày bắt đầu đợt CDS phải lớn hơn ngày kết thúc <strong>' + pre + '</strong> của đợt CDS trước');
								valid = false;
							}
						} else if( !inDateRange(fromDate, pre, next) ) {
							jQuery("#errorFromDate").html('Ngày bắt đầu đợt CDS phải trong khoảng <strong>' + pre + '</strong> tới <strong>' + next + '</strong>');
							valid = false;
						} else {
							jQuery("#errorFromDate").text('');
						}
					},
					error: function(){
						alert("Co loi xay ra khi dung ajax");
					}
				});
				//alert(valid);
			}
			
		} else {
			jQuery("#errorFromDate").text('');
		}
	}
	//valid to date
	if( isEmpty(toDate)) {
		jQuery("#errorToDate").html('<fmt:message key="warning.ep.toDate.empty" />');
		valid = false;
	}else {
		//from date > to day ?
		if( !isEmpty(fromDate) && isDateGreater(fromDate, toDate)) {
			jQuery("#errorToDate").html('<fmt:message key="warning.ep.fromDate.Greater" />');
			valid = false;
		}else if (id !="-1") {//check: to date > to date of previous period, < from date of next period
			//alert(pre);
			//alert(next);
			if(pre == "null") {
				if(isDateGreater(toDate, next)) {
					jQuery("#errorToDate").html('Ngày kết thúc đợt CDS phải nhỏ hơn ngày bắt đầu <strong>' + next + '</strong> của đợt CDS sau');
					valid = false;
				}
			} else if (next == "null") {
				if(isDateGreater(pre, toDate)) {
					jQuery("#errorToDate").html('Ngày kết thúc đợt CDS phải lớn hơn ngày kết thúc <strong>' + pre + '</strong> của đợt CDS trước');
					valid = false;
				}
			} else if( !inDateRange(toDate, pre, next) ) {
				jQuery("#errorToDate").html('Ngày kết thúc đợt CDS phải trong khoảng <strong>' + pre + '</strong> tới <strong>' + next + '</strong>');
				valid = false;
			} else {
				jQuery("#errorToDate").text('');
			}
		} else {
			jQuery("#errorToDate").text('');
		}
	}
	//valid start date
	if( isEmpty(startDate)) {
		jQuery("#errorStartDate").html('<fmt:message key="warning.ep.startDate.empty" />');
		valid = false;
	}else {
		if ( !isEmpty(fromDate) && 
				!isEmpty(toDate) &&
				!inDateRange(startDate, fromDate, toDate)) {
			jQuery("#errorStartDate").html('<fmt:message key="warning.ep.startDate.inRange" />');
			valid = false;
		}else {
			jQuery("#errorStartDate").text('');
		}
	}
	//valid end date
	if( isEmpty(endDate)) {
		jQuery("#errorEndDate").html('<fmt:message key="warning.ep.endDate.empty" />');
		valid = false;
	}else {
		if( !isEmpty(startDate) && isDateGreater(startDate, endDate)) {
			jQuery("#errorEndDate").html('<fmt:message key="warning.ep.startDate.Greater" />');
			valid = false;
		}else if ( !isEmpty(fromDate) && 
				!isEmpty(toDate) &&
				!inDateRange(endDate, fromDate, toDate)) {
			jQuery("#errorEndDate").html('<fmt:message key="warning.ep.endDate.inRange" />');
			valid = false;
		}else { 
			jQuery("#errorEndDate").text('');
		}
	}
	
	return valid;
}
</script>