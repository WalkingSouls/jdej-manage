package com.miquankj.api.entity;

import lombok.Data;

import java.util.Date;
@Data
public class Customer {
    private Integer customerId;

    private String avator;

    private String nick;

    private Byte cusType;

    private Integer storeId;

    private String company;

    private String realname;

    private String phone;

    private String province;

    private String city;

    private String addrDetail;

    private Date jointime;

    private Long totalConsumer;

    private Integer totalOrder;

    private Byte status = 1;

    private String regIp;

    private Date lastLoginTime;

    private String lastLoginIp;

    private Integer score;

    private Integer continueLogin;

    private Boolean isLogin;

    private Boolean errLoginTimes;

}