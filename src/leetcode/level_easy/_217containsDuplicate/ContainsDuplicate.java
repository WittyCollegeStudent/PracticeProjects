package leetcode.level_easy._217containsDuplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author zhangbo22479
 * @date 2018/12/9
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        Random random = new Random();
        int min = -24500, max = 279285;
        int[] nums = new int[max - min + 1];
        int index = 0;
        for (int i = min ; i <= max ; i ++) {
            nums[index ++] = i;
        }
        System.out.println("before sort:");
        System.out.println(Arrays.toString(nums));
        System.out.println("after sort:");
        Solution solution = new Solution();
        System.out.println(solution.containsDuplicate(nums));
    }
}


/**
 * 先排序，再查找重复元素
 */
class Solution {

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return false;
        } else {
//            quickSort(nums, 0, nums.length - 1);
            Arrays.sort(nums);
            int key = nums[0];
            for (int index = 1 ; index < nums.length ; index ++) {
                if (nums[index] == key) {
                    return true;
                } else {
                    key = nums[index];
                }
            }
            return false;
        }
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end || nums == null || nums.length == 0) {
            return ;
        }
        int key = nums[start];
        int left = start, right = end;
        while (left < right) {
            // 自右往左找第一个小于key的
            for (; left < right ; right -- ) {
                if (nums[right] < key) {
                    swap(nums, left, right);
                    break;
                }
            }
            // 自左往右找第一个大于key的
            for (; left < right ; left ++ ) {
                if (nums[left] > key) {
                    swap(nums, left, right);
                    break;
                }
            }
        }
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }

    private void swap(int[] nums, int indexA, int indexB) {
        int temp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = temp;
    }

}

/**
 * 放入set中以去除重复元素，比较set和原数组的长度
 */
class Solution2{

    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return nums.length != set.size();
    }

}