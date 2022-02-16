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

package com.korozet.zet.controller.manage;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.korozet.zet.entity.RoleMenu;
import com.korozet.zet.service.RoleMenuService;
import com.korozet.zet.syslog.SysLog;
import com.korozet.zet.util.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author pigx code generator
 * @date 2021-04-28 14:19:39
 */
@RestController
@AllArgsConstructor
@RequestMapping("/zet/rolemenu" )
@Api(value = "rolemenu", tags = "管理")
public class RoleMenuController {

    private final RoleMenuService roleMenuService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param roleMenu 
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public R getRoleMenuPage(Page page, RoleMenu roleMenu) {
        return R.ok(roleMenuService.page(page, Wrappers.query(roleMenu)));
    }


    /**
     * 通过id查询
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(roleMenuService.getById(id));
    }

    /**
     * 新增
     * @param roleMenu 
     * @return R
     */
    @ApiOperation(value = "新增", notes = "新增")
    @SysLog("新增" )
    @PostMapping
    public R save(@RequestBody RoleMenu roleMenu) {
        return R.ok(roleMenuService.save(roleMenu));
    }

    /**
     * 修改
     * @param roleMenu 
     * @return R
     */
    @ApiOperation(value = "修改", notes = "修改")
    @SysLog("修改" )
    @PutMapping
    public R updateById(@RequestBody RoleMenu roleMenu) {
        return R.ok(roleMenuService.updateById(roleMenu));
    }

    /**
     * 通过id删除
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除", notes = "通过id删除")
    @SysLog("通过id删除" )
    @DeleteMapping("/{id}" )
    public R removeById(@PathVariable Long id) {
        return R.ok(roleMenuService.removeById(id));
    }

}
