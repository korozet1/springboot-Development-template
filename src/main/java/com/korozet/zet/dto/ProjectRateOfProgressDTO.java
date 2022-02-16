package com.korozet.zet.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 后台管理工程进度管理查询数据传输类
 */
@Data
public class ProjectRateOfProgressDTO {

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "查询开始时间")
    private String startDate;

    /**
     * 查询解释时间
     */
    @ApiModelProperty(value = "查询解释时间")
    private String endDate;

    /**
     * 风机平台id
     */
    @ApiModelProperty(value = "风机平台id")
    private Integer platformId;
}
