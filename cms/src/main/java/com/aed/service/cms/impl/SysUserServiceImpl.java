package com.aed.service.cms.impl;

import com.aed.core.bean.Result;
import com.aed.core.constants.Constants;
import com.aed.core.util.CipherUtil;
import com.aed.core.util.ValidationUtil;
import com.aed.dao.SysUserDao;
import com.aed.domain.SysUser;
import com.aed.service.cms.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liudongxu06
 * @date 2018/7/27
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;


    public void registerSysUser(String account,String password){
        SysUser sysUser = new SysUser();
        sysUser.setAccount(account);
        sysUser.setUserName(account);
        sysUser.setMobile(account);
        String pwd = CipherUtil.generatePassword(password);
        sysUser.setPassword(pwd);
        sysUser.setCreateTime(new Date());
        sysUser.setStatus(Constants.STATUS_ON);
        ValidationUtil.validate(sysUser);
        sysUserDao.insert(sysUser);

    }

    public SysUser findByAccount(String account){
        Query query = Query.query(Criteria.where("account").is(account));
        return sysUserDao.findOneByQuery(query);
    }

    @Override
    public SysUser findById(String userId) {
        return sysUserDao.findById(userId);
    }

    @Override
    public void changePassword(String userId, String newPassword) {

    }

    @Override
    public void addRoles(String userId, String... roleIds) {

    }

    @Override
    public void removeRoles(String userId, String... roleIds) {

    }

    @Override
    public Set<String> findRoles(String account) {
        SysUser user = findByAccount(account);
        List<String> roles = user.getRoleIds();
        return new HashSet<>(roles);
    }

    @Override
    public Set<String> findPermission(String account) {
        return null;
    }

    public Result doLogin(String account, String password, boolean rememberMe){

        return Result.buildOk();

    }
}
