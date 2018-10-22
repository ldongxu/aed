package com.aed.service.ap;

import com.aed.core.bean.Result;
import com.aed.domain.AppUser;

import javax.servlet.http.HttpSession;

/**
 * Created by 刘东旭 on 2018/10/22.
 */
public interface AppUserService {

    Result register(AppUser user);

    Result doLogin(HttpSession session,String mobile, String pwd);

    AppUser findByMobile(String mobile);
}
