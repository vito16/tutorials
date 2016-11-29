import com.vito16.groovy.common.Constants;
import com.vito16.groovy.common.VelocityUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.test.context.ContextConfiguration;

import java.io.StringWriter;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 1.0.0
 */
@RunWith(BlockJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring.xml")
public class TestGenCode {

    @Test
    public void testRunInjectServiceMethod() {
        Template template = VelocityUtils.getTemplate("GroovyCode.vm");

        VelocityContext context = new VelocityContext();
        context.put("name", "VitoZhou");

        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        System.out.println(writer.toString());
    }

}
