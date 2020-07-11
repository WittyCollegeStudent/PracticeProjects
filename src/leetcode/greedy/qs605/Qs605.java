package leetcode.greedy.qs605;

import java.util.Arrays;
import java.util.Random;

public class Qs605 {

    public static void main(String[] args) {
        int size = 100, n = 7;
        int[] flowers = new int[size];
        Random random = new Random();
        for (int i = 0 ; i < size ; i ++) {
            flowers[i] = random.nextInt(2);
        }
        Solution so = new Solution();
        System.out.println(Arrays.toString(flowers) + "  " + n);
        System.out.println(so.canPlaceFlowers(flowers, n));
    }

}

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int preNum = 0, cnt = 0;
        for (int i = 0 ; i < flowerbed.length ; i++) {
            if ((preNum | flowerbed[i]) == 0 && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                cnt ++;
                preNum = 1;
            } else {
                preNum = flowerbed[i];
            }
        }
        return n <= cnt;
    }
}