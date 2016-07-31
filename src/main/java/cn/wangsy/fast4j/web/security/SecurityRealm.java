package cn.wangsy.fast4j.web.security;


import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import com.alibaba.druid.stat.TableStat.Name;
import com.youymi.youymiframework.service.ServiceResult;

import cn.wangsy.fast4j.web.model.entity.gen.Permission;
import cn.wangsy.fast4j.web.model.entity.gen.Role;
import cn.wangsy.fast4j.web.model.entity.gen.User;
import cn.wangsy.fast4j.web.service.impl.AuthService;
import cn.wangsy.fast4j.web.service.impl.PermissionService;
import cn.wangsy.fast4j.web.service.impl.RoleService;
import cn.wangsy.fast4j.web.service.impl.UserService;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年7月29日 下午4:34:03
 */
@Component(value = "securityRealm") 
public class SecurityRealm extends AuthorizingRealm{  
  
    @Resource  
    private UserService userService;  
    @Resource
    private RoleService roleService;
    @Resource
    private PermissionService permissionService;
    @Resource
    private AuthService authService;
    /** 
     * 权限认证 
     */  
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {  
    	SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = String.valueOf(principals.getPrimaryPrincipal());
        User queryUser = new User();
        queryUser.setUserName(username);
        
        final User user = userService.selectUserByAccount(queryUser);
        final List<Role> roleInfos = roleService.selectRolesByUserId(user.getId());
        for (Role role : roleInfos) {
            // 添加角色
            System.err.println(role);
            authorizationInfo.addRole(role.getRoleSign());

            final List<Permission> permissions = permissionService.selectPermissionsByRoleId(role.getId());
            for (Permission permission : permissions) {
                // 添加权限
                System.err.println(permission);
                authorizationInfo.addStringPermission(permission.getPermissionSign());
            }
        }
        return authorizationInfo; 
    }  
  
    /** 
     * 登录认证; 
     */  
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(  
            AuthenticationToken token) throws AuthenticationException {  
    	String username = String.valueOf(token.getPrincipal());
        String password = new String((char[]) token.getCredentials()); 
        //查出是否有此用户  
        User queryUser = new User();
        queryUser.setUserName(username);
        queryUser.setPassword(password);
        ServiceResult<User> ret = authService.loginValidate(queryUser);
        System.out.println(ret.getMsg());
        User user = ret.getData();
        if(user!=null){  
            //若存在，将此用户存放到登录认证info中  
            return new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName());  
        }else{
        	throw new AuthenticationException("用户名或密码错误");
        }
    }  
  
}  
