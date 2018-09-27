package com.aed.cms.web;

import com.aed.cms.service.SysUserService;
import com.aed.app.bean.Result;
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

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(String account,String password, @RequestParam(defaultValue = "false") boolean rememberMe){
        return sysUserService.doLogin(account,password,rememberMe);
    }




}
