package cn.wangsy.fast4j.web.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wangsy.fast4j.web.model.dao.gen.ProjectMapper;
import cn.wangsy.fast4j.web.model.entity.gen.Project;
import cn.wangsy.fast4j.web.model.entity.gen.ProjectExample;

/** 
 * @author wangsy
 * @date 创建时间：2016年7月24日 下午6:43:28
 * @version 1.0
 */
@Service
public class ProjectService {

	@Resource
	private ProjectMapper projectMapper;
	
	public List<Project> list(){
		ProjectExample example = new ProjectExample();
		return projectMapper.selectByExample(example);
	}
	
}
