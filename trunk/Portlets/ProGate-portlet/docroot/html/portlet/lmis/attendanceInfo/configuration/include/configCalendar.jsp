<%@page import="com.larion.progate.lmis.constants.Configuration_RS"%>
<%@ include file="../../../../common/init.jsp"%>
<%@ include file="../../../../lmis/initOfConfig.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">

function pagingSubmit(){ 
	jQuery("#frmConfigCalendar").submit();
}

jQuery(function() {
		
		/*show datepicker*/
		jQuery("#dateTime").datepicker({
			showOn: "both",
			buttonImage: "/ProGate-portlet/images/lmis/configAttendanceInfo/datetime.png",
			buttonImageOnly: true,
			buttonText:"Chọn ngày",
			minDate: '1',
			dateFormat:'dd/mm/yy'
		});
		
		jQuery('#save').click(function(){			
			addCalendar();
			});

	jQuery(".deleteCalendar").bind('click',function(e){
		e.preventDefault();
		var id=e.currentTarget.parentNode.getElementsByTagName("input")[1].value;
		deleteCalendar(id);
		});
			
			
});
		
jQuery(document).ready(function(){
	jQuery("#view").bind('click',function(){
		mySelect();
	});
	
	jQuery("#dateTime").keydown(function(e) {
		if (e.keyCode > 0 ) {
			e.preventDefault();
		}
	});
});		

function mySelect()
{
	
	var url='<portlet:renderURL >
		<portlet:param name="action" value="configuration" />
		<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.CALENDAR_TAB%>" />
		<portlet:param name="orgId" value="${bean.orgId}" />
		</portlet:renderURL>';
		document.frmConfigCalendar.action=url;
		document.frmConfigCalendar.submit();
}

function deleteCalendar(id)
{
	var url='<portlet:renderURL >
		<portlet:param name="action" value="configuration" />
		<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.CALENDAR_TAB%>" />
		<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.DELETE%>" />
		<portlet:param name="<%=Configuration_RS.CALENDAR_ID %>" value="ID_lmisWorkingCalendar" />
		<portlet:param name="orgId" value="${bean.orgId}" />
		</portlet:renderURL>';
		url = url.replace('ID_lmisWorkingCalendar',id);
		document.frmConfigCalendar.action=url;
		document.frmConfigCalendar.submit();
}
function addCalendar()
{
	var url='<portlet:renderURL  >
		<portlet:param name="action" value="configuration" />
		<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.CALENDAR_TAB%>" />
		<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.ADD%>" />
		<portlet:param name="orgId" value="${bean.orgId}" />
		</portlet:renderURL>';
		
		var dateTime = jQuery('#dateTime').val();
		var description = jQuery('#description').val();
		var selectHoliday = jQuery('#selectHoliday').val();
		
		jQuery.ajax({
			type: "POST",
			url : url,
			data : {
				'dateTime': dateTime,
				'description': description,
				'selectHoliday': selectHoliday
			},
			success: function(){
				var href='<portlet:renderURL>
					<portlet:param name="action" value="commonController" />
				<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.CALENDAR_TAB%>" />
				<portlet:param name="orgId" value="${bean.orgId}" />
				</portlet:renderURL>';
				
				jQuery(".successful").css("display", "block");
			    	jQuery(".successful").data('url',href).data('close',close).dialog("open");
			},
			error: function(){
				alert("Có lỗi xảy ra khi lưu cấu hình lịch làm việc!");
			}
		});
}


</script>

		<form name="frmConfigCalendar" id="frmConfigCalendar" action=""	method="post">
			<div class="contentConfigCalendar">
				<div id="filter">
					<div class="month-of-calendar" align="left">
						<label style="padding-left: 0px;"><fmt:message
								key="lmis.common.month" /> </label> <select name="<%=Configuration_RS.SELECT_MONTH %>"
							id="slt-month">

							<c:forEach begin="1" end="12" var="month">
								<c:choose>
									<c:when test="${month == bean.selectedMonth}">
										<option value="${month}" selected="selected">
										<c:choose>
											<c:when test="${month < 10}">
												<c:out value='0'/><c:out value='${month}' />
											</c:when>
											<c:otherwise>
												<c:out value='${month}' />
											</c:otherwise>
										</c:choose>
										</option>
									</c:when>
									<c:otherwise>
										<option value="${month}">
											<c:choose>
												<c:when test="${month < 10}">
													<c:out value='0'/><c:out value='${month}' />
												</c:when>
												<c:otherwise>
													<c:out value='${month}' />
												</c:otherwise>
											</c:choose>
										</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
					<div class="year-of-calendar" align="left">
						<label style="padding-left: 20px;"><fmt:message key="lmis.common.year" /> 
						</label> <input style="width: 44px; height: 22px; text-align: right;" name="<%=Configuration_RS.SELECT_YEAR%>" value="${bean.currentYearSelected}" />
					</div>
					<div class="view-of-calendar" align="left">
						<input type="submit" id="view" value="Xem"/>
					</div>
				</div>
				<div class="div-of-table-content">
					<div class="table-content">
						<table width="100%">
							<thead class="tbl-header">
								<tr>
									<th scope="col" width="4%" height="0"><fmt:message	key="lmis.common.number" /></th>
									<th scope="col" width="13%" height="0"><fmt:message	key="lmis.common.day" /></th>
									<th scope="col" width="10%" height="0"><fmt:message	key="lmis.common.dayOfWeek" /></th>
									<th scope="col" width="26%" height="0"><fmt:message	key="lmis.config.calendar.dayType" /></th>
									<th scope="col" width="42%" height="0"><fmt:message	key="lmis.common.noteUpper" /></th>
									<th scope="col" width="5%" height="0"><fmt:message	key="lmis.common.delete" /></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="lmisCalendar" items="${bean.lmisViewWorkingCalendar}" varStatus="itemCount">
									<c:choose>
										<c:when test="${itemCount.count % 2 !=0 }">
											<tr class="oddrow">
										</c:when>
										<c:otherwise>
											<tr class="evenrow">
										</c:otherwise>
									</c:choose>
									<td align="center"><c:out value="${itemCount.count}" />
									</td>
									<td align="center"><fmt:formatDate value="${lmisCalendar.dayValue}" pattern="dd/MM/yyyy" /></td>
									<td align="center">${functions:getDayOfWeek(lmisCalendar.dayValue)}</td>
									<td align="left" style="text-indent:10px">${lmisCalendar.name}</td>
									<td style="text-indent:10px"><c:out value='${lmisCalendar.description}'/></td>
									<td align="center"><a id="editCalendar" href="#">
									<c:choose>
									<c:when test="${functions:isFutureDay(lmisCalendar.dayValue)==true}">
										<input type="image"	src="/ProGate-portlet/images/lmis/configAttendanceInfo/Xoa.png" class="deleteCalendar" />
									</c:when>
									<c:otherwise>
										<input type="image"	src="/ProGate-portlet/images/lmis/configAttendanceInfo/Disable_Delete.png" disabled="disabled" />
									</c:otherwise>		
									</c:choose>
											<input type="hidden" value="${lmisCalendar.lmisViewWorkingCalendarId}" /> </a>
									</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="lmis-paging" style="padding-top: 10px"> 
							<c:set value="${bean.pagination}" var="paging"></c:set> 
							<%@ include file="/html/portlet/common/pagination.jsp" %>  
						</div>
					</div>
				</div>
			</div>
			<div class="content-of-add-holiday">
				<fieldset class="addMoreHoliday">
					<legend>
						<fmt:message key="lmis.config.calendar.addMoreHoliday" />
					</legend>
					<div class="warning">
						<fmt:message key="lmis.common.requiredField" />
					</div>
					<div>
						<table>
							<tr height="20px">
								<td><fmt:message key="lmis.config.calendar.dayTypeLower" />
								</td>
								<td width="180px" style="padding-left: 5px">
								<select id="selectHoliday" name="<%=Configuration_RS.SELECT_HOLIDAY %>" style="width: 146px">
										<option value="1">
											<fmt:message key="lmis.config.calendar.dayOff" />
										</option>
										<option value="2">
											<fmt:message key="lmis.config.calendar.holiday" />
										</option>
								</select>
								</td>
								<td width="50px" style="padding-left: 20px"><fmt:message key="lmis.common.note" />
								</td>
								<td width="155" rowspan="2"><textarea id="description" name="<%=Configuration_RS.DESCRIPTION%>" style="width: 265px; height: 60px" id="note"></textarea></td>
							</tr>
							<tr height="20px">
								<td><fmt:message key="lmis.common.day" /> (<label class="warning">*</label>)</td>
								<td width="180px" style="padding-left: 5px;"><input name="<%=Configuration_RS.DATE_TIME %>"
									id="dateTime" type="text" style="width: 120px;" /></td>
								<td>&nbsp;</td>
							</tr>
						</table>
					</div>
				</fieldset>
				<div align="center"
					style="padding-top: 10px; padding-bottom: 0px; clear: both; margin-bottom: -10px">
					<input class="button-enable" id="save" type="button" value='<fmt:message key="button.save"/>'/> 
					<input class="button-enable" id="cancel" type="reset"	value='<fmt:message key="button.cancel" />'  />
				</div>
			</div>
		</form>
<jsp:include page="../../../dialog/dialog-configCalendarSuccess.jsp"/>