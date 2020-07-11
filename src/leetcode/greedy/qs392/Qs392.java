package leetcode.greedy.qs392;

public class Qs392 {

    public static void main(String[] args) {

    }

}

class Solution {
    public boolean isSubsequence(String s, String t) {
        int indexOfS = 0, indexOfT = 0;
        while (indexOfS < s.length() && indexOfT < t.length()) {
            if (s.charAt(indexOfS) == t.charAt(indexOfT)) {
                ++ indexOfS;
                ++ indexOfT;
            } else {
                ++ indexOfT;
            }
        }
        return indexOfS == s.length();
    }
}
