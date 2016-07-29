package cn.wangsy.fast4j.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wangsy.fast4j.web.model.entity.gen.User;
import cn.wangsy.fast4j.web.service.impl.AuthService;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年7月29日 下午3:01:38
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

	@Resource
	private AuthService authService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public Object doLogin(User user){
		return authService.loginValidate(user);
	}
	
}
