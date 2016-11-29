package com.vito16.groovy.executor;

import groovy.lang.GroovyShell;
import org.codehaus.groovy.groovydoc.GroovyAnnotationRef;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 1.0.0
 */
public class RoleExcutor  implements Executor {
    @Override
    public void execute(String runableCode) {
        GroovyShell shell = new GroovyShell();
        shell.evaluate(runableCode);
    }
}
