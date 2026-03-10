package com.example.foyer.configs;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspects {

    @After("execution(* com.example.foyer.Services.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method" + name + " : ");
    }

    @Before("execution(* com.example.foyer.Services.BlocServiceImpl.retrieveAllBlocs(..))")
    public void logMethodEntryBef(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("In method " + " : " + name );
    }
}
