package com.pan.NowCoder;

/**
 * 斐波那契数列
 * Created by FantasticPan on 2019/1/18.
 */
public class Exercise10 {

    public int Fibonacci(int n) {
        //使用递归，时间复杂度很大
        //if (n == 0) {
        //    return 0;
        //}
        //if (n == 1) {
        //    return 1;
        //}
        //if (n == 2) {
        //    return 1;
        //}
        //int result = Fibonacci(n - 1) + Fibonacci(n - 2);
        //return result;

        //使用循环，效率很高
        int index[] = {0, 1};
        if (n < 2) {
            return n;
        }
        int one = 0;
        int two = 1;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = one + two;
            one = two;
            two = result;
        }
        return result;
    }
}