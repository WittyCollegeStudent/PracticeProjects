package leetcode.greedy.qs455;

import java.util.Arrays;

public class Qs455 {

    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        Solution so = new Solution();
        System.out.println(so.findContentChildren(g, s));
    }

}

class Solution {
    // 胃口、食物数量
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int cnt = 0;
        int foodIndex = g.length - 1, personIndex = s.length - 1;
        while (foodIndex >= 0 && personIndex >= 0) {
            if (g[foodIndex] <= s[personIndex]) {
                cnt ++;
                foodIndex --;
                personIndex --;
            } else {
                // 相当于减少食量
                foodIndex --;
            }
        }
        return cnt;
    }
}

