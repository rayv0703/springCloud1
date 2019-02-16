package com.broada.one.listener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfig {
    @Bean
    public OnlineCount init(){
        return new OnlineCount();
    }
}
