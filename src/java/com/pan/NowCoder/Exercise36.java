package com.pan.NowCoder;

/**
 * 分解让复杂问题简单-二叉搜索树与双向链表
 * Created by FantasticPan on 2019/2/16.
 */
public class Exercise36 {

    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }

        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }

        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p = left;
        // 2.定位至左子树双链表最后一个节点
        while (p != null && p.right != null) {
            p = p.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表，双向连接操作
        if (left != null) {
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }

        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(pRootOfTree.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后，双向连接操作
        if (right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }

        return left != null ? left : pRootOfTree;
    }
}
