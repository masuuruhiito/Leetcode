package com.shijianwei.main.jianzhiOffer.Code05_Find;

/**
 * @author SHI
 * @date 2022/1/20 16:28
 * <p>
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 * <p>
 * <p>
 * 从右上角出发，如果比该数大，那么向下找，如果比该数小，那么向左找
 *
 *
 * 返回条件时，查到了该数据，或者没查到，然后在进行的路上发现没有该点返回false
 */
public class Code04 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;

        while (row<rows&&column>=0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            }else {
                row++;
            }
        }
        return false;
    }


    public static boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j > 0 && i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                return true ;
            } else if (matrix[i][j] > target) {
                j--;
            }else {
                i++;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        int[][] matrix = {{5}};

        System.out.println(findNumberIn2DArray(matrix, 5));
        System.out.println(findNumberIn2DArray(matrix, 20));


    }
}
