package com.broada.one.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class OnlineCount implements HttpSessionListener {

    public int count = 0;
    //监听session的创建
    public synchronized void createSession(HttpSessionEvent arg0){
        System.out.println("【HttpSessionListener监听器】count++  增加");
        count++;
        arg0.getSession().getServletContext().setAttribute("count", count);
    }
    @Override
    public synchronized void sessionDestroyed(HttpSessionEvent arg0) {
        //监听session的撤销
        System.out.println("【HttpSessionListener监听器】count--  减少");
        count--;
        arg0.getSession().getServletContext().setAttribute("count", count);
    }
}
