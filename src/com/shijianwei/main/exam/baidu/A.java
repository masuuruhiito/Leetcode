package com.shijianwei.main.exam.baidu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/9/13 19:31
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().trim().toCharArray();
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int l = 0, r = 0; r < chars.length; r++) {
            if (map.containsKey(chars[r])) {
                int index = map.get(chars[r]);
                map.put(chars[r], r);
                for (int i = l; i < index; i++) {
                    map.remove(chars[i]);
                }
                l = index + 1;
                continue;
            }
            map.put(chars[r], r);
            if (map.size() == 5) {
                if (yuanyin.contains(chars[l])) {

                }else if (judge(chars, l)) {
                    res++;
                }
                map.remove(chars[l++]);
            }
        }

        System.out.println(res);
    }

    static HashSet<Character> yuanyin = new HashSet<>();
    static{
        yuanyin.add('a');
        yuanyin.add('e');
        yuanyin.add('i');
        yuanyin.add('o');
        yuanyin.add('u');
    }

    public static boolean judge(char[] chars, int l) {
        return !yuanyin.contains(chars[l]) && !yuanyin.contains(chars[l + 3]) &&
                yuanyin.contains(chars[l + 1]) && yuanyin.contains(chars[l + 2]) &&
                yuanyin.contains(chars[l + 4]);
    }
}
