package com.shijianwei.main.jianzhiOffer.Code16_Sort;

import com.sun.glass.ui.Size;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author SHI
 * @date 2022/2/9 15:07
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 示例 1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 *
 * 示例 2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 */
public class Code61 {
    //    正确条件：如果去重后最大值和最小值的差值小于5，就证明可以是顺子
    public static boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0 , min = 14;
        for (Integer integer : nums) {
            if(integer==0) continue;
            if(set.contains(integer)) return false;
            set.add(integer);
            max = Math.max(max,integer);
            min = Math.min(min,integer);
        }
        return max-min<5;
    }

    //    判断条件多余：

//    思想：首先对于不含有大小王的数据来说：
//        五个数，排序完之后，每两个数的差值都为1
//        对含有大小王的数据来说，将0剔除，剩余的数组中，最多有剔除个数个差值为2的数据
//    先将0去除，然后判断有无重复数据，有则false
//            然后在判断每个数据间差值，大于1的部分累加，判断结果与0的个数，如果比0的个数多，证明false

    public boolean isStraight1(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        int zeroCount= 0 ;
        for (Integer integer : nums) {
            if(integer==0) {
                zeroCount++;
                continue;
            }
            set.add(integer);
        }
        if(5-zeroCount!=set.size()) return false;
        Integer[]a = set.toArray(new Integer[]{}) ;
        int chazhi = 0 ;
        for (int i = 0; i < a.length-1; i++) {
            chazhi+= a[i+1]-a[i]>1?a[i+1]-a[i]-1:0;
        }
        return chazhi == zeroCount;
    }




    public static void main(String[] args) {
        int []a = {1,2,3,4,5};
        isStraight(a);
    }
}
