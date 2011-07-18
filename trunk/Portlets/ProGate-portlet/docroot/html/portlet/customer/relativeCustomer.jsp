<%@page import="java.util.ArrayList"%>
<%@page import="com.larion.progate.common.constants.URLParameter_RS"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.larion.progate.customer.constants.Customer_Const"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="larion.progate.model.ProGateOrgCustomer"%>
<%@page import="java.util.List"%>
<%@page import="larion.progate.service.ProGateOrgCustomerLocalServiceUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	int end = ProGateOrgCustomerLocalServiceUtil.countProGateOrgCustomers(orgId);
	List<ProGateOrgCustomer> list = null;
	
	if (flag == 1) {
		list = ProGateOrgCustomerLocalServiceUtil.getProGateOrgCusts(orgId, 0, end);
	} else {
		list = ProGateOrgCustomerLocalServiceUtil.getProGateOrgPartners(orgId, 0, end);
	}
	
	if (list == null) {
		list = new ArrayList<ProGateOrgCustomer>();
	}
	
	String relativeCusURL = url + StringPool.AMPERSAND + Customer_Const.OBJECT_ID + StringPool.EQUAL;	
%>

<%
if (list.size() > 1) {
%>
<div class="tq-layout-common">
	<div class="tq-header-layout">
		<div class="tq-header-left">
			<%if(flag == 1){
			%>
				<div class="tg-header-td-left">
					<span class="tg-content-orange">Các Khách Hàng Khác</span>
				</div>
			<%}else{ 
			%>
				<div class="tg-header-td-left">
					<span class="tg-content-orange">Các Đối Tác Khác</span>
				</div>
			<% } %>	
		</div>
	</div>
	<br>
	<br>
	
	<div class="cus-relative-layout">
		
	<%
	if(list != null && list.size() != 0){
		for(int i = 0; i < list.size(); i ++){
			ProGateOrgCustomer cus = list.get(i);
			if(cus.getPrimaryKey() != objectId){
	%>
	<div class="cus-image cus-relative">
		<a href="<%= relativeCusURL + cus.getPrimaryKey() %>" title="<%=cus.getCustomerName()  %>">
			<img src="<%=cus.getLogo()  %>" onLoad='scaleImg(this, 145, 100)'/>
		</a>
	</div>
			
	<%
			}
		}
	} 
	%>	
	</div>	
</div>
<%
}
%>