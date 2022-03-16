package com.shijianwei.main.jianzhiOffer.Code14_SearchandRecall;

/**
 * @author SHI
 * @date 2022/2/8 12:44
 * 剑指 Offer 12. 矩阵中的路径
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *
 *
 * dfs 深度优先搜索，不需要遍历全部的通路
 */
public class Code12 {
    public boolean exist(char[][] board, String word) {
        int column = 0 , row = 0 ;
        for(row = 0 ; row < board.length ;row ++){
            for(column = 0 ; column <board[0].length ;column++){
                if(dfs(board,word.toCharArray(),row , column,0 )){
                    return true ;
                }
            }
        }
        return false ;
    }

    // 通过递归返回值来进行判断，是否存在一条通路与words完全相同
    public static boolean dfs(char[][] board,char[] words,int row , int column ,int c){
//        先写鲁棒
        if(row<0||column<0||row>board.length-1||column>board[0].length-1||c<0||c>words.length-1||board[row][column]!=words[c]) return false;
        if(c == words.length-1) return true;
        char tmp = board[row][column];
        board[row][column]='\0';
        boolean res =dfs(board,words,row-1,column,c+1)||dfs(board,words,row,column-1,c+1)||
                dfs(board,words,row+1,column,c+1)||dfs(board,words,row,column+1,c+1);
        board[row][column] = tmp ;//neng dao zhebu de daibiao yijing panduan wan l gai dian de sizhou youmeiyou true
        return res ;
    }
}
