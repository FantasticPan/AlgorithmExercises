package com.pan.NowCoder;

/**
 * 变态跳台阶
 * Created by FantasticPan on 2019/1/18.
 */
public class Exercise10_3 {

    public int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }

        int result = JumpFloorII(target - 1);
        result = result * 2;
        return result;
    }
}
