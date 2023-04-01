package com.example.demo.service.impl;

import com.example.demo.aop.NestAnnotation;
import com.example.demo.dao.TestMapper;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @who luhaoming
 * @when 2020/7/27 16:09
 * @what 测试Service实现
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Override
    @NestAnnotation
    public String test() {
        return testMapper.test();
    }
}
