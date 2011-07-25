<%@ include file="../../../lmis/grid/grid.jsp" %>
<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ include file="../../../lmis/validation/validation_dayOff.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<c:if test="${bean.tabAction == bean.TAB_MANAGER }">
	<script type="text/javascript">
			jQuery(document).ready(function(){
				jQuery("#edit, #cancel").hide();				
			});
	</script>
	<c:choose>
		<c:when test="${bean.cmd == bean.REVIEW }">
			<script type="text/javascript">
				jQuery(document).ready(function(){
					jQuery("#btnReview").hide();
				});
			</script>
		</c:when>
	</c:choose>
</c:if>
<c:if test="${bean.tabAction == bean.TAB_PERSONAL }">
	<script type="text/javascript">
		jQuery(document).ready(function(){
			jQuery("#btnReview,#infoDayOff").hide();
		});
	</script>
</c:if>
<c:if test="${bean.tabAction == bean.TAB_OTHER}">
	<script type="text/javascript">
		jQuery(document).ready(function(){
			jQuery("#btnReview,#edit,#cancel").hide();
		});
	</script>
</c:if>
<c:choose>
	<c:when test="${bean.cmd == bean.VIEW || bean.cmd == bean.REVIEW }">
		<script type="text/javascript">
			jQuery(document).ready(function() {
					jQuery(".btnSend, .btnCancel, .btnAgree, .btnNotAgree,#reviewNext_").hide();
					jQuery("#dayOffBegin, #dayOffEnd").attr("disabled","disabled");
					jQuery("textarea").attr("disabled","disabled");
					jQuery('.contentDetail :input').attr("disabled","disabled");
					//jQuery('#review').html("Phản hồi của người phê duyệt sẽ hiển thị ở đây");
					if(${bean.absenceDetail.requestedStatus != 1}){
						jQuery("#btnReview").hide();
					}
				});
		</script>
		<c:choose>
			<c:when test="${bean.cmd == bean.REVIEW }">
				<script type="text/javascript">
					jQuery(document).ready(function() {
						jQuery("#review").removeAttr("disabled","disabled");
						jQuery(".btnAgree, .btnNotAgree,#reviewNext_").css('display','inline');
						jQuery("#btnReview").hide();
				});
				</script>
			</c:when>
		</c:choose>
	</c:when>
	<c:when test="${bean.cmd == bean.EDIT || bean.cmd == bean.ADD }">
		<script type="text/javascript">
			jQuery(document).ready(function() {
				jQuery("#dayOffBegin,#dayOffEnd").datepicker({
					showOn: "both",
					buttonImage: "/ProGate-portlet/images/lmis/viewAttendanceInfo/datetime.png",
					buttonImageOnly: true,
					buttonText:'Chọn ngày',
					dateFormat:'dd/mm/yy',
					minDate: '0'
				});
				jQuery("#review").attr("disabled","disabled");
				jQuery("#review").html("Phản hồi của người phê duyệt sẽ hiển thị ở đây ");
				jQuery("#imgDisable,#imgDisable1,#edit,.btnAgree,.btnNotAgree,#reviewNext_").hide();
			});
		</script>
		<c:choose>
			<c:when test="${bean.cmd == bean.ADD }">
				<script type="text/javascript">
					jQuery(document).ready(function(){
						var date = '<fmt:formatDate pattern="dd/MM/yyyy"	value="${bean.date }"/>';			
						jQuery("#cancel").hide();
						jQuery("#dateCreate").val(date);
						jQuery("#dayOffBegin").val(date);
						jQuery("#dayOffEnd").val(date);
						jQuery('input[name="dayOffBeginRadio"]')[0].checked = true;
						jQuery('input[name="dayOffEndRadio"]')[0].checked = true;
						jQuery("#reason").val("");
						jQuery(".cls-centerDetail").html("Chi Tiết Đơn Xin Nghỉ Phép Của Bạn");
						/* jQuery("#review").val(""); */
					});
				</script>
			</c:when>
		</c:choose>
	</c:when>
</c:choose>


<script type="text/javascript">
			jQuery(document).ready(function(){
				if(${bean.absenceDetail.startSession == 1}){
					jQuery("#absenceAll").attr("checked",true);
				}else if(${bean.absenceDetail.startSession == 2}){
					jQuery("#absenceMorning").attr("checked",true);
				}else if(${bean.absenceDetail.startSession == 3}){
					jQuery("#absenceEvening").attr("checked",true);
				}
				if(${bean.absenceDetail.endSession == 1}){
					jQuery("#absenceAll_").attr("checked",true);
				}else if(${bean.absenceDetail.endSession == 2}){
					jQuery("#absenceMorning_").attr("checked",true);
				}else if(${bean.absenceDetail.endSession == 3}){
					jQuery("#absenceEvening_").attr("checked",true);
				}
				if(${bean.absenceDetail.requestedStatus != 1}){
					jQuery("#edit,#cancel").hide();
				}
			});
			jQuery(function(){
				jQuery("#dayOffBegin,#dayOffEnd").keydown(function(e) {
					if (e.keyCode > 0 || e.keyCode == 9 ) {
						e.preventDefault();	
					}	
				});
			 	/* jQuery("input[@name='dayOffEnd']").change(function(){
					var dayOffBegin = jQuery("#dayOffBegin").val();
					var dayOffEnd = jQuery("#dayOffEnd").val();
					jQuery("#absenceMorning_, #absenceEvening_,#absenceAll_").removeAttr("disabled");
					if(isDateGreater(dayOffEnd,dayOffBegin)){
						jQuery("#absenceEvening_").attr("disabled","disabled");	
						jQuery("input[@name='dayOffEndRadio']")[0].checked = true;
					}
				});  */
				jQuery("input[@name='dayOffBeginRadio'],input[@name='dayOffEnd']").change(function(){
					var dayOffBegin = jQuery("#dayOffBegin").val();
					var dayOffEnd = jQuery("#dayOffEnd").val();
					jQuery("#absenceMorning_, #absenceEvening_,#absenceAll_").removeAttr("disabled");
					if(!isDateGreater(dayOffBegin,dayOffEnd) && !isDateGreater(dayOffEnd,dayOffBegin)){
						if(jQuery("input[@name='dayOffBeginRadio']:checked").val()== 1){
							jQuery("input[@name='dayOffEndRadio']")[1].checked = true;
							jQuery("#absenceAll_, #absenceEvening_").attr("disabled","disabled");
						}
						else if(jQuery("input[@name='dayOffBeginRadio']:checked").val()== 2){
							jQuery("input[@name='dayOffEndRadio']")[2].checked = true;
							jQuery("#absenceAll_, #absenceMorning_").attr("disabled","disabled");
						}
						else if (jQuery("input[@name='dayOffBeginRadio']:checked").val()== 3){
							jQuery("input[@name='dayOffEndRadio']")[0].checked = true;
							jQuery("#absenceEvening_, #absenceMorning_").attr("disabled","disabled");
						}
					}
					/* if(isDateGreater(dayOffEnd,dayOffBegin)){
						if(jQuery("input[@name='dayOffBeginRadio']:checked").val()== 1 || jQuery("input[@name='dayOffBeginRadio']:checked").val()== 3 ){
							jQuery("#absenceEvening_").attr("disabled","disabled");
						} 
						else if (jQuery("input[@name='dayOffBeginRadio']:checked").val()== 2 ){
							jQuery("input[@name='dayOffEndRadio']")[1].checked = true;
							jQuery("#absenceAll_,#absenceEvening_").attr("disabled","disabled");
							jQuery("#dayOffEnd").attr("value",dayOffBegin);
						}
					} */
				});
				
				
				jQuery("#edit").click(function(e){
					e.preventDefault();
					jQuery("#dayOffBegin,#dayOffEnd").datepicker({
						showOn: "both",
						buttonImage: "/ProGate-portlet/images/lmis/viewAttendanceInfo/datetime.png",
						buttonImageOnly: true,
						buttonText:'Chọn ngày',
						dateFormat:'dd/mm/yy',
						minDate: '0'
					});
					jQuery(".btnSend, .btnCancel").css('display','inline');
					jQuery("#dayOffBegin, #dayOffEnd, #reason").removeAttr("disabled");
					jQuery('.contentDetail :input').removeAttr("disabled","disabled");
					jQuery("#dateCreate,#review").attr("disabled","disabled");
					jQuery("#imgDisable,#imgDisable1,#edit").hide();
				});
				
				jQuery("#btnReview").click(function(e){
					jQuery("#review").removeAttr("disabled","disabled");
					jQuery(".btnAgree, .btnNotAgree,#reviewNext_").css('display','inline');
					jQuery("#btnReview").hide();
				});
				
				jQuery(".undo").click(function(e){
					if(${bean.tabAction == bean.TAB_PERSONAL}){
						undoPer();
					}else if(${bean.tabAction == bean.TAB_MANAGER}){
						undoMa();
					}else if(${bean.tabAction == bean.TAB_OTHER}){
						undoOther();
					}
				});
				
				jQuery("#cancel").click(function(e){
					var id= jQuery("#selectedId").val();
					var url='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
								<portlet:param name="action" value="managerDayOffInfo" />
								<portlet:param name="<%=Request.SELECTED_ID%>" value='id_changetime' />
								<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
								<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>"/>
								<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.DELETE%>"/>
							</portlet:renderURL>';
					var href ='<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
								<portlet:param name="action" value="commonController" />
								<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
								<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>"/>
								</portlet:renderURL>';
					url = url.replace('id_changetime',id);
					jQuery("#deleteComfirm").css("display", "block");
			    	jQuery("#deleteComfirm").data('url',url).data('href',href).dialog("open");
				});
				
				
				jQuery(".btnSend").click(function(e){
					if(isValidation()){
						loadBackgroud();
						var flag = false;
						var absenceBegin = jQuery("#dayOffBegin").val();
						var absenceEnd = jQuery("#dayOffEnd").val();
						var absenceReason = jQuery("#reason").val();
						var sessionBegin = jQuery("input[name='dayOffBeginRadio']:checked").val();					
						var sessionEnd = jQuery("input[name='dayOffEndRadio']:checked").val();
						var absenceTypeId = jQuery("select[name='absenceType']").val();
						var currentHander = jQuery("#currentHander").val();
						var selectedId = jQuery("#selectedId").val();
						var url='<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
									<portlet:param name="action" value="managerDayOffInfo"/>
									<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.SAVE%>"/>
									<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>"/>
									<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
								</portlet:renderURL>';
						jQuery(".btnSend").attr("disabled","disabled");
						jQuery.ajax({
							type:'POST',
							url:url,
							data:{
								"absenceBegin":absenceBegin,
								"absenceEnd":absenceEnd,
								"absenceReason":absenceReason,
								"sessionBegin":sessionBegin,
								"sessionEnd":sessionEnd,
								"absenceTypeId":absenceTypeId,
								"currentHander":currentHander,
								"selectTimeChangeID":selectedId,
							},
							success:function(){
								var href='<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
										<portlet:param name="action" value="commonController"/>
										<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>"/>
										<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
										</portlet:renderURL>';
								jQuery("#sendSuccess").css("display", "block");
						    	jQuery("#sendSuccess").data('url',href).dialog("open");
									
							},
							error:function(){
								alert("Có lỗi xảy ra, cần liên hệ đến Quản trị viên của ProGate");
							}
						});
					}
				}); 
				
				jQuery(".btnAgree").click(function(e){
					e.preventDefault();
					var reviewReason = jQuery("#review").val();
					var selectedId = jQuery("#selectedId").val();
					var url ='<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
									<portlet:param name="action" value="managerDayOffBy"/>
									<portlet:param name="<%=Constants.CMD%>" value="<%=Request.AGREE%>"/>
									<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_MANAGER%>"/>
									<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
								</portlet:renderURL>';
					jQuery.ajax({
						type:'POST',
						url: url,
						data:{
							'reviewReason':reviewReason,
							'selectedId':selectedId,
						},
						success:function(){
							if(jQuery("#reviewNext").is(':checked')){
								undoRe();
							}else{
								undoMa()
							}
						},
						error:function(){
							alert("Có lỗi xảy ra, cần liên hệ đến Quản trị viên của ProGate");
						}
					});
				});
				jQuery(".btnNotAgree").click(function(e){
					e.preventDefault();
					var reviewReason = jQuery("#review").val();
					var selectedId = jQuery("#selectedId").val();
					var url ='<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
									<portlet:param name="action" value="managerDayOffBy"/>
									<portlet:param name="<%=Constants.CMD%>" value="<%=Request.NOT_AGREE%>"/>
									<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_MANAGER%>"/>
									<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
								</portlet:renderURL>';
					jQuery.ajax({
						type:'POST',
						url: url,
						data:{
							'reviewReason':reviewReason,
							'selectedId':selectedId,
						},
						success:function(){
							if(jQuery("#reviewNext").is(':checked')){
								undoRe();
							}
							else{
								undoMa();
							}
						},
						error:function(){
							alert("Có lỗi xảy ra, cần liên hệ đến Quản trị viên của ProGate");
						}
					});
				});
			});
			function undoPer(){
				var url='<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
							<portlet:param name="action" value="commonController"/>
							<portlet:param name="<%=Constants.CMD%>" value="<%=Request.UNDO_HANDER%>"/>
							<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL%>"/>
							<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
						</portlet:renderURL>';
				submit(url);
			}
			function undoMa(){
				var url = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
								<portlet:param name="action" value="managerDayOffBy"/>
								<portlet:param name="<%=Constants.CMD%>" value="<%=Request.UNDO_HANDER%>"/>
								<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_MANAGER%>"/>
								<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
							</portlet:renderURL>';
				submit(url);
			}
			function undoRe(){
				var url = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
								<portlet:param name="action" value="managerDayOffBy"/>
								<portlet:param name="<%=Constants.CMD%>" value="<%=Request.UNDO_HANDER%>"/>
								<portlet:param name="unReview" value="unReview"/>
								<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_MANAGER%>"/>
								<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
							</portlet:renderURL>';
				submit(url);
			}
			function undoOther(){
				var url = '<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
					<portlet:param name="action" value="otherDayOff"/>
					<portlet:param name="<%=Constants.CMD%>" value="<%=Request.UNDO_HANDER%>"/>
					<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_OTHER%>"/>
					<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
				</portlet:renderURL>';
				submit(url);
			}
			function submit(url){
				document.frmManagerDayOffDetail.action=url;
				document.frmManagerDayOffDetail.submit();
			}
			function mySelect(){
				var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
								<portlet:param name="action" value="managerAttendanceInfo" />
								<portlet:param name="<%=Constants.CMD%>" value="<%=Request.SELECTED%>"/>
								<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
						</portlet:renderURL>';
				submit(url);
			}
			function isDateGreater(greater,lesser){
				var greaterDate = new Date(dateFormat(greater));
				var lesserDate = new Date(dateFormat(lesser));
				return (greaterDate > lesserDate);
			}
			function loadBackgroud(){
				jQuery("#backgroundLoading").css({
						"opacity": "0.7"
					});
				jQuery("#backgroundLoading").fadeIn("slow");
			}
</script>
<jsp:include page="../../dialog/dialog-sendSuccessDayOff.jsp"></jsp:include>
<jsp:include page="../../dialog/dialog-deleteDayOff.jsp"></jsp:include>
<form action="" name="frmManagerDayOffDetail" id="frmManagerDayOffDetail" method="post">  
    <div class="undo">
    	<input id="undo" type="image" src="/ProGate-portlet/images/lmis/undo.png">
    	<a id="_undo" href="#"><fmt:message key="lmis.common.back"/></a>
    </div>
    <div id="btnReview" class="cls-rightAngle" style="margin-right:8em">
    	<input name="review" type="image" src="/ProGate-portlet/images/lmis/review.png">
    	<a id="id-rightAngle" href="#"><fmt:message key="lmis.review"/></a>
    </div>  
    <div id="cancel" class="cls-rightAngle" style="margin-right:8em">
    	<input id="cancel" type="image" src="/ProGate-portlet/images/lmis/Cancel.png">
    	<a id="id-rightAngle" href="#"><fmt:message key="lmis.deployForm"/></a>
    </div> 
     <div id="edit" class="cls-rightAngle" style="margin-right:16em">
    	<input id="edit" type="image" src="/ProGate-portlet/images/lmis/edit.png">
    	<a id="id-rightAngle" href="#"><fmt:message key="lmis.edit"/></a>
    </div> 
    <div class="content">
    	<div class="cls-centerDetail">Chi Tiết Đơn Xin Nghỉ Phép Của ${functions:getFullName(bean.absenceDetail.requestedBy)}</div>
		<div style="padding-left:10px;padding-top:10px;float:left"><label style="color:red"><fmt:message key="lmis.common.requiredField"/></label></div>
		<%-- <div id="infoDayOff" style="float:left;margin-left:359px;margin-top:10px"><label style="color:red;font-weight: bold;">
			<c:choose>
			<c:when test="${bean.absenceDetail.absenceTypeId == 1 }">
				<fmt:message key="lmis.dayoff.year"><fmt:param>2</fmt:param>
					<fmt:param>${bean.countDayOff }</fmt:param></fmt:message>
			</c:when>
			<c:when test="${bean.absenceDetail.absenceTypeId == 2 }">
				<fmt:message key="lmis.dayoff.ot"><fmt:param>2</fmt:param>
					<fmt:param>${bean.countDayOff }</fmt:param></fmt:message>
			</c:when>
			<c:when test="${bean.absenceDetail.absenceTypeId == 3 }">
				<fmt:message key="lmis.dayoff.lastyear"><fmt:param>2</fmt:param>
					<fmt:param>${bean.countDayOff }</fmt:param></fmt:message>
			</c:when>
			<c:otherwise>
			<fmt:message key="lmis.dayoff.total"><fmt:param>${bean.countDayOff }</fmt:param></fmt:message>			
			</c:otherwise>
			</c:choose>
		</label></div> --%>
		<div class="contentDetail">
			<div style="float:left;padding-top:15px;">
				<table style="margin-left:10px;" >
					<tr>
						<td><fmt:message key="lmis.common.createDate"/></td>
						<td><div style="padding-left:25px">
								<input type="text" id="dateCreate"  name="dateCreateForm" style="width:315px;height: 20px" 
									value="<fmt:formatDate pattern="dd/MM/yyyy"	value="${bean.absenceDetail.createdAt }"/>" disabled="disabled" > </div>
						</td>
					</tr>
					<tr>
						<td><div style="margin-top:-10px"><fmt:message key="lmis.dayoff.Begin"/></div></td>
						<td>
							<div style="padding-top:10px;padding-left:25px">
								<input type="text" id="dayOffBegin" name="dayOffBegin" style="width:290px;height: 20px"
									value="<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.absenceDetail.startDate }"/>" >
								<div id="imgDisable" style="float:right;margin-right:-1px;margin-top:1px"><img src="/ProGate-portlet/images/lmis/viewAttendanceInfo/disable_datepicker.png"></div>
							</div>
							<div style="padding-top:5px;padding-left:25px">
								<span><input type="radio" name="dayOffBeginRadio" id="absenceAll" value="3">&nbsp;<fmt:message key="lmis.dayoff.type.allDate"/></span>
								<span style="margin:0 23px"><input type="radio" name="dayOffBeginRadio" id="absenceMorning" value="1">&nbsp;<fmt:message key="lmis.dayoff.type.morning"/></span>
								<span><input type="radio" name="dayOffBeginRadio" id="absenceEvening" value="2">&nbsp;<fmt:message key="lmis.dayoff.type.evening"/></span>
							</div>
							<div style="padding-left:2em;">
								<label id="errorDate" class="hiddenMessage"></label>
							</div>
						</td>
					</tr>
					<tr>
						<td><fmt:message key="lmis.dayoff.reason"/></td>
						<td>
							<div style="padding-top:17px;padding-left:25px">
								<textarea id="reason" rows="10" style="width:315px">${bean.absenceDetail.requestedReason }</textarea>
							</div>
							<div style="padding-left:2em">
								<label id="errorReason" class="hiddenMessage"></label>
							</div> 
						</td>
					</tr>
				</table>
			</div>
			<div class="cls-right">
				<table >
					<tr>
						<td><fmt:message key="lmis.dayoff.Type"/></td>
						<td>
							<select name="absenceType" style="width:315px;height: 26px" >
								<c:forEach var="list" items="${bean.lsAbType}" varStatus="itemCount">
									<c:choose>
										<c:when test="${bean.absenceDetail.absenceTypeId == list.lmisAbsenceSettingsId }">
											<option value="${bean.absenceDetail.absenceTypeId}" selected="selected">
												<c:out value="${list.name_}"/>
											</option>
										</c:when>
										<c:otherwise>
											<option value="${list.lmisAbsenceSettingsId }">
												<c:out value="${list.name_ }"/>
											</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td><div style="margin-top:-10px"><fmt:message key="lmis.dayoff.End"/></div></td>
						<td><div style="padding-top:10px;padding-left:25px">
								<input type="text" id="dayOffEnd" name="dayOffEnd" style="width:290px;height:20px;margin-right:1px" 
									value="<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.absenceDetail.endDate }"/>">
								<div id="imgDisable1" style="float:right;padding-right:2px"><img src="/ProGate-portlet/images/lmis/viewAttendanceInfo/disable_datepicker.png"></div>
							</div>
							<div style="padding-top:5px;padding-left:25px">
								<span><input type="radio" name="dayOffEndRadio" id="absenceAll_" value="3">&nbsp;<fmt:message key="lmis.dayoff.type.allDate"/></span>
								<span style="margin:0 23px"><input type="radio" name="dayOffEndRadio" id="absenceMorning_" value="1">&nbsp;<fmt:message key="lmis.dayoff.type.morning"/></span>
								<span><input type="radio" name="dayOffEndRadio" id="absenceEvening_" value="2">&nbsp;<fmt:message key="lmis.dayoff.type.evening"/></span>
							</div>
						</td>
					</tr>
				</table>
				<div  style="padding-top:8px;">
					<fieldset class="fieldset">
						<legend class="legend"><fmt:message key="lmis.common.review"/></legend>
							<textarea id="review" rows="8" style="width:413px"><c:out value="${bean.appReason}"></c:out></textarea>
					</fieldset>
				</div>
			</div>
		</div>
	</div><!-- End Content -->
	<div id="reviewNext_" style="float:right;margin:-15px 10px 20px 0">
		<input type="checkbox" name="reviewNext" id="reviewNext">Bạn muốn tiếp tục duyệt đơn khác sau khi phê duyệt đơn này
	</div>
	<div class="clear"></div>
	<div class="button">
		<input type="submit" value='<fmt:message key="button.reset"/>' class="btnCancel"/> 
		<input type="button" value='<fmt:message key="button.sendform"/>' class="btnSend"/>
		<input type="button" value='<fmt:message key="button.agree"/>' class="btnAgree"/> 
		<input type="button" value='<fmt:message key="button.notagree"/>' class="btnNotAgree"/>
		<input type="hidden" id="selectedId" name="selectedId" value="${bean.selectedId }"/>  
		<input type="hidden" id="currentHander" value="${bean.cmd }"/>
	</div>
</form>
<div id="backgroundLoading" >
	<div id="imgLoad">
	<img  src="/ProGate-portlet/images/lmis/loader.gif" />
	</div>
</div>