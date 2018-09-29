package com.aed.common.util;

import com.aed.domain.SysUser;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author liudongxu06
 * @date 2018/9/29
 */
public class LoginUtil {

    public static final String SESSION_ATTRIBUTE_CMS = "currentSysUser";
    public static final String SESSION_ATTRIBUTE_APP = "currentAppUser";


    public static SysUser getLoginSysUser(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        }
        return (SysUser) session.getAttribute(SESSION_ATTRIBUTE_CMS);
    }

    public static boolean isSysLogin(HttpServletRequest request){
        return getLoginSysUser(request)!=null;
    }

    public static String getRequestUri(HttpServletRequest request){
        String contextPath = request.getContextPath();
        String uri = request.getRequestURI();
        if (StringUtils.isNotBlank(contextPath)) {
            uri = uri.replace(contextPath, "");
        }
        return uri;
    }
}
