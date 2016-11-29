/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved
 */

/*
 * 修订记录:
 * muyu@yiji.com 2016-07-25 17:45 创建
 *
 */
package com.vito16.jdk8.functionalinterface;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2016/07/25
 */
public class FunctionalClient {
    public FunctionalClient(FunctionalInterface functionalInterface) {
        
    }

    public String test(FunctionalInterface functionalInterface){
        return functionalInterface.say("ABC");
    }
}
