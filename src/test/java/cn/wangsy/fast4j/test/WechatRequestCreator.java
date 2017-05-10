/**
 * 
 */
package cn.wangsy.fast4j.test;

import java.util.Date;

import org.apache.http.client.methods.HttpPost;
import org.junit.Test;

import cn.wangsy.fast4j.core.wechat.MessageUtil;
import cn.wangsy.fast4j.core.wechat.MsgType;
import cn.wangsy.fast4j.core.wechat.message.BaseMessage;
import cn.wangsy.fast4j.core.wechat.message.TextMessage;
import cn.wangsy.fast4j.util.AppUtil;

/**
 * 微信转发请求模拟器
 * @author wangsy
 * @date 2017年5月10日上午10:45:38
 */
public class WechatRequestCreator {

	@Test
	public void sendTextMessage(){
		
		TextMessage textMessage = new TextMessage();
		textMessage.setContent("content");
		textMessage.setMsgType(MsgType.TEXT.value());
		
		sendRequest(textMessage);
		
		
	}

	
	
	private void setCommonField(BaseMessage message){
		message.setFromUserName("wangsy");
		message.setToUserName("syj");
		message.setMsgId(AppUtil.getUUID());
		message.setCreateTime(new Date().getTime());
	}
	
	private void sendRequest(BaseMessage message) {
		setCommonField(message);
		String msgtext = MessageUtil.textMessageToXml(message);
		System.out.println(msgtext);
		String result = TestGetPost.sendPost("http://localhost:8080/wechat", msgtext);
		
		System.out.println("服务器响应内容：\n"+result);
	}
	
}
