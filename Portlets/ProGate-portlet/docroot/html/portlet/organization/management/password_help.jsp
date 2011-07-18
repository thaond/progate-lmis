<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
	<div id="password-help" >
	  <div>
	    <span style="font-weight:bold;">Mật khẩu được đánh giá như thế nào?</span><br />
	  	Độ bảo mật của mật khẩu được đánh giá theo 4 tiêu chí:
	    <ul class="fix_ul">
		  <li><img src="<%=request.getContextPath() %>images/dot.png" /> Kí tự hoa</li>
		  <li><img src="<%=request.getContextPath() %>images/dot.png" /> Kí tự thường</li>
		  <li><img src="<%=request.getContextPath() %>images/dot.png" /> Số</li>
		  <li><img src="<%=request.getContextPath() %>images/dot.png" /> Kí tự đặc biệt</li>
		</ul>
		<span style="font-weight:bold;">Yếu:</span> Mật khẩu chứa 1 hoặc 2 trong 4 tiêu chí<br />
		<span style="font-weight:bold;">Trung bình:</span> Mật khẩu chứa 3 trong 4 tiêu chí<br />
		<span style="font-weight:bold;">Mạnh:</span> Mật khẩu chứa cả 4 tiêu chí<br />
	  </div>
	   
	  <div style="margin-top:10px;">	  
	   <span style="font-weight:bold;">Độ an toàn của mật khẩu là như thế nào?</span><br />
	    Đầu tiên bạn phải tạo ra một mật khẩu an toàn. Tức là một chương trình máy tính, một cá nhân không thể đoán ra được mật khẩu của bạn trong 
thời gian ngắn. Để giúp bạn chọn ra được một mật khẩu an toàn chúng tôi đã tạo ra một tính năng giúp bạn nhận biết như thế nào là mật khẩu 
an toàn khi bạn tạo ra nó.  	
       </div>
       
       <div style="margin-top:10px;">
      	<span style="font-weight:bold;">Mẹo để tạo một mật khẩu an toàn</span><br />
      	<ul class="fix_ul">
      	  <li><img src="<%=request.getContextPath() %>images/dot.png" /> Bao gồm dấu chấm câu, dấu /, hoặc số</li>
      	  <li><img src="<%=request.getContextPath() %>images/dot.png" /> Bao gồm chữ hoa và chữ thường</li>
      	  <li><img src="<%=request.getContextPath() %>images/dot.png" /> Kí tự thay thế tương tự như: số "0" thay chữ “o”, “@” thay chữ "a"</li>
      	  <li><img src="<%=request.getContextPath() %>images/dot.png" /> Tạo một từ viết tắt</li>
      	  <li><img src="<%=request.getContextPath() %>images/dot.png" /> Thay thế ngữ âm, chẳng hạn như: “What R u looking 4” thay cho “What are you looking for”</li>
      	</ul>
	   </div>
	     
	   <div style="margin-top:10px;">
		  	<span style="font-weight:bold;">Những điều nên tránh</span><br />
		  	<ul class="fix_ul">
		  	  <li><img src="<%=request.getContextPath() %>images/dot.png" /> Không nên sử dụng mật khẩu theo kiểu liệt kê</li>
		  	  <li><img src="<%=request.getContextPath() %>images/dot.png" /> Không nên sử dụng mật khẩu chứa thông tin cá nhân (Tên, ngày, tháng năm sinh)</li>
		  	  <li><img src="<%=request.getContextPath() %>images/dot.png" /> Không nên sử dụng mật khẩu chứa các từ hoặc cụm từ viết tắt có thể tìm thấy trong từ điển</li>
		  	  <li><img src="<%=request.getContextPath() %>images/dot.png" /> Không nên sử dụng mật khẩu chứa tất cả các kí tự là số hoặc chữ hoa hoặc chữ thường</li>
		  	  <li><img src="<%=request.getContextPath() %>images/dot.png" /> Không nên sử dụng mật khẩu lặp lại (bbbaaa)</li>
		  	</ul>
	    </div>
	    
	    <div style="margin-top:10px;">
		  	<span style="font-weight:bold;">Mẹo để giữ mật khẩu của bạn an toàn</span><br />
		  	<ul class="fix_ul">
		  	  <li><img src="<%=request.getContextPath() %>images/dot.png" /> Không nên nói mật khẩu của bạn cho người khác biết</li>
		  	  <li><img src="<%=request.getContextPath() %>images/dot.png" /> Không nên viết mật khẩu của bạn ra</li>
		  	  <li><img src="<%=request.getContextPath() %>images/dot.png" /> Không nên gửi mật khẩu của bạn qua email</li>
		  	  <li><img src="<%=request.getContextPath() %>images/dot.png" /> Nên kiểm tra mật khẩu định kỳ và thay đổi mật khẩu mới</li>
		  	</ul>
	    </div>
	</div>
	