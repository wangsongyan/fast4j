package cn.wangsy.fast4j.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.SchedulerException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.wangsy.fast4j.util.AppUtil;
import cn.wangsy.fast4j.web.model.dao.gen.JobMapper;
import cn.wangsy.fast4j.web.model.entity.gen.Job;
import cn.wangsy.fast4j.web.model.entity.gen.ScheduleJob;
import cn.wangsy.fast4j.web.quartz.QuartzTest;
import cn.wangsy.fast4j.web.service.JobService;
import cn.wangsy.fast4j.web.service.ScheduleJobService;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年8月3日 上午11:46:26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:*.xml")
public class ScheduleJobTest {

	@Resource
	private ScheduleJobService scheduleJobService;
	@Resource
	private QuartzTest quartzTest;
	@Resource
	private JobService jobService;
	
	@Test
	public void test(){
		
		//Applicationcontext
		ScheduleJob scheduleJob = new ScheduleJob();
		scheduleJob.setJobName("测试任务");
		scheduleJob.setJobGroup("测试分组");
		scheduleJob.setJobStatus("1");
		scheduleJob.setCronExpression("* 0/1 * * * ?");
		scheduleJob.setJobDesc("仅仅用于测试");
		scheduleJob.setClassId("6b0d4360620a48c49a31760032916371");
		
		scheduleJobService.save(scheduleJob);
		
	}
	
	@Test
	public void jobTest(){
		Job job = new Job();
//		job.setCalssName("cn.wangsy.fast4j.web.quartz.FileScanJob");
//		jobService.save(job);
		
		//job = new Job();
		job.setCalssName("cn.wangsy.fast4j.web.quartz.QuartzJobFactory");
		jobService.save(job);
	}
	
}
