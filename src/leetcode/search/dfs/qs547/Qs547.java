package leetcode.search.dfs.qs547;

import java.util.Arrays;
import java.util.Random;

public class Qs547 {

    public static void main(String[] args) {
        int m = 3;
        int[][] grid = new int[m][m];
        for (int i = 0 ; i < m ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                grid[i][j] = new Random().nextInt(2);
            }
        }
        grid = new int[][] {{1,1,0}, {1,1,0}, {0,0,1}};
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(grid));
        System.out.println(solution.findCircleNum(grid));
    }

}

class Solution {
    public int findCircleNum(int[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0) {
            return 0;
        }
        boolean[] hasVisited = new boolean[grid.length];
        int num = 0;
        for (int i = 0 ; i < grid.length ; i ++) {
            num += dfs(grid, i, hasVisited);
        }
        return num;
    }
    private int dfs(int[][] grid, int i, boolean[] hasVisited) {
        if (i < 0 || i >= grid.length || hasVisited[i]) {
            return 0;
        }
        hasVisited[i] = true;
        int num = 0;
        for (int j = 0 ; j < grid.length ; j ++) {
            if (grid[i][j] == 1) {
                dfs(grid, j, hasVisited);
                num = 1;
            }
        }
        return num;
    }
}