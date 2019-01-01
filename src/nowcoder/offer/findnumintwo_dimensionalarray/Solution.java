package nowcoder.offer.findnumintwo_dimensionalarray;

/**
 * @author zhangbo22479
 * @date 2019/1/1
 * @description 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序
 * ，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断
 * 数组中是否含有该整数。
 */
public class Solution {

    public boolean Find(int target, int [][] array) {
        if (array == null || array.length <= 0 || array[0].length <= 0) {
            return false;
        }
        return FindTarget(target, array, array[0].length - 1, 0);
    }

    private boolean FindTarget(int target, int[][] array, int startX, int startY) {
        if (startX < 0 || startX >= array[0].length || startY < 0 || startY >= array.length) {
            return false;
        }
        int key = array[startY][startX];
        if (target == key) {
            return true;
        } else if (target > key) {
            return FindTarget(target, array, startX, ++ startY);
        } else {
            return FindTarget(target, array, -- startX, startY);
        }
    }

}