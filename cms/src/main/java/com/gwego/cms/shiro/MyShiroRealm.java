package com.gwego.cms.shiro;

import com.gwego.cms.domain.SysUser;
import com.gwego.cms.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liudongxu06
 * @date 2018/7/24
 */
public class MyShiroRealm extends AuthorizingRealm{
    @Autowired
    private SysUserService sysUserService;
    //权限授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //登陆认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String account = (String) authenticationToken.getPrincipal();
        String password = new String((char[])authenticationToken.getCredentials());
        SysUser sysUser = sysUserService.findByAccount(account);
        if (sysUser==null) throw new UnknownAccountException("账号错误");
        if (!password.equals(sysUser.getPassword())) throw new IncorrectCredentialsException("密码错误");
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(sysUser,sysUser.getPassword(),getName());
        return authenticationInfo;
    }
}
