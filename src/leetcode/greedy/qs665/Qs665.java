package leetcode.greedy.qs665;

import leetcode.tool.RandomTool;

import java.util.Arrays;

public class Qs665 {

    public static void main(String[] args) {
        RandomTool randomTool = new RandomTool();
        int[] nums = randomTool.generateRandArray(5, 100);
//        nums = new int[]{4,2,3};
        Solution so = new Solution();
        System.out.println(Arrays.toString(nums));
        System.out.println(so.checkPossibility(nums));
    }

}

class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length < 2) {
            return true;
        }
        int ppre = Integer.MIN_VALUE, pre = Integer.MIN_VALUE, cnt = 0;
        for (int num : nums) {
            if (cnt > 1) {
                return false;
            }
            // 找到不合适的情况
            if (num < pre) {
                cnt ++;
                // 说明把pre改小的策略是不对的，尝试将num改大
                if (num < ppre) {
                    ppre = pre;
                } else {
                    ppre = pre;
                    pre = num;
                }
            } else {
                ppre = pre;
                pre = num;
            }
        }
        return cnt <= 1;
    }
}