/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * muyu@yiji.com 2016-07-22 17:10 创建
 *
 */
package com.vito16.jdk8.defaultmethod;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2016/07/22
 */
public interface DefaultMethod {
    /**
     * 添加default关键字,并实现方法
     * @return
     */
    default String say() {
        return "默认字符";
    }
}
