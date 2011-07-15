<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<portlet:actionURL var="actionURL">
	<portlet:param name="action" value="commonController" />
	<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
</portlet:actionURL>

<script>
	<%@ include file="/js/cds/utils.js"%>
	<%@ include file="/js/cds/encoder.js"%>
</script>
<script type="text/javascript">
var t;
function loadComments(){
	var href = '<portlet:actionURL>
					<portlet:param name="action" value="commonController" />
					<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
				</portlet:actionURL>';

	jQuery.ajax({
		type:'POST',
		url: href,
		data: {
			'<%=RequestConst.HANDLE%>':'<%=RequestConst.HANDLE_GET_COMMENT_LIST%>',
			'<%=RequestConst.PERIOD_ID%>':'${bean.period.cdsEvaluationPeriodsId}',
			'<%=RequestConst.EMPLOYEE_ID%>':'${bean.employeeId}'
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
				var content = comment.find('content:first').html();
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
			//alert("Co loi xay ra khi dung ajax");
		}
	});
	t=setTimeout("loadComments()",5000);
}

jQuery(document).ready(function(){
	loadComments();
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
	jQuery("#periodId").change(function(){
		jQuery("#filterForm").submit();
	});
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
		+ Encoder.htmlEncode(commentText, true)
		+ '<div class="clear"></div><em style="color: gray">'
		+ date
		+' lúc '
		+ hour
		+'</em></div></div>';
	jQuery(".message:last").after(message);
	
	jQuery.ajax({
		type:'POST',
		url: '${actionURL}',
		data: {
			'<%=RequestConst.HANDLE%>':'<%=RequestConst.HANDLE_SAVE_COMMENT%>',
			'<%=RequestConst.PERIOD_ID%>':'${bean.period.cdsEvaluationPeriodsId}',
			'<%=RequestConst.COMMENT_TEXT%>':commentText,
			'<%=RequestConst.EMPLOYEE_ID%>':'${bean.employeeId}'
		},						
		success: function(data){
			//alert("server said: "+ data);
			
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
</script>

<div class="border-radius" style="min-height: 485px; margin-bottom: 20px">
<c:choose>
	<c:when test="${bean.errorHaveNotAnyClosePeriod == true}">
		<div style="text-align: center;" class="error">${bean.errorHaveNotAnyClosePeriodMessage}</div>
	</c:when>
	<c:otherwise>
		<portlet:renderURL var="renderURL">
			<portlet:param name="action" value="commonController" />
			<portlet:param name="<%=Request.ORG_ID%>" value="${bean.orgId}" />
		</portlet:renderURL>
		<form id="filterForm" action="${renderURL}" method="POST">
			<div class="background-radius" style="padding: 10px; margin: 2px 2px 10px 2px;">
				<label class="span-3 padding-bottom"><strong>Nhân viên:</strong></label>
				<div class="span-8 last padding-bottom">${functions:getUserFullnameByUserId(bean.employeeId)}</div>
				<label class="span-3 padding-bottom"><strong>Title hiện tại:</strong></label>	
				<div class="span-8 last padding-bottom">${bean.currentTitle}</div>
	
				<label class="span-3"><strong>Chức vụ hiện tại:</strong></label>	
				<div class="span-8 last">${bean.currentPositionList}</div>
				<label class="span-3"><strong>Dự án hiện tại:</strong></label>	
				<div class="span-8 last">${bean.currentProjectNameList}</div>
				<div class="clear"></div>
			</div>
		</form>
		<div class="span-11" style="min-height:240px; margin-left:10px">
			<div class="span-11" id="message-board">
				<div class="message span-11" style="display:none;"></div>
			</div>
			
			<div class="span-11" style="background-color: #E8F0F9; padding: 5px; margin-bottom: 2px">
				<textarea id="commentTextArea" class="span-11" style="color: gray; padding: 5px; height: 30px;" onclick="showCommentButton()" onblur="hideCommentButton()" onkeyup="checkContainText()">Bình luận của bạn</textarea><br/>
				<button onclick="submitComment()" id="commentButton" class="cds-btn right" style="margin-top: 5px; display:none">Bình luận</button>
			</div>
		</div>
		
		<div class="span-11 border-radius" style="margin-left:10px">
			<div class="border-radius " style="background-color: #DBEEF4; padding:5px 5px 5px 10px; background-image:url('/ProGate-portlet/images/cds/Pheduyet40px.png'); background-repeat:repeat;">
				<strong style="color: white">Kết quả CDS của ${functions:getUserFullnameByUserId(bean.employeeId)}</strong>
			</div>
			<div class="span-10 background-radius" style="padding: 10px; margin-left: 10px; margin-top: 10px; margin-bottom: 10px;">
				<div style="float:left;">
					<img src="/ProGate-portlet/images/cds/muiten.png" width="10px" height="10px" style="margin-top: 0.45em"/>
				</div>
				<div class="span-9 last" style="padding-left: 5px; text-align: justify;"> 
					<em>
						Đợt CDS: ${bean.period.name} - <fmt:formatDate pattern="MM/yyyy" value="${bean.period.startDate}" /> đến <fmt:formatDate pattern="MM/yyyy" value="${bean.period.endDate}" /><br/>
						Dự án: ${bean.projectNameList}<br/>
						Chức vụ: ${bean.positionList}<br/>
						Title: ${bean.titleName}
					</em>
				</div>
				<div class="clear"></div>	
			</div>
			
			<div style="padding: 10px; margin-left: 10px; margin-bottom: 10px;" class="span-10 background-radius">	
				<div style="float:left;">
						<img src="/ProGate-portlet/images/cds/muiten.png" width="10px" height="10px" style="margin-top: 0.7em"/>
					</div>
					<div class="span-9 last" style="padding-left: 5px; text-align: justify;"> 
						<em>
							Minimum Requirement: <img src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" title="Đạt minimum requirement"/>
						</em>
					</div>
					
					<div class="clear"></div>
					<div style="float:left;">
						<img src="/ProGate-portlet/images/cds/muiten.png" width="10px" height="10px" style="margin-top: 0.45em"/>
					</div>
					<div class="span-9 last" style="padding-left: 5px; text-align: justify; padding-top: 5px"> 
						<table style="width:360px">
							<thead>
								<tr>
									<th class="td-align-center">STT</th>
									<th class="td-align-center">Competency</th>
									<th class="td-align-center">Level Ranking</th>
								</tr>
							</thead>
								<c:forEach items="${bean.competencies}" var="competency" varStatus="index">
									<tr>
										<td class="td-align-center">${index.count}</td>
										<td class="td-align-left">${competency.name}</td>
										<td class="span-3 td-align-center">${competency.levelRankingValue}</td>
									</tr>
								</c:forEach>
							<tbody>
							
							</tbody>
						</table>
					</div>
					<div class="clear"></div>
			</div>
		</div>
		
		<div class="clear"></div>
	</c:otherwise>
</c:choose>
</div>

