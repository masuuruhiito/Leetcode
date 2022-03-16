package com.shijianwei.main.jianzhiOfferII.Sort;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author SHI
 * @date 2022/2/24 22:05
 */
public class Code007_ThreeNumsSumIsZero {
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums == null ||nums.length<3) return new ArrayList<>();
        Arrays.sort(nums);
        if(nums[0]>0) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0) break;
            if(i>0 && nums[i] == nums[i-1]) continue;
            int target = -nums[i];
            int l = i+1 , r = nums.length-1;
            while (l<r){
                if(l<nums.length && nums[l]+nums[r] == target){
                    List<Integer> res = Arrays.asList(nums[i],nums[l],nums[r]);
                    list.add(res);
                    l++;r--;
                    while (l<r && nums[l] == nums[l-1]) l++;
                    while (l<r && nums[r] == nums[r+1]) r--;
                }else if(l<nums.length && nums[l]+nums[r] > target){
                    r--;
                }else {
                    l++;
                }
            }
        }
        return list ;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, 4});
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
