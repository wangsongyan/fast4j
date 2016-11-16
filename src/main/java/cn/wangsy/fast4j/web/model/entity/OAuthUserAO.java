/**
 * 
 */
package cn.wangsy.fast4j.web.model.entity;

import cn.wangsy.fast4j.web.model.entity.gen.OAuthUser;
import cn.wangsy.fast4j.web.model.entity.gen.User;

/**
 * @author wangsy
 * @date 2016年11月15日下午3:26:31
 */
public class OAuthUserAO extends OAuthUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
