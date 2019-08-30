package com.zzw.login.realm;

import com.zzw.login.factory.Md5Factory;
import com.zzw.login.pojo.SysUser;
import com.zzw.login.service.SysUserManagerService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private SysUserManagerService sysUserManagerService;


    /**
     * 授权认证
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
        List<String> roleList = sysUserManagerService.getSysRoleByUserId(user.getUserId());
        List<String> permissionList = sysUserManagerService.getSysPermissionByUserId(user.getUserId());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roleList);
        info.addStringPermissions(permissionList);
        return info;
    }

    /**
     * 登陆认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());

        //        String username = authenticationToken.getPrincipal().toString();
        SysUser user = sysUserManagerService.getSysUserByName(username);
        if (user == null) {
            //账户不存在
            throw new UnknownAccountException();
        }
        if (!user.getPassword().equals(Md5Factory.getMd5HashStr(password, user.getAuthSalt(), user.getSuthSaltNum()))) {
            //密码不正确
            throw new IncorrectCredentialsException();
        }
        AuthenticationInfo info = new SimpleAuthenticationInfo(user, password.toCharArray(), getName());
        return info;
    }
}
