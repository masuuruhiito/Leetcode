package com.shijianwei.main.learn.algorithm;


import java.util.Arrays;


class FindCombinationNumslessthanTarget {

//    找出数组中两个数据相加小于target的组合种数
    /**
     * 先将数组排序，然后从后向前找，数组有序，可以通过二分查找来找到相加小于target的数据
     * @param nums
     * @param target
     * @return
     *
     */
    public static int func(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            int indexofSumLessthanTarget = findIndexofSumLessthanTarget(nums, target, i);
            if (indexofSumLessthanTarget != -1) {
                res += funcNumsofIndex(indexofSumLessthanTarget);
            }
        }
        return res;

    }

    public static int findIndexofSumLessthanTarget(int[] nums, int target, int endIndex) {
        int l = 0, r = endIndex - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] + nums[endIndex] > target) {
                r = mid - 1;
            } else if (mid + 1 == endIndex || nums[mid + 1] + nums[endIndex] > target) {
                return mid;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

//    只是对于每个数据的组合方式，已经选定一次， 那么就是index+1
    public static int funcNumsofIndex(int index) {
        return index + 1;
    }


    public static void main(String[] args) {
        int[] nums = {-1, -2, -3, -4, 1, 8, 9};
//        -4,-3,-2,-1,1,8,9
        int target = 9;
        System.out.println(func(nums, target));


//        ArrayList
//        System.out.println(findIndexofSumLessthanTarget(nums, target, nums.length-3));
    }
}
