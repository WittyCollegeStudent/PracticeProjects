package springdemo.beanwired;

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
 * @Description: 测试是否自动绑定成功
 */
//RunWith标签用于自动创建应用上下文
@RunWith(SpringJUnit4ClassRunner.class)
//指定加载配置项
@ContextConfiguration(classes = ScanConfig.class)
//指定Test运行的顺序
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BeanWiredTest {

    @Autowired
    @Qualifier("braveman1") //当有多个符合条件的bean时，需要使用此标签指定备选bean的ID
    private Person person;

    @Autowired
    @Qualifier("braveman1") //当有多个符合条件的bean时，需要使用此标签指定备选bean的ID
    private Person person2;

    @Test
    public void personShouldNotBeNULL(){
        System.out.println("person is NULL : " + (person == null));
        System.out.println("person type is : " + (person.getClass()));
        System.out.println("person name is : " + (person.getClass().getCanonicalName()));
        person.say();
    }

    /**
     * 判断person和person2之间是否是同一个对象
     */
    @Test
    public void personEqualsPerson2(){
        System.out.println("person == person2 : " + (person == person2));
        System.out.println("------BEFORE SET PERSON NAME------");
        System.out.println("person name : " + (person.getName()));
        System.out.println("person2 name : " + (person2.getName()));
        person.setName("person");
        System.out.println("------AFTER SET PERSON NAME------");
        System.out.println("person name : " + (person.getName()));
        System.out.println("person2 name : " + (person2.getName()));
    }

}
