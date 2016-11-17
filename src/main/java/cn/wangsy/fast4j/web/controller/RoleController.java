/**
 * 
 */
package cn.wangsy.fast4j.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wangsy.fast4j.web.service.RoleService;

/**
 * @author wangsy
 * @date 2016年11月17日下午2:10:37
 */
@Controller
@RequestMapping("/role")
public class RoleController {

	@Resource
	private RoleService roleService;
	
	@RequestMapping("/selectList")
	@ResponseBody
	private Object selectList(){
		return roleService.selectList();
	}
	
}
