package com.shijianwei.main.learn.algorithm;

import org.junit.Test;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author SHI
 * @date 2022/3/27 20:25
 *
 * 需求：
 *      输入一个字符串，然后分解每个字符，将所有的排列方式全加在list中，
 */
public class AllPermutation {
    public static void allPermutation(char[] chars){
        List<String> res = new ArrayList<>();
        permutation(chars, 0, res);
        for (String re : res) {
            System.out.println(re);
        }
    }

    private static void permutation(char[] chars, int index, List<String> res) {
        if (index >= chars.length) {
            res.add(Arrays.toString(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);
            permutation(chars,index+1, res);
            swap(chars, i, index);
        }
    }

    public static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }


    @Test
    public void aaa(){
//        System.out.println(swap("abcd".toCharArray(), 1, 2));
        allPermutation("1234".toCharArray());
    }





}
