package com.i2i.userandrole.service;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class ExecutionTimeAspect {

    @Around("@annotation(com.i2i.userandrole.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        var start = System.currentTimeMillis();
        var object = joinPoint.proceed();
        var end = System.currentTimeMillis();
        log.info("Execution time of " + joinPoint.getSignature().getName() + " :" + (end - start) + " ms");
        return object;
    }
}
