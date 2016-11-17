package cn.wangsy.fast4j.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.wangsy.fast4j.web.model.dao.gen.RoleMapper;
import cn.wangsy.fast4j.web.model.dao.gen.UserRoleMapper;
import cn.wangsy.fast4j.web.model.entity.gen.Role;
import cn.wangsy.fast4j.web.model.entity.gen.RoleExample;
import cn.wangsy.fast4j.web.model.entity.gen.UserRole;
import cn.wangsy.fast4j.web.model.entity.gen.UserRoleExample;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年7月29日 下午4:46:01
 */
@Service
public class RoleService {

	@Resource
	private UserRoleMapper userRoleMapper;
	@Resource
	private RoleMapper roleMapper;
	
	public List<Role> selectRolesByUserId(String id) {
		
		UserRoleExample userRoleExample = new UserRoleExample();
		userRoleExample.createCriteria().andUserIdEqualTo(id);
		List<UserRole> userRoles = userRoleMapper.selectByExample(userRoleExample);
		if(CollectionUtils.isEmpty(userRoles)){
			return null;
		}
		
		List<String> ids = new ArrayList<String>();
		for(UserRole userRole:userRoles){
			ids.add(userRole.getRoleId());
		}
		RoleExample roleExample = new RoleExample();
		roleExample.createCriteria().andIdIn(ids);
		return roleMapper.selectByExample(roleExample);
	}

	// 获取所有角色
	public List<Role> selectList(){
		RoleExample example = new RoleExample();
		return roleMapper.selectByExample(example);
	}
	
}
