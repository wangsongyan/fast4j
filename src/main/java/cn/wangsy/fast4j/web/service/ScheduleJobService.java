package cn.wangsy.fast4j.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import cn.wangsy.fast4j.util.AppUtil;
import cn.wangsy.fast4j.web.model.dao.gen.JobMapper;
import cn.wangsy.fast4j.web.model.dao.gen.ScheduleJobMapper;
import cn.wangsy.fast4j.web.model.entity.ScheduleJobAO;
import cn.wangsy.fast4j.web.model.entity.gen.Job;
import cn.wangsy.fast4j.web.model.entity.gen.ScheduleJob;
import cn.wangsy.fast4j.web.model.entity.gen.ScheduleJobExample;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年8月3日 上午11:42:30
 */
@Service
public class ScheduleJobService {

	@Resource
	private ScheduleJobMapper scheduleJobMapper;
	@Resource
	private JobMapper jobMapper;
	
	public void save(ScheduleJob scheduleJob){
		if(StringUtils.isBlank(scheduleJob.getId())){
			scheduleJob.setId(AppUtil.getUUID());
			scheduleJobMapper.insertSelective(scheduleJob);
		}else{
			scheduleJobMapper.updateByPrimaryKeySelective(scheduleJob);
		}
	}
	
	public void delete(String id){
		scheduleJobMapper.deleteByPrimaryKey(id);
	}
	
	public List<ScheduleJobAO> selectList(){
		ScheduleJobExample example = new ScheduleJobExample();
		List<ScheduleJob> jobList = scheduleJobMapper.selectByExample(example);
		List<ScheduleJobAO> result = new ArrayList<ScheduleJobAO>();
		for(ScheduleJob job:jobList){
			Job baseJob = jobMapper.selectByPrimaryKey(job.getClassId());
			if(baseJob != null){
				ScheduleJobAO scheduleJobAO = new ScheduleJobAO(job);
				scheduleJobAO.setClassName(baseJob.getCalssName());
				result.add(scheduleJobAO);
			}
		}
		return result;
	}
	
}
