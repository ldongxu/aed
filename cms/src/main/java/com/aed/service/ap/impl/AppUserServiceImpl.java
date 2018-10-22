package com.aed.service.ap.impl;

import com.aed.common.util.LoginUtil;
import com.aed.core.bean.ResponseErrorEnum;
import com.aed.core.bean.Result;
import com.aed.core.util.CipherUtil;
import com.aed.core.util.ValidationUtil;
import com.aed.dao.AppUserDao;
import com.aed.domain.AppUser;
import com.aed.service.ap.AppUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by 刘东旭 on 2018/10/22.
 */
@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private AppUserDao appUserDao;

    @Override
    public Result register(AppUser user) {
        ValidationUtil.validate(user);
        Date now = new Date();
        user.setCreateTime(now);
        user.setUpdateTime(now);
        appUserDao.insert(user);
        return Result.buildOk();
    }

    @Override
    public Result doLogin(HttpSession session,String mobile, String pwd) {
        if (StringUtils.isBlank(mobile) || StringUtils.isBlank(pwd)) return Result.buildFail(ResponseErrorEnum.ILLEGAL_APP_LOGIN_PARAMS);
        AppUser appUser = findByMobile(mobile);
        if (appUser==null) return Result.buildFail(ResponseErrorEnum.NOT_EXIST_APP_USER);
        if (!CipherUtil.validatePassword(appUser.getPwd(),pwd)){
            return Result.buildFail(ResponseErrorEnum.ILLEGAL_APP_LOGIN_PARAMS);
        }
        session.setAttribute(LoginUtil.SESSION_ATTRIBUTE_APP,appUser);
        return Result.buildOk();
    }

    @Override
    public AppUser findByMobile(String mobile) {
        return appUserDao.findByMobile(mobile);
    }
}
