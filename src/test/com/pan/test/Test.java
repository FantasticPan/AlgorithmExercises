package com.pan.test;

import java.util.Arrays;

/**
 * Created by FantasticPan on 2019/1/18.
 */
public class Test {

    @org.junit.Test
    public void test1() {
        int[] s = {5, 7, 6, 9, 11, 10, 8};
        for (int i : Arrays.copyOfRange(s, 0, 3)){
            System.out.println(i);
        }
    }
}
