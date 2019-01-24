package com.pan.EightSorts;

/**
 * 插入排序
 * Created by FantasticPan on 2019/1/24.
 */
public class InsertSort {

    public static void main(String[] args) {
        int x[] = {2, 4, 1, 8, 5, 6, 3, 0, 7, 9};
        new InsertSort().insertSort(x);
        System.out.println();
        new InsertSort().twoInsertSort(x);
    }

    /**
     * 直接插入排序
     *
     * @param array
     */
    public void insertSort(int[] array) {
        //第1个数肯定是有序的，从第2个数开始遍历，依次插入有序序列
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j;
            //将有序数组中比要插入的数大的数右移
            for (j = i - 1; j >= 0 && array[j] > temp; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = temp;
        }
        for (int x : array) {
            System.out.print(x + " ");
        }
    }

    /**
     * 二分插入排序
     *
     * @param array
     */
    public void twoInsertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int left = 0;
            int right = i - 1;
            int mid;

            //二分查找
            while (left <= right) {
                mid = (left + right) >> 1;
                if (temp < array[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            //插入排序，有序数组中比要插入的数大的数右移
            for (int j = i - 1; j >= left; j--) {
                array[j + 1] = array[j];
            }

            //将left位置赋值为要插入的数
            array[left] = temp;
        }
        for (int x : array) {
            System.out.print(x + " ");
        }
    }
}
