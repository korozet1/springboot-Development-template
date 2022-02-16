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
import com.korozet.zet.dto.RoleDTO;
import com.korozet.zet.entity.Role;
import com.korozet.zet.service.RoleService;
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
 * @date 2021-04-19 16:37:39
 */
@RestController
@AllArgsConstructor
@RequestMapping("/zet/role" )
@Api(value = "role", tags = "角色管理")
public class RoleController {

    private final  RoleService roleService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param role 
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public R getRolePage(Page page, Role role) {
        return R.ok(roleService.page(page, Wrappers.query(role)));
    }


    /**
     * 通过id查询
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    public R getById(@PathVariable("id" ) Integer id) {
        return R.ok(roleService.getRoleInfById(id));
    }

    /**
     * 新增
     * @param roleDTO
     * @return R
     */
    @ApiOperation(value = "新增", notes = "新增")
    @SysLog("新增角色" )
    @PostMapping
    public R save(@RequestBody RoleDTO roleDTO) {
        return R.ok(roleService.saveRole(roleDTO));
    }

    /**
     * 修改
     * @param roleDTO
     * @return R
     */
    @ApiOperation(value = "修改", notes = "修改")
    @SysLog("修改角色信息" )
    @PutMapping
    public R updateById(@RequestBody RoleDTO roleDTO) {
        return R.ok(roleService.updateRoleById(roleDTO));
    }

    /**
     * 通过id删除
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除", notes = "通过id删除")
    @SysLog("通过id删除角色" )
    @DeleteMapping("/{id}" )
    public R removeById(@PathVariable Long id) {
        return R.ok(roleService.removeById(id));
    }

    /**
     * 获取角色列表
     * @return
     */
    @GetMapping("/getRoleList")
    public R getRoleList(){
        return R.ok(roleService.list());
    }
}
