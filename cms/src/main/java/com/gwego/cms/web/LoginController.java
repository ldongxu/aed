package com.gwego.cms.web;

import com.gwego.bean.Result;
import com.gwego.cms.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liudongxu06
 * @date 2018/8/1
 */
@Controller
public class LoginController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(String account,String password, @RequestParam(defaultValue = "false") boolean rememberMe){
        return sysUserService.doLogin(account,password,rememberMe);
    }




}
