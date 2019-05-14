package com.miquankj.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * 商品列表筛选条件
 * @author liuyadong
 * @since 2019/5/9
 */
@Data
public class GoodsConditiondto {

    @ApiModelProperty(value = "所属店铺", required = true)
    private String addBis;

    @ApiModelProperty(value = "商品名称", allowEmptyValue = true)
    private String comName;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开始创建时间 使用yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "结束创建时间 使用yyyy-MM-dd HH:mm:s")
    private Date endTime;

    @ApiModelProperty(value = "推荐 1 是 0 否", allowEmptyValue = true)
    private String recommend;

    @ApiModelProperty(value = "当前页码.从0开始", allowEmptyValue = true)
    private int pageNum = 0;

    @ApiModelProperty(value = "分页大小", allowEmptyValue = true)
    private int pageSize = 10;

    @ApiModelProperty(value = "商品状态 0 下架 1 上架 -1 删除", allowEmptyValue = true)
    private String state;

}
