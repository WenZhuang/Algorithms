package main.lintcode_solutions;

import java.util.ArrayList;

/**
 * @author wenzhuang
 * @date 2019-10-03 14:58
 */
public class T66_BinaryTreePreorderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }

    private void preorderTraversal(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }

        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);

    }
}
