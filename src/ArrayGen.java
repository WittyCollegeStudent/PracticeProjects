import java.util.Arrays;
import java.util.Random;

public class ArrayGen {

    public static void main(String[] args) {
        int size = 40;
        Random random = new Random();
        int[][] arr = new int[size][size];
        for (int i = 0 ; i < size ; i ++) {
            for (int j = 0 ; j < size; j ++) {
                arr[i][j] = random.nextInt(100);
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }

}
