package com.shijianwei.main.netease;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/9/4 16:24
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] s = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = s[0], k = s[1], x = s[2];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        s = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i : s) {
            queue.add(i);
        }
        for (int i = 0; i < k; i++) {
            if (!queue.isEmpty()) {
                queue.add(queue.poll() - x);
            }
        }
        System.out.println(queue.poll());
    }
}
