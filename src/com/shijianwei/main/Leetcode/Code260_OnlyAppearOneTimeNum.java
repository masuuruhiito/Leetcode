package com.shijianwei.main.Leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author SHI
 * @date 2022/3/27 18:07
 * 260. 只出现一次的数字 III
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 *
 *
 *
 * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 */
public class Code260_OnlyAppearOneTimeNum {
    /**
     * 最简单还是使用set if contains remove return new int[]{set.get}
     *
     * 执行用时：3 ms, 在所有 Java 提交中击败了32.08%的用户
     * 内存消耗：41.9 MB, 在所有 Java 提交中击败了17.74%的用户
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            }else {
                set.add(nums[i]);
            }
        }
        int[] res = new int[2];
        int i = 0;
        for (Integer integer : set) {
            res[i++] = integer;
        }
        return res ;
    }


    /**
     * 正常点的思路为：使用位运算来进行优化，因为只有两个数据，那么可以求出来每个数据的异或积
     * 然后就得到了i，j的异或，
     * 再取出数据的最后一个一，代表这两个数，这一位不同，就可以根据这个特点将所有数据分类
     * 然后异或一边，再和异或积进行异或，得到最终的两个数
     *
     * 思路没问题，少考虑了数据溢出的问题
     *
     *
     * https://blog.csdn.net/oyoung_2012/article/details/79932394
     * 下回在看
     * 最终结论
     * “当一个数与其取负后的值相与， 如果这个数是偶数， 则结果是能整除这个偶数的最大的2的幂(即： m = n & -n , 则 n % m = 0, 且 m = 2 ^ k)， 如果这个数是奇数， 则结果必为1”
     *
     * 用途： 一般可以用来获取某个二进制数的LowBit
     *
     * @param nums
     * @return
     */
    public int[] singleNumber1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int []{};
        }
        int tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tmp ^= nums[i];
        }
        int i =0 ;int l = 0 ,r= 0 ;
        if (tmp == Integer.MIN_VALUE) {
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j]&tmp )== 0) {
                     l^= nums[j];
                }else {
                    r ^= nums[j];
                }
            }
            return new int[]{l, r};
        }
        for (i = 1; i <= 32; i++) {
            if (tmp >> 1 == 1) {
                break;
            }else {
                tmp >>= 1;
            }
        }
//        i = >> 次数，

        for (int j = 0; j < nums.length; j++) {
            if ((nums[j] >> i &1)== 0) {
                l ^= nums[j];
            }else {
                r ^= nums[j];
            }
        }
        return new int[]{l, r};
    }


    @Test
    public void aa(){
        int[] nums = {-145417756,744132272};
        System.out.println(nums[0] + " " + nums[1]);
        int[] ints = singleNumber1(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

//        System.out.println(nums[0]>>29 +" "+nums[1]>>29);

    }


//    [-145417756,744132272]
}
