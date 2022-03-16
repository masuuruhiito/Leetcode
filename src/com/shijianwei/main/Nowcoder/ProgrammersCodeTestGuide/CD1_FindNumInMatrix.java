package com.shijianwei.main.Nowcoder.ProgrammersCodeTestGuide;

/**
 * @author SHI
 * @date 2022/3/14 13:10
 */
public class CD1_FindNumInMatrix {
    public static String func(int[][]nums , int k){
        int i = 0 , j = nums[0].length-1 ;
        while(i>=0 && i < nums.length && j >=0 && j <nums[0].length){
            if(nums[i][j] == k ){
                return "Yes" ;
            }
            else if(nums[i][j] < k ){
                i++ ;
            }else {
                j -- ;
            }
        }
        return "No";
    }
}
