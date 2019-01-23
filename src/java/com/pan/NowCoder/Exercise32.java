package com.pan.NowCoder;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上到下打印二叉树-面试思路-举例让抽象具体化
 * Created by FantasticPan on 2019/1/22.
 */
public class Exercise32 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> treeNode = new ArrayList<>();
        LinkedList<TreeNode> treeList = new LinkedList<>();
        if (root == null) {
            return treeNode;
        }
        if (root.left == null && root.right == null) {
            treeNode.add(root.val);
            return treeNode;
        }

        while (root != null) {
            treeNode.add(root.val);
            if (root.left != null) {
                treeList.addLast(root.left);
            }
            if (root.right != null) {
                treeList.addLast(root.right);
            }
            root = treeList.pollFirst();
        }
        return treeNode;
    }
}
