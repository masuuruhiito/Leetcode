package com.shijianwei.main.Leetcode;

import jdk.nashorn.internal.ir.IfNode;
import org.junit.Test;

/**
 * @author SHI
 * @date 2022/4/5 15:00
 */
public class Code91_DecodingWay {

    /**
     * 解码字符串可以用dp数组保存上次的最大值，那么这一次的结果只能是上次的结果，
     * 者上次的结果加上当前这个字符和数组中最后一个的组合，
     *
     *
     * 上面的想法有很大的漏洞
     *
     * 具体看图
     *
     * @param s
     * @return
     */
    public static int numDecodings(String s) {

//        if ("".equals(s) || s.charAt(0) == '0') {
//            return 0;
//        }
//        通过加前导0来省略特判
        s = " " + s;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            int cur = s.charAt(i) - '0';
            int pre = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';
//            当当前位置的值在区间内的话，就代表i位置的值等于i-1
            // 当前位置为0的话，就可以直接走下面的了，
            if (cur >= 1 && cur <= 9) {
                dp[i] = dp[i - 1];
            }
//            当这个两位数也是符合要求的，那么这个方法数等于i-2位置的值，
//            如果这两个条件都符合的话，就可以直接相加，
            if (pre >= 10 && pre <= 26) {
                if (i == 1) {
                    dp[i] = dp[i - 1] + 1;
                }else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length() - 1];
    }


    /**
     * 优化时间：
     * @param s
     * @return
     */
    public static int numDecodings3(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i-1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0' <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }





    /**
     * 优化：根据上面的可以看出来，其实对于整个dp数组只用到了当前的值，和前两个数据，可以用数据对3取模
     * 就可以只是用o1的空间完成该方法
     */
    public static int numDecodings1(String s) {

//        通过加前导0来省略特判
        s = " " + s;
        int[] dp = new int[3];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            dp[i % 3] = 0;
            int cur = s.charAt(i) - '0';
            int pre = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';
//            当当前位置的值在区间内的话，就代表i位置的值等于i-1
            // 当前位置为0的话，就可以直接走下面的了，
            if (cur >= 1 && cur <= 9) {
                dp[i % 3] = dp[(i - 1) % 3];
            }
//            当这个两位数也是符合要求的，那么这个方法数等于i-2位置的值，
//            如果这两个条件都符合的话，就可以直接相加，
            if (pre >= 10 && pre <= 26) {
                dp[i % 3] += dp[(i - 2) % 3];
            }
        }
        return dp[(s.length()-1) % 3];
    }


    @Test
    public void aa(){
        numDecodings("1242311013");
    }
}
