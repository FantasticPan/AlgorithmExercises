package com.pan.NowCoder;

/**
 * 矩形覆盖
 * Created by FantasticPan on 2019/1/18.
 */
public class Exercise10_4 {

    public int RectCover(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }
}
