package com.linksong.leetcode.tree;

/*
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 来源：力扣（LeetCode）98
 *
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 来源：力扣（LeetCode）110
 * */

public class IsValiddBST {

    TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        if (!isValidBST(root.left)){
            return false;
        }
        if (pre != null && pre.val >= root.val){
            return false;
        }
        pre = root;
        if (!isValidBST(root.right)){
            return false;
        }
        return true;
    }


    //错误的解法

    /*
    * 陷阱1.所有的左子树都要比右子树小
    *
    * 陷阱2.边界情况，可能会比int的最小值小
    *
    *
    * */
    private boolean isBST(TreeNode treeNode) {
        boolean isBST = false;
        if (treeNode == null) {
            isBST = true;
        }
        if (treeNode.left.val < treeNode.val && treeNode.val < treeNode.right.val){
            isBST(treeNode.left);
            isBST(treeNode.right);
            isBST = true;
        }else {
            isBST = false;
        }
        return isBST;
    }


    public boolean isBalanced(TreeNode root) {
        return false;

    }



}
