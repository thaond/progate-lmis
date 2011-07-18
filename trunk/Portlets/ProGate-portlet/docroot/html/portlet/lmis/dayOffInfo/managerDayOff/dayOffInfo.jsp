
<%@ include file="../../../lmis/grid/grid.jsp" %>
<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>

<div class="wrapper">
	<div class="header">
       	 <div id="title">
            <b><fmt:message key="lmis.dayoff.title" /></b>
       	</div>
    </div><!--End header-->
    <div class="clear"></div>
    <!-- Tabbed -->
    <div class="wrap-tabbed" style="padding-left:10px;padding-top:10px">
    <ul class="nav-tabs">
        	<c:choose>
        		<c:when test="${bean.tabPersion == 0 }"><!--disable tab --></c:when>
        		<c:otherwise>
        			<c:choose>
		        		<c:when test="${bean.tabAction == bean.TAB_PERSONAL}">
		            		<li><a href='#' class='actived'><fmt:message key="lmis.common.of" /><span>&nbsp</span>${bean.userName}</a></li>
		            	</c:when>
		            	<c:otherwise>
		            		<portlet:renderURL var="dayOffInfoURL">
		            			<portlet:param name="action" value="commonController" />
		            			<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL %>" />
		            			<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId }" />
		            		</portlet:renderURL>
		            		<li><a href='${dayOffInfoURL}'><fmt:message key="lmis.common.of" /><span>&nbsp</span>${bean.userName}</a></li>
		            	</c:otherwise>
		            </c:choose>
            	</c:otherwise>
            </c:choose>
			
			<c:choose>
            	<c:when test="${bean.tabManager == 0 }">
            		<!-- disabled tab -->
            	</c:when>  
            	<c:otherwise>  
		            <c:choose>
		            	<c:when test="${bean.tabAction==bean.TAB_MANAGER}">
		            		<li><a href='#' class='actived'><fmt:message key="lmis.common.reviewby" /><span>&nbsp</span>${bean.userName }</a></li>
		            	</c:when>
		            	<c:otherwise>
		               		<li>
		                   		<portlet:renderURL var="managerDayOffByURL">
		                    		<portlet:param name="action" value="managerDayOffBy" />
		                    		<portlet:param name="<%=Request.TAB_ACTION %>" value="<%=Request.TAB_MANAGER %>" />
		                    		<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
		                   		</portlet:renderURL>
		                    	<a href="${managerDayOffByURL}"><fmt:message key="lmis.common.reviewby" /><span>&nbsp</span>${bean.userName }</a>
		               		</li>
		                </c:otherwise>
		            </c:choose>
		         </c:otherwise>
		     </c:choose>

			<c:choose>
            	<c:when test="${bean.tabOther == 0}">
            		<!-- disabled tab -->
            	</c:when>  
            	<c:otherwise>  
		            <c:choose>
		            	<c:when test="${bean.tabAction==bean.TAB_OTHER }">
		            		<li><a href="#" class='actived'><fmt:message key="lmis.common.all" /></a></li>
		            	</c:when>
		            	<c:otherwise>
		               		<li>
		                   		<portlet:renderURL var="otherDayOffURL">
		                    		<portlet:param name="action" value="otherDayOff" />
		                    		<portlet:param name="<%=Request.TAB_ACTION %>" value="<%=Request.TAB_OTHER %>" />
		                    		<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
		                   		</portlet:renderURL>
		                    	<a href="${otherDayOffURL}"><fmt:message key="lmis.common.all" /></a>
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
				<c:when test="${bean.cmd == 'null'||bean.cmd==bean.UNDO || bean.cmd == bean.DELETE}">
						<jsp:include page="managerDayOff.jsp"></jsp:include>
					</c:when>
					<c:when test="${bean.cmd == bean.VIEW || bean.cmd==bean.EDIT || bean.cmd == bean.ADD}">
						<jsp:include page="managerDayOffDetail.jsp"></jsp:include>
					</c:when>
				</c:choose>
			</c:when>

			<c:when test="${bean.tabAction == bean.TAB_MANAGER}">
				<c:choose>
					<c:when test="${bean.cmd == 'null' || bean.cmd == bean.UNDO || bean.cmd == 'viewFilter' }">
						<jsp:include page="managerDayOffBy.jsp"></jsp:include>
					</c:when>
					<c:when test="${bean.cmd == bean.VIEW || bean.cmd == bean.REVIEW}">
						<jsp:include page="managerDayOffDetail.jsp"></jsp:include>
					</c:when>
				</c:choose>

			</c:when>

			<c:when test="${bean.tabAction == bean.TAB_OTHER }">
				<c:choose>
					<c:when test="${bean.cmd == 'null' || bean.cmd == bean.UNDO || bean.cmd == 'viewFilter' }">
						<jsp:include page="otherDayOff.jsp"></jsp:include>
					</c:when>
					<c:when test="${bean.cmd == bean.VIEW }">
						<jsp:include page="managerDayOffDetail.jsp"></jsp:include>
					</c:when>
				</c:choose>
			</c:when>

			<c:otherwise></c:otherwise>
		</c:choose>
	</div><!--End tab Content -->

</div><!-- End wrapper -->
