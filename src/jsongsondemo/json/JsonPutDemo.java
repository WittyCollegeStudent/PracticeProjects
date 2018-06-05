package jsongsondemo.json;


import net.sf.json.JSONObject;

//1.put方式添加内容
public class JsonPutDemo {

    public static void main(String args[]) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "weianyang");
        jsonObject.put("age", 22);
        jsonObject.put("school", "HUNNU");
        jsonObject.put("car", new String[]{"car1", "car2"});
        jsonObject.put("nothing", "null");
        boolean nothing = jsonObject.get("nothing").equals(null);
        System.out.println(jsonObject);
        System.out.println(nothing);
        System.out.println(jsonObject.get("nothing").getClass().getName());
    }

}

