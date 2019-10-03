package main.lintcode_solutions;

/**
 * @author wenzhuang
 * @date 2019-10-03 12:51
 */
public class T632_BinaryTreeMaximumNode {
    /**
     * @param root the root of binary tree
     * @return the max ndoe
     */
    public TreeNode maxNode(TreeNode root) {
        // Write your code here
        if(root == null){
            return null;
        }

        TreeNode left = maxNode(root.left);
        TreeNode right = maxNode(root.right);

        TreeNode node = null;
        if (left != null && right != null) {
            node = left.val > right.val ? left : right;
        }else if (left != null) {
            node = left;
        }else if (right != null) {
            node = right;
        }else {
            return root;
        }

        return root.val > node.val ? root : node;
    }
}
