package leetcode.search.backtracking.qs79;

public class Qs79 {

    public static void main(String[] args) {
        Solution so = new Solution();
        char[][] board = new char[][]{
            {'a','a','a','a'},
            {'a','a','a','a'},
            {'a','a','a','a'}};
        String word = "aaaaaaaaaaaa";
        System.out.println(so.exist(board, word));
    }

}

class Solution {
    private boolean[][] isExist;
    private char[][] board;
    private int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length <= 0 || word == null || word.isEmpty()) {
            return true;
        }
        this.board = board;
        this.isExist = new boolean[board.length][board[0].length];
        boolean ans = false;
        for (int i = 0 ; i < board.length ; i ++) {
            for (int j = 0 ; j < board[0].length ; j ++) {
                ans = (ans | execute(board[i][j], word.toCharArray(), i, j, 0));
                if (ans) {
                    return true;
                }
            }
        }
        return ans;
    }

    /**
     *
     * @param currChar 当前要匹配的字符
     * @param dstWord
     * @param i
     * @param j
     * @param cnt 当前已经匹配到的数量
     * @return
     */
    private boolean execute(char currChar, char[] dstWord, int i, int j, int cnt) {
        if (cnt == dstWord.length - 1 && dstWord[cnt] == currChar && !this.isExist[i][j]) {
            return true;
            // 不符合或者踩过这个点
        } else if (dstWord[cnt] != currChar || this.isExist[i][j]) {
            return false;
        } else {
            boolean ans = false;
            this.isExist[i][j] = true;
            for (int[] direct : direction) {
                int nextX = direct[0] + i;
                int nextY = direct[1] + j;
                // 边界条件判断
                if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length) {
                    continue;
                }
                ans = (ans | execute(this.board[nextX][nextY], dstWord, nextX, nextY, cnt + 1));
                if (ans) {
                    break;
                }
            }
            this.isExist[i][j] = false;
            return ans;
        }
    }
}