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
public class AppLoginInterceptor extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = LoginUtil.getRequestUri(request);
        if (LoginUtil.isAppLogin(request)){
            if (uri.startsWith("/app/login") || uri.startsWith("/app/doLogin")){
                if (AjaxUtil.isAjaxRequest(request)){
                    response.setHeader("Content-type", "application/json;charset=UTF-8");
                    response.setCharacterEncoding("UTF-8");
                    String result = JsonUtil.toJson(Result.buildFail(ResponseErrorEnum.APP_LOGINED));
                    response.getWriter().print(result);
                }else {
                    response.sendRedirect(request.getContextPath()+"/app/index");
                }
                return false;
            }
            return true;
        }else {
            if (uri.startsWith("/app/index")
                    || uri.startsWith("/app/login") || uri.startsWith("/app/doLogin")
                    || uri.startsWith("/app/register") || uri.startsWith("/app/doRegister")
            ){
                return true;
            }
            response.sendRedirect(request.getContextPath()+"/app/login");
            return false;
        }
    }
}
