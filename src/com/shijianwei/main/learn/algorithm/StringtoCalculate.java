package com.shijianwei.main.learn.algorithm;

import com.shijianwei.main.exam.wangyi_0327.C;

import java.util.HashSet;

/**
 * @author SHI
 * @date 2022/4/22 19:10
 */
public class StringtoCalculate {

    public static double calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        double res = 0;
//        HashSet<Character> set = new HashSet<Character>() {
//            {
//                add('+');
//                add('-');
//                add('*');
//                add('/');
//            }
//        };
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if (set.contains(s.charAt(i))) {
//
//            }
//            stringBuilder.append(s.charAt(i));
//        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*' || s.charAt(i) == '/') {
                double[] ints = findTwoInteger(s, i);
                double tmp = s.charAt(i) == '*' ? ints[0] * ints[1] : 1.0*ints[0] / ints[1];
                s = s.replace(s.substring((int) ints[2], (int) ints[3]+1), String.valueOf(tmp));
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                double[] ints = findTwoInteger(s, i);
                double tmp = s.charAt(i) == '+' ? ints[0] + ints[1] : ints[0] - ints[1];
                s = s.replace(s.substring((int) ints[2], (int) ints[3]+1), String.valueOf(tmp));
            }
        }
        return Double.valueOf(s);
    }


    public static double[] findTwoInteger(String s, int index) {
        StringBuilder pre = new StringBuilder();
        StringBuilder next = new StringBuilder();

        int preIndex = 0;
        int nextIndex = 0;
        for (int i = index-1 ; i >= 0; i--) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == '.') {
                pre.append(s.charAt(i));
                preIndex = i;
            } else {
                break;
            }
        }


        for (int i = index+1; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == '.') {
                next.append(s.charAt(i));
                nextIndex = i;
            } else {
                break;
            }
        }

        pre.reverse();
        return new double[]{Double.valueOf(pre.toString()), Double.valueOf(next.toString()), preIndex, nextIndex};

    }

    public static void main(String[] args) {
        System.out.println(calculate("1+2-3*2"));
//        String s = "123";
//////        s = "345";
////        s = s.replace("2","444");
////        System.out.println(s);
//        System.out.println(s.substring(0,2));
    }
}
