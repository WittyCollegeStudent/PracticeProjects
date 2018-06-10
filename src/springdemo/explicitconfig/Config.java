package springdemo.explicitconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: weianyang
 * @Date: 2018/6/6 19:28
 * @Description: weianyang
 */

//定义配置类，用于替换xml文件
@Configuration
//@ComponentScan
public class Config {

    @Bean
    public BraveMan braveman(){
        return new BraveMan();
    }

    @Bean
    public SpiderMan spiderman(){
        return new SpiderMan();
    }

    @Bean
    public Office officeWithBraveman(BraveMan braveMan){
        return new Office(braveMan);
    }

    @Bean
    public Office officeWithBraveman2(BraveMan braveMan){
        return new Office(braveMan);
    }

    @Bean
    public Office officeWithSpiderman(SpiderMan spiderMan){
        return new Office(spiderMan);
    }

}
