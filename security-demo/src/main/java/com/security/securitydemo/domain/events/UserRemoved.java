package com.security.securitydemo.domain.events;

import com.security.securitydemo.models.User;
import org.springframework.context.ApplicationEvent;

public class UserRemoved extends ApplicationEvent {

    public UserRemoved(User source) {
        super(source);
    }
}
