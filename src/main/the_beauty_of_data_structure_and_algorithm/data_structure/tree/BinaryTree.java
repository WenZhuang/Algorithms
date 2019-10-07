package main.the_beauty_of_data_structure_and_algorithm.data_structure.tree;

import main.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wenzhuang
 * @date 2019-10-06 21:08
 */
public class BinaryTree {
    TreeNode root;

    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        res.addAll(preorderTraversal(root.left));
        res.add(root.val);
        res.addAll(preorderTraversal(root.right));
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        res.add(root.val);
        return res;
    }

    public List<List<Integer>> levelTraversal(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                res.add(level);
            }
        }
        return res;
    }
    //TODO 非递归写法

}
