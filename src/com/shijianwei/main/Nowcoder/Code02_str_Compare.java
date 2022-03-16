package com.shijianwei.main.Nowcoder;

/**
 * @author SHI
 * @date 2022/3/9 11:00
 */
public class Code02_str_Compare {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 比较版本号
     * @param version1 string字符串
     * @param version2 string字符串
     * @return int整型
     */
    public static int compare (String version1, String version2) {
        // Leetcode code here
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int len = str1.length < str2.length ? str1.length : str2.length;
        int i = 0 ;
        for (i = 0; i < len; i++) {
            long value1 = Long.valueOf(str1[i]);
            long value2 = Long.valueOf(str2[i]);
            if (value1 > value2) {
                return 1;
            } else if (value1 < value2) {
                return -1;
            }
        }
        if (i < str1.length) {
            for (int j = i; j < str1.length; j++) {
                if (Long.valueOf(str1[j]) != 0 ) {
                    return 1;
                }
            }
        } else if (i < str2.length) {
            for (int j = i; j < str2.length; j++) {
                if (Long.valueOf(str2[j]) != 0 ) {
                    return -1;
                }
            }
        }
        return 0 ;

    }


    public static void main(String[] args) {
        System.out.println(compare("1.7000000000","1.6000000000"));
    }
}
