package com.aed.service.cms;

import com.aed.core.bean.Result;
import com.aed.domain.SysUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * @author liudongxu06
 * @date 2018/8/2
 */
public interface SysUserService {
    void registerSysUser(String userName, String password);

    Result doLogin(HttpSession session, String userName, String password);

    SysUser findByUserName(String userName);

    SysUser findById(String id);

    void changePassword(String id, String newPassword);


}
