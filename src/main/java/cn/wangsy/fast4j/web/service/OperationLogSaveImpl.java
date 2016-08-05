package cn.wangsy.fast4j.web.service;

import java.lang.reflect.Method;
import java.util.Date;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;

import cn.wangsy.fast4j.core.annotation.Operation;
import cn.wangsy.fast4j.core.aop.LogPoint;
import cn.wangsy.fast4j.util.AppUtil;
import cn.wangsy.fast4j.web.model.dao.gen.LogMapper;
import cn.wangsy.fast4j.web.model.entity.gen.Log;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年8月5日 上午10:23:50
 */
public class OperationLogSaveImpl implements LogPoint{

	@Resource
	private LogMapper logMapper;
	
	@Override
	public void save(ProceedingJoinPoint joinPoint, Method method,
			Operation operation) {
		// TODO Auto-generated method stub
		System.out.println("save");
		
		Log log = new Log();
		log.setId(AppUtil.getUUID());
		log.setOperationType(operation.type().getName());
		log.setDescription(operation.desc());
		log.setCreateDate(new Date());
		
		logMapper.insertSelective(log);
		
	}

}
