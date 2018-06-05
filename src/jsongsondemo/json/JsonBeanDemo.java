package jsongsondemo.json;

import net.sf.json.JSONObject;

/**
 * @Author: weianyang
 * @Date: 2018/5/21 18:39
 * @Description: weianyang
 */
//3.Bean方式添加内容
public class JsonBeanDemo {

    public static void main(String args[]) {
        Person person = new Person();
        person.setName("null");
        person.setIgnore("ignored");
        person.setCars(new String[]{"car1", "car2", "car3"});
        person.setAge(23);
        JSONObject jsonObject = JSONObject.fromObject(person);
        System.out.println(jsonObject);
        System.out.println(jsonObject.get("name").getClass().getName());
        System.out.println(jsonObject.get("name").equals(null));
    }

}
