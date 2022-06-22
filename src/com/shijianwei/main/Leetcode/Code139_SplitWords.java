package com.shijianwei.main.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * @author SHI
 * @date 2022/4/10 21:18
 */
public class Code139_SplitWords {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true ;
        for(int i = 0 ; i < s.length();i++){
            if(dp[i]){
                for(String sub : set){
                    if(i+sub.length() <= s.length() && s.substring(i,i+sub.length()).equals(sub) ){
                        dp[i + sub.length()] = true;
                    }
                }
            }

            int[][] ints = new ArrayList<Integer>().toArray(new int[][]{new int[]{}});


        }
        return dp[dp.length-1];
    }
}
