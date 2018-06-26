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
    private Person braveman1;

    @Autowired
    @Qualifier("braveman2")
    private Person braveman2;

    @Autowired
    @Qualifier("spiderMan") //当有多个符合条件的bean时，需要使用此标签指定备选bean的ID
    private Person spiderman;

    @Test
    public void personShouldNotBeNULL(){
        System.out.println("braveman1 is NULL : " + (braveman1 == null));
        System.out.println("braveman1 type is : " + (braveman1.getClass()));
        System.out.println("braveman1 name is : " + (braveman1.getClass().getCanonicalName()));
        braveman1.say();
    }

    /**
     * 判断braveman1和braveman2是否是同一个对象
     */
    @Test
    public void braveman1EqualsBraveman2(){
        System.out.println("braveman1 equals braveman2 : " + (braveman1.equals(braveman2)));
    }

    /**
     * 判断person和person2之间是否是同一个对象
     */
    @Test
    public void personEqualsPerson2(){
        System.out.println("braveman1 == spiderman : " + (braveman1 == spiderman));
        System.out.println("------BEFORE SET PERSON NAME------");
        System.out.println("braveman1 name : " + (braveman1.getName()));
        System.out.println("spiderman name : " + (spiderman.getName()));
        braveman1.setName("braveman1");
        System.out.println("------AFTER SET PERSON NAME------");
        System.out.println("braveman1 name : " + (braveman1.getName()));
        System.out.println("spiderman name : " + (spiderman.getName()));
    }

}
