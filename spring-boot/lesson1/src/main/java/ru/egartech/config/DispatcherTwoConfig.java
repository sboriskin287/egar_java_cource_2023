package ru.egartech.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherTwoConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {ConfigV2.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/two"};
    }

    @Override
    protected String getServletName() {
        return "dispatcher2";
    }
}
