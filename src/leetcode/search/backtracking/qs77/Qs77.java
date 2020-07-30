package leetcode.search.backtracking.qs77;

import java.util.ArrayList;
import java.util.List;

public class Qs77 {
}

class Solution {
    private List<List<Integer>> listList;
    public List<List<Integer>> combine(int n, int k) {
        listList = new ArrayList<>();
        execute(1, n + 1, k, new ArrayList<>());
        return listList;
    }
    // start为起始,end为终止之后的一个数字
    private void execute(int start, int end, int k, List<Integer> itemList) {
        if (k == 0) {
            listList.add(new ArrayList<>(itemList));
        } else {
            for (; start < end ; start ++) {
                itemList.add(start);
                execute(start + 1, end, k - 1, itemList);
                itemList.remove(itemList.size() - 1);
            }
        }
    }
}