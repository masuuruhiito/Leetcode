package com.shijianwei.main.learn.algorithm;

import java.util.*;


public class LRU {
    private Map<Integer, Node> map;
    private DoubleLinkedList list ;
    private int cap ;
    public LRU(int capacity) {
         // write code here
        map = new HashMap<>(capacity);
        list = new DoubleLinkedList();
        cap =  capacity;
    }

    public int get(int key) {
         // write code here
        if (map.containsKey(key)) {
            Node node = map.get(key);
            list.delete(node);
            list.addfirst(node);
            return node.value;
        } else {
            return -1;
        }
    
    }

    public void set(int key, int value) {
         // write code here
        Node node = new Node(key,value);
        if(map.containsKey(key)){
            Node cur = map.get(key);
            list.delete(cur);
        }else{
            if(map.size() == cap){
                int cur = list.deletelast();
                map.remove(cur);
            }
        }
        list.addfirst(node);
        map.put(key,node);
    }
    
    
    
    static class DoubleLinkedList{
        Node head , tail ;
        DoubleLinkedList(){
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next=tail ;
            tail.pre = head;
        }
        
        int delete(Node node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
            return node.key;
        }
        
        int deletelast(){
            return delete(tail.pre);
        }
        
        void addfirst(Node node){
            node.next = head.next;
            node.pre = head ; 
            head.next.pre = node ; 
            head.next = node;
        }
            
    }
        
    
    static class Node{
        Node pre , next ; 
        int key;
        int value ;
        Node(){}
        Node(Node pre,Node next ,int key , int value){
            this.next= next;
            this.pre= pre;
            this.value= value;
            this.key= key;
        }
        Node(int key , int value){
            this.value= value;
            this.key= key;
        }
    }
}




/**
 * Your LRU object will be instantiated and called as such:
 * LRU solution = new LRU(capacity);
 * int output = solution.get(key);
 * solution.set(key,value);
 */