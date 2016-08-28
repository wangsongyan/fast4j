package cn.wangsy.fast4j.web.controller.weixin;

import com.github.sd4324530.fastweixin.handle.EventHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.req.BaseEvent;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年8月28日 下午9:17:49
 */
public class MyEventHandle implements EventHandle<BaseEvent> {

	@Override
	public BaseMsg handle(BaseEvent event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean beforeHandle(BaseEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

}
