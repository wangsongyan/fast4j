package cn.wangsy.fast4j.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.wangsy.fast4j.util.AppUtil;
import cn.wangsy.fast4j.web.model.dao.gen.PermissionMapper;
import cn.wangsy.fast4j.web.model.dao.gen.RolePermissionMapper;
import cn.wangsy.fast4j.web.model.entity.gen.Permission;
import cn.wangsy.fast4j.web.model.entity.gen.PermissionExample;
import cn.wangsy.fast4j.web.model.entity.gen.RolePermission;
import cn.wangsy.fast4j.web.model.entity.gen.RolePermissionExample;

import com.youymi.youymiframework.service.ServiceResult;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年7月26日 上午10:50:14
 */
@Service
public class PermissionService {

	@Resource
	private PermissionMapper permissionMapper;
	@Resource
	private RolePermissionMapper rolePermissionMapper;
	
	public ServiceResult<String> save(Permission permission){
		ServiceResult<String> ret = new ServiceResult<String>();
		if(null == permission || StringUtils.isBlank(permission.getPermissionSign())){
			ret.setMsg("参数错误！");
			ret.setSucceed(false);
			return ret;
		}
		if(StringUtils.isBlank(permission.getId())){
			permission.setId(AppUtil.getUUID());
			permissionMapper.insertSelective(permission);
			
			ret.setMsg("添加成功！");
			ret.setSucceed(false);
		}else{
			permissionMapper.updateByPrimaryKeySelective(permission);
			
			ret.setMsg("修改成功！");
			ret.setSucceed(false);
		}
		return ret;
	}
	
	public ServiceResult<String> delete(String id){
		ServiceResult<String> ret = new ServiceResult<String>();
		if(StringUtils.isBlank(id)){
			ret.setMsg("删除失败！");
		}else{
			permissionMapper.deleteByPrimaryKey(id);
			
			ret.setMsg("删除成功！");
			ret.setSucceed(true);
		}
		return ret;
	}

	public List<Permission> selectPermissionsByRoleId(String id) {
		RolePermissionExample rolePermissionExample = new RolePermissionExample();
		rolePermissionExample.createCriteria().andRoleIdEqualTo(id);
		List<RolePermission> rolePermissions = rolePermissionMapper.selectByExample(rolePermissionExample);
		if(CollectionUtils.isEmpty(rolePermissions)){
			return null;
		}
		
		List<String> ids = new ArrayList<String>();
		for(RolePermission userRole:rolePermissions){
			ids.add(userRole.getPermissionId());
		}
		PermissionExample permissionExample = new PermissionExample();
		permissionExample.createCriteria().andIdIn(ids);
		return permissionMapper.selectByExample(permissionExample);
	}
	
}
