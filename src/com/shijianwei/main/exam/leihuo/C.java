package com.shijianwei.main.exam.leihuo;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SHI
 * @date 2022/9/18 21:21
 */
public class C {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        List<Integer> list = func(sc.nextInt());
//        for (int i : list) {
//            System.out.print(i + " ");
//        }

//        toUPPER("asdfg");
    }


    public static List<Integer> func(int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 64; i++) {
            list.add(i);
        }

        while (n-- > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (((i + 1) % 5) == 0) {
                    list.remove(i);
                }
            }
        }
        return list;
    }

    public static String toUpper(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = (char) (chars[i] - 32);
            }
        }
        return new String(chars);
    }

    @Test
    public void aaa(){
        System.out.println(toUpper("adfsdaf"));
        System.out.println(toUpper("SDFasdfasFDSF"));
        System.out.println(toUpper("asdfsd asdf asdf"));
    }
}