package com.shijianwei.main.learn.algorithm;

/**
 * @author SHI
 * @date 2022/5/9 21:23
 * <p>
 * 针对一个 0，1，1，0，1，1，0    k = 2
 * 可以最多翻转k个0变为1
 * 求反转后最长的字符串长度
 */
public class ArrayFlip {
    public static void main(String[] args) {
//        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0};
        int[] nums = {1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int k = 2;
//        func1(nums, 2);
        //

        int[] dp = new int[nums.length];
        int[] tmp = new int[nums.length];

        int res = 0;
        if (nums[0] == 0) {
            if (tmp[0] > 0) {
                dp[0] = 1;
                tmp[0]--;
            }else {
                dp[0] = 0;
            }
        }else {
            dp[0] = 1;
        }
        res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (tmp[i - 1] > 0) {
                    dp[i] = dp[i - 1] + 1;
                    tmp[i] = tmp[i - 1] - 1;
                }else {
                    dp[i] = k;
                    tmp[i] = 0;
                }
            }else {
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(res, dp[i]);
        }



//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 1) {
//                res = Math.max(res, i+1 - l);
//                lastIndex = i;
//            }else {
//                if (tmp > 0) {
//                    res = Math.max(res, i+1 - l);
//                    tmp--;
//                }else {
//                    l = ++lastIndex;
//                    i = lastIndex-1;
//                    tmp = k;
//                }
//            }
//        }

    }


    /**
     * 利用面试官教的先创建好此时最大的滑动窗口的左右指针，
     *      那么此时的窗口中0的数量一定为k，就可以通过这个关系只比较弹出元素的值为什么就可以了
     *      并不需要判断当前r的值，因为根据初始化，对应r的位置一定为0，
     *
     * @param nums
     * @param k
     */
    public static void func1(int[] nums, int k) {
        int l = 0, r = 0;
        int res = 0;
        int tmp = k;
        while (r < nums.length && nums[r] == 1 || tmp > 0) {
            if (nums[r] == 0) {
                tmp--;
            }
            r++;
        }
        res = r - l;
//        此时初始化窗口为以0为起点的最大值，这个时候肯定里面已经有k个0了
        for (l = 1; l < nums.length; l++) {
            if (nums[l - 1] == 0) {
                r++;
                while (r < nums.length && nums[r] == 1) {
                    r++;
                }
            }
//            if (r == nums.length) r--;
            res = Math.max(res, r - l);
        }
        System.out.println(res);
    }
}
