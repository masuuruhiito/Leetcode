package com.shijianwei.main.exam.lechengbao;

import java.util.Scanner;

public class Ex7_9 {
        //i表示行数，j表示列数
     static int[][] x=new int[3][3];
     static int[][] o=new int[3][3];
     static int row;
     static int rank;

        //判断
        public static boolean judge(int[][] m,int i,int j){
            int num0=0;
            int num1=0;
            int num2=0;
            int num3=0;
            for(int l=0;l<3;l++){
                //正对角线
                if(i==j){
                if(m[l][l]==1){
                    num0+=1;
                }}

                //反对角线
                if(i==2-j){
                if(m[l][2-l]==1){
                    num1+=1;
                }}
                //行
                if(m[i][l]==1){
                    num2+=1;
                }
                //列
                if(m[l][j]==1){
                    num3+=1;
                }
            }


            if(num0==3||num1==3||num2==3||num3==3){
                return true;
            }
            else
                return false;
        }


        //输入位置
        static  void position(int[][] xo,int m,char player){
              //记录玩家是o或x
             //判断玩家
            Scanner input=new Scanner(System.in);
            System.out.print("玩家"+player+"输入行数：");
            row=input.nextInt()-1;
            System.out.print("玩家"+player+"输入列数：");
            rank=input.nextInt()-1;
            //判断该坐标上是否有棋子,如果有就重新输入,没有就赋值并输出
            if(row>2||rank>2||row<0||rank<0){
                System.out.println("行数列数必须为1到3之间整数，请重新输入");
                position(xo,m,player);
            }
            else if(x[row][rank]+o[row][rank]>0){
                System.out.println("坐标重复，请重新输入");
                position(xo,m,player);
            }
            else{
                xo[row][rank]=1;
                printMap();         //调用方法打印棋盘
            }           
        }

        //打印棋盘
        public static void printMap(){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(x[i][j]==1)
                        System.out.print(" x |");
                    else if(o[i][j]==1)
                        System.out.print(" o |");
                    else
                        System.out.print("   |");
                }
                System.out.println("");
            }
        }

        public static  void main(String[] args){
            boolean res=false;
            char player;
            //调用方法输入并判断胜利否
            for(int i=1;i<10;i++){
                int m=i%2;              
                //输入数值
                if(m==0){
                    player='x';
                    position(x,m,'x');
                    res=judge(x,row,rank);//判断胜利否
                }
                else{
                    player='o';
                    position(o,m,'o');
                    res=judge(o,row,rank);}//判断胜利否
                if(res){
                    System.out.println("玩家"+player+"获胜");
                    break;

                }
                else if(i==9){
                    System.out.println("平局");
                }
            }   
        }
}
