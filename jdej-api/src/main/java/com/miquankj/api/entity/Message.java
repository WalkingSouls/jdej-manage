package com.miquankj.api.entity;

import java.util.Date;

public class Message {
    private Integer msgId;

    private Integer userId;

    private Integer msgType;

    private String sender;

    private String receiver;

    private Date sendTime;

    private Byte readed;

    private Byte replied;

    private Byte status;

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Byte getReaded() {
        return readed;
    }

    public void setReaded(Byte readed) {
        this.readed = readed;
    }

    public Byte getReplied() {
        return replied;
    }

    public void setReplied(Byte replied) {
        this.replied = replied;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}