package cn.gotham.spring_security_01.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * 基础控制器
 * @author tanchong
 * Create Date: 2020/3/8
 */
@Controller
@Api(value = "基础 Api接口",tags = "base")
public class BaseController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "首页",notes = "成功登录首页访问接口")
    @GetMapping("/")
    public String index(){
        return "web/index";
    }

    @ApiOperation(value = "登录页面",notes = "登录页面接口")
    @GetMapping("/login")
    public String login(){
        LOGGER.info("登录页面");
        return "web/login/login";
    }
}
