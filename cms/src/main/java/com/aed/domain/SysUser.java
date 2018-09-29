package com.aed.domain;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author liudongxu06
 * @date 2018/7/5
 */
public class SysUser extends BaseBean {

    @NotBlank(message = "账号不能为空")
    private String userName;
    @NotBlank(message = "密码不能为空")
    private String password;
    private Date createTime;
    private Byte status;



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

}
