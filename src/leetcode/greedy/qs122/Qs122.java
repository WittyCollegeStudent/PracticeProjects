package leetcode.greedy.qs122;

import java.util.Arrays;
import java.util.Random;

public class Qs122 {

    public static void main(String[] args) {
        int size = 6;
        int[] prices = new int[size];
        Random random = new Random();
        for (int i = 0 ; i < size ; i ++) {
            prices[i] = random.nextInt(50);
        }
        Solution so = new Solution();
        System.out.println(Arrays.toString(prices));
        System.out.println(so.maxProfit(prices));
    }

}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int startPrice = prices[0], currProfits = 0;
        for (int price : prices) {
            if (price > startPrice) {
                currProfits += (price - startPrice);
                startPrice = price;
            } else {
                startPrice = price;
            }
        }
        return currProfits;
    }
}