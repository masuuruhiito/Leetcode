package com.shijianwei.main.Leetcode.additional.tree;

/**
 * @author SHI
 * @date 2022/2/17 15:51
 */
public class Code02 {
    public static void main(String [] args){

        int [] nums = {71,44,21,76,24,1,3,6};
        BubleSort(nums);
        for(int num:nums){
            System.out.print( num + "\t");
        }
    }

    public static void BubleSort(int []a){
        for(int i = 0 ; i<a.length ;i++){
            for(int j =  0; j <a.length - i-1 ; j++ ){
                if(a[j] >a [j+1]){
                    int tmp = a[j] ;
                    a[j] = a[j+1] ;
                    a[j+1] = tmp ;
                }
            }
        }
    }
}
