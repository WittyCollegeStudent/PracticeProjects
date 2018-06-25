package springdemo.verifyautowired;

import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: weianyang
 * @Date: 2018/6/6 18:40
 * @Description: 验证自动装配
 */
//RunWith标签用于自动创建应用上下文
@RunWith(SpringJUnit4ClassRunner.class)
//指定加载配置项
@ContextConfiguration(classes = ScanConfig.class)
//指定Test运行的顺序
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VerifyAutoWired {

    @Rule
    public final SystemOutRule log = new SystemOutRule();

    {
        log.enableLog();
    }

    @Autowired
    @Qualifier("braveman1") //当有多个符合条件的bean时，需要使用此标签指定备选bean的ID
    private Person person;

    /**
     * 用日志类判断输出是否和实际相同
     */
    @Test
    public void say(){
        person.setName("person");
        System.out.println(person.say());
        assertEquals("I am a brave man.\r\n", log.getLog());
    }

}
