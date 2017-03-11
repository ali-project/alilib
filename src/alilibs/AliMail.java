package alilibs;



import java.util.Properties;
import java.io.UnsupportedEncodingException;
import javax.mail.*;
import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;


public class AliMail {

	private static final String defaultSMTPHost = "smtp.163.com";
	private static final String defaultMailFromName = "xienaizhong@163.com";
	private static final String defaultMailFromPassword = "XnZ413121";

	public static int send(String mailTos, String mailSubject, String url)
			throws Exception {
		// check params
		if (mailTos == null || mailSubject == null || url == null)
			return 0;

		// encoding params
		String encoding = "iso-8859-1";
		try {
			// 标题不需要编码,编码后为乱码
			// 正文需要编码
			url = new String(url.getBytes(), encoding);
		} catch (UnsupportedEncodingException e) {
		}

		Properties props = new Properties();
		props.put("mail.smtp.host", defaultSMTPHost);// 邮件服务器地址
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.user", "CTOPAY");// 发送方的发送名;
		props.put("mail.smtp.from", defaultMailFromName);// 发送邮箱地址;
		props.put("mail.debug", "false");// 不打印构建发送者信息

		// 构建发送者
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(defaultMailFromName,
						defaultMailFromPassword);
			}
		};

		Session session = Session.getInstance(props, auth);
		session.setDebug(true);// 不打印发送信息

		Message msg = new MimeMessage(session);
		int sendNum = 0;// 发送的数量

		//Multipart mm = new MimeMultipart();
		//BodyPart mdp = new MimeBodyPart();
		//FileDataSource fds = new FileDataSource(url);
		//DataHandler dh = new DataHandler(fds);

		//String[] strs = url.split("/");
		// System.out.println(strs.length);

		//mdp.setFileName(strs[strs.length - 1]);// 可以和原文件名不一致
		//mdp.setDataHandler(dh);

		//mm.addBodyPart(mdp);

		// msg.setContent(mm);
		msg.saveChanges();

		for (String mailTo : mailTos.split(",")) {
			try {
				InternetAddress[] addresses = { new InternetAddress(mailTo) };
				msg.setRecipients(Message.RecipientType.TO, addresses);// 设置邮件接收地址集
				msg.setSentDate(new java.util.Date());// 设置邮件发送日期
				msg.setSubject(mailSubject);// 设置邮件的标题
				msg.setText(url);// 设置邮件的内容(文本)
                                
				// msg.setContent(mailText, "text/html");// 设置邮件的内容
				//msg.setContent(mm);
				Transport.send(msg);// 发送邮件

				sendNum++;// 发送记数
			} catch (MessagingException e) {
			}
		}
		
		return sendNum;
	}
	
	
	
	
}
