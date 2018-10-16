package com.aed.dao;

import com.aed.domain.AppUser;

/**
 * @author liudongxu06
 * @date 2018/10/8
 */
public interface AppUserDao extends BaseDao<AppUser>{

    AppUser findByMobile(String mobile);
}
