/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * muyu@yiji.com 2016-11-29 10:26 创建
 *
 */
package com.vito16.design.factory;

import com.vito16.design.model.Product;
import com.vito16.design.model.ProductA;
import com.vito16.design.model.ProductB;

/**
 * 简单工厂模式
 *
 * @author 木鱼 muyu@yiji.com
 * @version 2016/11/29
 */
public class SimpleFactory {

    public static Product createProduct(String name){
        if(name.equals("A")) {
            return new ProductA();
        }
        if(name.equals("B")) {
            return new ProductB();
        }
        return null;
    }

}
