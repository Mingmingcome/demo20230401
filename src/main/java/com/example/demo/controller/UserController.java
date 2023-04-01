package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @who luhaoming
 * @when 2020/7/27 17:35
 * @what 用户controller
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public int saveUser() {
        User user = new User();
        user.setUserId("2");
        user.setOrgCode("204");
        userService.saveUser(user);
        return 0;
    }
}
