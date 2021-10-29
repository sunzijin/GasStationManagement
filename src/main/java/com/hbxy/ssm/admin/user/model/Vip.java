package com.hbxy.ssm.admin.user.model;

import java.io.Serializable;

/**
 * @author 
 * 
 */
public class Vip implements Serializable {
    /**
     * 会员编号
     */
    private String vId;

    /**
     * 会员姓名
     */
    private String vName;

    /**
     * 会员性别
     */
    private String vSex;

    /**
     * 会员电话
     */
    private String vPhone;

    private static final long serialVersionUID = 1L;

    public String getvId() {
        return vId;
    }

    public void setvId(String vId) {
        this.vId = vId;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public String getvSex() {
        return vSex;
    }

    public void setvSex(String vSex) {
        this.vSex = vSex;
    }

    public String getvPhone() {
        return vPhone;
    }

    public void setvPhone(String vPhone) {
        this.vPhone = vPhone;
    }
}