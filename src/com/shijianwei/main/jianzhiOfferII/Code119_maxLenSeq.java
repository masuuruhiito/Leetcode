package com.shijianwei.main.jianzhiOfferII;

import java.util.Arrays;

/**
 * @author SHI
 * @date 2022/2/24 14:06
 */
public class Code119_maxLenSeq {
    public static int longestConsecutive(int[] nums) {
        if(nums.length<= 1)  return nums.length;
        Arrays.sort(nums);
        int count = 1 ;
        int max = 1;
        for(int i = 1 ; i < nums.length ;i++){
            if(nums[i]-nums[i-1]==1){
                count++;
            }else if(nums[i] == nums[i-1]){
                continue;
            }else{
                count =1 ;
            }
            max = Math.max(count,max);
        }
        return max ;
    }


    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1,2,0,1}));
    }
}
