package jsongsondemo.json;

import net.sf.json.JSONNull;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: weianyang
 * @Date: 2018/5/21 18:39
 * @Description: weianyang
 */
//2.Map方式添加内容
public class JsonMapDemo {

    public static void main(String args[]) {
        Map<String, Object> mapData = new HashMap<>();
        mapData.put("name", "weianyang");
        mapData.put("age", 22);
        mapData.put("school", "HUNNU");
        mapData.put("car", new String[]{"car1", "car2"});
        mapData.put("nothing", "null");
//        Boolean nothing = mapData.get("nothing").equals(null);
        JSONObject jsonObject = new JSONObject();
        jsonObject.putAll(mapData);
        System.out.println(jsonObject);
        System.out.println(JSONNull.getInstance().equals(null));
        System.out.println(jsonObject.get("nothing").getClass().getName());
    }

}
