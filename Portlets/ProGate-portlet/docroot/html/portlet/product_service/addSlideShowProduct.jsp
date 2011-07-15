<%@ include file="../common/init.jsp" %>
<%@ include file="slide_show_scripts.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<form action="" method="post" name="frmSlideShowProduct" enctype="multipart/form-data">
<div class="tnt-content" style="margin: 10px;">
	<div class="tnt-row tnt-border-bottom">
		<div class="tnt-row-left">
		<span>
			<fmt:message key="title.slideshow.product.add" />
		</span>
		</div>
	</div>
	
	<div class="tnt-row tnt-border-bottom">
		<div class="tnt-row-right ">
			<span class="tnt-bt-up">
			<a href="" class="tnt-link">
			<fmt:message key="button.up" />
			</a>
			</span>
			&nbsp;
			<span class="tnt-bt-down">
			<a href="" class="tnt-link">
			<fmt:message key="button.down" />
			</a>
			</span>			
		</div>
	</div>
	
	<div class="tnt-row">
		<div class="tnt-row-left">
		<span>
		<fmt:message key="warning.product.image" />
		</span>
		</div>
	</div>
	
	<c:forEach begin="0" end="4" varStatus="count">
	<div class="tnt-row tnt-border-bottom">
		<div class="tnt-row-left">
			<div class="tnt-row">
				<div class="tnt-row-left">
				<span>
				<input type="checkbox" class="cb_slide_show" style="margin-top: 65px;" 
						value="${count.count }"/>
				</span>
				</div>
				
				<div class="tnt-row-right">
				<span>
				<img alt="" src="" class="image-preview" style="width: 290px; height: 170px;"/>
				</span>
				</div>
			</div>
		</div>
		
		<div class="tnt-row-right" style="width: 58%;">
			<div class="tnt-row">
			<span>
			<input type="file" name="<%=SlideShowProduct_RS.SSP_IMAGE_URL%>" size="54" class="file-target" />
			</span>
			</div>
			
			<div class="tnt-row">
				<div class="tnt-row-left">
				<span>
				<fmt:message key="title.slideshow.product" />
				</span>
				</div>
				
				<div class="tnt-row-right" style="width: 70%;">
					<span>
					<input type="text" name="<%=SlideShowProduct_RS.SSP_TITLE%>" style="width: 100%;" class="slideShowTitle"/>
					</span>
				
					<span class="error_title_slideshow" class="tnt-error-message"></span>
				</div>
			</div>
			
			<div class="tnt-row">
				<div class="tnt-row-left">
				<span>
				<fmt:message key="title.slideshow.product.corresponding" />
				</span>
				</div>
				
				<div class="tnt-row-right" style="width: 70%;">
					<span>
					<select style="width: 102%;" name="<%=SlideShowProduct_RS.SSP_PRODUCT_ID%>">
					<c:forEach items="${bean.productList}" var="product">
					<option value="${product.primaryKey}">${product.title }</option>
					</c:forEach>
					</select>
					</span>
				</div>
			</div>
		</div>
	</div>
	</c:forEach>
	
	<div class="tnt-row">
	<div class="tnt-row-center">
		<span>
		<input type="button" class="bt-form" onclick="add_validate_and_submit()"
			value='<fmt:message key="button.save" />'/>
		</span>
		
		<span>
		<input type="button" class="bt-form" onclick="cancel()"
			value='<fmt:message key="button.cancel" />'/>
		</span>
	</div>
	</div>
</div>
</form>