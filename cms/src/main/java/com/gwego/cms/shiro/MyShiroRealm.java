package com.gwego.cms.shiro;

import com.gwego.cms.domain.SysUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author liudongxu06
 * @date 2018/7/24
 */
public class MyShiroRealm extends AuthorizingRealm{
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String account = (String) authenticationToken.getPrincipal();
        SysUser sysUser = null;
        //TODO

        if (sysUser==null) return null;
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(sysUser,sysUser.getPassword(),sysUser.getUserName());
        return authenticationInfo;
    }
}
