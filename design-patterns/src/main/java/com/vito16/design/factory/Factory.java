/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * muyu@yiji.com 2016-11-29 10:40 创建
 *
 */
package com.vito16.design.factory;

import com.vito16.design.model.Product;

/**
 * 工厂方法模式
 *
 * @author 木鱼 muyu@yiji.com
 * @version 2016/11/29
 */
public interface Factory {

    /**
     * 创建产品
     * @return
     */
    Product createProduct();

}
