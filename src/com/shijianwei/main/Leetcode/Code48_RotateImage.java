package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/3/29 18:50
 */
public class Code48_RotateImage {

    /**
     * 旋转矩阵,这我就不太会了
     *      思路: 00 02
     *
     * 看题解，思路真滴牛，翻折两次，然后就能得到旋转的了
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
//        首先先沿着右上，左下翻折
        int nums = matrix.length;
        for (int i = 0; i < nums; ++i){
            for (int j = 0; j < nums - i; ++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[nums - 1 - j][nums - 1 - i];
                matrix[nums - 1 - j][nums - 1 - i] = temp;
            }
        }

//        再上下翻折
        for (int i = 0; i < (nums >> 1); ++i){
            for (int j = 0; j < nums; ++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[nums - 1 - i][j];
                matrix[nums - 1 - i][j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        rotate(arr);
    }
}
