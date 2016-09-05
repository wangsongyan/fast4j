package cn.wangsy.fast4j.web.service;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Enumeration;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;

import com.baomidou.kisso.common.IpHelper;

import cn.wangsy.fast4j.core.annotation.Operation;
import cn.wangsy.fast4j.core.aop.LogPoint;
import cn.wangsy.fast4j.util.AppUtil;
import cn.wangsy.fast4j.util.HttpHelper;
import cn.wangsy.fast4j.web.model.dao.gen.LogMapper;
import cn.wangsy.fast4j.web.model.entity.gen.Log;

/**
 * 说明：
 * 
 * @author wangsy
 * @date 创建时间：2016年8月5日 上午10:23:50
 */
public class OperationLogSaveImpl implements LogPoint {

	private static final String LOG_CONTENT = "[类名]:%s,[方法]:%s,[参数]:%s,[IP]:%s";

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
		log.setContent(operateContent(joinPoint, method.getName(), HttpHelper.getHttpServletRequest()));
		log.setCreateDate(new Date());

		logMapper.insertSelective(log);

	}

	/**
	 * 获取当前执行的方法
	 * 
	 * @param joinPoint
	 *            连接点
	 * @param methodName
	 *            方法名称
	 * @return 操作内容
	 */
	public String operateContent(ProceedingJoinPoint joinPoint,
			String methodName, HttpServletRequest request) {
		String className = joinPoint.getTarget().getClass().getName();
		Object[] params = joinPoint.getArgs();
		StringBuffer bf = new StringBuffer();
		if (params != null && params.length > 0) {
			Enumeration<String> paraNames = request.getParameterNames();
			while (paraNames.hasMoreElements()) {
				String key = paraNames.nextElement();
				bf.append(key).append("=");
				bf.append(request.getParameter(key)).append("&");
			}
			if (StringUtils.isBlank(bf.toString())) {
				bf.append(request.getQueryString());
			}
		}
		return String.format(LOG_CONTENT, className, methodName, bf.toString(),
				IpHelper.getIpAddr(request));
	}

}
