package leetcode.tool;

import java.util.Random;

public class RandomTool {

    private Random random = new Random();

    public int[] generateRandArray(int size, int bound) {
        int[] arr = new int[size];
        for (int i = 0 ; i < size ; i ++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

}
