package leetcode.binarysearch.qs69;

import java.util.Timer;

public class Qs69 {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        Solution so = new Solution();
        long time1 = System.currentTimeMillis();
        for (int i = 0 ; i < Integer.MAX_VALUE / 20; i ++) {
            int answer = (int) Math.sqrt(i);
            int value = so.mySqrt(i);
            long time2 = System.currentTimeMillis();
            if (value != answer || time2 - time1 > 3000) {
                System.out.println(time2 - time1);
                time1 = time2;
                System.out.println(i + ":");
                System.out.println("answer = " + answer);
                System.out.println("value = " + value);
            }
        }
    }

}

class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int result = (int) Math.exp(0.5 * Math.log(x));
        int num1 = result, num2 = result + 1, num3 = result + 2;
        if (x / num3 >= num3) {
            return num3;
        } else if (x / num2 >= num2) {
            return num2;
        } else {
            return num1;
        }
    }
}