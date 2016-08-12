package cn.wangsy.fast4j.web.controller;

import javax.annotation.Resource;

import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wangsy.fast4j.web.model.entity.gen.User;
import cn.wangsy.fast4j.web.service.UserService;

/** 
 * @author wangsy
 * @date 创建时间：2016年7月24日 下午6:40:40
 * @version 1.0
 */
@Controller
@RequestMapping("/app")
public class AppController {

	@Resource
	private UserService userService;
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/user")
	@ResponseBody
	public Object user(){
		return userService.selectList();
	}
	
	@RequestMapping("/user/add")
	@ResponseBody
	public Object add(User user){
		return userService.save(user);
	}
	
	@RequestMapping("/chinese")
	@ResponseBody
	public String chinese(){
		return "快速开发平台";
	}

}
