package leetcode.search.backtracking.qs93;

import java.util.ArrayList;
import java.util.List;

public class Qs93 {

    public static void main(String[] args) {
        Solution so = new Solution();
        String str = "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        System.out.println(so.restoreIpAddresses(str));
    }

}

class Solution {
    private List<String> stringList = null;
    public List<String> restoreIpAddresses(String s) {
        stringList = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return stringList;
        }
        combinate(new StringBuffer(""), 0, s);
        return stringList;
    }
    private void combinate(StringBuffer currStr, int ipCnt, String strToTravel) {
        if (strToTravel.length() <= 0 && ipCnt == 4) {
            // 去除逗号
            stringList.add(currStr.substring(0, currStr.length()-1));
        } else if (ipCnt > 4) {
            return;
        } else  {
            int lenOfCurrStr = currStr.length();
            int length = strToTravel.length();
            for (int i = 1 ; i <= length && i < 4 ; i ++) {
                String nextNum = strToTravel.substring(0, i);
                if (Integer.parseInt(nextNum) > 255) {
                    return;
                }
                if (nextNum.charAt(0) == '0' && nextNum.length() > 1) {
                    return;
                }
                currStr.append(nextNum)
                    .append(".");
                combinate(currStr, ipCnt + 1, strToTravel.substring(i, strToTravel.length()));
                currStr.delete(lenOfCurrStr, currStr.length());
            }
        }
    }
}
