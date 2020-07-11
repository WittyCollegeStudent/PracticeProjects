package leetcode.binarysearch.qs34;

import java.util.Arrays;

public class Qs34 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 4, 5, 6};
        int target = 4;
        Solution so = new Solution();
        System.out.println(Arrays.toString(so.searchRange(arr, target)));
    }

}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return new int[]{-1, -1};
        }
        return new int[]{
                findFirstIndex(nums, 0, nums.length - 1, target),
                findLastIndex(nums, 0, nums.length - 1, target)
        };
    }
    private int findFirstIndex(int[] nums, int start, int end, int target) {
        int mid;
        while (start < end) {
            if (end - start == 1) {
                if (nums[start] == target) {
                    return start;
                } else if (nums[end] == target) {
                    return end;
                } else {
                    return -1;
                }
            }
            mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return (nums[start] == target ? start : -1);
    }
    private int findLastIndex(int[] nums, int start, int end, int target) {
        int mid;
        while (start < end) {
            if (end - start == 1) {
                if (nums[end] == target) {
                    return end;
                } else if (nums[start] == target) {
                    return start;
                } else {
                    return -1;
                }
            }
            mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return (nums[start] == target ? start : -1);
    }
}