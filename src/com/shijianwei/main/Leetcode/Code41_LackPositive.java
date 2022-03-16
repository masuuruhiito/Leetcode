package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/2/28 10:18
 *
 * On的时间复杂度
 * O1的空间复杂度
 *
 * 可以通过set来遍历是否含有从1到n（空间超限）
 * 可以通过二分查找（时间NLogN）
 * 可以将数据变为hash表，原地hash
 */
public class Code41_LackPositive {

    public static int firstMissingPositive(int[] nums) {
        int ans = 1 ;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]>0 && nums[i]<=nums.length && nums[i] != nums[nums[i]-1]) {
                swap(nums,nums[i]-1,i);

            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length+1;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp ;
    }


    public static void main(String[] args) {
        int[] a = {-1,4,2,1,9,10};
        System.out.println(firstMissingPositive(a));

    }

    /**
     * @author SHI
     * @date 2022/1/18 15:25
     *
     * 167. 两数之和 II - 输入有序数组
     * 给定一个已按照 非递减顺序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
     *
     * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
     *
     * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
     */
    public static class Code167 {
        public static int[] twoSum(int[] numbers, int target) {
            for (int i = 0; i < numbers.length-1; i++) {
                for (int j = i+1; j <numbers.length ; j++) {
                    if(numbers[i]+numbers[j]==target){
                        return new int []{i+1,j+1};
                    }else if(numbers[i]+numbers[j]>target){
                        break;
                    }            }
            }
            return new int []{0,0};
        }

        public static void main(String[] args) {
            int []a = {2,7,11,15};
            int []b = twoSum(a,9);
            for (int i : b) {
                System.out.print(i+" ");
            }
        }
    }

    /**
     * @author SHI
     * @date 2022/1/18 14:47
     *
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
     * 示例:
     *
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     *
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     */
    public static class Code283 {
        public static void moveZeroes(int[] nums) {
            int left= 0 ;
            int right = 0 ;
            while (right < nums.length) {
                if(nums[right]!=0){
                    swap(nums,left++,right);
                }
                right++;
            }
        }

        private static void swap(int[] nums, int left ,int right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }


        public static void main(String[] args) {
            int [] a ={0,0,1};

            moveZeroes(a);

            for (int i : a) {
                System.out.print(i+" ");
            }
        }
    }
}
