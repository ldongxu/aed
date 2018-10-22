package com.aed.controller.app;

import com.aed.core.bean.Result;
import com.aed.domain.AppUser;
import com.aed.service.ap.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author liudongxu06
 * @date 2018/9/29
 */
@Controller
@RequestMapping("/app")
public class AppLoginController {
    @Autowired
    private AppUserService appUserService;

    @RequestMapping("/register")
    public String registerPage() {
        return "/app/register";
    }

    @RequestMapping(value = "/doRegister",method = RequestMethod.POST)
    @ResponseBody
    public Result doRegister(AppUser user){
        return appUserService.register(user);
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "/app/login";
    }

    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    @ResponseBody
    public Result doLogin(HttpSession session,String mobile,String pwd){
        return appUserService.doLogin(session,mobile,pwd);
    }


}
