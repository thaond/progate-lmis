<%@ include file="/html/portlet/cds/init.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<c:choose>
<c:when test="${bean.hasPermissionOnTab3 == false}">
		<div class="border-radius" style="min-height: 485px; margin-bottom: 20px;">
			<div class="cds-notification">Rất tiếc! Bạn không có quyền truy cập vào liên kết này.<br/>
				Vui lòng nhấp <a href="#">vào đây</a> để trở lại trang chủ.
			</div>
		</div>	
</c:when>
<c:when test="${bean.errorHaveNotAnyOpenPeriod == true}">
		<div class="border-radius" style="min-height: 485px; margin-bottom: 20px;">
			<div style="text-align: center; margin-top: 10px; margin-bottom: 10px">
				Hiện không có đợt CDS nào đang tồn tại ở trạng thái “Mở”.<br />
				Vui lòng nhấp <a href="#">vào đây</a> để trở lại trang chủ.
			</div>
		</div>
</c:when>
<c:otherwise>
<div class="border-radius" style="min-height: 485px; margin-bottom: 20px;">
	<div style="text-align: center; margin-top: 10px; margin-bottom: 10px">
		Chức năng này đang được xây dựng.
	</div>
</div>
<%-- <div class="border-radius" style="min-height: 475px;">
	<div class="" style="padding: 10px; background-color: rgb(219, 238, 244); -moz-border-radius-topleft: 5px; -moz-border-radius-topright: 5px; -moz-border-radius-bottomright: 5px; -moz-border-radius-bottomleft: 5px;">
		<div class="span-9 padding-bottom">
			<label style="float: left; margin-right: 10px; width: 65px;">Dự Án</label>
			<select class="span-6 last" onchange="" id="periodId" name="<%=RequestConst.PROJECT_ID%>">
				<option>
					Java Project Hunter
				</option>
			</select>
		</div>
		<div class="span-10 last padding-bottom">
			<label style="float: left; margin-left: 10px; margin-right: 10px; width: 92px;">Tên Nhân Viên</label>
			<select onchange="" class="span-6 last">
				<option>Chọn tên nhân viên</option>
			</select>
		</div>
		<div class="span-3" style="margin-top:0px">
			<a id="search" href="#">
				<img class="absmiddle" src="/ProGate-portlet/images/cds/search.png" height="25" width="25"><span style="color:#E46C0A">Tìm kiếm</span>
			</a>
		</div>
		<div class="span-22 last right" style="height: 0px;">
			<a id="allStaffApprovalButton" href="#" style="float:right; margin-right: 10px; margin-top: 0px">
				<img class="absmiddle" src="/ProGate-portlet/images/cds/redPen.png" height="25" width="25" style="cursor:pointer"/> <span>Phê duyệt title</span>
			</a> 
		</div>
		<div class="clear"></div>
		
		<div style="min-height:370px">
		<table>
		<thead>
			<tr>
				<th class="span-1">STT</th>
				<th class="span-1"><input type="checkbox" name="checkAll" id="checkAll" style="vertical-align: middle;"/></th>
				<th class="span-5">Tên Nhân Viên</th>
				<th class="span-2">Chức Vụ</th>

				<th class="span-2">Title</th>
				<th class="span-3">Dự Án</th>
				<th class="span-5">Title Được Xét</th>
				<th class="span-3">Minimum Requirement</th>
			</tr>

		</thead>
		
		<tbody>
			<tr>
				<td class="td-align-center">
					1
				</td>
				<td class="td-align-center">
					<input type="checkbox" name="checkList" value='${employee.userId}' style="vertical-align: middle;"/>
				</td>
				<td class="td-align-left">Ngo Thua AN</td>
				<td class="td-align-left">Director</td>
				<td class="td-align-left">
					N/A
				</td>
				<td class="td-align-left">JPH</td>
				<td class="td-align-left">
					<select onchange="" class="span-6 last">
						<option>Software Engineer</option>
					</select>
				</td>
				<td class="td-align-center">
					<img class="absmiddle" title="Đã phê duyệt" src="/ProGate-portlet/images/cds/check-green.png" width="18px" height="18px" />
				</td>
			</tr>
		</tbody>
		</table>
		</div>
	</div>
</div> --%>
</c:otherwise>
</c:choose>