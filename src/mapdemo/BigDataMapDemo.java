package mapdemo;

import java.util.*;

/**
 * @author zhangbo22479
 * @date 2018/12/13
 * 测试大量数据(30w x 60)的情况下，map性能
 */
public class BigDataMapDemo {

    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        Map<String, Object> map = new HashMap<>();
        int cnt = 300000, arrLength = 60;
        for (int i = 0 ; i < cnt; i ++) {
            List<String> list = new ArrayList<>();
            for (int j = 0 ; j < arrLength; j ++) {
                list.add(Integer.toString(j));
            }
            map.put(Integer.toString(i), list);
        }
        long time2 = System.currentTimeMillis();
        System.out.println("耗时:" + (time2 - time1));
    }

}
