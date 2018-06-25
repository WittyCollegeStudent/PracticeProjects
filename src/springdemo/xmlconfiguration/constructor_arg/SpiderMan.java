package springdemo.xmlconfiguration.constructor_arg;

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

    private Integer age;

    public SpiderMan(){
        this.name = "SpiderMan";
    }

    public SpiderMan(String name, String clothes, Integer age){
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
