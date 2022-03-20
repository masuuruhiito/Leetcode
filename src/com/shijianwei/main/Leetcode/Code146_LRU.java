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


    static class LRUCache {
        Map<Integer, Node> map;
        DoubleLinkedList list;
        int cap;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            list = new DoubleLinkedList();
            cap = capacity;
        }

//        putget维护list，为了在删除最久未使用的keyvalue
        public int get(int key) {

            if (map.containsKey(key)) {
                Node node = map.get(key);
                list.delete(node);
                list.addFirst(node);
                return node.val;
            }
            return -1;
        }


        //
        public void put(int key, int value) {
            Node node = new Node(key, value);

            if (map.containsKey(key)) {

                list.delete(map.get(key));
                list.addFirst(node);
                map.put(key, node);

            } else {
                if (map.size() >= cap) {//buneng zia fangf l ,shanchu zuihou yige shu
                    int i = list.deleteLast();
                    map.remove(i);
                }
                list.addFirst(node);
                map.put(key, node);
            }
        }


        static class Node {
            int key, val;
            Node pre, next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        static class DoubleLinkedList {
            private Node head;
            private Node tail;

            public DoubleLinkedList() {
                head = new Node(-1, -1);
                tail = new Node(-1, -1);
                head.next = tail;
                tail.pre = head;
            }

            public void addFirst(Node node) {
//                先将nodeprenext赋值，然后要先赋head.next.pre ,
//                因为如果先给head。next赋值，这样下次再找head.next.pre 等价于nodepre
                // 赋值操作变为了node.pre=node ,导致出现错误

                node.next = head.next;
                node.pre = head;
                head.next.pre = node;
                head.next = node;
            }

            public int delete(Node node) {
                node.pre.next = node.next;
                node.next.pre = node.pre;
                return node.key;
            }

            public int deleteLast() {
                if (head.next != tail) {
                    return delete(tail.pre);
                }
                return -1 ;
            }
        }
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }

}


