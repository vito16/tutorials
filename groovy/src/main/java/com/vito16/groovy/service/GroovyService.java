package com.vito16.groovy.service;

import com.vito16.dubbo.model.User;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 1.0.0
 */

public interface GroovyService {
    User findOne(Integer id);
    User findByCode(String code);
    User findByDesc(String desc);
}
