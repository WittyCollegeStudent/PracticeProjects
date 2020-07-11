package leetcode.greedy.qs452;

import java.util.Arrays;
import java.util.Comparator;

public class Qs452 {

    public static void main(String[] args) {

    }

}

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length <= 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int cntToRemove = 0;
        int index = 1, currEnd = points[0][1];
        while (index < points.length) {
            // 记录有交集部分
            if (points[index][0] <= currEnd && points[index][1] >= currEnd) {
                index ++;
                cntToRemove ++;
            } else {
                // 说明不相交
                currEnd = points[index][1];
                index ++;
            }
        }
        return points.length - cntToRemove;
    }
}
