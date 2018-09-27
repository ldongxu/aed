package com.aed.cms.service;

import com.aed.cms.domain.SysResource;

import java.util.List;

/**
 * @author liudongxu06
 * @date 2018/8/2
 */
public interface ResourceService {
    SysResource createResourc(SysResource resource);
    void deleteResource(String id);
    List<SysResource> findMenu(String... resourceId);

}
