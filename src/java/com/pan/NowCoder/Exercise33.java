package com.pan.NowCoder;

import java.util.Arrays;

/**
 * 举例让抽象具体化-二叉搜索树的后序遍历序列
 * Created by FantasticPan on 2019/1/23.
 */
public class Exercise33 {

    public boolean VerifySequenceOfBST(int[] sequence) {
        if (sequence == null) return false;
        int length = sequence.length;
        int root = sequence[length - 1];
        boolean left = true;
        boolean right = true;
        int i = 0;
        for (; i < length - 1; i++) {
            if (sequence[i] > root) break;
        }

        int j = i;
        for (; j < length - 1; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }

        if (i > 0) {
            left = VerifySequenceOfBST(Arrays.copyOfRange(sequence, 0, i)); //左闭右开
        }

        if (i < length - 1) {
            right = VerifySequenceOfBST(Arrays.copyOfRange(sequence, i, length - 1));
        }

        return (left && right);
    }
}
