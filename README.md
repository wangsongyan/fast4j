# fast4j
SSM快速开发框架

## 技术路线
- 使用Spring+SpringMVC+Mybatis框架
- 使用Apache Shiro权限框架
- 验证码服务，Patchpa/Jcaptcha
- Freemarker模板引擎
- SpringTask/Quartz实现定时任务
- JavaMail邮箱服务

## 设计思想
- 使用Shiro实现操作权限+数据权限的控制
- 日志系统设计
- 可以自定义定时任务

## 使用说明
1. 使用自定义注解防止Form表单重复提交
  1. 在需要注入Token的方法上添加注解@Token  
  2. 在需要验证表单是否重复提交的方法添加@TokenValid注解  
  3. 实例代码
```java
@Token  
@RequestMapping("/index")  
public String page(HttpServletRequest request){  
	return "/index";  
}  
```
```java
@TokenValid  
@RequestMapping("/submit")  
@ResponseBody  
public Object submit(HttpServletRequest request){  
	return "提交成功！";  
}
```
