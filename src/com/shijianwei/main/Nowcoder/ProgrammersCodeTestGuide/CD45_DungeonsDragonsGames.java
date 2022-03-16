package com.shijianwei.main.Nowcoder.ProgrammersCodeTestGuide;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/3/14 13:04
 * 复制粘贴记得删除Main上的static关键字
 */
public class CD45_DungeonsDragonsGames {

    public static class Main {
        public static void main(String[] args) {
            // 获取输入
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();
            int m = input.nextInt();

            int[][] matrix = new int[n][m];

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j<m; ++j){
                    matrix[i][j] = input.nextInt();
                }
            }

            int [][]hpMatrix = new int[n][m];
//         chushihua zuihou yige jiedian
            if(matrix[n-1][m-1] < 0 ){
                hpMatrix[n-1][m-1] =1 - matrix[n-1][m-1];
            }else{
                hpMatrix[n-1][m-1] = 1 ;
            }


//        chushihua zuihou yihang
            for(int i = m-2 ; i >= 0 ; i--){
                hpMatrix[n-1][i] = hpMatrix[n-1][i+1] - matrix[n-1][i] > 0 ?
                        hpMatrix[n-1][i+1] - matrix[n-1][i] : 1 ;
            }

            for(int i = n-2 ; i >= 0 ; i--){
                hpMatrix[i][m-1] = hpMatrix[i+1][m-1] - matrix[i][m-1] > 0 ?
                        hpMatrix[i+1][m-1] - matrix[i][m-1] : 1 ;
            }

//         jaing qita shujubuquan
            for(int i = n-2 ; i >= 0 ; i--){
                for(int j = m-2 ; j >=0 ; j--){
                    int toleft = hpMatrix[i+1][j] - matrix[i][j] > 0 ?
                            hpMatrix[i+1][j] - matrix[i][j] : 1 ;
                    int todown = hpMatrix[i][j+1] - matrix[i][j] > 0 ?
                            hpMatrix[i][j+1] - matrix[i][j] : 1 ;
                    hpMatrix[i][j] = Math.min(toleft , todown);
                }
            }

            System.out.println(hpMatrix[0][0]) ;
        }
    }
}
