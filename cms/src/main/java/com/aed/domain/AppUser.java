package com.aed.domain;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author liudongxu06
 * @date 2018/9/29
 */
public class AppUser extends BaseBean {
    @NotBlank
    private String mobile;
    @NotBlank
    private String pwd;
    @NotBlank
    private String company;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String address;
    private Date createTime;
    private Date updateTime;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
