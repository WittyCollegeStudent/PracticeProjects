package jsongsondemo.gson;

import com.google.gson.Gson;
import jsongsondemo.json.Person;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @Author: weianyang
 * @Date: 2018/5/24 17:53
 * @Description: 反向解析
 */
public class GsonReadFileDemo {

    public static void main(String[] args) throws IOException {
        File file = new File(GsonReadFileDemo.class.getResource("/jsongsondemo/json/weianyang.json").getFile());
        String content = FileUtils.readFileToString(file, "UTF8");
        Gson gson = new Gson();
        Person person = gson.fromJson(content, Person.class);
        System.out.println(person);
    }

}
