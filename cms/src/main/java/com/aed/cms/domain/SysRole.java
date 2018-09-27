package com.aed.cms.domain;

import java.util.List;

/**
 * @author liudongxu06
 * @date 2018/7/23
 */
public class SysRole extends BaseBean{
    private String role;
    private String description;
    private Boolean available = Boolean.FALSE;

    private List<String> permissionIds;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<String> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(List<String> permissionIds) {
        this.permissionIds = permissionIds;
    }
}
