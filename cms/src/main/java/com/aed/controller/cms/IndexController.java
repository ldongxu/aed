package com.aed.controller.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liudongxu06
 * @date 2018/9/30
 */
@Controller
@RequestMapping("/cms")
public class IndexController {

    @RequestMapping("/index")
    public String indexPage(){
        return "/cms/index";
    }
}
