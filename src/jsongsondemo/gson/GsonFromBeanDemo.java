package jsongsondemo.gson;

import com.google.gson.Gson;
import jsongsondemo.json.Person;

/**
 * @Author: weianyang
 * @Date: 2018/5/24 12:30
 * @Description: 从Bean生成Json
 */
public class GsonFromBeanDemo {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("weianyang");
        person.setAge(23);
        person.setIgnore("ignored");
        person.setCars(new String[]{"car1", "car2"});
        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println(gson.toJson(person));
    }

}
