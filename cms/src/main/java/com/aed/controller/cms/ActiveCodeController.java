package com.aed.controller.cms;

import com.aed.core.bean.Result;
import com.aed.domain.ActiveCode;
import com.aed.service.cms.ActiveCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 刘东旭 on 2018/10/15.
 */
@Controller
@RequestMapping("/cms")
public class ActiveCodeController {

    @Autowired
    private ActiveCodeService activeCodeService;

    @RequestMapping("/activecode")
    public String activeCodePage(){
        return "/cms/activecode";
    }

    @RequestMapping(value = "/generateCode",method = RequestMethod.POST)
    @ResponseBody
    public Result generateCode(String mobile,int num){
        int s = activeCodeService.generateCode(mobile,num);
        return Result.buildOkWithData(null);
    }

    @RequestMapping("/getCode")
    @ResponseBody
    public Result getCode(String mobile,int page,int size){
        List<ActiveCode> list = activeCodeService.getCodes(mobile,page,size);
        long count = activeCodeService.count(mobile);
        return Result.buildOkWithData(null);
    }
}
