package com.larion.progate.cds.employee.action;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import javax.mail.internet.InternetAddress;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.larion.progate.common.action.ParameterizableViewAction;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portlet.messageboards.util.BBCodeUtil;
import com.liferay.util.mail.MailEngine;

public class ReviewingEmployeeAction extends ParameterizableViewAction {

	@Override
	public void handleRenderRequestInternal(RenderRequest request,
			RenderResponse response, Map<String, Object> bean) throws Exception {

		Properties props = new Properties();
		InputStream inStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("mail-template.properties");
		props.load(inStream);
		inStream.close();

		String subject = "Hi";
		String body = props.getProperty("BODY");
		System.out.println("body: " + body);

		InternetAddress from = new InternetAddress("thiennt@elarion.com",
				"thiennt");

		InternetAddress to = new InternetAddress("nguyentungthien@gmail.com",
				"nguyentungthien");

		String curBody = StringUtil.replace(body,
				new String[] { "[$TO_NAME$]" },
				new String[] { "nguyentungthien" });
		curBody = BBCodeUtil.getHTML(curBody);
		System.out.println("curBody: " + curBody);

		MailMessage message = new MailMessage(from, to, subject, curBody, true);

		MailEngine.send(message);
		//MailServiceUtil.sendEmail(message);
	}
}