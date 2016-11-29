/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * muyu@yiji.com 2016-11-29 10:34 创建
 *
 */
package com.vito16.design.test;

import com.vito16.design.factory.SimpleFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2016/11/29
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class SimpleFactoryTest {

    @BeforeClass
    public static void say(){
        System.out.println("简单工厂测试");
    }

    @Test
    public void testProductA(){
        SimpleFactory.createProduct("A").use();
    }
    @Test
    public void testProductB(){
        SimpleFactory.createProduct("B").use();
    }

}
