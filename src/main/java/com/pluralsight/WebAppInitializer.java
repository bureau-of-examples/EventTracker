package com.pluralsight;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext context = getWebApplicationContext();
      //  servletContext.addListener(new ContextLoaderListener(context));//causing error listener start
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("springDispatcherServlet", new DispatcherServlet(context));
        dispatcher.addMapping("*.html", "/pdf/**" ,"/css/**", "*.json", "*.xml");
        dispatcher.setLoadOnStartup(0);
    }

    private AnnotationConfigWebApplicationContext getWebApplicationContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("com.pluralsight.WebConfig");
        return context;
    }
}
