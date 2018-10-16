package com.aed.domain;


import java.util.Date;

/**
 * Created by 刘东旭 on 2018/10/15.
 */
public class ActiveCode extends BaseBean {
    private String account;
    private String code;
    private Byte status;
    private Date createTime;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
