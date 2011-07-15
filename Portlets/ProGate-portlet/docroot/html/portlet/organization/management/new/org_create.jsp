<%@page
	import="com.larion.progate.organization.menu.constants.URL_Const"%>
<%@ include file="init.jsp"%>
<%@ include file="script/new.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="larion.progate.service.ProGateOrgTypeLocalServiceUtil"%>
<%@ page import="larion.progate.model.ProGateOrgType"%>
<%@ page import="larion.progate.model.Region"%>
<%@ page import="larion.progate.model.Organization"%>
<%@ page import="larion.progate.service.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="larion.progate.service.OrganizationLocalServiceUtil"%>
<%@ page import="larion.progate.model.ProGateJournalArticle"%>
<%@ page
	import="larion.progate.service.ProGateJournalArticleLocalServiceUtil"%>
<%@ page
	import="larion.progate.service.ProGateJournalArticleTypesLocalServiceUtil"%>

<%@ page import="com.larion.progate.common.constants.*"%>
<%@ page import="java.util.*"%>
<%
	String defaultCity = (String) request.getAttribute("defaultCity");
	String defaultAddress = (String) request
			.getAttribute("defaultAddress");
	String defaultOrgType = (String) request
			.getAttribute("defaultOrgType");

	String userType = String.valueOf(renderRequest
			.getAttribute("userType"));

	boolean isProGateAdmin = (Boolean) renderRequest
			.getAttribute("isProGateAdmin");

	boolean belongToProGateAdmin = false;
	int orgParentId = 0;
	if (request.getAttribute(URLParameter_RS.ORG_PARENT_ID) != null) {
		orgParentId = (Integer) request
				.getAttribute(URLParameter_RS.ORG_PARENT_ID);
	}

	int orgRootId = 0;
	if (request.getAttribute(URLParameter_RS.ORG_ROOT_ID) != null) {
		orgRootId = (Integer) request
				.getAttribute(URLParameter_RS.ORG_ROOT_ID);
	}
	int viewMode = 0;
	if (request.getAttribute(URLParameter_RS.VIEW_MODE) != null) {
		viewMode = (Integer) request
				.getAttribute(URLParameter_RS.VIEW_MODE);
	}

	List<String> cities = new LinkedList<String>();
	cities.add(res.getString("select"));

	List<String> types = new LinkedList<String>();
	types.add(res.getString("select"));
	try {
		List<ProGateOrgType> orgTypes = ProGateOrgTypeLocalServiceUtil
				.getProGateOrgTypes(0, 100);
		for (ProGateOrgType proGateOrgType : orgTypes)
			types.add(proGateOrgType.getName());

		List<Region> orgCities = RegionLocalServiceUtil
				.getListRegionByCountryCode("VN");
		for (Region region : orgCities)
			cities.add(region.getName());

		renderRequest.setAttribute("types", types);
		renderRequest.setAttribute("cities", cities);
	} catch (Exception e) {
		System.out.println(e.toString());
	}

	String orgId = (String) renderRequest.getAttribute("orgId");
	//System.out.println("orgId=" + orgId);
	String description = "";
	boolean status = true;

	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	try {
		if (orgId != null) {
			Organization org = OrganizationLocalServiceUtil
					.getOrganization(Integer.valueOf(orgId));
			renderRequest.setAttribute("orgId", orgId);
			renderRequest.setAttribute("orgName", org.getName());
			renderRequest.setAttribute("orgType", org.getOrgType());
			renderRequest.setAttribute("orgTypeOf",
					org.getLevelSharing());
			renderRequest.setAttribute("city", org.getCity());
			renderRequest.setAttribute("address", org.getAddress1());
			renderRequest.setAttribute("email", org.getEmail());

			System.out.println(org.getOrgType());
			System.out.println(orgId);

			// lay phan gioi thieu cua Org
			String intro = ProGateJournalArticleTypesLocalServiceUtil
					.getArticleTypeOrgOverallIntro();
			// Introduction
			List<ProGateJournalArticle> listIntro = ProGateJournalArticleLocalServiceUtil
					.getListProGateArticles(Integer.valueOf(orgId),
							intro, "", 0, 2);
			if (listIntro != null)
				if (listIntro.size() > 0)
					description = listIntro.get(0).getContent();

			//System.out.println("description = " + description);

			renderRequest
					.setAttribute("maxUser", org.getMaxUserCount());
			renderRequest.setAttribute("expiredDate",
					df.format(org.getExpiredDate()));
			status = org.getOrgStatus();
			renderRequest.setAttribute("phone", org.getPhone());

			int userId = (Integer) renderRequest.getAttribute("userId");
			long createBy = org.getCreatedBy();
			if (createBy == userId && isProGateAdmin == true)
				belongToProGateAdmin = true;
		} else {
			renderRequest.setAttribute("orgTypeOf", 1);
		}
	} catch (Exception e) {
		// TODO: handle exception
	}

	if (renderRequest.getAttribute("expiredDate") == null) {
		Calendar expiredDate = Calendar.getInstance();
		expiredDate.add(Calendar.YEAR, 1);
		renderRequest.setAttribute("expiredDate",
				df.format(expiredDate.getTime()));
	}

	String viewURL = PortalUtil.getCurrentURL(request);
	boolean subOrg = false;
	if (viewURL.indexOf("taotochuc") != -1) {
		subOrg = true;
		renderRequest.setAttribute("orgTypeOf", 2);
	}
	String homeUrl = PortalUtil.getPortalURL(request);

	String urlSubOrg = ProGateUtil.buildUrl(
			homeUrl + StringPool.SLASH + URL_Const.SUB_ORG,
			new String[] { URLParameter_RS.ORG_ID,
					URLParameter_RS.VIEW_MODE },
			new String[] { Integer.toString(orgRootId),
					Integer.toString(viewMode) });
	//System.out.println("urlSubOrg= " + urlSubOrg);
%>

<style type="text/css">
table {
	border-collapse: separate;
	border-spacing: 1px;
}
</style>

<script type="text/javascript">   
	window.onload = function() {
		jQuery("#orgName").focus();
		jQuery("#hintOrgName").css("display", "block");	
		
		<%if (description != null)%> jQuery("#description").html(jQuery.trim(jQuery("#descriptionOrgTemp").text()));		 
		
		<%if (status == true) {%>
			jQuery('input:radio[name="status"]').filter('[value="true"]').attr('checked', true);
		<%} else {%>	  	
			jQuery('input:radio[name="status"]').filter('[value="false"]').attr('checked', true);
		<%}%>

		<%if (belongToProGateAdmin == false && isProGateAdmin == true
					&& orgId != null) {%>   
			jQuery("#orgName").attr("readonly","readonly");
			jQuery("#phone").attr("readonly","readonly");
			jQuery("#address").attr("readonly","readonly");
			jQuery("#description").attr("readonly","readonly");
			jQuery("#orgName").attr("disabled", true);
			jQuery("#email").attr("disabled", true);
			jQuery("#phone").attr("disabled", true);
			jQuery("#address").attr("disabled", true);
			jQuery("#description").attr("disabled", true);
			jQuery("#orgType").attr("disabled", true);
			jQuery("#orgTypeOf").attr("disabled", true);
			jQuery("#city").attr("disabled", true);		
		<%}%>

		<%if (orgId != null) {%>
			jQuery("#repair-action").css("display", "block");
		<%} else {%>
			jQuery("#add-action").css("display", "block");
		<%}%>

		<%if (belongToProGateAdmin == true && isProGateAdmin == true
					&& orgId != null) {%>
			jQuery("#oldOrgName").val("${orgName}");
		<%}%>
	}
</script>

<div class="new-manage-org-header-add" id="title-action">
	<%
		if (orgId != null) {
	%>
	<%=res.getString("title_edit_org")%>
	<%
		} else {
	%>
	<%=res.getString("title_create_org")%>
	<%
		}
	%>

</div>
<div id="delete-action" style="display: none;">
	<div class="new-manage-org-foresee">
		<img style="vertical-align: middle;"
			src="<%=request.getContextPath()%>/images/news_org/delete.png"
			width="25" height="25" /> <a id="deleteOrg"
			style="text-decoration: none;" href="javascript:void(0);"><%=res.getString("delete")%></a>
	</div>
	<%@ include file="deleteAlert.jsp"%>
</div>


<div class="new-manage-org-note-head">
	<font color="red"><%=res.getString("message_require_fields")%></font>
</div>
<%@ include file="show_success.jsp"%>
<%@ include file="show_error.jsp"%>

<form name="new-manage-org-form" id="new-manage-org-form" method="post"
	action="">
	<input type="hidden" name="orgId" id="orgId" value="<%=orgId%>" /> <input
		type="hidden" name="oldOrgName" id="oldOrgName" value="${orgName}" />
	<input type="hidden" name="<%=URLParameter_RS.ORG_PARENT_ID%>"
		id="orgParentId" value="<%=orgParentId%>" /> <input type="hidden"
		name="<%=URLParameter_RS.ORG_ROOT_ID%>" id="orgRootId"
		value="<%=orgRootId%>" />
	<div class="new-manage-org-table" style="padding-top: 5px;">
		<table width="100%" cellpadding="0" cellspacing="0">
			<TR>
				<TD class="new-manage-org-label"><%=res.getString("organization_name")%>
					(<span style="color: red">*</span>)</TD>

				<TD>
					<div class="new-manage-org-box">
						<INPUT id="orgName" name="orgName" size="70" maxlength="255"
							class="new-manage-org-text" type="text" value="${orgName}"
							onchange="validOrgName();" />
					</div>
					<div id="checkOrgName" class="new-manage-org-hiddenError"></div> <script
						type="text/javascript"> 
					jQuery("#orgName").blur(function(){
						checkExistOrgName();						 		
					});
				</script></TD>
			</TR>

			<TR>
				<TD class="new-manage-org-label"></TD>
				<TD>
					<div class="new-manage-org-box">
						<img src='<%=request.getContextPath()%>/images/info.png'
							width='15px' height='15px' class="new-manage-org-image-hint">
						<span><%=res.getString("message.hint.orgName")%></span>
					</div></TD>
			</TR>
			<c:choose>
				<c:when test="${orgRootId==0}">
					<TR>
						<TD class="new-manage-org-label"><%=res.getString("org_type_of")%>
							(<span style="color: red">*</span>)</TD>
						<TD>
							<div class="new-manage-org-box">
								<SELECT id="orgTypeOf" class="new-manage-org-text"
									name="orgTypeOf">
									<option value="0"
										<c:if test="${orgTypeOf == 0}">selected="true" title="<%= res.getString("org_type_of_0_hint")%>"</c:if>>
										<%=res.getString("org_type_of_0")%>
									</option>
									<option value="1"
										<c:if test="${orgTypeOf == 1}">selected="true" title="<%= res.getString("org_type_of_1_hint")%>"</c:if>>
										<%=res.getString("org_type_of_1")%>
									</option>
									<option value="2"
										<c:if test="${orgTypeOf == 2}">selected="true" title="<%= res.getString("org_type_of_2_hint")%>"</c:if>>
										<%=res.getString("org_type_of_2")%>
									</option>
								</SELECT>
							</div></TD>
					</TR>
				</c:when>
			</c:choose>

			<TR>
				<TD class="new-manage-org-label"><%=res.getString("org_type")%>
					(<span style="color: red">*</span>)</TD>

				<TD>
					<div class="new-manage-org-box">
						<c:set var="currentOrgType" value="${orgType}" scope="page" />
						<SELECT id="orgType" class="new-manage-org-text" name="orgType"
							onchange="validOrgType()">
							<c:forEach var="type" items="${types}">
								<c:choose>
									<c:when test="${type eq defaultOrgType}">
										<c:if test="${orgId ne null}">
											<option value="${type}">
												<c:out value="${type}" />
											</option>
										</c:if>
										<c:if test="${orgId eq null}">
											<option selected="true" value="${type}">
												<c:out value="${type}" />
											</option>
										</c:if>
									</c:when>
									<c:when test="${orgType eq type }">
										<option selected="true" value="${type}">
											<c:out value="${type}" />
										</option>
									</c:when>
									<c:otherwise>
										<option value="${type}">
											<c:out value="${type}" />
										</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</SELECT>
						<script type="text/javascript">					 	
					 	jQuery("#orgType").blur(function(event){
					 		validOrgType();
						});
					</script>
					</div>
					<div id="checkOrgType" class="new-manage-org-hiddenError"></div></TD>
			</TR>

			<TR>
				<TD class="new-manage-org-label"><%=res.getString("country")%>
				</TD>

				<TD>
					<div class="new-manage-org-box">
						<input type="text" name="country" id="country" maxlength="70"
							class="new-manage-org-text" readonly="readonly" value="Việt Nam"
							disabled="true" />
					</div></TD>
			</TR>

			<TR>
				<TD class="new-manage-org-label"><%=res.getString("state_province")%>
					(<span style="color: red">*</span>)</TD>

				<TD>
					<div class="new-manage-org-box">
						<c:set var="currentCity" value="${city}" scope="page" />
						<SELECT id="city" class="new-manage-org-text" name="city"
							onchange="validCity()">
							<c:forEach var="city" items="${cities}">
								<c:choose>
									<c:when test="${city eq defaultCity }">
										<c:if test="${orgId ne null}">
											<option value="${city}">
												<c:out value="${city}" />
											</option>
										</c:if>
										<c:if test="${orgId eq null}">
											<option selected="true" value="${city}">
												<c:out value="${city}" />
											</option>
										</c:if>
									</c:when>
									<c:when test="${city eq currentCity }">
										<option selected="true" value="${city}">
											<c:out value="${city}" />
										</option>
									</c:when>
									<c:otherwise>
										<option value="${city}">${city}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</SELECT>
						<script type="text/javascript">					 	
					 	jQuery("#city").blur(function(event){
					 		validCity();
						});
					 </script>
					</div>
					<div id="checkCity" class="new-manage-org-hiddenError"></div></TD>
			</TR>

			<TR>
				<TD class="new-manage-org-label"><%=res.getString("email")%></TD>

				<TD>
					<div class="new-manage-org-box">
						<INPUT id="email" name="email" size="70" maxlength="50"
							class="new-manage-org-text" type="text" value="${email}" />
						<script type="text/javascript">
						jQuery("#email").blur(function(){
							checkEmail();						 		
						});
					</script>
					</div>
					<div id="checkEmail" class="new-manage-org-hiddenError"></div></TD>
			</TR>


			<TR>
				<TD class="new-manage-org-label"><%=res.getString("telephone")%>
				</TD>

				<TD>
					<div class="new-manage-org-box">
						<INPUT id="phone" name="phone" size="70" maxlength="50"
							class="new-manage-org-text" type="text" value="${phone}" />
						<script type="text/javascript">
					 	jQuery("#phone").focus(function(event){
					 		var phone = jQuery.trim(jQuery('#phone').val());
							if(phone == ''){
				       			jQuery("#phone").val("(+84)");
				       		}
						});
					 	
					 	jQuery("#phone").blur(function(event){
					 		var phone = jQuery.trim(jQuery('#phone').val());
							if(phone == '(+84)'){
				       			jQuery("#phone").val('');
				       		}
						});
					 </script>
					</div>
					<div id="checkPhone" class="new-manage-org-hiddenError"></div></TD>
			</TR>

			<TR>
				<TD class="new-manage-org-label"></TD>
				<TD class="new-manage-org-box"><img
					src='<%=request.getContextPath()%>/images/info.png' width='15px'
					height='15px' class="new-manage-org-image-hint"> <span><%=res.getString("message.hint.phone")%></span>
				</TD>
			</TR>

			<TR>
				<TD class="new-manage-org-label"><%=res.getString("address")%>
				</TD>

				<TD>
					<div class="new-manage-org-box">
						<c:choose>
							<c:when test="${defaultAddress == null}">
								<INPUT id="address" name="address" size="70" maxlength="255"
									class="new-manage-org-text" type="text" value="${address}" />
							</c:when>
							<c:otherwise>
								<INPUT id="address" name="address" size="70" maxlength="255"
									class="new-manage-org-text" type="text"
									value="${defaultAddress}" />
							</c:otherwise>
						</c:choose>

						<script type="text/javascript">
					 	jQuery("#address").keydown(function(event){
				       		if(event.keyCode == 9 || event.keyCode == 8 || event.keyCode == 191 
				       		   || event.keyCode == 37 || event.keyCode == 39){       			
				       		}else{
				       		    if (this.value.length > 255){
				       		    	return false;
				       		    }												       			
				       		}       		
						});
					 </script>
					</div>
					<div id="checkAddress" class="new-manage-org-hiddenError"></div></TD>
			</TR>

			<TR>
				<TD class="new-manage-org-label"></TD>
				<TD class="new-manage-org-box"><img
					src='<%=request.getContextPath()%>/images/info.png' width='15px'
					height='15px' class="new-manage-org-image-hint"> <span><%=res.getString("message.hint.address")%></span>
				</TD>
			</TR>

			<TR>
				<TD class="new-manage-org-label"><%=res.getString("organization_description")%>
					(<span style="color: red">*</span>)</TD>

				<TD>
					<div class="new-manage-org-box">
						<TEXTAREA rows="6" cols="62" maxlength="300" id="description"
							name="description" class=""></TEXTAREA>
					</div>
					<div id="checkDescription" class="new-manage-org-hiddenError">
					</div></TD>
			</TR>

			<TR>
				<TD class="new-manage-org-label"><%=res.getString("max_no_of_users")%>
					(<span style="color: red">*</span>)</TD>

				<TD>
					<div class="new-manage-org-box">
						<c:choose>
							<c:when test="${isProGateAdmin == false}">
								<INPUT id="orgSize" name="orgSize" class="new-manage-org-text"
									type="text" readonly="readonly" value="100"
									style="width: 100px;" disabled="true" />
								<a class="new-manage-org-link" href="javascript:void(0);"><span><%=res.getString("upgrade.orgSize")%></span>
								</a>
							</c:when>
							<c:otherwise>
								<INPUT id="orgSize" name="orgSize" size="70" maxlength="11"
									value="100" class="new-manage-org-text" type="text"
									onkeyup="AcceptDigits(this)" value="${maxUser}" />
								<script type="text/javascript">
							 	jQuery("#orgSize").keydown(function(event){
						       		if(event.keyCode == 9 || event.keyCode == 8 || event.keyCode == 191 
						       		   || event.keyCode == 37 || event.keyCode == 39){       			
						       		}else{
						       		    if (this.value.length > 11){
						       		    	return false;
						       		    }												       			
						       		}       		
								});
							 </script>
							</c:otherwise>
						</c:choose>

					</div>

					<div id="checkOrgSize" class="new-manage-org-hiddenError"></div></TD>
			</TR>

			<TR>
				<TD class="new-manage-org-label"><%=res.getString("subscription_expriration_date")%>
					(<span style="color: red">*</span>)</TD>

				<TD>
					<div class="new-manage-org-box">
						<c:choose>
							<c:when test="${isProGateAdmin == false}">
								<INPUT type="text" name="expiredDate" id="expiredDate"
									class="new-manage-org-text" readonly="readonly" maxlength="70"
									value="${expiredDate}" style="width: 100px;" disabled="true" />
								<a class="new-manage-org-link" href="javascript:void(0);"><span><%=res.getString("extension.expiredDate")%></span>
								</a>
							</c:when>
							<c:otherwise>
								<INPUT type="text" name="expiredDate" id="expiredDate"
									class="new-manage-org-text" maxlength="70"
									value="${expiredDate}" style="width: 100px;" />
								<script type="text/javascript">
				    	  	 	// Calendar
								var pickerOpts = {
										showOn: "both",
										yearRange: "-80:+0",
										buttonImage: "<%=request.getContextPath()%>/images/calendar.gif",
										buttonImageOnly: true,
										dateFormat:"dd/mm/yy",
										onClose: function() {
											document.getElementById("expiredDate").focus();
									    }
								    };
				    	  	 	 jQuery("#expiredDate").datepicker(pickerOpts); 		    	  
							 </script>
							</c:otherwise>
						</c:choose>
					</div>
					<div id="checkExpiredDate" class="new-manage-org-hiddenError">
					</div></TD>
			</TR>

			<TR>
				<TD class="new-manage-org-label"><%=res.getString("status")%> (<span
					style="color: red">*</span>)</TD>

				<TD>
					<div class="new-manage-org-box">
						<div class="new-manage-radio">
							<input type="radio" value="true" name="status"
								class="new-management-org-radio"><%=res.getString("enabled")%>
						</div>
						<div style="float: left; padding-left: 30px">
							<input type="radio" value="false" name="status"
								class="new-management-org-radio"><%=res.getString("disabled")%>
						</div>
					</div></TD>
			</TR>
			<%
				if (subOrg) {
			%>
			<TR>
				<TD><LABEL class="label-field" for="organization_org_status">
						Hồ Sơ Tổ Chức</LABEL></TD>

				<TD style="PADDING-BOTTOM: 1px; MARGIN: 0px; PADDING-TOP: 1px">
					<SPAN
					style="PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; FLOAT: left; PADDING-TOP: 0px">
						<INPUT id="organization_org_status_true" value="0" CHECKED
						tabIndex="12" type=radio name="OrgProfile" /> <LABEL
						class=lbl-for-radio for=organization_org_status_true> Root
							Organization </LABEL> </SPAN> <SPAN style="float: left; padding-left: 17px;">
						<INPUT id="organization_org_status_false" value="1" tabIndex="12"
						type="radio" name="OrgProfile"> <LABEL
						class="lbl-for-radio" for="organization_org_status_false">
							Hồ Sơ Mới</LABEL> </SPAN></TD>
			</TR>
			<%
				}
			%>

			<TR>
				<TD colspan="2">
					<div class="new-manage-org-button-align">
						<div class="new-manage-org-save-button" id="add-action"
							style="display: none;">
							<button style="height: 24px; width: 80px;" class="bt-form"
								id="themOrg">
								<font size="3pt"
									style="font-family: sans-serif; font-size: 13px;">Lưu</font>
							</button>
						</div>

						<div class="new-manage-org-save-button" id="repair-action"
							style="display: none;">
							<button style="height: 24px; width: 80px;" class="bt-form"
								id="suaOrg">
								<font size="3pt"
									style="font-family: sans-serif; font-size: 13px;">Lưu</font>
							</button>
						</div>
						</form>
						<div class="new-manage-org-cancel-button">
							<%
								if (subOrg) {
							%>
							<form method="get" name="cancleAddOrg" action="">
								<a href="<%=urlSubOrg%>">
									<button style="height: 24px; width: 80px;" class="bt-form">
										<font size="3pt"
											style="font-family: sans-serif; font-size: 13px;">Hủy
										</font>
									</button> </a>
							</form>
							<%
								} else {
							%>
							<form method="get" name="cancleAddOrg" action="${pageURL}">
								<c:if test="${userType >= 0 && userType <= 2}">
									<input type="hidden" value="${userType}" name="userType"
										id="userType">
								</c:if>
								<button onclick="submitForm(document.cancleAddOrg)"
									style="height: 24px; width: 80px;" type="submit"
									class="bt-form">
									<font size="3pt"
										style="font-family: sans-serif; font-size: 13px;">Hủy </font>
								</button>
							</form>
							<%
								}
							%>
						</div>
					</div></TD>
			</TR>
		</table>
	</div>
	<div id="descriptionOrgTemp" style="display: none">
		<%=description.trim()%>
	</div>