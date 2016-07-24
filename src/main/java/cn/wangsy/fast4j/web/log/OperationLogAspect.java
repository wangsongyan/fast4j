package cn.wangsy.fast4j.web.log;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.binding.MapperMethod.MethodSignature;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

/** 
 * @author wangsy
 * @date 创建时间：2016年7月24日 下午10:11:40
 * @version 1.0
 */
@Aspect
public class OperationLogAspect  {
     
    //@Autowired
    //private OperationlogManager operationlogManager;
       
    @Autowired
    private HttpServletRequest request;
     
    private static final Logger logger = Logger.getLogger(OperationLogAspect.class);
     
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
    @Pointcut("@annotation(com.billstudy.springaop.log.annotation.Operation)")
    public void anyMethod() {}
 
    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint jp)throws Throwable{
        System.err.println("doBasicProfiling..."); 
         
        // 获取签名
        MethodSignature signature = (MethodSignature) jp.getSignature();
         
        Method method = signature.getMethod();
        // 记录日志
        Operation annotation = method.getAnnotation(Operation.class);
        // 解析参数
        Object[] objParam = jp.getArgs();
        String[] arguDesc = annotation.arguDesc();
        Object result = null;
        if(objParam.length == arguDesc.length){
             
            // 抽取出方法描述：
            String paramDesc = extractParam(objParam,arguDesc);
             
            System.out.println(paramDesc); 
//            // 记录时间
//            Operationlog log = new Operationlog(); 
//            Date sDate = Calendar.getInstance().getTime();
//             
//            String requestStartDesc = 执行开始时间为：+SIMPLE_DATE_FORMAT.format(sDate)+;
//            logger.info(requestStartDesc); 
//            System.out.println(進入方法前);
//            result = jp.proceed(); 
//            System.out.println(進入方法后);
//            Date eDate = Calendar.getInstance().getTime();
//            long time = eDate.getTime()-sDate.getTime();
//            String requestEndDesc = 执行完成时间为：+SIMPLE_DATE_FORMAT.format(eDate)+,本次用时：+time+毫秒！;
//            logger.info(执行完成时间为：+SIMPLE_DATE_FORMAT.format(eDate)+,本次用时：+time+毫秒！);
//             
//            log.setLogCreateTime(sDate);
//            log.setLogDesc(annotation.desc()+ 用时/+requestStartDesc + , + requestEndDesc); 
//            log.setLogResult(result+);
//            log.setLogType(annotation.type()+);
//            log.setLogParam(paramDesc);
//             
//            operationlogManager.save(log); 
//            logger.info(log.toJsonString());
        }else{
//            result = jp.proceed();
//            String methodName = signature.getName();
//            String className = jp.getThis().getClass().getName();
//            className = className.substring(0, className.indexOf($$));  // 截取掉cglib代理类标志
//            String errorMsg = 警告：+methodName+ 方法记录日志失败，注解[arguDesc]参数长度与方法实际长度不一致，需要参数+objParam.length+个，实际为+arguDesc.length+个，请检查+className+:+methodName+注解！;
//            logger.warn(errorMsg);
//            System.err.println(errorMsg);
        }
        return result;
    }
     
     
    /**
     * 根据注解参数以及方法实参拼接出方法描述
     * @param objParam
     * @param arguDesc
     * @return
     */
    private String extractParam(Object[] objParam, String[] arguDesc) {
        StringBuilder paramSb = new StringBuilder();
        int size = objParam.length-1;
        for (int i = 0; i < arguDesc.length; i++) {
            paramSb.append(arguDesc[i]+":"+objParam[i]+(i==size?"":","));
        }
        return paramSb.toString();
    }
 
     
}
