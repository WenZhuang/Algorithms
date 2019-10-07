package main.leetcode_solutions.tree;

import main.common.TreeNode;

/**
 * @author wenzhuang
 * @date 2019-10-07 15:18
 */
public class T98_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max){
        if (root == null){
            return true;
        }
        return (min < root.val && root.val < max) && isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
    //TODO 中序遍历解法
}
