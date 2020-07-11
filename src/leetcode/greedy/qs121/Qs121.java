package leetcode.greedy.qs121;

import java.util.Arrays;
import java.util.Random;

public class Qs121 {

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
        int currMin = prices[0], maxProfit = 0;
        for (int price : prices) {
            if (price < currMin) {
                currMin = price;
            } else {
                maxProfit = (maxProfit > (price - currMin) ? maxProfit : (price - currMin));
            }
        }
        return maxProfit;
    }
}
