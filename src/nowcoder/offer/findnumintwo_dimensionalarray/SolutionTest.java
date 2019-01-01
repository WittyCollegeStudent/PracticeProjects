package nowcoder.offer.findnumintwo_dimensionalarray;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zhangbo22479
 * @date 2019/1/1
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    private boolean existsTarget;
    private int target;
    private int[][] array;

    @Parameterized.Parameters
    public static Collection<Object[]> t() {
        return Arrays.asList(new Object[][]{
                {false, 5, Arrays.asList(new Object[][] {})},
                {true, 5, Arrays.asList(new Object[][] {{1, 2, 3}, {3, 4, 6}, {5, 7, 8}})},
                {false, 9, Arrays.asList(new Object[][] {{1, 2, 3}, {3, 4, 6}, {5, 7, 8}})},
                {true, 6, Arrays.asList(new Object[][] {{1, 2, 3}, {3, 4, 6}, {5, 7, 8}})},
                {true, 4, Arrays.asList(new Object[][] {{1, 2, 3}, {3, 4, 6}, {5, 7, 8}})},
                {false, 0, Arrays.asList(new Object[][] {{1, 2, 3}, {3, 4, 6}, {5, 7, 8}})}
        });
    }

    public SolutionTest(boolean existsTarget, int target, List<Integer[]> array) {
        this.existsTarget = existsTarget;
        this.target = target;
        if (array == null) {
            this.array = null;
        } else {
            this.array = new int[array.size()][];
            Object[][] tempArray = array.toArray(new Object[0][0]);
            for (int i = 0 ; i < tempArray.length ; i ++) {
                this.array[i] = new int[tempArray[i].length];
                for (int j = 0 ; j < tempArray[i].length ; j ++) {
                    this.array[i][j] = (int) tempArray[i][j];
                }
            }
        }
    }

    @Test
    public void find() {
        assertEquals(existsTarget, new Solution2().Find(target, array));
    }
}