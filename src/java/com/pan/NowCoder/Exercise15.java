package com.pan.NowCoder;

/**
 * 二进制中1的个数
 * Created by FantasticPan on 2019/1/17.
 */
public class Exercise15 {

    /**
     * 把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作
     *
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        //法1
        //int count = 0;
        //while (n != 0) {
        //    count++;
        //    n &= (n - 1);
        //}
        //return count;

        //法2
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((flag & n) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
}
