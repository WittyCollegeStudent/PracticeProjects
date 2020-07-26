package leetcode.search.bfs.qs1091;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Qs1091 {

    public static void main(String[] args) {
        Solution so = new Solution();
        int size = 15;
        int arr[][] = new int[size][size];
        for (int i = 0 ; i < size ; i ++) {
            for (int j = 0 ; j < size ; j ++) {
                arr[i][j] = 0;
            }
        }
//        arr[2][2] = 1;
//        arr[2][3] = 1;
        System.out.println("result:");
        long time1 = System.currentTimeMillis();
        System.out.println(so.shortestPathBinaryMatrix(arr));
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }

}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0 || grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }
        int length = 0;
        // 方向
        int[][] directs = new int[][]{{1, 1} ,{1, 0} ,{0, 1} ,{-1, 0} ,{0, -1} ,{1, -1} ,{-1, 1} ,{-1, -1}};
        Queue<int[]> pointQueue = new LinkedList<>();
        pointQueue.add(new int[]{0, 0});
        while (!pointQueue.isEmpty()) {
            int size = pointQueue.size();
            for (int i = 0 ; i < size ; i ++) {
                // 返回并删除
                int[] point = pointQueue.poll();
                // 判断是否达到结束
                if (point[0] == grid.length - 1 && point[1] == grid[0].length - 1) {
                    return length + 1;
                }
                if (grid[point[0]][point[1]] == 1) {
                    continue;
                }
                // 否则占据此节点，因为遍历前会判断，所以现在不需要再判断
                grid[point[0]][point[1]] = 1;
                // 遍历其它方向，并判断可行性
                for (int[] direct : directs) {
                    int[] nextPoint = new int[] {direct[0] + point[0], direct[1] + point[1]};
                    if (nextPoint[0] < 0 || nextPoint[0] >= grid.length || nextPoint[1] < 0 || nextPoint[1] >= grid[0].length) {
                        continue;
                    }
                    pointQueue.add(nextPoint);
                }
            }
            ++ length;
        }
        return -1;
    }
}

/**
 0 0 0 0
 0 0 0 0
 0 0 0 0
 0 0 0 0
 [
 [0,0,1,0,0,0,0],
 [0,1,0,0,0,0,1],
 [0,0,1,0,1,0,0],
 [0,0,0,1,1,1,0],
 [1,0,0,1,1,0,0],
 [1,1,1,1,1,0,1],
 [0,0,1,0,0,0,0]
 ]

 [[0,0,1,0,0,0,0],[0,1,0,0,0,0,1],[0,0,1,0,1,0,0],[0,0,0,1,1,1,0],[1,0,0,1,1,0,0],[1,1,1,1,1,0,1],[0,0,1,0,0,0,0]]
 **/