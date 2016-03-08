package com.vito16.groovy.common;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 1.0.0
 */
public class VelocityUtils {
    public static Template getTemplate(String vmName) {
        VelocityEngine engine = new VelocityEngine();
        engine.init();
        return engine.getTemplate(Constants.VM_DIR + vmName);
    }

    public static String getGenCode(String vmName,String code){
        Template template = VelocityUtils.getTemplate(vmName);

        VelocityContext context = new VelocityContext();
        context.put("name", code);

        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        return writer.toString();
    }

}
