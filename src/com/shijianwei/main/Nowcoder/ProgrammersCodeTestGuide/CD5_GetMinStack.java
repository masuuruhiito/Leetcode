package com.shijianwei.main.Nowcoder.ProgrammersCodeTestGuide;
import java.util.*;

/**
 * @author SHI
 * @date 2022/3/15 15:34
 */
public class CD5_GetMinStack {

    public static class Main{
        public static void main(String []args){
            Scanner sc = new Scanner(System.in);
            MinStack stack = new MinStack();
            int n = sc.nextInt();
            String []op = new String[n];
            int []nums = new int [n];
            for(int i = 0 ; i < n ; i++){
                String tmp = sc.next();
                if("getMin".equals(tmp) ){
                    System.out.println(stack.getMin());
                }else if("pop".equals(tmp)){
                    stack.pop();
                }else if("push".equals(tmp)){
                    int val = sc.nextInt();
                    stack.push(val);
                }
            }
        }

        static class MinStack{
            Node node;
            Integer pop(){
                if(isEmpty()){
                    return null;
                }else{
                    int res = node.val ;
                    node = node.next ;
                    return res ;
                }
            }
            void push(int val){
                Node tmp  = new Node();
                tmp.val = val ;
                if(isEmpty()){
                    node = tmp ;
                    tmp.minVal = val ;
                }else{
                    tmp.next = node;
                    tmp.minVal = Math.min(tmp.val,node.minVal);
                    node = tmp ;
                }
            }

            Integer getMin(){
                return isEmpty()?null:node.minVal;
            }


            boolean isEmpty(){
                return node==null ;
            }
        }

        static class Node{
            int val ;
            int minVal ;
            Node next ;
            Node(){}
            Node(int val ){
                this.val = val ;
            }
        }
    }
}
