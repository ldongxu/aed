package com.gwego.cms.service;

import com.gwego.cms.domain.SysRole;

import java.util.Set;

/**
 * @author liudongxu06
 * @date 2018/8/2
 */
public interface RoleService {
    SysRole createRole(SysRole role);
    void deleteRole(String roleId);
    void addRolePermissions(String roleId,String... permissionIds);
    void removeRolePermissions(String roleId,String... permissionIds);
    Set<String> findRoles(String... roleIds);
    Set<String> findPermissions(String... roleIds);
}
