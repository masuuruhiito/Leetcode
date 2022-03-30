package com.shijianwei.main.exam.huawei;

import com.sun.xml.internal.fastinfoset.util.ValueArrayResourceException;

import java.io.*;
import java.lang.ref.SoftReference;
import java.nio.Buffer;

/**
 * @author SHI
 * @date 2022/3/30 20:34
 *
 * 题目：
 *      一个数组表示每个点的能量值，k为只能走k次，初始在nums【0】位置，判断是否能到达最后一个节点
 *      如果可以输出最小跨越的步数，不行返回-1
 */
public class Code01_Greedy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        int k = Integer.parseInt(br.readLine());


        int ans = dfs(nums, 0);
        if (ans <= k) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }

    }


    /**
     * 思路：利用贪心策略，每次计算出每次可能到达的最远的地方，然后选取此时的最远的index直接跳到下一个节点进行比较
     * @param powers
     * @param index
     * @return
     */
    private static int dfs(int[] powers, int index) {
        if (index >= powers.length-1) return 0;

        int maxLen = 0, maxIndex = 0;
        for (int i = 1; i <= powers[index]; i++) {
            if (i+index>powers.length-1) break;
            //为了求出最小次数，那么当前后两个节点一致时优先考虑后方的节点，因为后方的节点可能是最后一个节点，那么就可以少走一步
            if (i + index + powers[i + index] >= maxLen) {
                maxLen = i + index + powers[i + index];
                maxIndex = i + index;
            }
        }
        if (maxIndex == 0) {
            return -1 ;
        }
        return dfs(powers, maxIndex) + 1;//每次步数+1
    }
}
