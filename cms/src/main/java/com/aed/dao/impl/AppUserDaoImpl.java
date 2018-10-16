package com.aed.dao.impl;

import com.aed.dao.AbstractBaseDao;
import com.aed.dao.AppUserDao;
import com.aed.domain.AppUser;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @author liudongxu06
 * @date 2018/10/8
 */
@Repository
public class AppUserDaoImpl extends AbstractBaseDao<AppUser> implements AppUserDao {
    @Override
    public AppUser findByMobile(String mobile) {
        Query query = Query.query(Criteria.where("mobile").is(mobile));
        return mongoTemplate.findOne(query,AppUser.class);
    }
}
