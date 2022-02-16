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

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.korozet.zet.dto.UserDTO;
import com.korozet.zet.service.UserRoleService;
import com.korozet.zet.service.UserService;
import com.korozet.zet.util.result.R;
import com.korozet.zet.vo.SecurityUserVO;
import com.korozet.zet.dto.UserPageDTO;
import com.korozet.zet.entity.User;
import com.korozet.zet.entity.UserRole;
import com.korozet.zet.syslog.SysLog;
import com.korozet.zet.util.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


/**
 * 
 *
 * @author pigx code generator
 * @date 2021-04-27 11:31:23
 */
@RestController
@AllArgsConstructor
@RequestMapping("/zet/user" )
@Api(value = "user", tags = "用户管理")
public class UserController {

    private final UserService userService;


    private final UserRoleService userRoleService;

    private final SecurityUtils securityUtils;

    /**
     * 分页查询
     * @param page 分页对象
     * @param userPageDTO
     * @return
     */
    @ApiOperation(value = "用户分页查询", notes = "用户分页查询")
    @GetMapping("/page" )
    public R getUserPage(Page page, UserPageDTO userPageDTO) {
        return R.ok(userService.getUserByPage(page,userPageDTO));
    }

    /**
     * 通过用户名查询
     * @param userName 用户名
     * @return R
     */
    @ApiOperation(value = "通过用户名查询", notes = "通过用户名查询")
    @GetMapping("/getUserInfoByName")
    public String getUserInfoByName(String userName) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",userName);
        queryWrapper.last("limit 1");
        Integer id = userService.getOne(queryWrapper).getId();
        return id+"";
    }


    /**
     * 通过id查询
     * @param id id
     * @return R
     */
    @ApiOperation(value = "用户通过id查询", notes = "用户通过id查询")
    @GetMapping("/{id}" )
    public R getById(@PathVariable("id" ) Integer id) {
        return R.ok(userService.getUserInfo(id));

    }

    /**
     * 新增
     * @param userDTO
     * @return R
     */
    @ApiOperation(value = "用户新增", notes = "用户新增")
    @SysLog("新增用户" )
    @PostMapping
    public R save(@RequestBody UserDTO userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDTO, User.class);
        //检查用户名是否存在
        SecurityUserVO checkUser=userService.getUserByName(user.getUsername());
        if(checkUser!=null){
           return R.of(-1,"用户名已存在");
        }
        String password=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword("{bcrypt}"+password);
        user.setCreateTime(LocalDateTime.now());
        boolean save = userService.save(user);
        //绑定角色
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("limit 1");
        User one = userService.getOne(queryWrapper);
        UserRole userRole=new UserRole();
        userRole.setUserId(one.getId());
        userRole.setRoleId(userDTO.getRoleId());
        userRoleService.save(userRole);
        return R.ok(save);
    }

    /**
     * 新增
     * @param userDTO
     * @return R
     */
    @ApiOperation(value = "用户新增", notes = "用户新增")
    @SysLog("新增用户" )
    @GetMapping("/addUser")
    public R addUser(UserDTO userDTO) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDTO, User.class);
        //检查用户名是否存在
        SecurityUserVO checkUser=userService.getUserByName(user.getUsername());
        if(checkUser!=null){
            return R.of(-1,"用户名已存在");
        }
        String password=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword("{bcrypt}"+password);
        user.setCreateTime(LocalDateTime.now());
        boolean save = userService.save(user);
        //绑定角色
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.orderByDesc("id");
        queryWrapper.last("limit 1");
        User one = userService.getOne(queryWrapper);
        UserRole userRole=new UserRole();
        userRole.setUserId(one.getId());
        userRole.setRoleId(userDTO.getRoleId());
        userRoleService.save(userRole);
        return R.ok(save);
    }

    /**
     * 修改
     * @param user 
     * @return R
     */
    @ApiOperation(value = "用户修改", notes = "用户修改")
    @SysLog("修改用户" )
    @PutMapping
    public R updateById(@RequestBody User user) {
        String password=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword("{bcrypt}"+password);
        return R.ok(userService.updateById(user));
    }

    /**
     * 修改（外部调用）
     * @param user
     * @return R
     */
    @ApiOperation(value = "用户修改", notes = "用户修改")
    @SysLog("修改用户" )
    @GetMapping("/editPwd")
    public R editPwd(User user) {
        String password=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword("{bcrypt}"+password);
        return R.ok(userService.updateById(user));
    }

    /**
     * 通过id删除
     * @param id id
     * @return R
     */
    @ApiOperation(value = "用户通过id删除", notes = "用户通过id删除")
    @SysLog("通过id删除用户" )
    @DeleteMapping("/{id}" )
    public R removeById(@PathVariable Integer id) {
        return R.ok(userService.removeById(id));
    }

    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/getUserInfo")
    @ApiOperation(value = "获取信息",notes = "获取用户信息")
    public R getUserInfo(){
        return R.ok(userService.getUserInfoById(securityUtils.getUser().getId()));
    }

    /**
     * 获取所有用户
     * @return
     */
    @GetMapping("/getUserList")
    @ApiOperation(value = "获取所有用户",notes = "获取所有用户")
    public R getUserList(){
        return R.ok(userService.list());
    }
}
