package leetcode.greedy.qs435;

import java.util.Arrays;
import java.util.Comparator;

public class Qs435 {

    public static void main(String[] args) {
        int[][] intervals = { {1,2}, {2,3}, {3,4}, {1,3}};
        Solution so = new Solution();
        System.out.println(so.eraseOverlapIntervals(intervals));
    }

}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparing(o1 -> o1[1]));
        int cntToRemove = 0;
        int index = 1, currEnd = intervals[0][1];
        while (index < intervals.length) {
            // 记录有交集部分
            if (intervals[index][0] < currEnd && intervals[index][1] >= currEnd) {
                index ++;
                cntToRemove ++;
            } else {
                // 说明不相交
                currEnd = intervals[index][1];
                index ++;
            }
        }
        return cntToRemove;
    }
}
