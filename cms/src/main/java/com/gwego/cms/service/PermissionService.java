package com.gwego.cms.service;

import com.gwego.cms.domain.SysPermission;

/**
 * @author liudongxu06
 * @date 2018/8/2
 */
public interface PermissionService {
    SysPermission createPermission(SysPermission permission);
    void deletePermission(String id);
}
