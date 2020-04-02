package cn.gotham.spring_security_01.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 系统日志记录监控器
 * @author tanchong
 * Create Date: 2020/3/9
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemLogRecordMonitor {

    /**
     * 模块信息
     */
    String value();
}
