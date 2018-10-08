package com.aed.service.cms;

import com.aed.domain.AppUser;

import java.util.List;

/**
 * @author liudongxu06
 * @date 2018/10/8
 */
public interface CmsAppUserService {

    List<AppUser> getList(int page,int size,String mobile);

    long count(String mobile);

}
