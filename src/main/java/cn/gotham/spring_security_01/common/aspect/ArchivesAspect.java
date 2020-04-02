package cn.gotham.spring_security_01.common.aspect;

import cn.gotham.spring_security_01.asset.bean.ParamFlag;
import cn.gotham.spring_security_01.asset.model.Asset;
import cn.gotham.spring_security_01.asset.repository.AssetRepository;
import cn.gotham.spring_security_01.common.annotation.ArchivesMonitor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author tanchong
 * Create Date: 2020/3/22
 */
@Component
@Aspect
public class ArchivesAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArchivesAspect.class);

    private AssetRepository assetRepository;

    public ArchivesAspect(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Pointcut("@annotation(cn.gotham.spring_security_01.common.annotation.ArchivesMonitor)")
    public void pointCut(){}


    @Around(value = "pointCut() && @annotation(archivesMonitor)")
    public Object takeNote(ProceedingJoinPoint proceedingJoinPoint, ArchivesMonitor archivesMonitor) throws Throwable {
        var args = proceedingJoinPoint.getArgs();
        // 让代理方法先执行
        for (Object arg : args) {
            LOGGER.info("这是 : Around :: {}",arg);
            if (arg instanceof Asset) {
                Asset asset = (Asset) arg;
                LOGGER.info("asset name :: {}",asset.getName());
            }
        }
        var result = proceedingJoinPoint.proceed(args);
        LOGGER.info("result {}",result);

        return result;
    }


}
