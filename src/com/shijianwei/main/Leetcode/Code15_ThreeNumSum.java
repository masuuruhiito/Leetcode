package com.shijianwei.main.Leetcode;

import java.util.*;

/**
 * @author SHI
 * @date 2022/2/22 20:14
 */
public class Code15_ThreeNumSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums== null || nums.length<=2) return res;
        Arrays.sort(nums);
        if(nums[0] >0) return null;
        for (int i = 0; i <nums.length ; i++) {
            int target = -nums[i];
            int l = i+1 , r = nums.length ;
            while (l<r){
                if(nums[l]+nums[r] == target){
                    res.add(Arrays.asList(nums[l++],nums[i--],-target));
                    while (l<r && nums[l] == nums[l-1]) l++;
                    while (l<r && nums[r] == nums[r+1]) r--;
                }else if(nums[l]+nums[r] > target){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return res;
    }

    /**
     * @author SHI
     * @date 2022/1/2 10:57
     *
     *
     *
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     *
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     *
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     *
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     * 示例 2：
     *
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     * 示例 3：
     *
     * 输入：s = "2[abc]3[cd]ef"
     * 输出："abcabccdcdcdef"
     * 示例 4：
     *
     * 输入：s = "abc3[cd]xyz"
     * 输出："abccdcdcdxyz"
     *
     */
    public static class Code394 {
        public static void main(String[] args) {

        }


        public String decodeString(String s) {
    //        2[abc]3[cd]ef
    ////        "3[a2[c]]"
            s.split("\\]");
            for (int i = 0; i <s.length() ; i++) {
                if (s.charAt(i)>='0'&&s.charAt(i)<='9') {

                }
            }

            return new String( );
        }
    }


    public List<List<Integer>> threeSum1(int[] nums) {
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            int l = i+1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[i] + nums[r] == 0) {
                    List<Integer> tmp = new ArrayList<>(Arrays.asList(nums[i], nums[l++], nums[r--]));
                    set.add(tmp);
                    while (l<r && nums[l] == nums[l-1]) l++;
                    while (l<r && nums[r] == nums[r+1]) r--;
                } else if (nums[l] + nums[i] + nums[r] > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
