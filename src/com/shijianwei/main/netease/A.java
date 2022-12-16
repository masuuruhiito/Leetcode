package com.shijianwei.main.netease;

import java.util.*;

/**
 * @author SHI
 * @date 2022/9/4 15:01
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        List<Integer> numsList = new ArrayList<>();
        Set<Integer> quchong = new HashSet<>();
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            if (!quchong.contains(nums[i])) {
                numsList.add(nums[i]);
                quchong.add(nums[i]);
            }
        }
        PriorityQueue<HashSet<Integer>> list = new PriorityQueue<>(new Comparator<HashSet<Integer>>() {
            @Override
            public int compare(HashSet<Integer> o1, HashSet<Integer> o2) {
                return o2.size() - o1.size();
            }
        });
        for (int i = 0; i < numsList.size(); i++) {
            for (int j = i + 1; j < numsList.size(); j++) {
                if (getRes(numsList.get(i), numsList.get(j), k)) {
                    boolean flag = false;
                    for (HashSet<Integer> set : list) {
                        if (set.contains(numsList.get(i))) {
                            set.add(numsList.get(j));
                            flag = true;
                        }
                        if (set.contains(numsList.get(j))) {
                            set.add(numsList.get(i));
                            flag = true;
                        }
                    }
                    if (!flag) {
                        HashSet<Integer> set = new HashSet<>();
                        set.add(numsList.get(i));
                        set.add(numsList.get(j));
                        list.add(set);
                    }
                }
            }
        }
        int res = 0;
        HashMap<HashSet<Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (HashSet<Integer> set : list) {
                if (set.contains(numsList.get(i))) {
                    map.put(set, map.get(set) == null ? 1 : map.get(set) + 1);
                    res = Math.max(map.get(set), res);
                }
            }
        }
        System.out.println(res);
    }

    public static boolean getRes(int n, int m, int k) {
        return Math.abs(n - m) % k == 0;
    }
}
