package jsongsondemo.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangbo22479
 * @date 2018/12/11
 */
public class JsonStringToMap {

    public static void main(String[] args) {
        String selectInstructions = "{\"3\":{\"unHandle\":{\"isCheckAll\":\"1\",\"instructions\":[]},\"failStart\":{\"isCheckAll\":\"0\",\"instructions\":[\"2018061305818\",\"2018061305819\",\"2018061305824\",\"2018061305826\"]}},\"M\":{}}";
        JSONObject instrs = JSONObject.parseObject(selectInstructions);
        // "渠道名 - 选中信息"的键值对
        Map<String, Object> instructionMap = new HashMap<>();
        for (Map.Entry<String, Object> entry : instrs.entrySet()) {
            Map<String, Object> detailMap = new HashMap<>();
            String channelName = entry.getKey();
            JSONObject detailObj = (JSONObject) entry.getValue();
            // "选中类型 - 具体信息"
            for (Map.Entry<String, Object> detailEntry : detailObj.entrySet()) {
                Map<String, Object> checkMap = new HashMap<>();
                String type = detailEntry.getKey();
                JSONObject detail = (JSONObject) detailEntry.getValue();
                // "isCheckAll, instructions"
                for (Map.Entry<String, Object> checkEntry : detail.entrySet()) {
                    if ("isCheckAll".equals(checkEntry.getKey())) {
                        checkMap.put("isCheckAll", checkEntry.getValue());
                    } else if ("instructions".equals(checkEntry.getKey())) {
                        JSONArray jsonArray = (JSONArray) checkEntry.getValue();
                        List<String> stringList = new ArrayList<>();
                        for (Object obj : jsonArray) {
                            stringList.add(obj.toString());
                        }
                        String[] array = stringList.toArray(new String[stringList.size()]);
                        checkMap.put("instructions", array);
                    }
                }
                detailMap.put(type, checkMap);
            }
            instructionMap.put(channelName, detailMap);
        }
        System.out.println(instructionMap);
    }

}
