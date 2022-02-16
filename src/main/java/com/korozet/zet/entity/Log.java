/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package com.korozet.zet.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 
 *
 * @author pigx code generator
 * @date 2021-04-22 14:15:26
 */
@Data
@TableName("sys_log")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统日志表")
public class Log extends Model<Log> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value="主键")
    private Integer id;

    /**
     * 请求用户
     */
    @ApiModelProperty(value="请求用户")
    private String requestUser;

    /**
     * 执行时间
     */
    @ApiModelProperty(value="执行时间")
    private Integer time;

    /**
     * 请求地址
     */
    @ApiModelProperty(value="请求地址")
    private String requestUri;

    /**
     * 具体操作
     */
    @ApiModelProperty(value="具体操作")
    private String title;

    /**
     * 请求参数
     */
    @ApiModelProperty(value="请求参数")
    private String params;

    /**
     * 请求ip
     */
    @ApiModelProperty(value="请求ip")
    private String requestIp;

    /**
     * 请求代理人
     */
    @ApiModelProperty(value="请求代理人")
    private String userAgent;

    /**
     * 请求方式（GET,POST）
     */
    @ApiModelProperty(value="请求方式（GET,POST）")
    private String method;

    /**
     * 请求状态（1：异常，0正常）
     */
    @ApiModelProperty(value="请求状态（1：异常，0正常）")
    private String type;

    /**
     * 请求平台
     */
    @ApiModelProperty(value = "请求平台（1：一号风机平台，2:二号风机平台，3：三号风机平台）")
    private Integer requestPlatform;

    /**
     * 错误信息
     */
    @ApiModelProperty(value="错误信息")
    private String exception;

    /**
     * 日志创建时间
     */
    @ApiModelProperty(value = "日志创建时间")
    private LocalDateTime createTime;

    @TableField(exist = false)
    private String [] createTimes;

    @TableField(exist = false)
    private LocalDateTime startTime;

    @TableField(exist = false)
    private LocalDateTime endTime;

    @TableField(exist = false)
    private String platformName;
}
