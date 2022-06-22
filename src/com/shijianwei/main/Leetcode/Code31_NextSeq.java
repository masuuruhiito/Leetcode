package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/3/5 20:09
 */
public class Code31_NextSeq {

//    先用笨方法，从后往前，如果

    /**
     * 笨方法，从后往前，最差为On2
     * 但是不需要额外空间
     * 该想法是错误的
     *
     * 想要变大，那么就从左边找较小的值，从右边找较大的值
     *          对于找的时候
     *          该较小值尽量靠右，该较大值尽量小，交换完后将左边节点后边的序列排序，以达到结果
     *
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }
//        target的位置就代表了后面的数据都是递减的
        int target = nums.length - 2;
        while (target >= 0 && nums[target] >= nums[target + 1]) {
            target--;
        }
        if (target >= 0) {
            int index = nums.length - 1;
            while (index > target && nums[index] <= nums[target]) {
                index--;
            }
//            此时交换target与当前比target大的数据，最差情况为target+1
//            保证了此时将数据最右边的最大值是大于target的，也就是现数组一定比之前大
            swap(nums,index,target);
        }
//        既然有了target的后面是递减的,那么为了保证最小,就将target翻转即可达到排序效果
        reverse(nums,target+1);
    }

    public static void reverse(int[] nums, int start) {
        int i = start , j = nums.length-1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] res = {3,2,1};
        nextPermutation(res);
        for (int re : res) {
            System.out.print(re+" ");
        }
    }
}
