package main.leetcode_solutions.tree;

import main.common.TreeNode;

/**
 * @author wenzhuang
 * @date 2019-10-07 15:16
 */
public class T112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        if (root.left == null && root.right == null){
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) ||  hasPathSum(root.right, sum - root.val);
    }
}
