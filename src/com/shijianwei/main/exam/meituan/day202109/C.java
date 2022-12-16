package com.shijianwei.main.exam.meituan.day202109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author SHI
 * @date 2022/8/27 15:33
 */
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] params;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] revNums = new int[n];
            revNums[0] = nums[0];
            for (int i = 1; i < n; i++) {
                revNums[i] = nums[n - i];
            }
            System.out.println(Math.max(getMax(nums), getMax(revNums)));
        }
    }

    public static int getMax(int[] nums) {
        int preMax = Integer.MIN_VALUE;
        int res = 0;
        for (int num : nums) {
            preMax = Math.max(num, num + preMax);
            res = Math.max(preMax, res);
        }
        return res;
    }
}
