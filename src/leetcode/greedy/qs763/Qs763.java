package leetcode.greedy.qs763;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Qs763 {

    public static void main(String[] args) {
        String str = "";
        int size = 30;
        Random random = new Random();
        while (size-- > 0) {
            char ch = (char) (random.nextInt(26) + 'a');
            str += ch;
        }
        Solution so = new Solution();
        List<Integer> list = so.partitionLabels(str);
        System.out.println(str);
        System.out.println(list);
    }

}

class Solution {
    public List<Integer> partitionLabels(String s) {
        int startIndex = 0, endIndex = 0;
        int[] lastIndexes = new int[26];
        for (char ch : s.toCharArray()) {
            lastIndexes[ch - 'a'] = s.lastIndexOf(ch);
        }
        int tmpIndex;
        char currCh;
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0 ; i < s.length() ; i = startIndex) {
            currCh = s.charAt(i);
            endIndex = lastIndexes[currCh - 'a'];
            for (int j = i + 1; j < endIndex ; j ++) {
                tmpIndex = lastIndexes[s.charAt(j) - 'a'];
                endIndex = (tmpIndex > endIndex ? tmpIndex : endIndex);
            }
            resultList.add(endIndex - startIndex + 1);
            startIndex = endIndex + 1;
        }
        return resultList;
    }
}