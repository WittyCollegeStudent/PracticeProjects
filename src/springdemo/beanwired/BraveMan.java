package springdemo.beanwired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Author: weianyang
 * @Date: 2018/6/6 19:56
 * @Description: weianyang
 */
@Component("braveman1")
@Qualifier("braveman2")
public class BraveMan implements Person{

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
        return "I am a brave man.";
    }

}
