package com.shijianwei.main.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SHI
 * @date 2022/2/17 15:46
 */
public class Code22 {
    public List<String> generateParenthesis(int n) {
        List<String > res = new ArrayList<>();
        return res ;
    }

    public static String dfs(int i){
        return "" ;
    }

    /**
     * @author SHI
     * @date 2022/1/16 19:11
     *
     * 278. 第一个错误的版本
     * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
     * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
     *
     * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
     *
     * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
     * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
     *
     *
     * 解题方法就是二分查找该项
     */
    public static class Code278 {
        /* The isBadVersion API is defined in the parent class VersionControl.
          boolean isBadVersion(int version); */

        public static void main(String[] args) {
            System.out.println(Solution.firstBadVersion(7));
        }


        static class VersionControl {

            static boolean isBadVersion(int i) {
                if(i >= 3){
                    return true  ;
                }
                else{
                    return false ;
                }

            }
        }

        public static class Solution extends VersionControl {
            public static int firstBadVersion(int n) {
                int i =1 , j = n;
                while (i<j){
                    int mid = i+((j-i)>>1);
                    if(isBadVersion(mid)){
                        j = mid ;
                    }else{
                        i = mid +1 ;
                    }
                }
                return i ;
            }
        }
    }

    /**
     * @author SHI
     * @date 2022/1/17 17:04
     *
     * 189. 轮转数组
     * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右轮转 1 步: [7,1,2,3,4,5,6]
     * 向右轮转 2 步: [6,7,1,2,3,4,5]
     * 向右轮转 3 步: [5,6,7,1,2,3,4]
     */
    public static class Code189 {
        public static void main(String[] args) {
            int []nums = {1,2,3,4,5,6,7};
            rotate(nums,3);
            for (int num : nums) {
                System.out.println(num
                );
            }
        }


    //    数组反转的方法
        public static void rotate(int[] nums, int k) {
    //        先将整个数组反转
            reversal(nums,0,nums.length-1);
    //        再将【0，k%nums.length-1】
            reversal(nums,0,k%nums.length-1);
    //        再将【k%nums.length,nums.length-1】反转
            reversal(nums,k%nums.length,nums.length-1);

        }

    //    反转函数
        public static void reversal(int []nums,int start ,int end ){
            while (start<end ){
                int temp = nums[start];
                nums[start++] = nums[end];
                nums[end--] = temp ;
            }
        }

    }
}
