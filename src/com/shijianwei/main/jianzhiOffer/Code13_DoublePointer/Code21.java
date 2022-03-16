package com.shijianwei.main.jianzhiOffer.Code13_DoublePointer;

/**
 * @author SHI
 * @date 2022/2/7 19:52
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class Code21 {
//    双指针   先从前面开始找偶数的数据,然后第二个指针开始从后面找奇数的数据,然后交换数据
    public static int[] exchange(int[] nums) {
        int i= 0 ,j = nums.length-1 ;
//        while (i<j){
//            if(nums[i]%2==0){
//                while (i<j) {
//                    if(nums[j]%2==1){
//                        int tmp = nums[i];
//                        nums[i] = nums[j];
//                        nums[j] = tmp ;
//                        break ;
//                    }
//                    j--;
//                }
//            }
//            i++;
//        }

//        这样更加直观
        while (i<j){
            while (i<j && nums[i]%2==1) i++;
            while (i<j && nums[i]%2==0) j--;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp ;
        }
        return nums;
    }

    public static void main(String[] args) {
        int [] nums ={2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1};
        nums = exchange(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
