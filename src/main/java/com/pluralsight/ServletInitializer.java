package com.pluralsight;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WebConfig.class);
	}

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext context = createRootApplicationContext(servletContext);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("springDispatcherServlet", new DispatcherServlet(context));
        dispatcher.addMapping("/pdf/*" ,"/css/*", "*.html", "*.json", "*.xml");
        dispatcher.setLoadOnStartup(0);
    }



}
