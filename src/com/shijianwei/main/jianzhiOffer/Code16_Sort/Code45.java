package com.shijianwei.main.jianzhiOffer.Code16_Sort;

import javax.swing.text.html.HTML;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author SHI
 * @date 2022/2/8 17:41
 * 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 * 先当与比较字典序，如果不是字典序的话
 */
public class Code45 {
    public String minNumber(int[] nums) {
        StringBuilder res= new StringBuilder();
        String[] s= new String[nums.length];
        for (int i = 0; i < s.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });

        for (String s1 : s) {
            res.append(s1);
        }
        return res.toString() ;
    }


    public String minNumber1(int[] nums) {
        StringBuilder res= new StringBuilder();
        String[] s= new String[nums.length];
        for (int i = 0; i < s.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        quicklySort(s,0,s.length-1);
        for (String s1 : s) {
            res.append(s1);
        }
        return res.toString() ;
    }


    public static void quicklySort(String []strs ,int l ,int r ) {
        if (l >= r) return;
        int i = l, j = r;
        while (i < j) {
            while ((strs[i] + strs[j]).compareTo(strs[j] + strs[i]) >= 0 && i < j) i++;
            while ((strs[i] + strs[j]).compareTo(strs[j] + strs[i]) <= 0 && i < j) j--;
            swap(strs, i, j);
        }
        quicklySort(strs, l, i - 1);
        quicklySort(strs, i + 1, r);
    }

    public static void swap(String[] arr, int i, int j) {
        String tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
