package leetcode.search.dfs.qs417;

import java.util.ArrayList;
import java.util.List;

public class Qs417 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0,0,1},{1,0,1},{1,0,1}};
        Solution so = new Solution();
        System.out.println(so.pacificAtlantic(arr));
    }

}

class Solution {
    private int[][] matrix;
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> lists = new ArrayList<>();
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return lists;
        }
        this.matrix = matrix;
        boolean[][] paciArr = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlan = new boolean[matrix.length][matrix[0].length];
        for (int i = 0 ; i < matrix[0].length; i ++) {
            dfs( 0, i, matrix[0][i], paciArr);
            dfs( matrix.length-1, i, matrix[matrix.length-1][i], atlan);
        }
        for (int i = 0 ; i < matrix.length; i ++) {
            dfs(i, 0, matrix[i][0], paciArr);
            dfs(i, matrix[0].length-1, matrix[i][matrix[0].length-1], atlan);
        }
        for (int i = 0 ; i < matrix.length ; i ++) {
            for (int j = 0 ; j < matrix[0].length ; j ++) {
                if (paciArr[i][j] && atlan[i][j]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    lists.add(list);
                }
            }
        }
        return lists;
    }
    private void dfs(int x, int y, int preNum, boolean[][] canReach) {
        if (x < 0 || y < 0 || x >= this.matrix.length || y >= matrix[0].length || canReach[x][y]) {
            return;
        }
        if (preNum > matrix[x][y]) {
            return;
        }
        preNum = matrix[x][y];
        canReach[x][y] = true;
        dfs(x+1, y, preNum, canReach);
        dfs(x-1, y, preNum, canReach);
        dfs( x, y+1, preNum, canReach);
        dfs( x, y-1, preNum, canReach);
    }
}