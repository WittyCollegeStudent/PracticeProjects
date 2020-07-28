package leetcode.search.backtracking.qs46;

import java.util.ArrayList;
import java.util.List;

public class Qs46 {
}

class Solution {
    List<List<Integer>> listList;
    public List<List<Integer>> permute(int[] nums) {
        listList = new ArrayList<>();
        execute(nums, new ArrayList<>());
        return listList;
    }
    private void execute(int[] nums, List<Integer> integerList) {
        if (nums.length <= 0) {
            listList.add(new ArrayList<>(integerList));
        } else {
            for (int i = 0 ; i < nums.length ; i ++) {
                int[] newNums = new int[nums.length - 1];
                System.arraycopy(nums, 0, newNums, 0, i);
                System.arraycopy(nums, i + 1, newNums, i, nums.length - i - 1);
                integerList.add(nums[i]);
                execute(newNums, integerList);
                integerList.remove(integerList.size() - 1);
            }
        }
    }
}