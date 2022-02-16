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
package com.korozet.zet.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.korozet.zet.mapper.UserMapper;
import com.korozet.zet.service.UserService;
import com.korozet.zet.vo.SecurityUserVO;
import com.korozet.zet.vo.UserInfoVO;
import com.korozet.zet.vo.UserPageVO;
import com.korozet.zet.vo.UserVO;
import com.korozet.zet.dto.UserPageDTO;
import com.korozet.zet.entity.User;
import org.springframework.stereotype.Service;

/**
 * 
 *
 * @author pigx code generator
 * @date 2021-04-27 11:31:23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public UserVO getUserInfoById(Integer id) {
        return baseMapper.getUserInfoById(id);
    }

    @Override
    public SecurityUserVO getUserByName(String userName) {
        return baseMapper.getUserByName(userName);
    }

    @Override
    public Page<UserPageVO> getUserByPage(Page page, UserPageDTO userPageDTO) {
        return baseMapper.getUserByPage(page,userPageDTO);
    }

    @Override
    public UserInfoVO getUserInfo(Integer id) {
        return baseMapper.getUserInfo(id);
    }
}
