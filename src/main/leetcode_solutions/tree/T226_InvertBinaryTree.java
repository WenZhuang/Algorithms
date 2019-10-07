package main.leetcode_solutions.tree;

import main.common.TreeNode;

/**
 * @author wenzhuang
 * @date 2019-10-07 13:20
 */
public class T226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
