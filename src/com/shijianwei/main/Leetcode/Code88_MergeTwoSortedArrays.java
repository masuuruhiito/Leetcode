package com.shijianwei.main.Leetcode;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author SHI
 * @date 2022/3/26 20:00
 * 88. 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 */
public class Code88_MergeTwoSortedArrays {
    /**
     * 我是渣渣，这是啥啊，垃圾题，c，人家三行写完了，我tm写这么多，还白费这么多内存
     * 放弃了，明日再战，看会面试题
     * <p>
     * 最优方法，因为是改变nums1，每次插入时间复杂度都为On，
     * 既然这样我使用额外空间 help 来记录最终值，就不会有插入，然后再将help赋值给nums1
     * <p>
     * 注：不能直接 nums1 = help
     * 也不能 nums1 = Arrays.copyof(help,help.length);
     * <p>
     * 而是直接使用System.arrcopy(help,0,nums1,0,nums1.length);
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] help = new int[m + n];
        int i = 0;
        int x = 0, y = 0;
        while (x < m && y < n) {
            help[i++] = nums1[x] > nums2[y] ? nums2[y++] : nums1[x++];
        }
        while (x < m) {
            help[i++] = nums1[x++];
        }
        while (y < n) {
            help[i++] = nums2[y++];
        }
//        nums1 = Arrays.copyOf(help, m + n);
        System.arraycopy(help, 0, nums1, 0, nums1.length);
    }


    @Test
    public void aaaaa() {
        int[] a = {1, 2, 3, 0, 0, 0}, b = {2, 3, 4};
        merge4(a, 3, b, 3);
        for (int i : a) {
            System.out.println(i);
        }
    }

    //    insert correct
    public static void insert(int[] nums, int index, int val) {
        for (int i = nums.length - 1; i > index; i--) {
            nums[i] = nums[i - 1];
        }
        nums[index] = val;
    }


    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null) {
            return;
        }
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums2[index] < nums1[i]) {
                insert(nums1, i, nums2[index++]);
                m++;
            }
        }
        while (m < nums1.length) {
            nums1[m++] = nums2[index++];
        }
    }

    @Test
    public void insertTest() {
        int[] a = {1, 2, 3, 0, 0, 0}, b = {2, 3, 4};
        insert(a, 5, 1);
        insert(a, 5, 2);
        insert(a, 3, 4);
        for (int i : a) {
            System.out.println(i);
        }
    }


    //    垃圾优先队列方法，太次了
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            queue.add(nums1[i]);
        }
        for (int i = 0; i < n; i++) {
            queue.add(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = queue.poll();
        }
    }


    @Test
    public void arrCopyTest() {
//        int[] a = {1, 2, 3, 4};
//        int []b = a ;
//        for (int i : b) {
//            System.out.println(i);
//        }
        int[] b = null;
        arr(b);
        for (int i : b) {
            System.out.println(i);
        }
    }


    public void arr(int[] b) {
        int[] a = {1, 2, 3};
        System.arraycopy(a, 0, b, 0, a.length);
    }


    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }


    /**
     * 题解中给了一种思路
     * 从后往前遍历nums1，将大的值赋值，
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge4(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (n < 0) {
                return;
            } else if (m < 0) {
                nums1[i] = nums2[n--];
            } else {
                nums1[i] = nums1[m] >= nums2[n] ? nums1[m--] : nums2[n--];
            }
        }
    }
}
