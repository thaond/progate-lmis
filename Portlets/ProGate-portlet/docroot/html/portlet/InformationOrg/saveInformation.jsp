<%@ include file="init.jsp"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ page import="com.liferay.portal.util.PropsValues"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>


<%@ page import="java.util.*"%>
<%@ page import="larion.progate.model.Organization"%>
<%@ page import="larion.progate.service.*"%>
<%@ page import="larion.progate.model.ProGateOrgType"%>
<%@ page import="larion.progate.model.Region"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="com.liferay.portal.util.PortalUtil"%>
<%
	List<String> cities = new LinkedList<String>();
	cities.add("Vui lòng chọn");
	List<String> types = new LinkedList<String>();
	types.add("Vui lòng chọn");
	try {
		List<ProGateOrgType> orgTypes = ProGateOrgTypeLocalServiceUtil
				.getProGateOrgTypes(0, 100);
		for (ProGateOrgType proGateOrgType : orgTypes) {
			types.add(proGateOrgType.getName());
		}
		List<Region> orgCities = RegionLocalServiceUtil
				.getListRegionByCountryCode("VN");
		for (Region region : orgCities) {
			cities.add(region.getName());
		}
		renderRequest.setAttribute("cities", cities);
		renderRequest.setAttribute("types", types);
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.toString());
	}

	String orgId = (String) request.getAttribute("orgId");

	if (orgId != null) {
		try {
			//Quann comment
			//org = OrganizationLocalServiceUtil.getOrganization(Integer.valueOf(orgId));						

			larion.progate.model.Organization org = null;
			org = larion.progate.service.OrganizationLocalServiceUtil
					.getOrgObjectFromOrgId(Integer.parseInt(orgId));
			//end Quann comment						

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String establishDate = null;
			Date orgFounded = org.getOrgFounded();
			if (orgFounded != null) {
				establishDate = (String) sdf.format(orgFounded
						.getTime());
			}
			establishDate = (establishDate == null) ? ""
					: establishDate;
			request.setAttribute("establishDate", establishDate);

			String founderList = org.getFounderList();
			founderList = (founderList == null) ? "" : founderList;
			request.setAttribute("founder", founderList);

			String orgType = org.getOrgType();
			orgType = (orgType == null) ? "aaa" : orgType;
			request.setAttribute("orgType", orgType);

			String orgSize = String.valueOf(org.getOrgSize());
			orgSize = (orgSize.equals("0")) ? "" : orgSize;
			request.setAttribute("orgSize", orgSize);

			String website = org.getWebsite();
			website = (website == null) ? "" : website;
			request.setAttribute("website", website);
			
// 			String email = org.getEmail();
// 			email = (email == null) ? "" : email;
// 			request.setAttribute("email", email);

			String city = org.getCity();
			city = (city == null) ? "" : city;
			request.setAttribute("city", city);

			String address = org.getAddress1();
			address = (address == null) ? "" : address;
			request.setAttribute("address", address);

			String phone = org.getPhone();
			phone = (phone == null) ? "" : phone;
			request.setAttribute("phone", phone);

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	HttpServletRequest req = PortalUtil
			.getHttpServletRequest(renderRequest);
	String hostAdd = PortalUtil.getHomeURL(req);
	hostAdd = hostAdd + "/tochuc/trangchu";
	request.setAttribute("hostAdd", hostAdd);
	
	String viewMode = (String)renderRequest.getParameter("viewMode");
	renderRequest.setAttribute("viewMode", viewMode);
%>


<script type="text/javascript">   
	window.onload = function() {
	  jQuery("#f_date1").focus();	
	}
	
	/*	
	 * Function to check if this is number key
	 */
	function AcceptDigits(objtextbox)
	{
		var exp = /[^\d]/g;
		objtextbox.value = objtextbox.value.replace(exp,'');
	}
</script>
<script type="text/javascript">
   <%@ include file="/js/test.js" %>
</script>

<style>
.area{
	border: 1px solid #BDC7D8;
    font-family: Arial;
    font-size: 13px;
    height: 100px; 
    width:310px;
    margin-left:5px;
}
</style>


<div class="header_repair"><%=res.getString("repairscreen")%></div>
<div class="foresee"><img style="vertical-align: middle;"
	src="<%=request.getContextPath()%>/images/preview.png" width="25" height="25" />
<%=res.getString("foresee")%></div>

<div class="note_head"><font color="red">(*) Thông tin bắt buộc nhập</font></div>

<%@ include file="showerror.jsp"%>
<%@ include file="showsuccess.jsp"%>
<div align="left"><br />
<form	action="<portlet:actionURL>
	              <portlet:param name="struts_action" value="/InformationOrg/UpdateAction" />
	              <portlet:param name="orgId" value="${orgId}" />
	              <portlet:param name="viewMode" value="${viewMode}" />
	              <portlet:param name="action" value="saveInformation" />
             </portlet:actionURL>" method="post" name="informationOrg">
<TABLE BORDER="0" CELLSPACING="0" CELLPADDING="0" class="editor">
	<tr>
		<td class="label" width="145px"><%=res.getString("establishDate")%>
		(<font color="red">*</font>)</td>
		<td width="535px">
		
				<INPUT id="f_date1" type="text" name="f_date1" class="inputtext" style="width:291px;" 
				   maxlength="70" value="${establishDate}"/>
    	  	 <script type="text/javascript">
    	  	 	// Calendar
				var pickerOpts = {
						showOn: "both",
						yearRange: "-80:+0",
						buttonImage: "<%=request.getContextPath()%>/images/calendar.gif",
						buttonText: "Open datepicker",
						buttonImageOnly: true,
						dateFormat:"dd/mm/yy",
						onClose: function() {
							document.getElementById("f_date1").focus();
					    }
				    };
    	  	 	 jQuery("#f_date1").datepicker(pickerOpts); 
    	  	 	 
    	  	 	
    	  	 </script> 	
			    					    				
			 <div id="checkEstablishDate" style="display:none;clear:both;"></div>									    		
    	</div>		
		</td>
</tr>

	<tr>
		<td class="label"><%=res.getString("typeOfActivity")%> (<font
			color="red">*</font>)</td>
		<td>
		<div class="inputtype"><c:set var="currentOrgType"
			value="${orgType}" scope="page"></c:set> <select id="orgType"
			name="orgType" class="select-field">
			<c:forEach var="type" items="${types}" varStatus="count">
				<c:choose>
					<c:when test="${type eq pageScope.currentOrgType}">
						<option selected="true" value="${type}"><c:out
							value="${type}" /></option>
					</c:when>
					<c:otherwise>
						<option value="${type}"><c:out value="${type}" /></option>
					</c:otherwise>
				</c:choose>

			</c:forEach>
		</select></div>
		<div id="checkOrgType" style="display: none; clear: both;"></div>
		</td>
	</tr>
	<tr>
		<td class="label"><%=res.getString("quantityOfMembers")%> (<font
			color="red">*</font>)</td>
		<td>
		<div class="inputtype"><input type="text" name="orgSize"
			id="orgSize" maxlength="70" class="inputtext"
			onkeyup="AcceptDigits(this)" value="${orgSize}" />
		<div id="checkOrgSize" style="display: none; clear: both;"></div>
		</div>
		</td>
	</tr>

	<tr>
		<td class="label"><%=res.getString("founder")%> (<font
			color="red">*</font>)</td>
		<td>
		<div class="inputtype"><input type="text" name="founder"
			id="founder" maxlength="70" class="inputtext" value="${founder}" /></div>
		<div id="checkFounder" style="display: none; clear: both;"></div>
		</td>
	</tr>

	<tr>
		<td class="label"><%=res.getString("website")%> (<font
			color="red">*</font>)</td>
		<td>
		<div class="inputtype"><input type="text" name="website"
			id="website" maxlength="70" class="inputtext" value="${website}" />
		<div id="checkWebsite" style="display: none; clear: both;"></div>
		</div>
		</td>
	</tr>
	
<!-- 	<tr> -->
<%-- 		<td class="label"><%=res.getString("email")%> (<font --%>
<!-- 			color="red">*</font>)</td> -->
<!-- 		<td> -->
<!-- 		<div class="inputtype"><input type="text" name="email" -->
<%-- 			id="email" maxlength="70" class="inputtext" value="${email}" /> --%>
<!-- 		<div id="checkEmail" style="display: none; clear: both;"></div> -->
<!-- 		</div> -->
<!-- 		</td> -->
<!-- 	</tr> -->

	<tr>
		<td class="label"><%=res.getString("country")%></td>
		<td>
		<div class="inputtype"><input type="text" name="country"
			id="country" maxlength="70" class="inputtext" readonly="readonly"
			value="Việt Nam" /></div>
		</td>
	</tr>

	<tr>
		<td class="label"><%=res.getString("province")%> (<font color="red">*</font>)</td>
		<td>
		<div class="inputtype"><c:set var="currentCity" value="${city}"
			scope="page"></c:set> <select id="city" name="city"
			class="select-field">
			<c:forEach var="city" items="${cities}" varStatus="count">
				<c:choose>
					<c:when test="${city eq pageScope.currentCity}">
						<option selected="true" value="${city}"><c:out
							value="${city}" /></option>
					</c:when>
					<c:otherwise>
						<option value="${city}"><c:out value="${city}" /></option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select></div>
		<div id="checkCity" style="display: none; clear: both;"></div>
		</td>
	</tr>

	<tr>
		<td class="label"><%=res.getString("telephone")%> (<font color="red">*</font>)</td>
		<td>
		<div class="inputtype"><input type="text" name="phone"
			id="phone" maxlength="100" class="inputtext"
			value="${phone}" />
		<div id="checkPhone" style="display: none; clear: both;"></div>
		</div>
		</td>
	</tr>

	<tr>
		<td class="label"><%=res.getString("address")%> (<font color="red">*</font>)</td>
		<td>
			<div class="inputtype">
				<textarea name="address" id="address" class="area" maxlength="100" COLS=40 ROWS=6>${address}</textarea>			
				<div id="checkAddress" style="display: none; clear: both;"></div>
			</div>
		</td>
	</tr>

	<tr>
		<td colspan="2">
		<div class="div_registerH save_button">
		<button id="save_information" class="bt-form"
			style="height: 24px; width: 80px;"><font size="3pt"
			style="font-family: sans-serif; font-size: 13px;"><%=res.getString("save")%></font></button>
		</div>
		</form>
		<form action="<%=hostAdd%>" name="ReturnInformationOrg" method="get">
		<div class="div_registerH cancel_button"><input type="hidden"
			id="orgId" name="orgId" value="${orgId}" /><input type="hidden" id="viewMode" name="viewMode" value="${viewMode}"/>
		<button id="cancel_information" type="submit" class="bt-form"
			style="height: 24px; width: 80px;"
			onclick="submitForm(document.ReturnInformationOrg)"><font
			size="3pt" style="font-family: sans-serif; font-size: 13px;"><%=res.getString("cancel")%></font></button>
		</div>
		</form>
		</td>
	</tr>
</TABLE>
</div>
