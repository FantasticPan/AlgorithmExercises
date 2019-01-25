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
        System.out.println();
        new SelectSort().heapSort(x);
    }

    /**
     * 简单选择排序
     *
     * @param array
     */
    public void simpleSelectSort(int[] array) {
        for (int i = 0; i < array.length >> 1; i++) {
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
        for (int i = 0; i < array.length / 2; i++) {
            int min = i;
            int max = i;
            for (int j = i + 1; j < array.length - i; j++) {
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

            //如果第一个数是最大值，则将原来调换的最大值赋值给max
            if (i == max) {
                max = min;
            }

            if (array.length - 1 - i != max) {
                int temp = array[array.length - 1 - i];
                array[array.length - 1 - i] = array[max];
                array[max] = temp;
            }
        }

        for (int x : array) {
            System.out.print(x + " ");
        }
    }

    public void heapSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            //构建堆
            createMaxHeap(array, array.length - 1 - i);
            if (0 != array.length - 1 - i) {
                int temp = array[0];
                array[0] = array[array.length - 1 - i];
                array[array.length - 1 - i] = temp;
            }
        }

        for (int x : array) {
            System.out.print(x + " ");
        }
    }

    public void createMaxHeap(int[] array, int lastIndex) {
        //从最后一个非叶节点开始
        for (int i = (lastIndex - 1) >> 1; i >= 0; i--) {
            //保存当前正在判断的节点
            int k = i;
            //如果当前k节点的子节点存在
            while (2 * k + 1 <= lastIndex) {
                //biggerIndex总是记录较大节点的值，先赋值为当前节点的左子节点的索引
                int biggerIndex = 2 * k + 1;
                //如果右节点存在
                if (biggerIndex + 1 <= lastIndex) {
                    if (array[biggerIndex] < array[biggerIndex + 1]) {
                        biggerIndex++;
                    }
                }
                if (array[k] < array[biggerIndex]) {
                    int temp = array[k];
                    array[k] = array[biggerIndex];
                    array[biggerIndex] = temp;
                    //如果子节点更换了，那么，以子节点为根的子树会不会受到影响呢？
                    k = biggerIndex;
                    //如果不用交换，那么，就直接终止循环了
                } else {
                    break;
                }
            }
        }
    }
}
