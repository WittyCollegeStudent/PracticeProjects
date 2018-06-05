package jsongsondemo.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jsongsondemo.json.PersonWithBirthday;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: weianyang
 * @Date: 2018/5/24 18:21
 * @Description: 日期格式转换
 */
public class GsonDateFormat {

    public static void main(String[] args) throws IOException {
        File file = new File(GsonReadFileDemo.class.getResource("/jsongsondemo/json/weianyang.json").getFile());
        String content = FileUtils.readFileToString(file, "UTF8");
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        PersonWithBirthday person = gson.fromJson(content, PersonWithBirthday.class);
        Date birthday = person.getBirthday();
        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(birthday));
    }

}
