package springdemo.verifyautowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: weianyang
 * @Date: 2018/6/6 19:28
 * @Description: weianyang
 */

//定义配置类，用于替换xml文件
@Configuration
//启用组件扫描(完整包名)，默认扫描当前包
@ComponentScan
public class ScanConfig {
}
