<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	<%@ include file="/js/cds/utils.js"%>
	<%@ include file="/js/cds/encoder.js"%>
</script>

<portlet:renderURL var="tab1Page2Region1">
	<portlet:param name="action" value="commonController" />
	<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_APPROVAL_1%>" />
	<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
	<portlet:param name="<%=RequestConst.TAB_PAGE%>" value="<%=RequestConst.TAB_APPROVAL_1_PAGE_2%>" />
	<portlet:param name="<%=RequestConst.TAB_PAGE_REGION%>" value="<%=RequestConst.TAB_APPROVAL_1_PAGE_2_REGION_1%>" />
	<portlet:param name="<%=RequestConst.PERIOD_ID%>" value="${bean.period.cdsEvaluationPeriodsId}" />
	<portlet:param name="<%=RequestConst.EMPLOYEE_ID%>" value="${bean.employeeId}" />
	<portlet:param name="<%=RequestConst.PROJECT_ID%>" value="${bean.projectId}" />
	<portlet:param name="<%=RequestConst.DISABLE_APPROVAL%>" value="${bean.disableApproval}" />
</portlet:renderURL>

<script>
jQuery(document).ready(function(){
	var progressOpts = {
		width: 100
	};
	
	//alert(percentInput);
	jQuery("#progressbar").reportprogress(${bean.rateOfProgress});
	
	jQuery("#progressbar").css({
		'background-color':'white',
		'border':'1px solid gray',
		'position':'relative'
	});
	jQuery(".progress").css({
		'background-color':'#06D62A',
		'float':'left',
		'height':'100%',
		'overflow':'hidden',
		'position':'absolute'
	});
	
	jQuery(".text").css({
		'font-size':'8pt',
		'height':'100%',
		'width':'100%',
		'text-align':'center',
		'position':'absolute',
		'top':'-1px',
		'color':'black'
	});
	// End handle progressbar
});
</script>
<c:if test="${bean.region == bean.TAB_APPROVAL_1_PAGE_2_REGION_2}">
	<script type="text/javascript">
	var t;
	var isEnabled = false;
	var soluongCommentStatic = 0;
	
	function enablePointRating(){
		var ratingStatus = jQuery("input[@name='ratingStatus']:checked").val();
		//alert("ratingStatus=" + ratingStatus);
		if (ratingStatus == "n/a"){
			jQuery('#ratingPoints').attr('disabled', 'disabled');
		}
		
		if (ratingStatus == "agree")
		{
			jQuery('#ratingPoints').empty();
			jQuery('#ratingPoints').html('<option value="n/a">Chọn</option><c:forEach items="${bean.points}" var="point"><option value="${point.pointValue}" <c:if test="${point.pointValue == bean.lastRatingPoint}">selected="selected"</c:if>>${point.pointName}</option></c:forEach>');
			jQuery('#ratingPoints').attr('disabled', 'disabled');
			jQuery("input[@name='ratingStatus']:last").attr('disabled', 'disabled');
			jQuery('#saveButton').css({'background-color':'#326AAC', 'cursor':'pointer'}); //enable
			isEnabled = true;
		}
		
		if (ratingStatus == "disagree")
		{
			//var disableApproval = ${bean.disableApproval};
			//alert("disableApproval="+disableApproval);
			if (${bean.disableApproval || bean.disableRatingPoint}){
				jQuery('#ratingPoints').attr('disabled', 'disabled');
			} else {
				jQuery('#ratingPoints').attr('disabled', '');
				jQuery("input[@name='ratingStatus']:last").attr('disabled', 'disabled');	
			}
			
			//Neu chua thay doi diem thi se disable nut luu
			var pointValue = jQuery("#ratingPoints").attr('value');
			if ((pointValue == "n/a") || (ratingStatus == "disagree" && pointValue=="${bean.lastRatingPoint}")){
				jQuery('#saveButton').css({'background-color':'gray', 'cursor':'default'}); //disable
				isEnabled = false;
			}
		}
	}
	function enableSaveButton(){
		var pointValue = jQuery("#ratingPoints").attr('value');
		var ratingStatus = jQuery("input[@name='ratingStatus']:checked").val();
		
		if ((pointValue == "n/a") || (ratingStatus == "disagree" && pointValue=="${bean.lastRatingPoint}") ){
			jQuery('#saveButton').css({'background-color':'gray', 'cursor':'default'}); //disable
			isEnabled = false;
		} else {
			jQuery('#saveButton').css({'background-color':'#326AAC', 'cursor':'pointer'}); //enable
			isEnabled = true;	
		}
	}
	
	function loadComments(){
		var href = '<portlet:actionURL>
						<portlet:param name="action" value="commonController" />
						<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_APPROVAL_1%>" />
						<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
					</portlet:actionURL>';
		var soluongComment = 0;
		
		jQuery.ajax({
			type:'POST',
			url: href,
			data: {
				'<%=RequestConst.HANDLE%>':'<%=RequestConst.HANDLE_GET_COMMENT_LIST%>',
				'<%=RequestConst.PERIOD_ID%>':${bean.period.cdsEvaluationPeriodsId},
				'<%=RequestConst.SLOT_ID%>':${bean.slot.slotId},
				'<%=RequestConst.EMPLOYEE_ID%>':${bean.employeeId}
			},						
			success: function(data){
				var messageList = '<div class="message span-22" style="display:none;"></div>';
				jQuery(data).find('comment').each(function() {
					var comment = jQuery(this);
					var author = comment.find('author:first').text();
					var content = comment.find('content:first').html();
					var date = comment.find('date:first').text();
					var hour = comment.find('hour:first').text();
				
					var message = '<div class="message span-22" style="background-color: #E8F0F9; padding: 5px; margin-bottom: 2px;  margin-left: 7px;"><div style="float:left;">'
						+'<img src="/ProGate-portlet/images/cds/noavatar.gif" width="60px" height="60px" style="padding-left: 5px; padding-right: 10px; padding-top: 5px;"/>'
						+'</div><div class="span-20 last" style="text-align: justify;"><strong style="color:#376092; padding-right: 5px">'
						+ author
						+'</strong> '
						+ content
						+ '<div class="clear"></div><em style="color: gray">'
						+ date
						+' lúc '
						+ hour
						+'</em></div></div>';
						messageList = messageList + message;
					//jQuery(".message:last").after(message);
					
					soluongComment = soluongComment + 1;
				});
				
				
				if (soluongComment <= 0) {
					jQuery('#soluongComment').text("Chưa có bình luận");	
				} else {
					jQuery('#soluongComment').text("Có " + soluongComment + " bình luận");
				}
				
				soluongCommentStatic = soluongComment;
				
				jQuery('#message-board').empty();
				jQuery('#message-board').html(messageList);
				//window.location='${tab3Page1}';
			},
			error: function(){
				//alert("Co loi xay ra khi dung ajax");
			}
		});
		t=setTimeout("loadComments()",300000);
	}
	
	jQuery(document).ready(function(){
		//jQuery("#loading").hide();
		// Handle progressbar
		loadComments();
		//disable pointRating
		//jQuery('#ratingPoints').attr('disabled', 'disabled');
		enablePointRating();
		//disable saveButton 
		jQuery('#saveButton').css({'background-color':'gray', 'cursor':'default'});
		var progressOpts = {
			width: 100
		};
		
		//alert(percentInput);
		jQuery("#progressbar").reportprogress(${bean.rateOfProgress});
		
		jQuery("#progressbar").css({
			'background-color':'white',
			'border':'1px solid gray',
			'position':'relative'
		});
		jQuery(".progress").css({
			'background-color':'#06D62A',
			'float':'left',
			'height':'100%',
			'overflow':'hidden',
			'position':'absolute'
		});
		
		jQuery(".text").css({
			'font-size':'8pt',
			'height':'100%',
			'width':'100%',
			'text-align':'center',
			'position':'absolute',
			'color':'black'
		});
		// End handle progressbar
		
		// Handle comments
		jQuery("#commentTextArea").css({
			'color':'gray',
			'font-family':'Arial',
			'font-size':'10pt'
		});
		
		jQuery('#commentTextArea').keydown(function (e) {
			if (e.keyCode == 13) {
				jQuery("#commentTextArea").height(jQuery("#commentTextArea").height() + 30);
			}
		});
		//End Handle Comments
	});
	
	var firstTime = true;
	var containText = false;
	
	function checkContainText(){
		var content = jQuery("#commentTextArea").val();
		if (content.trim() == ""){
			containText = false;
		} else {
			containText = true;
		}
	}
	function showCommentButton(){
		
		if (firstTime == true){
			firstTime = false;
			jQuery("#commentTextArea").css({
				'color':'black',
				'font-family':'Arial',
				'font-size':'10pt'
			});
			
			jQuery("#commentTextArea").val("");
			jQuery("#commentTextArea").height("50px");
			jQuery("#commentButton").show();
		} else if (containText == true){
				return;
			} else {
				jQuery("#commentTextArea").css({
					'color':'black',
					'font-family':'Arial',
					'font-size':'10pt'
				});
				
				jQuery("#commentTextArea").val("");
				jQuery("#commentTextArea").height("50px");
				jQuery("#commentButton").show();
			}
	}
	function hideCommentButton(){
		
		if (containText == true){
			return;
		} else {
			jQuery("#commentTextArea").css({
				'color':'gray',
				'font-family':'Arial',
				'font-size':'10pt'
			});
			
			jQuery("#commentTextArea").val("Bình luận của bạn");
			jQuery("#commentTextArea").height("30px");
			jQuery("#commentButton").hide();
		}
	}
	
	function submitComment(){
		var commentText = jQuery("#commentTextArea").val();
		var userFullname = '${functions:getUserFullnameByUserId(bean.userId)}';
		var date = getCurrentDate();
		var hour = getCurrentHour();
		
		//Hien comment truoc khi gui len server
		var message = '<div class="message span-22" style="background-color: #E8F0F9; padding: 5px; margin-bottom: 2px; margin-left: 7px;"><div style="float:left;">'
			+'<img src="/ProGate-portlet/images/cds/noavatar.gif" width="60px" height="60px" style="padding-left: 5px; padding-right: 10px; padding-top: 5px;"/>'
			+'</div><div class="span-20 last" style="text-align: justify;"><strong style="color:#376092; padding-right: 5px">'
			+ userFullname
			+'</strong> '
			+ Encoder.htmlEncode(commentText, true)
			+ '<div class="clear"></div><em style="color: gray">'
			+ date
			+' lúc '
			+ hour
			+'</em></div></div>';
		jQuery(".message:last").after(message);
		
		var cmtNo = soluongCommentStatic + 1;
		soluongCommentStatic = cmtNo;
		if (cmtNo <= 0) {
			jQuery('#soluongComment').text("Chưa có bình luận");	
		} else {
			jQuery('#soluongComment').text("Có " + cmtNo + " bình luận");
		}
		
		var href = '<portlet:actionURL>
				<portlet:param name="action" value="commonController" />
				<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_APPROVAL_1%>" />
				<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
			</portlet:actionURL>';
		
		jQuery.ajax({
			type:'POST',
			url: href,
			data: {
				'<%=RequestConst.HANDLE%>':'<%=RequestConst.HANDLE_SAVE_COMMENT%>',
				'<%=RequestConst.PERIOD_ID%>':${bean.period.cdsEvaluationPeriodsId},
				'<%=RequestConst.SLOT_ID%>':${bean.slot.slotId},
				'<%=RequestConst.COMMENT_TEXT%>':commentText,
				'<%=RequestConst.EMPLOYEE_ID%>':${bean.employeeId}
			},						
			success: function(data){
				//alert("server said: "+ data);
				//window.location='${tab3Page1}';
			},
			error: function(){
				//alert("Co loi xay ra khi dung ajax");
			}
		});
		
		firstTime = true;
		jQuery("#commentTextArea").val("");
		containText = false;
		hideCommentButton();
		location.hash = "commentTextArea";
	}
	
	
	function savePointRating(savePoint){
		if(savePoint == true) {
			if (isEnabled == false) return;
			clearTimeout(t);
			var href = '<portlet:actionURL>
				<portlet:param name="action" value="commonController" />
				<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_APPROVAL_1%>" />
				<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
			</portlet:actionURL>';
			
			var pointName = jQuery("#ratingPoints option:selected").text();
			var pointValue = jQuery("#ratingPoints").attr('value');
			var ratingStatus = jQuery("input[@name='ratingStatus']:checked").val();
			
			jQuery("#loading").show();
			
			jQuery.ajax({
				type:'POST',
				url: href,
				data: {
					'<%=RequestConst.HANDLE%>':'<%=RequestConst.HANDLE_SAVE_POINT_RATING%>',
					'<%=RequestConst.PERIOD_ID%>':${bean.period.cdsEvaluationPeriodsId},
					'<%=RequestConst.SLOT_ID%>':${bean.slot.slotId},
					'<%=RequestConst.POINT_NAME%>':pointName,
					'<%=RequestConst.POINT_VALUE%>':pointValue,
					'<%=RequestConst.RATING_STATUS%>':ratingStatus,
					'<%=RequestConst.EMPLOYEE_ID%>':${bean.employeeId}
				},						
				success: function(data){
					//alert("server said: "+ data);
					window.location='${tab1Page2Region1}';
				},
				error: function(){
					//alert("Co loi xay ra khi dung ajax");
				}
			});
		} else {
			clearTimeout(t);
			window.location='${tab1Page2Region1}';
		}
		
	}
	</script>
</c:if>
<c:if test="${bean.region == bean.TAB_APPROVAL_1_PAGE_2_REGION_1}">
<div class="border-radius" 
	<c:if test="${bean.userRole == bean.ROLE_PM}">style="min-height: 495px; margin-bottom: 20px"</c:if>
	<c:if test="${bean.userRole == bean.ROLE_BOD}">style="min-height: 475px; margin-bottom: 20px"</c:if>
>
</c:if>
<c:if test="${bean.region == bean.TAB_APPROVAL_1_PAGE_2_REGION_2}">
<div class="border-radius"
	<c:if test="${bean.userRole == bean.ROLE_PM}">style="min-height: 495px; margin-bottom: 20px"</c:if>
	<c:if test="${bean.userRole == bean.ROLE_BOD}">style="min-height: 475px; margin-bottom: 20px"</c:if>
>
</c:if>
	<!-- <div id="loading" style="display:none; position: fixed;top: 50%; left: 50%; margin-top: -50px; margin-left: -50px;">
		<img src="/ProGate-portlet/images/cds/ajax-loader.gif"/>
	</div> -->
	<div id="loading" class="cds-loading">
		<img src="/ProGate-portlet/images/cds/ajax-loader.gif"/>
	</div>
	<div style="padding-top: 3px;">
		<div class="span-11 last background-radius" style="padding: 10px; margin-left: 2px; margin-bottom: 2px;">
			<label class="span-2 padding-bottom"><strong>Nhân viên:</strong></label>
			<div class="span-9 last padding-bottom">${bean.employeeName}</div>
			<label class="span-2 padding-bottom"><strong>Chức vụ:</strong></label>	
			<div class="span-9 last padding-bottom">${bean.position}</div>

			<label class="span-2 padding-bottom"><strong>Title:</strong></label>	
			<div class="span-9 last padding-bottom">${bean.titleName}</div>
			<label class="span-2"><strong>Dự án:</strong></label>	
			<div class="span-9 last">${bean.projectName}</div>
		</div>
		<div class="span-11 last background-radius" style="padding: 10px; margin-left: 4px; margin-bottom: 2px;">
			<label class="span-3 padding-bottom"><strong>Đợt CDS:</strong></label>

			<div class="span-8 last padding-bottom">
				${bean.period.name} - <fmt:formatDate pattern="MM/yyyy" value="${bean.period.startDate}" /> đến <fmt:formatDate pattern="MM/yyyy" value="${bean.period.endDate}" />
			</div>
			<label class="span-3 padding-bottom"><strong>Trạng thái CDS:</strong></label>	
			<div class="span-8 last padding-bottom">
				<c:choose>
					<c:when test="${bean.paStatus.ratingStatus == 0}">
					<span style="" class="padding-bottom" title="Chưa đánh giá">
						<img style="vertical-align:middle; margin-top: -5px" src="/ProGate-portlet/images/cds/check-gray.png" width="18px" height="18px" /> Nhân viên
					</span> 
					</c:when>
					<c:when test="${bean.paStatus.ratingStatus == 1}">
					<span style="" class="padding-bottom" title="Đang đánh giá">
						<img style="vertical-align:middle; margin-top: -5px" src="/ProGate-portlet/images/cds/inprogress.png" width="18px" height="18px" /> Nhân viên
					</span> 
					</c:when>
					<c:when test="${bean.paStatus.ratingStatus == 2}">
					<span style="" class="padding-bottom" title="Đã đánh giá">
						<img style="vertical-align:middle; margin-top: -5px" src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" /> Nhân viên
					</span> 
					</c:when>
				</c:choose>
				 
				<c:choose>
					<c:when test="${bean.paStatus.ratingStatusPm == 0}">
					<span style="margin-left: 10px;" class="padding-bottom" title="Chưa phê duyệt">
						<img style="vertical-align:middle; margin-top: -5px" src="/ProGate-portlet/images/cds/check-gray.png" width="18px" height="18px" /> PM
					</span> 
					</c:when>
					<c:when test="${bean.paStatus.ratingStatusPm == 1}">
					<span style="margin-left: 10px;" class="padding-bottom" title="Đang phê duyệt">
						<img style="vertical-align:middle; margin-top: -5px" src="/ProGate-portlet/images/cds/inprogress.png" width="18px" height="18px" /> PM
					</span> 
					</c:when>
					<c:when test="${bean.paStatus.ratingStatusPm == 2}">
					<span style="margin-left: 10px;" class="padding-bottom" title="Đã phê duyệt">
						<img style="vertical-align:middle; margin-top: -5px" src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" /> PM
					</span> 
					</c:when>
				</c:choose>
				 
				<c:choose>
					<c:when test="${bean.paStatus.ratingStatusBod == 0}">
					<span style="margin-left: 10px;" class="padding-bottom" title="Chưa phê duyệt">
						<img style="vertical-align:middle; margin-top: -5px" src="/ProGate-portlet/images/cds/check-gray.png" width="18px" height="18px" /> BOD
					</span> 
					</c:when>
					<c:when test="${bean.paStatus.ratingStatusBod == 1}">
					<span style="margin-left: 10px;" class="padding-bottom" title="Đang phê duyệt">
						<img style="vertical-align:middle; margin-top: -5px" src="/ProGate-portlet/images/cds/inprogress.png" width="18px" height="18px" /> BOD
					</span> 
					</c:when>
					<c:when test="${bean.paStatus.ratingStatusBod == 2}">
					<span style="margin-left: 10px;" class="padding-bottom" title="Đã phê duyệt">
						<img style="vertical-align:middle; margin-top: -5px" src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" /> BOD
					</span> 
					</c:when>
				</c:choose> 
				 
			</div>
			<label class="span-3 padding-bottom"><strong>Tiến độ:</strong></label>	
			<div class="span-8 last padding-bottom">
				<div class="" id="progressbar" style="height: 12px; margin-top: 0.2em; width: 205px"></div> 
			</div>
			<div class="clear"></div>
			<label class="span-3"><strong>Khóa:</strong></label>	
			<div class="span-8 last" style="margin-top: -0.5em">
				<c:choose>
					<c:when test="${bean.paStatus.isLocked == true}"><img title="CDS đã khóa" src="/ProGate-portlet/images/cds/lock.png" height="25" width="25"></c:when>
					<c:otherwise><img title="CDS đang mở" src="/ProGate-portlet/images/cds/unlock.png" height="25" width="25"></c:otherwise>
				</c:choose>
			</div>
		</div>	
	</div>

	<div class="clear"></div>
	<c:choose>
			<c:when test="${bean.region == bean.TAB_APPROVAL_1_PAGE_2_REGION_1}">
				<table>
					<thead>
						<tr>
							<th rowspan="2" class="span-1">STT</th>
							<th rowspan="2" class="span-4">Slot</th>
							<th rowspan="2" class="span-10">Mô tả</th>
				
							<th rowspan="2" class="span-2">Phê duyệt</th>
							<th colspan="2" class="span-6">Trạng thái Slot</th>
						</tr>
						<tr>
							<!-- <th>Nhân viên đánh giá</th> -->
							<th>PM Phê Duyệt</th>
							<th>BOD Phê Duyệt</th>
						</tr>
					</thead>
					
					<tbody>
					
					<c:forEach items="${bean.slotList}" var="slot" varStatus="i">
						<c:if test="${slot.ratingStatus > 0}">	<!-- Nhan vien da danh gia moi dc phe duyet -->
						<portlet:renderURL var="tab1Page2Region2">
								<portlet:param name="action" value="commonController" />
								<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_APPROVAL_1%>" />
								<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
								<portlet:param name="<%=RequestConst.TAB_PAGE%>" value="<%=RequestConst.TAB_APPROVAL_1_PAGE_2%>" />
								<portlet:param name="<%=RequestConst.TAB_PAGE_REGION%>" value="<%=RequestConst.TAB_APPROVAL_1_PAGE_2_REGION_2%>" />
								<portlet:param name="<%=RequestConst.EMPLOYEE_ID%>" value="${bean.employeeId}" />
								<portlet:param name="<%=RequestConst.PROJECT_ID%>" value="${bean.projectId}" />
								<portlet:param name="<%=RequestConst.PERIOD_ID%>" value="${bean.period.cdsEvaluationPeriodsId}" />
								<portlet:param name="<%=RequestConst.SLOT_ID%>" value="${slot.slotId}" />
								<portlet:param name="<%=RequestConst.DISABLE_APPROVAL%>" value="${bean.disableApproval}" />
							</portlet:renderURL>
						
						<tr>
							<td class="td-align-center">${i.count}</td>
							<td class="td-align-left">${slot.aliasName}</td>
							<td class="td-align-left">${slot.description}</td>
							<td class="span-2 td-align-center"><a href="${tab1Page2Region2}"><img src="/ProGate-portlet/images/cds/redPen.png" height="25" width="25"/></a></td>
							<%-- <td class="td-align-center">
							<c:choose>
								<c:when test="${slot.ratingStatus == 0}">
									<img src="/ProGate-portlet/images/cds/check-gray.png" width="18px" height="18px" />
								</c:when>
								<c:when test="${slot.ratingStatus == 1 || slot.ratingStatus == 2}">
									<img src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" />
								</c:when>
							</c:choose>
							</td> --%>
							<td class="td-align-center">
							<c:choose>
								<c:when test="${slot.ratingStatusPm == 0}">
									<img src="/ProGate-portlet/images/cds/check-gray.png" title="Chưa phê duyệt" width="18px" height="18px" />
								</c:when>
								<c:when test="${slot.ratingStatusPm == 1 || slot.ratingStatusPm == 2}">
									<img src="/ProGate-portlet/images/cds/check-green.png" title="Đã phê duyệt" width="18px" height="18px" />
								</c:when>
							</c:choose>
							</td>
							<td class="td-align-center">
							<c:choose>
								<c:when test="${slot.ratingStatusBod == 0}">
									<img src="/ProGate-portlet/images/cds/check-gray.png" title="Chưa phê duyệt" width="18px" height="18px" />
								</c:when>
								<c:when test="${slot.ratingStatusBod == 1 || slot.ratingStatusBod == 2}">
									<img src="/ProGate-portlet/images/cds/check-green.png" title="Đã phê duyệt" width="18px" height="18px" />
								</c:when>
							</c:choose>
							</td>
						</tr>
						</c:if>
					</c:forEach>			
					</tbody>
				
				</table>
			</c:when>

			<c:when test="${bean.region == bean.TAB_APPROVAL_1_PAGE_2_REGION_2}">
				<label class="span-23 last" style="padding:10px; width: 890px"><strong>${bean.slot.aliasName}: </strong>${bean.slot.description}</label>
				<div class="clear"></div>
				<div class="" style="padding:10px; -moz-border-radius: 5px;background-image:url('/ProGate-portlet/images/cds/Danhgia45px.png'); background-repeat:repeat-x; border: 1px solid #83C7D8" >
					<label class="span-3 last"><strong>Điểm:</strong></label>
					<select class="span-2" id="ratingPoints" onchange="enableSaveButton()" <c:if test="${bean.disableRatingPoint || bean.disableApproval}">disabled="disabled"</c:if>>
						<option value="n/a">Chọn</option>
					<c:forEach items="${bean.points}" var="point">
						<option value="${point.pointValue}" <c:if test="${point.pointValue == bean.slot.pointValue}">selected="selected"</c:if>>
							${point.pointName}		
						</option>
					</c:forEach> 
					</select>
					<!-- <label class="prepend-3 span-3" style="display:none"><strong>Phê duyệt bởi:</strong></label><select class="span-6" style="display:none"><option>Chọn dự án</option></select> -->
					<label class="prepend-4 span-3 last"><strong>Phê duyệt:</strong></label> 
					<form>
						<div class="span-3 last">
							<input onclick="enablePointRating()" type="radio" name="ratingStatus" value="agree" 
								<c:if test="${bean.disableRatingPoint || bean.disableApproval}">disabled="disabled"</c:if>
								<c:if test="${bean.theLastRatingStatus == 'agree'}">checked</c:if>
							/> Đồng ý
						</div> 
						<div class="span-4 last">
							<input onclick="enablePointRating()" type="radio" name="ratingStatus" value="disagree" 
								<c:if test="${bean.disableRatingPoint || bean.disableApproval}">disabled="disabled"</c:if>
								<c:if test="${bean.theLastRatingStatus == 'disagree'}">checked</c:if>
							/> Không đồng ý
						</div> 
						<div class="span-4 last">
							<input onclick="enablePointRating()" type="radio" name="ratingStatus" value="n/a" 
								<c:if test="${bean.disableRatingPoint || bean.disableApproval || bean.theLastRatingStatus != 'n/a'}">disabled="disabled"</c:if>
								<c:if test="${bean.theLastRatingStatus == 'n/a'}">checked</c:if>
							/> Chưa phê duyệt
						</div>
						<div class="clear"></div>
					</form>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
				<div class="border-radius prepend-top" style="margin-left:5px; margin-right:5px">
					<!-- background-image:url('/ProGate-portlet/images/cds/Pheduyet40px.png');background-repeat:repeat; -->
					<div class="border-radius " style="background-color: #D7E4BD; padding:5px 5px 5px 10px; border: 1px solid gray">
						<strong style="color: black">Lịch sử đánh giá và phê duyệt</strong>
					</div>
					<div class="scroll-y" style="padding: 10px; height: 150px">
						<c:forEach items="${bean.slotRatingHistoryList}" var="ratingHistory">
							<div style="float:left;">
								<img src="/ProGate-portlet/images/cds/muiten.png" width="10px" height="10px" style="margin-top: 0.45em"/>
							</div>
							<div class="" style="padding-left: 15px; text-align: justify; color: gray"> 
								<!-- <em>Đợt 1 - 2011: <strong><em>ThinhPT</em></strong> đồng ý và rating 4 điểm - 14/03/2011 lúc 15h30</em> -->
								<c:set var="periodObject" value="${functions:getPeriodByPeriodId(ratingHistory.periodId)}" scope="page" />
								<em>${periodObject.name} - <fmt:formatDate pattern="MM/yyyy" value="${periodObject.fromDate}" /> đến <fmt:formatDate pattern="MM/yyyy" value="${periodObject.toDate}" /> </em>
								: <strong><em>${functions:getUserFullnameByUserId(ratingHistory.ratingBy)}</em></strong> 
								<c:if test="${ratingHistory.userType != 0}">
									<c:if test="${ratingHistory.ratingStatus == true}">đồng ý và </c:if>
									<c:if test="${ratingHistory.ratingStatus == false}">không đồng ý và </c:if>
								</c:if>
								 rating ${ratingHistory.pointName} điểm - <fmt:formatDate pattern="dd/MM/yyyy" value="${ratingHistory.ratingAt}" /> lúc <fmt:formatDate pattern="HH:mm" value="${ratingHistory.ratingAt}" />
							</div>
							<div class="clear"></div>
						</c:forEach>
						
						<!-- <div style="float:left;">
							<img src="/ProGate-portlet/images/cds/muiten.png" width="10px" height="10px" style="margin-top: 0.45em"/>
						</div>
						<div class="span-10 last" style="padding-left: 5px; text-align: justify; color: gray"> 
							<em>Đợt 1 - 2011: <strong><em>ChauLT</em></strong> rating 4 điểm - 14/03/2011 lúc 15h30</em>
						</div> -->
						<c:if test="${bean.sizeOfSlotRatingHistoryList == 0}">
							<div class="span-10 last" style="text-align: justify; color: gray">
								<em>Chưa có lịch sử đánh giá và phê duyệt.</em>
							</div>
						</c:if>
					</div>
				</div>
				<!-- <div class="span-11" style="min-height:300px">
					<div class="span-11 prepend-top" id="message-board">
						<div class="message span-11" style="display:none;"></div>
					</div>
					
					<div class="span-11" style="background-color: #E8F0F9; padding: 5px; margin-bottom: 2px">
						<textarea id="commentTextArea" class="span-11" style="color: gray; padding: 5px; height: 30px;" onclick="showCommentButton()" onblur="hideCommentButton()" onkeyup="checkContainText()">Bình luận của bạn</textarea><br/>
						<button onclick="submitComment()" id="commentButton" class="cds-btn right" style="margin-top: 5px; display:none">Bình luận</button>
					</div>
				</div>
				
				<input type="button" style="margin-right: 20px; margin-top:10px; margin-bottom: 10px" class="right cds-btn" value="Quay lại" onclick="savePointRating(false)">
				<input id="saveButton" type="button" style="margin-right: 20px; margin-top:10px; margin-bottom: 10px" class="right cds-btn" value="Lưu" onclick="savePointRating(true)">
				<div class="clear"></div> -->
				
				<div class="prepend-top append-bottom span-22" style="margin-left:10px;">
					<span style="font-size: 12pt; font-weight: bold;" id="soluongComment"></span>
				</div>
				<div class="" style="margin-left:5px; margin-right:5px">
					<div class="span-22" id="message-board">
						<div class="span-22 message" style="display:none;"></div>
					</div>
					<div class="clear"></div>
					
					<div class="span-22" style="background-color: #E8F0F9; padding: 5px; margin-bottom: 2px; margin-left: 7px">
						<textarea id="commentTextArea" class="span-22" style="color: gray; padding: 5px; height: 30px;" onclick="showCommentButton()" onblur="hideCommentButton()" onkeyup="checkContainText()">Bình luận của bạn</textarea><br/>
						<button onclick="submitComment()" id="commentButton" class="cds-btn right" style="margin-top: 5px; display:none">Bình luận</button>
					</div>
					
				</div>
				<div class="prepend-top" style="text-align: center">
					<input id="saveButton" type="button" style="margin-top:10px; margin-bottom: 10px" class="cds-btn" value="Lưu" onclick="savePointRating(true)">
					<input type="button" style="margin-top:10px; margin-bottom: 10px" class="cds-btn" value="Quay lại" onclick="savePointRating(false)">
					<div class="clear"></div>
				</div>
			</c:when>
	</c:choose>

</div>