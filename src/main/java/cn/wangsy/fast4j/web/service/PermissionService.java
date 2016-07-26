package cn.wangsy.fast4j.web.service;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import cn.wangsy.fast4j.util.AppUtil;
import cn.wangsy.fast4j.web.model.dao.gen.PermissionMapper;
import cn.wangsy.fast4j.web.model.entity.gen.Permission;

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
	
	public ServiceResult<String> save(Permission permission){
		ServiceResult<String> ret = new ServiceResult<String>();
		if(null == permission || StringUtils.isBlank(permission.getCode())){
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
	
}
