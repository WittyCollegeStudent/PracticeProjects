package jsongsondemo.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangbo22479
 * @date 2018/12/11
 * 将数组类型的JSON字符串转换为String[]
 */
public class MainTest {

    public static void main(String[] args) {
        String str = "[1,2,3,5,10,11,15,5]";
        JSONArray jsonArray = JSON.parseArray(str);
        List<String> stringList = new ArrayList<>();
        for (Object obj : jsonArray) {
            stringList.add(obj.toString());
        }
        String[] array = stringList.toArray(new String[stringList.size()]);
        System.out.println(array);
    }

}
