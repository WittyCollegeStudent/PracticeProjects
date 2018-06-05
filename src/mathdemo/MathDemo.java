package mathdemo;

import net.sf.json.JSONObject;

/**
 * @Author: weianyang
 * @Date: 2018/5/9 15:29
 * @Description: weianyang
 */
public class MathDemo {

    public static void main(String args[]){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "weianyang");
        jsonObject.put("age", 10);
        System.out.println(jsonObject.toString());
    }

}
