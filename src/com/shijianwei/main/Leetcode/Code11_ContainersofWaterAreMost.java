package com.shijianwei.main.Leetcode;

import org.junit.Test;

/**
 * @author SHI
 * @date 2022/3/30 21:23
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 *输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 *
 */
public class Code11_ContainersofWaterAreMost {

    /**
     * 求最大的盛水量
     * 思路：
     *      计算每次的值，然后将最大值返回
     * 预测超时
     *      确实超时了，那么就换种方法
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                int min = Math.min(height[i], height[j]);
                res = Math.max(res, (j - i) * min);
            }
        }
        return res ;
    }


    /**
     * 该问题遵循，如果移动短板，那么可能变大，移动长版，一定变小
     * 可以使用双指针，分别指向两端，那么每次移动短板，然后分别计算每次的值，返回
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int res = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            if(height[i] < height[j]){
                res = Math.max(res, (j - i) * height[i++]);
            }else {
                res = Math.max(res, (j - i) * height[j--]);
            }
        }
        return res ;
    }



    @Test
    public void aa(){
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
