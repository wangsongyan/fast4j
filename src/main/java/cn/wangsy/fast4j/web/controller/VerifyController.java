/**
 * 
 */
package cn.wangsy.fast4j.web.controller;

import org.springframework.stereotype.Controller;

import cn.wangsy.fast4j.core.controller.VerifyCodeController;

/**
 * @author wangsy
 * @date 2017年4月14日下午2:40:38
 */
@Controller
public class VerifyController extends VerifyCodeController{

	public static final String VERIFYCODE_KEY = "verifycode_key";
	
	@Override
	protected String getVerifyCodeKey() {
		return VERIFYCODE_KEY;
	}

}
