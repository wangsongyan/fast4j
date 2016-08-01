package cn.wangsy.fast4j.web.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


/** 
 * 说明：邮件发送服务类
 * @author wangsy
 * @date 创建时间：2016年8月1日 上午9:29:30
 */
@Service
public class MailService {

	private static final Logger logger = Logger.getLogger(MailService.class);
	
	@Resource
	private JavaMailSenderImpl sender;
	@Resource
	private SimpleMailMessage mailMessage;
	@Value("${mail.from}")
	private String mailFrom;
	
	/***
	 * 给单人发送邮件
	 * @param subject 主题
	 * @param text 内容
	 * @param to 接收人邮箱
	 */
	public void sendPlainText(String subject,String text,String to){
		sendPlainText(subject, text, new String[] {to});
	}
	
	/***
	 * 给多人发送邮件
	 * @param subject 主题
	 * @param text 内容
	 * @param to 接收人邮箱列表
	 */
	public void sendPlainText(String subject,String text,String[] to){
		mailMessage.setSubject(subject);
		mailMessage.setText(text);
		mailMessage.setTo(to);
		sender.send(mailMessage);
	}
	
	public void sendHtml(String subject,String text,String to,List<File> attachments) throws MessagingException{
		sendHtml(subject, text, new String[] {to}, attachments, true);
	}
	
	public void sendHtml(String subject,String text,String[] to,List<File> attachments) throws MessagingException{
		sendHtml(subject, text, to, attachments, true);
	}
	
	/**
	 *  发送邮件通用方法
	 * @param subject 主题
	 * @param text 内容
	 * @param to 接收人列表
	 * @param attachments 附件列表
	 * @param isHtml 内容是否是html
	 * @throws MessagingException
	 */
	private void sendHtml(String subject,String text,String[] to,List<File> attachments, boolean isHtml) throws MessagingException{
		MimeMessage mailMessage = sender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,true);
		messageHelper.setFrom(mailFrom);
		messageHelper.setTo(to);
		messageHelper.setSubject(subject);
		// true 表示启动HTML格式的邮件
		messageHelper.setText(text, true);
		
		if(!CollectionUtils.isEmpty(attachments)){
			for(File attachment:attachments){
				if(attachment.exists()){
					messageHelper.addAttachment(attachment.getName(), attachment);
				}
			}
		}
		sender.send(mailMessage);
		logger.debug("邮件发送成功...");
	}
	
}
