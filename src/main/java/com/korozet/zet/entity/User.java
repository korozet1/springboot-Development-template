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
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 
 *
 * @author pigx code generator
 * @date 2021-04-27 11:31:23
 */
@Data
@TableName("sys_user")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统用户表")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value="主键")
    private Integer id;

    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value="密码")
    private String password;

    /**
     * 用户真实名称
     */
    @ApiModelProperty(value="用户真实名称")
    private String nickName;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private LocalDateTime createTime;

    /**
     * 用户状态（0：有效 1：锁定）
     */
    @ApiModelProperty(value="用户状态（0：有效 1：锁定）")
    private Integer status;

    /**
     * 手机
     */
    @ApiModelProperty(value="手机")
    private String mobilePhone;


    /**
     * 逻辑删除（0存在1删除）
     */
    @ApiModelProperty(value="是否可以登录i")
    private Integer del;


    /**
     * 角色描述 文件超链接
     */
    @ApiModelProperty(value="角色描述 文件超链接")
    private String describe;

}
