<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	jQuery(document).ready(function(){
		if (${bean.selectedStatus == 1}){
			jQuery("#status option[value='1']").attr('selected','selected');
		}
		if(${bean.selectedStatus == 2}){
			jQuery("#status option[value='2']").attr('selected','selected');
		}
		if(${bean.selectedStatus == 3}){
			jQuery("#status option[value='3']").attr('selected','selected');
		}
	});
	jQuery(function(){
		jQuery(".txt-search").focus(function() {
			if (jQuery(this).val() == '<fmt:message key="lmis.common.find" />') {
				jQuery(this).val('');
			}
		});
		jQuery(".txt-search").blur(function(){
			if (jQuery(this).val() == "") {
				jQuery(this).val('<fmt:message key="lmis.common.find" />');
			}
		});
		jQuery(".detailRequest").click(function(e){
			var id=e.currentTarget.parentNode.getElementsByTagName("input")[1].value;
			var url = '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
							<portlet:param name="action" value="managerDayOffInfo" />
							<portlet:param name="<%=Request.SELECTED_ID%>" value='id_changetime' />
							<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
							<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_OTHER%>"/>
							<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.VIEW%>"/>
						</portlet:renderURL>';
			url = url.replace("id_changetime",id);
			submit(url);
			
		});
		
		jQuery("#btnViewInfo").click(function(e){
			var url =  '<portlet:renderURL  windowState="<%=WindowState.NORMAL.toString() %>">
						<portlet:param name="action" value="otherDayOff" />
						<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}"/>
						<portlet:param name="<%=Constants.CMD%>" value="viewFilter"/>
						<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_OTHER%>"/>
						</portlet:renderURL>';
			submit(url);
		});
	});
	function submit(url){
		document.frmOtherDayOff.action=url;
		document.frmOtherDayOff.submit();
	}
	function pagingSubmit(){ 
		jQuery('#frmOtherDayOff').submit(); 
	}
</script>

<form action="" name="frmOtherDayOff" id="frmOtherDayOff" method="post"> 	
    <div class="cls-rightAngle" style="margin-right:25em;margin-top:-2.2em">
    <label style="font-weight:bold;color:red"></label>
    </div>
   
    <div class="content">
   <div style="padding:10px 0 0 10px;float:left">
    	<label>Trạng thái</label>
    	<span>
			<select style="width: 130px;height: 22px" name="selectedStatus" id="status">
				<option value="-1">
					<c:out value="Tất cả"/>
				</option>
				<option value="1">
					<c:out value="Chờ phê duyệt"/>
				</option>
				<option value="2">
					<c:out value="Đồng ý"/>
				</option>
				<option value="3">
					<c:out value="Không đồng ý"/>
				</option>
			</select>
		</span>
				
    </div>
    <div style="padding:10px 0 0 80px;float:left">
    	<label>Loại ngày nghỉ</label>
    	<span>
			<select name="absenceType" style="width:150px;height: 22px">
				<option value="-1">
					<c:out value="Tất cả"/>
				</option>
				<c:forEach var="list" items="${bean.lsAbType}" varStatus="itemCount">
					<c:choose>
						<c:when test="${list.lmisAbsenceSettingsId == bean.absenceType }">
							<option value= "${list.lmisAbsenceSettingsId }" selected="selected">
								<c:out value="${list.name_ }"/>
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
		</span>
    </div>
    <div style="float:left;padding:10px 35px 0 10px">
		<input type="button" id="btnViewInfo" value="Xem" style="width:45px;height:25px">
	</div>
    <div class="search" style="margin-left:45px">
		<input class="txt-search" type="text" name="<%=Constants.SEARCH %>"  value='<fmt:message key="lmis.common.find" />'/>
		<span class="bt-search" style="margin-right:-20px">&nbsp</span>
	</div>
	<c:choose>
    	<c:when test="${bean.size ==0 }">
    		<div style="margin-top:20px">
				<%@ include file="../../../lmis/noDataManager.jsp" %>
			</div>
		</c:when>
	<c:otherwise>
    	<div class="tableContainer" style="min-height: 315px">
    		<table class="table" >
    			<thead style="color:#ffffff" >
    				<tr>
						<th class="styleSTT"  scope="col"><fmt:message key="lmis.common.number"/> </th>
						<th width="25%"  scope="col"><fmt:message key="lmis.common.fullname"/> </th>
						<th width="20%"  scope="col"><fmt:message key="lmis.dayoff.type"/></th>
						<th width="12%" scope="col"><fmt:message key="lmis.dayoff.begin"/></th>	
						<th width="12%" scope="col"><fmt:message key="lmis.dayoff.end"/></th>
						<th width="20%" scope="col"><fmt:message key="lmis.common.status"/></th>			
						<th scope="col">&nbsp</th>
					</tr>
    			</thead>
    			<tbody>
    				<c:forEach var="items" items="${bean.listAbsence}" varStatus="itemCount">
    					<c:choose>
							<c:when test="${itemCount.count % 2 !=0 }">
								<tr class="oddrow">
							</c:when>
							<c:otherwise>
								<tr class="evenrow">
							</c:otherwise>
						</c:choose>
									<td>${itemCount.count}</td>
									<td class="cls-left">${functions:getFullName(items.requestedBy)}</td>
									<td class="cls-left">${items.absenceType }</td>
									<td><fmt:formatDate pattern="dd/MM/yyyy" value="${items.startDate }"/></td>
									<td><fmt:formatDate pattern="dd/MM/yyyy" value="${items.endDate }"/></td>
									<td class="cls-left">
											<c:choose>
												<c:when test="${items.requestedStatus==1}">
													<fmt:message key="status.waiting" />
												</c:when>
												<c:when test="${items.requestedStatus==2}">
													<fmt:message key="status.agree" />
												</c:when>
												<c:when test="${items.requestedStatus==3}">
													<fmt:message key="status.notagree" />
												</c:when>
												<c:when test="${items.requestedStatus==6}">
													Đã vô hiệu hóa
												</c:when>
											</c:choose>
									</td>
									<td>
										<input class="detailRequest" type="image" src="/ProGate-portlet/images/lmis/detail.png"
														title='<fmt:message key="lmis.viewDetail"/>'/>
										<input type="hidden" name="absenceRequestsId" value="${items.lmisAbsenceRequestsId }">
									</td>
							</tr>						
    				</c:forEach>
    			</tbody>
    		</table>
    	</div><!-- tableContainer -->
    	<div class="lmis-paging"> 
					<c:set value="${bean.pagination}" var="paging"></c:set> 
						<%@ include file="/html/portlet/common/pagination.jsp" %>  
		</div>
		</c:otherwise>
    </c:choose>
    </div><!-- End content -->
    
</form>