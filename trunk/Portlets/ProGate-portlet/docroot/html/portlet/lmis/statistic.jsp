<%@ include file="grid/grid.jsp" %>
<%@ include file="init-tvna.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">
		jQuery(function (){
			jQuery('#proid1').reportprogress(${bean.percenDayOffYear});
			jQuery('#proid2').reportprogress(${bean.percenDayOffOT});
			jQuery('#proid3').reportprogress(${bean.percendayOffLastYear});
		});
</script>
<div class="wrapper" style="height:450px;">
	<div class="header">
		<div id="title">
			 <b><fmt:message key="lmis.common.stat" /></b>
		</div>
	</div>
	<div class="clear"></div>
	<div class="statt">
		<div class="statt-left">
			<fieldset class="fset" style="height: 107px;">
					<legend>Thông tin trong tháng</legend>
				<div style="float:left">
					<img src="/ProGate-portlet/images/lmis/Warning.png" width="64px" height="64px" />
				</div>
				<div style="float:right" style="widht:50%">
				<table style="width:230px">
					<thead style="height: 10px;">
						<tr>
							<th scope="row" width="60%"></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><fmt:message key="lmis.stt.war.late" /></td>
							<td><span style="color: red; font-weight: bold;">${bean.lateMonthStartTime} giờ</span></td>
						</tr>
						<tr>
							<td><fmt:message key="lmis.stt.war.soon" /></td>
							<td><span style="color: red; font-weight: bold;">${bean.earlyMonthEndTime} giờ</span></td>
						</tr>
						<tr>
							<td><fmt:message key="lmis.stt.war.dayoff" /></td>
							<td><span style="color: red; font-weight: bold;">${bean.totalDayOffNotPermission} <fmt:message key="lmis.stt.day" /></span></td>
						</tr>
					</tbody>
				</table>
				</div>
				<div class="clear"></div>
				<c:choose><c:when test="${bean.dayMax != null}">
				<fmt:message key="lmis.reqtime" /><fmt:message key="lmis.stt.day"/>&nbsp;${bean.dayMax}
				</c:when> </c:choose>
			</fieldset>
			<br/>
			<div class="prosessBarP" >
				<fieldset class="fset">
					<legend><fmt:message key="lmis.stt.day.title" /></legend>
					<div >
						<div style="height: 10px;width: 100%"></div>
						<label class="stt"> <fmt:message key="lmis.stt.mon.dayoff"><fmt:param>${bean.dayOffYearRemain }</fmt:param><fmt:param>${bean.dayOffYear }</fmt:param> </fmt:message>
						</label><div style="height: 8px;width: 100%"></div>
						<div id="proid1" name="progress" class="progressbarPhat"></div>
					</div>
					<div style="height: 8px;width: 100%;margin-top:8px"></div>
					<div style="margin-top:10px;margin-bottom:10px">
						<label class="stt"> <fmt:message key="lmis.stt.mon.ot"><fmt:param>${bean.dayOffOTRemain }</fmt:param><fmt:param>${bean.dayOffOT }</fmt:param> </fmt:message>
						</label><div style="height: 8px;width: 100%"></div>
						<div id="proid2" name="progress" class="progressbarPhat"></div>
					</div>
					<div style="height: 8px;width: 100%;margin-top:20px"></div>
					<div >
						<label class="stt"> <fmt:message key="lmis.stt.mon.preyear"><fmt:param>${bean.dayOffLastYearRemain }</fmt:param><fmt:param>${bean.dayOffLastYear }</fmt:param> </fmt:message>
						</label><div style="height: 8px;width: 100%"></div>
						<div id="proid3" name="progress" class="progressbarPhat"></div>
					</div>
				</fieldset>
			</div>
		</div>
		<div class="statt-right">
			<div class="tableContainer" style="height:auto;margin-top:0;margin-bottom:10px;">
				<table width="100%" cellspacing="0"">
					<thead>
						<tr class="stt-header">
							<th width="80%" scope="col"><fmt:message key="lmis.attendanceInfo.title" /> </th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="cls-left"><fmt:message key="lmis.stt.att.begin" /></td>
							<td class="cls-stt-right"><fmt:formatDate pattern="HH:mm" value="${bean.realStartTime}" /></td>
						</tr>
						<tr>
							<td class="cls-left"><fmt:message key="lmis.stt.att.late" /></td>
							<td class="cls-stt-right"><span style="color:red">${bean.lateStartTime}</span></td>
						</tr>
						<tr>
							<td class="cls-left"><fmt:message key="lmis.stt.att.yer" /></td>
							<td class="cls-stt-right"><fmt:formatDate pattern="HH:mm" value="${bean.realEndTime}" /></td>
						</tr>
						<tr>
							<td class="cls-left"><fmt:message key="lmis.stt.att.yersoo" /></td>
							<td class="cls-stt-right"><span style="color:red">${bean.earlyEndTime}</span></td>
						</tr>
					</tbody>
				</table>
			</div>
			<br />
			<div class="tableContainer" style="height:auto;margin-top:0;margin-bottom:10px;">
				<table width="100%" cellspacing="0">
						<thead>
							<tr class="stt-header">
								<th width="80%" scope="col"><fmt:message key="lmis.dayoff.title" /> </th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="cls-left"><fmt:message key="lmis.stt.dayoff.total" /></td>
								<td class="cls-stt-right">${bean.totalDayOff }</td>
							</tr>
							<tr>
								<td class="cls-left"><fmt:message key="lmis.stt.dayoff.per" /></td>
								<td class="cls-stt-right">${bean.totalDayOffPermission }</td>
							</tr>
							<tr>
								<td class="cls-left"><fmt:message key="lmis.stt.dayoff.nper" /></td>
								<td class="cls-stt-right">${bean.totalDayOffNotPermission }</td>
							</tr>

						</tbody>
					</table>
			</div>
			<br />
			<div class="tableContainer" style="height:auto;margin-top:0;margin-bottom:10px;">
				<table width="100%" cellspacing="0">
					<thead>
						<tr class="stt-header">
							<th width="80%" scope="col"><fmt:message key="lmis.ot.info" /> </th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="cls-left"><fmt:message key="lmis.stt.ot.hour" /></td>
							<td class="cls-stt-right"><span style="color:green">${bean.yesterdayOT }</span></td>
						</tr>
					</tbody>
				</table>
			</div>

		</div>
		<div class="clear-both"></div>
	</div>
</div>