package com.pan.NowCoder;

/**
 * 树的子结构-鲁棒性
 * Created by FantasticPan on 2019/1/21.
 */
public class Exercise26 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root1 != null && root2 != null) {
            //如果找到了对应Tree2的根节点的点
            if (root1.val == root2.val) {
                //以这个根节点为为起点判断是否包含Tree2
                result = doesTree1HaveTree2(root1, root2);
            }

            //如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }

            //如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    /**
     * @param root1
     * @param root2
     * @return
     */
    private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        //如果Tree2已经遍历完了都能对应的上，返回true，两个if顺序不能调换
        //应为在调用函数中是判断了root2不为空的，座椅如果此时root2为空，则一定是遍历完成的
        if (root2 == null) {
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if (root1 == null) {
            return false;
        }

        //如果其中有一个点没有对应上，返回false
        if (root1.val != root2.val) {
            return false;
        }

        //根节点相同，判断左右子节点是否相等
        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }
}
