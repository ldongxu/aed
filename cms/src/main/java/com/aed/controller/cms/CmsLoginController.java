package com.aed.controller.cms;

import com.aed.core.bean.Result;
import com.aed.service.cms.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public Result doLogin(String userName, String password, HttpSession session){
        return sysUserService.doLogin(session,userName,password);
    }
}
