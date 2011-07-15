<%@ include file="/html/portlet/cds/init.jsp"%>
<script>
	<%@ include file="/js/cds/encoder.js"%>
</script>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	function showEvaluationPeriodsAddEditDialog(id) {
		/*show popup*/
		jQuery('#addEditEvaluationPeriodsForm').modal({
			closeHTML: "<a href='#' title='Close' style='text-decoration:none;position:absolute; right:15px; top:6px; color:#fff;'><img src='/ProGate-portlet/images/cds/closeDialog.gif'/></a>",
			onShow: function(dialog) {
				jQuery('#oldStatus').val(jQuery("#addEditEvaluationPeriodsForm #status").val());
				
				jQuery('#agreeSave').data("lock", "false");
				jQuery('#addEditEvaluationPeriodsForm .yes').click(function(){
					if(jQuery('#agreeSave').data("lock") == "false") {
						jQuery('#agreeSave').data("lock", "true");
						if (isValidation(id)) {
							var href='<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
								<portlet:param name="action" value="evaluationPeriods" />
								<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
							</portlet:actionURL>';
							
							var nameEP = jQuery("#addEditEvaluationPeriodsForm #nameEP").val();
							var fromDate = jQuery("#addEditEvaluationPeriodsForm #fromDate").val();
							var toDate = jQuery("#addEditEvaluationPeriodsForm #toDate").val();
							var startDate = jQuery("#addEditEvaluationPeriodsForm #startDate").val();
							var endDate = jQuery("#addEditEvaluationPeriodsForm #endDate").val();
							var status = jQuery("#addEditEvaluationPeriodsForm #status").val();
	
							jQuery.ajax({
								type: 'POST',
								url: href,
								data: {
									"handle":"add",
									"id":id,
									"nameEP": nameEP,
									"fromDate": fromDate,
									"toDate": toDate,
									"startDate": startDate,
									"endDate": endDate,
									"status": status
								},
								success: function(data) {
									//alert("server said: "+ data);
									jQuery('#agreeSave').data("lock", "false");
									jQuery('#periodForm').submit();
								},
								error: function(data) {
									jQuery('#agreeSave').data("lock", "false");
									//alert("Co loi xay ra khi dung ajax");
								}
							});	
							
							if(id != "-1") { 
								//if change status is open or close
								if(status != jQuery('#oldStatus').val()) {
									if(status == "2" || status == "3") {
										jQuery.ajax({
											type: 'POST',
											url: href,
											data: {
												"handle":"sendMail",
												"nameEP": nameEP,
												"fromDate": fromDate,
												"toDate": toDate,
												"status": status
											},
											success: function(data) {
												//alert("server said: "+ data);
											},
											error: function(data) {
												//alert("Co loi xay ra khi dung ajax");
											}
										});	
									}
								}
							}
							
							jQuery.modal.close();
							jQuery("#loading").show();
						} else {
							jQuery('#agreeSave').data("lock", "false");
						}
					}
					
				});
			},
			onClose: function(dialog){
				jQuery('#agreeSave').data("lock", "false");
				jQuery.modal.close();
				/*delete datepicker, otherwise clone (@@) -> bug */
				//jQuery("#fromDate, #toDate, #startDate, #endDate").removeClass('hasDatepicker').datepicker();
				jQuery("#fromDate, #toDate, #startDate, #endDate").datepicker('destroy');
			}
		});
	}
	
	function showEvaluationPeriodsDeleteDialog(arrayId){
		jQuery('#deleteEvaluationPeriodsForm').modal({
			closeHTML: "<a href='#' title='Close' style='text-decoration:none;position:absolute; right:15px; top:6px; color:#fff;'><img src='/ProGate-portlet/images/cds/closeDialog.gif'/></a>",
			onShow: function(dialog){
				jQuery('#deleteEvaluationPeriodsForm .yes').click(function(){
					var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
									<portlet:param name="action" value="evaluationPeriods" />
									<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
								</portlet:actionURL>';
					
					jQuery.ajax({
						type:'POST',
						url: href,
						data: {
							"handle":"delete",
							"arrayId":arrayId
						},
						success: function(data){
							//alert("server said: "+ data);
							jQuery('#periodForm').submit();
						}
					});
					jQuery.modal.close();
					jQuery("#loading").show();
				});
			},
			onClose: function(dialog){
				jQuery.modal.close();
			}
		});
	}
	
	function showDatePicker(){
		/* jQuery("#fromDate, #toDate, #startDate, #endDate").not('.hasDatePicker').datepicker({ */
		jQuery("#fromDate, #toDate, #startDate, #endDate").datepicker({
			showOn: "both",
			dateFormat: "dd/mm/yy",
			buttonImage: "/ProGate-portlet/images/cds/calendar.png",
			buttonText: "Choose",
			buttonImageOnly: true
		});
	}
	
	function disableFields () {
		jQuery('#addEditEvaluationPeriodsForm #nameEP').attr("disabled", true);
		jQuery("#fromDate, #toDate, #startDate, #endDate").datepicker('disable');
		jQuery("#status option[value='1']").hide();
	}
	function enableFields() {
		jQuery('#addEditEvaluationPeriodsForm #nameEP').removeAttr("disabled");
		jQuery("#fromDate, #toDate, #startDate, #endDate").datepicker('enable');
		jQuery("#status option[value='1']").show();
	}
	
	jQuery(function() {	
		jQuery('#status').change(function() {
			var oldStatus = parseInt(jQuery('#oldStatus').val());
			var status = parseInt(jQuery(this).val());
			if(status == 2 && status != oldStatus) {
				var hasStatusOfOpen = ${bean.hasStatusOfOpen}; 				
				if(hasStatusOfOpen == true) {
					jQuery('#agreeSave').data("lock", "true");
					jQuery('#agreeSave').css("background-color", "gray");
					jQuery("#errorStatusOfOpen").html('Hiện đã có đợt CDS có trạng thái mở');
				}
			} else {
				jQuery('#agreeSave').data("lock", "false");
				jQuery('#agreeSave').removeAttr("style");
				jQuery("#errorStatusOfOpen").html('');
			}
		});
		
		/*click add ep*/
		jQuery('#addEP').click(function (e) {
			e.preventDefault();
			/*delete old data*/
			jQuery("#addEditEvaluationPeriodsForm #nameEP").val("");
			jQuery("#addEditEvaluationPeriodsForm #fromDate").val("");
			jQuery("#addEditEvaluationPeriodsForm #toDate").val("");
			jQuery("#addEditEvaluationPeriodsForm #startDate").val("");
			jQuery("#addEditEvaluationPeriodsForm #endDate").val("");	
			
			showDatePicker();
			enableFields();
			//add new -> status is init
			jQuery('#status').attr("disabled", true);
			showEvaluationPeriodsAddEditDialog("-1");
		});
		
		/*click edit*/
		jQuery('.editEP').click(function (e) {
			e.preventDefault();
			var href='<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
				<portlet:param name="action" value="evaluationPeriods" />
				<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
			</portlet:actionURL>';
			var id = e.currentTarget.parentNode.getElementsByTagName("input")[0].value.toString();
			//load data into popup
			jQuery.ajax({
				type:'GET',
				url: href,
				//dataType: 'xml',		
				data: {
					"handle":"edit",
					"id":id,
				},
				success: function(xml){
					//alert("Data:" + xml);
					var isNotUsed = jQuery(xml).find('isNotUsed:first').text();
					var nameToEdit = jQuery(xml).find('nameEP:first').text();
					var fromDateToEdit = jQuery(xml).find('fromDate:first').text();
					var toDateToEdit = jQuery(xml).find('toDate:first').text();
					var startDateToEdit = jQuery(xml).find('startDate:first').text();
					var endDateToEdit = jQuery(xml).find('endDate:first').text();
					var statusToEdit = jQuery(xml).find('status:first').text();
					
					jQuery('#addEditEvaluationPeriodsForm #nameEP').val(nameToEdit);
					jQuery('#addEditEvaluationPeriodsForm #fromDate').val(fromDateToEdit);
					jQuery('#addEditEvaluationPeriodsForm #toDate').val(toDateToEdit);
					jQuery('#addEditEvaluationPeriodsForm #startDate').val(startDateToEdit);
					jQuery('#addEditEvaluationPeriodsForm #endDate').val(endDateToEdit);
					jQuery('#addEditEvaluationPeriodsForm #status').val(statusToEdit);
					
					showDatePicker();
					if(statusToEdit == 2 || statusToEdit == 3) { 
						/*status open or close*/
						if(isNotUsed == "true") {
							enableFields();
						} else {
							disableFields();
						}
					} else if (statusToEdit == 1) {
						/*status new*/
						enableFields();
					}
					jQuery('#status').removeAttr("disabled");
					//hien pop-up
					showEvaluationPeriodsAddEditDialog(id);
				},
				error: function(){
					alert("Co loi xay ra khi dung ajax");
				}
			});
		});
		
		/*click delete*/
		jQuery('#deleteEP').click(function(e){
			e.preventDefault();
			var isDelete = true;
			/*array Id to delete EPs*/
			var arrayId = new Array();
			var ePsDeleteCount = 0;
			var indexDelete;
			var periodNotUsed; 
			jQuery("input[@name=checkList]").each(function(i) {
				if(jQuery(this).is(":checked")) {
					indexDelete = i + 1;
					periodNotUsed = jQuery('#notUsed'+indexDelete).val();
					//if evaluation period is used, not allow to delete
					if (periodNotUsed == 'false') {
						isDelete = false;
						return false;
					}
					
					arrayId.push(jQuery(this).val());
					ePsDeleteCount += 1;
				}
			});
				
			if(isDelete == true) {
				if(ePsDeleteCount == 1) {
					var name = jQuery('#ePName'+indexDelete).val();
					var fromDate = jQuery('#fromDate'+indexDelete).val();
					var toDate = jQuery('#toDate'+indexDelete).val();
					//alert(name);
					var message = '<fmt:message key="warning.ep.deleteOne.confirm">' + 
							'<fmt:param>' + Encoder.htmlEncode(name, true) + '</fmt:param>' +
							'<fmt:param>' + fromDate + '</fmt:param>' +
							'<fmt:param>' + toDate + '</fmt:param>' +
							'</fmt:message>';
					jQuery('#deleteEvaluationPeriodsForm #warning').html(message);
					showEvaluationPeriodsDeleteDialog(arrayId);
				}else if (ePsDeleteCount > 1){
					var message = '<fmt:message key="warning.ep.delete.confirm">' + '<fmt:param>' + ePsDeleteCount + '</fmt:param>' + '</fmt:message>';
					jQuery('#deleteEvaluationPeriodsForm #warning').html(message);
					showEvaluationPeriodsDeleteDialog(arrayId);
				}
			} else {
				jQuery('#notDeleteEvaluationPeriodsForm').modal({
					closeHTML: "<a href='#' title='Close' style='text-decoration:none;position:absolute; right:15px; top:6px; color:#fff;'><img src='/ProGate-portlet/images/cds/closeDialog.gif'/></a>",
				});
			}	
								
		});
		
	});
</script>

<div id="loading" class="cds-loading">
	<img src="/ProGate-portlet/images/cds/ajax-loader.gif"/>
</div>

<div class='simpleModalPopup span-12' id='deleteEvaluationPeriodsForm'>
	<div class='header'>
		<span><fmt:message key="title.ep" /></span>
	</div>
	<div class='message'>
		<div class="span-10 prepend-1 append-1 prepend-top append-bottom" id="warning">
			<%-- <label><fmt:message key="title.ep.popup.delete" /></label> --%>
		</div>
		<div style="margin-bottom:20px; text-align: center;">
			<input type="submit" value='<fmt:message key="button.yes" />' class="yes" /> 
			<input type="submit" value='<fmt:message key="button.no" />' class="simplemodal-close no" />
		</div>
	</div>
</div>

<div class='simpleModalPopup span-12' id='notDeleteEvaluationPeriodsForm' >
	<div class='header'>
		<span><fmt:message key="title.ep" /></span>
	</div>
	<div class='message' >
		<div class="span-10 prepend-1 append-1 prepend-top append-bottom" id="warning">
			<label><fmt:message key="warning.ep.notDelete.confirm" /></label>
		</div>
		<div style="margin-bottom:20px; text-align: center;">
			<input type="submit" value='<fmt:message key="button.agree" />' class="simplemodal-close no" /> 
		</div>
	</div>
</div>	

<div class='simpleModalPopup span-14' id='addEditEvaluationPeriodsForm' >
	<div class='header'>
		<span><fmt:message key="title.ep" /></span>
	</div>
	<div class='message'>
		<div class="span-12" style="padding-left: 52px;">
			<span class="dialog-notice" style="display: none"></span>
			<div class="span-12 requiredFieldTitle">
				<label ><fmt:message key="title.ep.require.field" /></label>
			</div>
			
			<div class="span-5">
				<label><fmt:message key="title.ep.popup.name" /></label>
			</div>
			<div class="span-7 last">
				<input class=" span-6" type="text" id="nameEP" MAXLENGTH="50"/>
			</div>
			<div class="clear"></div>
			<div class="prepend-5 min-height padding-bottom">
				<label id="errorName" class=""><fmt:message key="information.ep.name" /></label>
			</div>
			<div class="clear"></div>
			
			<div class=" span-5">
				<label><fmt:message key="title.ep.popup.fromDate" /></label>
			</div>
			<div class=" span-7 last">
				<input class=" span-6" type="text" id="fromDate" maxlength="0"/>
			</div>
			<div class="clear"></div>
			<div class="prepend-5 min-height padding-bottom">
				<label id="errorFromDate" class="requiredFieldMessage"></label>
			</div>
			<div class="clear"></div>
			
			<div class=" span-5">
				<label><fmt:message key="title.ep.popup.toDate" /></label>
			</div>
			<div class=" span-7 last">
				<input class=" span-6" type="text" id="toDate" maxlength="0"/>
			</div>
			<div class="clear"></div>
			<div class="prepend-5 min-height padding-bottom">
				<label id="errorToDate" class="requiredFieldMessage"></label>
				</div>
			<div class="clear"></div>
			
			<div class=" span-5">
				<label><fmt:message key="title.ep.popup.startDate" /></label>
			</div>
			<div class=" span-7 last">
				<input class=" span-6" type="text" id="startDate" maxlength="0"/>
			</div>
			<div class="clear"></div>
			<div class="prepend-5 min-height padding-bottom">
				<label id="errorStartDate" class="requiredFieldMessage"></label>
				</div>
			<div class="clear"></div>
			
			<div class=" span-5">
				<label><fmt:message key="title.ep.popup.endDate" /></label>
			</div>
			<div class=" span-7 last">
				<input class=" span-6" type="text" id="endDate" maxlength="0"/>
			</div>
			<div class="clear"></div>
			<div class="prepend-5 min-height padding-bottom">
				<label id="errorEndDate" class="requiredFieldMessage"></label>
				</div>
			<div class="clear"></div>
			
			<div class=" span-5">
				<label><fmt:message key="title.ep.status" /></label>
			</div>
			<div class=" span-7 last">
				<select id="status" name="status">
					<option value="1"><fmt:message key="title.ep.status.new" /></option>
					<option value="2"><fmt:message key="title.ep.status.open" /></option>
					<option value="3"><fmt:message key="title.ep.status.close" /></option>
				</select>
				<input type="hidden" id="oldStatus" name="oldStatus" value=""/>
			</div>
			<div class="clear"></div>
			
			<div class="prepend-5 ">
				<label id="errorStatusOfOpen" class="requiredFieldMessage"></label>
			</div>
			<div class="clear"></div>
			
			<div style="margin-top: 20px; margin-bottom: 10px; text-align: center;">
				<input id="agreeSave" type="submit" value='<fmt:message key="button.save" />' class="yes" /> 
				<input type="submit" value='<fmt:message key="button.cancel" />' class="simplemodal-close no" />
			</div>
		</div>
	</div>
</div>