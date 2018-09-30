package com.aed.controller.cms;

import com.aed.common.util.LoginUtil;
import com.aed.core.bean.Result;
import com.aed.service.cms.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author liudongxu06
 * @date 2018/9/29
 */
@Controller
@RequestMapping("/cms")
public class CmsLoginController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginPage(){
        return "/cms/login";
    }

    @RequestMapping(value = "/dologin",method = RequestMethod.POST)
    @ResponseBody
    public Result doLogin(String userName, String password, HttpSession session){
        return sysUserService.doLogin(session,userName,password);
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session!=null){
            session.removeAttribute(LoginUtil.SESSION_ATTRIBUTE_CMS);
            session.invalidate();
        }
        return "/cms/login";
    }
}
