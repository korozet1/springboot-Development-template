package com.korozet.zet.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeviceVo {

    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value="id")
    private Integer id;

    /**
     * 设备编号
     */
    @ApiModelProperty(value="设备编号")
    private String deviceNo;

    /**
     * 平台id
     */
    @ApiModelProperty(value="平台id")
    private String platformName;

    /**
     * 设备状态 0：正常 1：故障 2：离线 3：停机
     */
    @ApiModelProperty(value="设备状态 0：正常 1：故障 2：离线 3：停机")
    private Integer deviceStatus;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;

    /**
     * 是否固定点位（1：是 2：否）
     */
    private Integer fixedPointFlag;

    /**
     * 安装位置
     */
    @ApiModelProperty(value="安装位置")
    private String installAddress;
}
