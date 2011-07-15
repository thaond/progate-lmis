<%@ include file="../../../../common/init.jsp"%>
<%@ include file="../../../../lmis/initOfConfig.jsp"%>

<script type="text/javascript"><!--

/*get all id of checked mails*/
function getCheckedUserId(){
	arrayUserId.splice(0,arrayUserId.length);
	jQuery("input[@name=staffCheckbox]:checked").each(function() {
	arrayUserId.push(jQuery(this).val());
	});
}

function getCheckedUserEmail(){
	arrayUserEmailString.splice(0,arrayUserEmailString.length);
	for(i=0;i<arrayUserId.length;i++){
		arrayUserEmailString.push(jQuery("input[@name='"+arrayUserId[i]+"']").val());
	}
}
//SETTING UP OUR POPUP
//0 means disabled; 1 means enabled;
var popupStatus = 0;

//loading popup with jQuery magic!
function loadPopupStaff(){
	//loads popup only if it is disabled
	if(popupStatus==0){
		jQuery("#backgroundPopup").css({
			"opacity": "0.7"
		});
		jQuery("#backgroundPopup").fadeIn("slow");
		jQuery("#popupPeopleGetInvolved").fadeIn("slow");
		popupStatus = 1;
	}
}

//disabling popup with jQuery magic!
function disablePopupStaff(){
	//disables popup only if it is enabled
	if(popupStatus==1){
		jQuery("#backgroundPopup").fadeOut("slow");
		jQuery("#popupPeopleGetInvolved").fadeOut("slow");
		
		popupStatus = 0;
	}
}

//centering popup
function centerPopupStaff(){
	//request data for centering
	var windowWidth = document.documentElement.clientWidth;
	var windowHeight = document.documentElement.clientHeight;
	var popupHeight = jQuery("#popupPeopleGetInvolved").height();
	var popupWidth = jQuery("#popupPeopleGetInvolved").width();
	//centering
	jQuery("#popupPeopleGetInvolved").css({
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
	jQuery("#addStaff").click(function(event){
		if(isEditable==true){
		//centering with css
		centerPopupStaff();
		//load popup
		loadPopupStaff();
		event.preventDefault();
		}
	});
				
	//CLOSING POPUP
	//Click the x event!
	jQuery("#close-popup-staff, #cancelPopupStaff").click(function(){
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
					success : function(xmlUser){
						var emailUserString = "";
						//show email string to textarea
						var userEmail= jQuery(xmlUser).find('UserEmail').each(function(){
							emailUserString += jQuery(this).text()+"; ";
						});

						jQuery("textarea#txtaddUser").val(emailUserString);
						//check again all checkboxes of this popup
						jQuery('tbody#userEmailList input[type="checkbox"]:checked').each(function(){
							this.checked = false;
							});
						<c:forEach var="lmisViewEmailSettingDetailUser" items="${bean.lmisViewEmailSettingDetailUsers}" >		
							var userId="${lmisViewEmailSettingDetailUser.userRelatedId}";
							jQuery("input[@value='"+userId+"'][type='checkbox']").each(function(){
								this.checked = true;
								});
						</c:forEach>
					},
					error : function(){
						alert("co loi xay ra");
						
					}
					
				});

				disablePopupStaff();
	});
	
	//Click out event!
// 	jQuery("#backgroundPopup").click(function(){
// 		disablePopup();
// 	});
	//Press Escape event!
	jQuery(document).keypress(function(e){
		if(e.keyCode==27 && popupStatus==1){
			disablePopupStaff();
		}
	});
	
	
	jQuery('#savePopupStaff').click(function(){
		getCheckedUserId();
		getCheckedOrgId();
		getCheckedUserEmail();
		getCheckedOrgEmail();
		showEmailStringOfPopup();
		disablePopupStaff();
		
	});

	
	jQuery("#userEmailList input[type='checkbox']").change(function(){
		var count =0;
		count=jQuery("#userEmailList input[type=checkbox][checked]").length;
		if(${bean.countUser==count}){
			jQuery("#checkAllStaff").attr("checked","checked");
		}
		jQuery("#checkAllStaff").removeAttr("checked");
	});
	
	//check all check box
	jQuery('#checkAllStaff').click(function(){
		var checked_status =this.checked;
		jQuery("input[name='staffCheckbox']").each(function(){
			this.checked =checked_status;
		});
	});
	
});


</script>
<!-- <form name="frmPopupStaff" action="" method="post"> -->
<div id="popupPeopleGetInvolved">
	<div class="popupHeader">
		<div class="popHeaderTitle">
			<fmt:message key="lmis.config.email.peopleGetInvolved" />
		</div>
		<div id="close-popup-staff">x</div>
	</div>
			
	<div id="popupContent">
		<table width="650px" border="1px" bordercolor="#cecece"
			cellpadding="0" cellspacing="0">
			<thead class="header-of-table" style="display:block">
				<tr>
					<th scope="col" width="30px"><fmt:message	key="lmis.common.number" /></th>
					<th scope="col" width="250px"><fmt:message key="lmis.config.email.popup.memberName"/></th>
					<th scope="col" width="317px"><fmt:message key="lmis.config.email.popup.memberMail"/></th>
					<th scope="col" width="35px"><input id="checkAllStaff" name="checkAllStaff" type="checkbox" /></th>
					<th scope="col" width="17px">&nbsp;</th>
				</tr>
			</thead>
			<c:choose>
				<c:when test="${bean.countUser > 12}">
					<tbody class="tbodyPopupScroll" id="userEmailList">
					<c:forEach var="lmisViewStaffRootOrgFN" items="${bean.lmisViewStaffRootOrgFNs}" varStatus="countStatus">
						<tr>
							<td align="center" width="30px" >${countStatus.count}</td>
							<td width="251px" class="text-indent" >${lmisViewStaffRootOrgFN.fullName}</td>
							<td width="317px" class="text-indent" >${lmisViewStaffRootOrgFN.emailAddress}</td>
							<td  align="center" width="35px">
								<input type="checkbox" name="staffCheckbox" class="staffCheckbox" value='${lmisViewStaffRootOrgFN.userId}' />
								<input type="hidden" name="${lmisViewStaffRootOrgFN.userId}" value="${lmisViewStaffRootOrgFN.emailAddress}"/>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</c:when>
				<c:otherwise>
					<tbody class="tbodyPopupScroll" id="userEmailList">
						<c:forEach var="lmisViewStaffRootOrgFN" items="${bean.lmisViewStaffRootOrgFNs}" varStatus="countStatus">
							<tr>
								<td align="center" width="30px" >${countStatus.count}</td>
								<td width="250px" class="text-indent" >${lmisViewStaffRootOrgFN.fullName}</td>
								<td width="317px" class="text-indent" >${lmisViewStaffRootOrgFN.emailAddress}</td>
								<td  align="center" width="35px">
									<input type="checkbox" name="staffCheckbox" class="staffCheckbox" value='${lmisViewStaffRootOrgFN.userId}' />
									<input type="hidden" name="${lmisViewStaffRootOrgFN.userId}" value="${lmisViewStaffRootOrgFN.emailAddress}"/>
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
		<input class="button-enable" id="savePopupStaff" type="button" value='<fmt:message key="button.add"/>'/> 
		<input class="default-button-enable" id="cancelPopupStaff" type="reset"	value='<fmt:message key="lmis.common.default" />'  />
	</div>
</div>
<!-- </form> -->
<script type="text/javascript">

jQuery(document).ready(function(){
	jQuery('tbody#userEmailList input[type="checkbox"]:checked').each(function(){
		this.checked = false;
		});
	<c:forEach var="lmisViewEmailSettingDetailUser" items="${bean.lmisViewEmailSettingDetailUsers}" >		
		var userId="${lmisViewEmailSettingDetailUser.userRelatedId}";
		jQuery("input[@value='"+userId+"'][type='checkbox']").each(function(){
			this.checked = true;
			});
	</c:forEach>
});
</script>