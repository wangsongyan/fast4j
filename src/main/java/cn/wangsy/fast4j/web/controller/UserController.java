package cn.wangsy.fast4j.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
 * @author wangsy
 * @date 创建时间：2016年7月31日 下午6:04:09
 * @version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("")
	public String html(){
		return "/index";
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(){
		return "添加成功！";
	}
	
	@RequestMapping("/del")
	@ResponseBody
	public String delete(){
		return "删除成功！";
	}
	
}

