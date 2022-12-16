package com.shijianwei.main.exam.meituan.day202110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * @author SHI
 * @date 2022/8/27 13:31
 */
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            char[] cn = br.readLine().toCharArray();
            int m = Integer.parseInt(br.readLine());
            char[] cm = br.readLine().toCharArray();
            PriorityQueue<Integer> ans0 = new PriorityQueue<>();
            PriorityQueue<Integer> ans1 = new PriorityQueue<>();

            for (int i = 1; i <= n; i++) {
                if (cn[i-1] == '0') {
                    ans0.add(i);
                } else if (cn[i - 1] == '1') {
                    ans1.add(i);
                }
            }

            for (char c : cm) {
                if (c == 'M') {
                    if (!ans1.isEmpty()) {
                        System.out.println(ans1.poll());
                    } else {
                        System.out.println(ans0.peek());
                        ans1.add(ans0.poll());
                    }
                } else if (c == 'F') {
                    if (!ans0.isEmpty()) {
                        System.out.println(ans0.peek());
                        ans1.add(ans0.poll());
                    }else {
                        System.out.println(ans1.poll());
                    }
                }
            }
        }
    }
}
