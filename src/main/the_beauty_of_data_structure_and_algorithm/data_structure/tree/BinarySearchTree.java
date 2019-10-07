package main.the_beauty_of_data_structure_and_algorithm.data_structure.tree;

import main.common.TreeNode;

/**
 * @author wenzhuang
 * @date 2019-10-06 21:09
 */
public class BinarySearchTree extends BinaryTree{

    public TreeNode search(int value){
        TreeNode node  = root;
        while (node != null){
            if (value == node.val){
                return node;
            } else if (value < node.val){
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    public BinaryTree insert(int value){
        if (root == null){
            root = new TreeNode(value);
            return this;
        }
        TreeNode node  = root;
        while (true){
            if (value < node.val){
                if (node.left == null){
                    node.left = new TreeNode(value);
                    return this;
                }
                node = node.left;
            } else {
                if (node.right == null){
                    node.right = new TreeNode(value);
                    return this;
                }
                node = node.right;
            }
        }
    }

    public BinaryTree remove(int value){
        TreeNode node = root, p = null;
        //在树中查找value;
        while (node != null){
            if (value == node.val){
                break;
            } else if (value < node.val){
                p = node;
                node = node.left;
            } else {
                p = node;
                node = node.right;
            }
        }
        //没找到，直接返回
        if (node == null){
            return this;
        }
        //如果是有左右两个孩子的，把右子树最小节点与当前节点交换，标记删除
        if (node.left != null && node.right != null){
            TreeNode min = node.right, pMin = node;
            while (min.left != null){
                pMin = min;
                min = min.left;
            }
            node.val = min.val;
            p = pMin;
            node = min;
        }
        //删除节点后挂接的子树
        TreeNode child;
        if (node.left != null) {
            child = node.left;
        } else if (node.right != null){
            child = node.right;
        } else {
            child = null;
        }
        //删除根节点
        if (p == null) {
            root = child;
        } else if (p.left == node){
            //挂为左子树
            p.left = child;
        } else {
            //挂为右子树
            p.right = child;
        }
        return this;
    }

    public TreeNode findNext(TreeNode node){
        //有右子树，找右子树最小节点
        if (node.right != null){
            return findMin(node.right);
        }
        //无右子树，从根往下查找node，记录下最后一个大于node的节点
        TreeNode p = null, nd = root;
        while (nd != null){
            if (node.val == nd.val){
                break;
            } else if (node.val < nd.val){
                p = nd;
                nd = nd.left;
            } else {
                nd = nd.right;
            }
        }
        return p;
    }

    public TreeNode findPre(TreeNode node){
        //有左子树，找左子树的最大节点
        if (node.left != null){
            return findMax(node.left);
        }
        //无左子树，从根节点查找node，找最后一个小于node的节点
        TreeNode p = null, nd = root;
        while (nd != null){
            if (nd.val == node.val){
                break;
            } else if (node.val > nd.val){
                p = nd;
                nd = nd.right;
            } else {
                nd = nd.left;
            }
        }
        return p;
    }

    private TreeNode findMin(TreeNode node){
        if (node == null){
            return null;
        }
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    private TreeNode findMax(TreeNode node){
        if (node == null){
            return null;
        }
        while (node.right != null){
            node = node.right;
        }
        return node;
    }
}
