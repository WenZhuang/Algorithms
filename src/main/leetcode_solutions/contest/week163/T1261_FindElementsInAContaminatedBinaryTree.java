package main.leetcode_solutions.contest.week163;

import main.common.TreeNode;

public class T1261_FindElementsInAContaminatedBinaryTree {
    class FindElements {
        private TreeNode root;

        public FindElements(TreeNode root) {
            recover(root);
            this.root = root;
        }

        private void recover(TreeNode root) {
            if (root == null) {
                return;
            }

            if (root.val == -1) {
                root.val = 0;
            }
            if (root.left != null) {
                root.left.val = 2 * root.val + 1;
            }
            if (root.right != null) {
                root.right.val = 2 * root.val + 2;
            }
            recover(root.left);
            recover(root.right);
        }

        public boolean find(int target) {
            return find(root, target);
        }

        private boolean find(TreeNode root, int target) {
            if (root == null || root.val > target) {
                return false;
            }
            if (root.val == target) {
                return true;
            }
            return find(root.left, target) || find(root.right, target);
        }
    }
}
