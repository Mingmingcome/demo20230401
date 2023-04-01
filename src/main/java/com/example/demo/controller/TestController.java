package com.example.demo.controller;

import com.example.demo.aop.NestAnnotation;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @who luhaoming
 * @when 2020/7/27 16:06
 * @what 测试controller
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("/test")
    public String test() {
        return testService.test();
    }

    @RequestMapping("/test2")
    public String test2() {
        System.out.println(1);
        return this.test();
    }
}
