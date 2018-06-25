package springdemo.xmlconfiguration.constructor_arg;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: weianyang
 * @Date: 2018/6/6 18:40
 * @Description: 在constructor_arg装配方案中，测试是否成功绑定xml中的bean
 */
//RunWith标签用于自动创建应用上下文
@RunWith(SpringJUnit4ClassRunner.class)
//指定加载配置项
@ContextConfiguration(locations = {"classpath:springdemo/xmlconfiguration/constructor_arg/config.xml"})
//指定Test运行的顺序
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConstructorArgTest {

    @Autowired
    @Qualifier("spiderMan_arg_name_clothes") //当有多个符合条件的bean时，需要使用此标签指定备选bean的ID
    private SpiderMan person;

    @Test
    public void say_spiderMan_arg_name_clothes(){
        System.out.println("run function say_spiderMan_arg_name_clothes");
        System.out.println(person.say());
    }

}
