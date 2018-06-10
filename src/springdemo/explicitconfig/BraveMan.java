package springdemo.explicitconfig;

import org.springframework.stereotype.Component;

/**
 * @Author: weianyang
 * @Date: 2018/6/6 19:56
 * @Description: weianyang
 */
@Component("braveman")
public class BraveMan implements Person {

    private String name;

    public BraveMan(){
        this.name = "BraveMan";
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
        return "I am the " + name;
    }

}
