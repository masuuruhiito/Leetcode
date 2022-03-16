package com.shijianwei.main.Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 输入: s = ""
 * 输出: 0
 */

class Code03_TheRepeatedString {
////    思想：将每一个字符存在大小为128（ascmII值为数组下标）的数组中
////      判断字符是否重复重复往前走
//    public int lengthOfLongestSubstring(String s) {
//
//    }
    public static void main(String[] args) {
        System.out.println(new Code03_TheRepeatedString().lengthOfLongestSubstring("pwwke"));
    }

//     思想：滑动窗口
//    在进行遍历时，
    public int lengthOfLongestSubstring(String s) {
        int ans = 0 ,i = 0 ,j = 0 ;
        Set<Character> set = new HashSet<>();
        while (i<s.length()&&j<s.length()){
            if(!set.contains(s.charAt(j))){
                //如果不存在这个字符的时候，将其添加到set中,并且将ans更新
                set.add(s.charAt(j++));
                ans= Math.max(ans,j-i);
            }else{
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }


//     思想：使用数组进行优化

    public int four(String s) {
        int ans = 0 ;
        int[] index  = new int[128];//存储下标
        for (int i = 0; i <s.length() ; i++) {
            index[s.charAt(i)] = i ;

        }
        return ans;
    }

//     思想：滑动窗口优化
//    ，我们将 set 改为 map ，将字符存为 key ，将对应的下标存到 value ⾥就实现了
    public int three(String s) {
        int ans = 0 ,j = 0 ;
        Map<Character, Integer> map = new HashMap<>();

        while (j<s.length()){
            if(!map.containsKey(s.charAt(j))){
                //如果不存在这个字符的时候，将其添加到set中,并且将ans更新
                map.put(s.charAt(j++),j);
                ans= Math.max(ans,j);
            }else{
                map.remove(s.charAt(j));
            }
        }
        return ans;
    }


    //暴力遍历每一个子串，判断是否每一个都不相同  超时了
    public int solution(String s) {
        int ans = 0 ;
        if(s.length()==0){
            return 0 ;
        }
        for (int i = 0; i <s.length()-1 ; i++) {
            for (int j = i+1; j <s.length() ; j++) {

                if (Code03_TheRepeatedString.allIsUnique(s,i,j)) {
                    ans =Math.max(ans, j-i+1);
                }
            }
        }
        return ans ;
    }
    public static boolean allIsUnique(String s ,int start ,int end ){
        Set<Character> set = new HashSet<>();

        for (int i = start; i<=end ; i++) {

            if(set.contains(s.charAt(i))){
                return false ;
            }else{
                set.add(s.charAt(i));
            }
        }
        return true ;
    }
}
/**
 * 128
 * abcabcbb
 * a b c a b c b b
 *   1 2 3 3 3 2 1  max = 3
 *
 * pwwkew
 * p w w k e w
 * 1 2 1 2 3 3    max = 3
 *
 *
 * 1 1 3 4 3
 *
 *
 *
 * abcabcbb
 *
 * abcabcbb
 * 判断这个子串是否有重复，没有的话
 *
 *
 * 两个变量遍历
 * 前后指针，如果有就removei++
 * meiyou de
 */