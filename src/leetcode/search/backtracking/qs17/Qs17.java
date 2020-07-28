package leetcode.search.backtracking.qs17;

import java.util.*;

public class Qs17 {
}

class Solution {
    private List<String> stringList = null;
    private Map<Character, String> numToString;
    public Solution() {
        numToString = new HashMap<>();
        numToString.put('2', "abc");
        numToString.put('3', "def");
        numToString.put('4', "ghi");
        numToString.put('5', "jkl");
        numToString.put('6', "mno");
        numToString.put('7', "pqrs");
        numToString.put('8', "tuv");
        numToString.put('9', "wxyz");
    }
    public List<String> letterCombinations(String digits) {
        stringList = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return stringList;
        }
        execute(digits, 0, new StringBuffer(""));
        return stringList;
    }
    private void execute(String digits, int currIndex, StringBuffer buffer) {
        if (currIndex >= digits.length()) {
            stringList.add(buffer.toString());
        } else {
            String convertedStr = numToString.get(digits.charAt(currIndex));
            for (int i = 0 ; i < convertedStr.length() ; i ++) {
                buffer.append(convertedStr.charAt(i));
                execute(digits, currIndex + 1, buffer);
                buffer.delete(buffer.length() - 1, buffer.length());
            }
        }
    }
}