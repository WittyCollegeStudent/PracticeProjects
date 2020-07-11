package leetcode.greedy.qs451;

import java.util.*;

public class Qs451 {

    public static void main(String[] args) {
        String str = "AAbbccccccdddefaaaaaaaaa";
        Solution so = new Solution();
        System.out.println(so.frequencySort(str));
    }

}

class Solution {
    private Map<Character, Integer> map = new HashMap<>(52 * 4 / 3 + 1);
    // 记录字符出现的次数
    public String frequencySort(String s) {
        if (s == null || s.length() <= 0) {
            return s;
        }
        map.clear();
        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Character> freqChList[] = new ArrayList[s.length() + 1];
        for (Character ch : map.keySet()) {
            if (freqChList[map.get(ch)] == null) {
                freqChList[map.get(ch)] = new ArrayList<>();
            }
            freqChList[map.get(ch)].add(ch);
        }
        StringBuffer resList = new StringBuffer("");
        for (int i = s.length() ; i > 0 ; i --) {
            if (freqChList[i] != null) {
                for (Character ch : freqChList[i]) {
                    for (int j = i ; j > 0 ; j --) {
                        resList.append(ch);
                    }
                }
            }
        }
        return resList.toString();
    }
}