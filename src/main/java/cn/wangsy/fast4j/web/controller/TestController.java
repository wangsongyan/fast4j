package cn.wangsy.fast4j.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.quartz.SchedulerException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wangsy.fast4j.core.annotation.Token;
import cn.wangsy.fast4j.core.annotation.TokenValid;
import cn.wangsy.fast4j.util.Pager;
import cn.wangsy.fast4j.web.quartz.QuartzTest;
import cn.wangsy.fast4j.web.service.DictionaryTypeService;
import cn.wangsy.fast4j.web.service.JobService;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年8月1日 上午11:16:48
 */
@Controller
@RequestMapping("/test")
public class TestController {

	@Resource
	private QuartzTest quartzTest;
	@Resource
	private JobService jobService;
	@Resource
	private DictionaryTypeService dictionaryTypeService;
	
	@RequestMapping("/quartz")
	@ResponseBody
	public void quartz(){
		try {
			quartzTest.test();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/jobList")
	@ResponseBody
	public Object jobList(){
		return jobService.selectList();
	}
	
	@Token
	@RequestMapping("/getForm")
	public String getForm(HttpServletRequest request){
		return "/form";
	}
	
	@TokenValid
	@RequestMapping("/submitForm")
	@ResponseBody
	public Object submitForm(HttpServletRequest request, String tel, String address){
		System.out.println("tel="+tel+"&address="+address);
		return "提交成功！";
	}
	
	@RequestMapping("/listDict")
	@ResponseBody
	public Object listDict(Pager pager){
		return dictionaryTypeService.list(pager);
	}
}
