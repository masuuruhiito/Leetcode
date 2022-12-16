package com.shijianwei.main.exam.exam360;

import java.util.*;

/**
 * @author SHI
 * @date 2022/9/9 16:31
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int q = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        while (q-- > 0) {
            long l = sc.nextLong();
            long r = sc.nextLong();
            if (!queue.contains(l) && !queue.contains(r)) {
                queue.add(l);
                queue.add(r);
            }
        }
    }
}
