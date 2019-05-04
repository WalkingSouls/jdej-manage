package com.miquankj.api.entity;

public class MessageTemplate {
    private Integer msgTemId;

    private String temName;

    private Boolean valid;

    private String temDes;

    public Integer getMsgTemId() {
        return msgTemId;
    }

    public void setMsgTemId(Integer msgTemId) {
        this.msgTemId = msgTemId;
    }

    public String getTemName() {
        return temName;
    }

    public void setTemName(String temName) {
        this.temName = temName;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getTemDes() {
        return temDes;
    }

    public void setTemDes(String temDes) {
        this.temDes = temDes;
    }
}