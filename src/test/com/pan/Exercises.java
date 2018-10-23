package com.pan;

import org.junit.Test;

/**
 *
 */
public class Exercises {
    /**
     * 知识点：查找
     * <p>
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0.
     */
    @Test
    public void test() {
        //int[] array = {3, 4, 5, 1, 2};
        //int[] array = {2, 2, 2, 2, 2, 2, 1, 2};
        int[] array = {1, 1, 1, 0, 1};
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            //int mid = low + (high - low) / 2;
            int mid = (low + high) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] == array[high]) {
                high = high - 1;
            } else {
                high = mid;
            }
        }
        System.out.println(array[low]);
    }
}
