package leetcode.binarysearch.qs153;

public class Qs153 {

    public static void main(String[] args) {

    }

}

class Solution {

    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return binarySearch(nums, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int start, int end) {
        // 如果是升序排列的话，直接返回第一个元素
        if (nums[start] <= nums[end]) {
            return nums[start];
        }
        if (end - start == 1 || start == end) {
            return nums[end];
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] < nums[start]) {
            return binarySearch(nums, start, mid);
        } else {
            return binarySearch(nums, mid, end);
        }
    }

}