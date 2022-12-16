package com.shijianwei.main.exam.leihuo;

import java.util.*;

/**
 * @author SHI
 * @date 2022/9/18 20:00
 */
public class B {
    static HashMap<Integer, List<Integer>> guanxi = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < c; j++) {
                list.add(sc.nextInt());
            }
            guanxi.put(i, list);
        }
        int[][] caozuo = new int[m][2];
        for (int i = 0; i < m; i++) {
            caozuo[i][0] = sc.nextInt();
            caozuo[i][1] = sc.nextInt();
        }

        for (int[] ints : caozuo) {
            if (ints[0] == 1) {
                incr(Collections.singletonList(ints[1]));
                maxLen = Math.max(maxLen, curYunxing.size());
            }else {
                del(Collections.singletonList(ints[1]));
            }
        }
        System.out.println(maxLen);
    }

    static HashMap<Integer, Integer> curYunxing = new HashMap<>();
    static Integer maxLen = 0;

    public static void incr(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (Integer integer : list) {
            if (!curYunxing.containsKey(integer)) {
                curYunxing.put(integer, 1);
                incr(guanxi.get(integer));
            }else {
                curYunxing.put(integer, curYunxing.get(integer) + 1);
            }
        }
    }

    public static void del(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (Integer integer : list) {
            if (curYunxing.get(integer) <= 1) {
                curYunxing.remove(integer);
                del(guanxi.get(integer));
            } else {
                curYunxing.put(integer, curYunxing.get(integer) - 1);
            }
        }
    }
}
