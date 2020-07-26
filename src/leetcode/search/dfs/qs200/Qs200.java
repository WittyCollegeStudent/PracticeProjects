package leetcode.search.dfs.qs200;

import java.util.Random;

public class Qs200 {

    public static void main(String[] args) {
        int m = 100;
        char[][] grid = new char[m][m];
        for (int i = 0 ; i < m ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                grid[i][j] = (char) (new Random().nextInt(2) + '0');
            }
        }
        Solution so = new Solution();
        String res = "[";
        for (int i = 0 ; i < m ; i ++) {
            res += "[";
            for (int j = 0 ; j < m ; j ++) {
                res += String.format("\"%s\",", grid[i][j]) ;
            }
            res = res.substring(0, res.length() - 1);
            res += "]";
            res += ",";
        }
        res = res.substring(0, res.length() - 1);
        res += "]";
        System.out.println(res);
        System.out.println(so.numIslands(grid));
    }

}

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0) {
            return 0;
        }
        int num = 0;
        for (int i = 0 ; i < grid.length ; i ++) {
            for (int j = 0 ; j < grid[0].length ; j ++) {
                num += dfs(grid, i, j);
            }
        }
        return num;
    }
    private int dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
            return 0;
        }
        grid[x][y] = '0';
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
        return 1;
    }
}