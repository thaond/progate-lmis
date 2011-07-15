<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ include file="/html/portlet/cds/configuration/configTitle/configTitleValidation.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<c:choose>
<c:when test="${bean.hasPermissionOnTab5 == false}">
	<div class="cds-container">
		<jsp:include page="/html/portlet/cds/configuration/configScreenTabs.jsp"></jsp:include>
		<div class="border-radius" style="min-height: 485px; margin-bottom: 20px;">
			<div class="cds-notification">Rất tiếc! Bạn không có quyền truy cập vào liên kết này.<br/>
				Vui lòng nhấp <a href="#">vào đây</a> để trở lại trang chủ.
			</div>
		</div>	
	</div>
</c:when>
<c:otherwise>
<script type="text/javascript">
	function pagingSubmit() {
	    jQuery('#titleForm').submit();
	}
	
	function disableDeleteButton(){
		jQuery('#deleteTitle').css("color", "gray");
		jQuery('#deleteTitle img').attr('src', '/ProGate-portlet/images/cds/delete2.png');
	}
	function enableDeleteButton(){
		jQuery('#deleteTitle').css("color", "#0066CC");
		jQuery('#deleteTitle img').attr('src', '/ProGate-portlet/images/cds/delete.png');
	}
	
	jQuery(function() {
		/*----uncheck all checkbox when reloading page and disable delete button----*/
		jQuery("input[@name=checkList]").each(function() {
			this.checked = false;
		});
		disableDeleteButton();
		jQuery("#checkAll").attr("checked", false);
		
		/*click checkbox checkAll to auto check all checkboxes and enable/disable delete button*/
		jQuery("#checkAll").click(function() {
			var checked_status = this.checked;
			if(checked_status == true) {
				enableDeleteButton();
			}else {
				disableDeleteButton();
			}
			jQuery("input[@name=checkList]").each(function() {
				this.checked = checked_status;
			});
		});
		/*enable delete button when user check more than one checkbox*/
		jQuery("input[@name=checkList]").click(function() {
			var checked_status = false;
			jQuery("input[@name=checkList]").each(function(i) {
				if(jQuery(this).is(":checked")) {
					checked_status = true;
					return false;
				}
			});
			if (checked_status == true) {
				enableDeleteButton();
		 	}else {
		 		disableDeleteButton();
		 	}
		});
		
	});
</script>
<jsp:include page="/html/portlet/cds/configuration/configTitle/configTitleDialog.jsp"></jsp:include>

<form id="titleForm" name="frmtitle" action="" method="post">
<div class="cds-container">
	<jsp:include page="/html/portlet/cds/configuration/configScreenTabs.jsp"></jsp:include>
	
	<div class="border-radius" style="margin-bottom: 20px;">
	<c:if test="${bean.listSize == 0 }">
		<div style="padding: 22px 22px 450px;">
			<a class="prepend-top" id='addTitle' href="#">
				<img class="absmiddle" src="/ProGate-portlet/images/cds/add.png" width="22px" height="22px"/>
				Thêm Title
			</a>
		</div>
	</c:if>
	<c:if test="${bean.listSize > 0 }">
		<div class="filter-area" style="padding-right: 0px;">
		<div class="span-2 right last">
			<a id='deleteTitle' href="#">
				<img  class="absmiddle" src="" width="22px" height="22px" /> 
				<fmt:message key="button.delete" />
			</a>
		</div>
		<div class="span-2 right">
			<a id='addTitle' href="#">
				<img class="absmiddle" src="/ProGate-portlet/images/cds/add.png" width="22px" height="22px"/>
			 	<fmt:message key="button.add" />
		 	</a>
		</div>
		<div class="clear"> </div>
		</div>
		
		<div class="scroll-x" style="min-height: 450px;">
			<table id="tableTitle" style="width:910px">
			<thead>
				<tr>
					<th class="span-1"><fmt:message key="title.no" /></th>
					<th class="span-1">
						<input type="checkbox" name="checkAll" id="checkAll" 
							style="vertical-align: middle;"/>
					</th>
					<th class="span-1"><fmt:message key="button.edit" /></th>
					<th class="span-3"><fmt:message key="title.title.abbreviation" /></th>
					<th class="span-4"><fmt:message key="title.title.name" /></th>
					<c:forEach items="${bean.competencies}" var="competency" varStatus="count">
						<script>
							var width = {'width' : parseInt(jQuery('#tableTitle').css('width')) + 60 ,};
							jQuery('#tableTitle').css(width);
						</script>
						<th class="span-3">${competency.name }</th>
					</c:forEach>
					<c:if test="${bean.mrSize > 0}">
						<th class="span-4">Minimum Requirement</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
			<c:set value="${bean.pagination}" var="paging"></c:set>
			<c:forEach items="${bean.titles}" var="title" varStatus="count">
				<tr>
					<td class="td-align-center ">${count.count + (paging.currentPage -1) * paging.pageSize}</td>
					<td class="td-align-center ">
						<input type="checkbox" id="check${count.count }" 
							name="checkList" value='${title.cdsTitleId }' 
							style="vertical-align: middle;"/>
					</td>
					<td class="td-align-center ">
						<a class='editTitle' href="#"><img src="/ProGate-portlet/images/cds/edit.gif"/></a>
						<input type="hidden" value='${title.cdsTitleId }' />
						<input type="hidden"  id="abbreviation${count.count }" 
						 	name="abbreviations" class="abbreviations" value='${title.abbreviation }' />
					 	<input type="hidden"  id="titleName${count.count }" 
						 	name="titleNames" class="titleNames" value='${title.name }' />
					</td>
					<td class="td-align-center ">${title.abbreviation }</td>
					<td class="td-align-left ">${title.name }</td>
					
					<c:set var='titleCompetencies' value='${functions:getTitleCompetenciesByTitleId(title.cdsTitleId)}'  scope="page" />
					<c:forEach items="${titleCompetencies}" var="titleCompetency" varStatus="count">
						<td class="td-align-center">${titleCompetency.pointValue }</td>
					</c:forEach>
					
					<c:if test="${bean.mrSize > 0}">
					<td class="td-align-left">${functions:getTitleMRLevelsNameByTitleId(title.cdsTitleId)}</td>
					</c:if>
				</tr>
			</c:forEach>
			</tbody>
			</table>
		</div>
		<div class="clear"> </div>
		
		<c:if test="${bean.listSize > 10 }">
			<div class="cds-paging" style="-moz-border-radius: 5px;">
			<c:set value="${bean.pagination}" var="paging"></c:set>
			<%@ include file="/html/portlet/common/pagination.jsp" %>
			</div>
			<div class="clear"></div>
		</c:if>
	</c:if>
	</div>
</div>
</form>
</c:otherwise>
</c:choose>