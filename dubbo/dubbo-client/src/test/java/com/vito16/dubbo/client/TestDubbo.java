package com.vito16.dubbo.client;

import com.vito16.dubbo.model.User;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by vito on 15-1-29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring.xml")
public class TestDubbo {

    @Autowired
    ClientService clientService;

    @Test
    public void test1(){
        User user = clientService.getUser();
        System.out.println(ToStringBuilder.reflectionToString(user));
    }
}
