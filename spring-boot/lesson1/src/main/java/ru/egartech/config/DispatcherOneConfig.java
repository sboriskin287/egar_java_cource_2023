package ru.egartech.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherOneConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {WebConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {ConfigV1.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/one"};
    }

    @Override
    protected String getServletName() {
        return "dispatcher1";
    }
}
