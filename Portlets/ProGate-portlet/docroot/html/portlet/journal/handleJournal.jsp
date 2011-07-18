<%@ include file="../common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript" src="/ProGate-portlet/js/scaleImg.js"></script>


<script type="text/javascript">	
	
	function initEditor() {
		
		var out = document.frmJournal.<%=JournalArticle_RS.JA_CONTENT%>.value;
		
	    window.jaContent.setHTML(out);
	    
		return document.frmJournal.<%=JournalArticle_RS.JA_CONTENT%>.value;
	}
	
	function getHtmlValue() {
	    var html = window.<%=JournalArticle_RS.JA_CONTENT%>.getHTML();	    
	}
	
	/* Variables to validate */	
	var valid_journal_title = false;
	var valid_journal_description = false;
	var valid_journal_content = false;
	var valid_journal_image = false;
	
	function submit(url) {
		
		if ( valid_journal_title == true &&
			 valid_journal_description == true &&
			 valid_journal_content == true &&
			 valid_journal_image == true ) {
			
			document.frmJournal.action = url;
			document.frmJournal.submit();
		} else {
			jQuery("#tnt-global-message").removeClass("tnt-global-success-message");
			jQuery("#tnt-global-message").addClass("tnt-global-error-message");
			jQuery("#tnt-global-message span").text('<fmt:message key="warning.product.global.error" />');
		}
	}	
	
	function addSubmit() {
		var url = 
			'<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>">
				<portlet:param name="action" value="handleJournal"></portlet:param>
			    <portlet:param name="<%=Constants.CMD%>" value="<%=Constants.ADD%>"/>
			</portlet:actionURL>';
		
		jQuery("#successMsg").val('<fmt:message key="warning.journal.add.success"></fmt:message>');
		
		submit(url);
	}
	
	function updateSubmit() {
		
		var url = 
			'<portlet:actionURL windowState="<%=WindowState.MAXIMIZED.toString()%>">
				<portlet:param name="action" value="handleJournal"></portlet:param>
				<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.UPDATE%>"/>
			</portlet:actionURL>';
		
			jQuery("#successMsg").val('<fmt:message key="warning.journal.update.success"></fmt:message>');
		
		submit(url);
	}
	
	function deleteJournal() {
		if (confirm('<fmt:message key="warning.product.confirm.delete"/>')) {
			var url = 
				'<portlet:actionURL windowState="<%=WindowState.NORMAL.toString()%>">
					<portlet:param name="action" value="handleProduct" />
					<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.DELETE%>"/>
				</portlet:actionURL>';
			
			jQuery("#successMsg").val('<fmt:message key="warning.journal.delete.success"></fmt:message>');
				
			document.frmJournal.action = url;
		    document.frmJournal.submit();
		}
	}
	
	function validate() {
		
		// Validate journal title
		var journal_title_val = jQuery.trim(document.frmJournal.<%=JournalArticle_RS.JA_TITLE%>.value);
		if( journal_title_val == "") {
			jQuery("#error_journal_title").text('<fmt:message key="warning.journal.require.title" />');
			valid_journal_title = false;
		} else {
			jQuery("#error_journal_title").text('');
			valid_journal_title = true;
		}
				
		// Validate journal description
		var journal_description_val = jQuery.trim(document.frmJournal.<%=JournalArticle_RS.JA_DESCRIPTION%>.value);
		if( journal_description_val == "") {
			jQuery("#error_journal_description").text('<fmt:message key="warning.journal.require.description" />');			
			valid_journal_description = false;
		} else {
			jQuery("#error_journal_description").text('');
			valid_journal_description = true;
		}
		
		// Validate journal content
		var journal_content_val = jQuery.trim(window.jaContent.getHTML());
		document.frmJournal.<%=JournalArticle_RS.JA_CONTENT%>.value = journal_content_val;
		if( journal_content_val == "") {
			jQuery("#error_journal_content").text('<fmt:message key="warning.journal.require.content" />');			
			valid_journal_content = false;
		} else {
			jQuery("#error_journal_content").text('');
			valid_journal_content = true;
		}		
	}
	
	function validateAddImage() {
		// Validate journal image
		var journal_image_val = jQuery.trim(document.frmJournal.<%=JournalArticle_RS.JA_SMALL_IMAGE_URL%>.value);
		if( journal_image_val == "") {
			jQuery("#error_journal_image").text('<fmt:message key="warning.journal.require.image" />');
			valid_journal_image = false;
		}
	}
	
	function validateUpdateImage() {
		var journal_image_val = jQuery.trim(document.frmJournal.<%=JournalArticle_RS.JA_SMALL_IMAGE_URL%>.value);
		if( journal_image_val == "") {
			jQuery("#error_journal_image").text('');
			valid_journal_image = true;
		}
	}
	
	function update_validate_and_submit() {
		validate();
		validateUpdateImage();
		updateSubmit();
	}
	
	function add_validate_and_submit() {
		validate();
		validateAddImage();
		addSubmit();
	}
	
	function cancel(url) {
		window.location = url;
	}
	
	jQuery(document).ready(function(){		
		/*  Load warning message when form on load */
		var smgStatusVal = jQuery("#msgStatus").val();
		if ( smgStatusVal != 0) {
			if ( smgStatusVal == 1 ) {				
				jQuery("#tnt-global-message").addClass("tnt-global-success-message");
				jQuery("#tnt-global-message").removeClass("tnt-global-error-message");
				jQuery("#tnt-global-message span").text(jQuery("#successMsg").val());				
			} else {
				jQuery("#tnt-global-message").removeClass("tnt-global-success-message");
				jQuery("#tnt-global-message").addClass("tnt-global-error-message");
				jQuery("#tnt-global-message span").text(jQuery("#failMsg").val());
			}
		}
		
		var desc = jQuery("textarea[name='<%=JournalArticle_RS.JA_DESCRIPTION%>']").val();
		jQuery("textarea[name='<%=JournalArticle_RS.JA_DESCRIPTION%>']").val(jQuery.trim(desc));
		
		jQuery("textarea[name='<%=JournalArticle_RS.JA_DESCRIPTION%>']").bind('paste', function(e) {	     
			setTimeout(function() {
				var value = document.frmJournal.<%=JournalArticle_RS.JA_DESCRIPTION%>.value;
				document.frmJournal.<%=JournalArticle_RS.JA_DESCRIPTION%>.value = value.substring(0, 160);
		    }, 10);
		});
		
		jQuery("input[name='<%=JournalArticle_RS.JA_SMALL_IMAGE_URL%>']").change(function(){
			
			if (this.files) {
				//  This works in Firefox, #image-preview is an <img src="" />
				jQuery("#image-preview").attr("src", this.files[0].getAsDataURL());
			} else {
				// This is just wishful thinking, but it's a security issue so the value of the input is never
				// a true local file path
				jQuery("#image-preview").attr("src", jQuery(this).val());
				
			}
			
			var jQueryform = jQuery("form[name='frmJournal']");
	        
			var href = '<portlet:actionURL  windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
							<portlet:param name="action" value="checkingValidImage" />
							<portlet:param name="fileUpload" value="<%=JournalArticle_RS.JA_SMALL_IMAGE_URL%>" />
						</portlet:actionURL>';
			
			jQueryform.ajaxSubmit({
	            url: href,
	            success: function(data) {
	            	data = jQuery.trim(data);
	            	
	            	if (data == 'warning.image.invalid.name.extension') {
	            		jQuery("#error_journal_image").text('<fmt:message key="warning.image.invalid.name.extension" />');
	            		valid_journal_image = false;
	            	} else if (data == 'warning.image.invalid.format') {
	            		jQuery("#error_journal_image").text('<fmt:message key="warning.image.invalid.format" />');
	            		valid_journal_image = false;
	            	} else if (data == 'warning.image.invalid.format') {
	            		jQuery("#error_journal_image").text('<fmt:message key="warning.image.invalid.format" />');
	            		valid_journal_image = false;
	            	} else {
	            		jQuery("#error_journal_image").text('');
	            		valid_journal_image = true;
	            	}
	            }
	        });
		});
	});	
</script>

<form action="" method="post" name="frmJournal" enctype="multipart/form-data" >
<div class="tnt-content" style="margin: 10px;">
	<div class="tnt-row tnt-border-bottom">
		<c:choose>
			<c:when test='${bean.cmd == "add"}'>
				<div class="tnt-row-left">
					<span class="tnt-title-black">
						<fmt:message key="title.journal.add" />
					</span>
				</div>
			</c:when>
			
			<c:otherwise>
				<div class="tnt-row-left">
					<span class="tnt-title-black">
						<fmt:message key="title.journal.edit" />
					</span>
				</div>
			</c:otherwise>
		</c:choose>
		
		<c:if test='${bean.cmd != "add"}'>
			<div class="tnt-row-right">
				<span class="tnt-bt-delete-black">
					<a href='javascript:deleteJournal()' class="tnt-link">
						<img style="vertical-align: middle;" 
							src="<%=request.getContextPath()%>/images/support_org_profile/delete.png" 
							width="20" height="20" />
							
						<fmt:message key="button.delete" />
					</a>
				</span>
			</div>
		</c:if>
	</div>
	
	<div class="tnt-body">
		<div class="tnt-row" id="tnt-global-message">			
			<span>
			
			</span>			
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-left">
				<span class="tnt-required-title">
					<fmt:message key="title.required.field" />
				</span>
			</div>
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-left">
				<span>
					<fmt:message key="title.journal.require.title" />
				</span>
			</div>
			
			<div class="tnt-row-right eighty">
				<span>
					<input type="text" name="<%= JournalArticle_RS.JA_TITLE %>" style="width: 734px;"
						value="${bean.journalArticle.title}" maxlength="40">
					</span>
				<span id="error_journal_title" class="tnt-error-message"></span>
			</div>
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-left">
				<span>
					<fmt:message key="title.journal.require.content" />
				</span>
			</div>
			
			<div class="tnt-row-right eighty jaContent">
				<span>
					<liferay-ui:input-editor
						name='jaContent'
						editorImpl="editor.wysiwyg.portal-web.docroot.html.portlet.progate.edit.view.jsp"
						toolbarSet="liferay-article"
						initMethod='initEditor'
						onChangeMethod='editorContentChanged'
						height="400px"
						width="734px"				
					/>
					
					<input type="hidden" name='<%=JournalArticle_RS.JA_CONTENT %>'  id='<%=JournalArticle_RS.JA_CONTENT %>' 
							value="<c:out value='${bean.journalArticle.content}'></c:out>" />
				</span>
				<br/>
				<span id="error_journal_content" class="tnt-error-message"></span>
			</div>
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-left">
				<span>
					<fmt:message key="title.journal.require.description" />
				</span>
			</div>
			
			<div class="tnt-row-right eighty">
				<textarea rows="5" style="width: 734px;"
						name="<%=JournalArticle_RS.JA_DESCRIPTION %>"
						onkeypress="return imposeMaxLength(this, 160, event);">
					<c:out value='${bean.journalArticle.description}'></c:out>
				</textarea>
				<br/>
				<span id="error_journal_description" class="tnt-error-message"></span>
			</div>			
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-left">
				<span>
					<fmt:message key="title.journal.require.image" />
				</span>
			</div>
			
			<div class="tnt-row-right eighty">
				<div class="tnt-row-left" 
					style="float: left; border: thin ridge #E0EDF4; height: 100px; width: 100px;">	
					<c:set var="smallImageUrl" value="${bean.journalArticle.smallImageUrl}" />
					
					<c:choose>
						<c:when test="${smallImageUrl == null || smallImageUrl == ''}">
							<img alt="" src="<%=request.getContextPath()%>/images/news_org/small_noImage.gif" 
							onLoad='scaleImg(this, 100, 100)' id="image-preview"/>
						</c:when>
						
						<c:otherwise>
							<img id="image-preview" alt="" 
								 src='<c:out value="${bean.journalArticle.smallImageUrl}"></c:out>'
								 onLoad='scaleImg(this, 100, 100)'/>
						</c:otherwise>
					</c:choose>					
				</div>
				
				<div class="tnt-row-right eighty" style="width: 84%;">
					<span>
						<input type="file" id="smallImage" 
						onchange="imagePreview('smallImage', 'image-preview')" 
						name="<%=JournalArticle_RS.JA_SMALL_IMAGE_URL %>" size="81"/>
					</span>
					
					<br/>
					<span id="error_journal_image" class="tnt-error-message"></span>
					
					<br/>
					<span class="tnt-info">
						<fmt:message key="warning.product.image" />
					</span>
				</div>
			</div>
		</div>
		
		<div class="tnt-row">
			<div class="tnt-row-center">
				<span>
					<c:choose>
						<c:when test='${bean.cmd == "add"}'>
							<input type="button" class="bt-form" onclick="add_validate_and_submit()"
								value='<fmt:message key="button.save" />'/>
						</c:when>
						
						<c:otherwise>
							<input type="button" class="bt-form" onclick="update_validate_and_submit()"
								value='<fmt:message key="button.save" />'/>
						</c:otherwise>
					</c:choose>
				</span>
				
				<span>
				<input type="button" class="bt-form"
						onclick="cancel('<c:out value='${bean.returnToFullPageURL}'/>')"
						value='<fmt:message key="button.cancel" />'/>
				</span>
			</div>
		</div>
	</div>
</div>

<input type="hidden" name="<%=JournalArticle_RS.JA_ID %>" value="${bean.journalArticle.journalArticleId}"/>
<input type="hidden" name="<%=URLParameter_RS.ORG_ID %>" value="${bean.orgId}"/>
<input type="hidden" name="<%=URLParameter_RS.RETURN_TO_FULL_PAGE_URL %>" value="${bean.returnToFullPageURL}"/>
<input type="hidden" name="<%=Request.SUCCESS_MESSAGE %>" value="${bean.successMsg}" id="successMsg">
<input type="hidden" name="<%=Request.FAIL_MESSAGE %>" value="${bean.failMsg}" id="failMsg">
</form>

<form name="frmMsg">
	<input type="hidden" name="<%=Request.MESSAGE_STATUS%>" id="msgStatus"
		value="${bean.msgStatus}">
</form>