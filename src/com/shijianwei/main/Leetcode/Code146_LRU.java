package com.shijianwei.main.Leetcode;

import java.util.*;

/**
 * @author SHI
 * @date 2022/2/25 8:54
 *
 * 整理思路，这是最关键的
 *      首先增查都是O1
 *      查可以使用map来存储（因为原题为映射关系）
 *      增和删可以用双向链表实现
 *      在链表中，删除需要先进行查找，所以将链表的head端为最近使用，tail端为最少使用
 *      删除时只需要删除tail端，然后再将map修改
 *      增加或修改时，需要将数据放到head端
 *
 */
public class Code146_LRU {


    class LRUCache {
        int cap  ;
        Map<Integer,Node> map ;
        DoubleLinkedList list ;

        public LRUCache(int capacity) {
            cap = capacity;
            map = new HashMap<>();
            list = new DoubleLinkedList();
        }

        public int get(int key) {
            if(!map.containsKey(key)){
                return -1;
            }
            int v = map.get(key).val;
            put(key,v);
            return v;
        }

        public void put(int key, int value) {
            Node node = new Node(key,value);

            if(map.containsKey(key)){
//                  首先获取数据的位置，然后删除，
                list.delete(map.get(key));
                list.addHead(node);
                map.put(key,node);
            }else{
                if(map.size() == cap){//shanchu duiwei
                    int k = list.deleteLast();
                    map.remove(k);
                }
                list.addHead(node);
                map.put(key,node);
            }
        }
    }


    class DoubleLinkedList{
        Node head ;
        Node tail ;

        public DoubleLinkedList() {
            head = new Node(0,0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.pre = head;
        }


        public void addHead(Node node){
            node.next = head.next;
            node.pre = head;

            head.next = node;
            head.next.pre = node ;
        }

        public int deleteLast(){
            if(head.next == tail) return -1 ;
            return delete(tail.pre) ;
        }

        public int delete(Node node){
            int k = node.key;
            node.next.pre = node.pre;
            node.pre.next = node.next;
            return k;
        }
    }

    class Node{
        int key;
        int val;
        Node pre ;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }


    public static void main(String[] args) {

    }

}


