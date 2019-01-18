package com.pan.NowCoder;

/**
 * 数值的整数次方
 * Created by FantasticPan on 2019/1/17.
 */
public class Exercise16 {

    /**
     * 快速幂
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        boolean isNegative = false;
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }
        double pow = Power(base, exponent >> 1);
        pow *= pow;
        if ((exponent & 1) == 1) {
            pow *= base;
        }
        return isNegative ? 1 / pow : pow;
    }
}
