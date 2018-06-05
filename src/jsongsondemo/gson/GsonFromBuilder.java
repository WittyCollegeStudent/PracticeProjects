package jsongsondemo.gson;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jsongsondemo.json.Person;

import java.lang.reflect.Field;

/**
 * @Author: weianyang
 * @Date: 2018/5/24 12:58
 * @Description: 利用GsonBuilder生成Json数据
 */
public class GsonFromBuilder {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("weianyang");
        person.setAge(23);
        person.setCars(new String[]{"car1", "car2"});
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.setFieldNamingStrategy(new FieldNamingStrategy() {
            @Override
            public String translateName(Field f) {
                if(f.getName().equals("name")){
                    return "NNNNAAAAMMMMEEEE";
                }else{
                    return f.getName();
                }
            }
        });
        Gson gson = builder.create();
        System.out.println(gson.toJson(person));
    }

}
