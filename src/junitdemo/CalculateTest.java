package junitdemo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author zhangbo22479
 * @date 2019/1/1
 */
public class CalculateTest {

    @Test
    public void add() {
        assertEquals(6, new Calculate().add(3, 3));
    }

}