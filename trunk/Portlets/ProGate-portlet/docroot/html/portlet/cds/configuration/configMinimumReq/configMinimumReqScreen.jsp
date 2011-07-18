<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	<%@ include file="/js/cds/validate.js" %>
</script>
<c:choose>
<c:when test="${bean.hasPermissionOnTab4 == false}">
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
<div class="cds-container">

<jsp:include page="/html/portlet/cds/configuration/configScreenTabs.jsp"></jsp:include>

<div class="border-radius" style="padding:22px; min-height: 460px; margin-bottom: 20px">
<input type = "hidden" id="nextMROrder" value="${bean.nextMROrder}" />
<a href='#' id='addMR'>
	<img class="absmiddle" src="/ProGate-portlet/images/cds/add.png" 
		width="18px" height="18px"/> <fmt:message key="title.minimumReq.action.add" />
</a>
<!-- modal content -->

<table>
	<!--
	<tr>
		<td>Ten</td>
		<td>Mo ta</td> 
		<td>Thu tu</td>
		<td>Them</td>
		<td>Sua</td>
		<td>Xoa</td>
	</tr>
	-->
<!-- bien khoi dau khi lap allMRLevels -->
	<c:set var="init1" value="0" scope="page" />
		
<!-- 	Lap tat ca cac minimumReq -->
	<c:if test="${ bean.sizeOfMRs > 0}">
	<c:forEach var="i" begin="0" end="${bean.sizeOfMRs - 1}">
		<tr class="cds-background-white">
			<td class="span-13">
				<div style="float:left;">
					<img src="/ProGate-portlet/images/cds/tron.png" width="10px" height="10px" style="margin-top: 0.35em"/>
				</div>
				<div style="padding-left: 20px;">  
					<strong><c:out escapeXml="false" value="${bean.mRs[i].name}"></c:out></strong>
				</div>
				<input type="hidden" name="id" value='<c:out value="${bean.mRs[i].minimumRequirementId}" />' /> 
				<input type="hidden" name="name" value='<c:out  value="${bean.mRs[i].name}" />' />
				<input type="hidden" name="nextMRLevelOrders" value='<c:out value="${bean.nextMRLevelOrders[i]}" />' />
				<input type="hidden" name="mRHasLevels" value='<c:out value="${bean.mRHasLevels[i]}" />' />
			</td>
			<td style="vertical-align: top; padding-top: 6px;">
				<fmt:message key="title.CDS.order" />: <c:out value="${bean.mRs[i].numberOrder}"></c:out>
			</td>
			<td class="td-align-left" style="vertical-align: top; padding-top: 3px;">
				<a href="#" class="addMRLevel">
					<img class="absmiddle" src="/ProGate-portlet/images/cds/add.png" 
						width="18px" height="18px"/> <fmt:message key="title.mRLevel.action.add" />
				</a>
			</td>
			<td class="td-align-center" style="vertical-align: top; padding-top: 3px;">
				<a href="#" class="editMR">
					<img class="absmiddle" src="/ProGate-portlet/images/cds/edit.gif" 
						width="18px" height="18px"/> <fmt:message key="title.minimumReq.action.edit" />
				</a>
			</td>
			<td class="td-align-center" style="vertical-align: top; padding-top: 3px;"> 
				<a href="#" class="deleteMR">
					<img class="absmiddle" src="/ProGate-portlet/images/cds/delete.png" 
						width="18px" height="18px"/> <fmt:message key="title.minimumReq.action.delete" />
				</a>
			</td>			
		</tr>

		<!-- Lay ra tat ca cac level cua mRs[i] -->
		<c:if test="${bean.mRHasLevels[i] > 0}">
		<c:forEach var="j" begin="${pageScope.init1}"
			end="${pageScope.init1 + bean.mRHasLevels[i]-1}">
			<tr class="cds-background-white">
				<td class="span-12">
					<div style="padding-left:20px;">
					<div style="float:left;">
						<img src="/ProGate-portlet/images/cds/vuong.png" width="10px" height="10px" style="margin-top: 0.35em"/>
					</div> 
					<div style="padding-left: 20px;"> 
						<c:out value="${bean.allMRLevels[j].name}"></c:out>
					</div>
					</div>
					<input type="hidden" name="id" value='<c:out value="${bean.allMRLevels[j].minimumRequirementLevelId}" />' /> 
					<input type="hidden" name="name" value='<c:out value="${bean.allMRLevels[j].name}" />' />
				</td>
				<td style="vertical-align: top; padding-top: 6px;">
					<fmt:message key="title.CDS.order" />: <c:out value="${bean.allMRLevels[j].numberOrder}"></c:out>	
				</td>
				<td class="td-align-left">
				</td>
				<td class="td-align-center" style="vertical-align: top; padding-top: 3px;">
					<a href="#" class="editMRLevel">
						<img class="absmiddle" src="/ProGate-portlet/images/cds/edit.gif" 
							width="18px" height="18px"/> <fmt:message key="title.mRLevel.action.edit" />
					</a> 
				</td>
				<td class="td-align-center" style="vertical-align: top; padding-top: 3px;">
					<a href="#" class="deleteMRLevel">
						<img class="absmiddle" src="/ProGate-portlet/images/cds/delete.png" 
							width="18px" height="18px"/> <fmt:message key="title.mRLevel.action.delete" />
					</a> 
				</td>
			</tr>
		</c:forEach>
		<c:set var="init1" value="${pageScope.init1+bean.mRHasLevels[i]}"
			scope="page" />
		</c:if>
	</c:forEach>
	</c:if>
</table>
</div>

<jsp:include page="/html/portlet/cds/configuration/configMinimumReq/minimumReqDialog.jsp"></jsp:include>
<jsp:include page="/html/portlet/cds/configuration/configMinimumReq/mRlevelDialog.jsp"></jsp:include>

</div>
</c:otherwise>
</c:choose>