package leetcode.divideconquer.qs241;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Qs241 {

    public static void main(String[] args) {
        String str = "2*3-4*5";
        Solution so = new Solution();
        System.out.println(so.diffWaysToCompute(str));
    }

}

class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> answerList = new ArrayList<>();
        if (input == null || input.length() <= 0) {
            return answerList;
        }
        for (int i = 0 ; i < input.length() ; i ++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                List<Integer> leftList = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightList = diffWaysToCompute(input.substring(i + 1, input.length()));
                switch (input.charAt(i)) {
                    case '+':
                        for (int left : leftList) {
                            for (int right : rightList) {
                                answerList.add(left + right);
                            }
                        }
                        break;
                    case '-':
                        for (int left : leftList) {
                            for (int right : rightList) {
                                answerList.add(left - right);
                            }
                        }
                        break;
                    case '*':
                        for (int left : leftList) {
                            for (int right : rightList) {
                                answerList.add(left * right);
                            }
                        }
                        break;
                }
            }
        }
        if (answerList.size() == 0) {
            answerList.add(Integer.parseInt(input));
        }
        return answerList;
    }
}