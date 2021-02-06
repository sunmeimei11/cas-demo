package com.qep.ssoclient.demo.controller;

import com.qep.ssoclient.demo.entity.User;
import com.qep.ssoclient.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: sunyl-b
 * @time: 2021/2/1 14:53
 * @summary: ""
 */
//@RestController
//@RequestMapping("/loginuser")
public class LoginController {

    @Autowired
    private LoginService loginService;

//    @RequestMapping("/login")
    public User login(User user) {
        return loginService.login(user);
    }

}
