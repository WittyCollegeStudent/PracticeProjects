package jsongsondemo.json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @Author: weianyang
 * @Date: 2018/5/21 18:39
 * @Description: weianyang
 */
//Json读取文件
public class JsonReadFileDemo {

    public static void main(String args[]) throws IOException {
        File file = new File(JsonReadFileDemo.class.getResource("weianyang.json").getFile());
        String weianyang = FileUtils.readFileToString(file, "UTF8");
        System.out.println(weianyang);
        JSONObject jsonObject = JSONObject.fromObject(weianyang);
        System.out.println(jsonObject.get("aa"));
        System.out.println(jsonObject.containsKey("weianyasdf"));
        System.out.println(jsonObject.get("age"));
        System.out.println(jsonObject.get("nothing").getClass().getName());
        JSONArray jsonArray = jsonObject.getJSONArray("car");
        System.out.println(jsonArray);
    }

}
