package com.pan.EightSorts;

/**
 * 交换排序
 * Created by FantasticPan on 2019/1/25.
 */
public class ExchangeSort {

    public static void main(String[] args) {
        int[] x = {2, 4, 1, 8, 5, 6, 3, 0, 7, 9};
        new ExchangeSort().bubbleSort1(x);
        System.out.println();
        new ExchangeSort().bubbleSort2(x);
        System.out.println();
        new ExchangeSort().quickSort(x);
    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    public void bubbleSort1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //每一次循环，都把最大的数沉到数组末尾
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        for (int x : array) {
            System.out.print(x + " ");
        }
    }

    /**
     * 冒泡排序改进
     *
     * @param array
     */
    public void bubbleSort2(int[] array) {
        int low = 0;
        int high = array.length - 1;
        int i;
        while (low < high) {
            for (i = low; i < high; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            high--;
            for (i = high; i > low; i--) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }
            }
            low++;
        }
        for (int x : array) {
            System.out.print(x + " ");
        }
    }

    /**
     * 快速排序
     *
     * @param array
     */
    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        for (int x : array) {
            System.out.print(x + " ");
        }
    }

    public void quickSort(int[] array, int left, int right) {
        int _left = left;
        int _right = right;
        if (left <= right) {
            int temp = array[left];
            while (left != right) {
                while (right > left && array[right] >= temp) {
                    right--;
                }
                array[left] = array[right];

                while (left < right && array[left] <= temp) {
                    left++;
                }
                array[right] = array[left];
            }
            //此时low=high 是基准元素的位置，也是空出来的那个位置
            array[right] = temp;
            quickSort(array, _left, left - 1);
            quickSort(array, right + 1, _right);
        }
    }
}
