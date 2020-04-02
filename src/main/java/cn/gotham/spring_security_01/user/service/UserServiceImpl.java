package cn.gotham.spring_security_01.user.service;

import cn.gotham.spring_security_01.common.annotation.SystemLogRecordMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author tanchong
 * Create Date: 2020/3/9
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @SystemLogRecordMonitor("删除")
    @Override
    public void delete() {
        LOGGER.info("一级 delete");
    }

    @SystemLogRecordMonitor("创建")
    @Override
    public void create() {
        LOGGER.info("一级 create");
    }

    @SystemLogRecordMonitor("更新")
    @Override
    public void update() {
        LOGGER.info("一级 update");
    }

    @SystemLogRecordMonitor("获取全部")
    @Override
    public void getAll() {
        LOGGER.info("一级 getAll");
    }
}
