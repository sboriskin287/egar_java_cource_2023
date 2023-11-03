package org.example.aspect;

import org.example.annotation.PortalTransactional;
import org.example.service.ProfileService;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

//@Component
public class PortalTransactionalBeanPostProcessor
        implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(PortalTransactional.class)) {
            return doProxy(bean);
        } else {
            return bean;
        }
    }

    private Object doProxy(Object bean) {
        ProxyFactory pf = new ProxyFactory(bean);
        pf.addAdvisor(new DefaultPointcutAdvisor(
                new AnnotationMatchingPointcut(PortalTransactional.class, PortalTransactional.class),
                (org.aopalliance.intercept.MethodInterceptor) invocation -> {
                    StringBuilder builder = new StringBuilder();
                    builder
                            .append("Open transaction ")
                            .append(invocation.proceed())
                            .append(" Close transaction");
                    return builder.toString();
                }
        ));
        return pf.getProxy();
    }
}
