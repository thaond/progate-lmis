package com.larion.progate.sign_up.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.portlet.GenericPortlet;
import javax.servlet.ServletContext;

import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.lang.StringBuffer;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import javax.mail.SendFailedException;
import javax.mail.MessagingException;


public class SendMailUtil{
	
	private String subject = "Email kích hoạt tài khoản ProGate";
	private String content;		
	
	private String host = "mail.elarion.com";
	private String protocol = "smtp";
	private String port = "25";
	private String sender = "no-reply@elarion.com";
	private String senderPass = "1qazxsw2";
	private String[] receiver = {"thuyltm@elarion.com"};
	private String activateService;
	private String hashCode;
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private Date today = new Date();		
	private Date seven_date = new Date(today.getTime() + (1000 * 60 * 60 * 24 * 7));
		
	
	private void readMailContent(String firstname, String lastname, String username, String activelink){
		try{	
			this.content = "<p>Chào bạn <span style='font-weight:bold;'>" + firstname + " " + lastname + "</span>,<br /><br />" + 
				"Cảm ơn bạn đã quan tâm đến website của chúng tôi. " +
				"Bạn đã đăng ký thành viên thành công tại website <a href=\"http://www.ProGate.vn\">www.ProGate.vn</a>.<br />" +
				"Bạn vui lòng nhấn vào liên kết dưới đây để kích hoạt tài khoản:<br /><br />" +
				"<a  href=\"VERIFICATION_MAIL_LINK\">Kích hoạt</a><br/><br />" +
				"<span style='color: red;'>Liên kết này sẽ hết hạn vào ngày " +
				 dateFormat.format(seven_date) + ".</span><br /><br />" +
				"Mọi thắc mắc xin vui lòng liên hệ website <a href='http://#'>" +
				"www.ProGate.vn/hotro</a>.<br /><br />" +
				"<span style='text-decoration:underline;'>Lưu ý:</span> " +
				"Đây là email tự động, vui lòng không trả lời email này." +
				"<br /><br />Trân trọng,<br /><span style='font-weight:bold;'>ProGate Team</span></p>";
			
			StringBuilder activationUrl = new StringBuilder(); 
			activationUrl.append(activelink);

			this.content = this.content.replaceAll("VERIFICATION_MAIL_LINK", activationUrl.toString());
			
		} catch(Exception e){
			System.out.println("Read mail content error message : " + e.getMessage());
		}
	}
	
	public void postMail(String firstname, String lastname, String username, String activelink) throws MessagingException
	{
		readMailContent(firstname, lastname, username, activelink);
		boolean debug = false;
	     Properties props = new Properties();
	     props.put("mail.smtp.host", this.host);
	     props.put("mail.smtp.starttls.enable","true");
	     props.put("mail.transport.protocol", this.protocol);
		 props.put("mail.smtp.auth", "true");
		 props.put("mail.smtp.port", this.port);


	    // create some properties and get the default Session		 
		 Session sessions = Session.getInstance(props,
					new javax.mail.Authenticator() 
		  {
			protected PasswordAuthentication getPasswordAuthentication(){ 
				return new PasswordAuthentication("Hokusai2000@gmail.com", "namlong");	
			}
		  });	
		sessions.setDebug(debug);

	    // create a message
		MimeMessage msg = new MimeMessage(sessions);

	    // set the from and to address
	    InternetAddress addressFrom = new InternetAddress(sender);
	    msg.setFrom(addressFrom);

	    InternetAddress[] addressTo = new InternetAddress[receiver.length]; 
	    for (int i = 0; i < receiver.length; i++)
	    {
	        addressTo[i] = new InternetAddress(receiver[i]);
	    }
	    msg.setRecipients(Message.RecipientType.TO, addressTo);
	    // Optional : You can also set your custom headers in the Email if you Want
	    // Setting the Subject and Content Type
	    msg.setSubject(this.subject);
	    try{
	      String str = new String(this.content);
		  byte[] latin1 = str.getBytes("UTF-8");
		  byte[] utf8 = new String(latin1, "ISO-8859-1").getBytes("UTF-8");
		  this.content = new String(utf8, "UTF-8");
		  msg.setContent(this.content, "text/html");
	    }catch(Exception e){
	    	System.out.println(e);
	    }
	    
	   // Transport.send(msg);
	    
	    Transport t = sessions.getTransport(protocol);
	    try {
	        t.connect(this.sender, this.senderPass);
	        t.sendMessage(msg, msg.getAllRecipients());
	    } finally {
	        t.close();
	    }
	}
	
	public void setHashCode(String code){
		this.hashCode = code;
	}
	public String getHashCode() {		
		return this.hashCode;
	}
	
	public void setActivateService(String serv){
		this.activateService = serv;
	}
	public String getActivateService() {		
		return this.activateService;
	}
	
	public void setSubject(String subject){
		this.subject = subject;
	}
	public String getSubject() {
		return this.subject;
	}	
	
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return this.content;
	}
	
	public void setHost(String host){
		this.host = host;
	}
	public String getHost() {
		return this.host;
	}
	
	public void setPort(String port){
		this.port = port;
	}
	public String getPort() {
		return this.port;
	}
	
	public void setProtocol(String protocol){
		this.protocol = protocol;
	}
	public String getProtocol() {
		return this.protocol;
	}
	
	public void setReceiver(String[] receiver){
		this.receiver = receiver;
	}
	public String[] getReceiver() {
		return this.receiver;
	}
	
	public void setSender(String sender){
		this.sender = sender;
	}
	public String getSender(){
		return this.sender;
	}
	
	public void setSenderPass(String senderPass){
		this.senderPass = senderPass;
	}
	public String getSenderPass(){
		return this.senderPass;
	}
}
