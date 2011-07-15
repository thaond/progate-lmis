<%@ include file="../common/init.jsp" %>
<%@ include file="../lmis/init-ttn.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<div class="wrapper">
	<div class="header">
		<div class="header-center">

			<label id="header-title"><fmt:message key="lmis.support.title" />
			</label>
		</div>

		<div class="clear-both"></div>
	</div>
	<div class="mainContent">
		<div class="span-supp-content last" style="margin-right: 0;position: relative; float: left;">	
			<div class="support" id="LMIS" style="margin-top:10px; padding-left:10px; padding-right:10px; text-align:justify;">
				<div>
					<img class="absmiddle" src="/ProGate-portlet/images/lmis/answer.png"
						width="30px" height="30px" />
					<strong style="color:#E46C0A">Hướng Dẫn Sử Dụng Ứng Dụng Quản Lý Thời Gian</strong>
				</div>
				Khi ứng dụng được triển khai BOD sẽ vào phân quyền cho các nhóm người dùng và cá nhân có quyền thao tác một số chức năng trong ứng dụng
				<br/>
				Sau khi phân quyền xong, BOD và cá nhân được phân quyền (nếu có) sẽ cấu hình hệ thống
				<br/>
				Cấu hình khởi tạo "Quản Lý Thời Gian" gồm nhiều phần:
				<ul style="margin-left:10px; margin-bottom:0px;">
					<li>Email chấm công</li>
					<li>Email nghỉ phép</li>
					<li>Email tăng ca</li>
					<li>Thời gian làm việc</li>
					<li>Lịch làm việc</li>
					<li>Mã chấm công</li>
					<li>File chấm công</li>
					<li>Hệ số tăng ca</li>
				</ul>
				Dựa vào các quyền được phân dựa trên vai trò(BOD/PM/STAFF) và quyền đặc biệt được gán, mỗi nhân viên trong tổ chức sẽ có quyền sử dụng 
				những chức năng khác nhau gồm:
				<ul style="margin-left:10px; margin-bottom:0px;">
					<li>Thông tin chấm công</li>
					<li>Thay đổi thời gian làm việc</li>
					<li>Cấu hình chấm công</li>
					<li>Phân quyền chấm công</li>
					<li>Thông tin nghỉ phép</li>
					<li>Cấu hình nghỉ phép</li>
					<li>Phân quyền nghỉ phép</li>
					<li>Đăng ký tăng ca</li>
					<li>Báo cáo tăng ca</li>
					<li>Cấu hình tăng ca</li>
					<li>Phân quyền tăng ca</li>
				</ul>
			</div>
			<div class="support" id="clip" style="margin-top:10px; padding-left:10px; padding-right:10px; text-align:center;">
				<iframe width="610" height="349" src="http://www.youtube.com/embed/n6SDWUvmDLY" frameborder="1px"></iframe>
			</div>
			
			<div class="support" id="answer_1" style="margin-top:10px; padding-left:10px; padding-right:10px; text-align:justify;">
				<div class="padding-bottom">
					<strong style="color:#E46C0A; font-size:1.1em;">Danh Sách Chức Năng</strong>
				</div>
				<div class="span-15 padding-bottom">
					<div class="span-1 margin-text">
					<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/question.png"
						width="30px" height="30px" />
					</div>
					<div class="span-14 last" style="padding-top:5px">
						Xem thông tin chấm công				
					</div>
				</div>
				<div class="span-15">
					<div class="span-1 margin-text">
						<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/answer.png"
							width="30px" height="30px" />
					</div>
					<div class="span-14 last">
						Chức năng xem thông tin chấm công cho phép người dùng xem thông tin chấm công hàng ngày của mình
						và của nhân viên cấp dưới do mình quản lý (nếu là PM) hoặc có quyền cập nhật file chấm công, thông
						thông tin chấm công của các cá nhân trong tổ chức (nếu có quyền đặc biệt này)
					</div>
				</div>
				<div class="right" style="padding-right:20px">
					<a class="back" href="#"> &lt;&lt; Trở về </a>
				</div>
			</div>
			
			<div class="support" id="answer_2" style="margin-top:10px; padding-left:10px; padding-right:10px; text-align:justify;">
				<div class="padding-bottom">
					<strong style="color:#E46C0A; font-size:1.1em;">Danh sách chức năng</strong>
				</div>
				<div class="span-15 padding-bottom">
					<div class="span-1 margin-text">
					<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/question.png"
						width="30px" height="30px" />
					</div>
					<div class="span-14 last" style="padding-top:5px">
						Thay đổi thời gian làm việc			
					</div>
				</div>
				<div class="span-15">
					<div class="span-1 margin-text">
						<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/answer.png"
							width="30px" height="30px" />
					</div>
					<div class="span-14 last">
						Khi một nhân viên trong tổ chức muốn thay đổi thời gian làm việc của mình sớm hơn, hoặc trễ hơn so với
						giờ làm việc chính thức của công ty. Người dùng (vai trò là nhân viên cấp dưới) sẽ tạo đơn xin thay đổi thời gian làm việc
						và gửi cho cấp trên của mình với khung thời gian cụ thể.
						<br>
						Khi PM vào chức năng "Thay đổi thời gian làm việc", họ sẽ thấy các đơn xin thay đổi thời gian làm việc đã và đang chờ phê duyệt của cấp dưới.
						PM sẽ chọn đơn chờ phê duyệt sau đó thực hiện phê duyệt và viết lời phản hồi của mình. Nếu PM đồng ý thì thời gian làm việc mới của nhân viên
						xin đăng ký thay đổi thời gian làm việc có hiệu lực, và công tác chấm công sẽ dựa vào thời gian làm việc mới này để tính. Còn người ngược lại
						nếu PM không đồng ý thì việc thay đổi thời gian làm việc này sẽ không có hiệu lực.
					</div>
				</div>
				<div class="right" style="padding-right:20px">
					<a class="back" href="#"> &lt;&lt; Trở về </a>
				</div>				
			</div>
			
			<div class="support" id="answer_3" style="margin-top:10px; padding-left:10px; padding-right:10px; text-align:justify;">
				<div class="padding-bottom">
					<strong style="color:#E46C0A; font-size:1.1em;">Danh sách chức năng</strong>
				</div>
				<div class="span-15 padding-bottom">
					<div class="span-1 margin-text">
					<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/question.png"
						width="30px" height="30px" />
					</div>
					<div class="span-14 last" style="padding-top:5px">
						Cấu hình chấm công			
					</div>
				</div>
				<div class="span-15">
					<div class="span-1 margin-text">
						<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/answer.png"
							width="30px" height="30px" />
					</div>
					<div class="span-14 last">
						Cấu hình chức năng gồm nhữn phần sau:
						<ul style="margin-left:10px; margin-bottom:0px;">
							<li>Cấu hình Email</li>
							<li>Cấu hình thời gian làm việc</li>
							<li>Cấu hình lịch làm việc</li>
							<li>Cấu hình mã chấm công</li>
							<li>Cấu hình file chấm công</li>
						</ul>
						<br>
						<b>Cấu hình Email:</b> Dùng để cấu hình các loại email, khi xảy ra một sự kiện gửi đơn, phê duyệt,... về vấn đề chấm công như:
						Email thay đổi thời gian làm việc, email phản hồi đơn thay đổi thời gian làm việc... thì hệ thống sẽ tự động gởi email đến những
						người liên quan cũng như các bộ phận liên quan.
						<br>
						<b>Cấu hình thời gian làm việc:</b> Dùng để cấu hình thời gian làm việc mặc định của công ty gồm: Giờ bắt đầu và kết thúc làm việc,
						thời gian đi trễ tối đa,số phút đi trễ cho phép, số phút về sớm cho phép, thời gian đi trễ tối đa(phút), thời gian về sớm tối đa(phút)
						hệ số đi trễ bị phạt, số phút về sớm bị phạt.
						<br>
						<b>Cấu hình lịch làm việc:</b> Dùng để xem, thêm xóa, các ngày nghỉ trong tháng, trong năm
						<br>
						<b>Cấu hình mã chấm công:</b> Dùng để cấu hình mã chấm công cho nhân viên tương ứng với từng nhân viên để cập nhật dữ liệu chấm công cho nhân
						viên.
						<br>
						<b>Cấu hình file chấm công:</b> Dùng để cấu hình tên các cột sẽ lấy ra tương ứng và lưu xuống cơ sở dữ liệu từ file chấm công, thực sự hữu ích
						khi mỗi công ty/tổ chức sử dụng các loại máy chấm công khác nha.
					</div>
				</div>
				<div class="right" style="padding-right:20px">
					<a class="back" href="#"> &lt;&lt; Trở về </a>
				</div>
			</div>
			
			<div class="support" id="answer_4" style="margin-top:10px; padding-left:10px; padding-right:10px; text-align:justify;">
				<div class="padding-bottom">
					<strong style="color:#E46C0A; font-size:1.1em;">Danh sách chức năng</strong>
				</div>
				<div class="span-15 padding-bottom">
					<div class="span-1 margin-text">
					<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/question.png"
						width="30px" height="30px" />
					</div>
					<div class="span-14 last" style="padding-top:5px">
						Phân quyền chấm công		
					</div>
				</div>
				<div class="span-15">
					<div class="span-1 margin-text">
						<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/answer.png"
							width="30px" height="30px" />
					</div>
					<div class="span-14 last">
						Dùng để thực hiện phân quyền cho các nhân viên trong công ty dựa vào vai trò, quyền đặc biệt 
						hoặc ủy quyền. Để từ đó hệ thống dựa vào những thông tin phân quyền này để xác định một thành
						viên của tổ chức có quyền thực hiện những chức năng nào trong phần thông tin chấm công.
					</div>
				</div>			
				<div class="right" style="padding-right:20px">
					<a class="back" href="#"> &lt;&lt; Trở về </a>
				</div>
			</div>
			
			<div class="support" id="answer_5" style="margin-top:10px; padding-left:10px; padding-right:10px; text-align:justify;">
				<div class="padding-bottom">
					<strong style="color:#E46C0A; font-size:1.1em;">Danh sách chức năng</strong>
				</div>
				<div class="span-15 padding-bottom">
					<div class="span-1 margin-text">
					<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/question.png"
						width="30px" height="30px" />
					</div>
					<div class="span-14 last" style="padding-top:5px">
						Thông tin nghỉ phép		
					</div>
				</div>
				<div class="span-15">
					<div class="span-1 margin-text">
						<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/answer.png"
							width="30px" height="30px" />
					</div>
					<div class="span-14 last">
						Khi một nhân viên trong công ty/tổ chức muốn xin nghỉ phép họ chỉ việc tạo đơn xin nghỉ phép
						với những thông tin về thời gian nghỉ và lý do xin nghỉ. Sau đó gửi, hệ thống sẽ gởi đến cho PM
						<br>
						Sau khi đơn xin nghỉ phép của nhân viên được gởi đến PM, người PM này sẽ thực hiện phê duyệt đơn này. Nếu
						đồng ý thì nó sẽ thông báo bằng email đến nhân viên xin nghỉ phép này và được cập vào thông tin chấm công 
						của nhân viên này. Và ngược lại thì hệ thống sẽ thông báo bằng email cho nhân viên này. 
					</div>
				</div>	
				<div class="right" style="padding-right:20px">
						<a class="back" href="#"> &lt;&lt; Trở về </a>
				</div>
			</div>
			<div class="support" id="answer_6" style="margin-top:10px; padding-left:10px; padding-right:10px; text-align:justify;">
				<div class="padding-bottom">
					<strong style="color:#E46C0A; font-size:1.1em;">Danh sách chức năng</strong>
				</div>
				<div class="span-15 padding-bottom">
					<div class="span-1 margin-text">
					<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/question.png"
						width="30px" height="30px" />
					</div>
					<div class="span-14 last" style="padding-top:5px">
						Cấu hình nghỉ phép		
					</div>
				</div>
				<div class="span-15">
					<div class="span-1 margin-text">
						<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/answer.png"
							width="30px" height="30px" />
					</div>
					<div class="span-14 last">
						<b>Cấu hình Email:</b> Dùng để cấu hình các loại email, khi xảy ra một sự kiện gửi đơn, phê duyệt,... về vấn đề nghỉ phép như:
						Email xin nghỉ phép, email phản hồi đơn xin nghỉ phép... thì hệ thống sẽ tự động gởi email đến những
						người liên quan cũng như các bộ phận liên quan.
					</div>
				</div>	
				<div class="right" style="padding-right:20px">
						<a class="back" href="#"> &lt;&lt; Trở về </a>
				</div>
			</div>
			<div class="support" id="answer_7" style="margin-top:10px; padding-left:10px; padding-right:10px; text-align:justify;">
				<div class="padding-bottom">
					<strong style="color:#E46C0A; font-size:1.1em;">Danh sách chức năng</strong>
				</div>
				<div class="span-15 padding-bottom">
					<div class="span-1 margin-text">
					<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/question.png"
						width="30px" height="30px" />
					</div>
					<div class="span-14 last" style="padding-top:5px">
						Phân quyền nghỉ phép		
					</div>
				</div>
				<div class="span-15">
					<div class="span-1 margin-text">
						<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/answer.png"
							width="30px" height="30px" />
					</div>
					<div class="span-14 last">
						Dùng để thực hiện phân quyền cho các nhân viên trong công ty dựa vào vai trò, quyền đặc biệt 
						hoặc ủy quyền. Để từ đó hệ thống dựa vào những thông tin phân quyền này để xác định một thành
						viên của tổ chức có quyền thực hiện những chức năng nào trong phần thông tin nghỉ phép.
					</div>
				</div>	
				<div class="right" style="padding-right:20px">
						<a class="back" href="#"> &lt;&lt; Trở về </a>
				</div>
			</div>
			<div class="support" id="answer_8" style="margin-top:10px; padding-left:10px; padding-right:10px; text-align:justify;">
				<div class="padding-bottom">
					<strong style="color:#E46C0A; font-size:1.1em;">Danh sách chức năng</strong>
				</div>
				<div class="span-15 padding-bottom">
					<div class="span-1 margin-text">
					<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/question.png"
						width="30px" height="30px" />
					</div>
					<div class="span-14 last" style="padding-top:5px">
						Đăng ký tăng ca	
					</div>
				</div>
				<div class="span-15">
					<div class="span-1 margin-text">
						<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/answer.png"
							width="30px" height="30px" />
					</div>
					<div class="span-14 last">
						Khi một nhân viên trong công ty/tổ chức muốn xin tăng ca để giải quyết công việc, họ sẽ thông báo cho PM của mình.
						Sau đó PM sẽ tổng hợp lại và tạo đăng ký tăng ca với các thông tin chi tiết gồm: Lý do tăng ca chung, ngày tăng ca,
						giờ bắt đầu, số giờ tăng ca, lý do chi tiết của từng nhân viên...
						</br>
						Sau khi đơn đăng ký tăng ca của PM được gởi đến BOD, người BOD này sẽ thực hiện phê duyệt đơn này. Nếu
						đồng ý thì nó sẽ thông báo bằng email đến PM đăng ký tăng ca này và được cập vào thông tin chấm công 
						của các nhân viên đăng ký tăng ca. Và ngược lại thì hệ thống sẽ thông báo bằng email cho PM. 
					</div>
				</div>	
				<div class="right" style="padding-right:20px">
						<a class="back" href="#"> &lt;&lt; Trở về </a>
				</div>
			</div>
			<div class="support" id="answer_9" style="margin-top:10px; padding-left:10px; padding-right:10px; text-align:justify;">
				<div class="padding-bottom">
					<strong style="color:#E46C0A; font-size:1.1em;">Danh sách chức năng</strong>
				</div>
				<div class="span-15 padding-bottom">
					<div class="span-1 margin-text">
					<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/question.png"
						width="30px" height="30px" />
					</div>
					<div class="span-14 last" style="padding-top:5px">
						Báo cáo tăng ca
					</div>
				</div>
				<div class="span-15">
					<div class="span-1 margin-text">
						<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/answer.png"
							width="30px" height="30px" />
					</div>
					<div class="span-14 last">
						Sau khi tăng ca PM sẽ thực hiện tạo báo cáo tăng ca, cập nhật các thông tin tăng ca thực tế so
						với thông tin đăng ký tăng ca. Sau đó gởi cho BOD.
						</br>
						BOD sẽ xem và duyệt các đơn báo cáo tăng ca này
					</div>
				</div>	
				<div class="right" style="padding-right:20px">
						<a class="back" href="#"> &lt;&lt; Trở về </a>
				</div>
			</div>
			<div class="support" id="answer_10" style="margin-top:10px; padding-left:10px; padding-right:10px; text-align:justify;">
				<div class="padding-bottom">
					<strong style="color:#E46C0A; font-size:1.1em;">Danh sách chức năng</strong>
				</div>
				<div class="span-15 padding-bottom">
					<div class="span-1 margin-text">
					<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/question.png"
						width="30px" height="30px" />
					</div>
					<div class="span-14 last" style="padding-top:5px">
						Cấu hình tăng ca	
					</div>
				</div>
				<div class="span-15">
					<div class="span-1 margin-text">
						<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/answer.png"
							width="30px" height="30px" />
					</div>
					<div class="span-14 last">
						Cấu hình tăng ca gồm:
						<ul>
						<li>Cấu hình email</li>
						<li>Cấu hình hệ số tăng ca</li>
						</ul>
						</br>
						<b>Cấu hình Email:</b> Dùng để cấu hình các loại email, khi xảy ra một sự kiện gửi đơn, phê duyệt,... về vấn đề nghỉ phép như:
						Email xin nghỉ phép, email phản hồi đơn xin nghỉ phép... thì hệ thống sẽ tự động gởi email đến những
						người liên quan cũng như các bộ phận liên quan.
						</br>
						<b>Cấu hình hệ số tăng ca:</b> Dùng để cấu hình hệ số tăng ca cho nhân viên dựa vào loại ngày làm việc, và giờ tăng ca, BOD sẽ
						cấu hình các hệ số tăng ca khác nhau.
					</div>
				</div>	
				<div class="right" style="padding-right:20px">
						<a class="back" href="#"> &lt;&lt; Trở về </a>
				</div>
			</div>
			<div class="support" id="answer_11" style="margin-top:10px; padding-left:10px; padding-right:10px; text-align:justify;">
				<div class="padding-bottom">
					<strong style="color:#E46C0A; font-size:1.1em;">Danh sách chức năng</strong>
				</div>
				<div class="span-15 padding-bottom">
					<div class="span-1 margin-text">
					<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/question.png"
						width="30px" height="30px" />
					</div>
					<div class="span-14 last" style="padding-top:5px">
						Phân quyền tăng ca	
					</div>
				</div>
				<div class="span-15">
					<div class="span-1 margin-text">
						<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/answer.png"
							width="30px" height="30px" />
					</div>
					<div class="span-14 last">
						Dùng để thực hiện phân quyền cho các nhân viên trong công ty dựa vào vai trò, quyền đặc biệt 
						hoặc ủy quyền. Để từ đó hệ thống dựa vào những thông tin phân quyền này để xác định một thành
						viên của tổ chức có quyền thực hiện những chức năng nào trong phần thông tin tăng ca.
					</div>
				</div>	
				<div class="right" style="padding-right:20px">
						<a class="back" href="#"> &lt;&lt; Trở về </a>
				</div>
			</div>
			<div class="support" id="answer_12" style="margin-top:10px; padding-left:10px; padding-right:10px; text-align:justify;">
				<div class="padding-bottom">
					<strong style="color:#E46C0A; font-size:1.1em;">Danh sách chức năng</strong>
				</div>
				<div class="span-15 padding-bottom">
					<div class="span-1 margin-text">
					<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/question.png"
						width="30px" height="30px" />
					</div>
					<div class="span-14 last" style="padding-top:5px">
						Báo cáo cá nhân	
					</div>
				</div>
				<div class="span-15">
					<div class="span-1 margin-text">
						<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/answer.png"
							width="30px" height="30px" />
					</div>
					<div class="span-14 last">
						Để xem và in ra các thông kê chi tiết về thông tin làm việc của mỗi cá nhân nhân viên
					</div>
				</div>	
				<div class="right" style="padding-right:20px">
						<a class="back" href="#"> &lt;&lt; Trở về </a>
				</div>
			</div>
			<div class="support" id="answer_13" style="margin-top:10px; padding-left:10px; padding-right:10px; text-align:justify;">
				<div class="padding-bottom">
					<strong style="color:#E46C0A; font-size:1.1em;">Danh sách chức năng</strong>
				</div>
				<div class="span-15 padding-bottom">
					<div class="span-1 margin-text">
					<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/question.png"
						width="30px" height="30px" />
					</div>
					<div class="span-14 last" style="padding-top:5px">
						Báo cáo tổng hợp	
					</div>
				</div>
				<div class="span-15">
					<div class="span-1 margin-text">
						<img class="absmiddle" style="margin: 0" src="/ProGate-portlet/images/lmis/answer.png"
							width="30px" height="30px" />
					</div>
					<div class="span-14 last">
						Để xem và in ra các thống kê chi tiết về thông tin làm việc của tất cả các nhân viên trong dự án trong tổ chức con/dự án
						theo từng tháng. 
					</div>
				</div>	
				<div class="right" style="padding-right:20px">
						<a class="back" href="#"> &lt;&lt; Trở về </a>
				</div>
			</div>
		</div>
		
		<div class="span-7 last" style="position: relative; float: left;">
			<div style="border: 1px solid darkgray; margin-top:10px">
				<table width="100%">
					<thead class="support-title">
						<tr>
							<th>Danh Sách Chức Năng</th>
						</tr>
					<thead>
				</table>
				<div style="padding-left:5px"><img class="absmiddle" src="/ProGate-portlet/images/lmis/Program-Group.png"
					width="13px" height="13px" /> <a id="att-category" href="#" style="font-weight: bold;">Quản lý chấm công</a>
				</div>
					<div style="padding:5px; padding-left:25px">
						<img class="absmiddle" src="/ProGate-portlet/images/lmis/bullet_go.png"
							width="13px" height="13px" /> <a id="faq_1" href="#">Thông tin chấm công </a>
					</div>
					<div style="padding:5px; padding-left:25px">
						<img class="absmiddle" src="/ProGate-portlet/images/lmis/bullet_go.png"
							width="13px" height="13px" /> <a id="faq_2" href="#">Thay đổi thời gian làm việc</a>
					</div>
					<div style="padding:5px; padding-left:25px">
						<img class="absmiddle" src="/ProGate-portlet/images/lmis/bullet_go.png"
							width="13px" height="13px" /> <a id="faq_3" href="#">Cấu hình chấm công</a>
					</div>
					<div style="padding:5px; padding-left:25px">
						<img class="absmiddle" src="/ProGate-portlet/images/lmis/bullet_go.png"
							width="13px" height="13px" /> <a id="faq_4" href="#">Phân quyền chấm công</a>
					</div>
				<div style="padding-left:5px"><img class="absmiddle" src="/ProGate-portlet/images/lmis/Program-Group.png"
					width="13px" height="13px" /> <a id="dayoff-category" href="#" style="font-weight: bold;">Quản lý nghỉ phép</a>
				</div>
					<div style="padding:5px; padding-left:25px">
						<img class="absmiddle" src="/ProGate-portlet/images/lmis/bullet_go.png"
							width="13px" height="13px" /> <a id="faq_5" href="#">Thông tin nghỉ phép</a>
					</div>
					<div style="padding:5px; padding-left:25px">
						<img class="absmiddle" src="/ProGate-portlet/images/lmis/bullet_go.png"
							width="13px" height="13px" /> <a id="faq_6" href="#">Cấu hình nghỉ phép</a>
					</div>
					<div style="padding:5px; padding-left:25px">
						<img class="absmiddle" src="/ProGate-portlet/images/lmis/bullet_go.png"
							width="13px" height="13px" /> <a id="faq_7" href="#">Phân quyền nghỉ phép</a>
					</div>
				<div style="padding-left:5px"><img class="absmiddle" src="/ProGate-portlet/images/lmis/Program-Group.png"
					width="13px" height="13px" /> <a id="ot-category" href="#" style="font-weight: bold;">Quản lý tăng ca</a>
				</div>
					<div style="padding:5px; padding-left:25px">
						<img class="absmiddle" src="/ProGate-portlet/images/lmis/bullet_go.png"
							width="13px" height="13px" /> <a id="faq_8" href="#">Đăng ký tăng ca</a>
					</div>
					<div style="padding:5px; padding-left:25px">
						<img class="absmiddle" src="/ProGate-portlet/images/lmis/bullet_go.png"
							width="13px" height="13px" /> <a id="faq_9" href="#">Báo cáo tăng ca</a>
					</div>
					<div style="padding:5px; padding-left:25px">
						<img class="absmiddle" src="/ProGate-portlet/images/lmis/bullet_go.png"
							width="13px" height="13px" /> <a id="faq_10" href="#">Cấu hình tăng ca</a>
					</div>
					<div style="padding:5px; padding-left:25px">
						<img class="absmiddle" src="/ProGate-portlet/images/lmis/bullet_go.png"
							width="13px" height="13px" /> <a id="faq_11" href="#">Phân quyền tăng ca</a>
					</div>
				<div style="padding-left:5px"><img class="absmiddle" src="/ProGate-portlet/images/lmis/Program-Group.png"
					width="13px" height="13px" /> <a id="report-category" href="#" style="font-weight: bold;">Báo cáo</a>
				</div>
					<div style="padding:5px; padding-left:25px">
						<img class="absmiddle" src="/ProGate-portlet/images/lmis/bullet_go.png"
							width="13px" height="13px" /> <a id="faq_12" href="#">Báo cáo cá nhân</a>
					</div>
					<div style="padding:5px; padding-left:25px">
						<img class="absmiddle" src="/ProGate-portlet/images/lmis/bullet_go.png"
							width="13px" height="13px" /> <a id="faq_13" href="#">Báo cáo tổng hợp</a>
					</div>
			</div>
			<div style="border: 1px solid darkgray; margin-top:10px; margin-bottom:10px">
				<table width="100%">
					<thead class="support-title">
						<tr>
							<th align="center">Tài liệu</th>
						</tr>
					<thead>
				</table>
				<div style="padding:5px">
					<img class="absmiddle" src="/ProGate-portlet/images/lmis/download-material.png"
						width="13px" height="13px" /> 
					<a href="#"> Hướng dẫn sử dụng "Quản Lý Thời Gian" </a>
					<img class="absmiddle" src="/ProGate-portlet/images/lmis/pdf.png" width="13px" height="13px" />
				</div>
				<div style="padding:5px">
					<img class="absmiddle" src="/ProGate-portlet/images/lmis/download-material.png"
						width="13px" height="13px" /> 
					<a href="#"> Video hướng sử dụng "Quản lý thời gian"</a>
					<img class="absmiddle" src="/ProGate-portlet/images/lmis/video.png"
						width="13px" height="13px" />
				</div>
			</div>
		</div>
  </div>
</div>
<script>
jQuery(document).ready(function(){
	
	jQuery(".support").hide();
	jQuery("#clip").show();
	jQuery("#LMIS").show();
	
	jQuery("#faq_1, #att-category").click(function(){
		jQuery(".support").hide();
		jQuery("#answer_1").show();
	});
	jQuery("#faq_2").click(function(){
		jQuery(".support").hide();
		jQuery("#answer_2").show();
	});
	jQuery("#faq_3").click(function(){
		jQuery(".support").hide();
		jQuery("#answer_3").show();
	});
	jQuery("#faq_4").click(function(){
		jQuery(".support").hide();
		jQuery("#answer_4").show();
	});
	jQuery("#faq_5, #dayoff-category").click(function(){
		jQuery(".support").hide();
		jQuery("#answer_5").show();
	});
	jQuery("#faq_6").click(function(){
		jQuery(".support").hide();
		jQuery("#answer_6").show();
	});
	jQuery("#faq_7").click(function(){
		jQuery(".support").hide();
		jQuery("#answer_7").show();
	});
	jQuery("#faq_8, #ot-category").click(function(){
		jQuery(".support").hide();
		jQuery("#answer_8").show();
	});
	jQuery("#faq_9").click(function(){
		jQuery(".support").hide();
		jQuery("#answer_9").show();
	});
	jQuery("#faq_10").click(function(){
		jQuery(".support").hide();
		jQuery("#answer_10").show();
	});
	jQuery("#faq_11").click(function(){
		jQuery(".support").hide();
		jQuery("#answer_11").show();
	});
	jQuery("#faq_12, #report-category").click(function(){
		jQuery(".support").hide();
		jQuery("#answer_12").show();
	});
	jQuery("#faq_13").click(function(){
		jQuery(".support").hide();
		jQuery("#answer_13").show();
	});
	
	jQuery(".back").click(function(){
		jQuery(".support").hide();
		jQuery("#clip").show();
		jQuery("#LMIS").show();
	});
});
</script>