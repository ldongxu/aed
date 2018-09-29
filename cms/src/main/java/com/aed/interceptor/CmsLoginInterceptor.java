package com.aed.interceptor;

import com.aed.common.util.AjaxUtil;
import com.aed.common.util.LoginUtil;
import com.aed.core.bean.ResponseErrorEnum;
import com.aed.core.bean.Result;
import com.aed.core.util.JsonUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liudongxu06
 * @date 2018/9/29
 */
public class CmsLoginInterceptor extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = LoginUtil.getRequestUri(request);
        if (LoginUtil.isSysLogin(request)){
            if (uri.startsWith("/cms/login") || uri.startsWith("/cms/dologin")){
                if (AjaxUtil.isAjaxRequest(request)){
                    response.setHeader("Content-type", "application/json;charset=UTF-8");
                    response.setCharacterEncoding("UTF-8");
                    String result = JsonUtil.toJson(Result.buildFail(ResponseErrorEnum.CMS_LOGINED));
                    response.getWriter().print(result);
                }else {
                    response.sendRedirect(request.getContextPath()+"/cms/index");
                }
                return false;
            }
            return true;
        }else {
            return uri.startsWith("/cms/login") || uri.startsWith("/cms/dologin");
        }
    }

}
