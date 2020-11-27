package com.linksong.leetcode.tree;


/*
 *
 *  二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
 *  实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 *  返回转换后的单向链表的头节点。
 *
 *  输入： [4,2,5,1,3,null,6,0]
 *  输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 *
 *  来源：力扣（LeetCode）
 *
 *  解：对二叉树进行中序遍历即为一个升序的序列
 *
 *  设nn为二叉搜索树中节点的个数。
 *  中序遍历所有节点仅访问一次，所以时间复杂度为O(n).
 *  递归使用辅助栈空间O(n)，几个临时变量O(1)，因此总的空间复杂度为O(n).
 *
 * */
public class ConvertBiNode {
    TreeNode head = new TreeNode(-1);   //为了返回单向链表的头节点多设的一个节点
    TreeNode perv = null; //指向当前节点的前一个节点


    public TreeNode convertBiNode(TreeNode root) {
        recursiveMethod(root);
        return head.right;

    }

    private void recursiveMethod(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        recursiveMethod(treeNode.left);
        if (perv == null) {
            perv = treeNode;
            head.right = treeNode;
        } else {
            perv.right = treeNode;  //前一个节点的右指针指向当前节点
            perv = treeNode;        //更新perv指向
        }
        treeNode.left = null;       //当前节点的左指针设为null
        recursiveMethod(treeNode.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
    }
}
