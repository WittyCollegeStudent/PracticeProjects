package junitdemo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author zhangbo22479
 * @date 2019/1/1
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CalculateTest.class, CalculateTest2.class})
public class SuiteTest {
}
