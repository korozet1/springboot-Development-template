package com.korozet.zet.service.impl;

import cn.hutool.core.util.URLUtil;
import com.korozet.zet.mapper.UserMapper;
import com.korozet.zet.service.LogService;
import com.korozet.zet.syslog.SysLogUtil;
import com.korozet.zet.vo.MenuVO;
import com.korozet.zet.vo.SecurityUserVO;
import com.korozet.zet.entity.Log;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserMapper userMapper;

    private final LogService logService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //插入日志
        HttpServletRequest request = ((ServletRequestAttributes) Objects
                .requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        Log log=new Log();
        log.setTitle(s+"登录系统");
        log.setRequestIp(SysLogUtil.getIpAddress(request));
//        log.setRequestPlatform(Integer.parseInt(request.getHeader("platform")));
        log.setCreateTime(LocalDateTime.now());
        log.setRequestUser(s);
        log.setType("0");
        log.setUserAgent(request.getHeader("user-agent"));
        log.setMethod(request.getMethod());
        log.setRequestUri(URLUtil.getPath(request.getRequestURI()));
        logService.save(log);
        SecurityUserVO user=userMapper.getUserByName(s);
       List<GrantedAuthority> authorities = new ArrayList<>();
        List<MenuVO> list=user.getMenus();
        for (MenuVO menu : list) {
            authorities.add(new SimpleGrantedAuthority(menu.getUrl()));
        }
        return new User(user.getUsername(),user.getPassword(),authorities);
    }
}
