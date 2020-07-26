package leetcode.search.dfs.qs130;

import java.util.Arrays;
import java.util.Random;

public class Qs130 {

    public static void main(String[] args) {
        int m = 5;
        char[][] grid = new char[m][m];
        Random random = new Random();
        for (int i = 0 ; i < m ; i ++) {
            for (int j = 0 ; j < m ; j ++) {
                if (random.nextInt(8) == 0) {
                    grid[i][j] = 'O';
                } else {
                    grid[i][j] = 'X';
                }
            }
        }
        grid = new char[][]{{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
        Solution so = new Solution();
        System.out.println(Arrays.deepToString(grid));
        so.solve(grid);
        System.out.println(Arrays.deepToString(grid));
    }

}

class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length <= 0 || board[0].length <= 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0 ; i < n ; i ++) {
            dfs(board, 0, i);
            dfs(board, m-1, i);
        }
        for (int i = 0 ; i < m ; i ++) {
            dfs(board, i, 0);
            dfs(board, i, n-1);

        }
        for (int i = 0 ; i < m ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        return;
    }
    // 输入为点，返回是否为连通状态
    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O') {
            return ;
        }
        board[x][y] = 'T';
        dfs(board, x+1, y);
        dfs(board, x-1, y);
        dfs(board, x, y+1);
        dfs(board, x, y-1);
        return ;
    }
}


