package com.example.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @who luhaoming
 * @when 2022/4/9 14:21
 * @what 切面
 */
@Component
@Aspect
@Slf4j
public class NestAnnotationAspect {

    @Pointcut("@annotation(com.example.demo.aop.NestAnnotation)")
    public void nestAnnotation() {}

    @Around("nestAnnotation()")
    public Object nestAnnotationAop(ProceedingJoinPoint point) throws Throwable {
        Object proceed = point.getArgs();
        log.info("nestAnnotationAop==========" + proceed);
        return point.proceed();
    }
}
