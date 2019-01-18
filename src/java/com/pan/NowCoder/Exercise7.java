package com.pan.NowCoder;

import com.pan.NowCoder.util.TreeNode;

/**
 * 重建二叉树
 * Created by FantasticPan on 2019/1/16.
 */
public class Exercise7 {

    //public int val;
    //public TreeNode left;
    //public TreeNode right;
    //
    //public TreeNode(int x) {
    //    val = x;
    //}

    //前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    /**
     * 题目中前序遍历的第一个节点{1}一定是这棵二叉树的根节点，根据中序遍历序列，
     * 可以发现中序遍历序列中节点{1}之前的{4,7,2}是这棵二叉树的左子树，{5,3,8,6}是这棵二叉树的右子树。
     * 然后，对于左子树，递归地把前序子序列{2,4,7}和中序子序列{4,7,2}看成新的前序遍历和中序遍历序列。
     * 此时，对于这两个序列，该子树的根节点是{2}，该子树的左子树为{4,7}、右子树为空，
     * 如此递归下去（即把当前子树当做树，又根据上述步骤分析）。{5,3,8,6}这棵右子树的分析也是这样
     *
     * @param pre      前序遍历数组
     * @param startPre 前序第一个元素
     * @param endPre   前序最后一个元素
     * @param in       中序遍历数组
     * @param startIn  中序第一个元素
     * @param endIn    中序一个元素
     * @return
     */
    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        //建立根节点
        TreeNode tree = new TreeNode(pre[startPre]);
        tree.left = null;
        tree.right = null;
        int i;
        if (startPre == endPre && startIn == endIn) {
            return tree;
        }

        //找中序遍历中的根节点
        for (i = startIn; i < endIn; i++) {
            if (pre[startPre] == in[i]) {
                break;
            }
        }

        //在中序划分左右子树
        int leftLength = i - startIn;//左子树
        int rightLength = endIn - i;//右子树
        //遍历左子树
        if (leftLength > 0) {
            tree.left = reConstructBinaryTree(pre, startPre + 1, startPre + leftLength, in, startIn, i - 1);
        }
        //遍历右子树
        if (rightLength > 0) {
            tree.right = reConstructBinaryTree(pre, startPre + leftLength + 1, endPre, in, i + 1, endIn);
        }

        return tree;
    }
}
