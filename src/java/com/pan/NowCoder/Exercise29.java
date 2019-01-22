package com.pan.NowCoder;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵-面试思路-画图让抽象形象化
 * Created by FantasticPan on 2019/1/21.
 */
public class Exercise29 {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int top = 0;
        int right = col - 1;
        int bottom = row - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }

            for (int j = top + 1; j <= bottom; j++) {
                list.add(matrix[j][right]);
            }

            if (top != bottom) { //注意这里是!=，不是<=
                for (int k = right - 1; k >= left; k--) {
                    list.add(matrix[bottom][k]);
                }
            }

            if (left != right) {
                for (int m = bottom - 1; m > top; m--) {
                    list.add(matrix[m][left]);
                }
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        return list;
    }
}
