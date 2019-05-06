package com.miquankj.api.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Message {
    private Integer msgId;

    private Integer userId;

    private Integer msgType;

    private String sender;

    private String receiver;

    private Date sendTime;

    private Byte readed = 0;

    private Byte replied = 0;

    private Byte status = 0;

}