<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<portlet:renderURL var="inputData">
	<portlet:param name="action" value="commonController" />
	<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
	<portlet:param name="<%=RequestConst.INPUT_DATA_PAGE %>" value="<%=RequestConst.INPUT_DATA_PAGE_1%>" />
	<portlet:param name="<%=RequestConst.PROJECT_ID%>" value="${bean.selectedProjectId}" />
</portlet:renderURL>

<div class="left padding-top padding-bottom" style="font-size: 1.1em; color: #E46C0A">
	<img class="absmiddle" src="/ProGate-portlet/images/cds/import_big.png"
		width="40px" height="40px" />
	<strong>Nhập Minimum Requirement</strong>
</div>
<div class="right" style="padding-top:35px"><a href="<c:out value="${inputData}"/>"><img class="absmiddle" src="/ProGate-portlet/images/cds/back.png"/> Quay lại</a></div>
<div class="clear"></div>

<form action="" name="addMR" method="post">
<div class=" border-radius">
	<div class="background-radius" style="margin: 2px 2px 10px; padding: 10px;">
		<label class="span-3 padding-bottom"><strong>Nhân viên:  </strong></label>
		<label class="span-8 padding-bottom">${bean.employeeName }</label>
		<label class="span-3 last padding-bottom"><strong>Dự án:  </strong></label>
		<label class="span-8 padding-bottom">${bean.projectOfEmployee }</label>
		<div class="clear"></div>	
		<label class="span-3 "><strong>Chức vụ:  </strong></label>
		<label class="span-8 ">${bean.employeePosition } </label>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<div style="padding-left:12px">
		<c:forEach items="${bean.minimumRequirements}" var="minimumRequirement" varStatus="count">
			<c:set var='MRLevelsCount' value='${functions:getLevelCountByMinimumRequirementId(minimumRequirement.minimumRequirementId) }'  scope="page" />
			
			<div class=" span-5 padding-bottom">
				<label>${minimumRequirement.name }</label>
				<input type="hidden" id="minimumRequirementId${count.count}" 
					name="minimumRequirementsId" 
					value="${minimumRequirement.minimumRequirementId }" />
			</div>
			
			<!--Get List of Minimum Requirement Levels by Id-->
			<c:set var='MRLevels' value='${functions:getLevelsByMinimumRequirementId(minimumRequirement.minimumRequirementId)}'  scope="page" />
			<div class=" span-5 last">
				<c:if test="${MRLevelsCount > 0}">
					<select class=" span-13" id="MRLevelId${count.count}" name="MRLevelsId" >
						<option value="-1">
							Vui lòng chọn
						</option>
					<c:forEach items="${MRLevels}" var="MRLevel" varStatus="count">
						<option value="${MRLevel.minimumRequirementLevelId}">
							<c:out value="${MRLevel.name }" />
						</option>
					</c:forEach>
					</select>
				</c:if>
				<c:if test="${MRLevelsCount == 0}">
					<select disabled="disabled" class=" span-3" id="MRLevelId${count.count}" name="MRLevelsId" >
						<option value="-1">
							N/A
						</option>
					</select>
				</c:if>
			</div>
			<div class="clear"></div>
		</c:forEach>
	</div>
	<div class="clear"></div>
	<center style="padding:10px">
		<input type="submit" value='<fmt:message key="button.save" />' class="cds-btn-yes" /> 
		<input type="submit" value='<fmt:message key="button.cancel" />' class="cds-btn-no" />
	</center>
</div>
</form>

<script type="text/javascript">
	jQuery(function(){
		jQuery(".cds-btn-yes").click(function(e){
			var url = 	'<portlet:actionURL  windowState="<%=WindowState.NORMAL.toString() %>">
							<portlet:param name="action" value="commonController" />
							<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
							<portlet:param name="<%=RequestConst.INPUT_DATA_PAGE %>" value="<%=RequestConst.INPUT_DATA_PAGE_3%>" />
							<portlet:param name="<%=RequestConst.PROJECT_ID%>" value="${bean.selectedProjectId}" />
						</portlet:actionURL>';
			
			var mininumRequirementsId = new Array();
			var mRLevelsId = new Array();
			jQuery('input[@name=minimumRequirementsId]').each(function(index){

				var indexId = index + 1;
				var mRLevelId = jQuery('#MRLevelId'+indexId).val();
				
				if(mRLevelId != -1){
					var minimumRequirementId = jQuery('#minimumRequirementId'+indexId).val();
					mininumRequirementsId.push(minimumRequirementId);				
					mRLevelsId.push(mRLevelId);
				}
				
			});
			//document.addMR.action=url;
			//document.addMR.submit();
		});
		
		jQuery(".cds-btn-no").click(function(e){
			var url = 	'<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
							<portlet:param name="action" value="commonController" />
							<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
							<portlet:param name="<%=RequestConst.INPUT_DATA_PAGE %>" value="<%=RequestConst.INPUT_DATA_PAGE_1%>" />
							<portlet:param name="<%=RequestConst.PROJECT_ID%>" value="${bean.selectedProjectId}" />
						</portlet:renderURL>';
			document.addMR.action=url;
			document.addMR.submit();
		});
	});
</script>
