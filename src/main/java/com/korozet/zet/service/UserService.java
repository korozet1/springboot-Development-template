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

package com.korozet.zet.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.korozet.zet.vo.UserInfoVO;
import com.korozet.zet.vo.UserPageVO;
import com.korozet.zet.dto.UserPageDTO;
import com.korozet.zet.entity.User;
import com.korozet.zet.vo.SecurityUserVO;
import com.korozet.zet.vo.UserVO;

/**
 * 
 *
 * @author pigx code generator
 * @date 2021-04-27 11:31:23
 */
public interface UserService extends IService<User> {

    //根据id获取用户
    UserVO getUserInfoById(Integer id);

    //根据用户名获取用户
    SecurityUserVO getUserByName(String userName);

    //分页查询用户列表
    Page<UserPageVO> getUserByPage(Page page, UserPageDTO userPageDTO);

    //获取用户信息
    UserInfoVO getUserInfo(Integer id);
}
