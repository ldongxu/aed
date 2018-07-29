package com.gwego.cms.service;

import com.gwego.cms.domain.SysUser;
import com.gwego.constants.Constants;
import com.gwego.util.CipherUtil;
import com.gwego.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author liudongxu06
 * @date 2018/7/27
 */
@Service
public class SysUserService {

    @Autowired
    private MongoTemplate mongoTemplate;

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
        mongoTemplate.insert(sysUser);

    }

    public SysUser findByAccount(String account){
        Query query = Query.query(Criteria.where("account").is(account));
        return mongoTemplate.findOne(query,SysUser.class);
    }
}
