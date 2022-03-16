package com.shijianwei.main.Nowcoder.ProgrammersCodeTestGuide;
import java.util.Scanner;
import java.util.HashSet;
/**
 * @author SHI
 * @date 2022/3/14 16:50
 */
public class CD2_MaxArrLength {

    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    public static  class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            int len  =in.nextInt();
            int []nums = new int [len];
            for(int i = 0 ; i < len ; i ++){
                nums[i] = in.nextInt();
            }
            HashSet<Integer> set = new HashSet<>();
            int maxCount = 1 ;
            for(int i = 0; i < len ; i++  ){
                if(maxCount >= len-i+1)  break ;
                int max = nums[i] , min = nums[i] ;
                set.add(nums[i]);
                for(int j = i+1 ; j < len ; j++){
                    if(set.contains(nums[j])) break;
                    set.add(nums[j]);
                    if(nums[j] >max ) max = nums[j] ;
                    if(nums[j] < min) min = nums[j] ;
                    if(max-min == j-i){
                        maxCount  = max-min+1 > maxCount ? max -min +1 :maxCount;
                    }
                }
                set.clear();
            }
            System.out.println(maxCount);
        }
    }
}
