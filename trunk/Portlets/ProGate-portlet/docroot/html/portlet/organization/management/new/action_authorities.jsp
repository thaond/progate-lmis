<c:set var="status" value="${org.orgStatus}" />
<c:choose>	
	<c:when test="${isProGateAdmin == true}">
		<a href="javascript:void(0);" class="new-manage-org-link" onClick='manipulationOrg(this, ${orgId})'>
			<span id="enable-disable-text">
				<c:if test="${org.orgStatus == false}">
					<%=res.getString("enable")%>
				</c:if>
		    	<c:if test="${org.orgStatus == true}">		    		
					<%=res.getString("disable")%>
		    	</c:if>
		    </span>
		</a>&nbsp; |&nbsp;	
		<a href="javascript:void(0);" class="new-manage-org-link" onClick='toggleActiveOrg(this, ${orgId})'>
			<span id="typical-normal-text">
				<c:choose>
					<c:when test="${org.isProactive == true}">
						<%=res.getString("org.typical")%>
					</c:when>
					<c:otherwise>
						<%=res.getString("org.normal")%>						
					</c:otherwise>
				</c:choose>	
			</span>
		</a>&nbsp; |&nbsp;
		<a href="${pageURL}?cmd=edit&<%= URLParameter_RS.ORG_ID%>=${orgId}" class="new-manage-org-link">
			<%=res.getString("edit")%>
		</a> &nbsp;|&nbsp;
		<a href="javascript:void(0);" class="new-manage-org-link" onClick='deleteOrg(${orgId}, "${org.name}")'><%=res.getString("delete")%></a>	
	</c:when>
	
	<c:when test="${filterType == 0}">
		<!-- Org Admin -->
		<a href="${pageURL}?cmd=edit&<%= URLParameter_RS.ORG_ID%>=${orgId}" class="new-manage-org-link">
			<%=res.getString("edit")%>
		</a> 
		&nbsp;|&nbsp;		
		<a href="javascript:void(0);" class="new-manage-org-link" onClick='manipulationOrg(this, ${orgId})'>
			<span id="enable-disable-text">
				<c:if test="${org.orgStatus == false}">
					<%=res.getString("enable")%>
				</c:if>
		    	<c:if test="${org.orgStatus == true}">
		    		<%=res.getString("disable")%>
		    	</c:if>
		    </span>
		</a>
		&nbsp; |&nbsp;	
		<a href="javascript:void(0);" class="new-manage-org-link" onClick='deleteOrg(${orgId}, "${org.name}")'><%=res.getString("delete")%></a>
		&nbsp; |&nbsp;
		<a href="${userMgmtURL}?<%= URLParameter_RS.ORG_ID%>=${orgId}" class="new-manage-org-link">
			<%=res.getString("user.mgmt")%>
		</a>		 
	</c:when>
	
	<c:when test="${filterType == 1}">
		<!-- Org Member -->		
		<a href="javascript:void(0);" class="new-manage-org-link" onClick='leaveOrg(${orgId},"${org.name}")'><%=res.getString("left")%></a>
	</c:when>
	
	<c:when test="${filterType == 3}">
		<a href="javascript:void(0);" class="new-manage-org-link" onClick='acceptToLeave(${orgId},"${org.name}")'><%=res.getString("cancel.join")%></a>
	</c:when>
	
	<c:when test="${filterType == 4}">
		<a href="javascript:void(0);" class="new-manage-org-link" onClick='acceptToJoin(${orgId},"${org.name}")'><%=res.getString("accepted.join")%></a>
		&nbsp; |&nbsp;
		<a href="javascript:void(0);" class="new-manage-org-link" onClick='rejectToJoin(${orgId},"${org.name}")'><%=res.getString("rejected.join")%></a>
	</c:when>
	
	<c:otherwise>	
		<!-- Others Org -->	
		<c:choose>
			<c:when test="${org.levelSharing == 0}">
				<a href="javascript:void(0);" class="new-manage-org-link" onClick='joinOrg(${orgId},"${org.name}")'><%=res.getString("join")%></a>
			</c:when>
			<c:when test="${org.levelSharing == 1}">
				<a href="javascript:void(0);" class="new-manage-org-link" onClick='joinOrgConfirm(${orgId}, "${org.name}")'><%=res.getString("join")%></a>
			</c:when>
			<c:when test="${org.levelSharing == 2}">
				<a href="javascript:void(0);" class="new-manage-org-link" style="color:#7F7F7F;" title="<%=res.getString("message.hint.join.level.sharing.2")%>"><%=res.getString("join")%></a>
			</c:when>
		</c:choose>		
	</c:otherwise>
</c:choose>

