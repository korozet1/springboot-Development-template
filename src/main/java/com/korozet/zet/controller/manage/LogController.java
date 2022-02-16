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

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.korozet.zet.service.LogService;
import com.korozet.zet.util.result.R;
import com.korozet.zet.entity.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author pigx code generator
 * @date 2021-04-22 14:15:26
 */
@RestController
@AllArgsConstructor
@RequestMapping("/zet/log" )
@Api(value = "log", tags = "系统日志管理")
public class LogController {

    private final LogService logService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param log 
     * @return
     */
    @ApiOperation(value = "分页查询日志", notes = "分页查询日志")
    @GetMapping("/page" )
    public R getLogPage(Page page, Log log) {
        return R.ok(logService.getLogPage(page,log));
    }


    /**
     * 通过id查询
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询日志", notes = "通过id查询日志")
    @GetMapping("/{id}" )
    public R getById(@PathVariable("id" ) Integer id) {
        return R.ok(logService.getById(id));
    }

    /**
     * 新增
     * @param log 
     * @return R
     */
    @ApiOperation(value = "新增日志", notes = "新增日志")
    @PostMapping
    public R save(@RequestBody Log log) {
        return R.ok(logService.save(log));
    }

    /**
     * 修改
     * @param log 
     * @return R
     */
    @ApiOperation(value = "修改日志", notes = "修改日志")
    @PutMapping
    public R updateById(@RequestBody Log log) {
        return R.ok(logService.updateById(log));
    }

    /**
     * 通过id删除
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除日志", notes = "通过id删除日志")
    @DeleteMapping("/{id}" )
    public R removeById(@PathVariable Integer id) {
        return R.ok(logService.removeById(id));
    }

}
