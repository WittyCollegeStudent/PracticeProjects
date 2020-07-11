package springdemo.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 启动类
 * Description:获取上下文配置文件，读取后按配置加载java bean（名称来源于配置文件）
 * */
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springdemo/di/knights.xml");
        BraveKnight braveKnight = (BraveKnight) context.getBean("knight");
        braveKnight.embarkOnQuest();
    }

}
