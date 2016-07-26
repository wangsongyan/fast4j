package cn.wangsy.fast4j.web.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.stereotype.Service;

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
	//private UserService userService;
	//@Resource(name = "userService")
	private UserMapper userMapper;
	
	@Resource
	private SqlSessionFactoryBean sqlSessionFactoryBean;
	
	public List<User> selectList(){
		UserExample example = new UserExample();
		return userMapper.selectByExample(example);
	}
	
	public ServiceResult<String> save(User user){
		ServiceResult<String> ret = new ServiceResult<String>();
		if(null == user || StringUtils.isBlank(user.getUserName())){
			ret.setMsg("参数错误！");
			ret.setSucceed(false);
			return ret;
		}
		if(StringUtils.isBlank(user.getId())){
			user.setId(AppUtil.getUUID());
			userMapper.insertSelective(user);
			
			ret.setMsg("添加成功！");
			ret.setSucceed(false);
		}else{
			userMapper.updateByPrimaryKeySelective(user);
			
			ret.setMsg("修改成功！");
			ret.setSucceed(false);
		}
		return ret;
	}
	
	public int updateByUserName(String userName,String password){
		
		User user = new User();
		user.setPassword(password);
		
		UserExample example = new UserExample();
		example.createCriteria().andUserNameLike("%"+userName+"%");
		
		return userMapper.updateByExampleSelective(user, example);
	}
	
	public void test() throws Exception{
    	SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
    	
//		获取mybatis 的变量
		//SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) springContext
		//		.getBean("sqlSessionFactory");
		//		取得Configuration ,获取到对应的resultMap
		ResultMap map = sqlSessionFactory.getConfiguration().getResultMap(
				"cn.wangsy.fast4j.web.model.dao.gen.LogMapper.BaseResultMap");
		
		//System.out.println("[id]"+map.getId());
		
		//		ok，遍历
		List<ResultMapping> mapping = map.getIdResultMappings();//map.getResultMappings();

		for (ResultMapping mp : mapping) {
			System.out.println(mp.getColumn() + "-->" + mp.getProperty()
					+ "-->" + mp.getJavaType());
		}

		System.out.println("end");
	}
	
}
