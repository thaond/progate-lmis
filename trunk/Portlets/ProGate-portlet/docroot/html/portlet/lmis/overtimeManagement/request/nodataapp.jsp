
<form action="" name="frmRequestOTList" method="post">
	
	<div class="cls-ot">
			<c:if test="${bean.countPending !=0}">  	
	
	    	<div class="createChange"  style="margin-top:-26px">
	    	<span style="font-weight: bold; color: blue">
	    	<fmt:message key="lmis.overtimeReport.youhave">
			<fmt:param><label style="color: red">${bean.countPending}</label></fmt:param>
			</fmt:message></span>
			</div>
		</c:if>
		<div class="tableContainer">
			<div class="filter" style="height: 35px; padding-top: 10px;">
			<div class="selected-org">
				<fmt:message key="lmis.ot.nameorg"/>
				<select name="selectedOrg" style="width: 350px;">
					<option value="-1"><fmt:message key="lmis.common.all"/></option>
				<c:forEach var="subOrg" items="${bean.listSubOrg}" varStatus="countItems">
					<c:choose>
						<c:when test="${bean.selectedOrg == subOrg.orgId}">
							<option selected="selected" value="${subOrg.orgId}">${subOrg.name}</option>
						</c:when>
						<c:otherwise>
							<option value="${subOrg.orgId}">${subOrg.name}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				</select>
			</div>
			<div class="selected-status">
				<fmt:message key="lmis.common.statusLower"/>
				<select name="selectedStatus" style="width: 150px;">
						<option id="allStatus" value="-1" ><fmt:message key="lmis.common.all"/></option>
						<option id="pending" value="<%=LmisConst.OverTimeReq_Status_Pending%>"><fmt:message key="lmis.overtimeReport.status.pending"/></option>
						<option id="accepted" value="<%=LmisConst.OverTimeReq_Status_Accepted%>"><fmt:message key="lmis.overtimeReport.status.accepted"/></option>
						<option id="notAccepted" value="<%=LmisConst.OverTimeReq_Status_NotAccept%>"><fmt:message key="lmis.overtimeReport.status.notAccepted"/></option>
						<option id="reported" value="<%=LmisConst.OverTimeReq_Status_Create_Report%>"><fmt:message key="lmis.ot.type.reported"/></option>
						<option id="banned" value="<%=LmisConst.OverTimeReq_Status_Ban%>"><fmt:message key="lmis.ot.type.baned"/></option>
				</select>
			</div>
			<div class="search-button" style="margin-top: -3px">
				<input id="filter" type="submit" style="height: 26px" class="view" value='<fmt:message key="button.view"/>' />
			</div>
		</div>
			<div style="text-align: center; font-size: 16px;font-weight: bold; "><fmt:message key="lmis.ot.without"></fmt:message> <br/>
			  </div>
		</div>
	</div> 
</form>