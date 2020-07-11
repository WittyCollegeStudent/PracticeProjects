package leetcode.level_medium._11maxArea;

/**
 * @author zhangbo22479
 * @date 2018/12/28
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        Solution2 solution = new Solution2();
        System.out.println(solution.maxArea(height));
    }

}

/**
 * 解法一(375ms):
 * 遍历所有可能，找到最大的面积
 */
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for (int indexStart = 0 ; indexStart < height.length ; indexStart ++) {
            int heightStart = height[indexStart];
            for (int indexEnd = indexStart + 1 ; indexEnd < height.length ; indexEnd ++) {
                int heightEnd = height[indexEnd];
                if (Math.min(heightStart, heightEnd) * (indexEnd - indexStart) > max) {
                    max = Math.min(heightStart, heightEnd) * (indexEnd - indexStart);
                }
            }
        }
        return max;
    }
}

/**
 * 解法二(19ms):
 * 双指针法，每次计算面积，并且移动较短的那根指针(因为容积受限于短的一侧)
 */
class Solution2 {
    public int maxArea(int[] height) {
        return calcMaxArea(height, 0, height.length - 1);
    }

    private int calcMaxArea(int[] height, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int indexStart = start, indexEnd = end;
        int max = (indexEnd - indexStart) * Math.min(height[indexStart], height[indexEnd]);
        while (indexStart < indexEnd + 1) {
            int currArea;
            // 如果后指针更短，则后指针前移
            if (height[indexStart] > height[indexEnd]) {
                indexEnd --;
                currArea = (indexEnd - indexStart) * Math.min(height[indexStart], height[indexEnd]);
                // 更新最大面积
                max = Math.max(max, currArea);
                // 如果前指针更短，则前指针后移
            } else if (height[indexStart] < height[indexEnd]) {
                indexStart ++;
                currArea = (indexEnd - indexStart) * Math.min(height[indexStart], height[indexEnd]);
                max = Math.max(max, currArea);
                // 如果两指针相等，则递归
            } else {
                int areaPre = calcMaxArea(height, indexStart + 1, indexEnd);
                int areaAfter = calcMaxArea(height, indexStart, indexEnd - 1);
                currArea = Math.max(areaPre, areaAfter);
                max = Math.max(max, currArea);
                return max;
            }
        }
        return max;
    }

}
