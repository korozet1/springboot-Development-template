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

package com.korozet.zet.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.korozet.zet.vo.SecurityUserVO;
import com.korozet.zet.vo.UserInfoVO;
import com.korozet.zet.vo.UserPageVO;
import com.korozet.zet.vo.UserVO;
import com.korozet.zet.dto.UserPageDTO;
import com.korozet.zet.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 *
 * @author pigx code generator
 * @date 2021-04-27 11:31:23
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    SecurityUserVO getUserByName(@Param(value = "userName") String userName);


    UserVO getUserInfoById(@Param(value = "id") Integer id);


    Page<UserPageVO> getUserByPage(@Param(value = "page") Page page,
                                   @Param(value = "userPageDTO") UserPageDTO userPageDTO);

    UserInfoVO getUserInfo(@Param(value = "id") Integer id);
}
