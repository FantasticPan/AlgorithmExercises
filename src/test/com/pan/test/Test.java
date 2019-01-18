package com.pan.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by FantasticPan on 2019/1/18.
 */
public class Test {

    @org.junit.Test
    public void test1() {
        System.out.println(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(new Date()));
    }
}
