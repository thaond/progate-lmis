<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../../../lmis/validation/validation_changeWorking.jsp" %>
<c:choose>
	<c:when test="${bean.cmd == bean.EDIT}">
		<script type="text/javascript">
			jQuery(document).ready(function() {
			/*show datepicker*/
			jQuery("#datepickerBegin, #datepickerEnd").datepicker({
				showOn: "both",
				buttonImage: "/ProGate-portlet/images/lmis/viewAttendanceInfo/datetime.png",
				buttonImageOnly: true,
				buttonText:'Chọn ngày',
				dateFormat:'dd/mm/yy',
				minDate:'0'
			});
			jQuery(".btnAgree,.btnNotAgree").hide();
			jQuery("#review").attr("disabled","disabled");
			jQuery("#review").html("Phản hồi của người phê duyệt sẽ hiển thị ở đây");
			jQuery(".styleMar1").hide();
		});
		</script>
	</c:when>

	<c:when test="${bean.cmd == bean.ADD }">
		<script type="text/javascript">
			jQuery(document).ready(function(xml) {
				var currentDate= new Date();
				var day = currentDate.getDay();
				var month = currentDate.getMonth()+1;
				var year = currentDate.getFullYear();
				jQuery("#reason").val("");
				/* jQuery("#review").val(""); */
				jQuery("#datepickerBegin, #datepickerEnd").datepicker({
					showOn: "both",
					buttonImage: "/ProGate-portlet/images/lmis/viewAttendanceInfo/datetime.png",
					buttonImageOnly: true,
					buttonText:'Chọn ngày',
					dateFormat:'dd/mm/yy',
					minDate:'1'
				});
				jQuery(".btnAgree,.btnNotAgree").hide();
				jQuery("#review").attr("disabled","disabled");
				jQuery("#review").html("Phản hồi của người phê duyệt sẽ hiển thị ở đây");
				jQuery(".cls-centerDetail").html("Chi Tiết Đơn Xin Thay Đổi Thời Gian Làm Việc Của Bạn");
				jQuery(".styleMar1").hide();
			});
		</script>
	</c:when>
	<c:when test="${bean.cmd == bean.REVIEW}">
		<script type="text/javascript">
			jQuery(document).ready(function() {
				jQuery(".btnSend, .btnCancel,").hide();
				jQuery("#datepickerBegin, #datepickerEnd,#reason").attr("disabled","disabled");		
				jQuery('#tableDaily :input').attr("disabled","disabled");
		});
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			jQuery(document).ready(function() {
				jQuery(".btnSend, .btnCancel, .btnAgree, .btnNotAgree").hide();
				jQuery("#datepickerBegin, #datepickerEnd").attr("disabled","disabled");
				jQuery('#tableDaily :input').attr("disabled","disabled");
				jQuery("textarea").attr("disabled","disabled");
				
			});
		</script>
	</c:otherwise>
</c:choose>
<script type="text/javascript">
	jQuery(function(){
		jQuery("#datepickerBegin, #datepickerEnd").keydown(function(e) {
			if (e.keyCode > 0 ) {
				e.preventDefault();	
			}	
		});
		
		jQuery("input:text").not('#reason, #review').keydown(function(e) {
	    	// Allow only backspace and delete
	    	if ( e.keyCode == 46 || e.keyCode == 8 ) {
	    		// let it happen, don't do anything
	    	}
	    	else {
	    		// Ensure that it is a number and stop the keypress
	    		if (e.keyCode < 48 || e.keyCode > 57 || e.keyCode == 9 || e.keyCode == 37 || e.keyCode == 38 || e.keyCode == 39 ||e.keyCode == 40  ) {
	    			e.preventDefault();
	    		}
	    	}
		});
		jQuery(".btnSend").click(function(e){
			e.preventDefault();
			var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
					<portlet:param name="action" value="changeWorkingTimeDetail" />
					<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.UPDATE%>" />
					<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
					<portlet:param name="<%=Request.TAB_ACT%>" value="<%=Request.TAB_PERSONAL%>" />
					</portlet:renderURL>';
			 var href= '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="action" value="commonController" />
						<portlet:param name="<%=Request.TAB_ACT%>" value="<%=Request.TAB_PERSONAL%>" />
						<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
						</portlet:renderURL>';
			var dateBegin = jQuery('#datepickerBegin').val();
			var dateEnd = jQuery('#datepickerEnd').val();
			var reason = jQuery('#reason').val();
			var monHour = jQuery('#monHour').val();
			var monMin = jQuery('#monMin').val();
			var tueHour = jQuery('#tueHour').val();
			var tueMin = jQuery('#tueMin').val();
			var wedHour = jQuery('#wedHour').val();
			var wedMin = jQuery('#wedMin').val();
			var thuHour = jQuery('#thuHour').val();
			var thuMin = jQuery('#thuMin').val();
			var friHour = jQuery('#friHour').val();
			var friMin = jQuery('#friMin').val();
			var satHour = jQuery('#satHour').val();
			var satMin = jQuery('#satMin').val();
			var currentHander = jQuery('#currentHander').val();
			var selectTimeChangeID = jQuery('#selectTimeChangeID').val();
			
			if(isValidation()){
				 //submit(url);
				 //e.preventDefault();
				loadBackgroud();
				 jQuery.ajax({
					type:'POST',
					url:url,
					data:{
						"dateBegin":dateBegin,
						"dateEnd":dateEnd,
						"reason":reason,
						"monHour":monHour,
						"monMin":monMin,
						"tueHour":tueHour,
						"tueMin":tueMin,
						"wedHour":wedHour,
						"wedMin":wedMin,
						"thuHour":thuHour,
						"thuMin":thuMin,
						"friHour":friHour,
						"friMin":friMin,
						"satHour":satHour,
						"satMin":satMin,
						"currentHander":currentHander,
						"selectTimeChangeID":selectTimeChangeID,
					},
					success:function(){
						jQuery("#backgroundLoading").hide();
						jQuery("#sendSuccess").css("display", "block");
				    	jQuery("#sendSuccess").data('url',href).data('close',close).dialog("open");
				    
				    	/* document.frmChangeWorkingTimeDetail.action=href;
				    	document.frmChangeWorkingTimeDetail.submit(); */
				    	 
				    	
					},
					error:function(){
						jQuery("#sendSuccess").css("display", "block");
				    	jQuery("#sendSuccess").data('url',href).data('close',close).dialog("open");
					}
				 });
				
			}else{
				e.preventDefault();
			}
		});
		jQuery("#undoPer").one('click',function(e){
			var url='<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="action" value="commonController" />
						<portlet:param name="<%=Constants.CMD%>" value="<%=Request.UNDO_HANDER%>" />
						<portlet:param name="<%=Request.TAB_ACT%>" value="<%=Request.TAB_PERSONAL%>" />
					</portlet:renderURL>'
			submit(url);
		});
		jQuery("#undoMa").click(function(e){
			var url='<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="action" value="managerChangeWorkingTime" />
						<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
						<portlet:param name="<%=Constants.CMD%>" value="<%=Request.UNDO_HANDER%>" />
					</portlet:renderURL>'
			submit(url);
		});
		
		jQuery(".btnAgree").click(function(e){
			var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="action" value="managerChangeWorkingTime" />
						<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
						<portlet:param name="<%=Constants.CMD%>" value="<%=Request.AGREE%>" />
					</portlet:renderURL>';
			submit(url);
		});

		jQuery(".btnNotAgree").click(function(e){
			var url='<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="action" value="managerChangeWorkingTime" />
						<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
						<portlet:param name="<%=Constants.CMD%>" value="<%=Request.NOT_AGREE%>" />
					</portlet:renderURL>'
			submit(url);
		});

		jQuery("#daily :input").blur(function(e){
			e.preventDefault;
			var hour = e.currentTarget.parentNode.getElementsByTagName("input")[0].value;
			var min = e.currentTarget.parentNode.getElementsByTagName("input")[1].value;
			if(hour > 24 || hour ==''){
				jQuery(this).val(08);
				hour = e.currentTarget.parentNode.getElementsByTagName("input")[0].value;
			}
			if(min > 59 || min=='' ){
				jQuery(this).val(00);
				min = e.currentTarget.parentNode.getElementsByTagName("input")[1].value;
			}
			addHour = parseFloat(hour)+9;
			addMin = parseFloat(min)+30;
			if(addMin >= 60){
				addHour = addHour + parseInt(addMin/60);
				addMin = addMin%60;
			}
			if(addHour >=24){
				addHour = addHour%24;
			}
			if(addMin <10){
				var hourStr = addHour + ":0" + addMin;
			}else{
				var hourStr = addHour + ":" + addMin;
			}
			jQuery(this).parent().parent().find("td:eq(2)").html(hourStr);
		});
	});

	function submit(url){
		document.frmChangeWorkingTimeDetail.action=url;
		document.frmChangeWorkingTimeDetail.submit();
	}
	function loadBackgroud(){
		jQuery("#backgroundLoading").css({
				"opacity": "0.7"
			});
		jQuery("#backgroundLoading").fadeIn("slow");
	}
</script>
<jsp:include page="../../dialog/dialog-sendSuccess.jsp"></jsp:include>	
	<!-- Detail -->
<form action="" name="frmChangeWorkingTimeDetail" id="frmChangeWorkingTimeDetail" method="post">
	<c:choose>	
	<c:when test="${bean.tabAction == bean.TAB_PERSONAL}">
	    <div class="undo" id="undoPer">
	    	<input id="undo" type="image" src="/ProGate-portlet/images/lmis/undo.png">
	    	<a id="_undo" href="#"><fmt:message key="lmis.common.back" /></a>
	    </div>
	</c:when>
	<c:when test="${bean.tabAction == bean.TAB_MANAGER}">
		<div class="undo" id="undoMa">
	    	<input id="undo" type="image" src="/ProGate-portlet/images/lmis/undo.png">
	    	<a id="_undo" href="#"><fmt:message key="lmis.common.back" /></a>
	    </div>
	</c:when>
    </c:choose>
	<div class="content">
		<div class="cls-centerDetail">Chi Tiết Đơn Xin Thay Đổi Thời Gian Làm Việc Của ${functions:getFullName(bean.timeChangeDetail.requestedBy)}</div>
		<div style="padding-left:10px;padding-top:10px"><label style="color:red"><fmt:message key="lmis.common.requiredField" /></label></div>
		<div class="contentDetail">
			<div style="padding-top:20px;padding-left:10px">
				<label>Ngày tạo đơn</label>
				<c:choose>
					<c:when test="${bean.cmd==bean.ADD }">
						<input type="text" id="dateCreateForm" disabled="disabled" name="dateCreateForm"
						value="<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.dateCurrent}" />" />
					</c:when>
					<c:otherwise>
						<input type="text" id="dateCreateForm" disabled="disabled" name="dateCreateForm"
						value="<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.timeChangeDetail.createdAt}" />" />
					</c:otherwise>
				</c:choose>
			</div>
			<div>
				<div style="padding-top:10px;float:left;padding-left:10px;">
					<label><fmt:message key="lmis.changetime.beginday" /> </label>
					<c:choose>
						<c:when test="${bean.cmd==bean.ADD }">
							<input type="text" id="datepickerBegin" style="width:80px;margin-left:10px;" name="dateBegin"
								value="<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.dateCurrent}" />" />
						</c:when>
						<c:otherwise>
							<input type="text" id="datepickerBegin" style="width:80px;margin-left:10px;" name="dateBegin"
							value="<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.timeChangeDetail.startDate}" />" />
						</c:otherwise>
					</c:choose>
					<div  class="styleMar1"><img src="/ProGate-portlet/images/lmis/viewAttendanceInfo/disable_datepicker.png"></div>
				</div>
				<div style="padding-top:10px;float:left;padding-left:1.6em">
					<label><fmt:message key="lmis.changetime.endday" /> </label>
					<c:choose>
						<c:when test="${bean.cmd==bean.ADD }">
							<input type="text" id="datepickerEnd" style="width:80px;margin-left:10px;" name="dateEnd"
								value="<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.dateCurrent}" />" />
						</c:when>
						<c:otherwise>
							<input type="text" id="datepickerEnd" style="width:80px;margin-left:10px;" name="dateEnd"
								value="<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.timeChangeDetail.endDate}" />" />
						</c:otherwise>
					</c:choose>					
					<div  class="styleMar1"><img src="/ProGate-portlet/images/lmis/viewAttendanceInfo/disable_datepicker.png"></div>
				</div>
			</div>
			<div class="clear"> </div>
			<div style="padding-top:1px;padding-left:10px;">
				<label id="errorDate" class="hiddenMessage"></label>
			</div>
			<div>
					<label style="padding-left:46.3em;margin-bottom:-0.9em" id="errorReason" class="hiddenMessage"><fmt:message key="warning.tc.reason.empty" /></label>
			</div>
			<div><label id="errorDaily" class="hiddenMessage"></label></div>
			<div id="daily" style="width:48%">
			<input type="hidden" name="selectID" value="${bean.selectID }" />
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
							<c:choose>
								<c:when test="${bean.cmd == bean.ADD}">
									<td>
										<input id="monHour" type="text" width="20px" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											name="monHour" value="${functions:getHour(bean.startTime)}" />
										<label>:</label>
										<input id="monMin" type="text" width="20px"  name="monMin" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											value="${functions:getMin(bean.startTime)}" />
									</td>
									<td id="endMonTimeNew"><font id="selectdesc" size="2"></font><fmt:formatDate pattern="HH:mm" value="${bean.endTime}" /></td>
								</c:when>
								<c:otherwise>
									<td>
										<input id="monHour" type="text" width="20px" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											name="monHour" value="${functions:getHour(bean.timeChangeDetail.monStartTime)}" />
										<label>:</label>
										<input id="monMin" type="text" width="20px"  name="monMin" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											value="${functions:getMin(bean.timeChangeDetail.monStartTime)}" />
									</td>
									<td id="endMonTimeNew"><fmt:formatDate pattern="HH:mm" value="${bean.timeChangeDetail.monEndTime}" /></td>
								</c:otherwise>
							</c:choose>
						</tr>
						<tr class="evenrow">
							<td>3</td>
							<c:choose>
								<c:when test="${bean.cmd == bean.ADD}">
									<td>
										<input id="tueHour" type="text" width="20px" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											name="tueHour" value="${functions:getHour(bean.startTime)}" />
										<label>:</label>
										<input id="tueMin" type="text" width="20px"  name="tueMin" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											value="${functions:getMin(bean.startTime)}" />
									</td>
									<td id="endTueTimeNew"><fmt:formatDate pattern="HH:mm" value="${bean.endTime}" /></td>
								</c:when>
								<c:otherwise>
									<td>
										<input id="tueHour" type="text" width="20px" name="tueHour" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											value="${functions:getHour(bean.timeChangeDetail.tueStartTime)}" />
										<label>:</label>
										<input id="tueMin" type="text" width="20px"  name="tueMin" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											value="${functions:getMin(bean.timeChangeDetail.tueStartTime)}" />
									</td>
									<td id="endTueTimeNew"><fmt:formatDate pattern="HH:mm" value="${bean.timeChangeDetail.tueEndTime}" /></td>
								</c:otherwise>
							</c:choose>
						</tr>
						<tr class="oddrow">
							<td>4</td>
							<c:choose>
								<c:when test="${bean.cmd == bean.ADD}">
									<td>
										<input id="wedHour" type="text" width="20px" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											name="wedHour" value="${functions:getHour(bean.startTime)}" />
										<label>:</label>
										<input id="wedMin" type="text" width="20px"  name="wedMin" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											value="${functions:getMin(bean.startTime)}" />
									</td>
									<td id="endWedTimeNew"><fmt:formatDate pattern="HH:mm" value="${bean.endTime}" /></td>
								</c:when>
								<c:otherwise>
									<td>
										<input id="wedHour" type="text" width="20px" name="wedHour" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											value="${functions:getHour(bean.timeChangeDetail.wedStartTime)}" />
										<label>:</label>
										<input id="wedMin" type="text" width="20px"  name="wedMin" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											value="${functions:getMin(bean.timeChangeDetail.wedStartTime)}" />
									</td>
									<td id="endWedTimeNew"><fmt:formatDate pattern="HH:mm" value="${bean.timeChangeDetail.wedEndTime}" /></td>
								</c:otherwise>
							</c:choose>
						</tr>
						<tr class="evenrow">
							<td>5</td>
							<c:choose>
								<c:when test="${bean.cmd == bean.ADD}">
									<td>
										<input id="thuHour" type="text" width="20px" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											name="thuHour" value="${functions:getHour(bean.startTime)}" />
										<label>:</label>
										<input id="thuMin" type="text" width="20px"  name="thuMin" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											value="${functions:getMin(bean.startTime)}" />
									</td>
									<td id="endThuTimeNew"><fmt:formatDate pattern="HH:mm" value="${bean.endTime}" /></td>
								</c:when>
								<c:otherwise>
									<td>
										<input id="thuHour" type="text" width="20px" name="thuHour" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											value="${functions:getHour(bean.timeChangeDetail.thuStartTime)}" />
										<label>:</label>
										<input id="thuMin" type="text" width="20px" name="thuMin" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											value="${functions:getMin(bean.timeChangeDetail.thuStartTime)}" />
									</td>
									<td id="endThuTimeNew"><fmt:formatDate pattern="HH:mm" value="${bean.timeChangeDetail.thuEndTime}" /></td>
									</c:otherwise>
								</c:choose>
						</tr>
						<tr class="oddrow">
							<td>6</td>
							<c:choose>
								<c:when test="${bean.cmd == bean.ADD}">
									<td>
										<input id="friHour" type="text" width="20px" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											name="friHour" value="${functions:getHour(bean.startTime)}" />
										<label>:</label>
										<input id="friMin" type="text" width="20px"  name="friMin" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											value="${functions:getMin(bean.startTime)}" />
									</td>
									<td id="endFriTimeNew"><fmt:formatDate pattern="HH:mm" value="${bean.endTime}" /></td>
								</c:when>
								<c:otherwise>
									<td>
										<input id="friHour" type="text" width="20px" name="friHour" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											value="${functions:getHour(bean.timeChangeDetail.friStartTime)}" />
										<label>:</label>
										<input id="friMin" type="text" width="20px" name="friMin" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											value="${functions:getMin(bean.timeChangeDetail.friStartTime)}" />
									</td>
									<td id="endFriTimeNew"><fmt:formatDate pattern="HH:mm" value="${bean.timeChangeDetail.friEndTime}" /></td>
								</c:otherwise>
							</c:choose>
						</tr>
						<tr class="evenrow">
							<td>7</td>
							<c:choose>
								<c:when test="${bean.cmd == bean.ADD}">
									<td>
										<input id="satHour" type="text" width="20px" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											name="satHour" value="${functions:getHour(bean.startTime)}" />
										<label>:</label>
										<input id="satMin" type="text" width="20px"  name="satMin" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											value="${functions:getMin(bean.startTime)}" />
									</td>
									<td id="endSatTimeNew"><fmt:formatDate pattern="HH:mm" value="${bean.endTime}" /></td>
								</c:when>
								<c:otherwise>
									<td>
										<input id="satHour" type="text" width="20px" name="satHour" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											value="${functions:getHour(bean.timeChangeDetail.satStartTime)}" />
										<label>:</label>
										<input id="satMin" type="text" width="20px"	name="satMin" maxlength="2" onkeyup="javascript:this.value=this.value.replace(/[^0-9]/g, '');"
											value="${functions:getMin(bean.timeChangeDetail.satStartTime)}" />
									</td>
									<td id="endSatTimeNew"><fmt:formatDate pattern="HH:mm" value="${bean.timeChangeDetail.satEndTime}" /></td>
								</c:otherwise>
							</c:choose>
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
						<textarea id="review" name="review" style="width:390px;height:75px">
							<c:out value="${bean.contentApproval}"></c:out>
						</textarea>
						<!-- <script type="text/javascript">
							jQuery(document).ready(function(){
								jQuery('#review').html('${bean.contentApproval}');
							});
						</script> -->
				</fieldset>
				</div>
			</div>
		</div><!--End content detail-->
	</div><!--End content-->
	<div class="button">
		<input type="submit" value='<fmt:message key="button.reset" />' class="btnCancel" />
		<input type="submit" value='<fmt:message key="button.sendform" />' class="btnSend" />
		<input type="button" value='<fmt:message key="button.agree" />'class="btnAgree" />
		<input type="button" value='<fmt:message key="button.notagree" />'class="btnNotAgree" />
	</div>
	<input  type="hidden" name="<%=Request.CURRENT_CHANGE_TIME_ID %>" value="${bean.currentID }" id="currentId" />
	<input  type="hidden" name="<%=Request.CURRENT_HANDER %>" value="${bean.cmd }" id="currentHander"/>
	<input type="hidden" name="<%=Request.ORG_ID %>" value="${bean.orgId }" />
	<input type="hidden" name="<%=Request.SELECTED_ID%>" value="${bean.selectedID }" id="selectTimeChangeID" />
</form>
<div id="backgroundLoading" >
	<div id="imgLoad">
	<img  src="/ProGate-portlet/images/lmis/loader.gif" />
	</div>
</div>