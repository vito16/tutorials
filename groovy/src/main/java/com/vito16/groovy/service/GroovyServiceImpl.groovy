package com.vito16.groovy.service

import com.vito16.dubbo.model.User
import com.vito16.groovy.common.VelocityUtils

/**
 * @author 木鱼 muyu@yiji.com
 * @version 1.0.0
 */
class GroovyServiceImpl implements GroovyService {
    def userService;

    @Override
    User findOne(Integer id){
        def user = userService.findOne();
        user.id=id;
        return user;
    }

    @Override
    User findByCode(String code){
        GroovyShell shell = new GroovyShell()
        def user = shell.evaluate(code)
        return user;
    }

    @Override
    User findByDesc(String desc) {
        def codeStr = VelocityUtils.getGenCode("GroovyCode.vm","Vito Zhou");
        println codeStr
        GroovyShell shell = new GroovyShell()
        def user = shell.evaluate(codeStr)
        return user;
    }
}
