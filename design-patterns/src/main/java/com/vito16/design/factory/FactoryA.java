/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * muyu@yiji.com 2016-11-29 10:43 创建
 *
 */
package com.vito16.design.factory;

import com.vito16.design.model.Product;
import com.vito16.design.model.ProductA;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2016/11/29
 */
public class FactoryA implements Factory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}
