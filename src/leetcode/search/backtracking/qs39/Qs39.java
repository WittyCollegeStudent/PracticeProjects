package leetcode.search.backtracking.qs39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Qs39 {

    public static void main(String[] args) {
        Solution so = new Solution();
        int[] candidates = new int[] {1, 2, 3, 4, 5, 7};
        int target = 7;
        System.out.println(so.combinationSum(candidates, target));
    }

}

class Solution {
    private List<List<Integer>> listList;
    private int[] candidates;
    private int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        listList = new ArrayList<>();
        this.candidates = candidates;
        this.target = target;
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
                int nextSum = currSum + candidates[i];
                if (nextSum > target) {
                    return;
                }
                itemList.add(candidates[i]);
                execute(itemList, nextSum, i);
                itemList.remove(itemList.size() - 1);
            }
        }
    }
}