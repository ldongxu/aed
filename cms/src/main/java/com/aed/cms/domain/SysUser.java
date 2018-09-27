package com.aed.cms.domain;

import com.aed.app.constants.Constants;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

/**
 * @author liudongxu06
 * @date 2018/7/5
 */
public class SysUser extends BaseBean {

    @NotBlank
    @Pattern(regexp = Constants.MOBILE_REGEX,message = "手机号码格式不正确")
    private String account;//手机号做账号
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    @Pattern(regexp = Constants.MOBILE_REGEX,message = "手机号码格式不正确")
    private String mobile;
    private Date createTime;
    private Byte status;

    private List<String> roleIds;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }
}
