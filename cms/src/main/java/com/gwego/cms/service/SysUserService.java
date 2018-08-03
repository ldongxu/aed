package com.gwego.cms.service;

import com.gwego.bean.Result;
import com.gwego.cms.domain.SysUser;

/**
 * @author liudongxu06
 * @date 2018/8/2
 */
public interface SysUserService {
    void registerSysUser(String account,String password);
    Result doLogin(String account, String password, boolean rememberMe);
    SysUser findByAccount(String account);
    SysUser findById(String userId);
    void changePassword(String userId,String newPassword);
    void addRoles(String userId,String... roleIds);
    void removeRoles(String userId,String... roleIds);


}
