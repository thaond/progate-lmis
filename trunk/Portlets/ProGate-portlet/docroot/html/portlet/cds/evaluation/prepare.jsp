<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">

jQuery(function() {
	//no effect when clicking more than 1 time
	jQuery('#save').data("lock","false");
	jQuery('#continue').data("lock","false");
	jQuery('#down').data("lock","false");
	jQuery('#up').data("lock","false");
	
	/*Loop performance of appraisal slots list to show these in below list 
	and hide these in above list*/ 
	<c:forEach items="${bean.paSlots}" var="paSlot">
		var slotId = ${paSlot.slotId };
		/*show a slot in below list*/
		var evaluationSlot = jQuery('#evaluationSlot'+slotId);
		evaluationSlot.show();
		/*disable checkbox when BOD or PM approved*/
		if(${paSlot.ratingStatusBod != 0 || paSlot.ratingStatusPm != 0}) {
			jQuery('#checkEvaluationSlot'+slotId).attr("disabled", "disabled");
		}
		/*find level of this slot*/
		var levelId = evaluationSlot.attr("levelid");
		/*In below list, update a number of slots of this level (ADD 1) */
		updatePASlotCount(levelId, 1);
		/*Above list have slots in below list ? */
		var slot = jQuery('#slot'+slotId);
		if(slot.length) {
			/*hide a slot in above list*/
			slot.hide();
			/*In above list, update a number of slots of this level (SUBTRACT 1) */
			updateSlotCount(levelId, -1);
		}
	</c:forEach>
	
	if(emptyBelowList()) {
		jQuery('#belowList').hide();
		jQuery('#emptyList').show();	
	} else {
		jQuery('#belowList').show();
		jQuery('#emptyList').hide();
	}
	addRemoveHeight();
	reIndexTrBgColor();
	
	/*move items from above list to below list*/
	jQuery('#down').click(function(e){
		if(jQuery('#down').data("lock") == "false") {
			jQuery('#down').data("lock","true");
			if(${bean.lockCDS == false}) {
				e.preventDefault();
				jQuery('input[@name=checkSlots]:checked').each(function(i) {
					removeHighLight();
					return false;
				});
				var slotsName = "";
				var isPassed;
				var hasPassedSlot = 0;
				jQuery('input[@name=checkSlots]:checked').each(function(i) {
					isPassed = jQuery(this).parent().parent().attr("ispassed");
					if(isPassed == 'true') {
						hasPassedSlot = 1;
						return false;
						slotsName += jQuery(this).parent().parent().attr("slotname") + ", ";
					}
				});
				if(hasPassedSlot == 1) {
					//var message = "Bạn có chắc muốn thêm slot(s) <strong>" + slotsName + "</strong> đã đạt vào <strong> Danh sách các slot muốn đánh giá không</strong>?";
					var message = 'Slot(s) được chọn có chứa slot(s) có trạng thái "Đạt". Bạn có chắc muốn thêm slot(s) này vào "Danh sách các slot muốn đánh giá" không?';

					jQuery('#warning').html(message);
					jQuery('#warningMoveItemsForm').modal({
						closeHTML: "<a href='#' title='Close' style='text-decoration:none;position:absolute; right:15px; top:6px; color:#fff;'><img src='/ProGate-portlet/images/cds/closeDialog.gif'/></a>",
						onShow: function(dialog) {
							jQuery('#warningMoveItemsForm .yes').click(function() {
								jQuery.modal.close();
								//jQuery("#loading").show();
								
								jQuery('input[@name=checkSlots]:checked').each(function(i) {
									var slotId = jQuery(this).val();
									/*hide a slot in above list*/
									var slot = jQuery('#slot'+slotId);
									slot.hide();
									/*show a slot in below list*/
									var evaluationSlot = jQuery('#evaluationSlot'+slotId);
									evaluationSlot.show();
									evaluationSlot.addClass("tr-highlight");
									/*find level of this slot*/
									var levelId = jQuery('#slot'+slotId).attr("levelid");
									/*In above list, update a number of slots of this level (SUBTRACT 1) */
									updateSlotCount(levelId, -1);
									/*In below list, update a number of slots of this level (ADD 1) */
									updatePASlotCount(levelId, 1);
								});
								jQuery('input[@name=checkSlots]:checked').each(function(i) {
									this.checked = false;
								});
								if(!emptyBelowList()) {
									jQuery('#belowList').show();
									jQuery('#emptyList').hide();
								}
								addRemoveHeight();
								reIndexTrBgColor();
									
								//jQuery("#loading").hide();
							});
						},
						onClose: function(dialog){
							jQuery.modal.close();
						}
					});
				} else {
					//jQuery("#loading").show();
					jQuery('input[@name=checkSlots]:checked').each(function(i) {
						var slotId = jQuery(this).val();
						/*hide a slot in above list*/
						var slot = jQuery('#slot'+slotId);
						slot.hide();
						/*show a slot in below list*/
						var evaluationSlot = jQuery('#evaluationSlot'+slotId);
						evaluationSlot.show();
						evaluationSlot.addClass("tr-highlight");
						/*find level of this slot*/
						var levelId = jQuery('#slot'+slotId).attr("levelid");
						/*In above list, update a number of slots of this level (SUBTRACT 1) */
						updateSlotCount(levelId, -1);
						/*In below list, update a number of slots of this level (ADD 1) */
						updatePASlotCount(levelId, 1);
					});
					jQuery('input[@name=checkSlots]:checked').each(function(i) {
						this.checked = false;
					});
					if(!emptyBelowList()) {
						jQuery('#belowList').show();
						jQuery('#emptyList').hide();
					}
					addRemoveHeight();
					reIndexTrBgColor();
					//jQuery("#loading").hide();
				}
			}
			jQuery('#down').data("lock","false");
		}
	});
	
	/*move items from below list to above list */
	jQuery('#up').click(function(e){
		if(jQuery('#up').data("lock") == "false") {
			jQuery('#up').data("lock","true");
			if(${bean.lockCDS == false}) {
				jQuery("#loading").show();
				e.preventDefault();
				jQuery('input[@name=checkEvaluationSlots]:checked').each(function(i) {
					removeHighLight();
					return false;
				});
				jQuery('input[@name=checkEvaluationSlots]:checked').each(function(i) {
					var slotId = jQuery(this).val();
					/*hide a slot in below list*/
					var evaluationSlot = jQuery('#evaluationSlot'+slotId);
					evaluationSlot.hide();
					var levelId = evaluationSlot.attr("levelid");
					/*In below list, update a number of slots of this level (SUBTRACT 1) */
					updatePASlotCount(levelId, -1);
					/*Above list have slots in below list ?*/
					var slot = jQuery('#slot'+slotId);
					if(slot.length) {
						/*show a slot in above list*/
						slot.show();
						slot.addClass("tr-highlight");
						/*In above list, update a number of slots of this level (ADD 1) */
						updateSlotCount(levelId, 1);
					}
				});
				jQuery('input[@name=checkEvaluationSlots]:checked').each(function(i) {
					this.checked = false;
				});
				if(emptyBelowList()) {
					jQuery('#belowList').hide();
					jQuery('#emptyList').show();	
				} else {
					jQuery('#belowList').show();
					jQuery('#emptyList').hide();
				}
				addRemoveHeight();
				reIndexTrBgColor();
				jQuery("#loading").hide();
			}
			jQuery('#up').data("lock","false");
		}
	});
	
	jQuery('#save').click(function(e, continueURL) {
		if(isChangedPaList()) {
			jQuery("#loading").show();
			
			if(jQuery('#save').data("lock") == "false") {
				jQuery('#save').data("lock", "true");
				e.preventDefault();
				var competencies = new Array();
				var levels = new Array();
				var slots = new Array();
				var pointNames = new Array();
				var pointValues = new Array();
				jQuery('tr.evaluationCompetencies:visible').each(function() {
					var competencyId = jQuery(this).attr("competencyid");
					//alert("competencyid :" + competencyId);
					competencies.push(competencyId);
				});
				jQuery('tr.evaluationLevels:visible').each(function() {
					var levelId = jQuery(this).attr("levelid");
					//alert("levelId :" + levelId);
					levels.push(levelId);
				});
				jQuery('tr.evaluationSlots:visible').each(function() {
					var slotId = jQuery(this).attr("slotid");
					var pointName = jQuery(this).attr("pointname");
					var pointValue = jQuery(this).attr("pointvalue");
					/* alert("slotId :" + slotId 
							+ ", pointName: " + pointName 
							+ ", pointValue: " +  pointValue); */
					slots.push(slotId);
					pointNames.push(pointName);
					pointValues.push(pointValue);
				});
				
				var hrefAjax='<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
					<portlet:param name="action" value="cds.evaluation" />
					<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_EVALUATION_2%>" />
					<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
				</portlet:actionURL>';
				
				var selectedPeriod = jQuery('#selectPeriod').val();
				var selectedCompetency = jQuery('#selectCompetency').val();
				var selectedSlotStatus = jQuery('#selectSlotStatus').val();
				var hrefReload='<portlet:renderURL>
					<portlet:param name="action" value="cds.evaluation" />
					<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_EVALUATION_2%>" />
					<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
					<portlet:param name="<%=RequestConst.PERIOD_ID %>" value="selectedPeriod" />
					<portlet:param name="<%=RequestConst.COMPETENCY_ID %>" value="selectedCompetency" />
					<portlet:param name="<%=RequestConst.SLOT_STATUS %>" value="selectedSlotStatus" />
				</portlet:renderURL>';
				hrefReload = hrefReload.replace("selectedPeriod", selectedPeriod);
				hrefReload = hrefReload.replace("selectedCompetency", selectedCompetency);
				hrefReload = hrefReload.replace("selectedSlotStatus", selectedSlotStatus);
				
				//alert(href);
				
				jQuery.ajax({
					type: 'POST',
					url: hrefAjax,
					data: {
						"periodId": ${bean.selectedPeriod },
						"competencies": competencies,
						"levels": levels,
						"slots": slots,
						"pointNames": pointNames,
						"pointValues": pointValues,
					},
					success: function(data) {
						jQuery('#save').data("lock","false");
						//alert("server said: "+ data);
						if (continueURL == null) {
							//jQuery('#prepareForm').submit();
							location.href = hrefReload;
						} else {
							location.href = continueURL;
						}
					},
					error: function(data) {
						jQuery('#save').data("lock","false");
						alert("Co loi xay ra khi dung ajax" + ", server said: " + data);
					}
				});
			}
		}
		
	});
	
	jQuery('#continue').click(function(e) {
		e.preventDefault();
		var continueURL='<portlet:renderURL>
			<portlet:param name="action" value="cds.evaluation" />
			<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_EVALUATION_3%>" />
			<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
			<portlet:param name="<%=RequestConst.PERIOD_ID %>" value="${bean.selectedPeriod}" />
		</portlet:renderURL>';
		if(isChangedPaList()) {
			jQuery('#save').trigger('click', [continueURL]);
		} else {
			location.href = continueURL;
		}
	});
	
	jQuery('#selectPeriod, #selectCompetency, #selectSlotStatus').change(function(e) {
		if(isChangedPaList()) {
			showDialogWarningSaveItems();
		} else {
			jQuery('#prepareForm').submit();
		}
	});
	
	function updatePASlotCount(levelId, count){
		var evaluationLevel = jQuery('#evaluationLevel'+levelId);
		var slotCount = parseInt(evaluationLevel.attr("slotcount")) + count;
		evaluationLevel.attr("slotcount", slotCount);
		
		if(count == 1 && evaluationLevel.attr("showlevel") == 0) {
			evaluationLevel.show();
			var competencyId = evaluationLevel.attr("competencyid");
			updatePALevelCount(competencyId, count);
			evaluationLevel.attr("showlevel",1);
		} else if (count == -1 && slotCount == 0){
			evaluationLevel.hide();
			var competencyId = evaluationLevel.attr("competencyid");
			updatePALevelCount(competencyId, count);
			evaluationLevel.attr("showlevel",0);
		}
	}
	function updatePALevelCount(competencyId, count) {
		var evaluationCompetency = jQuery('#evaluationCompetency'+competencyId);
		var levelCount = parseInt(evaluationCompetency.attr("levelcount")) + count;
		if (levelCount == 0) {
			evaluationCompetency.hide();
		} else {
			evaluationCompetency.show();
		}
		evaluationCompetency.attr("levelcount", levelCount);
	}
		
	function updateSlotCount(levelId, count) {
		var level = jQuery('#level'+levelId);
		var slotCount = parseInt(level.attr("slotcount")) + count;
		level.attr("slotcount", slotCount);
		
		if (count == -1 && slotCount == 0){
			level.hide();
			var competencyId = level.attr("competencyid");
			updateLevelCount(competencyId, count);
			level.attr("showlevel",0);
		}else if (count == 1 && level.attr("showlevel") == 0) {
			level.show();
			var competencyId = level.attr("competencyid");
			updateLevelCount(competencyId, count);
			level.attr("showlevel",1);
		}
	}
	function updateLevelCount(competencyId, count) {
		var competency = jQuery('#competency'+competencyId);
		var levelCount = parseInt(competency.attr("levelcount")) + count;
		if (levelCount == 0) {
			competency.hide();
		} else {
			competency.show();
		}
		competency.attr("levelcount", levelCount);
	}

	function emptyBelowList() {
		var empty = true;
		jQuery('tr.evaluationCompetencies').each(function() {
			if(jQuery(this).attr('levelcount') != 0) {
				empty = false;
				return false;
			}
		});
		return empty;
	}

	function reIndexTrBgColor() {
		jQuery('tr:visible','#aboveList').each(function(i) {
			if(i % 2 == 0) {
				jQuery(this).css("background-color", "#FFFFFF");
			} else {
				jQuery(this).css("background-color", "#E9ECF4");
			}
		});
		jQuery('tr:visible','#belowList').each(function(i) {
			if(i % 2 == 0) {
				jQuery(this).css("background-color", "#FFFFFF");
			} else {
				jQuery(this).css("background-color", "#E9ECF4");
			}
		});
	}
	function addRemoveHeight() {
		var aboveList = jQuery('#aboveList');
		var belowList = jQuery('#belowList');
		aboveList.removeAttr('style');
		belowList.removeAttr('style');
		
		if(aboveList.height() > 400) {
			aboveList.css("height","400px");
		}
		if(belowList.height() > 400) {
			belowList.css("height","400px");
		}
	}
	function removeHighLight() {
		jQuery('tr.slots:visible').each(function() {
			if(jQuery(this).hasClass('tr-highlight')) {
				jQuery(this).removeClass("tr-highlight");	
			}
		});
		jQuery('tr.evaluationSlots:visible').each(function() {
			if(jQuery(this).hasClass('tr-highlight')) {
				jQuery(this).removeClass("tr-highlight");	
			}
		});
	}

	function isChangedPaList() {
		//if size of two list are different from each other => PA list is changed 
		if(${bean.paSlotsSize} != jQuery('tr.evaluationSlots:visible').length) {
			return true;
		}
		<c:forEach items="${bean.paSlots}" var="paSlot">
			var paSlotId = ${paSlot.slotId };
			var found = false;
			jQuery('tr.evaluationSlots:visible').each(function() {
				var slotId = jQuery(this).attr("slotid");
				if(slotId == paSlotId) {
					found = true;
					//if found => break loop
					return false;
				}
			});
			// if not found item of evaluationSlots list in PA list => PA list is changed 
			if(found == false) {
				return true;
			}
		</c:forEach>
		return false;
	}
	function showDialogWarningSaveItems(){
		jQuery('#warningSaveEvaluationsListForm').modal({
			closeHTML: "<a href='#' title='Close' style='text-decoration:none;position:absolute; right:15px; top:6px; color:#fff;'><img src='/ProGate-portlet/images/cds/closeDialog.gif'/></a>",
			onShow: function(dialog) {
				jQuery('#warningSaveEvaluationsListForm .yes').click(function() {
					jQuery.modal.close();
					jQuery('#save').trigger('click');
				});
			},
			onClose: function(dialog){
				jQuery.modal.close();
				jQuery('#prepareForm').submit();	
			}
		});	
	}
	
});
</script>

<jsp:include page="/html/portlet/cds/evaluation/prepareDialog.jsp"></jsp:include>

<c:choose>
<c:when test="${bean.hasOpenEvaluationPeriods == false}">
	<div class="cds-notification border-radius" 
			style="margin: 0pt; padding-top: 1.5em; height: 450px;">
		Hiện không có đợt CDS nào đang tồn tại ở trạng thái “Mở”<br />
		Vui lòng nhấp <a href="#">vào đây</a> để trở lại trang chủ.
	</div>
</c:when>

<c:otherwise>
<div id="loading" class="cds-loading">
	<img src="/ProGate-portlet/images/cds/ajax-loader.gif"/>
</div>

<portlet:renderURL var="evaluationURL">
	<portlet:param name="action" value="cds.evaluation" />
	<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_EVALUATION_2%>" />
	<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
</portlet:renderURL>
<form id="prepareForm" method="post" action="${evaluationURL }">
<div class="border-radius" style="margin: 0pt 0pt 10px;">
	<div class="filter-area">
		<label class="span-3 padding-bottom"><strong>Bạn đang ở title: </strong></label>
		<label class="span-7 padding-bottom" style="color: #E46C0A"> 
			<strong>${bean.titleName }</strong> 
		</label>
		<div class="clear"></div>
		
		<label class="span-3 padding-bottom">Đợt CDS  </label>
		<div class="span-7 padding-bottom">
			<select id="selectPeriod" class="span-6" name="<%=RequestConst.PERIOD_ID %>" >
				<c:forEach items="${bean.evaluationPeriods }" var="eP">
					<option value="${eP.cdsEvaluationPeriodsId}"
						<c:if test="${bean.selectedPeriod == eP.cdsEvaluationPeriodsId}">
							<c:out value="selected" />
						</c:if>>${eP.name } - <fmt:formatDate pattern="MM/yyyy" value="${eP.startDate}" /> đến <fmt:formatDate pattern="MM/yyyy" value="${eP.endDate}" />
					</option>
				</c:forEach>
			</select>
		</div>
		<c:if test="${bean.lockCDS == false }">
			<label class="span-7 padding-bottom" style="color: green">Bạn được phép thêm/xoá slot</label>
		</c:if>
		<c:if test="${bean.lockCDS == true }">
			<label class="span-7 padding-bottom" style="color: red">Bạn không được phép thêm/xoá slot</label>
		</c:if>
		<div class="clear"></div>
		
		<label class="span-3">Competency </label>
		<div class="span-7">
			<select id="selectCompetency" class="span-6" name="<%=RequestConst.COMPETENCY_ID%>" 
					<c:if test="${bean.hasPermissionToEvaluate == false}">
						disabled="disabled"
					</c:if>>
				<option value="0"
					<c:if test="${bean.selectedCompetency == 0}">
						<c:out value="selected" />
					</c:if>>Tất cả
				</option>
				<c:forEach items="${bean.competencies }" var="competency">
					<option value="${competency.competencyId}"
						<c:if test="${bean.selectedCompetency == competency.competencyId}">
							<c:out value="selected" />
						</c:if>>${competency.name }
					</option>
				</c:forEach>
			</select>
		</div>
		<label class="span-3 last">Trạng thái slot</label>
		<div class="span-7">
			<select id="selectSlotStatus" class="span-6" name="<%=RequestConst.SLOT_STATUS%>" 
					<c:if test="${bean.hasPermissionToEvaluate == false}">
						disabled="disabled"
					</c:if>>
				<option value="0"
					<c:if test="${bean.selectedSlotStatus == 0}">
						<c:out value="selected" />
					</c:if>>Tất cả
				</option>
				<option value="1"
					<c:if test="${bean.selectedSlotStatus == 1}">
						<c:out value="selected" />
					</c:if>>Đạt
				</option>
				<option value="2"
					<c:if test="${bean.selectedSlotStatus == 2}">
						<c:out value="selected" />
					</c:if>>Không Đạt
				</option>
				<option value="3"
					<c:if test="${bean.selectedSlotStatus == 3}">
						<c:out value="selected" />
					</c:if>>Chưa Đánh Giá
				</option>
			</select>
		</div>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	
	<c:choose>
		<c:when test="${bean.hasPermissionToEvaluate == false}">
			<div class="cds-notification" style="height: 450px;">
				Hiện tại bạn không được quyền đánh giá trong đợt CDS này.<br />
				Vui lòng chọn đợt CDS khác để đánh giá.
			</div>
		</c:when>
		<c:otherwise>
	
		<!----------------------- List of slots which are not evaluated --------------------------->
		<div style="font-size: 1.3em; margin-top: 20px; margin-bottom: 2px;" class="left padding-left">
			<strong>Danh sách các slot</strong>
		</div>
		<div style="margin-top: 23px;" class="right padding-right">	
			<c:if test="${bean.lockCDS == false }">
			<a id="down" href="#down">	
				<img class="absmiddle" src="/ProGate-portlet/images/cds/add.png" width="17px" height="17px" >	
				Thêm slot(s) vào "Danh sách các slot muốn đánh giá"	
			</a>	
			</c:if>
			<c:if test="${bean.lockCDS == true }">
				<img class="absmiddle" src="/ProGate-portlet/images/cds/add-slot-dis.png" width="17px" height="17px" >	
				<label style="color: gray"> Thêm slot(s) vào "Danh sách các slot muốn đánh giá" </label>	
			</c:if>
		</div>
		<div style="margin: 0px 3px;">
		<table style="border-collapse: separate; border: 1px solid #DBEEF4; " >
		<thead >
			<tr>
				<th style="border:0px" colspan="2" class="span-18">Mô Tả Slot</th>
				<th style="border:0px" class="span-2">Điểm</th>
				<th style="border:0px" class="span-3 last">Trạng Thái</th>
			</tr>
		</thead>
		<tbody id="aboveList" class="scroll-y" style="height: 400px;">
			<c:forEach items="${bean.aboveFinalCompetencies}" var="finalCompetency">
				<tr id="competency${finalCompetency.competencyId }"
					class="competencies" 
					levelcount="${functions:getLevelCountByCompetencyIdAndSlotStatus(bean.orgId, bean.userId, finalCompetency.competencyId, bean.selectedSlotStatus) }">
					<td style="border:0px" colspan="4"><strong>${finalCompetency.name }
						</strong> – Level Ranking: 
						<c:if test="${finalCompetency.levelRankingValue == ''}">
							N/A
						</c:if>
						<c:if test="${finalCompetency.levelRankingValue != ''}">
							${finalCompetency.levelRankingValue }
						</c:if>
					</td>
				</tr>
				<c:forEach items="${functions:getFinalLevelsByCompetencyId(bean.orgId,bean.userId,finalCompetency.competencyId,bean.selectedSlotStatus)}" var="finalLevel">
					<tr id="level${finalLevel.levelId }" showlevel="1"
						class="levels" competencyid="${finalCompetency.competencyId }"
						slotcount="${functions:getSlotCountByLevelIdAndSlotStatus(bean.orgId, bean.userId, finalLevel.levelId, bean.selectedSlotStatus) }" >
						<td style="border:0px" class="span-3 td-align-right"><strong>${finalLevel.name }</strong></td>
						<td style="border:0px" class="span-15 td-align-right"></td>
						<td style="border:0px" class="span-2 td-align-center">
						<c:choose>
							<c:when test="${finalLevel.totalLevelPoint > 0}">
								<c:set var='maxLevelPoint' value='${functions:getMaxLevelPoint(bean.orgId,finalLevel.levelId ) }'  scope="page" />
								${finalLevel.totalLevelPoint }/${maxLevelPoint }
							</c:when>
							<c:otherwise>
								-
							</c:otherwise>
						</c:choose>
						</td>
						<td style="border:0px" class="span-3 last td-align-center"></td>
					</tr>
					<c:forEach items="${functions:getFinalSlotsByLevelId(bean.orgId,bean.userId,finalLevel.levelId,bean.selectedSlotStatus)}" var="slot">
						<tr id="slot${slot.slotId }" class="slots"
							slotname="${slot.name }" ispassed="${slot.isPassed }"
							levelid="${finalLevel.levelId }">
							<td class="td-align-left span-1 prepend-2" style="vertical-align: top; border:0px;">
								<input type="checkbox" style="vertical-align: middle;"
									id="checkSlot${slot.slotId }" 
									name="checkSlots" value='${slot.slotId }'>
								<strong>${slot.name }</strong>
							</td>
							<td class="span-15 td-align-left" style="vertical-align: top; text-align: justify; border:0px;">
								${slot.description }
							</td>
							<td class="span-2 td-align-center" style="vertical-align: top; border:0px;">
							<c:choose>
								<c:when test="${slot.ratingStatus == true}">
									${slot.pointName }/${slot.maxPointName }
								</c:when>
								<c:otherwise>
									-
								</c:otherwise>
							</c:choose>
							</td>
							<c:choose>
								<c:when test="${slot.isPassed == true}">
								<td class="span-3 last td-align-center" 
									style="vertical-align: top; border:0px;">
									<img src="/ProGate-portlet/images/cds/check-green.png" title="Đạt" width="18px" height="18px"/>	
								</td>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${slot.ratingStatus == true}">
										<td class="span-3 last td-align-center" 
											style="vertical-align: top; padding-top: 7px; border:0px;">
											<img src="/ProGate-portlet/images/cds/x.png" title="Không đạt" width="15px" height="15px"/>	
										</td>
										</c:when>
										<c:otherwise>
										<td class="span-3 last td-align-center" title="Chưa đánh giá"
											style="vertical-align: top; border:0px;">
											<span> - </span>
										</td>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</c:forEach>
			</c:forEach>
		</tbody>
		</table>
		</div>	
	
		<!------------------- List of slots which want to be evaluated ------------------->
		<%-- <div class="prepend-top" style="text-align: center;">
		<c:if test="${bean.lockCDS == false }">
			<input id="down" type="image" width="40px" height="40px" 
				alt="Down" src="/ProGate-portlet/images/cds/arrow-down.png">
			<input id="up" type="image" width="40px" height="40px" 
				alt="Up" src="/ProGate-portlet/images/cds/arrow-up.png">
		</c:if>
		<c:if test="${bean.lockCDS == true }">
			<input id="down" type="image" width="40px" height="40px" 
				alt="Down" src="/ProGate-portlet/images/cds/arrow-down-dis.png">
			<input id="up" type="image" width="40px" height="40px" 
				alt="Up" src="/ProGate-portlet/images/cds/arrow-up-dis.png">
		</c:if>
		</div> --%>
		
		<div style="font-size: 1.3em; margin-top: 25px; margin-bottom: 2px;" class="left  padding-left">	
			<strong>Danh sách các slot muốn đánh giá</strong>	
		</div>
		<div style="margin-top: 28px;" class="right  padding-right">	
			<c:if test="${bean.lockCDS == false }">
			<a id="up" href="#up">
				<img width="17px" height="17px" class="absmiddle" src="/ProGate-portlet/images/cds/delete-slot.png">	
				Xóa slot(s) khỏi "Danh sách các slot muốn đánh giá"
			</a>
			</c:if>
			<c:if test="${bean.lockCDS == true }">
				<img class="absmiddle" src="/ProGate-portlet/images/cds/delete-slot-dis.png" width="18px" height="18px" >	
				<label style="color: gray"> Xóa slot(s) khỏi "Danh sách các slot muốn đánh giá"</label>	
			</c:if>
		</div>
		
		<div style="margin: 0px 3px;">
		<table style="border-collapse: separate; border: 1px solid #DBEEF4; ">
		<thead >
			<tr>
				<th style="border:0px" colspan="2" class="span-18">Mô Tả Slot</th>
				<th style="border:0px" class="span-2">Điểm</th>
				<th style="border:0px" class="span-3 last">Trạng Thái</th>
			</tr>
		</thead>
		<tbody id="belowList" class="scroll-y" style="height: 400px;">
			<c:forEach items="${bean.belowFinalCompetencies }" var="finalCompetency">
				<tr id="evaluationCompetency${finalCompetency.competencyId }"
					class="evaluationCompetencies hide" 
					competencyid="${finalCompetency.competencyId }"
					levelcount="0">
					<td style="border:0px" colspan="4"><strong>${finalCompetency.name }
						</strong> – Level Ranking: 
						<c:if test="${finalCompetency.levelRankingValue == ''}">
							N/A
						</c:if>
						<c:if test="${finalCompetency.levelRankingValue != ''}">
							${finalCompetency.levelRankingValue }
						</c:if>
					</td>
				</tr>
				<c:forEach items="${functions:getFinalLevelsByCompetencyId(bean.orgId,bean.userId,finalCompetency.competencyId, 0)}" var="finalLevel">
					<tr id="evaluationLevel${finalLevel.levelId }"
						class="evaluationLevels hide" showlevel="0" 
						levelid="${finalLevel.levelId }"
						competencyid="${finalCompetency.competencyId }" slotcount="0">
						<td style="border:0px" class="span-3 td-align-right"><strong>${finalLevel.name }</strong></td>
						<td style="border:0px" class="span-15 td-align-right"></td>
						<td style="border:0px" class="span-2 td-align-center">
						<c:choose>
							<c:when test="${finalLevel.totalLevelPoint > 0}">
								<c:set var='maxLevelPoint' value='${functions:getMaxLevelPoint(bean.orgId,finalLevel.levelId ) }'  scope="page" />
								${finalLevel.totalLevelPoint }/${maxLevelPoint }
							</c:when>
							<c:otherwise>
								-
							</c:otherwise>
						</c:choose>
						</td>
						<td style="border:0px" class="span-3 last td-align-center"></td>
					</tr>
					<c:forEach items="${functions:getFinalSlotsByLevelId(bean.orgId,bean.userId,finalLevel.levelId, 0)}" var="slot">
						<tr id="evaluationSlot${slot.slotId }" 
							class="evaluationSlots hide" slotid="${slot.slotId }"
							pointname="${slot.pointName }" pointvalue="${slot.pointValue }"
							levelid="${finalLevel.levelId }" >
							<td class="td-align-left span-1 prepend-2" style="vertical-align: top; border:0px;">
								<input type="checkbox" style="vertical-align: middle;"
									id="checkEvaluationSlot${slot.slotId }" 
									name="checkEvaluationSlots" value='${slot.slotId }' >
								<strong>${slot.name }</strong>
							</td>
							<td class="span-15 td-align-left" style="vertical-align: top; text-align: justify; border:0px;">
								${slot.description }
							</td>
							<td class="span-2 td-align-center" style="vertical-align: top; border:0px; ">
							<c:choose>
								<c:when test="${slot.ratingStatus == true}">
									${slot.pointName }/${slot.maxPointName }
								</c:when>
								<c:otherwise>
									-
								</c:otherwise>
							</c:choose>
							</td>
							<c:choose>
								<c:when test="${slot.isPassed == true}">
								<td class="span-3 last td-align-center" 
									style="vertical-align: top; border:0px; ">
									<img src="/ProGate-portlet/images/cds/check-green.png" title="Đạt" width="18px" height="18px"/>	
								</td>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${slot.ratingStatus == true}">
										<td class="span-3 last td-align-center" 
											style="vertical-align: top; padding-top: 7px; border:0px; ">
											<img src="/ProGate-portlet/images/cds/x.png" title="Không đạt" width="15px" height="15px"/>	
										</td>
										</c:when>
										<c:otherwise>
										<td class="span-3 last td-align-center" title="Chưa đánh giá"
											style="vertical-align: top; border:0px; ">
											<span> - </span>
										</td>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</c:forEach>
			</c:forEach>
		</tbody>
		</table>
		</div>
		
		<div id="emptyList" class="cds-notification hide"
			style="height: 100px; margin: 0px 4px 10px; padding-top: 10px; border: 1px solid #83C7D8; border-top: 0px">
			Hiện không có slot nào trong danh sách này.<br />
			Vui lòng thêm slot vào danh sách từ “<strong>Danh sách các slot</strong>”.
		</div>
		<div class="clear"></div>
		
		<div>
		<div class="prepend-top" style="padding: 0px 15px;">
			<strong>Chú thích: </strong> 
			<input type="checkbox" disabled="disabled" style="vertical-align: middle;"> 
			Slot đã được PM/BOD phê duyệt trong đợt này (checkbox bị disable)
		</div>
		<div class="clear"></div>
			
		<div class="right padding-right padding-bottom">	
		<c:if test="${bean.lockCDS == false }">
			<%-- <a id="save" href='#save' class="cds-btn"><fmt:message key="button.save" /></a>
			<a id="continue" href='#continue' class="cds-btn">Tiếp tục</a>
			<a id="cancel" href='#cancel' class="cds-btn" onclick="this.form.submit()" ><fmt:message key="button.cancel" /></a> --%>
			<input id="save" class="cds-btn" type="button" value="<fmt:message key="button.save" />" >
			<input id="continue" class="cds-btn" type="button" value="Tiếp tục" >
			<input id="cancel" class="cds-btn" type="button" onclick="this.form.submit()" value="<fmt:message key="button.cancel" />" >
		</c:if>
		<c:if test="${bean.lockCDS == true }">
			<input class="cds-btn-dis" type="button" value="<fmt:message key="button.save" />" >
			<input class="cds-btn-dis" type="button" value="Tiếp tục" >
			<input class="cds-btn-dis" type="button" value="<fmt:message key="button.cancel" />" >
		</c:if>
		</div>
		<div class="clear"></div>
		</div>
			
		</c:otherwise>
	</c:choose>
</div>
</form>
</c:otherwise>
</c:choose>

