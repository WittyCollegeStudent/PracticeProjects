package springdemo.explicitconfig;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Objects;


/**
 * @Author: weianyang
 * @Date: 2018/6/6 18:40
 * @Description: 显示配置Bean
 */
//RunWith标签用于自动创建应用上下文
@RunWith(SpringJUnit4ClassRunner.class)
//指定加载配置项
@ContextConfiguration(classes = Config.class)
//指定Test运行的顺序
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExplictConfigTest {

    @Autowired
//    @Qualifier("spiderman")
    private Person braveman;

    @Autowired
    @Qualifier("officeWithBraveman")
    private Office office;

    @Autowired
    @Qualifier("officeWithBraveman2")
    private Office office2;

    @Test
    public void officeEqualsOffice2(){
        System.out.println("office equals office2 : " + (Objects.equals(office, office2)));
    }

    @Test
    public void getBravemanDetails(){
        System.out.println("braveman is NULL : " + (braveman == null));
        System.out.println("braveman type is : " + (braveman.getClass()));
        System.out.println("braveman says : " + braveman.say());
    }

    @Test
    public void getOfficeDetails(){
        System.out.println("office is NULL : " + (office == null));
        System.out.println("office type is : " + (office.getClass()));
        System.out.println("office man says : " + office.getPerson().say());
    }

}
