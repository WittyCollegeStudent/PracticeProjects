package leetcode.search.backtracking.qs46;

import java.util.ArrayList;
import java.util.List;

public class Qs46 {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,1,1,3,2,2,3,4,5};
        Solution so = new Solution();
        long time1 = System.currentTimeMillis();
        so.permute(nums);
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
//        System.out.println(so.permute(nums));
    }

}

class Solution {
    private List<List<Integer>> listList;
    private boolean[] hasVisited;
    private int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        listList = new ArrayList<>();
        hasVisited = new boolean[nums.length];
        this.nums = nums;
        execute(new ArrayList<>());
        return listList;
    }
    private void execute(List<Integer> integerList) {
        if (integerList.size() == nums.length) {
            listList.add(new ArrayList<>(integerList));
        } else {
            for (int i = 0 ; i < nums.length ; i ++) {
                if (hasVisited[i]) {
                    continue;
                }
                hasVisited[i] = true;
                integerList.add(nums[i]);
                execute(integerList);
                integerList.remove(integerList.size() - 1);
                hasVisited[i] = false;
            }
        }
    }
}