package leetcode.search.dfs.qs695;

import java.util.*;

public class Qs695 {

    public static void main(String[] args) {
        int m = 50;
        int n = 50;
        int[][] grid = new int[m][n];
        for (int i = 0 ; i < m ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                grid[i][j] = new Random().nextInt(2);
            }
        }
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(grid));
        System.out.println(solution.maxAreaOfIsland(grid));
    }

}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0 ; i < grid.length ; i ++) {
            for (int j = 0 ; j < grid[0].length ; j ++) {
                max = Math.max(max, maxDfsTravel(grid, i, j));
            }
        }
        return max;
    }
    private int maxDfsTravel(int[][]grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        int cnt = 1;
        grid[x][y] = 0;
        cnt += maxDfsTravel(grid, x - 1, y);
        cnt += maxDfsTravel(grid, x + 1, y);
        cnt += maxDfsTravel(grid, x, y - 1);
        cnt += maxDfsTravel(grid, x, y + 1);
        return cnt;
    }
}
