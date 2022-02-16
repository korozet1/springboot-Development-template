package com.korozet.zet.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "项目管理页面头部信息")
public class ProjectHeadInfoVO {

    /**
     * 建设项目数量
     */
    @ApiModelProperty(value = "建设项目数量")
    private Integer projectNum;

    /**
     * 整体完工计划周期
     */
    @ApiModelProperty(value = "整体完工计划周期")
    private String finishCycle;

    /**
     * 实际动工时间
     */
    @ApiModelProperty(value = "实际动工时间")
    private String startTime;
}
