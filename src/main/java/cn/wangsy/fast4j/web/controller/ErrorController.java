package cn.wangsy.fast4j.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * @author wangsy
 * @date 创建时间：2016年7月31日 下午7:46:23
 * @version 1.0
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

	@RequestMapping("/403")
	public String permissionDenied(){
		return "/common/403";
	}
	
	@RequestMapping("/500")
	public String internalError(){
		return "/common/500";
	}
	
}
