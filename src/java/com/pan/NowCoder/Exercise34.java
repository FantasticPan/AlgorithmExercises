package com.pan.NowCoder;

import java.util.ArrayList;

/**
 * 举例让抽象具体化-二叉树中和为某一值的路径
 * Created by FantasticPan on 2019/2/15.
 */
public class Exercise34 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    private ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return arrayLists;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            arrayLists.add(new ArrayList<Integer>(list)); //必须new一个ArrayList，不然传的是引用会改变list的值
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1); //返回父节点

        return arrayLists;
    }
}
