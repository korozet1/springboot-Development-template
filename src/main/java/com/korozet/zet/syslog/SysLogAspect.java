package com.korozet.zet.syslog;


import com.google.gson.Gson;
import com.korozet.zet.service.LogService;
import com.korozet.zet.entity.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
@Slf4j
public class SysLogAspect {

    @Autowired
    private LogService logService;


    @Pointcut("@annotation(com.korozet.zet.syslog.SysLog)")
    public void logPointCut() {

    }

    /**
     * 环绕通知 @Around ， 当然也可以使用 @Before (前置通知) @After (后置通知)
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = null;
        long time = System.currentTimeMillis() - beginTime;
        String type="";
        String exception="";
        try {
           type="0";
           result=point.proceed();
        } catch (Exception e) {
            type="1";
            exception=e.getMessage();
            throw e;
        }finally {
            saveLog(point,time,type,exception);
        }
        return result;
    }


    /**
     * 日志入库
     * @param point
     * @param time
     * @param type
     * @param exception
     */
    private void saveLog(ProceedingJoinPoint point,long time,String type,String exception){
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        String strClassName = point.getTarget().getClass().getName();
        String strMethodName = point.getSignature().getName();
        log.debug("[类名]:{},[方法]:{}", strClassName, strMethodName);
        Log sysLogDTO=SysLogUtil.getSysLog();
        sysLogDTO.setType(type);
        sysLogDTO.setException(exception);
        sysLogDTO.setCreateTime(LocalDateTime.now());
        sysLogDTO.setTime((int) time);
        Object[] args=point.getArgs();
        try {
            List<String> list=new ArrayList<>();
            for (Object arg : args) {
                list.add(new Gson().toJson(arg));
            }
            sysLogDTO.setParams(list.toString());
        }catch (Exception e){

        }
        SysLog sysLog = method.getAnnotation(SysLog.class);
        if (sysLog != null) {
            sysLogDTO.setTitle(sysLog.value());
        }
        logService.save(sysLogDTO);
    }
}
