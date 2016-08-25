package cn.wangsy.fast4j.web.model.dao.customized;

import org.apache.ibatis.annotations.Param;

import cn.wangsy.fast4j.web.model.entity.gen.User;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年8月25日 上午10:03:14
 */
public interface UserDao {

	public User getUserById(@Param("id") String id);
	
}
