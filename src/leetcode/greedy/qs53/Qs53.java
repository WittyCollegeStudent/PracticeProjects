package leetcode.greedy.qs53;

public class Qs53 {

    public static void main(String[] args) {

    }

}

class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            currSum += num;
            max = (max > currSum ? max : currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return max;
    }
}
