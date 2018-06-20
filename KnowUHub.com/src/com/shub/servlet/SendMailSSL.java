package com.shub.servlet;

import java.util.Properties;


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMailSSL 
{ 
    public static void send(String to, String sub, 
                         String msg, final String id,final String pwd)
    { 
       
     Properties props = new Properties();
     
     props.put("mail.smtp.host", "smtp.gmail.com");
     
     props.put("mail.smtp.port", "587");		
     props.put("mail.smtp.auth", "true");
     props.put("mail.smtp.starttls.enable", "true");
     
    Session session = Session.getInstance(props,new javax.mail.Authenticator()
    {
  	  protected PasswordAuthentication getPasswordAuthentication() 
  	  {
  	 	 return new PasswordAuthentication(id,pwd);
  	  }
   });
    try
   {
 
 	
    MimeMessage message = new MimeMessage(session);
       message.setFrom(new InternetAddress(id));
       message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
       message.setSubject(sub);
       message.setText(msg);
       
       Transport.send(message);
 
 
    }
    catch(Exception e)
    {
    	 e.printStackTrace();
    }
  }  
}