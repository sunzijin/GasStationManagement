package com.hbxy.ssm.admin.user.model;

import java.io.Serializable;

/**
 * @author 
 * 
 */
public class Gas implements Serializable {
    private String gId;

    /**
     * 油品型号
     */
    private String gName;

    /**
     * 油品类型
     */
    private String gType;

    /**
     * 普通油价
     */
    private Float gUMoney;

    /**
     * 会员油价
     */
    private Float gVMoney;

    private static final long serialVersionUID = 1L;

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgType() {
        return gType;
    }

    public void setgType(String gType) {
        this.gType = gType;
    }

    public Float getgUMoney() {
        return gUMoney;
    }

    public void setgUMoney(Float gUMoney) {
        this.gUMoney = gUMoney;
    }

    public Float getgVMoney() {
        return gVMoney;
    }

    public void setgVMoney(Float gVMoney) {
        this.gVMoney = gVMoney;
    }
}