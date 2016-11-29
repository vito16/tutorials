/*
 * www.yiji.com Inc.
 * Copyright (c) 2016 All Rights Reserved.
 */

/*
 * 修订记录：
 * muyu@yiji.com 2016-03-03 10:31 创建
 */
package com.vito16.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 2016/3/3
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    String home() {
        return "a";
    }

    @RequestMapping("/a")
    @ResponseBody
    String a() {
        return "hello a";
    }


    @RequestMapping("/a2")
    String a2() {
        return "a";
    }
}
