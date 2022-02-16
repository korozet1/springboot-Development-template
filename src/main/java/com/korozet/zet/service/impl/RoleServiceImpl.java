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

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.korozet.zet.mapper.RoleMapper;
import com.korozet.zet.service.RoleService;
import com.korozet.zet.vo.RoleInfoVO;
import com.korozet.zet.dto.RoleDTO;
import com.korozet.zet.entity.Role;
import com.korozet.zet.entity.RoleMenu;
import com.korozet.zet.service.RoleMenuService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 *
 * @author pigx code generator
 * @date 2021-04-19 16:37:39
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMenuService roleMenuService;

    @Override
    public RoleInfoVO getRoleInfById(Integer id) {
        return baseMapper.getRoleInfoById(id);
    }

    @Override
    @Transactional
    public boolean updateRoleById(RoleDTO roleDTO) {
        ModelMapper modelMapper=new ModelMapper();
        LambdaQueryWrapper<RoleMenu> lambdaQuery = Wrappers.<RoleMenu>lambdaQuery();
        lambdaQuery.eq(RoleMenu::getRoleId,roleDTO.getId());
        roleMenuService.remove(lambdaQuery);
        Role role=modelMapper.map(roleDTO,Role.class);
        baseMapper.updateById(role);
        Integer [] menuIds=roleDTO.getMenuIds();
        for (Integer menuId : menuIds) {
            RoleMenu roleMenu=new RoleMenu();
            roleMenu.setPermissionId(menuId);
            roleMenu.setRoleId(roleDTO.getId());
            roleMenuService.save(roleMenu);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean saveRole(RoleDTO roleDTO) {
        ModelMapper modelMapper=new ModelMapper();
        Role role=modelMapper.map(roleDTO,Role.class);
        baseMapper.insert(role);
        Integer [] menuIds=roleDTO.getMenuIds();
        for (Integer menuId : menuIds) {
            RoleMenu roleMenu=new RoleMenu();
            roleMenu.setPermissionId(menuId);
            roleMenu.setRoleId(role.getId());
            roleMenuService.save(roleMenu);
        }
        return true;
    }
}
