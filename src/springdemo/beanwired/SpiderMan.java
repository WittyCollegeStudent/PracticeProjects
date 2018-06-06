package springdemo.beanwired;

import org.springframework.stereotype.Component;

/**
 * @Author: weianyang
 * @Date: 2018/6/6 19:56
 * @Description: weianyang
 */
@Component
public class SpiderMan implements Person{

    private String name;

    public SpiderMan(){
        this.name = "SpiderMan";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String say() {
        return "I am a spider man.";
    }

}
