package com.aed.controller.cms;

import com.aed.core.bean.Result;
import com.aed.core.util.DateUtil;
import com.aed.domain.ActiveCode;
import com.aed.service.cms.ActiveCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 刘东旭 on 2018/10/15.
 */
@Controller
@RequestMapping("/cms")
public class ActiveCodeController {

    @Autowired
    private ActiveCodeService activeCodeService;

    @RequestMapping("/activecode")
    public String activeCodePage() {
        return "/cms/activecode";
    }

    @RequestMapping(value = "/generateCode", method = RequestMethod.POST)
    @ResponseBody
    public Result generateCode(String mobile, int num) {
        Result result = activeCodeService.generateCode(mobile, num);
        return Result.buildOkWithData(result);
    }

    @RequestMapping("/getCode")
    @ResponseBody
    public Result getCode(String mobile, int page, int size) {
        List<ActiveCode> list = activeCodeService.getCodes(mobile, page, size);
        list.stream().forEach(activeCode -> activeCode.setExtVal("createTimeStr", DateUtil.formatDateTime(activeCode.getCreateTime())));
        long count = activeCodeService.count(mobile);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",list);
        map.put("total",count);
        return Result.buildOkWithData(map);
    }
}
