package com.pan.EightSorts;

/**
 * 基数排序
 * Created by FantasticPan on 2019/1/26.
 */
public class RadixSort {

    public static void main(String[] args) {
        //int[] x = {2, 4, 1, 8, 5, 6, 3, 0, 7, 9};
        //int[] x = {5, 1, 3, 4, 2};
        //new RadixSort().radixSort(x);
    }

    public void radixSort(int[] array) {
        if (array == null) {
            return;
        }

        //找到最大数
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        //需要遍历的次数由数组最大值的位数来决定
        int times = 0;
        while (max > 0) {
            max /= 10;
            ++times;
        }

        int count = 1;
        for (int i = 1; i <= times; i++) {
            int[][] buckets = new int[array.length][10];

            for (int j = 0; j < array.length; j++) {
                int num = (array[j] / count) % 10;
                buckets[j][num] = array[j];
            }

            int k = 0;
            for (int j = 0; j < 10; j++) {
                for (int l = 0; l < array.length; l++) {
                    if (buckets[l][j] != 0) { //java构建int数组默认为0
                        array[k++] = buckets[l][j];
                    }
                }
            }
            count *= 10;
        }

        for (int x : array) {
            System.out.print(x + " ");
        }
    }
}
