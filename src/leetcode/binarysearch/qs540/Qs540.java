package leetcode.binarysearch.qs540;

public class Qs540 {

    public static void main(String[] args) {
        Solution so = new Solution();
        int[] arr = new int[] {3,3,7,7,10,11,11};
        System.out.println(so.singleNonDuplicate(arr));
    }

}

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int res = nums[0];
        for (int i = 1 ; i < nums.length ; i ++) {
            res ^= nums[i];
        }
        return res;
    }
}