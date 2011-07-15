<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">

</script>

<!-- Popup WARNING MOVE ITEMs  -->
<div class='simpleModalPopup span-12' id='warningMoveItemsForm'>
	<div class='header'>
		<span>Thông Báo</span>
	</div>
	<div class='message'>
		<div class="span-10 prepend-1 append-1 prepend-top append-bottom" id="warning">
		</div>
		<div style="margin-bottom:20px; text-align: center">
			<input type="submit" value='<fmt:message key="button.yes" />' class="yes" /> 
			<input type="submit" value='<fmt:message key="button.no" />' class="simplemodal-close no" />
		</div>
	</div>
</div>

<!-- Popup WARNING SAVE EVALUATIONs LIST  -->
<div class='simpleModalPopup span-12' id='warningSaveEvaluationsListForm'>
	<div class='header'>
		<span>Thông Báo</span>
	</div>
	<div class='message'>
		<div class="span-10 prepend-1 append-1 prepend-top append-bottom" >
			Bạn có muốn lưu danh sách các slot muốn đánh giá gồm các slot vừa được chọn không?
		</div>
		<div style="margin-bottom:20px; text-align: center">
			<input type="submit" value='<fmt:message key="button.yes" />' class="yes" /> 
			<input type="submit" value='<fmt:message key="button.no" />' class="simplemodal-close no" />
		</div>
	</div>
</div>