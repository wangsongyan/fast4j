package cn.wangsy.fast4j.web.log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.binding.MapperProxy;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import cn.wangsy.fast4j.util.AopTargetUtils;
import cn.wangsy.fast4j.util.AppUtil;
import cn.wangsy.fast4j.util.ReflectionUtils;
import cn.wangsy.fast4j.web.model.dao.gen.LogMapper;
import cn.wangsy.fast4j.web.model.entity.gen.Log;

import com.alibaba.fastjson.JSON;

/**
 * 说明：
 * 
 * @author wangsy
 * @date 创建时间：2016年7月25日 下午2:44:39
 */
//@Aspect
//@Component
public class DatalogAspect {
	//private static final Logger logger = Logger.getLogger(DatalogAspect.class);
	@Resource
	private LogMapper logMapper;
	@Resource
	private SqlSessionFactoryBean sqlSessionFactoryBean;

	@Pointcut("execution(public * cn.wangsy.fast4j.web.model.dao.gen.*.insert*(..)) && !execution(public * cn.wangsy.fast4j.web.model.dao.gen.LogMapper.insert*(..))")
	public void insert() {
		
	}

	@Pointcut("execution(public * cn.wangsy.fast4j.web.model.dao.gen.*.update*(..))")
	public void update() {
		
	}

	@Pointcut("execution(public * cn.wangsy.fast4j.web.model.dao.gen.*.delete*(..))")
	public void delete() {
		
	}

	@Around("insert()")
	public Object addOperateLog(ProceedingJoinPoint jp) throws Throwable {
		Object result = jp.proceed();
		addLog(jp.getSignature().getName(), jp.getArgs(), null);
		return result;
	}

	@Around("update()")
	public Object updateLog(ProceedingJoinPoint jp) throws Throwable {
		//System.out.println("数据更新");
		Object proxy = jp.getThis();
		Object[] objParam = jp.getArgs();

		if (AopUtils.isAopProxy(proxy)) {// 只有代理对象才需要处理
			try {
				Class<?> proxyClass = proxy.getClass();
				String methodName = jp.getSignature().getName();
				if (methodName.contains("updateByExample")) {
					
					Method m = BeanUtils.findDeclaredMethod(proxyClass,"selectByExample", new Class[] { objParam[1].getClass() });
					Object srcData = m.invoke(proxy, objParam[1]);
					//System.out.println(JSON.toJSON(srcData));

					addLog(methodName, srcData,objParam);

				} else if (methodName.contains("updateByPrimaryKey")) {

					Object targetObject = AopTargetUtils.getTarget(proxy);
					Field h = targetObject.getClass().getSuperclass().getDeclaredField("h");
					h.setAccessible(true);
					MapperProxy aopProxy = (MapperProxy) h.get(targetObject);

					Object object = ReflectionUtils.getFieldValue(aopProxy,"mapperInterface");
					object = ReflectionUtils.getFieldValue(object, "name");
					System.out.println(object.toString());

					SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
					ResultMap map = sqlSessionFactory.getConfiguration().getResultMap(object.toString() + ".BaseResultMap");
					List<ResultMapping> mapping = map.getIdResultMappings();
					if (!CollectionUtils.isEmpty(mapping) && mapping.size() == 1) {
						ResultMapping mp = mapping.get(0);
						String property = mp.getProperty();
						String name = "get"+ property.substring(0, 1).toUpperCase()+ property.substring(1);
						Method method = BeanUtils.findDeclaredMethod(objParam[0].getClass(), name, new Class[] {});
						Object primaryKey = method.invoke(objParam[0]);

						method = BeanUtils.findDeclaredMethod(proxyClass, "selectByPrimaryKey",new Class[] { primaryKey.getClass() });
						Object sourceData = method.invoke(proxy, primaryKey);

						if(null != sourceData){
							addLog(methodName, sourceData, objParam);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();// 记录好异常进行处理
			}
		}
		Object result = jp.proceed();
		return result;
	}

	@Around("delete()")
	public Object deleteLog(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("数据删除");

		Object proxy = jp.getThis();
		Object[] objParam = jp.getArgs();

		if (AopUtils.isAopProxy(proxy)) {// 只有代理对象才需要处理
			try {
				Class<?> proxyClass = proxy.getClass();
				String methodName = jp.getSignature().getName();
				if (methodName.contains("deleteByExample")) {

					Method m = BeanUtils.findDeclaredMethod(proxyClass,"selectByExample", new Class[] { objParam[1].getClass() });
					Object srcData = m.invoke(proxy, objParam[1]);
					//System.out.println(JSON.toJSON(srcData));

					addLog(methodName,srcData,objParam);

				} else if (methodName.contains("deleteByPrimaryKey")) {

					Object targetObject = AopTargetUtils.getTarget(proxy);
					Field h = targetObject.getClass().getSuperclass().getDeclaredField("h");
					h.setAccessible(true);
					MapperProxy aopProxy = (MapperProxy) h.get(targetObject);

					Object object = ReflectionUtils.getFieldValue(aopProxy,"mapperInterface");
					object = ReflectionUtils.getFieldValue(object, "name");
					System.out.println(object.toString());

					SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
					ResultMap map = sqlSessionFactory.getConfiguration().getResultMap(object.toString() + ".BaseResultMap");
					List<ResultMapping> mapping = map.getIdResultMappings();
					if (!CollectionUtils.isEmpty(mapping) && mapping.size() == 1) {
						ResultMapping mp = mapping.get(0);
						String property = mp.getProperty();
						//String name = "get"+ property.substring(0, 1).toUpperCase()+ property.substring(1);
						//Method method = BeanUtils.findDeclaredMethod(objParam[0].getClass(), name, new Class[] {});
						//Object primaryKey = method.invoke(objParam[0]);

						Method method = BeanUtils.findDeclaredMethod(proxyClass, "selectByPrimaryKey",new Class[] { objParam[0].getClass() });
						Object sourceData = method.invoke(proxy, objParam[0]);
						
						if(null != sourceData){
							addLog(methodName, sourceData, objParam);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();// 记录好异常进行处理
			}
		}
		
		Object result = jp.proceed();
		return result;
	}

	private void addLog(String operateType, Object srcData, Object destData) {
		Log log = new Log();
		log.setId(AppUtil.getUUID());
		log.setCreateDate(new Date());
		log.setSrcData(JSON.toJSONString(srcData));
		log.setDestData(JSON.toJSONString(destData));
		log.setOperationType(operateType);
		logMapper.insertSelective(log);
	}

}