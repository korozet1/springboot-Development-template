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
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 
 *
 * @author pigx code generator
 * @date 2021-04-27 14:37:16
 */
@Data
@TableName("sys_menu")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "系统菜单表")
public class Menu extends Model<Menu> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value="主键")
    private Integer id;

    /**
     * 请求地址
     */
    @ApiModelProperty(value="请求地址")
    private String url;

    /**
     * 菜单名称
     */
    @ApiModelProperty(value="菜单名称")
    private String menuName;

    /**
     * 父级菜单id
     */
    @ApiModelProperty(value="父级菜单id")
    private Integer parentId;

    /**
     * 菜单图标
     */
    @ApiModelProperty(value="菜单图标")
    private String icon;

    /**
     * 菜单排序
     */
    @ApiModelProperty(value="菜单排序")
    private Integer sort;

    /**
     * 菜单创建时间
     */
    @ApiModelProperty(value="菜单创建时间")
    private LocalDateTime createTime;

    /**
     * 菜单修改时间
     */
    @ApiModelProperty(value="菜单修改时间")
    private LocalDateTime updateTime;

}
