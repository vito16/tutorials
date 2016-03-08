import com.vito16.dubbo.model.User;
import com.vito16.groovy.service.GroovyService;
import groovy.lang.GroovyShell;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

/**
 * @author 木鱼 muyu@yiji.com
 * @version 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring.xml")
public class TestGroovyOnSpring {

    @Autowired
    GroovyService groovyService;

    @Test
    public void testRunInjectServiceMethod(){
        User user = groovyService.findOne(2);
        System.out.println("user:"+ToStringBuilder.reflectionToString(user));
        Assert.notNull(user, "user can't be null");
    }

    @Test
    public void testRunCustomCode(){
        String code =
                "import org.springframework.context.support.ClassPathXmlApplicationContext\n" +
                "def ctx = new ClassPathXmlApplicationContext('spring.xml')\n" +
                "println ctx\n"+
                "def userService = ctx.getBean('userService')\n" +
                "println userService\n"+
                "def user = userService.findOne(12)\n"+
                "println user\n"+
                "return user";
        User user = groovyService.findByCode(code);
        System.out.println("user:" + ToStringBuilder.reflectionToString(user));
    }
    @Test
    public void testQueryCustomerCard(){
        String code =
                "import org.springframework.context.support.ClassPathXmlApplicationContext\n" +
                        "def ctx = new ClassPathXmlApplicationContext('spring.xml')\n" +
                        "println ctx\n"+
                        "def cardQueryService = ctx.getBean('cardQueryService')\n" +
                        "println cardQueryService\n"+
                        "def result = cardQueryService.findDefaultCardByUserId('123')\n"+
                        "println result\n"+
                        "return result";
        GroovyShell shell = new GroovyShell();
        shell.evaluate(code);
    }

    @Test
    public void testRun(){
        User user = groovyService.findByDesc("heihei");
        System.out.println(user);
    }

}
