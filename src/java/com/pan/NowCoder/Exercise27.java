package com.pan.NowCoder;

/**
 * 二叉树的镜像-面试思路
 * Created by FantasticPan on 2019/1/21.
 */
public class Exercise27 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }
        //不能TreeNode node = root，因为操作的是同一对象，后续root的操作会改变node的值
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        if (root.left != null) {
            Mirror(root.left);
        }

        if (root.right != null) {
            Mirror(root.right);
        }
    }
}
