package com.larion.progate.common.utils;

import com.larion.progate.common.constants.SendMailConst;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.internet.InternetAddress;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.StringUtil;

public class SendMailUtil {

	public void sendMail(InternetAddress from, InternetAddress[] to,
			String subject, String body) throws UnsupportedEncodingException {
		try {
			MailMessage message = new MailMessage(from, subject, body, true);
			message.setTo(to);
			MailServiceUtil.sendEmail(message);
			

			System.out.println("sendMail successful, from: "
					+ from.getAddress() + " to: " + to[0].getAddress());
			System.out.println("subject = " + subject);
			System.out.println("body = " + body);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}

	public void sendMail(InternetAddress[] to, String subject, String body)
			throws UnsupportedEncodingException {
		try {
			InternetAddress from = new InternetAddress(
					SendMailConst.senderEmail, SendMailConst.senderName);

			sendMail(from, to, subject, body);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}

	public void sendMail(InternetAddress from, InternetAddress[] to,
			String typeOfEmail, String[] subjectParam, String[] subjectValue,
			String[] bodyParam, String[] bodyValue)
			throws UnsupportedEncodingException {
		String subject = "";
		String body = "";
		boolean isAllow = true;

		Properties props = new Properties();
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream is = classLoader
				.getResourceAsStream("mail-template.properties");

		System.out.println("Load email template, emailType = " + typeOfEmail);

		try {
			props.load(is);
			is.close();

			subject = new String(props.getProperty(typeOfEmail + "_SUBJECT"));
			if (subject.length() > 0) {
				if (subjectParam.length > 0) {
					subject = StringUtil.replace(subject, subjectParam,
							subjectValue);
				}
			} else {
				isAllow = false;
			}
			// System.out.println("email subject: " + subject);

			body = new String(props.getProperty(typeOfEmail + "_BODY"));
			if (body.length() > 0) {
				if (bodyParam.length > 0) {
					body = StringUtil.replace(body, bodyParam, bodyValue);
				}
			} else {
				isAllow = false;
			}
			// System.out.println("email body: " + body);

			if (isAllow) {
				sendMail(from, to, subject, body);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}

	public void sendMail(InternetAddress[] to, String typeOfEmail,
			String[] subjectParam, String[] subjectValue, String[] bodyParam,
			String[] bodyValue) throws UnsupportedEncodingException {
		try {
			InternetAddress from = new InternetAddress(
					SendMailConst.senderEmail, SendMailConst.senderName);

			sendMail(from, to, typeOfEmail, subjectParam, subjectValue,
					bodyParam, bodyValue);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
	}
}
