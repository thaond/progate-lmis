<%@ include file="../../../lmis/grid/grid.jsp" %>
<%@ include file="../../../lmis/init-tvna.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<div class="wrapper">
	<div class="header">
       	 <div id="title">
            <b><fmt:message key="lmis.attendanceInfo.title"/></b>   
       	</div>
    </div><!--End header-->
    <div class="clear"></div>
	<!-- Tabbed -->
	<div class="wrap-tabbed" style="padding-left:10px;padding-top:10px">
        <ul class="nav-tabs">
        	<c:choose>
        		<c:when test="${bean.tabPersion == 0 }">
        			<!-- disabled tab -->
        		</c:when>
        		<c:otherwise>
        			<c:choose>
		        		<c:when test="${bean.tabAction == bean.TAB_PERSONAL}">
		            		<li><a href='#' class='actived'><fmt:message key="lmis.common.of"/><span>&nbsp</span>${bean.userName}</a></li> 
		            	</c:when>
		            	<c:otherwise>
		            		<portlet:renderURL var="attendanceInfoURL">
		            			<portlet:param name="action" value="attendanceInfo"/>
		            			<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.TAB_PERSONAL %>"/>
		            			<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId }"/>
		            		</portlet:renderURL>
		            		<li><a href='${attendanceInfoURL}'><fmt:message key="lmis.common.of" /><span>&nbsp</span>${bean.userName}</a></li>
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
		            		<li><a href='#' class='actived'><fmt:message key="lmis.common.managerby" /><span>&nbsp</span>${bean.userName }</a></li>
		            	</c:when>
		            	<c:otherwise>        
		               		<li>
		                   		<portlet:renderURL var="managerAttendanceInfoURL">
		                    		<portlet:param name="action" value="managerAttendanceInfo"/>
		                    		<portlet:param name="<%=Request.TAB_ACTION %>" value="<%=Request.TAB_MANAGER %>"/>
		                    		<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}"/>
		                   		</portlet:renderURL>
		                    	<a href="${managerAttendanceInfoURL}"><fmt:message key="lmis.common.managerby" /><span>&nbsp</span>${bean.userName }</a>
		               		</li>
		                </c:otherwise> 
		            </c:choose>
		        </c:otherwise>
		    </c:choose>
            
            <c:choose>
            	<c:when test="${bean.tabOther == 0 }">
            		<!-- disabled tab -->
            	</c:when>           
	            <c:otherwise>
	            	<c:choose>
	            		<c:when test="${bean.tabAction==bean.TAB_OTHER }">
	            			<li><a href='#' class='actived'><fmt:message key="lmis.common.other" /></a></li>
	            		</c:when>
	            		<c:otherwise>        
	               			<li>
	                   			<portlet:renderURL var="otherAttendanceURL">
	                    			<portlet:param name="action" value="otherAttendance"/>
	                    			<portlet:param name="<%=Request.TAB_ACTION %>" value="<%=Request.TAB_OTHER %>"/>
	                    			<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}"/>
	                   			</portlet:renderURL>
	                    		<a href="${otherAttendanceURL}"><fmt:message key="lmis.common.other" /></a>
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
				<jsp:include page="managerAttendance.jsp"></jsp:include>
			</c:when>
			
			<c:when test="${bean.tabAction == bean.TAB_MANAGER}">
				<jsp:include page="managerAttendanceBy.jsp"></jsp:include>
			</c:when>
			
			<c:when test="${bean.tabAction == bean.TAB_OTHER }">
				<jsp:include page="otherAttendance.jsp"></jsp:include>
			</c:when>
			<c:otherwise></c:otherwise>
		</c:choose>
	</div><!--End tab Content -->
</div><!-- End wrapper -->			