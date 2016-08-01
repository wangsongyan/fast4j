package cn.wangsy.fast4j.web.quartz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.wangsy.fast4j.web.model.entity.ScheduleJob;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年8月1日 上午11:08:30
 */
public class DataWorkContext {

	/** 计划任务map */
	private static Map<String, ScheduleJob> jobMap = new HashMap<String, ScheduleJob>();
	static {
		for (int i = 0; i < 5; i++) {
			ScheduleJob job = new ScheduleJob();
			job.setJobId("10001" + i);
			job.setJobName("data_import" + i);
			job.setJobGroup("dataWork");
			job.setJobStatus("1");
			job.setCronExpression("0/5 * * * * ?");
			job.setDesc("数据导入任务");
			addJob(job);
		}
	}
	/**
	 * 添加任务
	 * @param scheduleJob
	 */
	public static void addJob(ScheduleJob scheduleJob) {
		jobMap.put(scheduleJob.getJobGroup() + "_" + scheduleJob.getJobName(), scheduleJob);
	}
	
	public static List<ScheduleJob> getAllJob() {
		List<ScheduleJob> allJobs = new ArrayList<ScheduleJob>();
		for(Map.Entry<String, ScheduleJob> entry:jobMap.entrySet()){
			allJobs.add(entry.getValue());
		}
		return allJobs;
	}
	
}
