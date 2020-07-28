package leetcode.search.backtracking.qs257;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Qs257 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    private List<String> pathList;
    public List<String> binaryTreePaths(TreeNode root) {
        pathList = new ArrayList<>();
        execute(new ArrayList<>(), root);
        return pathList;
    }
    private void execute(List<Integer> currPath, TreeNode nodeToAdd) {
        if (nodeToAdd == null) {
            return;
        } else {
            currPath.add(nodeToAdd.val);
            if (nodeToAdd.left == null && nodeToAdd.right == null) {
                if (!currPath.isEmpty()) {
                    pathList.add(join(currPath, "->"));
                }
            } else {
                // left
                execute(currPath, nodeToAdd.left);
                // right
                execute(currPath, nodeToAdd.right);
            }
            currPath.remove(currPath.size() - 1);
        }
    }
    private String join(List<Integer> path, String separator) {
        StringBuffer result = new StringBuffer();
        int lastIndex = path.size() - 1;
        for (int i = 0 ; i < lastIndex; i ++) {
            result.append(path.get(i)).append(separator);
        }
        result.append(path.get(lastIndex));
        return result.toString();
    }
}