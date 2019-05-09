package com.miquankj.api.entity;

import lombok.Data;

import java.util.Date;
@Data
public class NoticeInfo {
    private Integer id;

    private String noticeTitle;

    private String noticType;

    private String noticState;

    private String senderId;

    private Date senderDate;

    private String receiverId;

    private Date receiverDate;

    private String state;

}