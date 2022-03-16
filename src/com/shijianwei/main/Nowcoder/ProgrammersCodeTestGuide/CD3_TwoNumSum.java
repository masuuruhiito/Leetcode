package com.shijianwei.main.Nowcoder.ProgrammersCodeTestGuide;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/3/14 17:08
 */
public class CD3_TwoNumSum {

    public static class Main{
        public static void main(String []args){
            Scanner s = new Scanner(System.in);
            int n = s.nextInt() , k  = s.nextInt();
            int [] arr = new int [n];
            for(int i = 0 ; i < n ; i++){
                arr[i] = s.nextInt();
            }

            int left = 0 , right = arr.length-1;
            while(left< right){
                if(k - arr[left] == arr[right] ){
                    if(left == 0 || arr[left] !=arr[left-1] || right == n-1)
                        System.out.println(arr[left] +" "+arr[right] );
                    left ++ ; right -- ;
                }else if(k - arr[left] > arr[right] ){
                    left++ ;
                }else{
                    right-- ;
                }
            }

        }
    }
}
