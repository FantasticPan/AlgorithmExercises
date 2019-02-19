package com.pan.NowCoder;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 分解让复杂问题简单-字符串的排列
 * Created by FantasticPan on 2019/2/18.
 */
public class Exercise38 {

    public static void main(String[] args) {
        new Exercise38().Permutation("abc");
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str.length() == 0 || str == null) {
            return list;
        }
        Permutation(str.toCharArray(), 0, list);
        Collections.sort(list);
        return list;
    }

    private void Permutation(char[] chars, int i, ArrayList<String> list) {
        if (i == chars.length - 1) {
            if (!list.contains(new String(chars))) {
                list.add(new String(chars));
                return;
            }
        } else {
            for (int j = i; j < chars.length; j++) {
                swap(chars, i, j);

                Permutation(chars, i + 1, list);

                swap(chars, i, j); //归位，将交换的元素交换回来
            }
        }
    }

    private void swap(char[] chars, int index1, int index2) {
        if (index1 != index2) {
            char c = chars[index1];
            chars[index1] = chars[index2];
            chars[index2] = c;
        }
    }
}
