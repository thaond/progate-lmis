<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ include file="/html/portlet/cds/configuration/evaluationPeriods/evaluationPeriodsValidation.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<c:choose>
<c:when test="${bean.hasPermissionOnTab3 == false}">
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
	    jQuery('#periodForm').submit();
	}
	
	function disableDeleteButton(){
		jQuery('#deleteEP').css("color", "gray");
		jQuery('#deleteEP img').attr('src', '/ProGate-portlet/images/cds/delete2.png');
	}
	function enableDeleteButton(){
		jQuery('#deleteEP').css("color", "#0066CC");
		jQuery('#deleteEP img').attr('src', '/ProGate-portlet/images/cds/delete.png');
	}
	
	jQuery(function() {

		/*----uncheck all checkbox when reloading page and disable delete button----*/
		jQuery("input[@name=checkList]").each(function() {
			this.checked = false;
		});
		jQuery("#checkAll").attr("checked", false);
		disableDeleteButton();
		/*-------------------------------*/
		
		/*click checkbox checkAll to check all checkboxes and enable/disable delete button*/
		jQuery("#checkAll").click(function() {
			var checked_status = this.checked;
			if( jQuery("input[@name=checkList]:enabled").length > 0 ) {
				if(checked_status == true) {
					enableDeleteButton();
				}else {
					disableDeleteButton();
				}
				jQuery("input[@name=checkList]:enabled").each(function() {
					this.checked = checked_status;
				});
			}
		});
		/*enable/disable delete button when user check more than one checkbox*/
		jQuery("input[@name=checkList]").click(function() {
			var checked_status = false;
			jQuery("input[@name=checkList]:checked").each(function(i) {
				checked_status = true;
				return false;
			});
			if (checked_status == true) {
				enableDeleteButton();
		 	}else {
		 		disableDeleteButton();
		 	}
		});	
		
	});
</script>

<jsp:include page="/html/portlet/cds/configuration/evaluationPeriods/evaluationPeriodsDialog.jsp"></jsp:include>

<form id="periodForm" name="frmPeriod" action="" method="post">
<div class="cds-container">
	
	<jsp:include page="/html/portlet/cds/configuration/configScreenTabs.jsp"></jsp:include>
	
	<div class="border-radius" style="margin-bottom: 20px;">
	<c:if test="${bean.count == 0 }">
		<div style="padding: 22px 22px 450px;">
			<a class="prepend-top" id='addEP' href="#"><img class="absmiddle" src="/ProGate-portlet/images/cds/add.png" width="22px" height="22px"/>  Thêm đợt CDS</a>
		</div>
	</c:if>
	<c:if test="${bean.count > 0 }">
		<div class="filter-area" >
			<label class="span-2"><fmt:message key="title.ep.status" /> </label>
			<select class="span-3" name="CDS_Status" onchange="this.form.submit()" >
				<option value="0"
					<c:if test="${bean.selectedStatus == 0}">
						<c:out value="selected" />
					</c:if>><fmt:message key="title.ep.status.all" />
				</option>
				<option value="1"
					<c:if test="${bean.selectedStatus == 1}">
						<c:out value="selected" />
					</c:if>><fmt:message key="title.ep.status.new" />
				</option>
				<option value="2"
					<c:if test="${bean.selectedStatus == 2}">
						<c:out value="selected" />
					</c:if>><fmt:message key="title.ep.status.open" />
				</option>
				<option value="3"
					<c:if test="${bean.selectedStatus == 3}">
						<c:out value="selected" />
					</c:if>><fmt:message key="title.ep.status.close" />
				</option>
			</select>
			
			<div class="span-2 right">
				<a id='deleteEP' href="#">
					<img  class="absmiddle" src="" width="22px" height="22px" /> 
					<fmt:message key="button.delete" />
				</a> 
			</div>
			<div class="span-2 right">
				<a id='addEP' href="#">
					<img class="absmiddle" src="/ProGate-portlet/images/cds/add.png" width="22px" height="22px"/>
					<fmt:message key="button.add" />
				</a>
			</div>
			<div class="clear"> </div>
		</div>
		<div class="clear"> </div>
		
		<div style="min-height: 450px;">
		<table>
			<thead>
				<tr>
					<th><fmt:message key="title.ep.no" /></th>
					<th class="td-align-center">
						<input type="checkbox" id="checkAll" value="edit" 
							style="vertical-align: middle;"/>
					</th>
					<th><fmt:message key="title.ep.edit" /></th>
					<th><fmt:message key="title.ep.name" /></th>
					<th><fmt:message key="title.ep.fromDate" /></th>
					<th><fmt:message key="title.ep.toDate" /></th>
					<th><fmt:message key="title.ep.status" /></th>
				</tr>
			</thead>
			<c:if test="${bean.listSize > 0 }">
			<tbody>
			<c:set value="${bean.pagination}" var="paging"></c:set>
			<c:forEach items="${bean.evaluationPeriodsList}" var="eP" varStatus="count">
				<c:set value="${functions:isNotUsed(eP.cdsEvaluationPeriodsId)}" var="isNotUsed"></c:set>
				<tr <c:if test="${isNotUsed == false }">
						style="color: gray;" title="Đợt CDS đã được sử dụng"
					</c:if>>
					<td class="td-align-center">${count.count + (paging.currentPage -1) * paging.pageSize}</td>
					<td class="td-align-center">
						<input type="checkbox" name="checkList" value="${eP.cdsEvaluationPeriodsId}" 
							style="vertical-align: middle;" 
							<c:if test="${isNotUsed == false }">
								disabled="disabled"
							</c:if>/>
						<input type="hidden" id="notUsed${count.count }" 
							name="notUsed" value="${isNotUsed}" />
						<input type="hidden"  id="ePName${count.count }" 
						 	name="ePNames" value='<c:out value="${eP.name }" escapeXml="false" />' />
					 	<input type="hidden" id="fromDate${count.count }" 
							name="fromDate${count.count }" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${eP.fromDate }" />" />
						<input type="hidden" id="toDate${count.count }" 
							name="toDate${count.count }" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${eP.toDate }" />" />
					</td>
					<td class="td-align-center">
						<a class='editEP' href="#"><img src="/ProGate-portlet/images/cds/edit.gif"/></a>
						<input type="hidden" value='${eP.cdsEvaluationPeriodsId}' />
					</td>
					<td class="td-align-left">
						<c:out value="${eP.name }" escapeXml="false" />
					</td>
					<td class="td-align-center">
						<fmt:formatDate pattern="dd/MM/yyyy" value="${eP.fromDate }" />
					</td>
					<td class="td-align-center">
						<fmt:formatDate pattern="dd/MM/yyyy" value="${eP.toDate }" />
					</td>
					<td class="td-align-center">
						<c:choose>
						<c:when test="${eP.status  == 1}">
						    <img src="/ProGate-portlet/images/cds/new.png" title="<fmt:message key="title.ep.tooltip.init" />" width="22px" height="22px"  />
						</c:when>
						<c:when test="${eP.status  == 2}">
						    <img src="/ProGate-portlet/images/cds/open.png" title="<fmt:message key="title.ep.tooltip.open" />" width="22px" height="22px"  />
						</c:when>
						<c:otherwise>
						    <img src="/ProGate-portlet/images/cds/close.png" title="<fmt:message key="title.ep.tooltip.close" />" width="22px" height="22px"  />
						</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
			</tbody>
			</c:if>
			</table>
			
			<c:if test="${bean.listSize == 0 }">
			<div class="cds-notification" style="color:red;">
				<span>Không có dữ liệu</span>
			</div>
			</c:if>
			
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