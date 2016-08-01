package cn.wangsy.fast4j.web.service;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import cn.wangsy.fast4j.web.model.entity.gen.User;

import com.youymi.youymiframework.service.ServiceResult;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年7月29日 下午3:04:48
 */
@Service
public class AuthService {

	@Resource
	private UserService userService;
	
	public ServiceResult<User> loginValidate(User user) {
		ServiceResult<User> ret = new ServiceResult<User>();
		ret.setSucceed(false);
		if(user == null){
			return null;
		}
		if(StringUtils.isBlank(user.getUserName())){
			ret.setMsg("账号不能为空！");
			return ret;
		}
		if(StringUtils.isBlank(user.getPassword())){
			ret.setMsg("密码不能为空！");
			return ret;
		}
		User dbUser = userService.selectUserByAccount(user);
		if(dbUser == null){
			ret.setMsg("账户信息不正确！");
			return ret;
		}
		if(!user.getPassword().equals(dbUser.getPassword())){
			ret.setMsg("密码不正确");
			return ret;
		}
		ret.setSucceed(true);
		ret.setMsg("验证通过！");
		ret.setData(dbUser);
		return ret;
	}
	
	public ServiceResult<User> loginValidate(User user,String verifyCode){
		return loginValidate(user);
	}
	
}
