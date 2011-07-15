<%@ include file="../../../lmis/grid/grid.jsp" %>
<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">
	jQuery(function(){
		jQuery(".undo").click(function(e){
			var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="action" value="otherChangeWorkingTime" />
						<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
						<portlet:param name="<%=Constants.CMD%>" value="<%=Request.UNDO_HANDER%>" />
					</portlet:renderURL>';
			submit(url);
		});
	});

	function submit(url){
		document.frmOtherChangeWorkingTime.action=url;
		document.frmOtherChangeWorkingTime.submit();
	}

	jQuery(document).ready(function() {
		jQuery("textarea,.styleMar1").attr("disabled","disabled");
		jQuery('#tableDaily :input').attr("disabled","disabled");
		jQuery('#review').html('${bean.contentApproval}');
	});


</script>


<form action="" name="frmOtherChangeWorkingTime" method="post">
    <div class="undo">
    	<input id="undo" type="image" src="/ProGate-portlet/images/lmis/undo.png">
    	<a id="_undo" href="#"><fmt:message key="lmis.common.back" /></a>
    </div>
	<div class="content">
		<div style="padding-left:10px;padding-top:10px"><label style="color:red"><fmt:message key="lmis.common.requiredField" /></label></div>
		<div class="contentDetail">
			<div style="padding-top:20px;padding-left:10px">
				<label>Ngày tạo đơn</label>
						<input type="text" id="dateCreateForm" disabled="disabled" name="dateCreateForm"
						value="<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.timeChangeDetail.createdAt}" />" />
			</div>

			<div>
				<div style="padding-top:10px;float:left;padding-left:10px;">
					<label><fmt:message key="lmis.changetime.beginday" /> </label>
					<input type="text" id="datepickerBegin" style="width:80px;margin-left:10px;"
						name="dateBegin" disabled="disabled"
						value="<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.timeChangeDetail.startDate}" />" />
					<div  class="styleMar1"><img src="/ProGate-portlet/images/lmis/viewAttendanceInfo/disable_datepicker.png"></div>
				</div>
				<div style="padding-top:10px;float:left;padding-left:1.6em">
					<label><fmt:message key="lmis.changetime.endday" /> </label>
					<input type="text" id="datepickerEnd" style="width:80px;margin-left:10px;"
						 name="dateEnd" disabled="disabled"
						value="<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.timeChangeDetail.endDate}" />" />
					<div  class="styleMar1"><img src="/ProGate-portlet/images/lmis/viewAttendanceInfo/disable_datepicker.png"></div>
				</div>
			</div>
			<div class="clear"> </div>
			<div id="daily" style="width:48%">
				<table width="100%" border="0" cellspacing="0" id="tableDaily">
					<thead style="color:#ffffff">
						<tr>
							<th width="5%"  scope="col"><fmt:message key="lmis.common.dayOfWeek" /></th>
							<th width="25%"  scope="col"><fmt:message key="lmis.daily.begintime" /></th>
							<th width="25%" scope="col"><fmt:message key="lmis.daily.endtime" /></th>
						</tr>
					</thead>
					<tbody>
						<tr class="oddrow">
							<td>2</td>
							<td>
								<input id="monHour" type="text" width="20px" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
								name="monHour" value="${functions:getHour(bean.timeChangeDetail.monStartTime)}" />
								<label>:</label>
								<input id="monMin" type="text" width="20px"  name="monMin" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
									value="${functions:getMin(bean.timeChangeDetail.monStartTime)}" />
							</td>
							<td id="endMonTimeNew"><fmt:formatDate pattern="HH:mm" value="${bean.timeChangeDetail.monEndTime}" /></td>
						</tr>
						<tr class="evenrow">
							<td>3</td>
							<td>
								<input id="tueHour" type="text" width="20px" name="tueHour" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
									value="${functions:getHour(bean.timeChangeDetail.tueStartTime)}" />
								<label>:</label>
								<input id="tueMin" type="text" width="20px"  name="tueMin" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
									value="${functions:getMin(bean.timeChangeDetail.tueStartTime)}" />
							</td>
							<td id="endTueTimeNew"><fmt:formatDate pattern="HH:mm" value="${bean.timeChangeDetail.tueEndTime}" /></td>
						</tr>
						<tr class="oddrow">
							<td>4</td>
							<td>
								<input id="wedHour" type="text" width="20px" name="wedHour" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
									value="${functions:getHour(bean.timeChangeDetail.wedStartTime)}" />
								<label>:</label>
								<input id="wedMin" type="text" width="20px"  name="wedMin" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
									value="${functions:getMin(bean.timeChangeDetail.wedStartTime)}" />
							</td>
							<td id="endWedTimeNew"><fmt:formatDate pattern="HH:mm" value="${bean.timeChangeDetail.wedEndTime}" /></td>
						</tr>
						<tr class="evenrow">
							<td>5</td>
							<td>
								<input id="thuHour" type="text" width="20px" name="thuHour" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
									value="${functions:getHour(bean.timeChangeDetail.thuStartTime)}" />
								<label>:</label>
								<input id="thuMin" type="text" width="20px" name="thuMin" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
									value="${functions:getMin(bean.timeChangeDetail.thuStartTime)}" />
							</td>
							<td id="endThuTimeNew"><fmt:formatDate pattern="HH:mm" value="${bean.timeChangeDetail.thuEndTime}" /></td>
						</tr>
						<tr class="oddrow">
							<td>6</td>
							<td>
								<input id="friHour" type="text" width="20px" name="friHour" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
									value="${functions:getHour(bean.timeChangeDetail.friStartTime)}" />
								<label>:</label>
								<input id="friMin" type="text" width="20px" name="friMin" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
									value="${functions:getMin(bean.timeChangeDetail.friStartTime)}" />
							</td>
							<td id="endFriTimeNew"><fmt:formatDate pattern="HH:mm" value="${bean.timeChangeDetail.friEndTime}" /></td>
						</tr>
						<tr class="evenrow">
							<td>7</td>
							<td>
								<input id="satHour" type="text" width="20px" name="satHour" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
									value="${functions:getHour(bean.timeChangeDetail.satStartTime)}" />
								<label>:</label>
								<input id="satMin" type="text" width="20px"	name="satMin" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
									value="${functions:getMin(bean.timeChangeDetail.satStartTime)}" />
							</td>
							<td id="endSatTimeNew"><fmt:formatDate pattern="HH:mm" value="${bean.timeChangeDetail.satEndTime}" /></td>
						</tr>
					</tbody>
				</table>
			</div> <!--End table daily -->


			<div id="writerDetail" style="width:45%;float:left;margin-left:4em">

				<div style="float:left"><fmt:message key="lmis.common.reason" /> (<label style="color:red">*</label>)</div>
				<div style="float:left;padding-left:10px">
				<textarea id="reason" name="reason" cols="42" rows="3">
					<c:out value="${bean.timeChangeDetail.requestedReason }" escapeXml="false"></c:out>
				</textarea>
				<script type="text/javascript">
					jQuery(document).ready(function(){
						jQuery('#reason').html('${bean.timeChangeDetail.requestedReason}');
					});
				</script>
				</div>
				<div class="clear"></div>
				<div style="padding-top:14px">
				<fieldset class="fieldset">
					<legend class="legend"><fmt:message key="lmis.common.review" /></legend>
						<textarea id="review" name="review" cols="45" rows="4">
						</textarea>
				</fieldset>
				</div>
			</div>
		</div><!--End content detail-->
	</div><!--End content-->
</form>

