<%@ include file="../../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<div style="width: 100%">
	<div class="title-msg">
		<fmt:message key="title.cds.decentralization" />
	</div>

	<div class="tabs-menu">
		<c:choose>
			<c:when test="${bean.tabAction == bean.DECENTRALIZE_TOTAL_ACT }">
				<div class="tabs-state tabs-state-active">
				<a><fmt:message key="title.cds.decentralization.total" /></a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="tabs-state tabs-state-default">
					<a  href=''>
						<fmt:message key="title.cds.decentralization.total" />
					</a>
				</div>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${bean.tabAction == bean.DECENTRALIZE_INDIVIDUAL_ACT}">
				<div class="tabs-state tabs-state-active">
				<a><fmt:message key="title.cds.decentralization.individual" /></a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="tabs-state tabs-state-default">					
					<a  href=''>
						<fmt:message key="title.cds.decentralization.individual" />
					</a>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

	<div class="tabs-content">
		<c:choose>
			<c:when test="${bean.tabAction == bean.DECENTRALIZE_TOTAL_ACT}">
				<jsp:include page="decentralizeTotal.jsp"></jsp:include>
			</c:when>

			<c:otherwise>
				<jsp:include page="decentralizeIndividual.jsp"></jsp:include>
			</c:otherwise>
		</c:choose>
	</div>
</div>

	<style type="text/css">
   		.waitingUpload {
   			background: url("/ProGate-portlet/images/ajax-loader.gif");
   		}
	</style>

<div>
	<script type="text/javascript">
		
		function ajaxUpload() {
			var jQueryform = jQuery("form[name='formUpload']");
            
			var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
							<portlet:param name="action" value="checkingValidImage" />
							<portlet:param name="fileUpload" value="imageUpload" />
						</portlet:actionURL>';
			
			jQueryform.ajaxSubmit({
                url: href,                
                success: function(data) {
                	data = jQuery.trim(data);
                	jQuery("#preview").removeClass("waitingUpload");
                	//jQuery("#preview").addClass("waitingUpload");
                	alert(data);
                }
            });
		}
		
		jQuery(function(){
			
			jQuery("input[name='btUpload']").click(function(){
				
				jQuery("#preview").addClass("waitingUpload");
				//window.setTimeout('ajaxUpload()',1000);
				var jQueryform = jQuery("form[name='formUpload']");
	            
				var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
								<portlet:param name="action" value="checkingValidImage" />
								<portlet:param name="fileUpload" value="imageUpload" />
							</portlet:actionURL>';
				
				jQueryform.ajaxSubmit({
	                url: href,                
	                success: function(data) {
	                	data = jQuery.trim(data);
	                	jQuery("#preview").removeClass("waitingUpload");
	                	//jQuery("#preview").addClass("waitingUpload");
	                	alert(data);
	                }
	            });
			});
		});
	</script>
	
	<div id="upload-area">
        <div id="preview" style="width: 16px; height: 16px;">
                
        </div>

        <form action="" method="post" name="formUpload" enctype="multipart/form-data" >
                <label>Upload a Picture of Yourself</label>
                <input type="file" size="20" id="fileUpload"  name="fileUpload" class=" ">
                <input type="button" name="btUpload" value="Save">
        </form>
	</div>
</div>
