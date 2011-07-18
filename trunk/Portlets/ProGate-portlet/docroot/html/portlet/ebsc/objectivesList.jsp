<%@ include file="../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
	jQuery(function(){
		
		// Handle add button
		jQuery(".bt-new a").click(function(e){	
			jQuery("#createObjectiveSet").css("display", "block");
	    	jQuery("#createObjectiveSet").dialog("open");
		});
		
		// Handle delete button	
		jQuery(".bt-delete a").click(function(e){
			
			e.preventDefault();
		});
		
		// Handle Checkbox
		jQuery("#parent_ckb").change(function(e){		
			if(jQuery(this).attr("checked") == true) {			
				jQuery("input[name='child_ckb']").attr("checked",true);
		    }
		    else{	    	
		    	jQuery("input[name='child_ckb']").attr("checked",false);
		    }
		});
		
		jQuery("input[name='child_ckb']").change(function(e){		
			var tr = jQuery(this).parent().parent();
			
			if(jQuery(this).attr("checked") == true) {			
				if(tr.hasClass("objType0").toString() == 'true') {
					//alert("objType0");
				} else if(tr.hasClass("objType1").toString() == 'true') {
					//alert("objType1");
				}
		    }
		    else{	    	
		    	
		    }
		});
		
		// End Handle Checkobx
	});
</script>

<jsp:include page="dialog/dialogCreateObjectiveSet.jsp"></jsp:include>

<form method="post" action="" name="frmObjectiveList">
<div class="tbl-main-content">
<table cellspacing="0" cellPadding="0" width="100%">
<tbody>
<tr>
	<td>
	<div class="bg-dot_1">
	<div class="tbl-right-menu">
		<div>
			<span>
				<fmt:message key="title.search" /> 
			</span>
			
			<input id="search_txt" class="txt-search" 
				maxLength="255" type="text" name="<%=Constants.SEARCH%>" /> 
			
			<span class="bt-search">&nbsp;</span>
		
			<span class="bt-new">
				<a href='#' >
					<fmt:message key="button.new" />
				</a>
			</span>

			<span class="bt-delete">
				<a href='#' >
					<fmt:message key="button.delete" />
				</a>
			</span>	
		</div>
	</div>
	</div>
	</td>
</tr>

<tr>
	<td>
	<table class="tbl-style">
	<tbody>
		<tr class="tbl-header bg-dot_2">
			<td width="4%"><fmt:message key="title.no" /></td>
			<td width="5%">
				<input id="parent_ckb" class="input_header" type="checkbox" />
			</td>
			<td width="5%"><fmt:message key="button.edit" /></td>
			<td width="30%"><fmt:message key="title.objective" /></td>
			<td width="10%"><fmt:message key="title.create.date" /></td>
			<td width="10%"><fmt:message key="title.percent.input" /></td>
			<td width="10%"><fmt:message key="title.percent.complete" /></td>
			<td width="10%"><fmt:message key="title.estimate" /></td>
			<td width="10%"><fmt:message key="title.note" /></td>
		</tr>
		<c:forEach items="${bean.objectivesByOrgID}" var="obj" varStatus="count">
		<c:choose>
		<c:when test="${count.count % 2 != 0}">
			<c:choose>
				<c:when test="${obj.objtype == 0}">
			<tr class="tbl-content-row-0 objType0 ">
				</c:when>
				
				<c:when test="${obj.objtype == 1}">
			<tr class="tbl-content-row-0 objType1 ">					
				</c:when>
				
				<c:otherwise>
			<tr class="tbl-content-row-0 objType3 ">
				</c:otherwise>				
			</c:choose>			
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${obj.objtype == 0}">
			<tr class="tbl-content-row-1 objType0 ">
				</c:when>
				
				<c:when test="${obj.objtype == 1}">
			<tr class="tbl-content-row-1 objType1 ">					
				</c:when>
				
				<c:otherwise>
			<tr class="tbl-content-row-1 objType3 ">
				</c:otherwise>				
			</c:choose>			
		</c:otherwise>
		</c:choose>
				<td class="tbl-cell"><c:out value="${count.count + ( pageNum - 1 ) * pageSize}"/></td>				
				
				<td class="image-cell"  align="center">
				<input type="checkbox" name="<%=Request.CHILD_CKB %>" value='<c:out value="${obj.org_id}"/>'>
				</td>
				
				<td align="center">
					<portlet:renderURL var="editOrgURL">
					    <portlet:param name="action"  
					                   value="showingOrgainzationDetails" />
						<portlet:param name="<%=Request.ORG_ID %>"
					                   value="${bean.org.orgId}" />
					    <portlet:param name="<%=ObjectivesList_RS.OBJ_LIST_ID %>"
					                   value="${obj.orgObjectListId}" />
					    <portlet:param name="<%=Request.TA %>"
					                   value="<%=Request.TA_1_2 %>" />				    
				  	</portlet:renderURL>
				  	
				  	<c:set var="messageObjectiveEdit"><fmt:message key="warning.objective.edit"/></c:set>
					<ui:icon src="<%=request.getContextPath()%>/images/edit_icon.gif"
						message='${messageObjectiveEdit}'
						toolTip="true" url="<%=editOrgURL %>"/>
				</td>
				
				<td>
				<portlet:renderURL var="viewOrgURL">
				    <portlet:param name="action"
				                   value="showingOrgainzationDetails" />					    
				   	<portlet:param name="<%=Request.ORG_ID %>"
					                   value="${bean.org.orgId}" />
					    <portlet:param name="<%=ObjectivesList_RS.OBJ_LIST_ID %>"
					                   value="${obj.orgObjectListId}" />
				    <portlet:param name="<%=Request.TA %>"
				                   value="<%=Request.TA_1_3 %>" />
				</portlet:renderURL>
				<a href='<c:out value="${viewOrgURL}"/>' style="color: blue; text-decoration: none">
				<c:choose>
				<c:when test="${obj.objtype == 0}">
					 <span class="type1"><fmt:message key="title.year" /><c:out value="${obj.year}"/></span>
				</c:when>
				
				<c:when test="${obj.objtype == 1}">
					 <span class="type2"><fmt:message key="title.quarter" />
					 	<fmt:formatNumber type="number" pattern="#" 
					 		value="${obj.month_hash div 100 }"></fmt:formatNumber>
					 </span>
				</c:when>
				
				<c:otherwise>
					<span class="type3"><fmt:message key="titile.month" /><c:out value="${obj.month_hash mod 100}"/></span>
				</c:otherwise>				
				</c:choose>
				</a>
				</td>
				
				<td class="tbl-cell"><fmt:formatDate pattern="dd/MM/yyyy" value="${obj.created_date}" /></td>
				
				<td class="tbl-cell"><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2"
					 		value="${obj.entering_percent * 100}"></fmt:formatNumber> 
				
				<td class="tbl-cell"><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2"
					 		value="${obj.completion_percent * 100}"></fmt:formatNumber>
				
				<td class="tbl-cell">
				<c:choose>
				<c:when test="${obj.isapproved == true}">
					<fmt:message key="title.none.estimate" />
				</c:when>
				<c:otherwise>
					<fmt:message key="title.estimate" />
				</c:otherwise>
				</c:choose>
				</td>
				
				<td class="tbl-cell"><c:out value="${obj.description}"/></td>
			</tr>
		</c:forEach>												
	</tbody>
	</table>
	</td>
</tr>

</tbody>
</table>
</div>
<input type="hidden" name="pagesNum" value="<%=request.getAttribute("pagesNum")%>"/>
<input type="hidden" name="pageNum" value="<%=request.getAttribute("pageNum")%>"/> 
</form>


<FORM NAME="frmMsg">
	<INPUT TYPE="hidden" NAME="MsgTxt" Value="${cobsMsgTxt}">
</FORM>