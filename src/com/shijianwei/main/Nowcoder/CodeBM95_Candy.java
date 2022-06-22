package com.shijianwei.main.Nowcoder;

import java.util.Arrays;

/**
 * @author SHI
 * @date 2022/4/23 12:32
 * 贪心
 */
public class CodeBM95_Candy {
    public int candy (int[] arr) {
        // write code here
        int []nums = new int[arr.length];
        Arrays.fill(nums,1);
        for(int i =1 ; i < nums.length ; i++){
            if(arr[i]>arr[i-1]){
                nums[i] = nums[i-1]+1;
            }
        }
        for(int i =nums.length-2 ; i >=0 ; i--){
            if(arr[i] > arr[i+1] && nums[i] <= nums[i+1]){
                nums[i] = nums[i+1]+1;
            }
        }
        return Arrays.stream(nums).sum();
    }
}
