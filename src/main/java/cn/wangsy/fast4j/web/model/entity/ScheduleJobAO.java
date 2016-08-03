package cn.wangsy.fast4j.web.model.entity;

import cn.wangsy.fast4j.web.model.entity.gen.ScheduleJob;

public class ScheduleJobAO extends ScheduleJob{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ScheduleJobAO(){
	
	}
	
	public ScheduleJobAO(ScheduleJob scheduleJob){
		this.setId(scheduleJob.getId());
		this.setJobName(scheduleJob.getJobName());
		this.setJobGroup(scheduleJob.getJobGroup());
		this.setJobStatus(scheduleJob.getJobStatus());
		this.setCronExpression(scheduleJob.getCronExpression());
		this.setJobDesc(scheduleJob.getJobDesc());
		this.setClassId(scheduleJob.getClassId());
	}
	
	private String className;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
}