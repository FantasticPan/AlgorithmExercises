package com.pan.NowCoder;

/**
 * 跳台阶
 * Created by FantasticPan on 2019/1/18.
 */
public class Exercise10_2 {

    public int JumpFloor(int target) {
        //使用递归，效率不高
        //if (target == 1) {
        //    return 1;
        //}
        //if (target == 2) {
        //    return 2;
        //}
        //return JumpFloor(target - 1) + JumpFloor(target - 2);

        //使用循环，效率高
        switch (target){
            case 1:
                return 1;
            case 2:
                return 2;
        }
        int one = 1;
        int two = 2;
        int result = 0;
        for (int i = 2; i < target; i++) {
            result = one + two;
            one = two;
            two = result;
        }
        return result;
    }
}
