package com.vito16.springboot.test;

import com.vito16.springboot.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;

import javax.sql.DataSource;

/**
 * Created by vito on 16/7/5.
 */
@SpringApplicationConfiguration(classes = Main.class)
public class DbTest {

    @Autowired
    DataSource dataSource;

    @Test
    public void testDb(){
        System.out.println(dataSource.toString());
    }
}
