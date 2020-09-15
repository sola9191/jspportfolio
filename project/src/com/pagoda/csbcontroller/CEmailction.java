package com.pagoda.csbcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CEmailction implements CAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =  response.getWriter();
		//String subject=request.getParameter("subject");
		//String content=request.getParameter("content");
		String email =request.getParameter("email"); //답변받을이메일
		String to="sola91@naver.com";
		/////////////////////////////////////////////////////////////////여기까지는 받아올거!!
		String host="smtp.naver.com";
		final String user="sola91@naver.com"; //보내는쪽의 메일설정
	    final String password="!Tkrhk1357910";
	    Properties props = new Properties();
	    props.put("mail.smtp.host",host);
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.post", "587");
	    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	    	protected PasswordAuthentication getPasswordAuthentication(){
	    		return new PasswordAuthentication(user,password);
	    	}
	    });

	    try {
	        MimeMessage msg = new MimeMessage(session);
	        msg.setFrom(new InternetAddress(user));
	        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to) );
	        // msg.setRecipients(Message.RecipientType.TO,"sola91@naver.com"); 보내는사람 추가할때 
	        msg.setSubject(request.getParameter("subject"));
	        msg.setContent(email+request.getParameter("content"), "text/html; charset=euc-kr");
	        Transport.send(msg);
	        //다 처리되면
	        out.println("<script> alert('메일전송이 완료되었습니다.'); </script>");
			out.println("<script> location.href='"+request.getContextPath()+"/email_view.service'; </script>");
	        
	    } catch (MessagingException mex) {
	    	out.println("<script> alert('메일전송이 실패하였습니다.'); </script>");
	        System.out.println("send failed, exception: " + mex);
	    }
	    
	}
}