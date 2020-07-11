package junitdemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * @author zhangbo22479
 * @date 2019/1/1
 * @参数化测试用例
 * 总的执行顺序:构造函数 -> before -> test
 * 每个测试用例打印的调用顺序:before-> test -> 调用下一个测试用例的构造函数
 */
@RunWith(Parameterized.class)
public class ParameterTest {

    private int expected;
    private int input1;
    private int input2;

    @Parameterized.Parameters
    public static Collection<Object[]> t() {
        return Arrays.asList(new Object[][]{
            {4, 1, 3},
            {5, 1, 4},
            {6, 2, 4}
        });
    }

    public ParameterTest(int expected, int input1, int input2) {
        System.out.println(22479);
        System.out.println(expected);
        this.expected = expected;
        this.input1 = input1;
        this.input2 = input2;
    }

    @Before
    public void before() {
        System.out.println(this);
    }

    @Test
    public void testAdd() {
        System.out.println(222);
        assertEquals(expected, new Calculate().add(input1, input2));
    }

}