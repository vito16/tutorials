package com.vito16.dubbo.service.impl;
import com.vito16.dubbo.model.User;
import com.vito16.dubbo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by vito on 15-1-29.1
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public User getUser() {
        User user = new User();
        user.setId(1);
        user.setName("Vito");
        return user;
    }
}
