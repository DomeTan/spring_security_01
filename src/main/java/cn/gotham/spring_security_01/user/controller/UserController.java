package cn.gotham.spring_security_01.user.controller;

import cn.gotham.spring_security_01.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanchong
 * Create Date: 2020/3/9
 */
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/delete")
    public String delete(){
        userService.delete();
        return "delete";
    }

    @GetMapping("/create")
    public String create(){
        userService.create();
        return "create";
    }
}

