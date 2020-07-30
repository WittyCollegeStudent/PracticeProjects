package leetcode.search.backtracking.qs47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Qs47 {
}

class Solution {
    private List<List<Integer>> listList;
    private boolean[] hasVisited;
    private int[] nums;
    public List<List<Integer>> permuteUnique(int[] nums) {
        listList = new ArrayList<>();
        hasVisited = new boolean[nums.length];
        Arrays.sort(nums);
        this.nums = nums;
        execute(new ArrayList<>());
        return listList;
    }
    private void execute(List<Integer> integerList) {
        if (integerList.size() == nums.length) {
            listList.add(new ArrayList<>(integerList));
        } else {
            for (int i = 0 ; i < nums.length ; i ++) {
                // 相同且当前位置的数字下的树枝的情况之前必定遍历过
                if (i != 0 && nums[i-1] == nums[i] && !hasVisited[i - 1]) {
                    continue;
                }
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