package com.gmail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Gmail_Mail2 {
	public static void send(String title, String content, String toEmail) {
		Properties p = new Properties();
		
		// 보낼 계정 설정
		p.put("mail.smtp.user", "kyw05171@gmail.com");
		// 호스트 설정
		p.put("mail.smtp.host", "smtp.gmail.com");
		// 구글 메일 포트번호 설정
		p.put("mila.smtp.port", "456");
		// 
		p.put("mail.smtp.starttls.enable", "true");
		// 인증할지 여부 설정
		p.put("mail.smtp.auth", "true");
		
		// 디버그 사용여부 설정
		p.put("mail.smtp.debug", "true");
		// SSL 포트번호 설정
		p.put("mail.smtp.socketFactory.port", "456");
		// SSL 클래스 설정
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		// SSL 클래스가 사용안될 때, 대체방법 사용여부 설정 (보통 사용안함)
		p.put("mail.smtp.socketFactory.fallback", "false");
		
		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(p, auth);
			session.setDebug(true);
			
			MimeMessage msg = new MimeMessage(session);
			String message = content;
			msg.setSubject(title);
			
			Address fromAddr = new InternetAddress("kyw05171@gmail.com");
			msg.setFrom(fromAddr);
			
			Address toAddr = new InternetAddress(toEmail);
			msg.addRecipient(Message.RecipientType.TO, toAddr);
			msg.setContent(message, "text/plain;charset=KSC5601");
			
			Transport.send(msg);
			
		} catch(MessagingException e) {
			e.printStackTrace();
		}
	}
	
	
	private static class SMTPAuthenticator extends Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("kyw05171", "ljbflneolwzbvdkj");
		}
	}

	
	public static void main(String[] args) {
		send("제목333", "내용333", "nice_10bird@naver.com");
		System.out.println("성공");
	}
}


