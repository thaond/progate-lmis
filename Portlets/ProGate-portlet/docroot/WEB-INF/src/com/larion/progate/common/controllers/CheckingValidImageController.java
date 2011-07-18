package com.larion.progate.common.controllers;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.portlet.mvc.ParameterizableViewController;

import com.larion.progate.common.utils.Functions;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.imagegallery.ImageNameException;
import com.liferay.portlet.imagegallery.ImageSizeException;

public class CheckingValidImageController extends ParameterizableViewController {

	@Override
	protected void handleActionRequestInternal(ActionRequest request,
			ActionResponse response) throws Exception {

		UploadPortletRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(request);
		HttpServletResponse res = PortalUtil.getHttpServletResponse(response);
		ServletOutputStream output = res.getOutputStream();
		
		/*/
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\"?>\n");
		xml.append("<ReturnValue>\n");
		xml.append("<name>");
		xml.append("ThienNT");
		xml.append("</name>\n");
		xml.append("</ReturnValue>\n");
		
		System.out.println("Data: " + xml.toString());
		res.setContentType("text/xml");
		output.print(xml.toString());
		*/
		
		String fileUpload = uploadRequest.getParameter("fileUpload");

		try {
			Functions.checkValidImage(request, uploadRequest, fileUpload);
			output.println("warning.image.valid");
		} catch (Exception e) {
			// Use old image for updating product
			if (e instanceof ImageNameException) {
				output.println("warning.image.invalid.name.extension");
			}

			if (e instanceof IOException) {
				output.println("warning.image.invalid.format");
			}

			if (e instanceof ImageSizeException) {
				output.println("warning.image.invalid.format");
			}
		}
		output.flush();
	}
}
