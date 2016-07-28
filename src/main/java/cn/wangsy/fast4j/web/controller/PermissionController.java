package cn.wangsy.fast4j.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wangsy.fast4j.web.model.entity.gen.Permission;
import cn.wangsy.fast4j.web.service.PermissionService;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年7月26日 上午10:52:00
 */
@Controller
@RequestMapping("/p")
public class PermissionController {

	@Resource
	private PermissionService permissionService;
	
	@RequestMapping("/add")
	@ResponseBody
	public Object save(Permission permission){
		return permissionService.save(permission);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Object delete(String id){
		return permissionService.delete(id);
	}
	
}
