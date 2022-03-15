package com.example.task20.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    @Around("allServiceMethods()")
    public Object checkTimeExecution(ProceedingJoinPoint point) {
        long startTime = System.currentTimeMillis();
        Object result = null;
        try {
            result = point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        String methodName = point.getSignature().toShortString();
        Number timeMS = endTime - startTime;
        log.info("{} - {}ms", methodName, timeMS);
        return result;
    }
    @Pointcut("within(com.example.task20.service.*)")
    public void allServiceMethods() {}
}