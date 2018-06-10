package springdemo.explicitconfig;

import org.springframework.stereotype.Component;

/**
 * @Author: weianyang
 * @Date: 2018/6/8 16:00
 * @Description: 办公室，里面有一个办公室主任，这个主任需要实现Person接口
 */
@Component
public class Office {

    private Person person;

    public Office(Person person){
        this.person = person;
    }

    public Office(){}

    public Person getPerson() {
        return person;
    }
}
