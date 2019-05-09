package com.miquankj.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 类别dto
 * @author liuyadong
 * @since 2019/5/9
 */
@Data
public class Branddto {
    @ApiModelProperty(value = "id", required = true)
    private Integer id;

    @ApiModelProperty(value = "上级id",required = true)
    private Integer subId;

    @ApiModelProperty(value = "商品类别：1-一级 2-二级",required = true)
    private Integer brandType;

    @ApiModelProperty(value = "类目名称",required = true)
    private String name;

    @ApiModelProperty(value = "下级类目列表",allowEmptyValue = true)
    private List<Branddto> branddtoList = new ArrayList<>();
}
