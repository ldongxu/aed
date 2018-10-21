package com.aed.controller.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 刘东旭 on 2018/10/21.
 */
@Controller
@RequestMapping("/app")
public class AppIndexController {

    @RequestMapping("/index")
    public String indexPage() {
        return "/app/index";
    }
}
