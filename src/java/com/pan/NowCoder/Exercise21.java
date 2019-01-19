package com.pan.NowCoder;

/**
 * 调整数组顺序使奇数位于偶数前面
 * Created by FantasticPan on 2019/1/19.
 */
public class Exercise21 {

    public void reOrderArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int n = 0; n < array.length - 1; n++) {
                if (array[n] % 2 == 0 && array[n + 1] % 2 == 1) {
                    int x = array[n];
                    array[n] = array[n + 1];
                    array[n + 1] = x;
                }
            }
        }
    }
}