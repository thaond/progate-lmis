<%@ include file="../../../../common/init.jsp"%>
<%@ include file="../../../../lmis/initOfConfig.jsp"%>

<script type="text/javascript">

function getCheckedOrgId(){
	arrayOrgId.splice(0,arrayOrgId.length);
	jQuery("input[@name=orgCheckBox]:checked").each(function() {
		arrayOrgId.push(jQuery(this).val());
	});
}

function getCheckedOrgEmail(){
	arrayOrgEmailString.splice(0,arrayOrgEmailString.length);
	for( i=0;i<arrayOrgId.length;i++){
		arrayOrgEmailString.push(jQuery("input[@name='"+arrayOrgId[i]+"']").val());
	}
}


//SETTING UP OUR POPUP
//0 means disabled; 1 means enabled;
var popupStatus = 0;

//loading popup with jQuery magic!
function loadPopup(){
	//loads popup only if it is disabled
	if(popupStatus==0){
		jQuery("#backgroundPopup").css({
			"opacity": "0.7"
		});
		jQuery("#backgroundPopup").fadeIn("slow");
		jQuery("#popupOrgRelated").fadeIn("slow");
		popupStatus = 1;
	}
}

//disabling popup with jQuery magic!
function disablePopup(){
	//disables popup only if it is enabled
	if(popupStatus==1){
		jQuery("#backgroundPopup").fadeOut("slow");
		jQuery("#popupOrgRelated").fadeOut("slow");
		popupStatus = 0;
	}
}

//centering popup
function centerPopup(){
	//request data for centering
	var windowWidth = document.documentElement.clientWidth;
	var windowHeight = document.documentElement.clientHeight;
	var popupHeight = jQuery("#popupOrgRelated").height();
	var popupWidth = jQuery("#popupOrgRelated").width();
	//centering
	jQuery("#popupOrgRelated").css({
		"position": "absolute",
		"top": windowHeight/2-popupHeight/2,
		"left": windowWidth/2-popupWidth/2
	});
	//only need force for IE6
	
	jQuery("#backgroundPopup").css({
		"height": windowHeight
	});
	
}


//CONTROLLING EVENTS IN jQuery
jQuery(document).ready(function(){
	
	//LOADING POPUP
	//Click the button event!
	jQuery("#addRelatedOrg").click(function(event){
		//centering with css
		if(isEditable==true){
		centerPopup();
		//load popup
		loadPopup();
		event.preventDefault();
		}
		
	});
				
	//CLOSING POPUP
	//Click the x event!
	jQuery("#popup-close, #cancelPopupOrg").click(function(){
		//cancelSelectEmailOrg();
			var href= '<portlet:actionURL>
						<portlet:param name="action" value="commonController" />
						<portlet:param name="<%=Request.TAB_ACTION%>" value="<%=Request.EMAIL_TAB%>" />
						<portlet:param name="disable" value="false" />
						</portlet:actionURL>';
			
			jQuery.ajax({
				type : "GET",
				url : href,
				data : {
					"orgId" : ${bean.orgId}
				},
				success : function(xmlOrg){
					var emailOrgString="";
					//show email string to textarea
					var OrgEmailDetail = jQuery(xmlOrg).find('OrgRelatedEmail').each(function(){
						emailOrgString += jQuery(this).text()+"; ";
					});
					jQuery("textarea#txtaddOrg").val(emailOrgString);
					//check again all checkboxes of this popup
					jQuery('tbody#orgEmailList input[type="checkbox"]:checked').each(function(){
						this.checked = false;
						});
					<c:forEach var="lmisViewEmailSettingDetailOrg" items="${bean.lmisViewEmailSettingDetailOrgs}" >				
						var orgId="${lmisViewEmailSettingDetailOrg.orgRelatedId}";
						jQuery("input[@value='"+orgId+"'][type='checkbox']").each(function(){
							this.checked = true;
							});
					</c:forEach>
				},
				error : function(){
					alert("co loi xay ra");
					
				}
				
			});
		disablePopup();
		//mySelect(true);
	});

	//Press Escape event!
	jQuery(document).keypress(function(e){
		if(e.keyCode==27 && popupStatus==1){
			disablePopup();
		}
	});

	//check all check box
		jQuery('#checkAllOrg').click(function(){
			var checked_status =this.checked;
			jQuery("input[name='orgCheckBox']").each(function(){
				this.checked =checked_status;
			});
		});
	//click save button
	jQuery('#savePopupOrg').click(function(){
		getCheckedUserId();
		getCheckedOrgId();
		getCheckedOrgEmail();
		getCheckedUserEmail();
		showEmailStringOfPopup();
		disablePopup();
	});	
	
});

/*jQuery("tbody#orgEmailList input[type='checkbox']").click(function(){
	checkAllIf();
});*/

/*function checkAllIf(){
	var count =0;
	var countif =${bean.countOrg};
	
	count=jQuery("#orgEmailList input[type=checkbox][checked]").length;
	alert(countif);
	alert("ra de");
	alert(count);
	if(count==countif){
		alert("hello");
		jQuery("#checkAllOrg").attr("checked","checked");
	}
	else{
		jQuery("#checkAllOrg").removeAttr("checked");
	}
}*/


</script>

<!-- <form name="frmPopupOrg" action="" method="post"> -->
<div id="popupOrgRelated">
	<div class="popupHeader">
		<div class="popHeaderTitle">
			<fmt:message key="lmis.config.email.relatedOrg" />
		</div>
		<div id="popup-close">x</div>
	</div>

	<div id="popupContent">
		<table width="650px" border="1px" bordercolor="#cecece"
			cellpadding="0" cellspacing="0">
			<thead class="header-of-table" style="display:block" align="center">
				<tr>
					<th scope="col" width="30px"><fmt:message key ="lmis.common.number"/></th>
					<th scope="col" width="250px"><fmt:message key="lmis.config.email.popup.orgName"/></th>
					<th scope="col" width="317px"><fmt:message key="lmis.config.email.popup.orgEmail"/></th>
					<th scope="col" width="35px"><input id="checkAllOrg" type="checkbox" /></th>

					<th scope="col" width="17px">&nbsp;</th>
				</tr>
			</thead>
			<c:choose>
				<c:when test="${bean.countUser > 12}">
					<tbody class="tbodyPopupScroll" id="orgEmailList" >
						<c:forEach var="organization" items="${bean.organizations}" varStatus="countStatus">
							<tr>
								<td align="center" width="30px" ><c:out value="${countStatus.count}"/></td>
								<td width="251px" class="text-indent" ><c:out value="${organization.name}" /></td>
								<td width="317px" class="text-indent" ><c:out value="${organization.email}"/></td>				
								<td align="center" width="35px">
									<input name="orgCheckBox" type="checkbox" value='${organization.orgId}' />
									<input type="hidden" name="${organization.orgId}" value="${organization.email}"/>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</c:when>
			<c:otherwise>
				<tbody class="tbodyPopupScroll" id="orgEmailList" >
					<c:forEach var="organization" items="${bean.organizations}" varStatus="countStatus">
						<tr>
							<td align="center" width="30px" ><c:out value="${countStatus.count}"/></td>
							<td width="250px" class="text-indent" ><c:out value="${organization.name}" /></td>
							<td width="317px" class="text-indent" ><c:out value="${organization.email}"/></td>				
							<td align="center" width="35px">
								<input name="orgCheckBox" type="checkbox" value='${organization.orgId}' />
								<input type="hidden" name="${organization.orgId}" value="${organization.email}"/>
							</td>
							<td scope="col" width="17px">&nbsp;</td>
						</tr>
					</c:forEach>
				</tbody>
			</c:otherwise>
			</c:choose>
		</table>

	</div>
	<div align="center"	style="padding-top: 10px; padding-bottom: 10px; clear: both; cursor: pointer;">
		<input class="button-enable" id="savePopupOrg" type="button" value='<fmt:message key="button.add"/>'/> 
		<input class="default-button-enable" id="cancelPopupOrg" type="reset"	value='<fmt:message key="lmis.common.default" />'  />
	</div>
</div>
<!-- </form> -->
<script type="text/javascript">

jQuery(document).ready(function(){
	jQuery('tbody#orgEmailList input[type="checkbox"]:checked').each(function(){
		this.checked = false;
		});
	<c:forEach var="lmisViewEmailSettingDetailOrg" items="${bean.lmisViewEmailSettingDetailOrgs}" >				
		var orgId="${lmisViewEmailSettingDetailOrg.orgRelatedId}";
		jQuery("input[@value='"+orgId+"'][type='checkbox']").each(function(){
			this.checked = true;
			});
	</c:forEach>
});
</script>