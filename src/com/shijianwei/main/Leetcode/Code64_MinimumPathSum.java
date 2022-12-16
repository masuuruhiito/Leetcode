package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/9/11 21:28
 */
public class Code64_MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        int row = grid.length - 1, column = grid[0].length - 1;
        for (int i = 1; i <= row; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i <= column; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[row][column];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }
}
