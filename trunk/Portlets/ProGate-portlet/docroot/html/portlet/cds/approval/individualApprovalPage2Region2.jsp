<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<script type="text/javascript">
var t;
var isEnabled = false;

function enableSaveButton(){
	var pointValue = jQuery("#ratingPoints").attr('value');
	if (pointValue == "n/a"){
		jQuery('#saveButton').css({'background-color':'gray', 'cursor':'default'});
		isEnabled = false;
	} else {
		jQuery('#saveButton').css({'background-color':'#326AAC', 'cursor':'pointer'});
		isEnabled = true;	
	}
}

function loadComments(){
	var href = '<portlet:actionURL>
					<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_APPROVAL_1%>" />
					<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
				</portlet:actionURL>';

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
			//alert("server said: "+ data);
			//xmlDoc = $.parseXML(data);
			//xml = jQuery(xmlDoc);
			//jQuery('#message-board').html('<div class="message" style="display:none;"></div>');
			var messageList = '<div class="message span-11" style="display:none;"></div>';
			jQuery(data).find('comment').each(function() {
				var comment = jQuery(this);
				var author = comment.find('author:first').text();
				var content = comment.find('content:first').text();
				var date = comment.find('date:first').text();
				var hour = comment.find('hour:first').text();
				
				var message = '<div class="message span-11" style="background-color: #E8F0F9; padding: 5px; margin-bottom: 2px"><div style="float:left;">'
					+'<img src="/ProGate-portlet/images/cds/noavatar.gif" width="60px" height="60px" style="padding-left: 5px; padding-right: 10px; padding-top: 5px;"/>'
					+'</div><div class="span-9 last" style="text-align: justify;"><strong style="color:#376092; padding-right: 5px">'
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
			});
			
			jQuery('#message-board').empty();
			jQuery('#message-board').html(messageList);
			//window.location='${tab3Page1}';
		},
		error: function(){
			alert("Co loi xay ra khi dung ajax");
		}
	});
	t=setTimeout("loadComments()",5000);
}

jQuery(document).ready(function(){
	//jQuery("#loading").hide();
	// Handle progressbar
	loadComments();
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
		'position':'absolute'
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
	var message = '<div class="message span-11" style="background-color: #E8F0F9; padding: 5px; margin-bottom: 2px"><div style="float:left;">'
		+'<img src="/ProGate-portlet/images/cds/noavatar.gif" width="60px" height="60px" style="padding-left: 5px; padding-right: 10px; padding-top: 5px;"/>'
		+'</div><div class="span-9 last" style="text-align: justify;"><strong style="color:#376092; padding-right: 5px">'
		+ userFullname
		+'</strong> '
		+ commentText
		+ '<div class="clear"></div><em style="color: gray">'
		+ date
		+' lúc '
		+ hour
		+'</em></div></div>';
	jQuery(".message:last").after(message);
	
	var href = '<portlet:actionURL>
			<portlet:param name="action" value="commonController" />
			<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_EVALUATION_3%>" />
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
		},						
		success: function(data){
			//alert("server said: "+ data);
			//window.location='${tab3Page1}';
		},
		error: function(){
			alert("Co loi xay ra khi dung ajax");
		}
	});
	
	firstTime = true;
	jQuery("#commentTextArea").val("");
	hideCommentButton();
	location.hash = "commentTextArea";
}


function savePointRating(savePoint){
	if(savePoint == true) {
		if (isEnabled == false) return;
		clearTimeout(t);
		var href = '<portlet:actionURL>
			<portlet:param name="action" value="commonController" />
			<portlet:param name="<%=RequestConst.TAB%>" value="<%=RequestConst.TAB_EVALUATION_3%>" />
			<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
		</portlet:actionURL>';
		
		var pointName = jQuery("#ratingPoints option:selected").text();
		var pointValue = jQuery("#ratingPoints").attr('value');
		
		jQuery("#loading").show();
		
		jQuery.ajax({
			type:'POST',
			url: href,
			data: {
				'<%=RequestConst.HANDLE%>':'<%=RequestConst.HANDLE_SAVE_POINT_RATING%>',
				'<%=RequestConst.PERIOD_ID%>':${bean.period.cdsEvaluationPeriodsId},
				'<%=RequestConst.SLOT_ID%>':${bean.slot.slotId},
				'<%=RequestConst.POINT_NAME%>':pointName,
				'<%=RequestConst.POINT_VALUE%>':pointValue
			},						
			success: function(data){
				//alert("server said: "+ data);
				window.location='${tab3Page1}';
			},
			error: function(){
				alert("Co loi xay ra khi dung ajax");
			}
		});
	} else {
		clearTimeout(t);
		window.location='${tab3Page1}';
	}
	
}
</script>

<div id="loading" style="display:none; text-align: center; height: 951px; width: 1424px;left: 0;opacity: 0.5;position: fixed;top: 0;z-index: 1001; background: black; color: white;">
	<span style="position: fixed;top: 250px; font-size: 14pt">Đang lưu ...</span>
</div>
<label class="span-23 last" style="padding:10px"><strong>${bean.slot.aliasName}: </strong>${bean.slot.description}</label>
	<div class="clear"></div>
	<div class="" style="padding:10px; -moz-border-radius: 5px;background-image:url('/ProGate-portlet/images/cds/Danhgia45px.png'); background-repeat:repeat-x; border: 1px solid #83C7D8" >
		<label class="span-3 last"><strong>Điểm:</strong></label>
		<select class="span-2" id="ratingPoints" onchange="enableSaveButton()">
			<option value="n/a">Chọn</option>
		<c:forEach items="${bean.points}" var="point">
			<option value="${point.pointValue}" <c:if test="${point.pointValue == bean.slot.pointValue}">selected="selected"</c:if>>
				${point.pointName}		
			</option>
		</c:forEach> 
		</select>
		<!-- <label class="prepend-3 span-3" style="display:none"><strong>Phê duyệt bởi:</strong></label><select class="span-6" style="display:none"><option>Chọn dự án</option></select>-->
		<div class="clear"></div> 
	</div>
	<div class="clear"></div>
	<div class="span-11 border-radius prepend-top" style="margin-left:10px">
		<div class="border-radius " style="background-color: #DBEEF4; padding:10px; background-image:url('/ProGate-portlet/images/cds/Pheduyet40px.png'); background-repeat:repeat;">
			<strong style="color: white">Lịch sử đánh giá và phê duyệt</strong>
		</div>
		<div class="span-11" style="padding: 10px; min-height: 150px">
			<c:forEach items="${bean.slotRatingHistoryList}" var="ratingHistory">
				<div style="float:left;">
					<img src="/ProGate-portlet/images/cds/muiten.png" width="10px" height="10px" style="margin-top: 0.45em"/>
				</div>
				<div class="span-10 last" style="padding-left: 5px; text-align: justify; color: gray"> 
					<!-- <em>Đợt 1 - 2011: <strong><em>ThinhPT</em></strong> đồng ý và rating 4 điểm - 14/03/2011 lúc 15h30</em> -->
					<c:set var="periodObject" value="${functions:getPeriodByPeriodId(ratingHistory.periodId)}" scope="page" />
					<em>${periodObject.name} - <fmt:formatDate pattern="MM/yyyy" value="${periodObject.fromDate}" /> đến <fmt:formatDate pattern="MM/yyyy" value="${periodObject.toDate}" />
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
			
		</div>
	</div>
	<div class="span-11" style="min-height:240px">
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
<div class="clear"></div>