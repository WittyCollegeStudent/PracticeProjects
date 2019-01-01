package mapdemo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangbo22479
 * @date 2018/12/11
 * 从map中读取不存在的元素，会返回null，而不是空的map
 */
public class MapReadAferAddition {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "22479");
        System.out.println((Map<String, Object>)map.get(23));
    }

}
