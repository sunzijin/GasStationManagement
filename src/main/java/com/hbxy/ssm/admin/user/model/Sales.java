package com.hbxy.ssm.admin.user.model;

import java.io.Serializable;

/**
 * @author 
 * 
 */
public class Sales implements Serializable {
    private String sId;

    /**
     * 营业额
     */
    private Float sMoney;

    private static final long serialVersionUID = 1L;

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public Float getsMoney() {
        return sMoney;
    }

    public void setsMoney(Float sMoney) {
        this.sMoney = sMoney;
    }
}