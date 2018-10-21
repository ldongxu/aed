package com.aed.controller.app;

import com.aed.core.bean.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liudongxu06
 * @date 2018/9/29
 */
@Controller
@RequestMapping("/app")
public class AppLoginController {

    @RequestMapping("/register")
    public String registerPage() {

        return "/app/register";
    }

    @RequestMapping(value = "/doRegister",method = RequestMethod.POST)
    @ResponseBody
    public Result doRegister(){
        return Result.buildOk();
    }

    @RequestMapping("/login")
    public String loginPage() {

        return "/app/login";
    }

    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    @ResponseBody
    public Result doLogin(){
        return Result.buildOk();
    }


}
