package com.shijianwei.main;

/**
 * 想实现LRU，put和get都是o1
 *   可以使用多种数据结构叠加的方式
 *   各取优点
 *       puto1可以使用hashmap来实现，但是此时getLRU不是o1
 *       getlRUo1可以使用双向链表实现，记录每次的最近查询
 */

class Test {


    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
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
}
