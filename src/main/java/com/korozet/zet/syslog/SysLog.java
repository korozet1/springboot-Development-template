package com.korozet.zet.syslog;


import java.lang.annotation.*;

/**
 * 系统日志注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

    String value() default "";

    /**
     * 当类型等于1的时候，则重新赋值value
     * @return
     */
    String type() default "0";
}
