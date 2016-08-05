package cn.wangsy.fast4j.web.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import cn.wangsy.fast4j.core.annotation.Operation;
import cn.wangsy.fast4j.core.aop.OperationType;
import cn.wangsy.fast4j.util.AppUtil;
import cn.wangsy.fast4j.web.model.dao.gen.JobMapper;
import cn.wangsy.fast4j.web.model.entity.gen.Job;
import cn.wangsy.fast4j.web.model.entity.gen.JobExample;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年8月3日 下午12:43:12
 */
@Service
public class JobService {

	@Resource
	private JobMapper jobMapper;
	
	public void save(Job job){
		if(StringUtils.isBlank(job.getId())){
			job.setId(AppUtil.getUUID());
			jobMapper.insertSelective(job);
		}else{
			jobMapper.updateByPrimaryKeySelective(job);
		}
	}
	
	@Operation(type = OperationType.QUERY,desc = "查询任务列表")
	public List<Job> selectList(){
		JobExample example = new JobExample();
		return jobMapper.selectByExample(example);
	}
	
}
