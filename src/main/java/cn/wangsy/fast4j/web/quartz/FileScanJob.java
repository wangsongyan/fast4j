package cn.wangsy.fast4j.web.quartz;

import java.io.File;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import cn.wangsy.fast4j.web.model.entity.gen.ScheduleJob;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年8月1日 上午11:50:12
 */
public class FileScanJob implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		
		ScheduleJob scheduleJob = (ScheduleJob)context.getMergedJobDataMap().get("scheduleJob");
		System.out.println(scheduleJob.getJobName());
		
		//File root = new File("D:/dx-workspace/workshop");
		//scan(root);
		
	}

	public void scan(File file){
		if(file.isFile()){
			System.out.println(file.getName());
		}else{
			for(File f:file.listFiles()){
				scan(f);
			}
			System.err.println(file.getName());
		}
	}
	
}
