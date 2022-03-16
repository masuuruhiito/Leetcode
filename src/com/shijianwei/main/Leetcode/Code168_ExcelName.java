package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/3/1 13:30
 */
public class Code168_ExcelName {
    public static String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber > 0) {
            int mod = (columnNumber-1)%26 ;
            res.append((char)('A'+mod));
            columnNumber=(columnNumber-1)/26;
        }
        return res.reverse().toString();
    }

//    8 2-> 0100 4 2

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));//BD
    }
}
