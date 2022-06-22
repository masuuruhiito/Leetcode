package com.shijianwei.main;

import java.util.*;

/**
 * @author SHI
 * @date 2022/4/12 13:33
 */
public class Test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

    }


    public static int func(int n, List<List<Integer>> list) {
        List<HashSet> resList = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        set.addAll(list.get(0));
        resList.add(set);
        for (int i = 1; i < list.size(); i++) {
            boolean flag = false;
            for (Integer integer : list.get(i)) {

            }
        }
        return resList.size();
    }
}
