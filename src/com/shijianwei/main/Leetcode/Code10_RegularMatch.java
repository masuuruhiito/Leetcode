package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 *
 * @date 2022/4/23 14:41
 */
public class Code10_RegularMatch {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        boolean flag = false;
        int flagIndex = 0;
        int[] roll = new int[s.length()];
        int rollInsert = 0;
        int rollIndex =0;
        while (i < s.length()) {
            if (p.charAt(j) == '.') {
                i++;
                j++;
            } else if (p.charAt(j) == '*') {
//                如果是*的话就可以继续匹配了，但是这次一旦不符合就可以直接换到下一个里面
                flag = true;
                if (j == p.length() - 1) {//最后一个是*的话，一定可以匹配
                    break;
                }
                j++;
            } else {
                if (s.charAt(i) == p.charAt(flagIndex + 1)) {
                    roll[rollInsert++] = i;
                }
                if (!flag && s.charAt(i) != p.charAt(j)) {
                    return false;
                } else if (flag && s.charAt(i) != p.charAt(j)) {
                    if (rollIndex + 1 <= rollInsert) {
                        i = rollIndex++;
                    }else {
                        return false;
                    }
                } else {
                    i++;
                    j++;
                }
            }
        }
        return true;
    }
}
