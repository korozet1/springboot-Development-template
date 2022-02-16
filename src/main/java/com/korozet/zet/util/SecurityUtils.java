package com.korozet.zet.util;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.korozet.zet.entity.User;
import com.korozet.zet.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public final class SecurityUtils {

    private final UserService userService;

    public User getUser(){
        String userName= SecurityContextHolder.getContext().getAuthentication().getName();
        LambdaQueryWrapper<User> lambdaQuery= Wrappers.<User>lambdaQuery();
        lambdaQuery.eq(User::getUsername,userName);
        User user=userService.getOne(lambdaQuery);
        return user;
    }

}
