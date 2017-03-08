/**
 * 
 */
package cn.wangsy.fast4j.web.service;

import java.util.Date;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import cn.wangsy.fast4j.core.annotation.DataSource;
import cn.wangsy.fast4j.web.model.dao.gen.UserMapper;
import cn.wangsy.fast4j.web.model.entity.gen.User;

/**
 * @author wangsy
 * @date 2017年1月11日上午9:29:39
 */
@Service
public class TestService {

	@Resource
	private UserMapper userMapper;
	
	@DataSource(value = "dataSource1")
	private void insert(){
		User user = new User();
		user.setId("123");
		user.setUserName("test");
		user.setCreatedAt(new Date());
		userMapper.insertSelective(user);
	}
	
	@DataSource(value = "dataSource2")
	private void insert1(){
		User user = new User();
		user.setId("123");
		user.setUserName("test");
		user.setCreatedAt(new Date());
		userMapper.insertSelective(user);
	}
	
	@Transactional
	public void test(){
		insert();
		insert1();
	}
	
}
