package jsongsondemo.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class CreateComponentJson {

    public static void main(String[] args) {
        JSONArray baseArray = ComponentJsonArray.getCreatedComponentJsonArray();
        System.out.println(baseArray);
    }

}

class ComponentJsonArray{

    public static JSONArray getCreatedComponentJsonArray(){
        JSONArray baseArray = new JSONArray();
        JSONObject baseJson1 = new JSONObject();
        baseJson1.put("key", "jl");
        baseJson1.put("value", "");
        baseJson1.put("label", "级联下拉1");
        baseJson1.put("componentType", "cascader");
        baseJson1.put("data", new JSONArray());
        JSONObject baseJson2 = JSON.parseObject("{\n" +
                "      key: 'test3',\n" +
                "      value: '2',\n" +
                "      label: '下拉4',\n" +
                "      componentType: 'select',\n" +
                "      options: [\n" +
                "        {\n" +
                "          value: '1',\n" +
                "          label: '成都'\n" +
                "        },\n" +
                "        {\n" +
                "          value: '2',\n" +
                "          label: '重庆'\n" +
                "        }\n" +
                "      ]\n" +
                "    }");
        JSONObject baseJson3 = JSON.parseObject("{\n" +
                "      key: 'dx3',\n" +
                "      sex: 'woman',\n" +
                "      label: '单选按钮',\n" +
                "      componentType: 'radio'\n" +
                "    }");
        JSONObject baseJson4 = JSON.parseObject("{\n" +
                "      key: 'dx4',\n" +
                "      sex: 'man',\n" +
                "      label: '单选按钮',\n" +
                "      componentType: 'radio'\n" +
                "    }");
        baseArray.add(baseJson1);
        baseArray.add(baseJson2);
        baseArray.add(baseJson3);
        baseArray.add(baseJson4);

        // 创建10*10*10的省市县级联
        for (int i = 1; i <= 10; i++) {
            JSONObject temp = new JSONObject();
            temp.put("value", "sheng" + i);
            temp.put("label", "省" + i);
            temp.put("children", new JSONArray());
            for (int j = 1; j <= 10; j++) {
                JSONObject tempSecond = new JSONObject();
                tempSecond.put("value", "shi" + j);
                tempSecond.put("label", "省" + i + "-市" + j);
                tempSecond.put("children", new JSONArray());
                ((JSONArray)temp.get("children")).add(tempSecond);
                for (int k = 1; k <= 10; k++) {
                    JSONObject tempThird = new JSONObject();
                    tempThird.put("xian", "shi" + j);
                    tempThird.put("label", "省" + i + "-市" + j + "-县" + k);
                    ((JSONArray)((JSONObject)((JSONArray)temp.get("children")).get(j-1)).get("children")).add(tempThird);
                }
            }
            ((JSONArray)((JSONObject)baseArray.get(0)).get("data")).add(temp);
        }
        // 创建4个日期
        for (int i = 1; i <= 2; i++) {
            JSONObject temp = new JSONObject();
            temp.put("key", "riqi" + i);
            temp.put("value", "2018-07-0" + i);
            temp.put("label", "第" + i + "个日期");
            temp.put("componentType", "date");
            baseArray.add(temp);
        }
        // 创建4个复选
        String[] ff = new String[]{"香蕉", "苹果", "西瓜", "西瓜"};
        for (int i = 1; i <= 2; i++) {
            JSONObject temp = new JSONObject();
            temp.put("key", "fuxuan" + i);
            temp.put("value", ff);
            temp.put("label", "第" + i + "个复选框");
            temp.put("componentType", "checkbox");
            baseArray.add(temp);
        }
// 创建10个textarea
        for (int i = 1; i <= 5; i++) {
            JSONObject temp = new JSONObject();
            temp.put("key", "textarea" + i);
            temp.put("value", "textarea文本域" + i);
            temp.put("label", "第" + i + "个文本域");
            temp.put("componentType", "textarea");
            baseArray.add(temp);
        }
// 创建30个文本框
        for (int i = 1; i <= 10; i++) {
            JSONObject temp = new JSONObject();
            temp.put("key", "t" + i);
            temp.put("value", "字段值" + i);
            temp.put("label", "第" + i + "个文本框");
            temp.put("componentType", "input");
            baseArray.add(temp);
        }
        // 创建1个table
        JSONObject tableTemp = new JSONObject();
        tableTemp.put("key", "table11");
        tableTemp.put("value", "");
        tableTemp.put("label", "第1个表格");
        tableTemp.put("componentType", "table");
        JSONArray tableDataArray = new JSONArray();
        tableDataArray.add(JSON.parseObject("{title: '姓名', key: 'name'}"));
        tableDataArray.add(JSON.parseObject("{title: '年龄', key: 'age'}"));
        tableDataArray.add(JSON.parseObject("{title: '地址', key: 'address'}"));
        tableTemp.put("columns4", tableDataArray);
        tableTemp.put("data", new JSONArray());
        for (int i = 1; i <= 15; i++) {
            JSONObject temp = new JSONObject();
            temp.put("name", "小明" + i);
            temp.put("age", i);
            temp.put("address", "北京市朝阳区芍药居");
            ((JSONArray)tableTemp.get("data")).add(temp);
        }
        baseArray.add(tableTemp);
        return baseArray;
    }

}