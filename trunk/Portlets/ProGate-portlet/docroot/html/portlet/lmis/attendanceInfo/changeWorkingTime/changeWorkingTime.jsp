<%@ include file="../../../lmis/grid/grid.jsp" %>
<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<div class="wrapper">
	<div class="header">
       	 <div id="title">
            <b><fmt:message key="lmis.changeworkingtime.title" /></b>
       	</div>
    </div><!--End header-->
    <div class="clear"></div>
    <div class="wrap-tabbed" style="padding-left:10px;padding-top:10px">
        <ul class="nav-tabs">
        	<c:choose>
        		<c:when test="${bean.tabPersion == 0 }">
        			<!-- disabled tab -->
        		</c:when>
        		<c:otherwise>
        			<c:choose>
		        		<c:when test="${bean.tabAction == bean.TAB_PERSONAL}">
		            		<li><a href='#' class='actived'><fmt:message key="lmis.common.of" /><span>&nbsp</span>${bean.userName}</a></li>
		            	</c:when>
		            	<c:otherwise>
		            		<portlet:renderURL var="changeTimeWorkingURL">
		            			<portlet:param name="action" value="changeWorkingTime" />
		            			<portlet:param name="<%=Request.TAB_ACT%>" value="<%=Request.TAB_PERSONAL %>" />
		            			<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId }" />
		            		</portlet:renderURL>
		            		<li><a href='${changeTimeWorkingURL}'><fmt:message key="lmis.common.of" /><span>&nbsp</span>${bean.userName}</a></li>
		            	</c:otherwise>
            		</c:choose>
            	</c:otherwise>
            </c:choose>
			
			<c:choose>
            	<c:when test="${bean.tabManager == 0 }">
            		<!--disabled tab  -->
            	</c:when>  
            	<c:otherwise>  
           			 <c:choose>
		            	<c:when test="${bean.tabAction==bean.TAB_MANAGER}">
		            		<li><a href='#' class='actived'><fmt:message key="lmis.common.reviewby" /><span>&nbsp</span>${bean.userName }</a></li>
		            	</c:when>
		            	<c:otherwise>
		               		<li>
		                   		<portlet:renderURL var="managerChangeWorkingTimeURL">
		                    		<portlet:param name="action" value="managerChangeWorkingTime" />
		                    		<portlet:param name="<%=Request.TAB_ACT %>" value="<%=Request.TAB_MANAGER %>" />
		                    		<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
		                   		</portlet:renderURL>
		                    	<a href="${managerChangeWorkingTimeURL}"><fmt:message key="lmis.common.reviewby" /><span>&nbsp</span>${bean.userName }</a>
		               		</li>
		                </c:otherwise>
		            </c:choose>
		        </c:otherwise>
		     </c:choose>   
			
			<c:choose>
            	<c:when test="${bean.tabOther == 0}">
            		<!--disabled tab  -->
            	</c:when>  
            	<c:otherwise>  
		            <c:choose>
		                <c:when test="${bean.tabAction==bean.TAB_OTHER}">
		                	<li><a href='#' class='actived'><fmt:message key="lmis.common.all" /></a></li>
		                </c:when>
		            	<c:otherwise>
		                	<li>
		                    	<portlet:renderURL var="otherChangeWorkingTimeURL">
		                    		<portlet:param name="action" value="otherChangeWorkingTime" />
		                    		<portlet:param name="<%=Request.TAB_ACT%>" value="<%=Request.TAB_OTHER%>" />
		                    		<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
		                    	</portlet:renderURL>
		                		<a href="${otherChangeWorkingTimeURL }"><fmt:message key="lmis.common.all" /></a>
		                	</li>
		            	</c:otherwise>
		         	</c:choose>
		        </c:otherwise>
		    </c:choose>
		</ul>
    	<div class="boder-bottom-tab"></div>
    </div><!-- end tabbed -->
    <div class="clear"></div>
    <div class="tab_content">
    	<c:choose>
    		<c:when test="${bean.tabAction == bean.TAB_PERSONAL}">
    			<c:choose>
	    			<c:when test="${bean.cmd == 'null' || bean.cmd == bean.UNDO_HANDER || bean.cmd == bean.DELETE ||bean.cmd == bean.UPDATE}">
	    				<jsp:include page="changeWorkingTimeList.jsp"></jsp:include>
	    			</c:when>
	    			<c:when test="${bean.cmd == bean.VIEW || bean.cmd == bean.EDIT || bean.cmd == bean.ADD }">
	    				<jsp:include page="changeWorkingTimeDetail.jsp"></jsp:include>
	    			</c:when>
	    			<c:otherwise></c:otherwise>
    			</c:choose>
    		</c:when> <%--End Tab personal --%>

    		<c:when test="${bean.tabAction == bean.TAB_MANAGER }">
    			<c:choose>
    				<c:when test="${bean.cmd == 'null' || bean.cmd == bean.UNDO_HANDER || bean.cmd == bean.AGREE || bean.cmd == bean.NOT_AGREE || bean.cmd == bean.SELECTED}">
    					<jsp:include page="managerChangeWorkingTime.jsp"></jsp:include>
    				</c:when>
    				<c:when test="${bean.cmd == bean.REVIEW || bean.cmd == bean.VIEW }">
    					<jsp:include page="changeWorkingTimeDetail.jsp"></jsp:include>
    				</c:when>
    			</c:choose>
    		</c:when><%--End Tab manager --%>

    		<c:when test="${bean.tabAction == bean.TAB_OTHER }">
    			<c:choose>
    				<c:when test="${bean.cmd =='null' || bean.cmd == bean.UNDO_HANDER || bean.cmd == bean.SELECTED}">
    					<jsp:include page="otherChangeWorkingTime.jsp"></jsp:include>
    				</c:when>
    				<c:when test="${bean.cmd == bean.VIEW }">
    					<jsp:include page="otherChangeWorkingTimeDetail.jsp"></jsp:include>
    				</c:when>
    			</c:choose>
    		</c:when><%--End Tab Other --%>

    		<c:otherwise>
    		</c:otherwise>
    	</c:choose>
    </div>
</div><!-- End wrapper -->

