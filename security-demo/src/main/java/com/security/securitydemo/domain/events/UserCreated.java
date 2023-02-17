package com.security.securitydemo.domain.events;

import com.security.securitydemo.models.User;
import org.springframework.context.ApplicationEvent;

public class UserCreated extends ApplicationEvent {

    public UserCreated(User source) {
        super(source);
    }
}
