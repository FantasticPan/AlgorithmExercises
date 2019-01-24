package com.pan.EightSorts;

/**
 * 选择排序
 * Created by FantasticPan on 2019/1/24.
 */
public class SelectSort {

    public static void main(String[] args) {
        //int[] x = {2, 4, 1, 8, 5, 6, 3, 0, 7, 9};
        int[] x = {5, 1, 3, 4, 2};
        new SelectSort().simpleSelectSort(x);
        System.out.println();
        new SelectSort().twoSelectSort(x);
    }

    /**
     * 简单选择排序
     *
     * @param array
     */
    public void simpleSelectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {

                if (array[min] > array[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }

        for (int x : array) {
            System.out.print(x + " ");
        }
    }

    /**
     * 二元选择排序
     *
     * @param array
     */
    public void twoSelectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            int max = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[max]) {
                    max = j;
                } else if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }

            //如果第一个数是最大值，则将原来调换的最大时赋值给max
            if (i == max) {
                max = min;
            }

            if (array.length - 1 - i != max) {
                int temp = array[i];
                array[i] = array[max];
                array[max] = temp;
            }
        }
    }
}
