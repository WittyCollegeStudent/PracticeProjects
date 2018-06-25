package springdemo.verifyautowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: weianyang
 * @Date: 2018/6/6 19:56
 * @Description: weianyang
 */

//
@Component
public class SpiderMan implements Person {

    private String name;

    public SpiderMan(){
        this.name = "SpiderMan";
    }

    @Autowired(required = false)
    public SpiderMan(Tool tool){
        this.name = "SpiderMan";
        System.out.println("constructor param tool");
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
        return "I am a spider man.";
    }

}
