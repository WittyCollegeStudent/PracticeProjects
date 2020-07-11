package nowcoder.offer.findnumintwo_dimensionalarray;

/**
 * @author zhangbo22479
 * @date 2019/1/1
 * @description 非递归做法
 */
public class Solution2 {

    public boolean Find(int target, int [][] array) {
        if (array == null || array.length <= 0 || array[0].length <= 0) {
            return false;
        }
        // 从右上角开始执行搜索
        int startX = array[0].length - 1, startY = 0;
        while (0 <= startX && startX <= array[0].length - 1 && 0 <= startY && startY <= array.length - 1) {
            int key = array[startY][startX];
            if (key == target) {
                return true;
            } else if (key > target) {
                startX -- ;
            } else {
                startY ++;
            }
        }
        return false;
    }

}