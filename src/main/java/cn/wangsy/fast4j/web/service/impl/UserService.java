package cn.wangsy.fast4j.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.wangsy.fast4j.util.AppUtil;
import cn.wangsy.fast4j.web.model.dao.gen.UserMapper;
import cn.wangsy.fast4j.web.model.entity.gen.User;
import cn.wangsy.fast4j.web.model.entity.gen.UserExample;

import com.youymi.youymiframework.service.ServiceResult;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年7月25日 下午1:10:24
 */
@Service
public class UserService {

	@Resource
	private UserMapper userMapper;
	
	@Resource
	private SqlSessionFactoryBean sqlSessionFactoryBean;
	
	public List<User> selectList(){
		UserExample example = new UserExample();
		return userMapper.selectByExample(example);
	}
	
	public ServiceResult<String> save(User user){
		ServiceResult<String> ret = new ServiceResult<String>();
		ret.setSucceed(false);
		if(null == user || StringUtils.isBlank(user.getUserName())){
			ret.setMsg("参数错误！");
			return ret;
		}
		if(StringUtils.isBlank(user.getUserName())){
			ret.setMsg("用户名不能为空！");
			return ret;
		}
		if(StringUtils.isBlank(user.getEmail())){
			ret.setMsg("邮箱不能为空！");
			return ret;
		}
		if(StringUtils.isBlank(user.getPhone())){
			ret.setMsg("手机号码不能为空！");
			return ret;
		}
		if(StringUtils.isBlank(user.getPassword())){
			ret.setMsg("密码不能为空！");
			return ret;
		}
		if(StringUtils.isBlank(user.getId())){
			
			if(isUserExist(user.getUserName())){
				ret.setMsg("用户名已存在！");
				return ret;
			}
			
			if(isEmailExist(user.getEmail())){
				ret.setMsg("邮箱已存在！");
				return ret;
			}
			
			if(isPhoneExist(user.getPhone())){
				ret.setMsg("手机号码已存在！");
				return ret;
			}
			
			user.setId(AppUtil.getUUID());
			user.setPassword(DigestUtils.md5Hex(user.getPassword()));
			user.setCreatedAt(new Date());
			userMapper.insertSelective(user);
			
			ret.setMsg("添加成功！");
			ret.setSucceed(false);
		}else{
			user.setUpdatedAt(new Date());
			userMapper.updateByPrimaryKeySelective(user);
			
			ret.setMsg("修改成功！");
			ret.setSucceed(false);
		}
		return ret;
	}
	
	/***
	 * 根据账号获取用户
	 * @param userName 用户名
	 * @return
	 */
	public User selectUserByAccount(User user){
		if(StringUtils.isBlank(user.getUserName())){
			return null;
		}
		UserExample example = new UserExample();
		example.or().andUserNameEqualTo(user.getUserName());
		example.or().andEmailEqualTo(user.getUserName());
		example.or().andPhoneEqualTo(user.getUserName());
		
		List<User> userList = userMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(userList)){
			return userList.get(0);
		}
		return null;
	}
	
	private boolean isUserExist(String userName){
		if(StringUtils.isBlank(userName)){
			return true;
		}
		UserExample example = new UserExample();
		example.createCriteria().andUserNameEqualTo(userName);
		return userMapper.countByExample(example)>0;
	}
	
	private boolean isEmailExist(String email){
		if(StringUtils.isBlank(email)){
			return true;
		}
		UserExample example = new UserExample();
		example.createCriteria().andEmailEqualTo(email);
		return userMapper.countByExample(example)>0;
	}
	
	private boolean isPhoneExist(String phone){
		if(StringUtils.isBlank(phone)){
			return true;
		}
		UserExample example = new UserExample();
		example.createCriteria().andPhoneEqualTo(phone);
		return userMapper.countByExample(example)>0;
	}
}
