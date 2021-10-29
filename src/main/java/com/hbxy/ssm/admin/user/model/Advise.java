package com.hbxy.ssm.admin.user.model;

import java.io.Serializable;

/**
 * @author 
 * 
 */
public class Advise implements Serializable {
    private String aId;

    private String aDialog;

    private static final long serialVersionUID = 1L;

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public String getaDialog() {
        return aDialog;
    }

    public void setaDialog(String aDialog) {
        this.aDialog = aDialog;
    }
}