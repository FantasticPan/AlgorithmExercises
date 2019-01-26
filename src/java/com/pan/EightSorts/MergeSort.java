package com.pan.EightSorts;

/**
 * 归并排序
 * Created by FantasticPan on 2019/1/25.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] x = {2, 4, 1, 8, 5, 6, 3, 0, 7, 9};
        new MergeSort().mergeSort(x);
    }

    public void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
        for (int x : array) {
            System.out.print(x + " ");
        }
    }

    public void mergeSort(int[] array, int left, int right) {
        int mid = (left + right) >> 1;
        if (left < right) {
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        //当某一方比较完后退出循环
        while (i <= mid && j <= right) {

            if (array[i] < array[j]) {
                //temp[k++]，先使用，在自增
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }

        //将temp中的元素全部拷贝到原数组中
        int t = 0;
        //从左到右进行拷贝
        while (left <= right) {
            array[left++] = temp[t++];
        }

        //for (int k2 = 0; k2 < temp.length; k2++) {
        //    array[left + k2] = temp[k2];
        //}
    }
}
