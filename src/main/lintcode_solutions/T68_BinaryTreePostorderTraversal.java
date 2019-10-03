package main.lintcode_solutions;

import java.util.ArrayList;

/**
 * @author wenzhuang
 * @date 2019-10-03 15:00
 */
public class T68_BinaryTreePostorderTraversal {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> list = new ArrayList<>();
        postorderTraversal(root, list);
        return list;
    }

    private void postorderTraversal(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }

        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);

    }
}
