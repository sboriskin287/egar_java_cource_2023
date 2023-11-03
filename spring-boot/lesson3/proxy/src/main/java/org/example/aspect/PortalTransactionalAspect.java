package org.example.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PortalTransactionalAspect {

    @Pointcut("@annotation(org.example.annotation.PortalTransactional)")
    public void pointcut(){}

    @Around("pointcut()")
    public String around(ProceedingJoinPoint pjp) throws Throwable {
        StringBuilder builder = new StringBuilder();
        builder
                .append("Open transaction ")
                .append(pjp.proceed())
                .append(" Close transaction");
        return builder.toString();
    }

    @Before("pointcut()")
    public void before() {
        System.out.println("executing before method in tx");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("executing after method in tx\n");
    }
}
