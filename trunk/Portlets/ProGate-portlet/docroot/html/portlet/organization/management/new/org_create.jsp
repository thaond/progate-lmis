<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="init.jsp"%>
<%@ include file="script/new.jsp"%>

<%
   
    boolean isSignedIn=(Boolean)renderRequest.getAttribute("isSignedIn");

	String defaultCity = "";
	defaultCity = (String) request.getAttribute("defaultCity");

	String defaultAddress = "";
	defaultAddress = (String) request.getAttribute("defaultAddress");

	String defaultOrgType = "";
	defaultOrgType = (String) request.getAttribute("defaultOrgType");

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
		e.printStackTrace();
	}
	String orgId="";
	if(renderRequest.getAttribute("orgId")!=null){
		orgId = (String) renderRequest.getAttribute("orgId");
	}
	
	
	String description = "";
	boolean status = true;

	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	if (!"".equals(orgId)) {
		
		Organization org = OrganizationLocalServiceUtil
				.getOrganization(Integer.valueOf(orgId));
		renderRequest.setAttribute("orgId", orgId);
		renderRequest.setAttribute("orgName", org.getName());
		renderRequest.setAttribute("orgType", org.getOrgType());
		renderRequest.setAttribute("orgTypeOf", org.getLevelSharing());
		renderRequest.setAttribute("city", org.getCity());
		renderRequest.setAttribute("address", org.getAddress1());
		renderRequest.setAttribute("email", org.getEmail());
		
		String intro = ProGateJournalArticleTypesLocalServiceUtil
				.getArticleTypeOrgOverallIntro();
		
		List<ProGateJournalArticle> listIntro = ProGateJournalArticleLocalServiceUtil
				.getListProGateArticles(Integer.valueOf(orgId), intro,
						"", 0, 2);
		if (listIntro != null)
			if (listIntro.size() > 0)
				description = listIntro.get(0).getContent();

		renderRequest.setAttribute("maxUser", org.getMaxUserCount());
		renderRequest.setAttribute("expiredDate",
				df.format(org.getExpiredDate()));
		status = org.getOrgStatus();
		renderRequest.setAttribute("phone", org.getPhone());
		
		int userId=0;
		if(renderRequest.getAttribute("userId")!=null){
		 userId = (Integer) renderRequest.getAttribute("userId");
		}
		
		long createBy = org.getCreatedBy();
		if (createBy == userId && isProGateAdmin == true)
			belongToProGateAdmin = true;
	} else {
		renderRequest.setAttribute("orgTypeOf", 1);
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
	
%>

<c:if test="${isSignedIn == true }">

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

		<%if (belongToProGateAdmin == true && isProGateAdmin == true
					&& orgId != null) {%>
			jQuery("#oldOrgName").val("${orgName}");
		<%}%>
	}
</script>

<div class="new-manage-org-header-add" id="title-action">
	<c:choose>
	  <c:when test="${cmd =='edit'}">
	      <%=res.getString("title_edit_org")%>
	  </c:when>
	  <c:otherwise>
         <%=res.getString("title_create_org")%>
      </c:otherwise>
	</c:choose>
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

<form name="frmNewManageOrg" id="frmNewManageOrg" method="post" action="">
	<input type="hidden" name="orgId" id="orgId" value="<%=orgId%>" /> 
	<input type="hidden" name="currentOrgName" id="currentOrgName" value="${orgName}"/> 
	<input type="hidden" name="isOrgExisted" id="isOrgExisted"/> 
	<input type="hidden" name="<%=URLParameter_RS.ORG_PARENT_ID%>"
		id="orgParentId" value="<%=orgParentId%>" /> 
	<input type="hidden"
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
							class="new-manage-org-text" type="text" value="${orgName}" onblur="checkOrgExist();"/>
					</div>
					<div id="checkOrgName" class="new-manage-org-hiddenError"></div></TD>
			</TR>

			<TR>
				<TD class="new-manage-org-label"></TD>
				<TD>
					<div class="new-manage-org-box">
						<img src='<%=request.getContextPath()%>/images/info.png'
							width='15px' height='15px' class="new-manage-org-image-hint">
						<span><%=res.getString("message.hint.orgName")%></span>
					</div>
				</TD>
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
							</div>
						</TD>
					</TR>
				</c:when>
			</c:choose>

			<TR>
				<TD class="new-manage-org-label"><%=res.getString("org_type")%>
					(<span style="color: red">*</span>)</TD>

				<TD>
					<div class="new-manage-org-box">
						<c:set var="currentOrgType" value="${orgType}" scope="page" />
						<SELECT id="orgType" class="new-manage-org-text" name="orgType">
							<c:forEach var="type" items="${types}">
								<c:choose>
								   <c:when test="${defaultOrgType!=null}">
								      <c:choose>
								         <c:when test="${type == defaultOrgType}">
												<option selected="selected" value="${type}">
													<c:out value="${type}" />
												</option>											    
									     </c:when>
									     <c:otherwise>
									        <option value="${type}"><c:out value="${type}" /></option>	
									     </c:otherwise>
								      </c:choose>  
								   </c:when>
								   <c:otherwise>
								   <c:choose>
								     <c:when test="${orgType == type }">
										<option selected="selected" value="${type}">
											<c:out value="${type}" />
										</option>
									 </c:when>
									 <c:otherwise>
										<option value="${type}">
											<c:out value="${type}" />
										</option>
									 </c:otherwise>
									</c:choose>								    
								   </c:otherwise>									
								</c:choose>
							</c:forEach>
						</SELECT>
					</div>
					<div id="checkOrgType" class="new-manage-org-hiddenError"></div>
				</TD>
			</TR>

			<TR>
				<TD class="new-manage-org-label"><%=res.getString("country")%>
				</TD>

				<TD>
					<div class="new-manage-org-box">
						<input type="text" name="country" id="country" maxlength="70"
							class="new-manage-org-text" readonly="readonly" value="Việt Nam"
							disabled="disabled" />
					</div>
				</TD>
			</TR>

			<TR>
				<TD class="new-manage-org-label"><%=res.getString("state_province")%>
					(<span style="color: red">*</span>)</TD>

				<TD>
					<div class="new-manage-org-box">
						<c:set var="currentCity" value="${city}" scope="page" />
						<SELECT id="city" class="new-manage-org-text" name="city">
							<c:forEach var="ct" items="${cities}">								
								<c:choose>
								   <c:when test="${defaultCity!=null}">
								      <c:choose>
								         <c:when test="${ct == defaultCity}">
												<option selected="selected" value="${ct}">
													<c:out value="${ct}" />
												</option>											    
									     </c:when>
									     <c:otherwise>
									        <option value="${ct}"><c:out value="${ct}" /></option>	
									     </c:otherwise>
								      </c:choose>  
								   </c:when>
								   <c:otherwise>
								   <c:choose>
								     <c:when test="${city == ct }">
										<option selected="selected" value="${ct}">
											<c:out value="${ct}" />
										</option>
									 </c:when>
									 <c:otherwise>
										<option value="${ct}">
											<c:out value="${ct}" />
										</option>
									 </c:otherwise>
								   </c:choose>								    
								   </c:otherwise>									
								</c:choose>								
							</c:forEach>
						</SELECT>
					</div>
					<div id="checkCity" class="new-manage-org-hiddenError"></div>
				</TD>
			</TR>

			<TR>
				<TD class="new-manage-org-label"><%=res.getString("email")%> (<span style="color: red">*</span>) </TD>

				<TD>
					<div class="new-manage-org-box">
						<INPUT id="email" name="email" size="70" maxlength="50"
							class="new-manage-org-text" type="text" value="${email}" />
					</div>
					<div id="checkEmail" class="new-manage-org-hiddenError"></div>
				</TD>
			</TR>


			<TR>
				<TD class="new-manage-org-label"><%=res.getString("telephone")%>
				</TD>

				<TD>
					<div class="new-manage-org-box">
						<INPUT id="phone" name="phone" size="70" maxlength="50"
							class="new-manage-org-text" type="text" value="${phone}" />
					</div>
					<div id="checkPhone" class="new-manage-org-hiddenError"></div>
				</TD>
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
					</div>
					<div id="checkAddress" class="new-manage-org-hiddenError"></div>
				</TD>
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
					<span>
					    <liferay-ui:input-editor
								editorImpl="editor.wysiwyg.portal-web.docroot.html.portlet.progate.edit.view.jsp"
								height="250" 
								width="460px" 
								name="descriptionEditor" 
					            toolbarSet="liferay-article"
					            initMethod='initEditor'
					            onChangeMethod='editorContentChanged'
						/>
						<input type="hidden" name='description' value="<c:out value='<%=description%>'></c:out>" />		
					</span>
					</div>
					<div id="checkDescription" class="new-manage-org-hiddenError">
					</div>
				</TD>
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
							</c:otherwise>
						</c:choose>
					</div>

					<div id="checkOrgSize" class="new-manage-org-hiddenError"></div>
				</TD>
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
									value="${expiredDate}" style="width: 100px;" disabled="disabled" />
								<a class="new-manage-org-link" href="javascript:void(0);"><span><%=res.getString("extension.expiredDate")%></span>
								</a>
							</c:when>
							<c:otherwise>
								<INPUT type="text" name="expiredDate" id="expiredDate"
									class="new-manage-org-text" maxlength="70"
									value="${expiredDate}" style="width: 100px;" />
							</c:otherwise>
						</c:choose>
					</div>
					<div id="checkExpiredDate" class="new-manage-org-hiddenError">
					</div>
				</TD>
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
					</div>
				</TD>
			</TR>
			<%
				if (subOrg) {
			%>
			<TR>
				<TD><LABEL class="label-field" for="organization_org_status">
						Hồ Sơ Tổ Chức</LABEL>
				</TD>

				<TD style="PADDING-BOTTOM: 1px; MARGIN: 0px; PADDING-TOP: 1px">
					<SPAN style="PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; FLOAT: left; PADDING-TOP: 0px">
						<INPUT id="organization_org_status_true" value="0" CHECKED tabIndex="12" type=radio name="OrgProfile" /> 
						<LABEL class=lbl-for-radio for=organization_org_status_true> Root Organization</LABEL> 
					</SPAN> 
					<SPAN style="float: left; padding-left: 17px;">
						<INPUT id="organization_org_status_false" value="1" tabIndex="12"type="radio" name="OrgProfile"> 
						<LABEL class="lbl-for-radio" for="organization_org_status_false">Hồ Sơ Mới</LABEL> 
					</SPAN>
				</TD>
			</TR>
			<%
				}
			%>

			<TR>
				<TD colspan="2">
					<div class="new-manage-org-button-align">

						<div class="new-manage-org-save-button">
							<input style="height: 24px; width: 80px;" class="bt-form"
								id="save" type="button" value="<%=res.getString("ok")%>">
						</div>

						<div class="new-manage-org-cancel-button">
							<%
								if (subOrg) {
							%>
							<a href="<%=urlSubOrg%>"> 
							   <input type="button" style="height: 24px; width: 80px;" class="bt-form"
								      value="<%=res.getString("cancel")%>"> 
						   </a>
							<%
								} else {
							%>
							<c:if test="${userType >= 0 && userType <= 2}">
								<input type="hidden" value="${userType}" name="userType"
									id="userType">
							</c:if>
							<input onclick="cancel('<c:out value='${pageURL}'/>')"
								value="<%=res.getString("cancel")%>"
								style="height: 24px; width: 80px;" type="button" class="bt-form"/>
							<%
								}
							%>
						</div>
					</div>
				</TD>
			</TR>
		</table>
	</div>
	<input type="hidden" name="cmd" value="${cmd}" />
</form>
</c:if>