package cn.wangsy.fast4j.web.controller;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wangsy.fast4j.web.model.entity.gen.User;
import cn.wangsy.fast4j.web.service.AuthService;

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
	public String login(){
		return "/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(User user){
		//return authService.loginValidate(user);
		//使用权限工具进行用户登录，登录成功后跳到shiro配置的successUrl中，与下面的return没什么关系！  
        SecurityUtils.getSubject().login(new UsernamePasswordToken(user.getUserName(), DigestUtils.md5Hex(user.getPassword())));  
        return "redirect:/user";
	}
	
}
