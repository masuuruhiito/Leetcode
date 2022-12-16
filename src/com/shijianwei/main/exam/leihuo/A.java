package com.shijianwei.main.exam.leihuo;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/9/18 19:11
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        String[][] arr = new String[n][2];
        double res = 0.0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine().split(" ");
            if (arr[i][0].equals(arr[i][1])) {
                res += 1;
            }else {
                res += getScore(arr[i][0], arr[i][1]);
            }
        }
        System.out.printf("%.2f", (res / n) * 100);
        System.out.print("%");
    }

    private static double getScore(String a, String b) {
        double ans = 0.0;
        if (a.charAt(0) == b.charAt(0)) {
            ans += 2;
        }
        int lena = a.length();
        int lenb = b.length();
        String lastA = a.substring(lena - 5);
        String lastB = b.substring(lenb - 5);

        int len = getLen(lastA, lastB);
        ans += len;
        String placeA = a.substring(1, lena - 6);
        String placeB = b.substring(1, lena - 6);

        if (placeA.equals(placeB)) {
            ans += 3;
        }
        return ans / 10.0;
    }

    private static int getLen(String lastA, String lastB) {
        String s1 = lastA.length() > lastB.length() ? lastB : lastA;
        String s2 = lastA.length() <= lastB.length() ? lastB : lastA;

        int len1 = s1.length();
        int len2 = s2.length();
        int max = 0, start = 0;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    start = i - max;
                }
            }
        }
        return max;
    }

    public static boolean judgeOrigin(char[] chars1, char[] chars2) {
        String s = String.valueOf(chars1, 1, chars1.length - 6);
        System.out.println(s);
        return String.valueOf(chars1, 1, chars1.length - 6).equals(String.valueOf(chars2, 1, chars2.length - 6));
    }

    public static int getMaxSameSubString(char[] chars1, char[] chars2) {
        String s1 = String.valueOf(chars1, chars1.length - 5, 5);
        String s2 = String.valueOf(chars2, chars2.length - 5, 5);
        if (s1.length() > s2.length()) {
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < s2.length(); i++) {
            if (s1.charAt(0) == s2.charAt(i)) {
                dp[0][i] = 1;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            if (s1.charAt(i) == s2.charAt(0)) {
                dp[i][0] = 1;
            }
        }
        int maxLen = 0;
        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen;
    }

    @Test
    public void aaa(){
        System.out.println(Math.round(1.1));
        System.out.println(Math.round(1.2));
        System.out.println(Math.round(1.4));
        System.out.println(Math.round(1.5));
    }
}
