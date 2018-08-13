package com.gwego.cms.service.impl;

import com.gwego.bean.Result;
import com.gwego.cms.domain.SysUser;
import com.gwego.cms.service.SysUserService;
import com.gwego.cms.shiro.MyShiroRealm;
import com.gwego.constants.Constants;
import com.gwego.util.ValidationUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

/**
 * @author liudongxu06
 * @date 2018/7/27
 */
@Service
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MyShiroRealm myShiroRealm;

    public void registerSysUser(String account,String password){
        SysUser sysUser = new SysUser();
        sysUser.setAccount(account);
        sysUser.setUserName(account);
        sysUser.setMobile(account);
        String pwd = myShiroRealm.getPasswordService().encryptPassword(password);
        sysUser.setPassword(pwd);
        sysUser.setCreateTime(new Date());
        sysUser.setStatus(Constants.STATUS_ON);
        ValidationUtil.validate(sysUser);
        mongoTemplate.insert(sysUser);

    }

    public SysUser findByAccount(String account){
        Query query = Query.query(Criteria.where("account").is(account));
        return mongoTemplate.findOne(query,SysUser.class);
    }

    @Override
    public SysUser findById(String userId) {
        return null;
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
        return null;
    }

    @Override
    public Set<String> findPermission(String account) {
        return null;
    }

    public Result doLogin(String account,String password,boolean rememberMe){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(account,password);
        token.setRememberMe(rememberMe);
        String errmsg = "登陆失败";
        try {
            subject.login(token);
        }catch(UnknownAccountException uae){
            errmsg = "用户名或者密码错误";
        }catch(IncorrectCredentialsException ice){
            errmsg = "用户名或者密码错误";
        }catch(LockedAccountException lae){
            errmsg = "账户已锁定,暂时不能登录";
        }catch(ExcessiveAttemptsException eae){
            errmsg = "错误次数过多,暂时不能登录";
        }catch(AuthenticationException ae){
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            ae.printStackTrace();
        }
        if (!subject.isAuthenticated()){
            token.clear();
            return Result.buildCommonFail(errmsg);
        }
        return Result.buildOk();

    }
}
