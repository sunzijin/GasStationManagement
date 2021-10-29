package com.hbxy.ssm.admin.user.model;

import java.io.Serializable;

/**
 * @author 
 * 
 */
public class Ob implements Serializable {
    private String oId;

    /**
     * 商品名称
     */
    private String oName;

    /**
     * 商品数量
     */
    private Integer oCount;

    /**
     * 商品价格
     */
    private Float oPrice;

    /**
     * 生产厂
     */
    private String oFactory;

    private static final long serialVersionUID = 1L;

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        this.oName = oName;
    }

    public Integer getoCount() {
        return oCount;
    }

    public void setoCount(Integer oCount) {
        this.oCount = oCount;
    }

    public Float getoPrice() {
        return oPrice;
    }

    public void setoPrice(Float oPrice) {
        this.oPrice = oPrice;
    }

    public String getoFactory() {
        return oFactory;
    }

    public void setoFactory(String oFactory) {
        this.oFactory = oFactory;
    }
}