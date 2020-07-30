package leetcode.search.backtracking.qs40;

import java.util.*;

public class Qs40 {

    public static void main(String[] args) {
        Solution so = new Solution();
        int[] candidates = new int[] {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(so.combinationSum2(candidates, target));
    }

}

class Solution {
    private List<List<Integer>> listList;
    private int[] candidates;
    private boolean[] hasTraveled;
    private int target;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        listList = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
        this.hasTraveled = new boolean[candidates.length];
        Arrays.sort(candidates);
        execute(new ArrayList<>(), 0, 0);
        return listList;
    }
    private void execute(List<Integer> itemList, int currSum, int travelIndex) {
        if (currSum == target) {
            listList.add(new ArrayList<>(itemList));
        } else {
            int i = travelIndex;
            for (; i < candidates.length ; i ++) {
                // 剪枝
                if (i != 0 && candidates[i-1] == candidates[i] && !hasTraveled[i-1]) {
                    continue;
                }
                int nextSum = currSum + candidates[i];
                if (nextSum > target) {
                    return;
                }
                itemList.add(candidates[i]);
                hasTraveled[i] = true;
                execute(itemList, nextSum, i + 1);
                hasTraveled[i] = false;
                itemList.remove(itemList.size() - 1);
            }
        }
    }
}