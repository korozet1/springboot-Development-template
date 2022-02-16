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

import com.korozet.zet.service.MenuService;
import com.korozet.zet.syslog.SysLog;
import com.korozet.zet.util.result.R;
import com.korozet.zet.vo.MenuVO;
import com.korozet.zet.entity.Menu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 
 *
 * @author pigx code generator
 * @date 2021-04-27 14:37:16
 */
@RestController
@AllArgsConstructor
@RequestMapping("/zet/menu" )
@Api(value = "menu", tags = "菜单管理")
public class MenuController {

    private final MenuService menuService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param menu 
     * @return
     */
    @ApiOperation(value = "分页查询菜单", notes = "分页查询菜单")
    @GetMapping("/page" )
    public R getMenuPage(Page page, Menu menu) {
        return R.ok(menuService.page(page, Wrappers.query(menu)));
    }


    /**
     * 通过id查询
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询菜单", notes = "通过id查询菜单")
    @GetMapping("/{id}" )
    public R getById(@PathVariable("id" ) Integer id) {
        return R.ok(menuService.getById(id));
    }

    /**
     * 新增
     * @param menu 
     * @return R
     */
    @ApiOperation(value = "新增菜单", notes = "新增菜单")
    @SysLog("新增菜单" )
    @PostMapping
    public R save(@RequestBody Menu menu) {
        return R.ok(menuService.save(menu));
    }

    /**
     * 修改
     * @param menu 
     * @return R
     */
    @ApiOperation(value = "修改菜单", notes = "修改菜单")
    @SysLog("修改菜单" )
    @PutMapping
    public R updateById(@RequestBody Menu menu) {
        return R.ok(menuService.updateById(menu));
    }

    /**
     * 通过id删除
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除菜单", notes = "通过id删除菜单")
    @SysLog("通过id删除菜单" )
    @DeleteMapping("/{id}" )
    public R removeById(@PathVariable Integer id) {
        return R.ok(menuService.removeById(id));
    }


    /**
     * 菜单列表
     * @return
     */
    @GetMapping("/getMenuList")
    @ApiOperation(value = "不分页查询菜单列表",notes = "不分页查询菜单列表")
    public R getMenuList(){
        ModelMapper modelMapper=new ModelMapper();
        List<Menu> menuList =menuService.list();
        List<MenuVO> menuVOList=modelMapper.map(menuList,new TypeToken<List<MenuVO>>(){}.getType());
        return R.ok(menuVOList);
    }
}
