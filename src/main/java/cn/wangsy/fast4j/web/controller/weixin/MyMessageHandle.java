package cn.wangsy.fast4j.web.controller.weixin;

import com.github.sd4324530.fastweixin.handle.MessageHandle;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.req.BaseReqMsg;


/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年8月28日 下午9:16:09
 */
public class MyMessageHandle implements MessageHandle<BaseReqMsg>{

	@Override
	public BaseMsg handle(BaseReqMsg message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean beforeHandle(BaseReqMsg message) {
		// TODO Auto-generated method stub
		return false;
	}

}
