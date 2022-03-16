package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/2/28 13:04
 */
public class Code7_ReverseNum {

    public static int reverse1(int x) {
        boolean flag = false ;
        if (x<0){
            x = -x ;
            flag = true ;
        }
        int res = 0 ;
        while (x != 0) {
            int tmp = x%10;
            x /= 10;
            
        }
        return 1;
    }


//    使用字符串解决
    public static int reverse(int x) {
        String s = String.valueOf(x);
        StringBuilder res = new StringBuilder();
        if(s.charAt(0) == '-'){
            res.append('-');
            for (int i = 0; i < s.length()-1; i++) {
                res.append(s.charAt(s.length()-i-1));
            }
        }else {
            for (int i = 0; i < s.length(); i++) {
                res.append(s.charAt(s.length() - i -1));
            }
        }


        return Long.valueOf(res.toString())<Integer.MAX_VALUE
                && Long.valueOf(res.toString())>Integer.MIN_VALUE
                ?Integer.valueOf(res.toString()):0;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1234567899));
        System.out.println(reverse(-1234));
    }

    /**
     * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：c = 5
     * 输出：true
     * 解释：1 * 1 + 2 * 2 = 5
     * 示例 2：
     *
     * 输入：c = 3
     * 输出：false
     * 示例 3：
     *
     * 输入：c = 4
     * 输出：true
     * 示例 4：
     *
     * 输入：c = 2
     * 输出：true
     * 示例 5：
     *
     * 输入：c = 1
     * 输出：true
     */
    public static class Code633 {
        public static void main(String[] args) {
            Solution s = new Solution();
            System.out.println(s.judgeSquareSum(5));
            System.out.println(s.judgeSquareSum(2));
            System.out.println(s.judgeSquareSum(8));
            System.out.println(s.judgeSquareSum(9));
            System.out.println(s.judgeSquareSum(2147483600));
        }

        static class Solution {
            public boolean judgeSquareSum(int c) {
                long i = (int )Math.sqrt(c);
                long  j  = 0 ;
                while(j<=i){
                    if(i*i + j*j == c){
                        return true;
                    }else if(i*i + j*j < c){
                        j++;
                    }else if(i*i + j*j > c){
                        i--;
                    }
                }
                return false ;
            }
        }

    }

    /**
     * @author SHI
     * @date 2022/1/29 18:40
     *
     * 可用求和相减方法，等差数列求和公式 ：n(a[1]+a[n])/2 ;
     *
     * 使用异或方法的时候，可以对所有数据进行异或，然后对数组下标进行异或，这样省了空间复杂度
     */
    public static class Code268 {
        public int missingNumber(int[] nums) {
            int []newNums = new int[nums.length+nums.length+1];
            for (int i = 0; i < nums.length; i++) {
                newNums[i] = nums[i];
            }
            for (int i = nums.length; i <newNums.length ; i++) {
                newNums[i] = i-nums.length;
            }
            int res = nums.length ;
            for (int i = 0; i < newNums.length-1; i++) {
                res^=newNums[i];
            }
            return res ;
        }


        public int missingNumber1(int[] nums) {
            int suma = 1 ;
            for (int i = 0; i < nums.length; i++) {
                suma^=nums[i];
            }
            int sumb = 0 ;
            for (int i = 1; i <nums.length+1 ; i++) {
                sumb^=i ;
            }
            return suma^sumb;
        }
    }

    /**
     * 给定一个已按照 非递减顺序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
     *
     * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
     *
     * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
     *
     *  
     * 示例 1：
     *
     * 输入：numbers = [2,7,11,15], target = 9
     * 输出：[1,2]
     * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     * 示例 2：
     *
     * 输入：numbers = [2,3,4], target = 6
     * 输出：[1,3]
     * 示例 3：
     *
     * 输入：numbers = [-1,0], target = -1
     * 输出：[1,2]
     *  
     *
     * 提示：
     *
     * 2 <= numbers.length <= 3 * 104
     * -1000 <= numbers[i] <= 1000
     * numbers 按 非递减顺序 排列
     * -1000 <= target <= 1000
     * 仅存在一个有效答案
     */
    public static class Code167 {
        public static void main(String[] args) {
            Solution s= new Solution();
            int []ans = {-1,0};
            System.out.println(s.twoSum(ans,-1)[0]+"  "+s.twoSum(ans,-1)[1]);
        }


        static class Solution {
            public int[] twoSum(int[] numbers, int target) {
                int i = 1 , j = numbers.length ;
                while(i<j){
                    if(numbers[i-1]+numbers[j-1]==target){
                        break;
                    }else if(numbers[i-1]+numbers[j-1]>target){
                        j--;
                    }else{
                        i++;
                    }
                }
                int []ans ={i,j};
                return ans;
            }
        }
    }

    /**
     * @author SHI
     * @date 2022/1/18 19:17
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     */
    public static class Code20 {

    //    public static List<Character> hashMap = new ArrayList<Character>(){
    //        {
    //            add()
    //        }
    //    };
    //
    //    public static Map hashMap1 = new HashMap(){
    //        {
    //            push();
    //        }
    //    };
        public boolean isValid(String s) {
            return false;
        }
        public static void main(String[] args) {

        }
    }
}
