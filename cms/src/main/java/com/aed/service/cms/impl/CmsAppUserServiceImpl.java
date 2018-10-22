package com.aed.service.cms.impl;

import com.aed.dao.AppUserDao;
import com.aed.domain.AppUser;
import com.aed.service.cms.CmsAppUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liudongxu06
 * @date 2018/10/8
 */
@Service
public class CmsAppUserServiceImpl implements CmsAppUserService {
    @Autowired
    private AppUserDao appUserDao;

    @Override
    public List<AppUser> getList(int page, int size, String mobile) {
        Query query = new Query();
        if (StringUtils.isNotBlank(mobile)){
            query.addCriteria(Criteria.where("mobile").is(mobile));
        }
        query.with(new Sort(Sort.Direction.DESC, "createTime"));
        page = page>0?page:1;
        size = size>0?size:10;
        int skip = (page-1)*size;
        query.skip(skip).limit(size);
        return appUserDao.findByQuery(query);
    }

    @Override
    public long count(String mobile) {
        Query query = new Query();
        if (StringUtils.isNotBlank(mobile)){
           query.addCriteria(Criteria.where("mobile").is(mobile));
        }
        return appUserDao.count(query);
    }
}
