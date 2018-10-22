package com.aed.service.cms.impl;

import com.aed.common.util.LoginUtil;
import com.aed.core.bean.ResponseErrorEnum;
import com.aed.core.bean.Result;
import com.aed.core.constants.Constants;
import com.aed.core.util.CipherUtil;
import com.aed.core.util.ValidationUtil;
import com.aed.dao.SysUserDao;
import com.aed.domain.SysUser;
import com.aed.service.cms.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author liudongxu06
 * @date 2018/7/27
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;


    public void registerSysUser(String userName,String password){
        SysUser sysUser = new SysUser();
        sysUser.setUserName(userName);
        String pwd = CipherUtil.generatePassword(password);
        sysUser.setPassword(pwd);
        sysUser.setCreateTime(new Date());
        sysUser.setStatus(Constants.STATUS_ON);
        ValidationUtil.validate(sysUser);
        sysUserDao.insert(sysUser);

    }

    @Override
    public Result doLogin(HttpSession session, String userName, String password) {
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) return Result.buildFail(ResponseErrorEnum.ILLEGAL_CMS_LOGIN_PARAMS);
        SysUser user = findByUserName(userName.trim());
        if (null == user) return Result.buildFail(ResponseErrorEnum.NOT_EXIST_CMS_USER);
        if (!CipherUtil.validatePassword(user.getPassword(),password)){
            return Result.buildFail(ResponseErrorEnum.ILLEGAL_CMS_LOGIN_PARAMS);
        }
        session.setAttribute(LoginUtil.SESSION_ATTRIBUTE_CMS,user);
        return Result.buildOk();

    }

    @Override
    public SysUser findById(String id) {
        return sysUserDao.findById(id);
    }

    @Override
    public void changePassword(String id, String newPassword) {

    }

    @Override
    public SysUser findByUserName(String userName) {
        return sysUserDao.findOneByQuery(Query.query(Criteria.where("userName").is(userName)));
    }
}
