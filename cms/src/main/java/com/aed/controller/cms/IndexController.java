package com.aed.controller.cms;

import com.aed.core.bean.Result;
import com.aed.core.util.JsonUtil;
import com.aed.domain.AppUser;
import com.aed.service.cms.CmsAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liudongxu06
 * @date 2018/9/30
 */
@Controller
@RequestMapping("/cms")
public class IndexController {

    @Autowired
    private CmsAppUserService appUserService;

    @RequestMapping("/index")
    public String indexPage() {
        return "/cms/index";
    }

    @RequestMapping("/userList")
    @ResponseBody
    public Result pageList(Integer page, Integer size, String mobile) {
        List<AppUser> list = appUserService.getList(page == null ? 1 : page, size == null ? 10 : size, mobile);
        list.forEach(o -> {
            o.setPwd(null);
        });
        long total = appUserService.count(mobile);
        Map<String, Object> map = new HashMap<>();
        map.put("rows", list);
        map.put("total", total);
        return Result.buildOkWithData(map);
    }
}
