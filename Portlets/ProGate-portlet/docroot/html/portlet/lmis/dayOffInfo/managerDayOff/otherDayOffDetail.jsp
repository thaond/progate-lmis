<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	jQuery(document).ready(function(){
		jQuery('.contentDetail :input').attr("disabled","disabled");
	});
	
	jQuery(function(){
		jQuery(".undo").click(function(){
			var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
				<portlet:param name="action" value="otherDayOff" />
				<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
				<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_OTHER%>"/>
				<portlet:param name="<%=Constants.CMD%>" value="<%=Request.UNDO_HANDER%>"/>
			</portlet:renderURL>';
		submit(url);
		});
	});
	function submit(url){
		document.frmOtherDayOffDetail.action=url;
		document.frmOtherDayOffDetail.submit();
	}
</script>

<form action="" name="frmOtherDayOffDetail" method="post">  
    <div class="undo">
    	<input id="undo" type="image" src="/ProGate-portlet/images/lmis/undo.png">
    	<a id="_undo" href="#"><fmt:message key="lmis.common.back"/></a>
    </div>
    <div class="content">
    	<div class="cls-centerDetail"><fmt:message key="lmis.common.detailInfo"/></div>
		<div style="padding-left:10px;padding-top:10px">
			<div style="float:left"><label style="color:red"><fmt:message key="lmis.common.requiredField"/></label></div>
			<div style="float:left;padding-left:30.5em"><label style="color:red;font-weight:bold">NPTN con lai : 0 ngay, TS ngay da nghi: 5 ngay</label></div>
		</div>
		<div class="contentDetail">
			<div style="float:left;padding-top:20px;">
				<table style="margin-left:10px;" >
					<tr>
						<td><fmt:message key="lmis.common.createDate"/></td>
						<td><div style="padding-left:25px">
								<input type="text" id="dateCreate"  name="dateCreateForm" size="41px" disabled="disabled"> </div>
						</td>
					</tr>
					<tr>
						<td><div style="margin-top:-10px"><fmt:message key="lmis.dayoff.Begin"/></div></td>
						<td>
							<div style="padding-top:10px;padding-left:25px">
								<input type="text" id="dayOffBegin" name="dayOffBegin" size="36px">
								<div id="imgDisable" style="float:right;padding-right:2px"><img src="/ProGate-portlet/images/lmis/viewAttendanceInfo/disable_datepicker.png"></div>
							</div>
							<div style="padding-top:5px;padding-left:25px">
								<span><input type="radio" name="dayOff" checked="yes"><fmt:message key="lmis.dayoff.type.allDate"/></span>
								<span style="margin:0 10px"><input type="radio" name="dayOff"><fmt:message key="lmis.dayoff.type.morning"/></span>
								<span><input type="radio" name="dayOff"><fmt:message key="lmis.dayoff.type.evening"/></span>
							</div>
						</td>
					</tr>
					<tr>
						<td><fmt:message key="lmis.dayoff.reason"/></td>
						<td><div style="padding-top:17px;padding-left:25px"><textarea id="reason" rows="5" cols="31"></textarea></div> </td>
					</tr>
				</table>
			</div>
			<div class="cls-right">
				<table >
					<tr>
						<td><fmt:message key="lmis.dayoff.Type"/></td>
						<td>
							<select>
								<option value="1">Nghi phep thuong nien</option>
								<option value="2">Nghi khong tinh luong</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><div style="margin-top:-10px"><fmt:message key="lmis.dayoff.End"/></div></td>
						<td><div style="padding-top:10px;padding-left:25px">
								<input type="text" id="dayOffEnd" name="dayOffEnd" size="36px" >
								<div id="imgDisable1" style="float:right;padding-right:2px"><img src="/ProGate-portlet/images/lmis/viewAttendanceInfo/disable_datepicker.png"></div>
							</div>
							<div style="padding-top:5px;padding-left:25px">
								<span><input type="radio" name="dayOffEnd" checked="yes"><fmt:message key="lmis.dayoff.type.allDate"/></span>
								<span style="margin:0 10px"><input type="radio" name="dayOffEnd"><fmt:message key="lmis.dayoff.type.morning"/></span>
								<span><input type="radio" name="dayOffEnd"><fmt:message key="lmis.dayoff.type.evening"/></span>
							</div>
						</td>
					</tr>
				</table>
				<div  style="padding-top:10px;">
					<fieldset class="fieldset">
						<legend class="legend"><fmt:message key="lmis.common._review"/></legend>
							<textarea id="review" rows="3" cols="40"></textarea>
					</fieldset>
				</div>
			</div>
		</div>
	</div><!-- End Content -->
</form>