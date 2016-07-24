package cn.wangsy.fast4j.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wangsy.fast4j.web.service.ProjectService;

/** 
 * @author wangsy
 * @date 创建时间：2016年7月24日 下午6:40:40
 * @version 1.0
 */
@Controller
@RequestMapping("/app")
public class AppController {

	@Resource
	private ProjectService projectService;
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/project")
	@ResponseBody
	public Object project(){
		return projectService.list();
	}
	
	@RequestMapping("/chinese")
	@ResponseBody
	public String chinese(){
		return "快速开发平台";
	}
	
}
