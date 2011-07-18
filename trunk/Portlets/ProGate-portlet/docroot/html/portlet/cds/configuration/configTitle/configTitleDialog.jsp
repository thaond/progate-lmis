<%@ include file="/html/portlet/cds/init.jsp"%>
<script>
	<%@ include file="/js/cds/encoder.js"%>
</script>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	function showTitleAddEditDialog(id) {
		/*show popup*/
		jQuery('#addEditTitleForm').modal({
			closeHTML: "<a href='#' title='Close' style='text-decoration:none;position:absolute; right:15px; top:6px; color:#fff;'><img src='/ProGate-portlet/images/cds/closeDialog.gif'/></a>",
			onShow: function(dialog) {
				//add height for fieldset competency and minimum
				if(jQuery('#fieldsetCompetency').height() > 180) {
					jQuery('#fieldsetCompetency').css("height","180px");
				}
				if(jQuery('#fieldsetMR').height() > 180) {
					jQuery('#fieldsetMR').css("height","180px");
				}
				
				jQuery('#agreeSave').data("lock","false");
				jQuery('#addEditTitleForm .yes').click(function(){
					if(jQuery('#agreeSave').data("lock") == "false") {
						jQuery('#agreeSave').data("lock", "true");
						//if isValidation() completed -> lock=false -> now clicking works
						if (isValidation(id)) {
							var href='<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
								<portlet:param name="action" value="configTitle" />
								<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
							</portlet:actionURL>';
							
							var fullName = jQuery("#fullName").val();
							var shortName = jQuery("#shortName").val();
							var order = jQuery("#order").val();
							var competenciesId = new Array();
							var pointHashes = new Array();
							var pointValues = new Array();
							var mininumRequirementsId = new Array();
							var mRLevelsId = new Array();
							
							jQuery('input[@name=competenciesId]').each(function(index){
								competenciesId.push(jQuery(this).val());
							});
							jQuery('select[@name=points]').each(function(index){
								var pointHash = jQuery(this).val();
								//alert(pointHash);
								pointHashes.push(pointHash);
							});
							jQuery('select[@name=points]').each(function(index){
								var pointValue = jQuery("option:selected",this).text();
								// var pointValue = jQuery(this).find("option:selected").text();
								//alert(pointValue);
								pointValues.push(pointValue);
							});
							jQuery('input[@name=minimumRequirements]').each(function(index){
								if( jQuery(this).is(":checked") ){
									var indexId = index + 1;
									var minimumRequirementId = jQuery('#minimumRequirementId'+indexId).val();
									//alert(minimumRequirementId);
									mininumRequirementsId.push(minimumRequirementId);

									var mRLevelId = jQuery('#MRLevelId'+indexId).val();
									//alert(mRLevelId);
									mRLevelsId.push(mRLevelId);
								}
							});
							
							jQuery.ajax({
								type: 'POST',
								url: href,
								data: {
									"handle":"add",
									"id":id,
									"fullName": fullName,
									"shortName": shortName,
									"order": order,
									"competenciesId": competenciesId,
									"pointHashes": pointHashes,
									"pointValues": pointValues,
									"mininumRequirementsId": mininumRequirementsId,
									"mRLevelsId": mRLevelsId
								},
								success: function(data) {
									//alert("server said: "+ data);
									jQuery('#agreeSave').data("lock", "false");
									jQuery('#titleForm').submit();
								},
								error: function(data) {
									jQuery('#agreeSave').data("lock", "false");
									//alert("Co loi xay ra khi dung ajax");
								}
							});
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
			}
		});
	}
	
	function showTitleDeleteDialog(titlesId){
		jQuery('#deleteTitleForm').modal({
			closeHTML: "<a href='#' title='Close' style='text-decoration:none;position:absolute; right:15px; top:6px; color:#fff;'><img src='/ProGate-portlet/images/cds/closeDialog.gif'/></a>",
			onShow: function(dialog){
				jQuery('#deleteTitleForm .yes').click(function(){
					
					var href='<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
						<portlet:param name="action" value="configTitle" />
						<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
					</portlet:actionURL>';
					
					jQuery.ajax({
						type:'POST',
						url: href,
						data: {
							"handle":"delete",
							"titlesId":titlesId
						},
						success: function(data){
							//alert("server said: "+ data);
							jQuery('#titleForm').submit();
						},
						error: function(data) {
							alert("Co loi xay ra khi dung ajax");
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
	
	jQuery(function() {
		
		/*click add title*/
		jQuery('#addTitle').click(function(e) {
			e.preventDefault();
			/*delete old data*/
			jQuery("#fullName").val("");
			jQuery("#shortName").val("");
			jQuery("#order").val("${bean.nextTitleOrder}");
			jQuery('select[@name=points]').each(function(index){
				if(jQuery(this).val() != -1) {
					jQuery(this).val("select");
				}
			});
			jQuery('input[@name=minimumRequirements]').each(function(index){
				jQuery(this).attr("checked", false);
				jQuery('#MRLevelId'+index).val("minimumLevel");
			});
			
			showTitleAddEditDialog("-1");
		});
		
		/*click delete title*/
		jQuery('#deleteTitle').click(function(e) {
			e.preventDefault();
			/*array titlesId to delete titles*/
			var titlesId = new Array();
			var titlesDeleteCount = 0;
			var indexDelete;
			jQuery("input[@name=checkList]").each(function(i) {
				if(jQuery(this).is(":checked")) {
					titlesId.push(jQuery(this).val());
					titlesDeleteCount += 1;
					indexDelete = i + 1;
				}
			});
			if(titlesDeleteCount == 1) {
				var name = jQuery('#abbreviation'+indexDelete).val();
				//alert(name);
				var message = '<fmt:message key="warning.title.deleteOne.confirm">' + '<fmt:param>' + Encoder.htmlEncode(name, true) + '</fmt:param>' + '</fmt:message>';
				jQuery('#deleteTitleForm #warning').html(message);
				showTitleDeleteDialog(titlesId);
			}else if (titlesDeleteCount > 1){
				var message = '<fmt:message key="warning.title.delete.confirm">' + '<fmt:param>' + titlesDeleteCount + '</fmt:param>' + '</fmt:message>';
				jQuery('#deleteTitleForm #warning').html(message);
				showTitleDeleteDialog(titlesId);
			} 
			
		});
		
		/*click edit title*/
		jQuery('.editTitle').click(function(e) {
			e.preventDefault();	
			var href='<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
				<portlet:param name="action" value="configTitle" />
				<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
			</portlet:actionURL>';
			var titleId = e.currentTarget.parentNode.getElementsByTagName("input")[0].value.toString();
			
			//load data into popup
			jQuery.ajax({
				type:'GET',
				url: href,
				data: {
					"handle":"edit",	
					"titleId":titleId,
				},
				success: function(xml){
					//alert("Data:" + xml);
					var fullName = jQuery(xml).find('fullName:first').text();
					//alert("fullName: "+fullName);
					var shortName = jQuery(xml).find('shortName:first').text();
					//alert("shortName: "+shortName);
					var order = jQuery(xml).find('order:first').text();
					//alert("order: "+order);

					jQuery('#fullName').val(fullName);
					jQuery('#shortName').val(shortName);
					jQuery('#order').val(order);
					
					jQuery('select[@name=points]').each(function(index){
						var indexId = index + 1;
						var pointHash = jQuery(xml).find('pointHash' + indexId + ':first').text();
						//jQuery(this).val(pointHash);
						jQuery(this).attr("value",pointHash);
						/* alert('pointHash' + indexId + ':first' + ", pointHash: " + pH + 
								', #point'+indexId); */
						//alert(jQuery(this).val());
						/*alert(jQuery("option:selected",this).text()); */
					});
					
					jQuery('input[@name=minimumRequirements]').each(function(index){
						var indexId = index + 1;
						var checked_status = jQuery(xml).find('checkMinimumRequirement' + indexId + ':first').text();
						//alert('#minimumRequirement'+indexId + ": " + checked_status);
						if(checked_status == 1) {
							jQuery(this).attr("checked", true);
						} else {
							jQuery(this).attr("checked", false);
						}
						
					});
					
					jQuery('select[@name=MRLevelsId]').each(function(index){
						var indexId = index + 1;
						var MRLevelId = jQuery(xml).find('MRLevelId' + indexId + ':first').text();
						if(MRLevelId != -1) {
							jQuery('#MRLevelId'+indexId).val(MRLevelId);
						}
						/*alert('pointHash' + indexId + ':first' + ", pointHash: " + pointHash + 
								', #point'+indexId);*/
					});
					
					//show pop-up
					showTitleAddEditDialog(titleId);
				},
				error: function() {
					alert("Co loi xay ra khi dung ajax");
				}
			});
			
		});
		
		
	});
</script>

<div id="loading" class="cds-loading">
	<img src="/ProGate-portlet/images/cds/ajax-loader.gif"/>
</div>

<!-- Popup ADD EDIT -->
<div class='simpleModalPopup span-14' id='addEditTitleForm' >
	<div class='header'>
		<span><fmt:message key="title.title" /></span>
	</div>
	<div class='message'>
		<div class="span-12 prepend-1 append-1">
			<span class="dialog-notice" style="display: none"></span>
			<div class="span-14 requiredFieldTitle">
				<label ><fmt:message key="title.title.require.field" /></label>
			</div>
			
			<div class="span-4">
				<label><fmt:message key="title.title.popup.name" /></label>
			</div>
			<div class="span-8 last">
				<input class=" span-8" type="text" id="fullName" MAXLENGTH="50" />
			</div>
			<div class="clear"></div>
			<div class="prepend-4 min-height padding-bottom">
				<label id="errorFullName"><fmt:message key="information.title.name" /></label>
			</div>
			<div class="clear"></div>
			
			<div class=" span-4">
				<label><fmt:message key="title.title.popup.abbreviation" /></label>
			</div>
			<div class=" span-8 last">
				<input class=" span-5" type="text" id="shortName" MAXLENGTH="50" />
			</div>
			<div class="clear"></div>
			<div class="prepend-4 min-height padding-bottom">
				<label id="errorShortName"><fmt:message key="information.title.abbreviation" /></label>
			</div>
			<div class="clear"></div>
			
			<div class=" span-4">
				<label><fmt:message key="title.title.popup.order" /></label>
			</div>
			<div class=" span-8 last">
				<input class=" span-3" type="text" id="order" MAXLENGTH="2"
					onkeypress="return isNumberKey(event)" value="${bean.nextTitleOrder}"/>
			</div>
			<div class="clear"></div>
			<div class="prepend-4 min-height padding-bottom">
				<label id="errorOrder"><fmt:message key="information.title.order" /></label>
			</div>
			<div class="clear"></div>
			
			<fieldset class="fieldsetAlign span-12" style="padding: 1px;" >
				<legend style="margin-left: 1.4em;">
					<fmt:message key="title.title.popup.competency" />
				</legend>
				<div id="fieldsetCompetency" class="scroll-y" style="margin-top: -0.6em; width: 506px;">
					<div style="margin: 15px -1.4em 10px 1.4em;">
					<c:forEach items="${bean.competencies}" var="competency" varStatus="count">
						<div class=" span-4 padding-bottom">
							<label>${competency.name }</label>
							<input type="hidden" id="competencyId${count.count}" 
								name="competenciesId" 
								value="${competency.competencyId }" />
						</div>
						
						<div class=" span-7 last">
								<c:set var='competencyLevelsCount' value='${functions:getLevelCountByCompetencyId(competency.competencyId) }'  scope="page" />
								<c:if test="${competencyLevelsCount > 0}">
								<select class=" span-5" id="point${count.count}" name="points" >
									<option value="select">
										<fmt:message key="title.title.popup.defaultSelection" />
									</option>
									<c:forEach var="i" begin="0" end='${competencyLevelsCount -1}'>
										<option value="${i*3 }">
											<c:out value="${i} - ${i+1}" />
										</option>
										
										<option value="${i*3  + 1}">
											<c:out value="++ ${i+1}" />
										</option>
										
										<option value="${i*3  + 2}">
											<c:out value="${i+1}" />
										</option>
									</c:forEach>
								</select>
								</c:if>
								<c:if test="${competencyLevelsCount == 0}">
								<select class=" span-5" id="point${count.count}" name="points" disabled="disabled" >
									<option value="-1" selected="selected">
										N/A
									</option>
								</select>
								</c:if>
						</div>
						<div class="clear"></div>
					</c:forEach>	
					</div>
				</div>
			</fieldset>
			<div class="min-height padding-bottom">
				<label id="errorCompetencyLevels"></label>
			</div>
			<div class="clear"></div>
			
			
			<fieldset class="fieldsetAlign span-12" style="padding: 1px;" >
				<legend style="margin-left: 1.4em;">
					<fmt:message key="title.title.popup.minimumRequirement" />
				</legend>
				<div id="fieldsetMR" class="scroll-y" style="margin-top: -0.6em; width: 506px;">
					<div style="margin: 15px -1.4em 10px 1.4em;">
					<c:forEach items="${bean.minimumRequirements}" var="minimumRequirement" varStatus="count">
						<c:set var='MRLevelsCount' value='${functions:getLevelCountByMinimumRequirementId(minimumRequirement.minimumRequirementId) }'  scope="page" />
						
						<div class=" span-4 padding-bottom ">
							<c:if test="${MRLevelsCount > 0}">
								<input type="checkbox" id="minimumRequirement${count.count}" name="minimumRequirements"
									style="vertical-align: middle;"/>
							</c:if>
							<c:if test="${MRLevelsCount == 0}">
								<input disabled="disabled" type="checkbox" id="minimumRequirement${count.count}" name="minimumRequirements"
									style="vertical-align: middle;"/>
							</c:if>
							<label>${minimumRequirement.name }</label>
							<input type="hidden" id="minimumRequirementId${count.count}" 
								name="minimumRequirementsId" 
								value="${minimumRequirement.minimumRequirementId }" />
						</div>
						
						<!--Get List of Minimum Requirement Levels by Id -->
						<c:set var='MRLevels' value='${functions:getLevelsByMinimumRequirementId(minimumRequirement.minimumRequirementId)}'  scope="page" />
						<div class=" span-7 last">
							<c:if test="${MRLevelsCount > 0}">
								<select class=" span-5" id="MRLevelId${count.count}" name="MRLevelsId" >
								<c:forEach items="${MRLevels}" var="MRLevel" varStatus="count">
									<option value="${MRLevel.minimumRequirementLevelId}">
										<c:out value="${MRLevel.name }" />
									</option>
								</c:forEach>
								</select>
							</c:if>
							<c:if test="${MRLevelsCount == 0}">
								<select disabled="disabled" class=" span-5" id="MRLevelId${count.count}" name="MRLevelsId" >
									<option value="-1">
										N/A
									</option>
								</select>
							</c:if>
						</div>
						<div class="clear"></div>
					</c:forEach>
					</div>
				</div>
			</fieldset>
			
			<div style="margin-bottom: 10px; text-align: center;">
				<input id="agreeSave" type="submit" value='<fmt:message key="button.save" />' class="yes" /> 
				<input type="submit" value='<fmt:message key="button.cancel" />' class="simplemodal-close no" />
			</div>
		</div>
	</div>
</div>

<!-- Popup DELETE -->
<div class='simpleModalPopup span-12' id='deleteTitleForm' >
	<div class='header'>
		<span><fmt:message key="title.title" /></span>
	</div>
	<div class='message' style="text-align: center;">
		<div class="span-10 prepend-1 append-1 prepend-top append-bottom" id="warning">
		</div>
		<div style="margin-bottom:20px; text-align: center;">
			<input type="submit" value='<fmt:message key="button.yes" />' class="yes" /> 
			<input type="submit" value='<fmt:message key="button.no" />' class="simplemodal-close no" />
		</div>
	</div>
</div>