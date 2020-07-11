package leetcode.divideconquer.qs95;

import java.util.ArrayList;
import java.util.List;

public class Qs95 {

    public static void main(String[] args) {

    }

}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){this.val=val;}
    TreeNode(int val,TreeNode left,TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
}

class Solution {
    public List<TreeNode> generateTrees(int n) {
        int[] nums = new int[n];
        for (int i = 0 ; i < n ; i ++) {
            nums[i] = i + 1;
        }
        return generate(nums, 0, n - 1);
    }
    private List<TreeNode> generate(int[] nums, int start, int end){
        List<TreeNode> treeNodeList = new ArrayList<>();
        if (start > end) {
            return treeNodeList;
        } else if (start == end) {
            treeNodeList.add(new TreeNode(nums[start]));
            return treeNodeList;
        } else {
            for (int i = start ; i <= end ; i ++) {
                List<TreeNode> leftList = generate(nums, start, i - 1);
                List<TreeNode> rightList = generate(nums,i + 1, end);
                TreeNode root;
                if (leftList.size() <= 0 && rightList.size() <= 0) {
                    treeNodeList.add(new TreeNode(nums[i]));
                } else if (leftList.size() <= 0) {
                    // 仅是左子树为空
                    for (TreeNode rightNode : rightList) {
                        root = new TreeNode(nums[i]);
                        root.right = rightNode;
                        treeNodeList.add(root);
                    }
                } else if (rightList.size() <= 0){
                    // 仅是右子树为空
                    for (TreeNode leftNode : leftList) {
                        root = new TreeNode(nums[i]);
                        root.left = leftNode;
                        treeNodeList.add(root);
                    }
                } else {
                    // 左右子树均不为空
                    for (int j = 0; j < leftList.size() ; j ++) {
                        for (TreeNode rightNode : rightList) {
                            root = new TreeNode(nums[i]);
                            root.left = leftList.get(j);
                            root.right = rightNode;
                            treeNodeList.add(root);
                        }
                    }
                }
            }
            return treeNodeList;
        }
    }
}
