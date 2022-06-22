package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/3/31 17:17
 */
public class Code74_SearchBinaryMatrices {
    /**
     * 在上比下大，右比左大的矩阵中，搜索target
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false ;
        }
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            }else {
                i++;
            }
        }
        return false;
    }
}
