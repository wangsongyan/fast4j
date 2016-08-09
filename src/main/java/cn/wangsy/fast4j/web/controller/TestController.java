package cn.wangsy.fast4j.web.controller;

import javax.annotation.Resource;

import org.quartz.SchedulerException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wangsy.fast4j.web.quartz.QuartzTest;
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
	
}
