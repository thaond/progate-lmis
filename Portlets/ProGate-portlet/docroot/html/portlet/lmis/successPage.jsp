<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<form method="post" name="frmRequestOTDetail" action="">
	<div style="margin-top: -36px;" class="createChange">
		<input type="image" class="mode-edit-active" id="approve" href="#"
			src="/ProGate-portlet/images/lmis/overtimeManagement/Pheduyet.png"
			style="display: none;"> <a href="#"
			style="vertical-align: 7px; font-weight: bold; display: none;"
			id="aproveReport">Phê duyệt</a> <input width="24" height="24"
			type="image" class="mode-edit-active" href="#"
			src="/ProGate-portlet/images/lmis/undo.png" id="ctl-back"> <a
			style="vertical-align: 7px; font-weight: bold;" href="#" id="goBack">Quay
			về</a>
	</div>
	<div class="cls-ot">
		<div class="title-center">Thông Tin Chi Tiết</div>
		<div style="display: none;" class="req-field">(*) Thông Tin Bắt
			Buộc Nhập</div>
		<div style="height: 20px; width: 100%;"></div>
		<div class="content-left">
			<table id="tbl-field">
				<thead>
					<tr>
						<th width="150px" style="border: medium none;" scope="col"></th>
						<th style="border: medium none;"></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Ngày tăng ca</td>
						<td><input type="text" class="date-req" name="today"
							value="13/07/2011" readonly="readonly" disabled="disabled">
						</td>
					</tr>
					<tr>
						<td class="cls-org">Tên bộ phận</td>
						<td style="height: 35px;"><input type="text" class="subOrg"
							name="slt-org" style="margin-top: 5px;" value="123"
							disabled="disabled"></td>
					</tr>
					<tr>
						<td>Ngày báo cáo</td>
						<td style="height: 45px;"><input type="text"
							style="width: 350px; height: 20px;" class="date-input-ot"
							name="date-ot" value="14/07/2011" disabled="disabled"></td>

					</tr>
				</tbody>
			</table>
		</div>
		<div class="content-right">
			<fieldset style="width: 350px; -moz-border-radius: 5px 5px 5px 5px;">
				<legend>Lý do tăng ca </legend>
				<textarea disabled="disabled"
					style="margin-left: 5px; height: 60px; width: 406px;"
					name="txt-reason" id="txt-reason">Research Martketing</textarea>
			</fieldset>
		</div>
		<div class="clear"></div>
		<div class="tbl-title">
			<div class="mbr-join">Thành Viên Tham Gia</div>
		</div>
		<div class="clear"></div>
		<div class="tbl-mbr">
			<table>
				<thead>
					<tr>
						<th width="25%" scope="row">Họ Tên Nhân Viên</th>
						<th width="11%" scope="row"><span title="Giờ bắt đầu đăng ký">GBÐÐK</span>
						</th>
						<th width="10%" scope="row"><span title="Số giờ đăng ký">Số
								Giờ ĐK</span>
						</th>
						<th width="11%" scope="row"><span
							title="Giờ bắt đầu thực tế ">GBĐTT</span>
						</th>
						<th width="10%" scope="row"><span title="Tổng số giờ thực tế">TSGTT</span>
						</th>
						<th scope="row">Lý do tăng ca</th>
					</tr>
				</thead>
				<tbody>
					<tr class="oddrow">
						<td class="text-indent">Trương Quốc Anh Thư</td>
						<td align="center"><input type="text" disabled="disabled"
							value="17" class="time-align"> : <input type="text"
							disabled="disabled" value="30" class="time-align"></td>
						<td align="center" class="hour"><input type="text"
							disabled="disabled" value="2.0" class="hour-align">
						</td>
						<td align="center"><input type="text" disabled="disabled"
							value="17" class="time-align"> : <input type="text"
							disabled="disabled" value="30" class="time-align"></td>
						<td align="center" class="hour"><input type="text"
							disabled="disabled" value="2.0" class="hour-align">
						</td>
						<td class="tdreason"><input type="text" disabled="disabled"
							value="Research Martketing" id="tdreason">
						</td>
					</tr>
					<tr class="evenrow">
						<td class="text-indent">Nguyễn Thị Trang</td>
						<td align="center"><input type="text" disabled="disabled"
							value="17" class="time-align"> : <input type="text"
							disabled="disabled" value="30" class="time-align"></td>
						<td align="center" class="hour"><input type="text"
							disabled="disabled" value="2.0" class="hour-align">
						</td>
						<td align="center"><input type="text" disabled="disabled"
							value="17" class="time-align"> : <input type="text"
							disabled="disabled" value="30" class="time-align"></td>
						<td align="center" class="hour"><input type="text"
							disabled="disabled" value="2.0" class="hour-align">
						</td>
						<td class="tdreason"><input type="text" disabled="disabled"
							value="Research Martketing" id="tdreason">
						</td>
					</tr>
					<tr class="oddrow">
						<td class="text-indent">Nguyễn Đỗ Hoàng Lâm</td>
						<td align="center"><input type="text" disabled="disabled"
							value="17" class="time-align"> : <input type="text"
							disabled="disabled" value="30" class="time-align"></td>
						<td align="center" class="hour"><input type="text"
							disabled="disabled" value="2.0" class="hour-align">
						</td>
						<td align="center"><input type="text" disabled="disabled"
							value="17" class="time-align"> : <input type="text"
							disabled="disabled" value="30" class="time-align"></td>
						<td align="center" class="hour"><input type="text"
							disabled="disabled" value="2.0" class="hour-align">
						</td>
						<td class="tdreason"><input type="text" disabled="disabled"
							value="Research Martketing" id="tdreason">
						</td>
					</tr>
					<tr class="evenrow">
						<td class="text-indent">Nguyễn Thị Giang</td>
						<td align="center"><input type="text" disabled="disabled"
							value="17" class="time-align"> : <input type="text"
							disabled="disabled" value="30" class="time-align"></td>
						<td align="center" class="hour"><input type="text"
							disabled="disabled" value="2.0" class="hour-align">
						</td>
						<td align="center"><input type="text" disabled="disabled"
							value="17" class="time-align"> : <input type="text"
							disabled="disabled" value="30" class="time-align"></td>
						<td align="center" class="hour"><input type="text"
							disabled="disabled" value="2.0" class="hour-align">
						</td>
						<td class="tdreason"><input type="text" disabled="disabled"
							value="Research Martketing" id="tdreason">
						</td>
					</tr>
					<tr class="oddrow">
						<td class="text-indent">Hồ Quế Phương</td>
						<td align="center"><input type="text" disabled="disabled"
							value="17" class="time-align"> : <input type="text"
							disabled="disabled" value="30" class="time-align"></td>
						<td align="center" class="hour"><input type="text"
							disabled="disabled" value="2.0" class="hour-align">
						</td>
						<td align="center"><input type="text" disabled="disabled"
							value="17" class="time-align"> : <input type="text"
							disabled="disabled" value="30" class="time-align"></td>
						<td align="center" class="hour"><input type="text"
							disabled="disabled" value="2.0" class="hour-align">
						</td>
						<td class="tdreason"><input type="text" disabled="disabled"
							value="Research Martketing" id="tdreason">
						</td>
					</tr>
					<tr class="evenrow">
						<td class="text-indent">Nguyễn Thị Hồng Ngân</td>
						<td align="center"><input type="text" disabled="disabled"
							value="17" class="time-align"> : <input type="text"
							disabled="disabled" value="30" class="time-align"></td>
						<td align="center" class="hour"><input type="text"
							disabled="disabled" value="2.0" class="hour-align">
						</td>
						<td align="center"><input type="text" disabled="disabled"
							value="17" class="time-align"> : <input type="text"
							disabled="disabled" value="30" class="time-align"></td>
						<td align="center" class="hour"><input type="text"
							disabled="disabled" value="2.0" class="hour-align">
						</td>
						<td class="tdreason"><input type="text" disabled="disabled"
							value="Research Martketing" id="tdreason">
						</td>
					</tr>
					<tr class="oddrow">
						<td class="text-indent">Nguyễn Quang Huy</td>
						<td align="center"><input type="text" disabled="disabled"
							value="17" class="time-align"> : <input type="text"
							disabled="disabled" value="30" class="time-align"></td>
						<td align="center" class="hour"><input type="text"
							disabled="disabled" value="2.0" class="hour-align">
						</td>
						<td align="center"><input type="text" disabled="disabled"
							value="17" class="time-align"> : <input type="text"
							disabled="disabled" value="30" class="time-align"></td>
						<td align="center" class="hour"><input type="text"
							disabled="disabled" value="2.0" class="hour-align">
						</td>
						<td class="tdreason"><input type="text" disabled="disabled"
							value="Research Martketing" id="tdreason">
						</td>
					</tr>
					<tr class="evenrow">
						<td class="text-indent">Phùng Xuân Tiến</td>
						<td align="center"><input type="text" disabled="disabled"
							value="17" class="time-align"> : <input type="text"
							disabled="disabled" value="30" class="time-align"></td>
						<td align="center" class="hour"><input type="text"
							disabled="disabled" value="2.0" class="hour-align">
						</td>
						<td align="center"><input type="text" disabled="disabled"
							value="17" class="time-align"> : <input type="text"
							disabled="disabled" value="30" class="time-align"></td>
						<td align="center" class="hour"><input type="text"
							disabled="disabled" value="2.0" class="hour-align">
						</td>
						<td class="tdreason"><input type="text" disabled="disabled"
							value="Research Martketing" id="tdreason">
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="feedback" style="width: 450px; padding-left: 5px;">
		<fieldset class="fbk-field">
			<legend>Phản hồi của người phê duyệt </legend>
			<textarea name="feedback" style="height: 76px; width: 899px;"
				disabled="disabled"></textarea>
		</fieldset>
		<label class="cls-error">Bạn chưa nhập thông tin phê duyệt</label>
	</div>
	<div class="align-right" style="padding-right: 2px; padding-top: 10px;">
		<input type="submit" class="default-button-disable" id="agreeReport"
			value="Đồng Ý" disabled="disabled"> <input type="submit"
			class="not-agree-disable" id="notAgreeReport" value="Không Đồng Ý"
			disabled="disabled">
	</div>
</form>