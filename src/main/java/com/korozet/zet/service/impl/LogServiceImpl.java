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

import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.korozet.zet.service.LogService;
import com.korozet.zet.entity.Log;
import com.korozet.zet.mapper.LogMapper;
import com.korozet.zet.util.DateUtil;
import org.springframework.stereotype.Service;


/**
 * 
 *
 * @author pigx code generator
 * @date 2021-04-22 14:15:26
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {


    @Override
    public Page<Log> getLogPage(Page page, Log log) {
        if(ArrayUtil.isNotEmpty(log.getCreateTimes())){
            if(log.getCreateTimes().length==1){
                log.setStartTime(DateUtil.stringToLocalTime(log.getCreateTimes()[0]));
            }
            else if(log.getCreateTimes().length==2){
                log.setStartTime(DateUtil.stringToLocalTime(log.getCreateTimes()[0]));
                log.setEndTime((DateUtil.stringToLocalTime(log.getCreateTimes()[1])));
            }
        }
        return baseMapper.getLogPage(page,log);
    }
}
