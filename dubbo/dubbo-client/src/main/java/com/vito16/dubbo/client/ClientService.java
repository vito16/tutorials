package com.vito16.dubbo.client;
import com.vito16.dubbo.model.User;
import com.vito16.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by vito on 15-1-29.
 */
@Component
public class ClientService {

    @Autowired
    UserService userService;

    public User getUser(){
        return userService.getUser();
    }
}
