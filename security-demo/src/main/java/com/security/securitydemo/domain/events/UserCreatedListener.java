package com.security.securitydemo.domain.events;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
class UserCreatedListener implements ApplicationListener<UserCreated> {

    @Override
    @Async
    public void onApplicationEvent(UserCreated event) {
        // handle UserCreatedEvent
        System.out.println("Listening user created Event :"+event);
    }
}