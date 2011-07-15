<%@ include file="../../lmis/init-tvna.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">
	jQuery(document).ready(function(){
		jQuery("#dateDayOff").datepicker({
			showOn: "both",
			buttonImage: "/ProGate-portlet/images/lmis/viewAttendanceInfo/datetime.png",
			buttonImageOnly: true,
			buttonText:'Chọn ngày',
			dateFormat:'dd/mm/yy'
		});
	});
	jQuery(function(){
		jQuery("#calDayOff").click(function(e){
			e.preventDefault();
			var url='<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
        			<portlet:param name="action" value="managerDayOffBy" />
    				<portlet:param name="<%=Request.TAB_ACTION %>" value="<%=Request.TAB_MANAGER %>" />
    				<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
   					</portlet:renderURL>';
   			jQuery.ajax({
   				type:'GET',
   				url:url,
   				data:{
   					'statistic':'statistic'
   				},
   				success: function(xml){
   					var dayValue = jQuery(xml).find('dayValue').text();
					jQuery('#dateDayOff').val(dayValue);
					
					var countForm = jQuery(xml).find('countForm').text();
					jQuery('#countForm').val(countForm);
   					
   					jQuery("#viewCalDayOff").css("display", "block");
   			    	jQuery("#viewCalDayOff").dialog("open");
   				}
   			});
		});
		var close = function(){
			jQuery("#viewCalDayOff").dialog("close");
	  	}
		var dialogOpts = {
		    	title:'Thống Kê Đơn',
		    	autoOpen: false,
			    modal: true,
			    overlay:{
			    	background:'#000000',
		    		opacity:'0.7'
			    },
			    buttons:{
			    	'<fmt:message key="button.close" />': close
			    },
			    resizable: false,
			    width: 300,
			    height: 200
		    };
		jQuery("#viewCalDayOff").dialog(dialogOpts);
	});
	function mySelect(){
		var day = jQuery("#dateDayOff").val();
		var url='<portlet:renderURL windowState="<%=WindowState.NORMAL.toString() %>">
				<portlet:param name="action" value="managerDayOffBy" />
				<portlet:param name="<%=Request.TAB_ACTION %>" value="<%=Request.TAB_MANAGER %>" />
				<portlet:param name="<%=Request.ORG_ID %>" value="${bean.orgId}" />
				</portlet:renderURL>';
		jQuery.ajax({
	   		type:'GET',
	   		url:url,
	   		data:{
	   			'statistic':'statistic',
	   			'dateDayOff':day
	   		},
	   		success: function(xml){
	   			var dayValue = jQuery(xml).find('dayValue').text();
				jQuery('#dateDayOff').val(dayValue);
						
				var countForm = jQuery(xml).find('countForm').text();
				jQuery('#countForm').val(countForm);
	   		},
	   		error:function(){
	   			alert("co loi xay ra o ajax");
	   		}
		});
	}
</script>
<div id="viewCalDayOff">
	<div style="margin-left:1.9em">
		<table>
			<tr>
				<td><div>Ngày</div></td>
				<td><div><input class="styleInput7" type="text" name="dateDayOff" id="dateDayOff" onchange="mySelect()"></div></td>
			</tr>
			<tr>
				<td><div>Số đơn nghỉ</div></td>
				<td><div><input class="styleInput7" type="text" name="countForm" id="countForm" readonly="readonly"></div></td>
			</tr>
		</table>
	</div>
</div>