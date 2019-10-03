package main.lintcode_solutions;

import java.util.ArrayList;

/**
 * @author wenzhuang
 * @date 2019-10-03 14:59
 */
public class T67_BinaryTreeInorderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        return list;
    }

    private void inorderTraversal(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);

    }
}
