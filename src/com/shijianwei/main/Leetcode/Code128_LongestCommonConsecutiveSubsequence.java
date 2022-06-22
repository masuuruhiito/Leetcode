package com.shijianwei.main.Leetcode;

import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * @author SHI
 * @date 2022/4/10 15:37
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */
public class Code128_LongestCommonConsecutiveSubsequence {


    /**
     * 所以说下标无所谓，使用set去重，每次去set数据集中寻找是否有该数据
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0 ;
        for (Integer integer : set) {
//            保证当前数据是头
            if (!set.contains(integer - 1)) {
                int tmpLen = 1;
                int tmpNum = integer;

                while (set.contains(tmpNum + 1)) {
                    tmpLen++;
                    tmpNum++;
                }

                maxLen = Math.max(maxLen, tmpLen);
            }
        }
        return maxLen;
    }
}
