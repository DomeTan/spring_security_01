package cn.gotham.spring_security_01.common.aspect;

import cn.gotham.spring_security_01.common.annotation.SystemLogRecordMonitor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 * @author tanchong
 * Create Date: 2020/3/9
 */
@Component
@Aspect
public class SystemLogAspect {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

//    @Pointcut("execution(* cn.gotham.spring_security_01.user.controller.*Controller.*(..))")
    @Pointcut("@annotation(cn.gotham.spring_security_01.common.annotation.SystemLogRecordMonitor)")
    public void pointCut() {

    }

    @Around(value = "pointCut()  && @annotation(systemLogRecordMonitor)")
    public Object recordSystemLog(ProceedingJoinPoint joinPoint, SystemLogRecordMonitor systemLogRecordMonitor ) throws Throwable {
        var startTime = System.currentTimeMillis();
        var format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(startTime));

        var result = joinPoint.proceed(joinPoint.getArgs());
        long endTime = System.currentTimeMillis();
        var value = systemLogRecordMonitor.value();
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        var username = authentication.getName();
        LOGGER.info("用户 [ {} ] 于 [ {} ]  访问了 [{}] 模块 耗时 {}/MS.",username,format,value,(endTime-startTime));
        return result;
    }

}
