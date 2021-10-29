package com.hbxy.ssm.admin.user.model;

import java.io.Serializable;

/**
 * @author 
 * 
 */
public class UserLogin implements Serializable {
    /**
     * 员工编号
     */
    private String userId;

    private String userLoginId;

    /**
     * 密码
     */
    private String currentPassword;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 类型
     */
    private String userType;

    /**
     * 性别
     */
    private String mSex;

    /**
     * 年龄
     */
    private Integer mAge;

    /**
     * 工资
     */
    private Float mMoney;

    /**
     * 电话
     */
    private String mPhone;

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getmSex() {
        return mSex;
    }

    public void setmSex(String mSex) {
        this.mSex = mSex;
    }

    public Integer getmAge() {
        return mAge;
    }

    public void setmAge(Integer mAge) {
        this.mAge = mAge;
    }

    public Float getmMoney() {
        return mMoney;
    }

    public void setmMoney(Float mMoney) {
        this.mMoney = mMoney;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }
}