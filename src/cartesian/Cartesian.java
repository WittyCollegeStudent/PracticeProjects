package cartesian;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: weianyang
 * @Date: 2018/5/24 12:30
 * @Description: 笛卡尔积
 */
public class Cartesian {
    private static List<List<String>> factorsLists = new ArrayList<>();

    public static void main(String[] args){
        List<String> stringList1 = new ArrayList<>();
        List<String> stringList2 = new ArrayList<>();
        List<String> stringList3 = new ArrayList<>();
        stringList1.add("年龄一");
        stringList1.add("年龄二");
        stringList1.add("年龄三");
        stringList2.add("风险一");
        stringList2.add("风险二");
        stringList2.add("风险三");
        stringList3.add("金额一");
        stringList3.add("金额二");
        stringList3.add("金额三");
        factorsLists.add(stringList1);
        factorsLists.add(stringList2);
        factorsLists.add(stringList3);
        int sumSize = 1;//笛卡尔积的总长度
        int externalSize = factorsLists.size();
        int counter[] = new int[externalSize];//存储每一层的下标
        for (List<String> stringList : factorsLists) {
            sumSize *= stringList.size();
        }
        int counterIndex = externalSize - 1;//当前层
        int counterIndexTemp = counterIndex;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < sumSize; i++) {
            int j = 0;
            StringBuilder stringBuilder = new StringBuilder();
            for (; j < externalSize; j++) {
                stringBuilder.append(factorsLists.get(j).get(counter[j]));
                stringBuilder.append("/");
            }
            if(!StringUtils.isEmpty(stringBuilder.toString())){
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            result.add(stringBuilder.toString());
            System.out.println();
            counter[counterIndex]++;//当前层下标加一，用取下一个数值
            counterIndexTemp = counterIndex;
            while (counter[counterIndex] >= factorsLists.get(counterIndex).size()) {
                counter[counterIndex] = 0;
                if(counterIndex >= 1){
                    counterIndex--;//下一层
                    counter[counterIndex]++;
                }
            }
            counterIndex = counterIndexTemp;//还原值，设置为最外层的大小
        }
        System.out.println(result);
    }

}
