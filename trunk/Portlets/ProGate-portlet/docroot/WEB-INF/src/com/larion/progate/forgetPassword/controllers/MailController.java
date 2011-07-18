package com.larion.progate.forgetPassword.controllers;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.MessagingException;

public class MailController{
	
	private String subject = "ProGate contact mail";
	private String content;		
	
	private String host = "mail.elarion.com";
	private String protocol = "smtp";
	private String port = "25";
	private String sender = "no-reply@elarion.com";
	private String senderPass = "1qazxsw2";
	private String[] receiver = {"tongocphuongthuy@yahoo.com.vn"};
	
	/*	
	public void SendMail() throws Exception{

		//try {						
			System.out.println("mail controller");
		    boolean sessionDebug = false;

		    Properties props = System.getProperties();
		    props.put("mail.smtp.host", this.host);
		    props.put("mail.transport.protocol", this.protocol);
		    props.put("mail.smtp.starttls.enable","true");  
		    props.put("mail.smtp.port", this.port);
		    props.put("mail.smtp.auth", "true");
		    
		    final String senderTemp = this.sender;
		    final String senderPassTemp = this.senderPass;
		    Session mailSession = Session.getInstance(props,new Authenticator(){
		    	@Override
				public PasswordAuthentication getPasswordAuthentication() {
		            String username = senderTemp;
		            String password = senderPassTemp;
		            return new PasswordAuthentication(username, password);
		         }
		    });
		    

		    mailSession.setDebug(sessionDebug);

		    Message msg = new MimeMessage(mailSession);

		    msg.setFrom(new InternetAddress(this.sender));
		    
		    InternetAddress[] address = new InternetAddress[this.receiver.length];
		    
		    for (int i = 0; i < this.receiver.length; i++){
		    	address[i]  = new InternetAddress(this.receiver[i]);
		    }
		  
		    msg.setRecipients(Message.RecipientType.TO, address);
		    msg.setSubject(this.subject);
		    msg.setSentDate(new Date());
		    
		    String str = new String(this.content);
		    byte[] latin1 = str.getBytes("UTF-8");
		    byte[] utf8 = new String(latin1, "ISO-8859-1").getBytes("UTF-8");
		    this.content = new String(utf8, "UTF-8");
		    
		    msg.setContent(this.content,"text/html;");

		    Transport.send(msg);		    
		  
		/*}catch (SendFailedException e1) {
			System.out.println("Send  error message: " + e1.getMessage());
		}
		catch (MessagingException e) {
			System.out.println("Send mail error message: " + e.getMessage());
		}
		catch (java.io.UnsupportedEncodingException e) {
			System.out.println("Send mail error message: " + e.getMessage());
		}}*/
	

	public void postMail() throws MessagingException
	{	
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
				return new PasswordAuthentication(sender, senderPass);	
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
	    
	    Transport t = sessions.getTransport(protocol);
	    try {
	        t.connect(this.sender, this.senderPass);
	        t.sendMessage(msg, msg.getAllRecipients());
	    } finally {
	        t.close();
	    }
	    
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