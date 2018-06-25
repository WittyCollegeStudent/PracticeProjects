package springdemo.xmlconfiguration.cnamespace;

import springdemo.beanwired.Person;

/**
 * @Author: weianyang
 * @Date: 2018/6/6 19:56
 * @Description: weianyang
 */
public class SpiderMan implements Person{

    private String name;

    private String clothes;

    private Tool tool;

    private int age;//这里建议使用基本数据类型，因为它们在没有赋值的情况下，其值是0，而Integer一类则是null

    public SpiderMan(){
        this.name = "SpiderMan";
    }

    public SpiderMan(String name, String clothes, int age){
        this.name = name;
        this.clothes = clothes;
        this.age = age;
    }

    public SpiderMan(Tool tool){
        this.tool = tool;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String say() {
        return "My name is " + name + ", clothes is " + clothes + ", age is " + age;
    }

}
