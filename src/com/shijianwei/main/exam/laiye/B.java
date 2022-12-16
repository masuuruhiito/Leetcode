package com.shijianwei.main.exam.laiye;

/**
 * @author SHI
 * @date 2022/9/11 14:04
 */
public class B {
    public int trap(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        while (r >= l) {
            while (l < height.length && height[l] == 0) {
                l++;
            }
            while (r >= 0 && height[r] == 0) {
                r--;
            }
            for (int i = l; i <= r; i++) {
                if (height[i] > 0) {
                    height[i] = height[i] - 1;
                } else {
                    res++;
                }
            }
        }
        return res;
    }

    public static String trim(String word) {
        int l = 0;
        while (word.charAt(l) == '0') {
            l++;
        }
        int r = word.length() - 1;
        while (word.charAt(r) == '0') {
            r--;
        }
        return word.substring(l, r + 1);
    }

    public static void main(String[] args) {
        System.out.println(trim("000111001010"));
    }
}
