package com.pan.NowCoder;

import java.util.ArrayList;

/**
 * 时间效率-最小的k个数
 * Created by FantasticPan on 2019/2/19.
 */
public class Exercise40 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (k > input.length) {
            return integers;
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] < input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
            integers.add(input[input.length - i - 1]);
        }
        return integers;
    }
}
