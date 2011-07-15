<%@ include file="../../../lmis/grid/grid.jsp" %>
<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>

<div class="wrapper">
	<div class="header">
       	 <div id="title">
            <b><fmt:message key="lmis.summary.report.header"/></b>   
       	</div>
    </div><!--End header-->
    <div class="clear"></div>
    <c:choose>
     <c:when test="${bean.report == 0 }">
     	<jsp:include page="../../noPermission.jsp"></jsp:include>
    </c:when>
    <c:otherwise>
    <!-- Tabbed -->
    <div class="wrap-tabbed" style="padding-left:10px;padding-top:10px">
   
    
    <ul class="nav-tabs">
        	<c:choose>
        		<c:when test="${bean.tabAction == bean.TAB_ATTENDANCE}">
            		<li><a href='#' class='actived'><fmt:message key="lmis.summary.attendance"/></a></li> 
            	</c:when>
            	<c:otherwise>
            		<portlet:renderURL var="reportAttendanceURL">
            			<portlet:param name="action" value="reportAttendance"/>
            			<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_ATTENDANCE %>"/>
            			<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId }"/>
            		</portlet:renderURL>
            		<li><a href='${reportAttendanceURL}'><fmt:message key="lmis.summary.attendance" /></a></li>
            	</c:otherwise> 
            </c:choose>   
            	
            <c:choose>  
            	<c:when test="${bean.tabAction==bean.TAB_DAYOFF}">
            		<li><a href='#' class='actived'><fmt:message key="lmis.summary.dayoff" /></a></li>
            	</c:when>
            	<c:otherwise>        
               		<li>
                   		<portlet:renderURL var="reportDayOffURL">
                    		<portlet:param name="action" value="reportDayOff"/>
                    		<portlet:param name="<%=Request.TAB_ACTION %>" value="<%=Request.TAB_DAYOFF %>"/>
                    		<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}"/>
                   		</portlet:renderURL>
                    	<a href="${reportDayOffURL}"><fmt:message key="lmis.summary.dayoff" /></a>
               		</li>
                </c:otherwise> 
            </c:choose>
            
            <c:choose>
            	<c:when test="${bean.tabAction==bean.TAB_OVERTIME }">
            		<li><a href="#" class='actived'><fmt:message key="lmis.summary.overtime"/></a></li>
            	</c:when>
            	<c:otherwise>        
               		<li>
                   		<portlet:renderURL var="reportOverTimeURL">
                    		<portlet:param name="action" value="reportOverTime"/>
                    		<portlet:param name="<%=Request.TAB_ACTION %>" value="<%=Request.TAB_OVERTIME %>"/>
                    		<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}"/>
                   		</portlet:renderURL>
                    	<a href="${reportOverTimeURL}"><fmt:message key="lmis.summary.overtime" /></a>
               		</li>
                </c:otherwise> 
            </c:choose>
            
            <c:choose>
            	<c:when test="${bean.tabAction==bean.TAB_REPORT }">
            		<li><a href="#" class='actived'><fmt:message key="lmis.summary.report"/></a></li>
            	</c:when>
            	<c:otherwise>        
               		<li>
                   		<portlet:renderURL var="reportSummaryURL">
                    		<portlet:param name="action" value="reportSummary"/>
                    		<portlet:param name="<%=Request.TAB_ACTION %>" value="<%=Request.TAB_REPORT %>"/>
                    		<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}"/>
                   		</portlet:renderURL>
                    	<a href="${reportSummaryURL}"><fmt:message key="lmis.summary.report" /></a>
               		</li>
                </c:otherwise> 
            </c:choose>               
		</ul>
		<div class="boder-bottom-tab"></div>
		</div><!-- end tabbed -->
		<div class="clear"></div>
		<div class="tab_content">
			<c:choose>
				<c:when test="${bean.tabAction == bean.TAB_ATTENDANCE}">
					<jsp:include page="attendanceReport.jsp"></jsp:include>
				</c:when>
				<c:when test="${bean.tabAction == bean.TAB_DAYOFF }">
					<jsp:include page="dayOffReport.jsp"></jsp:include>
				</c:when>
				<c:when test="${bean.tabAction == bean.TAB_OVERTIME }">
					<jsp:include page="overTimeReport.jsp"></jsp:include>
				</c:when>
				<c:when test="${bean.tabAction == bean.TAB_REPORT}">
					<jsp:include page="sumReport.jsp"></jsp:include>
				</c:when>
			</c:choose>
		</div>
		</c:otherwise>
		</c:choose>
</div><!-- End wrapper -->




















