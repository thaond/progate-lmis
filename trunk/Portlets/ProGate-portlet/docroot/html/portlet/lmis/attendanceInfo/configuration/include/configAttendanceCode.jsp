<%@ include file="../../../../common/init.jsp" %>
<%@ include file="../../../../lmis/initOfConfig.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>


<script type="text/javascript"
	src="/ProGate-portlet/js/jquery.alerts.js"></script>
<script>
var UserId;
var attCode;
function pagingSubmit(){ 
	jQuery("#frmConfigCalendar").submit();
}
	jQuery(document).ready(function() {
				jQuery('input').blur(function() {
					if(jQuery(this).val()=="") {
						alert("Mã chấm công không được để trống");
						jQuery(this).focus();
					}
				});
				jQuery('.editCode').click(
						function(e) {
							//Add class
							jQuery('.editCode').attr("src","/ProGate-portlet/images/lmis/Edit_disable.png");
							jQuery('#control input').removeClass('button-disable').addClass('button-enable');
							jQuery('#control input').removeAttr('disabled');
							jQuery(".hdn").removeAttr("name");
							jQuery('.txtinput').removeAttr("name");
							var elm = jQuery(this).parent().find('.hdn');
							//Remove hidden name
							elm.attr("name","UserId");
							UserId = elm.val();
							var code =jQuery(this).parent().prev().find('input');
							code.attr('id','code');
							disableAll();
							jQuery(this).parent().parent().find('.txt').find(
									'input').removeAttr('disabled');
							e.preventDefault();
						});
			});
	function disableAll() {
		var e = jQuery('.editCode');
		jQuery.each(e,function (){
			jQuery(this).attr('disabled','disabled');
		});
	}
	function mysubmit(url){
		if(url=='' || url==null){
				url = '<portlet:renderURL >
					<portlet:param name="action" value="configuration" />
					<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.EDIT%>" />
					<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.ATTENDANCECODE_TAB%>" />
					<portlet:param name="orgId" value="${bean.orgId}" />
				</portlet:renderURL>';
			}
		attCode = jQuery('#code').val(); 
		jQuery.ajax({
			type: "POST",
			url :url,
			data:{
				"UserId" : UserId,
				"code" : attCode
			},
			success: function(){
				var href='<portlet:renderURL>
					<portlet:param name="action" value="commonController" />
				<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.ATTENDANCECODE_TAB%>" />
				<portlet:param name="orgId" value="${bean.orgId}" />
				</portlet:renderURL>';
				
				jQuery(".successful").css("display", "block");
			    	jQuery(".successful").data('url',href).data('close',close).dialog("open");
			},
			error: function(data){
				var ok = jQuery(data).find('success').val();
				if(ok==2){
					var href='<portlet:renderURL>
						<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.ATTENDANCECODE_TAB%>" />
					<portlet:param name="orgId" value="${bean.orgId}" />
					</portlet:renderURL>';
					
					jQuery(".successful").css("display", "block");
				    	jQuery(".successful").data('url',href).data('close',close).dialog("open");
				}
				if(ok==0){
					alert("Đã xảy ra lỗi nghiêm trọng, vui lòng thông báo đến Administrator");
				}
				if(ok==1){
					alert("Mã chấm công đã tồn tại, vui lòng nhập mã khác");
				}
			}
		});
	}
function myCancel(r){
			url = '<portlet:renderURL  >
				<portlet:param name="action" value="configuration" />
				<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.CANCEL%>" />
				<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.ATTENDANCECODE_TAB%>" />
				<portlet:param name="orgId" value="${bean.orgId}" />
			</portlet:renderURL>';

		document.frmConfigCode.action=url;
		document.frmConfigCode.reset();
		document.frmConfigCode.submit();
	}
</script>

<form id="frmConfigCalendar" action="" name="frmConfigCode"
	method="post">


<div class="contentConfigCalendar">
	<div class="div-of-table-content">
	<div class="table-content" style="min-height: 280px">
	<table width="100%">
		<thead class="tbl-header">
			<tr>
				<th width="50px" scope="col"><fmt:message
					key="lmis.common.number" /></th>
				<th width="15%" scope="col"><fmt:message
					key="lmis.config.code.staffid" /></th>
				<th scope="col"><fmt:message key="lmis.config.code.staffname" />
				</th>
				<th width="100px" scope="col"><fmt:message
					key="lmis.config.code.scannercode" /></th>
				<th width="8%" scope="col"><fmt:message key="button.edit" /></th>
	
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${bean.lsResult}" varStatus="itemCount">
				<c:choose>
					<c:when test="${itemCount.count % 2 !=0 }">
						<tr class="oddrow">
					</c:when>
					<c:otherwise>
						<tr class="evenrow">
					</c:otherwise>
				</c:choose>
				<td align="center">${itemCount.count}</td>
				<td align="center">${item.staffCode}</td>
				<td id="fullname">${item.fullName}</td>
				<td align="center" class="txt"><input style="display:table-cell; width: 85%; padding-right:10px; text-align: right" class="txtinput" disabled="disabled"
					type="text" value="${item.scannerCode }" maxlength="8" /></td>
				<td id="tdEdit"><input class="hdn" type="hidden" value="${item.userId }" /> <input type="image" class="editCode" src="/ProGate-portlet/images/lmis/edit.png" /></td>
			</c:forEach>
		</tbody>
	</table>
	</div>
		<div class="lmis-paging" style="padding-top: 10px"> 
			<c:set value="${bean.pagination}" var="paging"></c:set> 
			<%@ include file="/html/portlet/common/pagination.jsp" %>  
		</div>
	</div>
</div>
<!--End content-->

<input type="hidden" name="orgId" value="${bean.orgId }">
<div id="control" align="center" style="padding-top: 10px; padding-bottom: 0px; clear: both;"><input
	class="button-disable" id="save" type="button" onclick="mysubmit('');"
	value='<fmt:message key="button.save" />' disabled="disabled" /> <input
	class="button-disable" id="cancel" type="reset"
	onclick="myCancel(${bean.orgId});"
	value='<fmt:message key="button.cancel" />' disabled="disabled" /></div>
</form>

<jsp:include page="../../../dialog/dialog-configAttCodeOk.jsp"/>