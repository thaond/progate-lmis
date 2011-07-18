<%@ include file="../../../lmis/grid/grid.jsp" %>
<%@ include file="../../../lmis/init-tvna.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<script type="text/javascript">
		/* jQuery(document).ready(function() {
			jQuery('a.spec').click(function(){
				alert('Ban khong co quyen thuc hien thao tac nay');
			});
		}); */
</script>
<div class="wrapper">
	<div class="header">
		<div id="title">
			 <b><fmt:message key="lmis.ot.request" /></b>
		</div>
	</div>
	<div class="clear"></div>
		<div class="wrap-tabbed" style="padding-left:10px;padding-top:10px">
			<ul class="nav-tabs">
				<c:choose>
	        		<c:when test="${bean.tabAction == bean.TAB_OT_PERSONAL}">
	            		<li><a href='#' class='actived'><fmt:message key="lmis.ot.per" /><span>&nbsp</span><c:out value="${bean.userName }"></c:out> </a></li>
	            	</c:when>
	            	<c:otherwise>
	            		<portlet:renderURL var="requestOverTimeURL">
	            			<portlet:param name="action" value="requestOverTime" />
	            			<portlet:param name="<%=Request.TAB_OT_ACT%>" value="<%=Request.TAB_OT_PER %>" />
	            			<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.MANAGE%>" />
	            			<portlet:param name="<%=Request.ROOT_ID %>" value="${bean.rootId }" />
	            		</portlet:renderURL>
	            		<li><a href='${requestOverTimeURL}'><fmt:message key="lmis.ot.per" /><span>&nbsp</span> <c:out value="${bean.userName }"></c:out></a></li>
	            	</c:otherwise>
	            </c:choose>

	            <c:choose>
	            	<c:when test="${(bean.tabAction==bean.TAB_OT_MANAGER && bean.typeUser ==bean.isBod) }">
	            		<li><a href='#' class='actived'><fmt:message key="lmis.ot.approved" /><span>&nbsp</span> <c:out value="${bean.userName }"></c:out></a></li>
	            	</c:when>
	            	<c:when test="${bean.typeUser !=bean.isBod }">
	            		
	            	</c:when>
	            	<c:otherwise>
	               		<li>
	                   		<portlet:renderURL var="manageRequestOverTimeURL">
	                    		<portlet:param name="action" value="manageRequestOverTime" />
	                    		<portlet:param name="<%=Request.TAB_OT_ACT %>" value="<%=Request.TAB_OT_MANAGER %>" />
	                    		<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.MANAGE %>" />
	                    		<portlet:param name="<%=Request.ROOT_ID %>" value="${bean.rootId}" />
	                   		</portlet:renderURL>
	                    	<a href="${manageRequestOverTimeURL}"><fmt:message key="lmis.ot.approved" /><span>&nbsp</span> <c:out value="${bean.userName }"></c:out></a>
	               		</li>
	                </c:otherwise>

	            </c:choose>

	            <c:choose>
	                <c:when test="${bean.tabAction==bean.TAB_OT_OTHER && bean.typeUser==bean.isSpec}">
	                	<li><a href='#' class='actived'><fmt:message key="lmis.ot.other" /></a></li>
	                </c:when>
	                <c:when test="${bean.tabAction==bean.TAB_OT_OTHER && bean.typeUser==bean.isBod}">
	                	<li><a href='#' class='actived'><fmt:message key="lmis.ot.other" /></a></li>
	                </c:when>
	                <c:when test="${bean.typeUser == bean.isBod}">
	                	 <li>
	                    	<portlet:renderURL var="otherRequestURL">
	                    		<portlet:param name="action" value="otherRequestOverTime" />
	                    		<portlet:param name="<%=Request.TAB_OT_ACT%>" value="<%=Request.TAB_OT_OTHER%>" />
	                    		<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.MANAGE %>" />
	                    		<portlet:param name="<%=Request.ROOT_ID %>" value="${bean.rootId}" />
	                    	</portlet:renderURL>
	                		<a href="${otherRequestURL }"><fmt:message key="lmis.ot.other" /></a>
	                	</li>
	                </c:when>
	                <c:when test="${bean.typeUser != bean.isSpec}">
	                	
	                </c:when>
	                
	            	<c:otherwise>
	                	<li>
	                    	<portlet:renderURL var="otherRequestURL">
	                    		<portlet:param name="action" value="otherRequestOverTime" />
	                    		<portlet:param name="<%=Request.TAB_OT_ACT%>" value="<%=Request.TAB_OT_OTHER%>" />
	                    		<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.MANAGE %>" />
	                    		<portlet:param name="<%=Request.ROOT_ID %>" value="${bean.rootId}" />
	                    	</portlet:renderURL>
	                		<a href="${otherRequestURL }"><fmt:message key="lmis.ot.other" /></a>
	                	</li>
	            	</c:otherwise>
	         	</c:choose>

			</ul>
	    	<div class="boder-bottom-tab"></div>
	    </div>

	 	<div class="clear"></div>
	 	<div class="tab_content">
	 	<c:choose>
    		<c:when test="${bean.tabAction == bean.TAB_OT_PERSONAL}">
    			<c:choose>
    				<c:when test="${bean.cmd == bean.add}">
    						<jsp:include page="addrequest.jsp"></jsp:include>
    				</c:when>
    				<c:when test="${bean.cmd == bean.manage && bean.typeUser==bean.isStaff}">
    						<jsp:include page="requestList.jsp"></jsp:include>
    				</c:when>
    				<c:when test="${bean.cmd == bean.manage && bean.typeUser==bean.isPm}">
    					<jsp:include page="requestListPm.jsp"></jsp:include>
    				</c:when>
    				<c:when test="${bean.cmd == bean.manage && bean.typeUser==bean.isBod}">
    					<jsp:include page="requestListPm.jsp"></jsp:include>
    				</c:when>
    				<c:when test="${bean.cmd == bean.view}">
    						<jsp:include page="viewRequest.jsp"></jsp:include>
    				</c:when>
    				<c:when test="${bean.cmd==bean.edit}">
    						<jsp:include page="editRequest.jsp"></jsp:include>
    				</c:when>
    				
    			</c:choose>
    		</c:when>

    		<c:when test="${bean.tabAction == bean.TAB_OT_MANAGER }">
    			<c:choose>
    				<c:when test="${bean.cmd ==bean.manage && bean.typeUser==bean.isBod}">
    					<jsp:include page="manageRequest.jsp"></jsp:include>
    				</c:when>
    				<c:when test="${bean.cmd == bean.approve  && bean.typeUser==bean.isBod}">
    						<jsp:include page="manageApprove.jsp"></jsp:include>
    				</c:when>
    				<c:when test="${bean.cmd==bean.view  && bean.typeUser==bean.isBod}">
    					<jsp:include page="manageApprove.jsp"></jsp:include>
    				</c:when>
    			</c:choose>
    		</c:when>

    		<c:when test="${bean.tabAction == bean.TAB_OT_OTHER }">
    			<c:choose>
    				<c:when test="${bean.cmd ==bean.manage }">
    					<jsp:include page="other.jsp"></jsp:include>
    				</c:when>
    				<c:when test="${bean.cmd == bean.view }">
    						<jsp:include page="otherDetail.jsp"></jsp:include>
    				</c:when>
    			</c:choose>
    		</c:when>

    		<c:otherwise>
    		</c:otherwise>
    	</c:choose>
	 	</div>

</div>