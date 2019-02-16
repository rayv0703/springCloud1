package com.broada.one.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String contextPath = context.getContextPath();
        System.out.println(contextPath);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
