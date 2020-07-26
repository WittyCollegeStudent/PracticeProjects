package leetcode.search.bfs.qs279;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Qs279 {
}

class Solution {
    public int numSquares(int n) {
        // 剩余长度是否访问过
        boolean[] hasVisited = new boolean[n + 1];
        int lenth = 0;
        List<Integer> squares = generateSquares(n);
        // 剩余长度
        Queue<Integer> nextList = new LinkedList<>();
        nextList.add(n);
        while (!nextList.isEmpty()) {
            int size = nextList.size();
            while (size -- > 0) {
                int currLen = nextList.poll();
                for (int square : squares) {
                    int next = currLen - square;
                    if (next == 0) {
                        return lenth + 1;
                    }
                    if (next < 0) {
                        break;
                    }
                    if (hasVisited[next]) {
                        continue;
                    }
                    nextList.add(next);
                    hasVisited[next] = true;
                }
            }
            ++ lenth;
        }
        return lenth;
    }
    private List<Integer> generateSquares(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n ; i ++) {
            if (n / i >= i) {
                list.add(i * i);
            } else {
                break;
            }
        }
        return list;
    }
}
