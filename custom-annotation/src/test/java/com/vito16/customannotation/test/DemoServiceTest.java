package com.vito16.customannotation.test;

import com.vito16.customannotation.App;
import com.vito16.customannotation.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2017/11/09
 */
@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class DemoServiceTest {

    @Autowired
    DemoService demoService;


    @Test
    public void test(){
        demoService.test();
    }
}
