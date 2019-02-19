package com.pan.NowCoder;

/**
 * 时间效率-数组中出现次数超过一半的数字
 * Created by FantasticPan on 2019/2/19.
 */
public class Exercise39 {

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else {
                if (array[i] == result) {
                    times++;
                } else {
                    times--;
                }
            }
        }

        //出现次数超过一半判断
        times = 0;
        for (int anArray : array) {
            if (result == anArray) {
                times++;
            }
        }
        if (times << 1 <= array.length) {
            return 0;
        }
        return result;
    }
}
