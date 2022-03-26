package com.shijianwei.main.Leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author SHI
 * @date 2022/3/26 16:26
 * 想求topK所有的排序算法都可以，想追求最快的时间复杂度
 * 可以尝试：
 *      快速排序，一直排到mid位置为k时结束
 *      选择排序，每次将最大的放到最后一位，当k为最后一个数时时间复杂度变为On2
 *      堆排序，实现堆结构，将所有数据插入，然后弹出k次
 */
public class Code215_TheFirstKLargestElement {

    /**
     * 这个Arrays.sort() 是来搞笑凑数的
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


    /**
     * 先来最简单的选择排序，预计会超时
     * 通过了，时间超过 5.15%
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int maxIndex = i ;
            for (int j = i+1; j < nums.length; j++) {
                maxIndex = nums[maxIndex] > nums[j] ? maxIndex : j;
            }
            swap(nums, maxIndex, i);
            if (--k == 0 ) return nums[i];
        }
        return -1 ;
    }

    /**
     * 这次来写的顺手的快速排序
     *      执行用时：23 ms, 在所有 Java 提交中击败了13.66%的用户
     * @param nums 参数数组
     * @param k    k大的数
     * @return 返回第K个大的数
     */
    public int findKthLargest2(int[] nums, int k) {
        return quicklySort(nums, 0, nums.length - 1, k);
    }
    private static int quicklySort(int[] nums, int l, int r, int k) {
        while (true) {
//            int random = (int) (Math.random() * (r - l + 1));
//            swap(nums, random, r);
            int p = partation(nums, l, r);
            if (p == nums.length - k) {
                return nums[p];
            } else if (p > nums.length - k) {
                r = p - 1;
            }else {
                l = p + 1;
            }
        }
    }


//     取出最大的坐标，每次遍历，比target大的换位置，不大的不管
//    youwenti , 先换成一定能成功的堆排序，这个下次再写
    private static int partation(int[] nums, int start, int end) {
        if (start == end){ return start;}
        int target = nums[end];
        int j = end;
        while (start < j) {
            if (nums[start] > target) {
                swap(nums, start,--j);
            }else {
                start++;
            }
        }
        //分完区记得将target换到最后一个位置
        swap(nums, end, j);
        return j ;
    }





    /**
     * 堆排序：
     *      执行用时：2 ms, 在所有 Java 提交中击败了81.77%的用户
     *
     *      首先将每个非叶子节点下沉，下沉是与孩子中最大的交换，
     *      然后再弹出k次，每次弹出的时候记得将最后一个数和第一个进行交换，重新下沉该值
     *
     *      注：每个节点的左子节点：0 的孩子是 1 2  1 的孩子是 3 4  左孩子为 2*n+1 右孩子2*n+2
     *          每个节点的父节点为 1 的父节点为0  （n-1）/2
     *          非叶子节点：按照满二叉树来的话，就是除了最后一层，也就是
     *          满二叉树节点个数为1+2+4+8 等比数列：1 1-2^n / 1-2 = 2^n-1
     *          所以非叶子节点下标为：2^n-1 - 2^(n-1)
     *          不用求非叶子节点下标，可以进行遍历判断当前节点的孩子是否越界，越界后直接返回就好了
     *
     *          根据图Code215.png 求出最后一个非叶子节点的下标为（len-2）/2
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest3(int[] nums, int k) {
//        从最后一个非叶子节点开始下坠
        for (int i = (nums.length - 2) / 2; i >= 0; i--) {
            failing(nums, i,nums.length-1);
        }
//        下坠之后，保证了第一个是最大的，将最大的弹出，一共k次
        for (int i = 0; i < k; i++) {
            swap(nums, 0, nums.length - i - 1);
            failing(nums, 0,nums.length-2-i);
        }
        return nums[nums.length - k];
    }


    /**
     * 想实现下坠，就是和两个子节点比较，和大的换，在一个节点有一个子节点为空时停止
     * @param nums
     * @param index
     */
    public static void failing(int[] nums, int index,int last) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (last <= 0 || left > last) {
            return;
        }
        int max = right>last? left :  nums[left] > nums[right] ? left : right;
        if (nums[max] > nums[index]) {
            swap(nums, max, index);
        }
//        如果当前节点的子节点还有子节点那么递归下坠
        if (max * 2 + 1 < last) {
            failing(nums, max, last);
        }
    }






    private static void swap(int[] nums, int i, int j) {
        if (i == j || i > nums.length ){ return ;}
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }





    @Test
    public void aa(){
        int[] ints = {3,2,1,5,6,4};
//        swap(ints, 0, 1);
//        System.out.println(ints[0]+" "+ints[1]);
        System.out.println(findKthLargest2(ints, 1));

    }




//    0 - 6 的随机数
//    @Test
//    public void aa(){
//        int l = 0 , r = 6 ;
//        while (true) {
//            int random = (int) (Math.random() * (r - l + 1));
//            if (random == 7 ){
//                System.out.println(random);
//                return;
//            }
////            if (random == 0 ) System.out.println(random);
//
//        }
//
//    }



    @Test
    public void partationTest(){
        int[] nums = {1, 2,4,4,4,4,3,3,33,1,2,3};
        System.out.println(partation(nums, 0, nums.length - 1));
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}
